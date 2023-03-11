package OnHold;

public class Voter {
    private String votName;
    private String studentID;

    private boolean voted;

    public Voter(String votName, String studentID) {
        this.votName = votName;
        this.studentID = studentID;
        this.voted=false;
    }

    public void hasVoted(boolean voted){
        this.voted = voted;
    }


}
