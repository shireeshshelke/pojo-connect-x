package com.pojo.connectx.similarity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimilarityOutputPojo {
	private String sourceClassNm;
	private String targetClassNm;
	private String sourceFlattenKey;
	private String targetFlattenKey;
	private int similarityScore;
}
