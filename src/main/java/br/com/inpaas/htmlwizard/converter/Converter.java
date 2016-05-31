package br.com.inpaas.htmlwizard.converter;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Interface for converters
 * @author Dio
 *
 */
public interface Converter {

	/**
	 * Converts the information from an InputStream and writes it to an OutputStream
	 * @param is - The InputStream
	 * @param os - The OutputStream
	 * @throws ConversionException
	 */
	void convert(InputStream is, OutputStream os) throws ConversionException;
	
}
