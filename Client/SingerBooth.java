package Client;
import Entity.Singer;
import adt.MyHashMap;

import java.util.Scanner;

public class SingerBooth {
    Scanner scanner = new Scanner(System.in);
    private MyHashMap<String, Singer> singerMap;
    MyHashMap<String, Singer> SingerList = new MyHashMap<String, Singer>();
    public SingerBooth() {
        singerMap = new MyHashMap<>();
    }

    public void initializeSinger() {
        Singer SingerDetails1 = new Singer("001", "James", "010101-01-0101", "Male", "22", "<<Love Story>>");
        SingerList.put(SingerDetails1.getId(), SingerDetails1);

        Singer SingerDetails2 = new Singer("002", "Jimmy", "000601-01-0101", "Male", "23", "<<Counting Star>>");
        SingerList.put(SingerDetails2.getId(), SingerDetails2);

        Singer SingerDetails3 = new Singer("003", "Rebeca", "991230-01-0101", "Female", "24", "<<Unstoppable>>");
        SingerList.put(SingerDetails3.getId(), SingerDetails3);

        Singer SingerDetails4 = new Singer("004", "Alexandra", "020710-01-0101", "Female", "21", "<<Happier>>");
        SingerList.put(SingerDetails4.getId(), SingerDetails4);

        Singer SingerDetails5 = new Singer("005", "Albert", "970620-01-0101", "Male", "26", "<<Love Yourself>>");
        SingerList.put(SingerDetails4.getId(), SingerDetails4);
    }

    public void searchSingerById(){
        System.out.print("Enter Singer ID: ");
        String singerId = scanner.nextLine();
        Singer singer = SingerList.get(singerId);
        if (singer != null) {
            System.out.println("----Singer Details----");
            System.out.println("ID: " + singer.getId());
            System.out.println("Name: " + singer.getName());
            System.out.println("IC: " + singer.getIcNo());
            System.out.println("Gender: " + singer.getGender());
            System.out.println("Age: " + singer.getAge());
            System.out.println("Song Titles: " + singer.getSongTitles());
        } else {
            System.out.println("Singer with ID " + singerId + " not found.");
        }
    }

    public void editSingerInfo() {
        System.out.print("Enter singer ID: ");
        String id = scanner.nextLine();

        // Check if singer exists in HashMap
        if (SingerList.containsKey(id)) {
            Singer singer = SingerList.get(id);

            // Display current singer information
            System.out.println("Current singer information:");
            System.out.println(singer);

            // Prompt user for new singer information
            System.out.print("Enter new name (press Enter to keep current name): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                singer.setName(name);
            }

            System.out.print("Enter new IC number (press Enter to keep current IC number): ");
            String icNumber = scanner.nextLine();
            if (!icNumber.isEmpty()) {
                singer.setIcNo(icNumber);
            }

            System.out.print("Enter new gender (press Enter to keep current gender): ");
            String gender = scanner.nextLine();
            if (!gender.isEmpty()) {
                singer.setGender(gender);
            }

            System.out.print("Enter new age (press Enter to keep current age): ");
            String age = scanner.nextLine();
            if (!age.isEmpty()) {
                singer.setAge(age);
            }

            System.out.print("Enter new song title (press Enter to keep current song title): ");
            String songTitle = scanner.nextLine();
            if (!songTitle.isEmpty()) {
                singer.setSongTitles(songTitle);
            }

            // Update singer information in HashMap
            SingerList.put(singer.getId(), singer);

            System.out.println("Singer information updated successfully.");
        } else {
            System.out.println("Singer not found.");
        }
    }

//    public void voteForSinger() {
//        System.out.print("Enter Singer ID: ");
//        String singerId = scanner.nextLine();
//        Singer singer = singerMap.get(singerId);
//        if (singer != null) {
//            int currentVoteCount = singer.getVoteCount();
//            singer.setVoteCount(currentVoteCount + 1);
//            System.out.println("Vote for Singer " + singerId + " recorded successfully.");
//        } else {
//            System.out.println("Singer ID " + singerId + " not found.");
//        }
//    }
    //ON HOLD YAAA
}


