package AssignmentThree.QuestionOne;

// import statements
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


/**
 * ACS-2947 - Assignment Three
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentThree">GitHub</a>
 */
public abstract class AbstractTree<E> implements Tree<E>
{
    /**
     * Checks if the passed position is an internal position, i.e. it has
     * at least one child
     * @param p A valid Position within the tree
     * @return true if it is internal, false otherwise
     */
    public boolean isInternal(Position<E> p)
    {
        return numChildren(p) > 0;
    } // end of isInternal()

    /**
     * Checks if the passed position is an external position, i.e. it has no children
     * @param p A valid Position within the tree
     * @return true if it is external, false otherwise
     */
    public boolean isExternal(Position<E> p)
    {
        return numChildren(p) == 0;
    } // end of isExternal()

    /**
     * Checks if the passed position is the root of the tree
     * @param p A valid Position within the tree
     * @return returns true if p is root, false otherwise
     */
    public boolean isRoot(Position<E> p)
    {
        return p == root();
    } // end of isRoot()

    /**
     * Checks if the current tree is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty()
    {
        return size() == 0;
    } // end of isEmpty()

    /**
     * Returns the number of levels separating Position p from the root
     * @param p element whose depth is to be found
     * @return depth of the element
     */
    public int depth(Position<E> p)
    {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    } // end depth()

    /**
     * Returns the height of the subtree rooted at position p
     * @param p subtree of which the height is to be found
     * @return height of the tree
     */
    public int height(Position<E> p)
    {
        int h = 0;
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + height(c));

        return h;
    } // end of height()

    // ---------------- IMPLEMENTATION OF ITERATOR ----------------

    // -------- NESTED ELEMENT ITERATOR -------

    /**
     * This class adapts the iteration produced by positions() to return elements.
     */
    private class ElementIterator implements Iterator<E>
    {
        Iterator<Position<E>> postIterator = positions().iterator();

        /**
         * Returns a boolean value if the postIterator has the next element or not
         * @return true if there is next, false otherwise
         */
        public boolean hasNext() {
            return postIterator.hasNext();
        } // end of hasNext()

        /**
         * Returns the next element
         * @return next element
         */
        public E next() {
            return postIterator.next().getElement();
        } // end of next()

        /**
         * Remove method that removes the postIterator position
         */
        public void remove() {
            postIterator.remove();
        } // end of remove

    } // end of ElementIterator
    // ------------- END OF NESTED SUBCLASS -------------

    /**
     * Returns an iterator of the elements stored in the tree
     * @return iterator of the element stored in the tree
     */
    public Iterator<E> iterator() {
        return new ElementIterator();
    } // end of iterator()

    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot
     * @param p position of the element
     * @param snapshot snapshot to which the passed position is added
     */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot)
    {
        snapshot.add(p);
        for (Position<E> c : children(p))
            preorderSubtree(c, snapshot);
    } // end of preorderSubtree()

    /**
     * Returns an iterable collection of positions of the tree, reported in preorder
     * @return collection of positions of the tree
     */
    public Iterable<Position<E>> preorder()
    {
        List<Position<E>> snapshot = new ArrayList<>();

        if (!isEmpty())
            preorderSubtree(root(), snapshot);

        return snapshot;
    } // end of preorder()

    /**
     * Allows transversal through the positions of the tree
     * @return Iterable of positions
     */
    public Iterable<Position<E>> positions() {
        return preorder();
    } // end of positions()

    /**
     * Adds position of the subtree rooted at Position p to the given snapshot
     * @param p position of the element
     * @param snapshot snapshot to which the passed position is added
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot)
    {
        for (Position<E> c : children(p))
            postorderSubtree(c, snapshot);

        snapshot.add(p);        // for postorder, we add position p after exploring subtree
    } // end of postorderSubtree

    /**
     * Returns an iterable collection of positions of the tree, reported in postorder
     * @return postorder iterable collection of the trees
     */
    public Iterable<Position<E>> postorder()
    {
        List<Position<E>> snapshot = new ArrayList<>();

        if (!isEmpty())
            postorderSubtree(root(), snapshot);

        return snapshot;

    } // end of postorder()

} // end of AbstractTree()
