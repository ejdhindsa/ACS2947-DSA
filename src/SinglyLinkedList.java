public class SinglyLinkedList<E>
{
    /**
     * The Node Class nested inside SinglyLinkedList class that will hold nodes with
     * reference points to the current element and the next node. The node class is
     * declared inside the linked list class for enforced cohesion and encapsulation,
     * considering that a node cannot exist outside a linked list.
     * @param <E> Node class can take any argument of generic type <E>
     */
    private static class Node<E>
    {
        // instance variables of node class
        private E element;          // reference to the element inside the node
        private Node<E> next;       // reference point to the next node in the list

        /**
         * Full argument constructor for the node class that creates a generic node with two
         * parameters
         * @param element element that is passed into the node class
         * @param next reference to the next node
         */
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        } // end of full-argument constructor

        /**
         * Returns the element inside the node to the user
         * @return reference to current element
         */
        private E getElement() {
            return element;
        } // end of getElement

        /**
         * Returns the next node connected to the current node
         * @return next node
         */
        private Node<E> getNext() {
            return next;
        } // end of getNext()

        /**
         * Connects the current node with another node
         * @param next reference point to the next node
         */
        private void setNext(Node<E> next) {
            this.next = next;
        } // end of setNext()

    } // end of node class

    // *************************** END OF NESTED NODE CLASS *****************************

    // instance variables of SinglyLinkedList class
    private Node<E> head;           // head node of the list (null if empty)
    private Node<E> tail;           // tail node of the list (null if empty)
    private int size;               // size of the linked list

    /**
     * Creating a constructor as a no-argument constructor, this creates an empty list
     */
    public SinglyLinkedList() {}

    // ---------------- ACCESS METHODS ----------------

    /**
     * Returns the size of the current linked list
     * @return size of the list
     */
    public int size() {
        return size;
    } // end of size()

    /**
     * Returns true or false if the linked list if empty
     * @return boolean value if linked list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    } //end of isEmpty()

    /**
     * Returns the first element in a linked-list (but does not remove)
     * i.e., the element that is also the head element
     * @return the first element in the list
     */
    public E first() {
        if(isEmpty()) return null;      // returns null if the list is empty
        return head.getElement();       // accesses node class's get element method
    } // end of first()

    /**
     * Returns the last element in a linked-list (but does not remove)
     * i.e., the element that is also the tail element
     * @return the last element in the list
     */
    public E last() {
        if (isEmpty()) return null;     // returns null if the list is empty
        return tail.getElement();
    } // end of last()

    // ---------------- UPDATE METHODS ----------------

    public void addFirst(E element)
    {
        head = new Node<>(element, head);       // creates a new node and sets it to be the head
        if (size == 0)
            tail = head;                        // special case: if first element: set head to also be tail
        size++;                                 // increase the size by one
    } // end of addFirst()



} // end of SinglyLinkedList()
