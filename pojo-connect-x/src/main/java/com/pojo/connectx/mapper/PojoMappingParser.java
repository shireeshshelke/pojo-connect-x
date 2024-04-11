package com.pojo.connectx.mapper;

import java.util.List;
import java.util.Map;

import com.pojo.connectx.similarity.ISimilarityMapper;
import com.pojo.connectx.similarity.SimilarityMapper;
import com.pojo.connectx.similarity.SimilarityOutputPojo;
import com.pojo.connectx.util.template.gen.FreeMarkerTemplateEngine;
import com.pojo.connectx.util.template.gen.ITemplateEngine;

public abstract class PojoMappingParser<T> {
	ObjectToTreeConverter<T> converter;
	ISimilarityMapper mapper;
	ITemplateEngine templateEngine;
	
	public PojoMappingParser() {
		this.converter = null;
		this.mapper = new SimilarityMapper();
		this.templateEngine = new FreeMarkerTemplateEngine();
	}
	
	protected abstract ObjectToTreeConverter<T> getConverter();
	protected abstract ISimilarityMapper getMapper();
	protected abstract ITemplateEngine getTemplateEngine();

	public boolean doMapping(List<T> sourceClasses, T targetClasses) {
		boolean res = false;
		
		ClassTreeAndNodes sourceClassAndNodes = converter.getClassesAndNodes(sourceClasses);
		ClassTreeAndNodes targetClassAndNodes = converter.getClassesAndNodes(List.of(targetClasses));
		
		if (sourceClassAndNodes != null && targetClassAndNodes != null) {
			Map<String, SimilarityOutputPojo> mapping = mapper.mapStrings(sourceClassAndNodes.getAllNodes(), targetClassAndNodes.getAllNodes());
		}
		return res;
	}
} 
