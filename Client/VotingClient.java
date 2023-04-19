package Client;

import Entity.Voter;
import Entity.VotingRecorder;
import adt.DllNode;
import adt.DoublyLinkListInterface;
import adt.PriorityQueue;

import Entity.Singer;
import adt.PriorityQueueInterface;

import java.util.Objects;
import java.util.Scanner;


public class VotingClient {
    private DoublyLinkListInterface<VotingRecorder> voteList = new DllNode<VotingRecorder>();
    private PriorityQueueInterface<Singer> singerList = new PriorityQueue<Singer>();


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
        countSingerVotes();
        Singer singer = null;

        // Check if id consist in the list or not
        if(singerList.toString().contains(new Singer(singerID).getId())){
            for(int i = 0; i<singerList.size(); i++){
                if(Objects.equals(new Singer(singerID).getId(), singerList.get(i))){
                    singer = singerList.get(i);

                    System.out.println("===============================================");
                    System.out.println(String.format("|  Singer ID    :  %-10s                |", singer.getId()));
                    System.out.println(String.format("|  Singer Name  :  %-30s                |", singer.getName()));
                    System.out.println(String.format("|  Total Vote   :  %-10d                |", singer.getVoteCount()));
                    System.out.println("===============================================");
                }
            }
        }else {
            System.out.println("No singer with such ID Exists !");
        }

    }

    public void displayCurrentResult(){
        countSingerVotes();
        int listSize = singerList.size();

        System.out.println("========================================");
        System.out.println("|             Singer Ranking           |");
        System.out.println("========================================");

        for(int i=0; i < listSize; i++){
            Singer currentSinger = singerList.poll();
            String formattedStr = String.format("| " + i+1 + ". %-22s  %-10d  |", currentSinger.getName(), currentSinger.getVoteCount());
            System.out.println("|                                                                           |");
            System.out.println(formattedStr);
        }

        System.out.println("==================================================\n");
        System.out.println("Total Vote count: " + VotingRecorder.totalVotes);
        System.out.println("\n==================================================");

    }

    // Counts respective singer votes and store them into PQ to auto sort them
    public void countSingerVotes(){

        // Loops through the votelist
        for(int i; i<voteList.size(); i++){

            Singer voteSinger = voteList.getEntry(i).getSinger();
            // Register vote into singer vote count
            if(singerList.contains(voteSinger)){
                int singerCurrentVote = voteSinger.getVoteCount();
                voteSinger.setVoteCount(singerCurrentVote++);
                singerList.update(voteSinger);
            }else {
                System.out.println("Singer does not exist");
            }
        }
    }






}




