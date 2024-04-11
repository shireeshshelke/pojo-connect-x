package com.pojo.connectx.similarity;

import org.apache.commons.text.similarity.JaccardSimilarity;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.apache.commons.text.similarity.LongestCommonSubsequence;

public class SimilarityChecker {
	public static enum SIMILARITY_ALGO implements SimilarityAlgo {
		Jaccard("Jaccard"),
		JaroWinkler("JaroWinkler"),
		LongestCommonSubsequence("LongestCommonSubsequence"),
		Levenshtein("Levenshtein");

		SIMILARITY_ALGO(String name) {
			this.name = name;
		}

		String name;

		@Override
		public String getName() {
			return name;
		}
	};

	JaccardSimilarity jaccardSimilarity = null;
	JaroWinklerSimilarity jaroWinklerSimilarity = null;
	LongestCommonSubsequence longestCommonSubsequence = null;

	public int computeSimilarity(String string1, String string2, SIMILARITY_ALGO algo) {
		int res = Integer.MIN_VALUE;
		
		switch (algo) {
		case Jaccard:
			if (jaccardSimilarity == null) {
				jaccardSimilarity = new JaccardSimilarity();
			}
			res = (int) (jaccardSimilarity.apply(string1, string2) * 1000);
			break;
		case JaroWinkler:
			if (jaroWinklerSimilarity == null) {
				jaroWinklerSimilarity = new JaroWinklerSimilarity();
			}
			res = (int) (jaroWinklerSimilarity.apply(string1, string2) * 1000);
			break;
		case LongestCommonSubsequence:
			if (longestCommonSubsequence == null) {
				longestCommonSubsequence = new LongestCommonSubsequence();
			}
			res = longestCommonSubsequence.apply(string1, string2);
			break;
		case Levenshtein:
			res = -LevenshteinDistance.getDefaultInstance().apply(string1, string2);
			break;
		default:
			res = longestCommonSubsequence.apply(string1, string2);
			break;
		}
		return res;
	}
}
