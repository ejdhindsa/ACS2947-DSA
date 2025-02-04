package AssignmentOne.QuestionTwo;

// import statements
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ACS-2927 | Assignment One <br>
 * This is a driver class that works as required by the assignment PDF.
 * It prompts the user to buy/sell shares and then gives the description of the shares
 * based on the actions taken by the user
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Assignment_One">GitHub</a>
 */
public class Assign1PartB_Driver
{
    // Using a static the account as that allows us to use the account in any of the methods,
    // this forfeits the use of account in methods as an argument.
    // Like said, the alternative method would be to declare the account in the main method
    // and pass it as an argument to all the other methods as required
    static Account account = new Account();

    public static void main(String[] args)
    {
        // creating a scanner object to take input from the user
        Scanner kb = new Scanner(System.in);
        int userInput = 0;                      // initializing userInput as 0
        boolean correctInput = false;

        do      // a do-while loop that asks the user for input until it is correct
        {
            try
            {
                // calling the displayMenu() method to simply print the statements as required
                displayMenu();
                userInput = kb.nextInt();       // taking userInput from the user
                correctInput = true;
            } // end of try

            catch (InputMismatchException e)
            {
                System.out.println("Input not valid: " + e + " expected: 1 | 2 | 3");
                kb.next();          // consume the invalid token
            } // end of catch

        } while (!correctInput);


        // starting a while loop that works until the user inputs three which quits the loop
        while (userInput != 3)
        {
            if (userInput == 1)          // if the user inputs one, buyShares() is called
            {
                buyShares();             // buyShares() handles the buying of shares
            } // end of if
            else if (userInput == 2)    // if the user inputs two, sellShares is called
            {
                sellShares();           // sellShares() handles selling of the shares
            } // end of if
            else                        // in all other scenarios user exception is thrown
            {
                // IllegalArgumentException is thrown if the value that user entered is not correct
                throw new IllegalArgumentException(
                        "Input not valid: " + userInput
                        + " expected: 1 | 2 | 3"

                ); // end of exception

            } // end of else

            // calling accountInformation that prints brief stats about the account
            accountInformation();

            // statements to match the given output
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println();

            // looping until 3 in entered, displaying the menu and getting new user input
            // each time code the current while loop ends
            displayMenu();
            userInput = kb.nextInt();

        } // end of while loop

        // end program message
        System.out.println("*** end of program ***");

    } // end of main

    /**
     * Public method that prints required messages as based on the assignment
     */
    public static void displayMenu()
    {
        System.out.println("Make a selection:");
        System.out.println("1. Buy shares");
        System.out.println("2. Sell shares");
        System.out.println("3. Quit");

    } // end of displayMenu

    /**
     * Public method that displays the information of the account.
     * It prints the number of total shares and the net values of the shares in the account.
     */
    public static void accountInformation()
    {
        System.out.println("\nTotal shares: " + account.getTotalShares());
        System.out.println("Total shares value: $" + account.getTotalValue());

    } // end of accountInformation()

    /**
     * Public method that handles buying the shares by calling the buyShares() method from the
     * Account class.
     * It takes in two values, the quantity of the shares and the price per share and then passes
     * them as an argument in the buyShares() method
     * @see Account#buyShares(int shareQuantity, int sharePrice)
     */
    public static void buyShares()
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("\nEnter number of shares to buy: ");
        int shareQuantity = kb.nextInt();

        System.out.print("Enter purchase price per share: ");
        int sharePrice = kb.nextInt();

        account.buyShares(shareQuantity, sharePrice);

    } // end of buyShares

    /**
     * Public method that handles the selling of shares by calling the sellShares() method
     * from the Account class.
     * It takes two arguments, the number of shares to be sold and the selling price.
     * @see Account#sellShares(int shareQuantity, int sellingPrice)
     */
    public static void sellShares()
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("\nEnter number of shares to sell: ");
        int shareQuantity = kb.nextInt();
        System.out.print("Enter the selling price per share: $");
        int sellingPrice = kb.nextInt();

        double capitalChanged = account.sellShares(shareQuantity, sellingPrice);

        System.out.println("Capital changed: $" + capitalChanged);

    } // end of sellShares()

} // end of Assign1PartB_Driver
