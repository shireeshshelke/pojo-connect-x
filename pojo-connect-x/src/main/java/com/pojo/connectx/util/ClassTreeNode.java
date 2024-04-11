package com.pojo.connectx.util;

import java.util.List;

import com.pojo.connectx.config.PojoConnectConstants;

import lombok.Data;

@Data
public class ClassTreeNode {
	private String classPath;
	private String complexType;
	private String simpleName;

	private String variableName;
	private String flattenName;

	private String getter;
	private String setter;

	private boolean primitive;
	private boolean isUsrDefinedClasspath;

	private boolean collection;
	private ClassTreeNode parentIfCollection;

	private List<ClassTreeNode> children;

	private String parentVarName;
	private boolean instantiated;

	public ClassTreeNode(String classPath, String variableName, String getter, String setter, boolean isCollection,
			String complexType, String flattenName, String parentVarName) {
		this.classPath = classPath;
		this.variableName = variableName;
		this.getter = getter;
		this.setter = setter;
		this.collection = isCollection;
		this.complexType = complexType;
		this.flattenName = flattenName;
		this.parentVarName = parentVarName;

		this.primitive = DTProcessor.isPrimitive(classPath);
		this.isUsrDefinedClasspath = DTProcessor.isUsrDefined(this.collection ? complexType : classPath);

		if (this.classPath != null) {
			String arr[] = this.classPath.split(PojoConnectConstants.DOT_SEP);
			if (arr.length >= 1) {
				this.simpleName = arr[arr.length - 1];
			}
		}

	}

}
