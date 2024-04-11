package com.pojo.connectx.util.template.gen;

import java.util.Map;

public interface ITemplateEngine {
	public static final String TEMPLATE_PATH = "src/main/resources/templates/";

	String processTemplate(Map<String, Object> data, String templateName) throws TemplateProcessingException;
}
