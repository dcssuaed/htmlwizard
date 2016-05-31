package br.com.inpaas.htmlwizard;

import br.com.inpaas.htmlwizard.converter.ConverterFactory;
import br.com.inpaas.htmlwizard.converter.PDFConverter;
import junit.framework.TestCase;

public class TestConverterFactory extends TestCase {

	public void testDefinedPDFType() {
		assertEquals(PDFConverter.class, ConverterFactory.getByTargetType("pdf").getClass());
	}
	
	public void testDefinedPDFTypeWithIrregularCase() {
		assertEquals(PDFConverter.class, ConverterFactory.getByTargetType("PdF").getClass());
	}
	
	public void testDefaultConverterForNonExistentType() {
		assertNotNull(ConverterFactory.getByTargetType("I dont even exist"));
	}
	
	public void testNullType() {
		assertNull(ConverterFactory.getByTargetType(null));
	}
	
}
