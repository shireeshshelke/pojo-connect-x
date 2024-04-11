package com.pojo.connectx.mapper;

import java.util.List;

public abstract class ObjectToTreeConverter<T> {

	public abstract ClassTreeAndNodes getClassesAndNodes(List<T> allClasspaths, Object... args);

}
