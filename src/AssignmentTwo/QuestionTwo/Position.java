package AssignmentTwo.QuestionTwo;

/**
 * ACS-2947 | Assignment Two <br>
 * From Data Structures and Algorithms in Java, Sixth Edition, Goodrich et al.
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentTwo">Assignment Two GitHub</a>
 */
public interface Position<E> {
    /**
     * Returns the element stored at this position.
     *
     * @return the stored element
     * @throws IllegalStateException if position no longer valid
     */
    E getElement() throws IllegalStateException;
}
