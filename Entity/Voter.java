package Entity;

public class Voter implements Comparable<Voter> {

    private static int VoterID = 0;
    private static int castVoteNumber = 0; // voter no vote to any singer at 1st
    private String name;
    private String password;
    private String ic;
    boolean isVote = false;// havent use!!!

    // constructor

    public Voter(String name, String password, String ic) {
        this.name = name;
        this.password = password;
        this.ic = ic;
        VoterID++;
    }

//    public Voter(String name, String password, String ic) {
//        this.name = name;
//        this.password = password;
//        this.ic = ic;
//        VoterID++;
//    }

    // setter and getter
    public static int getVoterID() {
        return VoterID;
    }

    public static void setVoterID(int voterID) {
        VoterID = voterID;
    }

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

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
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
