package Assignment_One;

/**
 * ACS-2927 | Assignment One <br>
 * Implementation of a CircularlyDoublyLinkedList that is based on CircularlyLinkedList and
 * DoublyLinkedList as discussed in the class. It achieves the important methods of both the
 * linked lists to achieve the desired outcome as required by the assignment.
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Assignment_One">GitHub</a>
 */

public class CircularDoublyLinkedList<E>
{
    // ----------------------------------- NESTED NODE CLASS -------------------------------
    /**
     * The Node Class nested inside CircularDoublyLinkedList class that will hold nodes with
     * reference points to the current element and the next node and previous node.
     * The node class is declared inside the linked list class for enforced cohesion and
     * encapsulation, considering that a node cannot exist outside a linked list.
     */
    public static class Node<E>
    {
        // instance variables of node class
        private E element;                  // reference to an element stored inside the node
        private Node<E> next;               // reference to the next node after the current node
        private Node<E> prev;               // reference to the previous node before the current node

        /**
         * Full argument constructor for the Node class that creates a generic node with
         * three parameters, namely, element, next and prev.
         * @param element reference to the current element
         * @param next reference to the next node
         * @param prev reference to the previous node
         */
        public Node (E element, Node<E> next, Node<E> prev)
        {
            this.element = element;         // current element
            this.next = next;               // reference to the next node
            this.prev = prev;               // reference to the next node
        } // end of full-argument constructor

        // ------ Access Method ---------

        /**
         * Public access method that returns the reference of the current node element
         * in the circular-doubly linked list
         * @return reference to current node element
         */
        public E getElement() {
            return this.element;
        } // end of getElement()

        /**
         * Public access method that returns the node next to the current code in the
         * circular-doubly linked list
         * @return reference to the next node
         */
        public Node<E> getNext() {
            return next;
        } // end of getNext()

        /**
         * Public access method that returns the node previous to the current code in the
         * circular-doubly linked list
         * @return reference to the previous node
         */
        public Node<E> getPrev() {
            return prev;
        } // end of getNext()

        // ------ Update Methods ---------

