package br.com.inpaas.htmlwizard.ui;

/**
 * Response Model for AWS Lambda
 * 
 * @author Dio
 */
public class Response {

	private final boolean success;
	private final String message;
	
	public Response(String message) {
		this.message = message;
		this.success = true;
	}
	
	public Response(String message, boolean success) {
		this.message = message;
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
}