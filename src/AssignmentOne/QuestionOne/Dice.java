package AssignmentOne.QuestionOne;

// import statements
import java.util.ArrayList;

/**
 * ACS-2927 | Assignment One <br>
 * Dice class that instantiates a dice object which is made with two die objects.
 * These two dies are then rolled to get the rolls which are then stored in an arraylist.
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Assignment_One">GitHub</a>
 */

public class Dice
{
    // instance variables for the Dice class
    Die dieOne;                     // first die object
    Die dieTwo;                     // second die object
    ArrayList<Integer> faceValues;  // arraylist of face values

    /**
     * No-argument constructor of the die class that creates a constructor with a default
     * face value of six.
     * The method also instantiates the dies as well as the arraylist.
     */
    public Dice()
    {
        dieOne = new Die(6);
        dieTwo = new Die(6);
        faceValues = new ArrayList<>();

    } // end of no-arg constructor

    /**
     * Semi-argument constructor for the dice class that creates a dice with two dies of
     * the same face value.
     * The method also instantiates the dies as well as the arraylist.
     * @param faces faces that the dies will have
     */
    public Dice(int faces)
    {
        dieOne = new Die(faces);
        dieTwo = new Die(faces);
        faceValues = new ArrayList<>();

    } // end of semi-arg constructor

    /**
     * Full-argument constructor that creates the die object with two dies that may be of
     * different face values independent of each other.
     * The method also instantiates the dies as well as the arraylist.
     * @param faceOne face value of the first die
     * @param faceTwo face value of the second die
     */
    public Dice(int faceOne, int faceTwo)
    {
        dieOne = new Die(faceOne);
        dieTwo = new Die(faceTwo);
        faceValues = new ArrayList<>();

    } // end of full-arg constructor

    /**
     * A roll method that rolls both the dies and stores the role in an arraylist.
     * @return Arraylist with rolls
     */
    public ArrayList<Integer> roll()
    {
        // empty the array so that no extra values are added
        faceValues.clear();

        int rollOne = dieOne.rollDie();         // rolling die one
        int rollTwo = dieTwo.rollDie();         // rolling die two

        // adding the values to the arraylist
        faceValues.add(rollOne);
        faceValues.add(rollTwo);

        return faceValues;
    } // end of roll

    /**
     * Overridden toString method that prints both the rolls to the console
     * @return string value of both the dies
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < faceValues.size(); i++)
        {
            if (i == 0)
                sb.append(faceValues.get(i)).append(", ");
            else
                sb.append(faceValues.get(i));

        } // end of for each
        sb.append("]");

        return sb.toString();

    } // end of toString

} // end of Dice class
