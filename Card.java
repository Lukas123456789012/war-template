
/**
 * Implement a playing card
 *
 * @author Mr. Jaffe
 * @version 2022-10-18
 */
public class Card
{
    // instance variables - replace the example below with your own
    private int rank;
    private String face;

    /**
     * Constructor for objects of class Card
     */
    public Card(int rank, String face)        
    {
        this.rank = rank;
        this.face = face;
    }

    public int getRank() {
        return this.rank;
    }

    public String getFace() {
        return this.face;
    }
}
