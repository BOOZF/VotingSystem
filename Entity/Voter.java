package Entity;

public class Voter implements Comparable<Voter> {

    private static int castVoteNumber = 0; // voter no vote to any singer at 1st
    private String name;
    private String password; 
    private String studentID;
    boolean isVote = false;// havent use!!!

    // constructor

    public Voter(String name, String password, String studentID) {
        this.name = name;
        this.password = password;
        this.studentID = studentID;
    }


    // setter and getter
    public static int getCastVoteNumber() {
        return castVoteNumber;
    }

    public static void setCastVoteNumber(int castVoteNumber) {
        Voter.castVoteNumber = castVoteNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String ic) {
        this.studentID = studentID;
    }

    public boolean isVote() {
        return isVote;
    }

    public void setVote(boolean vote) {
        isVote = vote;
    }

    @Override
    public int compareTo(Voter o) {
        return name.compareTo(o.name);
    }
}