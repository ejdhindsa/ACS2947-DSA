package AssignmentFour;

// import statements
import java.util.Comparator;

/**
 * ACS-2927 | Assignment Four <br>
 * Default Comparator for PostalCode that compares two PostalCodes based on their codes
 * @param <E> Generic Type PostalCode
 *
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentFour">GitHub</a>
 */
public class DefaultComparator<E> implements Comparator<PostalCode>
{
    /**
     * Default comparator for Postal Codes.
     * It compares two postal code based on their codes
     * @param ObjectOne the first object to be compared.
     * @param ObjectTwo the second object to be compared.
     * @return positive, negative or zero based on the code of the postal codes
     */
    public int compare(PostalCode ObjectOne, PostalCode ObjectTwo)
    {
        return ObjectOne.getCode().compareTo(ObjectTwo.getCode());
    } // end of compareTo()
} // end of class
