package AssignmentOne.QuestionOne;

// import statements
import java.util.Random;

/**
 * ACS-2927 | Assignment One <br>
 * Implementation of a Die class that creates a Die object with a given set of faces, which correspond to the
 * face values that the die can have.
 * It is an auxiliary class that supports the Dice class.
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Assignment_One">GitHub</a>
 */

public class Die
{
    // instance variables of die class
    private int faces;              // total faces of a die
    private int faceValue;          // value that a die can roll

    /**
     * No-argument constructor that instantiates a die object with a default face value of six.
     * This is a fall-back measure as required by the assignment that the default value a die should roll
     * should be of six.
     */
    public Die()
    {
        this(6);    // default face-value set to six
    }  // end of no-arg constructor

    /**
     * Full-argument constructor of the die class that creates a die with the face value as passed as
     * an argument by the user.
     * @param faces faces of the die
     */
    public Die(int faces)
    {
        this.faces = faces;
    } // end of full argument constructor

    // -------- Utility Methods --------

    /**
     * Public method that rolls the die with the minimum value of one to the maximum value as same as
     * the face of the die.
     * The rolDie() method uses Random class from the Java library to generate the random values within
     * the given interval.
     * @return outcome of rolled die
     */
    public int rollDie()
    {
        Random rnd = new Random();
        faceValue = rnd.nextInt(faces) + 1;     // since the seed is from 0 to faces not including faces

        return faceValue;
    } // end of rollDie

    /**
     * Overridden toString method that creates a toString of the faceValue of the die and returns to the user.
     * @return toString of the linked-list
     */
    @Override
    public String toString()
    {
        // creating a StringBuilder just for returning the face value seemed like an overkill but used
        // a StringBuilder to follow course instructions
        StringBuilder sb = new StringBuilder();
        sb.append(faceValue);

        return sb.toString();
    } // end of toString()

} // end of Die
