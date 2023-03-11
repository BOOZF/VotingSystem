package OnHold;

import java.util.Arrays;

public class Ranking {
    private String[] candidates;
    private int[] scores;

    public Ranking(String[] candidates, int[] scores) {
        this.candidates = candidates;
        this.scores = scores;
    }

    public void printRanking() {
        int[] sortedScores = scores.clone();
        Arrays.sort(sortedScores);
        for (int i = sortedScores.length - 1; i >= 0; i--) {
            int score = sortedScores[i];
            System.out.println(getCandidateByScore(score) + ": " + score);
        }
    }

    private String getCandidateByScore(int score) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == score) {
                return candidates[i];
            }
        }
        return null;
    }
}

