public class Hand {

    //create an array of cards and hand position, initialized to 12 because there is no situation that the dealer or player
    //can have more than 12 cards without busting
    Card [] cards = new Card[12];
    //hand position is used to know the index at which a new card should be added; hand position is increased whenever a card is added
    int handPosition = 0;

    //returns the sum of the hand
    public int getSumOfHand () {
        int sumOfHand = 0;
        for (int i=0;i<handPosition;i++) {
            sumOfHand += cards[i].cardValue;
        }
        return sumOfHand;
    }

    //runs through the hand and
    void checkForAces(int numberOfAces) {
        for(int i=0; numberOfAces>0; i++) {
            if (cards[i].cardRank.equals("Ace")) {
                changeAces(i);
                numberOfAces--;
            }
        }
    }

    //changes the value of aces (only for the dealer)
    /*
    NOTE: this logic is very simple, it could be expanded upon
    The dealer simply always chooses the higher value for an ace as long as it doesn't bust in doing so.
    This could be changed in such a way that the dealer takes into account a card that it has not received yet,
    and chooses a value for an ace accordingly. This could be considered cheating. There are situations where if the
    dealer chose the value of an ace to be 1, the sum of his hand would not be 17, so he would hit again, but
    if he chose it to be 11, the sum of his hand would be more than 21 and he would stand. In this situation, because
    of this code, the dealer would make the ace 11, and stand.
    */
    void changeAces(int i) {
        cards[i].setCardValue(11);
        int largeSum = getSumOfHand();
        if (largeSum > 21) {
            cards[i].setCardValue(1);
        }

    }

    //goes through the hand and counts number of aces
    int countAces() {
        int aceCount=0;
        for(int i = 0; i<handPosition; i++) {
            if (cards[i].cardRank.equals("Ace")) {
                aceCount++;
            }
        }
        return aceCount;
    }

    //sets the value of an ace to what the player decides
    void setAceValue(int value, int aceIndex) {
        int aceCount = 0;
        for(int i=0; i<handPosition; i++) {
            if (cards[i].cardRank.equals("Ace")) {
                if (aceIndex == aceCount) {
                    cards[i].setCardValue(value);
                }
                aceCount++;
            }
        }

    }

    //adds a card to the hand
    public void addCard(Card card) {

        cards[handPosition] = card;
        handPosition++;
    }

    //displays number of cards and each card in the hand
    public void displayHand() {
        System.out.println(" " +handPosition + " cards:");
        for(int i = 0; i < handPosition; i++) {
            System.out.println(cards[i].cardRank + " of " + cards[i].cardSuit);
        }
    }

    //displays the first dealt card for the dealer
    public void displayFirstCard() {
        System.out.println(cards[0].cardRank + " of " + cards[0].cardSuit);
    }
}
