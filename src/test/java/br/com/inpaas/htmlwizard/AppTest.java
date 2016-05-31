package br.com.inpaas.htmlwizard;

import java.io.File;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import br.com.inpaas.htmlwizard.ui.AWSLambdaUI;
import br.com.inpaas.htmlwizard.ui.Request;
import br.com.inpaas.htmlwizard.ui.Response;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	public static void main(String[] args) throws Exception {
		Response response = new AWSLambdaUI().handleRequest(new Request("PGh0bWw+DQogICA8Ym9keT4NCiAgICAgIDxoMT5IZWxsbyBXb3JsZDwvaDE+DQogICA8L2JvZHk+DQo8L2h0bWw+"), null);
		
		byte[] decoded = Base64.decodeBase64(response.getMessage());
		FileUtils.writeByteArrayToFile(new File("/tmp/html2pdf/generated.pdf"), decoded);
	}
}
