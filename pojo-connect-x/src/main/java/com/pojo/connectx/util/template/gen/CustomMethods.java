package com.pojo.connectx.util.template.gen;

import java.util.List;

import com.pojo.connectx.util.DTProcessor;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import lombok.Data;

@Data
public class CustomMethods {
	public TemplateMethodModelEx getLastFromDotSep = new TemplateMethodModelEx() {

		@Override
		public Object exec(List arguments) throws TemplateModelException {
			if (arguments.size() != 1 && String.valueOf(arguments.get(0)).isBlank()) {
				throw new TemplateModelException("Wrong Arguments");
			}
			String argument = String.valueOf(arguments.get(0));
			String input = argument;
			if (argument.contains("$")) { // This is required for nested classes, eg. com.Person$Details
				input = argument.replaceAll("\\$", "\\.");
			}
			String argumentArr[] = input.split("\\.");
			return argumentArr[argumentArr.length - 1];
		}
	};

	public TemplateMethodModelEx isPrimitive = new TemplateMethodModelEx() {

		@Override
		public Object exec(List arguments) throws TemplateModelException {
			if (arguments.size() != 1 && String.valueOf(arguments.get(0)).isBlank()) {
				throw new TemplateModelException("Wrong Arguments");
			}
			String argument = arguments.get(0).toString();
			return DTProcessor.isPrimitive(argument);
		}
	};
}
