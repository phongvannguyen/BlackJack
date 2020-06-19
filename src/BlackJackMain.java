import java.util.Scanner;

/**
 * @author Phong Van Nguyen
 * @date 10/01/17
 *
 * This class simulates a blackjack game.
 */
public class BlackJackMain {

    public static void main(String [] args) {

        Scanner userInput = new Scanner(System.in);
        int userResponse;

        boolean endGame = false;

        while(!endGame) {

            System.out.println("Welcome Player! May the God of Gambling be with you!");

            // Create the playing deck
            Deck deck = new Deck();
            deck.createDeck();
            deck.shuffle();

            // Create a deck for the player's cards
            Deck playerDeck = new Deck();

            // Create a deck for the dealer's cards
            Deck dealerDeck = new Deck();

            // Player draws two cards.
            playerDeck.draw(deck);
            playerDeck.draw(deck);

            // Dealer draws two cards
            dealerDeck.draw(deck);
            dealerDeck.draw(deck);

            System.out.println("Your Hand: ");
            System.out.print(playerDeck.toString());
            System.out.println("Your deck's value: " + playerDeck.getHandTotal());
            System.out.println();

            System.out.println("Dealer's Hand: ");
            System.out.println(dealerDeck.getCard(0).toString() + "\n\t[HIDDEN]\n");

            boolean haveBlackJack = false;
            // See if either or both players have 21 on their first two cards
            if(playerDeck.getHandTotal() == 21 && dealerDeck.getHandTotal() != 21) {
                System.out.println("You have a blackjack. You are the winner!");
                haveBlackJack = true;
            } else if(playerDeck.getHandTotal() != 21 && dealerDeck.getHandTotal() == 21) {
                System.out.println("Dealer has a blackjack. You lose!");
                haveBlackJack = true;
            } else if(playerDeck.getHandTotal() == 21 && dealerDeck.getHandTotal() == 21){
                System.out.println("Both players have blackjack. It's a tie");
                haveBlackJack = true;
            }

            boolean playerDone = false;
            boolean dealerDone = false;

            while ((!playerDone || !dealerDone) && !haveBlackJack) {

                if (!playerDone) {
                    System.out.println("(1) Hit or (2) Stand?");
                    userResponse = userInput.nextInt();

                    while(userResponse != 1 && userResponse != 2) {
                        System.out.println("Please enter a valid value. (1) Hit or (2) Stand");
                        userResponse = userInput.nextInt();
                    }

                    // hit
                    if (userResponse == 1) {
                        playerDeck.draw(deck);
                        System.out.println("Your Hand: ");
                        System.out.print(playerDeck.toString());
                        System.out.println("You deck's value: " + playerDeck.getHandTotal() + "\n");

                        if (playerDeck.getHandTotal() > 21) {
                            System.out.println("You Bust!");
                            playerDone = true;
                        }
                    } else {
                        playerDone = true;
                    }
                }

                if (!dealerDone) {
                    if (dealerDeck.getHandTotal() < 17) {
                        System.out.println("The dealer hits");
                        dealerDeck.draw(deck);
                    } else {
                        System.out.println("The dealer stands");
                        dealerDone = true;
                    }
                }

                System.out.println();
            }

            /* If either player's first two dealt cards do not add up
                to  21, then this will commence. */
            if(!haveBlackJack) {
                /*
                These print out the final hands of both player's and dealer's
                 */
                System.out.println("Your Hand: ");
                System.out.print(playerDeck.toString());
                System.out.println("Your deck's value: " + playerDeck.getHandTotal() + "\n");

                System.out.println("Dealer's Hand: ");
                System.out.print(dealerDeck.toString());
                System.out.println("Dealer's deck's value: " + dealerDeck.getHandTotal());
                System.out.println();

                int playerTotal = playerDeck.getHandTotal();
                int dealerTotal = dealerDeck.getHandTotal();
                // Conditions for player to win.
                if ((playerTotal > dealerTotal && playerTotal <= 21)
                        || (playerTotal <= 21 && dealerTotal > 21)) {
                    System.out.println("You win this hand!!!");
                }
                // Conditions for dealer to win.
                else if ((playerTotal != dealerTotal && dealerTotal <= 21)
                        || (playerTotal > 21 && dealerTotal <= 21)
                        || (playerTotal > 21 && dealerTotal > 21)) {
                    System.out.println("Dealer wins this hand!!!");
                } else {
                    System.out.println("It's a tie!!!");
                }
            }
            System.out.println("Would you like to play again? (1) Yes (2) No");
            userResponse = userInput.nextInt();

            while(userResponse != 1 && userResponse != 2) {
                System.out.println("Please enter a valid value. (1) Yes or (2) No");
                userResponse = userInput.nextInt();
            }

            if (userResponse == 2) {
                endGame = true;
            }

        }
        // close scanner;
        userInput.close();

        System.out.println("Thank you for playing!");
    }
}
