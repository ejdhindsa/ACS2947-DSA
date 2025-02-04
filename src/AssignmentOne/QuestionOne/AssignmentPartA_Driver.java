package AssignmentOne.QuestionOne;

/**
 * ACS-2927 | Assignment One <br>
 * Driver file to the first part of the assignment.
 * All the driver file does is to create four players, create a new game session and
 * add players to the said game session.
 * Alternatively, you can also create a CircularDoublyLinkedList of players and instantiate
 * the game class.
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Assignment_One">GitHub</a>
 */
public class AssignmentPartA_Driver
{
    public static void main(String[] args)
    {
        // instantiating players
        // instantiation of players have been hardcoded as the assignment PDF suggests
        // creating four players to check the code
        Player playerOne = new Player("Alvin");         // player one - Alvin
        Player playerTwo = new Player("Simon");         // player two - Simon
        Player playerThree = new Player("Theodore");    // player three - Theodore
        Player playerFour = new Player("David");        // player four - David

        // instantiating a game session
        Game gameSession = new Game();

        // adding players to the game session
        gameSession.addPlayer(playerOne);
        gameSession.addPlayer(playerTwo);
        gameSession.addPlayer(playerThree);
        gameSession.addPlayer(playerFour);

        // calling initiate game to start the game
        gameSession.initiateGame();

        // Alternatively, this could have been done as well:
        /*
        CircularDoublyLinkedList<Player> linkedList = new CircularDoublyLinkedList<>();
        linkedList.addLast(playerOne);
        linkedList.addLast(playerTwo);
        linkedList.addLast(playerThree);
        linkedList.addLast(playerFour);

        Game alternateSession = new Game(linkedList);
        */

    } // end of main

} // end of AssignmentPartA_Driver
