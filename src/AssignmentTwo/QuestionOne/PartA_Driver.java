package AssignmentTwo.QuestionOne;

// import statements

import java.util.Random;
import java.util.Scanner;

/**
 * ACS-2947 | Assignment Two <br>
 * Implementation of driver code for the first question. The code at hand tries to recreate the
 * game called Simon.
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentTwo">Assignment Two GitHub</a>
 */
public class PartA_Driver
{
    // a static arraylist of colours
    // using it in a static manners escapes the need of passing it into different methods
    static ArrayList<String> colours = new ArrayList<>();         // list of the colours

    public static void main(String[] args)
    {
        // instance variables
        ArrayList<String> compColours = new ArrayList<>();     // colours list of the computer

        int turn = 1;                                          // number of turns
        int score = 0;                                         // score of the user
        boolean continueGame = true;                           // tells if the game can be continued

        // initialising a scanner to get userInout
        Scanner kb = new Scanner(System.in);

        // calling a method that fills the arraylist with colours
        // the only reason to create a particular method is to keep main clean
        fillColours();

        // greeting message
        System.out.println("Let's play Simon!\n");

        // starting a loop while the came is to be continued
        while(continueGame)
        {
            // creating a new arrayList of playerColours that gets empty every turn
            ArrayList<String> playerColours = new ArrayList<>();   // colours list of the player

            // starting a try-catch to use Thread.sleep()
            // setting compColors to be as many values as the current turn
            compColours = getRandomColor(turn);

            // printing the compColours using a for each loop
            for (String colour : compColours)
                System.out.println(colour);

            try
            {
                Thread.sleep(5000);                 // sleeping the thread for five seconds

                /* ------------ SIDE NOTE AND EXPLANATION --------------------
                    I am using IntelliJ to code and even after extensive search over the internet.
                    I cannot seem to find a way to clear the terminal as IntelliJ terminal is not a
                    terminal but a windows log.txt file.
                    Which is why text can only be added but not removed from it, and I am too lazy
                    (I know I shouldn't say this) to check it on another application.
                    So I am printing quite a few new lines to move away from the computer input!
                 */
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            } // end of try
            catch(InterruptedException e)
            {
                System.out.println("An error occurred: " + e.getMessage());
            } // end of catch

            // getting userInput using a loop
            for (int i = 0; i < compColours.size(); i++) {
                String userInput = kb.next().trim().toLowerCase();
                playerColours.add(userInput);
            } // end of for loop

            if (compColours.equals(playerColours)) {
                score++;
                System.out.println("Correct! Your current score is " + score);
                turn++;
            } // end of if
            else {
                continueGame = false;
                System.out.println("Game over! Your score is " + score);

            } // end of else

            System.out.println();                         // white space
        } // end of while loop

    } // end of main

    /**
     * Static method that populates the colour playlist with eight different colours
     */
    public static void fillColours()
    {
        colours.add("red");
        colours.add("blue");
        colours.add("yellow");
        colours.add("green");
        colours.add("orange");
        colours.add("purple");
        colours.add("black");
        colours.add("white");

    } // end of fillColours()

    /**
     * A static method that returns a list of random colours to the main method where they can be used to match
     * against the player colours
     * @param number number colours to be added
     * @return arraylist filled with random colours
     */
    public static ArrayList<String> getRandomColor(int number)
    {
        ArrayList<String> randomColours = new ArrayList<>();         // ArrayList that will hold colours
        Random rnd = new Random();                                   // initialising a new random
        int count = 0;                                               // setting a counter-variable

        // starting a while loop that runs until count matches number
        while(count < number)
        {
            int randomColour = rnd.nextInt(colours.size());         // getting a random index
            String colour = colours.get(randomColour);              // colour from the random index
            randomColours.add(colour);                              // adding colour from random index to the array
            count++;                                                // increasing the count
        } // end of while

        return randomColours;                                       // returning the array

    } // end of String

} // end of class
