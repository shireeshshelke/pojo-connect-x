package com.pojo.connectx.similarity;

import java.util.LinkedList;
import java.util.Map;

public interface ISimilarityMapper {

	public Map<String, SimilarityOutputPojo> mapStrings(LinkedList<SimilarityInputPojo> source,
			LinkedList<SimilarityInputPojo> target);

	public Map<String, SimilarityOutputPojo> mapStrings(LinkedList<SimilarityInputPojo> source,
			LinkedList<SimilarityInputPojo> target, SimilarityAlgo algo);

}
