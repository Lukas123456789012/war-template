import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    Deck deck = new Deck();
    Deck[] Hand = new Deck[3];
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        // ...then run the event loop
        this.runEventLoop();
    }

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        deck.initializeNewDeck();
        deck.shuffle();
        Hand = deck.dealDeck();
        Hand[0].getDeckSize();
        for (int i = 0; i < 300; i++) {
            if (checkWinner() == 1 ||checkWinner() == 2) {
                break;
            } 
            Card card1 = drawP1Card();
            Card card2 = drawP2Card();
            announceCards(card1,card2);
            if (checkWhoWon(card1,card2) == 1) {
                System.out.println("Player 1 has won the draw");
                Hand[0].addCardToDeck(card1);
                Hand[0].addCardToDeck(card2);
            } else if (checkWhoWon(card1, card2) == 2) {
                System.out.println("Player 2 has won the draw");
                Hand[1].addCardToDeck(card1);
                Hand[1].addCardToDeck(card2);  
            } else if (checkWhoWon(card1, card2) == 3) {
                System.out.println("It is a tie. A war will now commence");
                war();
            }
            System.out.println("Player 1 has " + Hand[0].getDeckSize() + " Cards.");
            System.out.println("Player 2 has " + Hand[1].getDeckSize() + " Cards.");        
        }
    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

    public int checkWinner() {
        int winner = 0;
        if (Hand[0].getDeckSize() == 0) {
            System.out.println("Player 2 is the Winner!");
            winner = 2;
        } else if (Hand[1].getDeckSize() == 0) {
            System.out.println("Player 1 is the Winner!");
            winner = 1;
        }
        return winner;
    }

    public Card drawP2Card() {
        Card i = Hand[1].dealCardFromDeck();
        return i;
    }

    public Card drawP1Card() {
        Card i = Hand[0].dealCardFromDeck();
        return i;
    }

    public int checkWhoWon(Card card1, Card card2) {
        int i = 0;
        if (card1.getRank() > card2.getRank()) {

            i = 1;
        } else if (card2.getRank() > card1.getRank()) {

            i = 2;
        } else if (card1.getRank() == card2.getRank()) {

            i = 3;
        }
        return i;
    }

    public void announceCards(Card card1, Card card2) {
        System.out.println("Player 1 has drawn a "+card1.getFace() +" of " +card1.getSuit());
        System.out.println("Player 2 has drawn a "+card2.getFace() +" of " +card2.getSuit());
    }

    public void war () {
        for (int i = 0; i < 4 && Hand[0].getDeckSize() != 1; i++) {
            Card card1 =Hand[0].dealCardFromDeck();
            Hand[2].addCardToDeck(card1);
        }
        Card card1 = Hand[0].dealCardFromDeck();
        for (int i = 0; i < 4 && Hand[1].getDeckSize() != 1; i++) {
            Card card2 =Hand[1].dealCardFromDeck();
            Hand[2].addCardToDeck(card2);
        }
        Card card2 = Hand[1].dealCardFromDeck();
        System.out.print("Player 1 has drawn a " + card1.getSuit() + " of " + card1.getRank() +".");
        System.out.print("Player 1 has drawn a " + card2.getSuit() + " of " + card2.getRank() +".");
        if (card1.getRank() > card2.getRank()) {
            System.out.println("Player 1 has won the war! they will now get 10 cards.");
            boolean idx = false; 
            while( idx = false ) {
                Hand[0].addCardToDeck(Hand[2].dealCardFromDeck());
                if (Hand[2].getDeckSize() == 0) {
                    idx = true;
                }
            }
        } else if (card1.getRank() < card2.getRank()) {
            System.out.println("Player 1 has won the war! they will now get 10 cards.");
            boolean idx = false;
            while( idx = false ) {
                Hand[1].addCardToDeck(Hand[2].dealCardFromDeck());
                if (Hand[2].getDeckSize() == 0) {
                    idx = true;
                }
            }
        } else if (card1.getRank() == card2.getRank()){
            boolean idx = false;
            while( idx = false ) {
                Hand[2].addCardToDeck(card1);
                Hand[2].addCardToDeck(card2);
            }
        }
    }
}
