package AssignmentTwo.QuestionOne;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ACS-2947 | Assignment Two <br>
 * Implementation of a generic ArrayList as required by the assignment
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentTwo">Assignment Two GitHub</a>
 */
public class ArrayList<E> implements List<E>
{

    // ----------------- NESTED ARRAY ITERATOR CLASS ---------------------

    /**
     * A (nonstatic) inner class.
     * It implements the iterator functionality on the arraylist allowing users to use
     * iterator methods and iteration over the said class.
     * Note that each instance contains an implicit reference to the containing lit, allowing
     * it to access the list's members
     */
    private class ArrayIterator implements Iterator<E>
    {
        private int j = 0;                  // index of the next element to report
        private boolean removable = false;  // tells if the element is removable at this time

        /**
         * Tests whether the iterator has a next object
         *
         * @return true if there are further objects, false otherwise
         */
        public boolean hasNext()
        {
            return j < size();      // size field of outer instance
        } // end of hasNext()

        /**
         * Returns the next object to the iterator
         *
         * @return next object
         * @throws NoSuchElementException if there are no further elements
         */
        public E next() throws NoSuchElementException
        {
            if (j == size) throw new NoSuchElementException("No next element");
            removable = true;       // this element can subsequently be removed
            return data[j++];       // post increment j, so it is ready for future call to next
        } // end of next()

        /**
         * Removes the element returned by the most recent call to next
         *
         * @throws IllegalStateException if next has not yet been called
         * @throws IllegalStateException if remove has been already called since recent next
         */
        public void remove() throws IllegalStateException
        {
            if (!removable) throw new IllegalStateException("Nothing to remove");
            ArrayList.this.remove(j--);         // that was last returned
            j--;                                // the next element has shifted one cell to the left
            removable = false;                  // do not allow remove again until next() is called
        }

    } // end of ArrayIterator class

    // ------------- END OF NESTED ARRAY ITERATOR CLASS ------------------

    /**
     * Returns an iterator of the elements stored in the list
     *
     * @return iterator of elements stored in the list
     * @see ArrayIterator
     */
    public Iterator<E> iterator()
    {
        return new ArrayIterator();         // create new instance of inner class
    } // end of iterator()

    // instance variables
    public static final int CAPACITY = 4;          // default array capacity
    private E[] data;                               // generic array used for storage
    private int size = 0;                           // current number of elements

    // ------- CONSTRUCTORS -------

    /**
     * No-argument constructor for creating an arraylist with an initial capacity of 4.
     * The constructor calls the full-argument constructor with this keyword and passes the
     * constant capacity to be used as the capacity.
     */
    public ArrayList()
    {
        this(CAPACITY);
    } // end of no-argument constructor

    /**
     * Full-argument constructor for creating an arraylist with the capacity passed as the
     * argument in the constructor.
     * The constructor initialises an object array and then casts it into a generic array.
     *
     * @param capacity the capacity of the array
     */
    public ArrayList(int capacity)
    {
        data = (E[]) new Object[capacity];
    } // end of full-arg constructor

    // -------- PUBLIC METHODS ----------

    /**
     * Public method that returns the current size of the arraylist
     *
     * @return current size of the list as an int
     */
    public int size()
    {
        return size;
    } // end of size

    /**
     * Public method that returns a boolean value if the arraylist is empty or not
     *
     * @return boolean true/false if the arraylist is empty or not
     */
    public boolean isEmpty()
    {
        return size == 0;
    } // end of isEmpty()

    /**
     * Public method that returns but does not remove the element at the passed index to the user.
     * The method first calls the checkIndex() method to see if the index that has been passed is a
     * valid index or not, if it is, the element at that index is returned to the user.
     *
     * @param index the index of the element to return
     * @return element at the passed index
     * @throws IndexOutOfBoundsException if the user tries to access the element out of the arraylist's bounds.
     * @see #checkIndex(int index, int size)
     */
    public E get(int index) throws IndexOutOfBoundsException
    {
        checkIndex(index, size);                // check if the index is valid
        return data[index];                     // return data at said index
    } // end of get()

    /**
     * Public method that inserts element e to the index i.
     * This method also returns the element that has been removed which was replaced by the new element.
     * The method first calls the checkIndex() method to see if the index that has been passed is a
     * valid index or not, if it is, the element at that index is returned to the user.
     *
     * @param index the index of the element to replace
     * @param element the new element to be stored
     * @return the element that has been replaced
     * @throws IndexOutOfBoundsException if the user tries to access the element out of the arraylist's bounds
     * @see #checkIndex(int index, int size)
     */
    public E set(int index, E element) throws IndexOutOfBoundsException
    {
        checkIndex(index, size);                // check if the index is valid
        E temp = data[index];                   // get the element currently at the index
        data[index] = element;                  // set the passed element at the given index
        return temp;                            // return the removed element
    } // end of set()

