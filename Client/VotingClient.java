//package Client;
//
//import Entity.Voter;
//import adt.DoublyLinkList;
//import adt.PriorityQueue;
//
//import Entity.Singer;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//
//public class VotingClient {
//
//    // Need to modify later on
//    private static PriorityQueue<Singer> singerList = new DoublyLinkList();
//    private static DoublyLinkList<Votes> voteList = new DoublyLinkList();
//
//    // Constructor (the list will be updated after every vote to keep on track)
//    public VotingClient(PriorityQueue<Singer>singerList, DoublyLinkList<Votes> voteList) {
//        this.singerList = singerList;
//        this.voteList = voteList;
//    }
//
//    public void votingMenu(){
//        // Pending Cast Vote (Dk need to add in voter Client or Voting Client)
//        System.out.println("1.  Search singer's vote \n" +
//                "2.  Show Top 3 and Bottom 3 Vote Counts\n" +
//                "3.  Generate Full Vote List\n" +
//                "4.  Back");
//    }
//
//    public void searchVote(){
//        // User is able to search vote by searching for Vote ID. The result will display Voter: xxx, Voted for: xxx on xx/xx/xxxx xx:xx:xx
//        String voteID;
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Please enter the VoteID: ");
//        // TODO: Add validation for V001
//        voteID = sc.nextLine();
//
//        if(voteList.contains(voteID)){
//            System.out.println("Voter: " + voteList[voteIDindex].get("voter") + ", Voted for: " + voteList[voteIDindex].get("voted") + " on "
//                    + voteList[voteIDindex].get("dateTime"));
//        }else {
//            System.out.println("The voteID does not exists");
//        }
//    }
//
//    public void topBottomSinger(){
//        System.out.println("====================================");
//
//    }
//
//
//
//
//
//
//
//
//}
//
//
//
//
