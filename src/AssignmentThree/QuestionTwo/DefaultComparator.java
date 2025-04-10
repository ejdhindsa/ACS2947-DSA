package AssignmentThree.QuestionTwo;

import java.util.Comparator;

/**
 * ACS-2947 - Assignment Three
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentThree">GitHub</a>
 */
public class DefaultComparator<E> implements Comparator<E>
{
    /**
     * Default comparator to compare two entities
     * @param a the first object to be compared.
     * @param b the second object to be compared.
     * @return compared values from two entities
     * @throws ClassCastException thrown when code attempts to cast an object to a subclass
     * of which it is not an instance
     */
    public int compare(E a , E b) throws ClassCastException
    {
        return ((Comparable<E>) a).compareTo(b);
    } // end of compare

} // end of DefaultComparator
