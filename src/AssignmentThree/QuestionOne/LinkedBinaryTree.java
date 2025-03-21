package AssignmentThree.QuestionOne;

/**
 * ACS-2947 - Assignment Three
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentThree">GitHub</a>
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E>
                                 implements BinaryTree<E>
{
    // ----------- NESTED NODE CLASS --------------

    protected static class Node<E> implements Position<E>
    {
        private E element;                  // element stored in the node
        private Node<E> parent;             // reference to parent node
        private Node<E> left;               // reference to left child
        private Node<E> right;              // reference to right child

        /**
         * Constructs a node with given elements and neighbours
         * @param element element present in the node
         * @param above parent or the node above the current element
         * @param leftChild the left child of the node
         * @param rightChild the right child of the node
         */
        public Node (E element, Node<E> above, Node<E> leftChild, Node<E> rightChild)
        {
            this.element = element;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;

        } // end of node

        // -------------- ACCESS METHODS ---------------

        public E getElement() {
            return element;
        } // end of getElement()

        public Node<E> getParent() {
            return parent;
        } // end of getParent()

        public Node<E> getLeft() {
            return left;
        } // end of getLeft()

        public Node<E> getRight() {
            return right;
        } // end of getRight()

        // ----------------- UPDATE METHODS ------------

        public void setElement(E element) {
            this.element = element;
        } // end of setElement()

        public void setParent(Node<E> parentNode) {
            this.parent = parentNode;
        } // end of setParent()

        public void setRight(Node<E> rightChild) {
            this.right = rightChild;
        } // end of setRight()

        public void setLeft(Node<E> leftChild) {
            this.left = leftChild;
        } // end of set Left

        @Override
        public String toString() {
            return (String) this.getElement();
        } // end of toString()

    } // ---------------- END OF NESTED NODE CLASS ---------------

    /**
     * Protected factory function to create a new node storing element e
     * @param element element in the node
     * @param parent parent of the node
     * @param left left child of the node
     * @param right right child of the node
     * @return new node storing the element e
     */
    protected Node<E> createNode(E element, Node<E> parent, Node<E> left, Node<E> right)
    {
        return new Node<E>(element, parent, left, right);
    } // end of createNode

    // -------- INSTANCE VARIABLES --------
    protected Node<E> root = null;              // root of the node
    private int size = 0;                       // number of nodes in the tree

    /**
     * Constructor of a linked binary tree that creates an empty binary tree
     */
    public LinkedBinaryTree() {}

    // --------- NON PUBLIC UTILITY METHODS ----------

    /**
     * Protected validate method that validates the position and returns it as a node
     * @param p position to be validated
     * @return passed position as a node
     * @throws IllegalArgumentException if p is invalid or non-existent
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException
    {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");

        Node<E> node = (Node<E>) p;             // safe cast
        if (node.getParent() == node)           // convention for defunct node
            throw new IllegalArgumentException("P is no longer in the tree");

        return node;

    } // end of validate()

    // -------------- ACCESS METHODS -----------------

    /**
     * Public method that returns the size of the tree
     * @return size of the tree
     */
    public int size()
    {
        return size;
    } // end of size()

    /**
     * Public access method that returns the root of the tree as a Position element
     * @return root of the tree
     */
    public Position<E> root()
    {
        return root;
    } // end of root()

    /**
     * Public access method that returns the parent of element p
     * @param p A valid Position within the tree
     * @return parent of element p
     * @throws IllegalArgumentException id p is invalid
     */
    public Position<E> parent(Position<E> p) throws IllegalArgumentException
    {
        Node<E> node = validate(p);
        return node.getParent();
    } // end of parent()

    /**
     * Public access method that returns the left child of element p
     * @param p A valid Position within the tree
     * @return left child of element p
     * @throws IllegalArgumentException id p is invalid
     */
    public Position<E> left(Position<E> p) throws IllegalArgumentException
    {
        Node<E> node = validate(p);
        return node.getLeft();

    } // end of left()

    /**
    * Public access method that returns the right child of element p
    * @param p A valid Position within the tree
    * @return right child of element p
    * @throws IllegalArgumentException id p is invalid
    */
    public Position<E> right(Position<E> p) throws IllegalArgumentException
    {
        Node<E> node = validate(p);
        return node.getRight();

    } // end of right()

    // --------------- UPDATE METHODS --------------

    /**
     * Places element e at the root of an empty tree and returns its new position
     * @param e element to be added at the root
     * @return position of the root
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException
    {
        if (!isEmpty())
            throw new IllegalStateException("Tree is not empty");

        root = createNode(e, null, null, null);
        size = 1;
        return root;

    } // end of addRoot()

    /**
     * Creates a new left child of Position P storing element e;
     * returns its Positions
     * @param p the position of the parent
     * @param element new element to be added to the left
     * @return position of the newly added element
     * @throws IllegalArgumentException if parent already has a left child
     */
    public Position<E> addLeft(Position<E> p, E element) throws IllegalArgumentException
    {
        Node<E> parent = validate(p);

        if (parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");

        Node<E> child = createNode(element, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;

    } // end of addLeft()

    /**
     * Creates a new right child of Position P storing element e;
     * returns its Positions
     * @param p the position of the parent
     * @param element new element to be added to the right
     * @return position of the newly added element
     * @throws IllegalArgumentException if parent already has a left child
     */
    public Position<E> addRight(Position<E> p, E element) throws IllegalArgumentException
    {
        Node<E> parent = validate(p);

        if (parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");

        Node<E> child = createNode(element, parent, null, null);
        parent.setRight(child);
        size++;
        return child;

    } // end of addRight()

    public E set(Position<E> p, E e) throws IllegalArgumentException
    {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);

        return temp;

    } // end of set()

    /**
     * Removes the node at Position p and replaces it with its child, if any
     * @param p position of element p that is to be removed
     * @return removed position
     * @throws IllegalArgumentException if p has two children
     */
    public E remove(Position<E> p) throws IllegalArgumentException
    {
        Node<E> node = validate(p);

        if (numChildren(p) == 2)
            throw new IllegalArgumentException("p already has two children");

        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());

        if (child != null)
            child.setParent(node.getParent());
        if (node == root)
            root = child;
        else
        {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        } // end of else

        size--;

        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);

        return temp;

    } // end of remove()

    /**
     * Public method that prints the binary tree as per the accordance
     * @return LinkedBinaryTree as a string
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        int depthOfTree;

        for (Position<E> p : positions())
        {
            depthOfTree = depth(p);
            for(int i = 0; i < depthOfTree; i++)
            {
                sb.append("\t");
            } // end of for

            sb.append("- ");
            sb.append(p.getElement()).append("\n");
        } // end of for

        return sb.toString();
    } // end of toString()

} // end of LinkedBinaryTree
