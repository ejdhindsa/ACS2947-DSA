/*****************************************************************************************
 * ACS-2947 | Lab Three
 * @author Ekamjot Singh
 * Student ID: 3167888
 * GitHub Link : https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Lab_Three
 ****************************************************************************************/

package Lab_Three;

// import statements
import java.util.*;

public class PalindromeChecker
{
    public static void main(String[] args)
    {
        // creating an ArrayStack with a default capacity of 1000
        Stack<Character> stack = new ArrayStack<>();

        // boolean value to check if it is boolean or not
        boolean isPalindrome = true;

        // creating a scanner to take input from the user
        Scanner kb = new Scanner(System.in);

        System.out.println("Enter word, phrase, or sentence: ");
        String userInput = kb.nextLine();       // taking input from the user

        // now we need to strip the entered sentence of any special characters,
        // or whitespaces and push them into the stack
        char[] userChar = userInput.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < userChar.length; i++)
        {
            if(Character.isLetter(userChar[i]))
            {
                sb.append(userChar[i]);
                count++;
                //System.out.print(userChar[i]);
            } // end of if conditional

        } // end of for loop

        String cleanString = sb.toString();
        char[] clean = cleanString.toLowerCase().toCharArray();

        for (int i = 0; i < count; i++)
        {
            stack.push(clean[i]);
        } // end of for
        ;

        // now the values have been pushed, so that the element pushed in the end,
        // is the element that rests on the top

        for(int i = 0; i < count; i++)
        {
            if(Character.isLetter(clean[i]))
            {
                char ch = stack.pop();
                if (ch != clean[i])
                    isPalindrome = false;
            } // end of if
        } // end of for

        String endMessage = isPalindrome ? "\tis a palindrome" : "\tis not a palindrome";
        System.out.println(endMessage);

    } // end of main

} // end of PalindromeChecker
