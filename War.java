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
    Deck[] Hand = new Deck[2];
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
    public void checkWhoWon(Card card1, Card card2) {
        if (card1.getRank() > card2.getRank()) {
            System.out.println("Player 1 has won the draw");
        } else if (card2.getRank() > card1.getRank()) {
            System.out.println("Player 2 has won the draw");
        }
    }
    public void announceCards(Card card1, Card card2) {
        System.out.println("Player 1 has drawn a "+card1.getFace() +" of " +card1.getSuit());
    }
}
