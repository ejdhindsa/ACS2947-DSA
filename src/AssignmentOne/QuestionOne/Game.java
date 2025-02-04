package AssignmentOne.QuestionOne;

import java.util.ArrayList;

/**
 * ACS-2927 | Assignment One <br>
 * This class represents a game where players take turns rolling dice and accumulating scores.
 * The game continues until one player reaches a score of 100 or only one player remains.
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Assignment_One">GitHub</a>
 */
public class Game
{
    // instance variables of the Game class
    CircularDoublyLinkedList<Player> list;          // list of player
    Dice dice;                                      // dice object

    /**
     * No-argument constructor for the Game class that initialises an
     * empty list of players and a new Dice object.
     */
    public Game ()
    {
        list = new CircularDoublyLinkedList<>();
        dice = new Dice();
    } // end of no-arg constructor

    /**
     * Full-argument constructor for the Game class that initialises
     * the game with a predefined list of players and a new Dice object.
     * @param list A CircularDoublyLinkedList containing the players.
     */
    public Game (CircularDoublyLinkedList<Player> list)
    {
        this.list = list;
        this.dice = new Dice();
    } // end of full arg constructor

    // ------- Utility Methods -------

    /**
     * Adds a player to the game.
     * The player is added to the end of the circular doubly linked list.
     * @param player The player to be added to the game.
     */
    public void addPlayer(Player player)
    {
        list.addLast(player);
    } // end of addPlayer

    /**
     * Public method that initiates and runs the game.
     * Players take turns rolling dice, and their scores are updated based on the dice outcomes.
     * The game continues until one player reaches a score of 100 or only one player remains.
     * Eliminated players are tracked and displayed at the end of the game.
     */
    public void initiateGame()
    {
        System.out.println();
        int count = 0;
        ArrayList<String> eliminatedPlayers = new ArrayList<>();
        boolean scoredHundred = false;

        // while the list size is greater than one and nobody has scored a hundred
        while (list.size() > 1 && !scoredHundred)
        {
            Player currentPlayer = list.first();        // get the first player on the list
            ArrayList<Integer> rolls = dice.roll();     // roll dice for the player

            // store the dice values and the sum in variables
            int rollOne = rolls.get(0);
            int rollTwo = rolls.get(1);
            int sum = rollOne + rollTwo;

            System.out.print(currentPlayer.getName() + " rolled " + rollOne + " and " + rollTwo + ".");

            // ------ CASE CHECKS ------

            // if either of the rolls is a two: double the score
            if (rollOne == 2 || rollTwo == 2)
            {
                sum *= 2;
                currentPlayer.addScore(sum);
                System.out.println("Lucky 2, score is now " + currentPlayer.getScore());

            } // end of if statement

            // if the sum of the rolls is seven: subtract seven from the score
            else if (sum == 7)
            {
                currentPlayer.removeScore(7);
                System.out.println("Unlucky 7, score is now " + currentPlayer.getScore());
            } // end of else-if

            // if both the rolls are one: remove player from the game
            else if (rollOne == 1 && rollTwo == 1)
            {
                list.removeFirst();
                System.out.println("Snake eyes! Player removed :(");
                eliminatedPlayers.add(currentPlayer.getName());
            } // end of else if

            // if both the rolls are six: reset the score are reverse the list
            else if (rollOne == 6 && rollTwo == 6)
            {
                currentPlayer.resetScore();
                list.reverse();
                System.out.println("Double 6, score is now 0. Reverse Direction");
            } // end of else if

            // otherwise, add the sum of rolls to the score
            else
            {
                currentPlayer.addScore(sum);
                System.out.println("Score is now " + currentPlayer.getScore());
            } // end of else

            // set victor if the score of player exceeds or is equal to hundred
            if (currentPlayer.getScore() >= 100)
            {
                scoredHundred = true;
                System.out.println(currentPlayer.getName() + " won the game! :)");
            } // end of if

            // set victor if all but one player are eliminated from the game
            if (list.size() == 1)
            {
                System.out.println(list.first().getName() + " won the game!");
            } // end of if

            // rotate the list to get to the next player
            list.rotate();
            count++;

        } // end of while

        // print stats about the current play through
        System.out.println();
        System.out.println("Final Scores:");
        System.out.println(list);
        System.out.println("Eliminated: " + eliminatedPlayers);

    } // end of inititateGame

} // end of Game()
