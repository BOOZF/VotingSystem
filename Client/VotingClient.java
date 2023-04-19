package Client;

import Entity.Voter;
import Entity.VotingRecorder;
import adt.DllNode;
import adt.DoublyLinkListInterface;
import adt.PriorityQueue;

import Entity.Singer;
import adt.PriorityQueueInterface;


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

    // Search for specific singer and display their votes
    public void searchSingerVote(String singerID){
        boolean found = false;
        countSingerVotes();

        for(int i = 0; i< singerList.size(); i++){
            if(singerList.get(i).toString().contains(singerID)){
                System.out.println("===========================================");
                System.out.println("|   Singer Name : " + singerList.get(i).getName() + "    |");
                System.out.println("|   Total Votes : " + singerList.get(i).getVoteCount() + "   |");
                System.out.println("|=================================================");
                found = true;
            }
        }

        if (!found){
            System.out.println("Singer Not Found !");
        }
    }

    // Display the whole ranking for voter to view
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
        for(int i=0; i<voteList.size(); i++){

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

    // TODO: Implement Voter change vote function
    public String editVote(Voter voter, Singer singer){
        int voteIndex = 0;
        boolean found = false;

        if(!voter.isVote()){
            return "You have not voted !";
        }

        for(int i = 0; i< voteList.size(); i++){
            if(voteList.getEntry(i).getVoter().equals(voter)){
                voteList.getEntry(i).setSinger(singer);
                voteIndex = i;
                found = true;
            }
        }

        if(!found){
            return "Vote not found !";
        }

        return voteList.getEntry(voteIndex).toString();


    }





}




