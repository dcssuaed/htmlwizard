package br.com.inpaas.htmlwizard.converter;

/**
 * Factory for converters
 * 
 * @author Dio
 */
public class ConverterFactory {

	public static Converter getByTargetType(String type) {
		if(type == null) return null;
		
		switch(type.toLowerCase()) {
			case "pdf": return new PDFConverter();
			
			case "docx": return new DOCXConverter();
			
			default: return new PDFConverter();
		}
	}
	
}
