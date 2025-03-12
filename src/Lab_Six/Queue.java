package Lab_Six;

import java.util.Iterator;

/**
 * Ekamjot Singh | 3167888 <br>
 * ACS-2947 Lab Six
 * Interface for a queue: a collection of elements that are inserted
 * and removed according to the first-in first-out principle. Although
 * similar in purpose, this interface differs from java.util.Queue.
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Lab_Six">GitHub</a>
 */
public interface Queue<E> extends Iterable<E>
{
    /**
     * Returns the number of elements in the queue.
     * @return number of elements in the queue
     */
    int size();

    /**
     * Tests whether the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts an element at the rear of the queue.
     * @param e  the element to be inserted
     */
    void enqueue(E e);

    /**
     * Returns, but does not remove, the first element of the queue.
     * @return the first element of the queue (or null if empty)
     */
    E first();

    /**
     * Removes and returns the first element of the queue.
     * @return element removed (or null if empty)
     */
    E dequeue();

    /**
     * Empties a queue in O(1) run time.
     */
    void clear();

    /**
     * Returns an iterator of the elements stored in the queue.
     * @return iterator of the queue's elements
     */
    Iterator<E> iterator();

}

