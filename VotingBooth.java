public class VotingBooth {
    private int numOfVoters;
    private int numOfVotesForCandidate1;
    private int numOfVotesForCandidate2;
    private int numOfVotesForCandidate3;
    private int numOfInvalidVotes;


    public VotingBooth(int numOfVoters) {
        this.numOfVoters = numOfVoters;
        this.numOfVotesForCandidate1 = 0;
        this.numOfVotesForCandidate2 = 0;
        this.numOfVotesForCandidate3 = 0;
        this.numOfInvalidVotes = 0;
    }

    public void castVote(int candidateNumber) {
        if (candidateNumber == 1) {
            numOfVotesForCandidate1++;
        } else if (candidateNumber == 2) {
            numOfVotesForCandidate2++;
        } else if(candidateNumber == 3){
            numOfVotesForCandidate3++;
        }else {
            numOfInvalidVotes++;
        }
    }

    public void printResults() {
        System.out.println("Total number of voters: " + numOfVoters);
        System.out.println("Number of votes for candidate 1: " + numOfVotesForCandidate1);
        System.out.println("Number of votes for candidate 2: " + numOfVotesForCandidate2);
        System.out.println("Number of votes for candidate 3: " + numOfVotesForCandidate3);
        System.out.println("Number of invalid votes: " + numOfInvalidVotes);
    }
}

