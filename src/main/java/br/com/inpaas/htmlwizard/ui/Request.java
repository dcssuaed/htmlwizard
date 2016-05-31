package br.com.inpaas.htmlwizard.ui;

/**
 * Request Model for AWS Lambda
 * 
 * @author Dio
 */
public class Request {
	
	private String target;
	private String source;
	
	public Request() {
		this.target = "pdf";
	}
	
	public Request(String source) {
		this.source = source;
	}
	
	public String getTarget() {
		return target;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setTarget(String target) {
		this.target = target;
	}
	
	public void setSource(String source) {
		this.source = source;
	}

}
