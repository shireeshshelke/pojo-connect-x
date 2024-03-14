package com.pojo.connectx.similarity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pojo.connectx.similarity.SimilarityChecker.SIMILARITY_ALGO;

public class SimilarityMapper {
	SimilarityChecker checker;

	public SimilarityMapper() {
		checker = new SimilarityChecker();
	}

	public Map<String, SimilarityOutputPojo> mapStrings(LinkedList<SimilarityInputPojo> source, LinkedList<SimilarityInputPojo> target) {
		return mapStrings(source, target, SIMILARITY_ALGO.LongestCommonSubsequence);
	}

	public Map<String, SimilarityOutputPojo> mapStrings(LinkedList<SimilarityInputPojo> source, LinkedList<SimilarityInputPojo> target, SIMILARITY_ALGO longestcommonsubsequence) {
		
		List<SimilarityOutputPojo> allDists = getSortedListOfSimilarityScore(source, target, longestcommonsubsequence);
		Map<String, SimilarityOutputPojo> mapping = getBestMappingFromList(allDists, source.size(), target.size());
		
		return mapping;
	}

	private Map<String, SimilarityOutputPojo> getBestMappingFromList(List<SimilarityOutputPojo> allDists, int a1Size, int a2Size) {
		Map<String, SimilarityOutputPojo> mapping = null;

		if (allDists != null) {
			mapping = new HashMap<>();
			Set<Integer> a1Set = new HashSet<>();
			Set<Integer> a2Set = new HashSet<>();

			for (SimilarityOutputPojo p : allDists) {
				if (a1Set.size() == a1Size || a2Set.size() == a2Size) {
					break;
				}

				int s1Hash = p.getSourceFlattenKey().hashCode();
				int s2Hash = p.getTargetFlattenKey().hashCode();

				if (!a1Set.contains(s1Hash) && !a2Set.contains(s2Hash)) {
					a1Set.add(s1Hash);
					a2Set.add(s2Hash);
					mapping.put(p.getTargetFlattenKey(), p);
				}
			}
		}
		return mapping;
	}

	private List<SimilarityOutputPojo> getSortedListOfSimilarityScore(LinkedList<SimilarityInputPojo> source, LinkedList<SimilarityInputPojo> target, SIMILARITY_ALGO longestcommonsubsequence) {
		List<SimilarityOutputPojo> allDists = null;

		if (source != null && target != null) {
			allDists = new ArrayList<>(source.size() * target.size());

			for (SimilarityInputPojo s : source) {
				for (SimilarityInputPojo t : target) {
					int similarityScore = checker.computeSimilarity(s.getFlattenName(), t.getFlattenName(),
							longestcommonsubsequence);

					allDists.add(new SimilarityOutputPojo(s.getParentClassName(), t.getParentClassName(),
							s.getFlattenName(), t.getFlattenName(), similarityScore));
				}
			}

			allDists.sort(new Comparator<SimilarityOutputPojo>() {

				@Override
				public int compare(SimilarityOutputPojo o1, SimilarityOutputPojo o2) {
					return o2.getSimilarityScore() - o1.getSimilarityScore();
				}
			});
		}
		return allDists;
	}
}
