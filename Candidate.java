public class Candidate {
    private String candName;
    private int candNo;

    private int voteCount;

    public Candidate(String candName) {
        this.candName = candName;
    }

    public Candidate(String candName, int candNo) {
        this.candName = candName;
        this.candNo = candNo;
        this.voteCount = 0;
    }

    public int getVoteCount(){
        return voteCount;
    }

    public void increVoteCount(){
        this.voteCount++;
    }
}
