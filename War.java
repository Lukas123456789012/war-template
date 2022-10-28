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
        Hand[0].length();
        Hand[0].add();
        System.out.println(deck.getDeckSize()); 
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
