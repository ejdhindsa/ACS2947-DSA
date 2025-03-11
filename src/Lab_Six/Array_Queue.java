package Lab_Six;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * ACS-2947
 * Lab 5
 * A Dynamic ArrayQueue Class that implements Iterable interface
 */
public class ArrayQueue<E> implements Queue<E>
{
    private static final int CAPACITY = 4;
    private E[] data;
    private int f = 0;
    private int size = 0;

    public ArrayQueue() { this(CAPACITY); }
    public ArrayQueue(int cap) { data = (E[]) new Object[cap];}

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
    }

    /**
     * Returns and removes the first element of the Queue. Null if empty.
     * @return E
     */
    public E dequeue() {
        if(isEmpty()) return null;
        E ans = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        size--;
        return ans;
    }

    //Add the enqueue method

    //Add the resize method

    //Add the toString method

    //Add the clear method

    private class ArrayIterator implements Iterator<E>
    {
        private int j = 0;

        public boolean hasNext() {
            return j < size;
        }

        //Add the next method with the following signature
        /*public E next() throws NoSuchElementException {
        	//complete this method
        }*/

        public void remove() {throw new UnsupportedOperationException();}

    }

    public Iterator<E> iterator() {
        return new ArrayIterator();
    }
}

