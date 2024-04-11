package com.pojo.connectx.util.template.gen;

/**
 * 
 */
public class TemplateProcessingException extends Exception {

	private static final long serialVersionUID = "com.pojo.connectx.util.template.gen.TemplateProcessingException"
			.hashCode();

	public TemplateProcessingException(String error) {
		super(error);
	}

	public TemplateProcessingException(String error, Throwable cause) {
		super(error, cause);
	}

	public TemplateProcessingException(Throwable cause) {
		super(cause);
	}

}