        /**
         * Update method that sets the next node to the node as passed as an argument
         * @param next reference to the next node
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }// end of setNext()

        /**
         * Update method that sets the previous node to the node as passed as an argument
         * @param prev reference to the prev node
         */
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        } // end of setPrev()

    } // --------------------------------- NESTED NODE CLASS -----------------------------

    // instance variables for the CircularDoublyLinkedClass
    private Node<E> tail = null;        // tail of the linked list
    private int size = 0;               // size of the linked list

    /**
     * Constructor of the CircularDoublyLinked list that creates an instance of the
     * class when called.
     * It is a no-argument constructor since all fields are
     * implemented as we populate the linked list.
     */
    public CircularDoublyLinkedList() {}

    // ------ Access Methods ------

    /**
     * A public access method that returns the current size of the CircularDoublyLinkedList
     * @return current size of the list
     */
    public int size() {
        return this.size;
    } // end of size()

    /**
     * A public access method that returns a boolean value of true or false based on if the
     * list has any elements inside it
     * @return boolean true/false if the list is empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    } // end of isEmpty()

    /**
     * Public access method that returns the first Node in the linked list.
     * This is done by getting the next element from the tail; since it is a circular list,
     * this means that the next element after tail would be the first element
     * @return first element of the list
     */
    public E first() {
        if (this.isEmpty())
            return null;                // return null if the list is empty

        return tail.getNext().getElement();
    } // end of first()

    /**
     * Public access method that returns the last Node in the linked list.
     * This is done by getting the element.
     * This is in the tail of the list.
     * @return last element of the list
     */
    public E last() {
        if (this.isEmpty())
            return null;                // return null if the array is empty

        return tail.getElement();
    } // end of last()

    // ------- Update Methods -------

    /**
     * Public update method that adds the element at the beginning of the circular-doubly linked list.
     * This method calls the addBetween() method and adds the element between two said elements.
     * It also considers the case of adding the first element into the list and handles it using an
     * if else conditional.
     * @param element element to be added to the list
     * @see CircularDoublyLinkedList#addBetween(Object, Node, Node)
     */
    public void addFirst(E element)
    {
        // In case of an empty list, the first element that gets added will be set as its tail.
        // Since this will be the only element in the list and since it is a circular doubly
        // linked list, the same element will be set as the previous and the next element
        if (size == 0)
        {
            tail = new Node<>(element, null, null);     // tail element that links to nothing
            tail.setNext(tail);                                  // next element as itself
            tail.setPrev(tail);                                  // previous element as itself
            size++;                                              // update the size
        } // end of if conditional
        else
        {
            // If the list is not empty, add the first element next to the tail (the head).
            // This way the element can be added between the tail and the element
            // that is next to the tail (pseudo head).
            addBetween(element, this.tail, this.tail.getNext());
        } // end of else

    } // end of addFirst()

    /**
     * Public update method that adds an element to the end of the linked list.
     * This is done by calling the addFirst() method that adds the element as the header of the
     * linked list, but then the tail is updated to be the next element.
     * Consecutively making the new element to be the tail of the linked list.
     * @param element element to be added at the end
     * @see CircularDoublyLinkedList#addFirst(Object) 
     */
    public void addLast(E element)
    {
        addFirst(element);              // add an element to the first of the list (making it the header)
        tail = tail.getNext();          // set the now header to be the tail of the element
    } // end of addLast()

    /**
     * Public update method that removes the head (next element to the tail) of the list
     * @return the removed element
     */
    public E removeFirst()
    {
        if (this.isEmpty())
            return null;                // return null if the list is empty
        return remove(tail.getNext());
    } // end of removeFirst()

    // ------- Utility Methods --------

    /**
     * Public update method that rotates the linked list by jumping from tail to the
     * header and declaring that header to be the new tail
     */
    public void rotate()
    {
        if (tail != null)
            tail = tail.getNext();
    } // end of rotate()

    /**
     * Public update method that reverses the linked list by jumping from the
     * tail to the element previous to the tail, making the tail to be the new header
     */
    public void reverse()
    {
        if (tail != null)
            tail = tail.getPrev();
    } // end of reverse()

    /**
     * Overridden toString method that creates a toString of all the elements in the list and returns it
     * to the user.
     * This works by starting at the head of the list (next element from tail) and looping
     * through the list until head is encountered again.
     * @return toString of the linked-list
     */
    @Override
    public String toString()
    {
        if (isEmpty())
            return "[]";                                 // if the list is empty return empty brackets

        StringBuilder sb = new StringBuilder();         // creating a StringBuilder to append data
        Node<E> current = tail.getNext();               // getting the head of the list

        // use of do-while loop since we want the code to run at least once as the first current
        // value is actually the head, then we terminate the while loop if we encounter it again
        sb.append("[");
        do {
            sb.append(current.getElement());            // append to string builder
            current = current.getNext();                // move onto the next element

            if (current != tail.getNext())              // while the next element is not head
                sb.append(", ");                        // keep appending ", "

        } while (current != tail.getNext());
        sb.append("]");

        return sb.toString();                           // return the string to the user
    } // end of toString

    // ------- Private Update Methods -------

    /**
     * addBetween() is a private utility method that adds a new node in the middle of two existing nodes.
     * It takes the previous and the next nodes (to the target node) as parameters and adds the said new
     * node in between them.
     * @param element reference to the element to be added
     * @param predecessor reference to the previous node
     * @param successor reference to the next node
     */
    private void addBetween(E element, Node<E> predecessor, Node<E> successor)
    {
        // if it is not the first element, creating a new instance of the node
        Node<E> newest = new Node<>(element, successor, predecessor);

        predecessor.setNext(newest);            // set next of the previous node to be this node
        successor.setPrev(newest);            // set previous of the next node to be this node

        size++;                                     // increase the size by one
    } // end of addBetween()

    /**
     * remove() is a private utility method that removes the current node from the linked list.
     * This is done by dereferencing the current node and setting the neighbouring nodes to be
     * each other's next and previous nodes.
     * This method also returns the node to the user
     * @param node node to be removed
     * @return removed note
     */
    private E remove (Node<E> node)
    {
        Node<E> predecessor = node.getPrev();       // getting reference of next node
        Node<E> successor = node.getNext();         // getting reference of previous node

        // following two statements dereference the current node and set each other to be
        // their own predecessor and successor
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;                                     // decrease the size of the list by one

        return node.getElement();                   // return the current removed node
    } // end of remove

} // end of CircularlyDoublyLinkedList
