package AssignmentThree.QuestionTwo;

/*
 * From Data Structures and Algorithms in Java, Sixth Edition, Goodrich et al.
 */

/**
 * ACS-2947 - Assignment Three
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentThree">GitHub</a>
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

} // end of Entry

