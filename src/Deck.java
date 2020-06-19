import java.util.ArrayList;
import java.util.Random;

/**
 * @author Phong Van Nguyen
 * @date 10/01/17
 *
 * This class simulates a typical deck of 52 cards.
 */
public class Deck {

    // Where all the 52 cards are stored.
    ArrayList<Card> deckOfCards;

    /**
     * Creates a space for the cards that will fill the deck.
     */
    public Deck() {

        this.deckOfCards = new ArrayList<>();

    }

    /**
     * Generates a deck with 52 cards.
     */
    public void createDeck() {

        // for each suit
        for(Suit cSuit : Suit.values()) {
            // for each value
            for(int n = 0; n < 13; n++) {
                // add a card to the deck
                this.deckOfCards.add(new Card(n, cSuit));
            }
        }

    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() {

        // temporary deck
        ArrayList<Card> shuffledDeck = new ArrayList<>();

        Random rand = new Random();
        int randomIndex = 0;
        int sizeOfDeck = this.deckOfCards.size();
        // Each time a card is removed, the range of random number generator
        // is decreased by 1 to account for the new size of the deck.
        for(int i = 0; i < sizeOfDeck; i++) {
            randomIndex = rand.nextInt(this.deckOfCards.size());
            shuffledDeck.add(this.deckOfCards.get(randomIndex));
            this.deckOfCards.remove(randomIndex);
        }
        this.deckOfCards = shuffledDeck;

    }

    /**
     * Gets the card at the specified index
     *
     * @param index    The location of the card.
     * @return         The card.
     */
    public Card getCard(int index) {

        return this.deckOfCards.get(index);
    }

    /**
     * Removes the card at the specified index
     *
     * @param index     The location of the card.
     */
    public void removeCard(int index) {

        this.deckOfCards.remove(index);
    }

    /**
     * Draws the incoming deck's top card.
     *
     * @param deckToBeDrawn     the deck to be drawn.
     */
    public void draw(Deck deckToBeDrawn) {

        this.deckOfCards.add(deckToBeDrawn.getCard(0));
        deckToBeDrawn.removeCard(0);

    }

    /**
     *
     * @return      The hand's total value.
     */
    public int getHandTotal() {

        int handTotal = 0;
        int numAces = 0;

        for(Card card : this.deckOfCards) {
            switch(card.getCardIndex()) {
                case 0: handTotal += 2; break;
                case 1: handTotal += 3; break;
                case 2: handTotal += 4; break;
                case 3: handTotal += 5; break;
                case 4: handTotal += 6; break;
                case 5: handTotal += 7; break;
                case 6: handTotal += 8; break;
                case 7: handTotal += 9; break;
                case 8: handTotal += 10; break;
                case 9: handTotal += 10; break;
                case 10: handTotal += 10; break;
                case 11: handTotal += 10; break;
                case 12: numAces += 1; break;
            }
        }

        for(int i = 0; i < numAces; i++) {
            if(handTotal >= 11) {
                handTotal += 1;
            }
            else {
                handTotal += 11;
            }
        }

        return  handTotal;

    }

    public String toString() {

        String cardsInTheList = "";

        for(Card aCard : this.deckOfCards) {
           cardsInTheList += aCard.toString() +"\n";
        }
        return cardsInTheList;

    }

}
