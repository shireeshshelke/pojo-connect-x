package com.pojo.connectx.util.template.gen;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerTemplateEngine implements ITemplateEngine {

	private Configuration cfg;

	private Configuration getConfiguration() throws IOException {
		if (cfg == null) {
			cfg = new Configuration(Configuration.VERSION_2_3_32);
			cfg.setDirectoryForTemplateLoading(new File(ITemplateEngine.TEMPLATE_PATH));
		}
		return cfg;
	}

	@Override
	public String processTemplate(Map<String, Object> data, String templateName) throws TemplateProcessingException {
		String res = null;
		Template template;
		try {
			template = getConfiguration().getTemplate(templateName);
			StringWriter sw = new StringWriter();
			template.process(data, sw);
			res = sw.toString();
		} catch (IOException | TemplateException e) {
			throw new TemplateProcessingException(e);
		}
		return res;
	}

}
