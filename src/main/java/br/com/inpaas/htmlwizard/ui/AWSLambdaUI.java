package br.com.inpaas.htmlwizard.ui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import br.com.inpaas.htmlwizard.converter.Converter;
import br.com.inpaas.htmlwizard.converter.ConverterFactory;

/**
 * AWS Lambda UI
 * Handler: br.com.inpaas.htmlwizard.ui.AWSLambdaUI::handleRequest
 * 
 * @author Dio
 */
public class AWSLambdaUI implements RequestHandler<Request, Response> {
	
	public Response handleRequest(Request request, Context context) {
		if(context != null) {
			LambdaLogger logger = context.getLogger();
	
			logger.log(String.format("requestId:%s, function:%s, groupName:%s, logStreamName:%s", context.getAwsRequestId(),
					context.getFunctionName(), context.getLogGroupName(), context.getLogStreamName()));
		}
		
		ByteArrayInputStream is = null;
		ByteArrayOutputStream os = null;
		try {
			is = new ByteArrayInputStream(request.getSource().getBytes());
			os = new ByteArrayOutputStream();
			
			Converter converter = ConverterFactory.getByTargetType(request.getTarget());
			converter.convert(is, os);
			
			return new Response(Base64.encodeBase64String(os.toByteArray()));
			
		} catch(Exception e) {
			return new Response(e.getMessage(), false);
			
		} finally {
			IOUtils.closeQuietly(os, is);
			
		}
	}
}
