import java.util.ArrayList;

public class Election{
    private String name;
    private ArrayList<Candidate> candidates;

    public Election(String name, ArrayList<Candidate> candidates) {
        this.name = name;
        this.candidates = candidates;
    }

    public void addCandidate(Candidate candidate) {
        this.candidates.add(candidate);
    }
    // Test
    public Candidate getWinner(){
        Candidate winner = null;
        int maxVotes = 0;
        for (Candidate candidate : candidates){
            if (candidate.getVoteCount() > maxVotes){
                winner = candidate;
                maxVotes = candidate.getVoteCount();
            }
        }
        return winner;
    }

}
