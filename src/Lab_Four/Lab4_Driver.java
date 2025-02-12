package Lab_Four;

/**
 * ACS-2947 | Lab Four
 * Create a java program that fulfills the requirements from the given lab question
 *
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Lab_Four">Github</a>
 */

public class Lab4_Driver
{
    public static void main(String[] args)
    {
        // instantiating a new LinkedPositionalList
        LinkedPositionalList<Character> list = new LinkedPositionalList<>();

        Position<Character> cursor;             // declaring a cursor that will hold the position

        // adding said values to the list
        // since the ascii value of A is 65 and that of O is 79,
        // we can use a for loop to traverse in the list and add the said values to the list
        for(int i = 65; i <= 79; i++)
        {
            list.addFirst((char) i);
        } // end of for loop

        cursor = list.first();          // setting cursor to be the first element

        System.out.println("Q2a");
        answerPrint(cursor, list);

        // ------ Question 2b - Move the cursor to G --------

        // the ninth position 'G' would be at index 8, therefore looping until 7 and 'G' is accessed
        // since it is after the element that is at index 7
        for (int i = 0; i < 8; i++)
        {
            cursor = list.after(cursor);
        } // end of for loop

        System.out.println("Q2b");
        answerPrint(cursor, list);

        // ----- Question 2c - Add Q before and P after the cursor ------

        list.addAfter(cursor, 'P');             // adding P after the cursor
        list.addBefore(cursor, 'Q');            // adding Q before the cursor

        System.out.println("Q2c");
        answerPrint(cursor, list);

        // ------ Question 2d - Move the cursor backwards, 5 positions -------

        // since we have to move five positions before the current position
        // setting up a var of value 5 and decrementing in a while loop
        int move = 5;
        while(move > 0)
        {
            cursor = list.before(cursor);
            move--;
        } // end of while

        move = 0;                       // safely setting move to 0
        System.out.println("Q2d");
        answerPrint(cursor, list);

        // ------ Question 2e - Set value at cursor to Y, delete item before cursor -------

        list.set(list.after(cursor), 'Y');                  // setting the current position to be Y
        list.remove(list.before(cursor));       // removing value before the cursor

        System.out.println("Q2e");
        answerPrint(cursor, list);

        // ------- Question 2f - Move forward six and change the letter to S ------

        // since we have to move six positions after the current positions
        // setting up move to be six and decrementing the loop
        move = 6;
        while(move > 0)
        {
            cursor = list.after(cursor);
            move--;
        } // end of while

        // setting the current position to be S
        list.set(cursor, 'S');

        move = 0;                               // safely setting move back to 0
        System.out.println("Q2f");
        answerPrint(cursor, list);

        // ------ Question 2g - Add letter A in the first position -------

        list.addFirst('A');

        System.out.println("Q2g");
        answerPrint(cursor, list);

        // ------- Question 2h - Reset cursor and remove all elements with odd ascii number -----

        cursor = list.first();              // resetting the cursor

        int size = list.size();

        while (size > 0)
        {
            Position<Character> nextPosition =  list.first();

            if (list.after(cursor) != null)
                nextPosition = list.after(cursor);

            int asciiValue = (int) cursor.getElement();         // get the ascii value of the current element

            if (!(asciiValue % 2 == 0))
                list.remove(cursor);                            // removing if the ascii value is odd

            cursor = nextPosition;                        // setting the cursor to be the next position

            size--;
        } // end of while

        System.out.println("Q2h");
        answerPrint(cursor, list);

        // ------ Question 2i - Add letter z to the end of the list

        // getting the size of the list
        size = list.size();

        // starting a while loop as long as size - 1 > 0
        // the reason for size -1 is that we are using list.after which pushes the size to one more
        // thus balancing them both
        while((size - 1) > 0)
        {
            cursor = list.after(cursor);
            size--;
        } // end of while

        // add after the cursor, since the cursor is add last postion
        list.addAfter(cursor, 'Z');

        /*
        //Alternate Method (Possibly):

        cursor = list.last();
        list.addAfter(cursor, 'Z');
         */

        System.out.println("Q2i");
        answerPrint(cursor, list);

        System.out.println("Entries remaining in the list: " + list.size());

    } // end of main()

    public static void answerPrint(Position<Character> cursor, LinkedPositionalList<Character> list)
    {
        System.out.println("Cursor is at: " + cursor.getElement());
        System.out.println("LPL Contents: " + list);
        System.out.println();

    } // end of answerPrint

} // end of class
