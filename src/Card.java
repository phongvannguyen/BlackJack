/**
 * @author Phong Van Nguyen
 * @date 10/01/17
 *
 * A representation of what a card is.
 */
public class Card {

    private String[] cardValue = {  "TWO",
                            "THREE",
                            "FOUR",
                            "FIVE",
                            "SIX",
                            "SEVEN",
                            "EIGHT",
                            "NINE",
                            "TEN",
                            "JACK",
                            "QUEEN",
                            "KING",
                            "ACE"   };

    /**
     * It will be used as an index to obtain a card's value from the cardValue array.
     *
     * 0 - "TWO"
     * 1 - "THREE"
     * ...
     * 11 - "KING"
     * 12 - "ACE"
     */
    private int cardIndex;

    /**
     * One of the four suits of this card.
     */
    private Suit cardSuit;

    /**
     * This constructor sets up a card.
     *
     * @param cIndex  the value of the card.
     * @param cSuit   the suit of the card.
     */
    public Card(int cIndex, Suit cSuit) {

        this.cardIndex = cIndex;
        this.cardSuit = cSuit;

    }

    // Empties constructor
    public Card() {}

    /**
     * Returns the value of the card.
     *
     * @return the value.
     */
    public int getCardIndex() {

        return this.cardIndex;

    }

    /**
     * Prints out the card
     *
     * @return the card with value and a suit.
     */
    public String toString() {

        return "\t" + this.cardValue[cardIndex].toString() + " of " + this.cardSuit.toString();

    }
}
