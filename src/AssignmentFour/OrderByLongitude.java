package AssignmentFour;

// import statements
import java.util.Comparator;

/**
 * ACS-2927 | Assignment Four <br>
 * Comparator class that compares two instances of PostalCodes based on their longitudes.
 * That is, it checks and sorts the postalCodes as their longitudes move from west to east.
 * @param <E> Generic Type input (would be a PostalCode).
 *
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentFour">GitHub</a>
 */
public class OrderByLongitude<E> implements Comparator<PostalCode>
{
    /**
     * Public method that compares two instances of PostalCodes based on their longitudes.
     * That is, it checks and sorts the postalCodes as their longitudes move from west to east.
     * @param objectOne the first object to be compared.
     * @param objectTwo the second object to be compared.
     * @return positive, negative or zero based on the comparison.
     */
    public int compare(PostalCode objectOne, PostalCode objectTwo)
    {
        if (objectOne.getLongitude() < objectTwo.getLongitude())
        {
            return -1;                  // if object two is greater, return negative
        } // end of if
        else if (objectOne.getLongitude() == objectTwo.getLongitude())
        {
            // PSA: This case is not possible since latitudes of two different places cannot be same
            // but putting it here just for the namesake
            return 0;                   // if they are the same, return 0
        } // end of else if

        return 1;                       // if object one is greater return positive
    } // end of compare

} // end of class