    /**
     * Public method that adds an element to the end of the arraylist.
     * If the capacity of the array is full, it calls the resize method and increases the capacity
     * of the array to be twice the current capacity
     *
     * @param element element that is to be added at the end of the list
     * @throws IndexOutOfBoundsException if the user tries to add an element at an invalid index
     * @see #checkIndex(int index, int size)\
     * @see #resize(int newCapacity)
     */
    public void add(E element) throws IndexOutOfBoundsException
    {
        if(size == data.length)
            resize(2 * data.length);    // if the arraylist is over capacity, resize the array

        data[size] = element;                   // set the last element
        size++;                                 // increase the size
    } // end of add()

    /**
     * Public method that adds an element at the index that is provided by the user as an argument.
     * The method first calls the checkIndex() method to see if the index that has been passed is a
     * valid index or not, if it is, the element at that index is returned to the user.
     * If the capacity of the array is full, it calls the resize method and increases the capacity
     * of the array to be twice the current capacity
     *
     * @param index the index at which the new element should be stored
     * @param element the new element to be stored
     * @throws IndexOutOfBoundsException if the user tries to add an element at an invalid index
     * @see #checkIndex(int index, int size)\
     * @see #resize(int newCapacity)
     */
    public void add(int index, E element) throws IndexOutOfBoundsException
    {
        checkIndex(index, size + 1);        // check size + 1 since we are increasing elements by one
        if (size == data.length)
            resize(2 * data.length);                   // if size is more than actual length, increase the capacity

        for (int k = size - 1; k >= index; k--)
            data[k+1] = data[k];                // start shifting by rightmost

        data[index] = element;                  // place the new element at index
        size++;                                 // increase the size

    } // end of add()

    /**
     * Public method that removes and returns the element at index i, while also shifting subsequent
     * elements earlier.
     * The remove method also calls the resize method to decrease the size of the array by half if the
     * current number of elements in the array are quarter the number of elements that the arraylist can hold.
     *
     * @param index the index of the element to be removed
     * @return element that has been removed
     * @throws IndexOutOfBoundsException if the user tries to remove the element out of index range
     */
    public E remove(int index) throws IndexOutOfBoundsException
    {
        checkIndex(index, size);                    // check if the index is valid
        E temp = data[index];

        for (int k = index; k < size - 1; k++)      // shift elements to fill the hole
            data[k] = data[k+1];

        data[size-1] = null;                        // help with garbage collection
        size--;                                     // decrease the size

        // now since the size of the ArrayList is decreased, we check if there are quarter the
        // elements than the array size, if there are, we decrease the size by half
        if (size == (data.length / 4))
            resize(data.length / 2);

        return temp;                                // return the removed element
    } // end of remove

    // ------- UTILITY METHODS ---------

    /**
     * Utility method that checks if the index of the element that is tried of being accessed is valid or not.
     *
     * @param index index of the element
     * @param size size of the array
     * @throws IndexOutOfBoundsException if the user tries to access the element out of the arraylist's bounds.
     */
    protected void checkIndex(int index, int size) throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Illegal index: " + index);
    } // end of checkIndex

    /**
     * Protected utility method that resizes the internal array to have given capacity >= size.
     *
     * @param capacity new capacity of the array
     */
    protected void resize(int capacity)
    {
        E[] temp = (E[]) new Object[capacity];      // safe cast
        for(int k = 0; k < size; k++)
            temp[k] = data[k];

        data = temp;                                // start using the new array
    } // end of resize

    /**
     * A (overridden) public equals method that checks if two arraylists are equal or not
     *
     * @param o the passed array
     * @return true if arrays are equal, false otherwise
     */
    @Override
    public boolean equals(Object o)
    {
        if (o == null)
            return false;                   // return false if o is null

        if(getClass() != o.getClass())
            return false;                   // return false if classes don't match

        ArrayList<E> other = (ArrayList<E>) o;    // use non-parameterised type

        if(this.size() != other.size())
            return false;                           // return false if the sizes don't match

        for (int i = 0; i < size(); i++)
        {
            if(!data[i].equals(other.data[i]))
                return false;               // return false if data does not match
        } // end of for

        return true;                        // otherwise return true
    } // end of equals()

    /**
     * Public toString method that returns the ArrayList in a string format
     *
     * @return ArrayList in a string format
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();     // initialising a StringBuilder

        // creating a basic structure for the toString of the ArrayList
        sb.append("[");
        for(int k = 0; k < size; k++)
        {
            if(k == size-1)
                sb.append(data[k]);
            else
                sb.append(data[k]).append(", ");
        } // end of for
        sb.append("]");

        return sb.toString();                       // returning StringBuilder as a string
    } // end of toString

} // end of class
