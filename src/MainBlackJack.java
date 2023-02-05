//Nicolas Crespo, July 9, 2021, game of blackjack
import java.util.Scanner;

public class MainBlackJack {

  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      String response = "yes";
      //plays a round, then asks if player wants to play again
      while (response.equals("yes")) {
        playRound();
        System.out.println(
          "\n----------------------------------------------------------"
        );
        System.out.println(
          "Would you like to play again? Please enter 'yes' or 'no.' "
        );
        System.out.println(
          "----------------------------------------------------------"
        );
        response = input.next();
      }
    }
    System.out.println("Thanks for playing! ");
  }

  private static void playRound() {
    //create dealer/player
    Dealer dealer = new Dealer();
    Player player = new Player();

    //creates deck, deals to player/dealer
    dealer.createDeck();
    dealer.deal(player.playerHand);
    dealer.deal(dealer.dealerHand);

    //displays dealt cards
    player.displayHand();
    dealer.displayFirstHand();

    //asks player hit or stand
    boolean hit = player.askPlayer();
    //if player says hit, gets a new card, adds it to player hand, and displays the new hand, then asks again
    while (hit) {
      Card newCard = dealer.getNewCard();
      player.playerHand.addCard(newCard);
      System.out.print("\nYou have");
      player.playerHand.displayHand();
      hit = player.askPlayer();
    }

    //check if the player hand has aces in it,
    player.checkAces();
    int playerSumOfHand = player.getSumOfHand();
    //displays sum of the hand for the last time
    System.out.println("The sum of your hand is " + playerSumOfHand + ". ");
    System.out.println();

    //checks if the player won or busted
    boolean playerRoundOver = player.checkIfRoundOver();

    //if player won or busted round is over, otherwise dealer plays
    if (!playerRoundOver) {
      boolean dealerRoundOver = dealer.playDealer();
      //checks if the dealer won or busted, otherwise compare dealer and player hand and declare winner
      if (!dealerRoundOver) {
        dealer.declareWinner(player.getSumOfHand());
      }
    }
  }
}
