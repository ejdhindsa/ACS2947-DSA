package Lab_Six;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Ekamjot Singh | 3167888 <br>
 * ACS-2947 Lab Six
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Lab_Six">GitHub</a>
 */
public class ArrayQueue<E> implements Queue<E>
{
    // instance variables
    private static final int CAPACITY = 4;
    private E[] data;
    private int f = 0;
    private int size = 0;

    /**
     * No argument constructor for creating an ArrayQueue.
     * This is done with the default initial capacity of 4
     */
    public ArrayQueue() { this(CAPACITY); }

    /**
     * Full-argument constructor that initialises an ArrayQueue with the initial capacity as
     * passed as an argument in the constructor
     * @param cap the capacity of the ArrayQueue
     */
    public ArrayQueue(int cap) {
        data = (E[]) new Object[cap];
    } // end of full argument constructor

    /**
     * Returns the size of the Queue
     * @return int
     */
    public int size() { return size; }

    /**
     * Checks if the Queue is empty.
     * @return boolean
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * Returns but does not remove the first element of the Queue. Null if Queue is empty.
     * @return E
     */
    public E first() {
        if(isEmpty()) return null;
        return data[f];
    } // end of first()

    /**
     * Returns and removes the first element of the Queue. Null if empty.
     * @return E
     */
    public E dequeue()
    {
        if(isEmpty()) return null;
        E ans = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        size--;
        return ans;
    } // end of dequeue


    public void enqueue(E element) throws IndexOutOfBoundsException
    {
        if (size == data.length)
        {                                   // if queue becomes full, increase the capacity of the queue
            resize(2 * data.length);
        } // end of if

        int avail = (f + size) % data.length;
        data[avail] = element;
        size++;

    } // end of enqueue

    public void resize(int capacity)
    {
        E[] temp = (E[]) new Object[capacity];      // safe case
        for (int k = 0; k < size; k++)
        {
            temp[k] = data[(f + k) % data.length];
        } // end of for loop

        f = 0;                  // since we made a new array, all the items are in sequential order already
        data = temp;            // set a temp array to be the new array

    } // end of resize

    @Override
    public String toString()
    {
        // creating an instance of StringBuilder
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        // using a for loop to print everything
        for(int i = 0; i < size; i++)
        {
            // this appends the data into the queue while also considering the rotating effect that
            // the queue has
            sb.append(data[(f + i) % data.length]);

            if (i < size - 1)
                sb.append(", ");            // only append if not the last element

        } // end of for loop
        sb.append("]");

        return sb.toString();

    } // end of toString()

    public void clear()
    {
        data = (E[]) new Object[CAPACITY];
        size = 0;

    } // end of clear

    // --------------------- NESTED ARRAY ITERATOR CLASS -------------------------
    private class ArrayIterator implements Iterator<E>
    {
        private int j = 0;

        public boolean hasNext()
        {
            return j < size;
        } // end of hasNext

        public E next() throws NoSuchElementException
        {
            if (j == size)
                throw new NoSuchElementException("No next element");
            return data[(f + j++) % data.length];

        } // end of next()

        public void remove() {
            throw new UnsupportedOperationException();
        } // end of remove

    } // end of arrayIterator
    // ---------------------------- END OF NESTED CLASS ----------------------------

    public Iterator<E> iterator() {
        return new ArrayIterator();
    } // end of iterator

} // end of ArrayQueue
