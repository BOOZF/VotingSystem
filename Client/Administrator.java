package Client;

import Entity.Admin;
import Entity.Singer;
import Entity.Voter;
import adt.*;

import java.util.Objects;

public class Administrator {
    private static AVLTreeInterface<Singer> SingerList;
    private static AVLTreeInterface<Voter> VoterList;
    private static AVLTreeInterface<Admin> AdminList;
    private static HashMapInterface<String, Integer> castVote;

    public Administrator(AVLTreeInterface singerList) {
    }

    public Administrator() {
        VoterList = new AVLTree<>();
        AdminList = new AVLTree<>();
        SingerList = new AVLTree<>();
        castVote = new MyHashMap<>();

    }

    public static void displayAdminMenu() {
        System.out.println();
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%78s","******************** ADMIN PAGE *********************\n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%79s","             1.  Delete Candidate                     \n");
        System.out.printf("%79s","             2.  Insert Candidate                     \n");
        System.out.printf("%79s","             3. Generate Result Report                \n");
        System.out.printf("%79s","             4.  Show all the VotersID                \n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%70s","                Enter Your Option :            \n");
    }

    public void addSinger(Singer singer){
        try {
            SingerList.insert(singer);
        } catch (AVLTree.DuplicateElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteSinger(String singerID){
        Singer singer = null;
        AVLTree.List<Singer> singerList = SingerList.inOrderTraversal();

        for (int i = 0; i < singerList.size(); i++){
            if (Objects.equals(singerID, singerList.get(i).getId())){
                singer = singerList.get(i);
                SingerList.remove(singer);
            }
        }

    }

    /**
    public String generateFullReport() {
        StringBuilder sb = new StringBuilder();
        Singer singer = new Singer();

        // get total number of votes
        int totalVotes = 0;
        AVLTree.List<Singer> singerReport = SingerList.inOrderTraversal();
        for (int i = 0; i < singerReport.size(); i++) {
            totalVotes += singer.getVoteCount();
        }

        // generate report for each singer
        for (int i = 0; i < singerReport.size(); i++) {
            sb.append("Singer ID: ").append(singer.getId())
                    .append(", Name: ").append(singer.getName())
                    .append(", Number of Votes: ").append(singer.getVoteCount())
                    .append(", Percentage of Votes: ").append((double) singer.getVoteCount() / totalVotes * 100)
                    .append("%\n");
        }

        // add total number of votes to report
        sb.append("Total Number of Votes: ").append(totalVotes);

        return sb.toString();
    }
     **/

    public void displaySingers() {
        System.out.println("Singer list:");
        AVLTree.List<Singer> nameList = SingerList.inOrderTraversal();
        for (int i = 0; i < nameList.size(); i++) {
            Singer nameOfList = nameList.get(i);
            System.out.println(nameOfList);
        }
    }


    public void displayVoters() {
        System.out.println("Voter list:");
        AVLTree.List<Voter> nameList = VoterList.inOrderTraversal();
        for (int i = 0; i < nameList.size(); i++) {
            Voter nameOfList = nameList.get(i);
            System.out.println(nameOfList);
        }
    }

    /**
    public Singer getSingerByID(String singerID) {
        Singer singer = new Singer(singerID, "");
        if (SingerList.search(singer)) {
            return singer;
        }
        return null;
    }
     **/


}
