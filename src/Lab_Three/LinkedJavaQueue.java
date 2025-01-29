/*****************************************************************************************
 * ACS-2947 | Lab Three
 * @author Ekamjot Singh
 * Student ID: 3167888
 * GitHub Link : https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Lab_Three
 ****************************************************************************************/

package Lab_Three;

import java.util.LinkedList;

public class LinkedJavaQueue<E> implements Queue<E>
{
    // creating a new linked list as defined by JAVA16
    private LinkedList<E> list = new LinkedList<>();

    /**
     * Constructor for LinkedJavaQueue that instantiates the LinkedJavaQueue object
     */
    public LinkedJavaQueue() {}

    /**
     * Method that returns the size of the list
     * @return returns size of the list
     */
    public int size() { return list.size(); }

    /**
     * Method that returns a boolean value if it is empty for not
     * @return boolean true/false if empty
     */
    public boolean isEmpty() { return list.isEmpty(); }

    /**
     * Adds an element to the queue to the end due to the FIFO principle
     * @param element  the element to be inserted
     */
    public void enqueue (E element) {
        list.addLast(element);
    } // end of enqueue

    /**
     * Returns the first element
     * @return first element
     */
    public E first () { return list.getFirst(); }

    /**
     * Method that removes and return the first element of the list (earliest added element)
     * @return first element in the list
     */
    public E dequeue () { return list.removeFirst(); }

    /**
     * Overridden toString() method
     * @return toString()
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();         // initializing a string builder to hold the string values

        sb.append("[");
        for (int i = 0; i < (list.size()); i++)
        {
            if(i == list.size() - 1)
                sb.append(list.get(i));
            else
                sb.append(list.get(i)).append(", ");

        } // end of for-each

        sb.append("]");

        return sb.toString();
    } // end of toString()

} // end of LinkedJavaQueue
