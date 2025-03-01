package Tree;

/**
 * ACS-2947 | Data Structures and Algorithms <br>
 * From Data Structures and Algorithms in Java, Sixth Edition, Goodrich et al.
 *
 * @author Ekamjot Singh | 3167888
 */
public interface Position<E>
{
    /**
     * Returns the element stored at this position.
     *
     * @return the stored element
     * @throws IllegalStateException if position no longer valid
     */
    E getElement() throws IllegalStateException;

} // end of interface
