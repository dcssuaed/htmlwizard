package br.com.inpaas.htmlwizard.converter;

import java.io.InputStream;
import java.io.OutputStream;

import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

/**
 * PDF Converter
 * 
 * @author Dio
 */
public class PDFConverter implements Converter {
	
	PDFConverter() { }

	public void convert(InputStream is, OutputStream os) throws ConversionException {
		try {
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocument(new Tidy().parseDOM(is, null), null);
			renderer.layout();
			renderer.createPDF(os);
			
		} catch(DocumentException e) {
			throw new ConversionException(e);
			
		}
	}

}
