package AssignmentFour;

/**
 * ACS-2927 | Assignment Four <br>
 * Entry Interface for a key-value pair.
 * From Data Structures and Algorithms in Java, Sixth Edition, Goodrich et al.
 * @param <K> Key of the Entry
 * @param <V> Value of the Entry
 *
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentFour">GitHub</a>
 */
public interface Entry<K,V>
{

    /**
     * Returns the key stored in this entry.
     * @return the entry's key
     */
    K getKey();

    /**
     * Returns the value stored in this entry.
     * @return the entry's value
     */
    V getValue();

} // end of class

