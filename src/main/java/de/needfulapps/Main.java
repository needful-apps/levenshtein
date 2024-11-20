package de.needfulapps;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> streetNames = new ArrayList<>();

        streetNames.add("Elm Street");
        streetNames.add("Maple Street");
        streetNames.add("Oak Street");
        streetNames.add("Pine Street");
        streetNames.add("Willow Street");

        String myStreet = "Helm Street";

        List<Candidate> candidates = LevenshteinDistance.findCandidate(streetNames, myStreet, 5, 3);

        System.out.println("Candidates for " + myStreet + ":");
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getWord() + " - " + candidate.getDistance());
        }
    }
}