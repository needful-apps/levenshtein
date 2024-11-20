package de.needfulapps;

import de.needfulapps.Candidate;

import java.util.ArrayList;
import java.util.List;

public class LevenshteinDistance {

    public static List<Candidate> findCandidate(List<String> candidates, String word, int maxDistance, int maxCandidates) {
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
        List<Candidate> candidateList = new ArrayList<>();
        for (String candidate : candidates) {
            candidateList.add(levenshteinDistance.compareWords(candidate, word));
        }

        return candidateList.stream()
                .sorted()
                .filter(candidate -> candidate.getDistance() <= maxDistance)
                .limit(maxCandidates)
                .toList();
    }

    private Candidate compareWords(String candidate, String word) {
        int distance = calculateDistance(candidate, word);
        return new Candidate(distance, candidate);
    }

    private int calculateDistance(String candidate, String word) {
        int[][] distance = new int[candidate.length() + 1][word.length() + 1];

        for (int i = 0; i <= candidate.length(); i++) {
            distance[i][0] = i;
        }

        for (int j = 1; j <= word.length(); j++) {
            distance[0][j] = j;
        }

        for (int i = 1; i <= candidate.length(); i++) {
            for (int j = 1; j <= word.length(); j++) {
                int cost = candidate.charAt(i - 1) == word.charAt(j - 1) ? 0 : 1;
                distance[i][j] = Math.min(Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1), distance[i - 1][j - 1] + cost);
            }
        }

        return distance[candidate.length()][word.length()];
    }
}
