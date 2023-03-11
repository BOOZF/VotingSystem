package OnHold;

import java.util.ArrayList;

public class Ballot {
    private String ticketID;
    private ArrayList<String> candidateName;

    public Ballot(ArrayList<String> candidateName) {
        this.candidateName = candidateName;
    }

    public Ballot(String ticketID, ArrayList<String> candidateName) {
        this.ticketID = ticketID;
        this.candidateName = candidateName;
    }

    public String getticketID(){
        return ticketID;
    }

    public ArrayList<String> getCandidateName(){
        return candidateName;
    }
}
