package com.pojo.connectx.mapper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.pojo.connectx.similarity.SimilarityInputPojo;
import com.pojo.connectx.util.ClassTreeNode;

import lombok.Data;

@Data
public class ClassTreeAndNodes {
	private Map<String, Map<String, ClassTreeNode>> classes;
	private LinkedList<SimilarityInputPojo> allNodes;

	public ClassTreeAndNodes() {
		this.classes = new HashMap<>();
		this.allNodes = new LinkedList<>();
	}
}
