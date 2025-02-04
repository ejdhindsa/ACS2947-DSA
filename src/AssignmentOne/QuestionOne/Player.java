package AssignmentOne.QuestionOne;

/**
 * ACS-2927 | Assignment One <br>
 * This class represents a Player in a game, with a name and a score.
 * The class provides methods to manipulate the player's score and retrieve player information.
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Assignment_One">GitHub</a>
 */

public class Player
{
    // instance variables of the player class
    private String name;
    private int score;

    /**
     * No-argument constructor for the Player class that creates a player object.
     */
    public Player()
    {
        this.name = "unknown";
    } // end of no-arg constructor

    /**
     * Full-argument constructor for the Player class that creates a player object with the
     * passed as an argument to the class.
     * @param name The name of the player
     */
    public Player(String name)
    {
        this.name = name;
    } // end of full arg constructor

    /**
     * Retrieves the name of the player.
     * @return The name of the player
     */
    public String getName()
    {
        return name;
    } // end of getName()

    /**
     * Retrieves the current score of the player.
     * @return The current score of the player
     */
    public int getScore()
    {
        return score;
    } // end of getScore()

    /**
     * Adds the specified amount to the player's score.
     * @param score The amount to be added to the player's score
     */
    public void addScore(int score)
    {
        this.score += score;
    } // end of addScore()

    /**
     * Subtracts the specified amount from the player's score.
     * If the score goes below 0, it is set to 0.
     * @param score The amount to subtract from the player's score
     */
    public void removeScore(int score)
    {
        this.score -= score;
        if (this.score < 0)         // is score is less than 0, set it to zero
            this.score = 0;

    } // end of removeScore()

    /**
     * Resets the player's score to 0.
     */
    public void resetScore()
    {
        this.score = 0;
    } // end of resetScore

    /**
     * Returns a string representation of the player object
     * The format is "name: score".
     * @return A string representation of the player
     */
    @Override
    public String toString()
    {
        // creating a StringBuilder to create toString for the player object
        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append(": ");
        sb.append(score);

        return sb.toString();

    } // end of toString()

} // end of Player()
