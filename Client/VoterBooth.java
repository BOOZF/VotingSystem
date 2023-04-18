package Client;

import Entity.Voter;
import adt.DllNode;
import adt.DoublyLinkListInterface;

import java.util.Scanner;

public class VoterBooth {

    public static void main(String[] args) {

        // create a Doubly Linked List of Voter objects
        DoublyLinkListInterface<Voter> voterList = new DllNode<>();

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {

            // display options to the user
            System.out.println("Welcome to the Voting System!");
            System.out.println("Please choose an option:");
            System.out.println("1. Register as a Voter");
            System.out.println("2. Login as a Voter");
            System.out.println("3. Cast your Vote");
            System.out.println("4. View Candidate Scores");
            System.out.println("5. View Candidate Profiles");
            System.out.println("6. Delete Voter Account");
            System.out.println("7. Exit");

            // read the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    // register as a voter
                    System.out.println("Please enter your name:");
                    String name = scanner.nextLine();

                    System.out.println("Please enter your IC number:");
                    String ic = scanner.nextLine();

                    System.out.println("Please enter your password:");
                    String password = scanner.nextLine();

                    Voter voter = new Voter(name, password, ic);
                    boolean isRegistered = voterList.add(voter);

                    if (isRegistered) {
                        System.out.println("You have successfully registered as a voter!");
                    } else {
                        System.out.println("Failed to register as a voter!");
                    }

                    break;

                case 2:
                    // login as a voter
                    System.out.println("Please enter your IC number:");
                    String icNum = scanner.nextLine();

                    System.out.println("Please enter your password:");
                    String pwd = scanner.nextLine();

                    Voter foundVoter = voterList.getEntry(new Voter("", pwd, icNum));

                    if (foundVoter == null) {
                        System.out.println("Invalid IC number or password!");
                    } else {
                        System.out.println("Welcome " + foundVoter.getName() + "!");
                    }

                    break;

                case 3:
                    // cast vote
                    // to be implemented

                    break;

                case 4:
                    // view candidate scores
                    // to be implemented

                    break;

                case 5:
                    // view candidate profiles
                    // to be implemented

                    break;

                case 6:
                    // delete voter account
                    System.out.println("Please enter your IC number:");
                    String icNumber = scanner.nextLine();

                    System.out.println("Please enter your password:");
                    String passwordStr = scanner.nextLine();

                    Voter deletedVoter = new Voter("", passwordStr, icNumber);
                    boolean isDeleted = voterList.remove(deletedVoter);

                    if (isDeleted) {
                        System.out.println("Your voter account has been deleted!");
                    } else {
                        System.out.println("Failed to delete your voter account!");
                    }

                    break;

                case 7:
                    // exit the program
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }

            System.out.println(); // print a newline character for formatting
        }

        scanner.close();
    }
}