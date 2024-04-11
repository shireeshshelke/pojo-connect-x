package com.pojo.connectx.util;

import java.awt.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DTProcessor {

	private static Pattern multilinePattern = null;

	private static Pattern getJavaPackagePattern() {
		if (multilinePattern == null) {
			multilinePattern = Pattern.compile("java\\..*|javax\\..*");
		}
		return multilinePattern;
	}

	public static boolean isPrimitive(String classpath) {
		return primitiveDTSet.contains(classpath);
	}

	public static boolean isUsrDefined(String classpath) {
		Matcher matcher = getJavaPackagePattern().matcher(classpath);
		return !matcher.matches();
	}

	public static boolean isCollection(String classpath) {
		return collectionSet.contains(classpath);
	}

	private static Set<String> primitiveDTSet = new HashSet<>(Arrays.asList(
			String.class.getName(),
			Integer.class.getName(),
			Double.class.getName(),
			Long.class.getName(),
			Float.class.getName(),
			Short.class.getName(),
			Byte.class.getName(),
			Character.class.getName(),
			Boolean.class.getName(),
			BigDecimal.class.getName(), // Considered this as primitive w.r.t. POJO
			
			int.class.getName(),
			double.class.getName(),
			long.class.getName(),
			float.class.getName(),
			short.class.getName(),
			byte.class.getName(),
			char.class.getName(),
			boolean.class.getName()
			
			));
	private static Set<String> collectionSet = new HashSet<>(Arrays.asList(
			List.class.getName(),
			ArrayList.class.getName(),
			LinkedList.class.getName(),
			Set.class.getName(),
			HashSet.class.getName()
			));
}
