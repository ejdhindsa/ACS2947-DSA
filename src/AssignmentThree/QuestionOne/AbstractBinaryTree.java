package AssignmentThree.QuestionOne;

import java.util.ArrayList;
import java.util.List;

/**
 * ACS-2947 - Lab 5
 * An abstract base class providing some functionality of the BinaryTree interface
 * @param <E> generalised variable to be used in the class
 *
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Lab_Five">GitHub</a>
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E>
                                            implements BinaryTree<E>
{
    /**
     * A Returns the position of p's sibling (or null if no sibling exists)
     * @param p A valid Position within the tree
     * @return position of p's sibling
     */
    public Position<E> sibling(Position<E> p)
    {
        Position<E> parent = parent(p);

        if (parent == null)
            return null;                    // p must be the root

        if (p == left(parent))              // p is a left child
            return right(parent);           // right child may be null
        else                                // p is a right child
            return left(parent);            // left child may be null

    } // end of sibling()

    /**
     * Public method that returns the children of Position p
     * @param p A valid Position within the tree
     * @return number of children of p
     */
    public int numChildren(Position<E> p)
    {
        int count = 0;

        if (left(p) != null)
            count++;                // increase count if left exits
        if (right(p) != null)
            count++;                // increase count if right exists

        return count;

    } // end of numChildren()

    /**
     * Returns an iterable collection of the Positions representing p's children
     * @param p A valid Position within the tree
     * @return iterable of the children
     */
    public Iterable<Position<E>> children(Position<E> p)
    {
        List<Position <E>> snapshot = new ArrayList<>(2);

        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));

        return snapshot;

    } // end of children()

    // ------------ TRANSVERSAL ALGORITHM ---------------

    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot
     * @param p Position p at which subtree is rooted
     * @param snapshot snapshot in which all the values are saved
     */
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot)
    {
        if (left(p) != null)
            inorderSubtree(left(p), snapshot);
        snapshot.add(p);

        if (right(p) != null)
            inorderSubtree(right(p), snapshot);

    } // end of inorderSubtree

    /**
     * Returns an iterable collection of positions of the tree, reported in inorder
     * @return iterable collection of positions
     */
    public Iterable<Position<E>> inorder()
    {
        List<Position<E>> snapshot = new ArrayList<>();

        if (!isEmpty())
            inorderSubtree(root(), snapshot);

        return snapshot;
    } // end of inorder()

} // end of AbstractBinaryTree()
