// package statement
package AssignmentTwo.QuestionTwo;

/**
 * ACS-2947 | Assignment Two <br>
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentTwo">Assignment Two GitHub</a>
 */
public class PartB_Driver
{
    public static void main(String[] args)
    {
        // initializing ArrayPositionalLists to match the assignment criteria
        // all the lists are of default capacity of 16, didn't see a massive reason
        // as to why they should be anything else
        ArrayPositionalList<String> listOne = new ArrayPositionalList<>();
        ArrayPositionalList<String> listTwo = new ArrayPositionalList<>();
        ArrayPositionalList<String> listThree = new ArrayPositionalList<>();
        ArrayPositionalList<String> listFour = new ArrayPositionalList<>();
        ArrayPositionalList<String> listFive = new ArrayPositionalList<>();

        // --------------------- POPULATING THE LISTS ----------------------

        // ************* First List ***************
        listOne.addLast("harry");
        listOne.addLast("will");
        listOne.addLast("tom");
        listOne.addLast("tom");
        listOne.addLast("tom");
        listOne.addLast("charles");

        printList(listOne);
        // ********** End of First List **********

        // ************ Second List **************
        listTwo.addLast("harry");
        listTwo.addLast("harry");
        listTwo.addLast("tom");
        listTwo.addLast("will");
        listTwo.addLast("meg");
        listTwo.addLast("harry");

        printList(listTwo);
        // ********* End of Second List *********

        // ************* Third List *************
        Position<String> first = listThree.addFirst("tom");
        Position<String> last = listThree.addLast("meg");
        Position<String> second = listThree.addAfter(first, "will");
        Position<String> third = listThree.addAfter(second, "ekam");
        listThree.set(third, "harry");
        listThree.addBefore(last, "charles");

        printList(listThree);
        // ********** End of Third List *********

        // ************ Fourth List *************
        listFour.addLast("meg");
        listFour.addLast("meg");
        listFour.addLast("tom");
        listFour.addLast("tom");
        listFour.addLast("tom");
        listFour.addLast("tom");
        listFour.addLast("harry");

        printList(listFour);
        // ******** End of Fourth List ********

        // ************* Fifth List *************
        listFive.addLast("meg");
        listFive.addLast("meg");
        listFive.addLast("tom");
        listFive.addLast("james");
        listFive.addLast("charles");
        listFive.addLast("charles");
        listFive.addLast("james");
        listFive.addLast("harry");
        listFive.addLast("harry");
        listFive.addLast("harry");

        printList(listFive);
        // ********** End of Fifth List *********

        // ----------------------------- PART B : INSERTION SORT -----------------------

        // instantiating an ArrayPositionalList to hold the unsorted array
        ArrayPositionalList<Character> unsortedList = new ArrayPositionalList<>();

        // populating the array
        unsortedList.addLast('A');
        unsortedList.addLast('M');
        unsortedList.addLast('A');
        unsortedList.addLast('Z');
        unsortedList.addLast('I');
        unsortedList.addLast('N');
        unsortedList.addLast('G');
        unsortedList.addLast('R');
        unsortedList.addLast('A');
        unsortedList.addLast('C');
        unsortedList.addLast('E');

        // calling the insertion sort method
        InsertionSort(unsortedList);
        System.out.println("Sorted Characters using Insertion Sort Algorithm: ");
        System.out.println(unsortedList);

    } // end of main

    /**
     * Public static method in which an ArrayPositionalList is passed as a parameter. This method checks and removes
     * all the consecutive duplicates from the list while returning the size of the array with duplicates removed.
     * This penultimately alters the original list.
     * @param list list passed into the program as a parameter
     * @return size of the list with duplicates removed
     */
    public static int removeConsecutiveDuplicates(ArrayPositionalList<String> list)
    {
        if (list.isEmpty())
            return 0;               // if the list is empty return 0

        // setting the current element to be the first element of the list
        Position<String> current = list.first();

        // iterating while the current element isn't the last element
        while (current != list.last())
        {
            // creating a next element to be right after the current element
            Position<String> next = list.after(current);

            // starting an if conditional that checks if the elements match
            if (current.getElement().equals(next.getElement())) {
                list.remove(next);
            }
            else
                current = next;                 // setting the current element to be the next element

        } // end of while

        return list.size();

    } // end of removeConsecutiveDuplicates()

    /**
     * Public sorting method that sorts the list in the ascending order using Insertion Sort Algorithm.
     * The reason why character is used instead of String is that it is just easier to do it with chars than with
     * Strings.
     * @param list list to be sorted
     */
    public static void InsertionSort(ArrayPositionalList<Character> list)
    {
        int size = list.size();                           // size of the list
        Position<Character> current = list.first();

        // starting a for loop to sort the array in non-decreasing order
        for(int i = 1; i < size; i++)
        {
            current = list.after(current);               // setting cursor to be the current element

            // getting the element of the current element
            char cursor = current.getElement();

            // finding the character at the previous position
            Position<Character> previous = list.before(current);

            // Find the current position for the current character
            // the while loop works while the previous element is more than the current element (j > i)
            while (previous.getElement() > cursor)
            {
                // this sets the current shifts the current element to the position of previous
                // i.e. it shifts it left like it is done in a basic insertion sort
                list.set(list.after(previous), previous.getElement());

                // updating the previous so that we keep iterating through the list
                previous = list.before(previous);
            } // end of while

            // This simply inserts after the previous position
            // I was playing around with the code since it was not working nad producing same results at different
            // positions.
            // And I found that I must also put the cursor back into the list as that was not being done in
            // while loop, so I have done it here.
            list.set(list.after(previous), cursor);

        } // end of for

    } // end of insertionSort()

    /**
     * A public utility method that simply prints the list while also calling the removeConsecutiveDuplicates
     * to remove any consecutive duplicates.
     * The reason for the creation of this utility method is just to keep the main method clean and enforce the
     * OOP principle of reusability.
     * @param list lis that is to be printed
     * @see #removeConsecutiveDuplicates(ArrayPositionalList)
     */
    public static void printList(ArrayPositionalList<String> list)
    {
        // printing the list
        System.out.println("Original positional list:");
        System.out.println(list);
        System.out.println();

        // calling the remove duplicates to have the duplicates removed from the list
        int newSize = removeConsecutiveDuplicates(list);

        // printing the new list
        System.out.println("Number of entries after call: " + newSize);
        System.out.println("List with duplicates removed: ");
        System.out.println(list);
        System.out.println();

    } // end of printList

} // end of class

