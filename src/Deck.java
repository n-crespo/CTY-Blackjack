public class Deck {

  // deck attributes/deck array
  Card[] deck = new Card[52];
  int deckPosition = 0;

  // increases deck position and returns next card in the deck
  public Card getNextCard() {
    deckPosition++;
    return deck[deckPosition - 1];
  }

  public void createDeck() {
    // create each suit
    createSuits(0, 12, '♠');
    createSuits(13, 25, '♣');
    createSuits(26, 38, '♥');
    createSuits(39, 51, '♦');

    // createSuits(0, 12, '\u0006');
    // createSuits(13, 25, '\u0005');
    // createSuits(26, 38, '\u0003');
    // createSuits(39, 51, '\u0004');
  }

  void createSuits(int startPos, int endPos, char suit) {
    int cardValue = 2;

    // create aces
    Card ace = new Card();
    deck[startPos] = ace;
    ace.setCardRank("Ace");
    ace.setCardSuit(suit);
    ace.setCardValue(1);

    // create number cards
    for (int i = startPos + 1; i <= endPos - 2; i++) {
      Card card = new Card();
      card.setCardValue(cardValue);
      cardValue++;
      card.setCardSuit(suit);
      card.setCardRank(String.valueOf(cardValue - 1));
      deck[i] = card;
    }
    // create 3 letter cards
    for (int i = endPos - 2; i <= endPos; i++) {
      Card card = new Card();
      card.setCardValue(10);
      card.setCardSuit(suit);
      if (i == endPos - 2) {
        card.setCardRank("Jack");
        deck[i] = card;
      } else if (i == endPos - 1) {
        card.setCardRank("Queen");
        deck[i] = card;
      } else if (i == endPos) {
        card.setCardRank("King");
        deck[i] = card;
      }
    }
  }

  // gets a random number and switches the deck[random number] with the first/next
  // card in the deck
  public void shuffle() {
    for (int i = 0; i < deck.length; i++) {
      int index = (int) (Math.random() * deck.length);
      deck[i] = deck[index];
    }
  }
}
