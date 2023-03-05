public class VoteRecorder {
    private String[] candidates;
    private int[] voteCounts;

    public VoteRecorder(String[] candidates) {
        this.candidates = candidates;
        this.voteCounts = new int[candidates.length];
    }

    public void recordVote(String candidate) {
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i].equals(candidate)) {
                voteCounts[i]++;
                break;
            }
        }
    }

    public int[] getvoteCounts(){
        return voteCounts;
    }
    public void printResults() {
        for (int i = 0; i < candidates.length; i++) {
            System.out.println(candidates[i] + ": " + voteCounts[i] + " votes");
        }
    }
}

