package Lab_Six;

// import statements
import java.util.ArrayList;
import java.util.Collections;

/**
 * Ekamjot Singh | 3167888 <br>
 * ACS-2947 Lab Six
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Lab_Six">GitHub</a>
 */
public class Lab6_Driver
{
    public static void main(String[] args)
    {
        // creating an arraylist of capacity 12 to have all the months
        ArrayList<Month> months = new ArrayList<>(12);

        // utility method to populate the array
        populateMonths(months);

        // months sorted with no comparator
        System.out.println("Natural Ordering (With No Comparator)");
        for (Month month : months)
            System.out.println(month);
        System.out.println();

        // months sorted with default comparator
        Collections.sort(months, new DefaultComparator());

        System.out.println("Natural ordering (With default comparator):");
        for (Month month : months)
            System.out.println(month);
        System.out.println();

        // months with month Comparator
        MonthComparator monthComparator = new MonthComparator();
        Collections.sort(months, monthComparator);

        System.out.println("Ordering by MonthComparator");
        for (Month month : months)
            System.out.println(month);
        System.out.println();

        // Second part of the lab
        printBinaryNumbers(16);

    } // end of main

    public static void printBinaryNumbers(int n)
    {
        ArrayQueue<String> binaryNumbers = new ArrayQueue<>();

        binaryNumbers.enqueue("1");

        // converting integers into binary literals in a loop\
        for (int i = 0; i < n; i++)
        {
            String first = binaryNumbers.first();
            binaryNumbers.enqueue(first + "0");
            binaryNumbers.enqueue(first + "1");

            System.out.print(binaryNumbers.dequeue());
            System.out.print(" ");

        } // end of for loop
        System.out.println();

        for (String element: binaryNumbers) {
            System.out.print(element + " ");
        } // end enhanced-for
        System.out.println();

        binaryNumbers.clear();
        System.out.println(binaryNumbers);

    } // end of printBinaryNumbers

    /**
     * Utility methods that populates the arraylist with all the months as required by the lab instructions,
     * the only reason for creating this method is to keep the main method clean
     * @param months arraylist in which months are to be added
     */
    public static void populateMonths(ArrayList<Month> months)
    {
        months.add(new Month("January", 1, 31, 21));
        months.add(new Month("February", 2, 28, 20));
        months.add(new Month("March", 3, 31, 23));
        months.add(new Month("April", 4, 30, 21));
        months.add(new Month("May", 5, 31, 22));
        months.add(new Month("June", 6, 30, 22));
        months.add(new Month("July", 7, 31, 21));
        months.add(new Month("August", 8, 31, 23));
        months.add(new Month("September", 9, 30, 22));
        months.add(new Month("October", 10, 31, 21));
        months.add(new Month("November", 11, 30, 22));
        months.add(new Month("December", 12, 31, 22));

    } // end of populateMonths

} // end of Lab6_Driver
