package Entity;

public class VotingRecorder implements Comparable<VotingRecorder> {

    // To keep track on who voted for who
    private Voter voter;
    private Singer singer;
    private boolean isCounted;
    public static int totalVotes;


    // Empty Constructor =======================================================================================================
    public VotingRecorder(){
        // Create dummy data for empty constructor
        this.voter = new Voter();
        this.singer = new Singer();
        this.isCounted = false;
        totalVotes++;
    }

    public VotingRecorder(Voter voter, Singer singer){
        this.voter = voter;
        this.singer = singer;
        this.isCounted = false;
        totalVotes++;
    }

    // Setter
    public void setVoter(Voter voter){
        this.voter = voter;
    }

    public void setSinger(Singer singer){
        this.singer = singer;
    }

    public void setIsCounted(boolean bool){
        this.isCounted = bool;
    }
    // ======================================================================================================================
    // Getter ===============================================================================================================
    public Voter getVoter(){
        return this.voter;
    }

    public Singer getSinger(){
        return this.singer;
    }

    public boolean getIsCounted(){
        return this.isCounted;
    }

    public int getTotalVotes(){
        return totalVotes;
    }
    // ======================================================================================================================

    // TODO: Implement compareTo properly
    @Override
    public int compareTo(VotingRecorder o) {
        return 0;
    }

}
