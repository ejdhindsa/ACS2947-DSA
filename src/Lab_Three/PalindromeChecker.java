package Lab_Three;

// import statements
import java.util.*;

public class PalindromeChecker
{
    public static void main(String[] args)
    {
        // creating an ArrayStack with a default capacity of 1000
        ArrayStack<String> stack = new ArrayStack<>();

        // creating a scanner to take input from the user
        Scanner kb = new Scanner(System.in);

        System.out.println("Enter word, phrase, or sentence: ");
        String userInput = kb.nextLine();       // taking input from the user

        // now we need to strip the entered sentence of any special characters,
        // or whitespaces and push them into the stack
        char[] userChar = userInput.toCharArray();

        for (int i = 0; i < userChar.length; i++)
        {
            if(Character.isLetter(userChar[i]) || Character.isDigit(userChar[i]))
            {
                // since push works only with one data type, we need to convert char
                String word = Character.toString(userChar[i]);
                stack.push(word);

                //System.out.print(userChar[i]);
            } // end of if conditional

        } // end of for loop

        System.out.println(stack);

    } // end of main

} // end of PalindromeChecker
