import java.util.Scanner;

public class Player {

    //create player hand Hand
    Hand playerHand = new Hand();

    //method to set a certain index in the playerHand to a different value
    void setAceValue(int value, int aceIndex) {
        playerHand.setAceValue(value, aceIndex);
    }

    int countAces() {
        return playerHand.countAces();
    }

    int getSumOfHand() {
        return playerHand.getSumOfHand();
    }

    //method to make sure round isn't immediately over because the player busted or won
    boolean checkIfRoundOver() {
        boolean roundOver = false;
        int sumOfHand = getSumOfHand();
        if (sumOfHand == 21) {
            System.out.println("\n---------");
            System.out.println("You win!");
            System.out.println("---------");
            roundOver = true;
        } else if (sumOfHand > 21) {
            System.out.println("\n----------");
            System.out.println("You busted.");
            System.out.println("----------");
            roundOver = true;
        }
        return roundOver;
    }

    void displayHand() {
        System.out.print("\nYou have");
        playerHand.displayHand();
    }

    //asks user if they want to hit or stand, returns as boolean
    boolean askPlayer() {

        boolean hit;
        Scanner input = new Scanner(System.in);
        int sumOfHand = playerHand.getSumOfHand();

        if(sumOfHand < 21) {
            System.out.println("\nThe sum of your hand is "+sumOfHand+". (Assuming the value of any aces is 1.)");
            System.out.println("Would you like to hit or stand? Please enter 'h' or 's'");
            String inputString = input.next();
            hit = !inputString.equals("s");
        } else {
            hit = false;
        }
        return hit;
    }

    //checks any card in the player hand is an ace, then asks the player which value they want it to have
    void checkAces() {
        int numberOfAces = countAces();
        Scanner input = new Scanner(System.in);
        if (numberOfAces > 0) {
            System.out.println("Your hand has "+numberOfAces+" ace(s) in it. ");
            for (int i = 1; i<=numberOfAces;i++) {
                System.out.println("Would you like Ace #"+i+" to be valued at 11 or 1? Please enter '11' or '1'. ");
                int value = input.nextInt();
                setAceValue(value, (i-1));
            }
        }
    }

}
