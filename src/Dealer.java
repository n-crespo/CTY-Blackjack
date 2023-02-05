public class Dealer {

  //create hand for dealer
  Hand dealerHand = new Hand();
  //create deck
  Deck deck = new Deck();

  public Card getNewCard() {
    return deck.getNextCard();
  }

  //displays first
  void displayFirstHand() {
    System.out.println("\nDealer has a: ");
    dealerHand.displayFirstCard();
  }

  //creates deck/shuffle
  void createDeck() {
    deck.createDeck();
    deck.shuffle();
  }

  int getSumOfHand() {
    return dealerHand.getSumOfHand();
  }

  void displayHand() {
    System.out.print("\nDealer has");
    dealerHand.displayHand();
    System.out.println("(The sum of dealer hand is " + getSumOfHand() + ".)");
  }

  //gives player and dealer 2 cards each
  public void deal(Hand hand) {
    Card card1 = deck.getNextCard();
    hand.addCard(card1);
    Card card2 = deck.getNextCard();
    hand.addCard(card2);
  }

  //if there are aces, change their value if necessary
  void fixAces() {
    int numberOfAces = dealerHand.countAces();
    if (numberOfAces > 0) {
      dealerHand.checkForAces(numberOfAces);
    }
  }

  boolean playDealer() {
    boolean hit = true;
    int sumOfHand = getSumOfHand();
    boolean roundOver = false;

    //if sum of hand is less than 17, hit
    //say round is over if sum of hand is 21 or higher
    while (hit) {
      if (sumOfHand < 17) {
        Card card = getNewCard();
        dealerHand.addCard(card);
        fixAces();
        //Recalculate sum of hand after getting a new card and fixing the aces
        sumOfHand = getSumOfHand();
        roundOver = false;
      } else if (sumOfHand < 21) {
        displayHand();
        hit = false;
        roundOver = false;
      } else if (sumOfHand == 21) {
        displayHand();
        System.out.println("\n-----------");
        System.out.println("Dealer wins. ");
        System.out.println("-----------");
        hit = false;
        roundOver = true;
      } else {
        displayHand();
        System.out.println("\n-----------");
        System.out.println("Dealer bust. ");
        System.out.println("-----------");
        System.out.println("You win! ");
        hit = false;
        roundOver = true;
      }
    }
    return roundOver;
  }

  //compares the sums of player and dealer, declares winner
  void declareWinner(int playerSum) {
    int dealerSum = getSumOfHand();

    if (playerSum > dealerSum) {
      System.out.println("\n-----------");
      System.out.println("You win!");
      System.out.println("-----------");
    } else if (playerSum == dealerSum) {
      System.out.println("\n---------");
      System.out.println("You tie!");
      System.out.println("---------");
    } else {
      System.out.println("\n------------");
      System.out.println("Dealer wins!");
      System.out.println("------------");
    }
  }
}
