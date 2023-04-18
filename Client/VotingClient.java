package Client;

import Entity.Voter;
import Entity.VotingRecorder;
import adt.DllNode;
import adt.DoublyLinkListInterface;
import adt.PriorityQueue;

import Entity.Singer;

import java.util.Scanner;


public class VotingClient {
    private Voter[] voteList = new DoublyLinkListInterface<Voter>();
    private PriorityQueue<Singer> singerList = new PriorityQueue<Singer>();


    // Constructor (the list will be updated after every vote to keep on track)
    public VotingClient() {
    }

    public void votingMenu(){
        // Pending Cast Vote (Dk need to add in voter Client or Voting Client)
        System.out.println("1.  Search singer's vote \n" +
                "2.  Show Top 3 and Bottom 3 Vote Counts\n" +
                "3.  Generate Full Vote List\n" +
                "4.  Back");
    }

    public void searchSingerVote(){
        // User is able to search vote by searching for Vote ID. The result will display Voter: xxx, Voted for: xxx on xx/xx/xxxx xx:xx:xx
        String singerID;
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the singerID: ");
        singerID = sc.nextLine();

        // TODO: Implement contains(String) in DLL
        if (singerList.contains(String singerID)) {
            System.out.println("===============================================");
            System.out.println(String.format("|  Singer ID    :  %-10s                |", singerID));
            System.out.println(String.format("|  Singer Name  :  %-30s                |", singerList.getEntry(singerList.getIndex(singerID)).getName()));
            System.out.println(String.format("|  Total Vote   :  %-10d                |", singerList.getEntry(singerList.getIndex(singerID)).getVoteCount()));
            System.out.println("===============================================");
        }

    }

    public void displayCurrentResult(){

        int listSize = singerList.size();

        System.out.println("========================================");
        System.out.println("|             Singer Ranking           |");
        System.out.println("========================================");

        for(int i; i < listSize; i++){
            Singer currentSinger = singerList.poll();
            String formattedStr = String.format("| " + i+1 + ". %-22s  %-10d  |", currentSinger.getName(), currentSinger.getVoteCount());
            System.out.println("|                                                                           |");
            System.out.println(formattedStr);
        }

        System.out.println("==================================================\n");
        System.out.println("Total Vote count: " + VotingRecorder.totalVotes);
        System.out.println("\n==================================================");

    }








}




