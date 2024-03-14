package com.pojo.connectx.similarity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimilarityInputPojo {
	private String flattenName;
	private String parentClassName;
}
