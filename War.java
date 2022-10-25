import java.util.List;
import java.util.ArrayList;
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
        System.out.println(deck.getDeckSize());
        Hand = deck.dealDeck();
        System.out.println(deck.getDeckSize()); 
        if (deck.getDeckSize() == 0 ){
            for (int a = 0; a < 300; a++) {
                for ( int b = 0; b < 2; b++) {
                        
                }   
            
            }
        } else {
            System.out.print("error with decks");
        }
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
