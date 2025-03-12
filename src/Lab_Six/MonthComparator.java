package Lab_Six;

import java.util.Comparator;

/**
 * Ekamjot Singh | 3167888 <br>
 * ACS-2947 Lab Six
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Lab_Six">GitHub</a>
 */
public class MonthComparator implements Comparator<Month>
{
    /**
     * Compare method that compares two months.
     * The criteria for comparing two months is as follows:
     *  The month with higher number of working days comes first
     *  If working days are same then the month with higher number of days takes precedence
     *  If the number of days is the same, they are arranged in alphabetical order
     * @param a the first object to be compared.
     * @param b the second object to be compared.
     * @return compared int based on what if-else conditional runs
     */
    public int compare(Month a, Month b)
    {
        if (a.freeDays() < b.freeDays())
        {
            return -1;
        } // end of if
        else if (a.freeDays() == b.freeDays())
        {
            if (a.days > b.days)
                return -1;
            else if (a.days == b.days)
            {
                return a.monthName.compareTo(b.monthName);
            } // end of else-if
        } // end of else-if

        return 1;

    } // end of compare

} // end of MonthComparator
