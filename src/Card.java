public class Card {

    //create card attributes
    String cardRank;
    int cardValue;
    char cardSuit;

    //get/set methods
    void setCardRank(String rank){
        cardRank = rank;
    }

    String getCardRank (Card card) {
        return card.cardRank;
    }

    void setCardValue(int value) {
        cardValue = value;
    }

    int getCardValue (Card card) {
        return card.cardValue;
    }

    void setCardSuit(char suit) {
        cardSuit = suit;
    }

    char getCardSuit (Card card) {
        return card.cardSuit;
    }
}
