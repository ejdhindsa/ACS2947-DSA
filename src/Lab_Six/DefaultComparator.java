package Lab_Six;

import java.util.Comparator;

/**
 * Ekamjot Singh | 3167888 <br>
 * ACS-2947 Lab Six
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Lab_Six">GitHub</a>
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
    public int compare(E a, E b) throws ClassCastException
    {
        return((Comparable<E>) a).compareTo(b);

    } // end of compare()

} // end of DefaultComparator
