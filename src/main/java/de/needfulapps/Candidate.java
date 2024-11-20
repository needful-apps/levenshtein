package de.needfulapps;

public class Candidate implements Comparable<Candidate> {
    private int distance;
    private String word;

    public int getDistance() {
        return distance;
    }

    public String getWord() {
        return word;
    }

    public Candidate(int distance, String word) {
        this.distance = distance;
        this.word = word;
    }

    @Override
    public int compareTo(Candidate other) {
        return this.distance - other.distance;
    }
}
