package br.com.inpaas.htmlwizard.converter;

public class ConversionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConversionException() {
		// TODO Auto-generated constructor stub
	}
	
	public ConversionException(Throwable e) {
		super(e);
	}
	
	public ConversionException(String msg, Throwable e) {
		super(msg, e);
	}
	
	
}