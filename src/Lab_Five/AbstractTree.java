package Lab_Five;

/**
 * ACS-2947 | Lab 5 <br>
 * Abstract base for a Tree
 *
 * @param <E> Generalized type of the Tree
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Lab_Five">GitHub</a>
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

} // end of AbstractTree()
