// package statement
package AssignmentTwo.QuestionTwo;

/**
 * ACS-2947 | Assignment Two <br>
 * Implementation of a generic ArrayPositionalList as required by the assignment
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentTwo">Assignment Two GitHub</a>
 */
public abstract class ArrayPositionalList<E> implements PositionalList<E> {

    //-------------------- NESTED LOCATION CLASS ------------------------------

    /**
     * A (static) inner class.
     * It implements a location object that enforces the principle of encapsulation
     * in this configuration of the ArrayPositionalList.
     * This allows the use of location through position so as not to give the users of
     * the data structure direct access to the location since that opposes the OOP principles.
     * @param <E>
     */
    private static class Location<E> implements Position<E>
    {
        // fields used in the location class
        private int index;                      // the location index
        private E element;                      // the element at the said location

        /**
         * Full-argument constructor for Location inner class that creates a location object
         * with the index and element fields as passed by the user
         * @param index the index of the element
         * @param element the element
         */
        public Location(int index, E element)
        {
            this.index = index;
            this.element = element;
        } // end of constructor

        /**
         * Public access method that returns the element. It is a non-static method, i.e. it must
         * be called on a location object
         * @return element in the location object
         * @throws IllegalStateException if the element does not exist
         */
        public E getElement() throws IllegalStateException
        {
            if (index == -1)
            {
                throw new IllegalStateException("Position no longer valid");
            } // end of if
            return element;
        } // end of getElement()

        /**
         * Public update method that sets the element e. It is a non-static method that means
         * that it must be called on a location object.
         * @param e element that is to be set
         */
        public void setElement(E e)
        {
            element = e;
        } // end of setElement()

        /**
         * Public access method that returns the index of the location.
         * It is the non-static method, that is, it needs to be called on a location object.
         * @return the index of the location object
         */
        public int getIndex()
        {
            return index;
        } // end of getIndex()

        /**
         * Public update method that sets the index of the location.
         * It is a non-static method that means that it must be called on a location object
         * @param i the new index of the location
         */
        public void setIndex(int i)
        {
            index = i;
        } // end of setIndex()

    } // end of inner class

    // --------------------- END OF NESTED LOCATION CLASS --------------

    // fields for ArrayPositionalList
    public static final int CAPACITY = 16;          // capacity of the list
    private Location<E>[] data;                     // array of type Location<E>
    private int size = 0;                           // size of the array

    /**
     * No-Argument constructor for creating an ArrayPositionalList.
     * The said constructor called the full-argument constructor with the default capacity
     * of 16, therefore, creating an APL of that size.
     */
    public ArrayPositionalList()
    {
        this(CAPACITY);                    // creating APL of the default size: 16
    } // no-arg constructor

    /**
     * Full-Argument constructor that creates an ArrayPositionalList of the size that has been
     * passed as an argument by the user.
     * The constructor casts (unchecked) the location array as a generic Location object array.
     * @param capacity maximum elements that could be in the array
     */
    public ArrayPositionalList(int capacity)
    {
        data = (Location<E>[]) new Location[capacity];
    } // full-arg constructor

    // ------------- PRIVATE UTILITY METHODS ---------------

    /**
     * Private utility method that validates the location and checks if the value in passed in it
     * is correct and is valid to be used in the entirety of the program
     * @param position position object
     * @return position object as a location
     * @throws IllegalArgumentException if the passed position is invalid
     */
    public Location<E> validate(Position<E> position) throws IllegalArgumentException
    {
        if(!(position instanceof Location))
            throw new IllegalArgumentException("Invalid location");

        Location<E> location = (Location<E>) position;

        if(location.getIndex() == -1)
            throw new IllegalArgumentException("Location is no longer valid");

        return location;
    } // end of validate()

    /**
     * Private utility method that checks if the position method created is valid or not
     * @param location location passed into the method
     * @return position object if the position passes all the checks
     */
    public Position<E> position(Location<E> location)
    {
        if (location.getIndex() == -1 || location.getIndex() == size || location == null)
            return null;

        return location;
    } // end of position()

    // ------------- ACCESS METHODS -----------------

    /**
     * Public access method that returns the size of the positional list
     * @return size of the list
     */
    public int size()
    {
        return size;
    } // end of size()

    /**
     * Public access method that returns a boolean value if the positional list is empty
     * or not
     * @return boolean value false if the list is empty, true if not
     */
    public boolean isEmpty()
    {
        return size == 0;
    } // end of isEmpty()

    /**
     * Public access method that returns the first element in the array positional list
     * or null if the array is empty
     * @return first element of the array
     */
    public Position<E> first()
    {
        return position(data[0]);
    } // end of first()

    /**
     * Public access method that returns the last element in the array positional list
     * or null if the array is empty
     * @return last element of the array
     */
    public Position<E> last()
    {
        return position(data[size - 1]);
    } // end of last()

    /**
     * Public access method that returns the position immediately before the passed
     * position p, or returns null if p is the first element
     * @param p a Position of the list
     * @return position of the element before p
     * @throws IllegalArgumentException if the passed position is invalid
     */
    public Position<E> before(Position<E> p) throws IllegalArgumentException
    {
        Location<E> location = validate(p);
        int index = location.getIndex();

        return position(data[index - 1]);
    } // end of before()

    /**
     * Public access method that returns the position immediately after the passed
     * position p, or returns null if p is the last element
     * @param p a Position of the list
     * @return position of the element after p
     * @throws IllegalArgumentException if the passed position is invalid
     */
    public Position<E> after(Position<E> p) throws IllegalArgumentException
    {
        Location<E> location = validate(p);
        int index = location.getIndex();

        return position(data[index + 1]);
    } // end of after

    /**
     * Public update method that adds a new element as passed in the method to the first index.
     * The method shifts all the elements by one while also changing their index to reflect
     * the said change.
     * @param e the new element
     * @return Position element that has been added
     * @throws IllegalStateException thrown if the list is already full
     */
    public Position<E> addFirst(E e) throws IllegalStateException
    {
        if (size == data.length)
            throw new IllegalStateException("List is full");

        // creating a new location element
        Location<E> element = new Location<>(0, e);

        // shifting all the elements by one
        for(int k = size - 1; k >= 0; k--)
        {
            data[k + 1] = data[k];          // shifting values by one
            data[k + 1].setIndex(k + 1);    // increasing the index by one
        } // end of for loop
        data[0] = element;                  // setting the first element as the passed element
        size++;                             // increasing the size by one

        return position(data[0]);           // return the element back to user
    } // end of addFirst()

    /**
     * Public update method that adds the passed element to the end of the list.
     * @param e the new element
     * @return the newly added element
     * @throws IllegalStateException thrown if the list is full
     */
    public Position<E> addLast(E e) throws IllegalStateException
    {
        // if the array is filled, throw an exception
        if (size == data.length)
            throw new IllegalStateException("List is full.");

        Location<E> element = new Location<>(size, e);      // create a new location element
        data[size] = element;                               // set the element to be the last element
        size++;                                             // increase the size by one

        return position(data[size - 1]);                    // return the newly created element
    } // end of addLast()

    /**
     * Public update method that adds element (passed into the method) to the index before the
     * position element that is passed into the method.
     * @param p the Position before which the insertion takes place
     * @param e the new element
     * @return the newly added element as a position
     * @throws IllegalArgumentException if the passed position is not valid
     */
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException
    {
        // validating the passed position as a location
        Location<E> location = validate(p);

        // checking if the list is already full
        if (size == data.length)
            throw new IllegalStateException("List is full.");

        // getting the index before which new element is to be added
        int index = location.getIndex();

        // shifting all the indices to the next indice
        for(int i = size - 1; i >= index; i--)
        {
            data[i + 1] = data[i];
            data[i + 1].setIndex(index + 1);
        } // end of for loop

        // setting the new element to before the index of the current element
        Location<E> element = new Location<>(size, e);
        data[index] = element;
        size++;                             // increasing the size

        return position(data[index]);
    } // end of addBefore()

    /**
     * Public update method that adds element (passed into the method) to the index after the
     * position element that is passed into the method.
     * @param p the Position after which the insertion takes place
     * @param e the new element
     * @return the newly added element as a position
     * @throws IllegalArgumentException if the passed position is not valid
     */
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException
    {
        // validate passed Position as a Location
        Location<E> location = validate(p);

        // throwing an exception if the size of the array is already full
        if (size == data.length)
            throw new IllegalStateException("List is full.");

        // getting the index before which new element is to be added
        int index = location.getIndex();
        index++;                        // increasing the index by one to add to position after index

        // shifting all the element after the passed element to the next index
        for (int i = size - 1; i >= index; i--)
        {
            data[i + 1] = data[i];
            data[i + 1].setIndex(index + 1);
        } // end of for-loop

        // setting the new element to be at index, since index is already increased by one, no use of index + 1
        Location<E> element = new Location<>(index, e);
        data[index] = element;
        size++;                                     // increasing size by one

        return position(data[index]);

    } // end of addAfter()

    /**
     * Replaces the element stored at the given Position and returns the replaced element.
     * @param p the Position of the element to be replaced
     * @param e the new element
     * @return the replaced element
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException
    {
        // validate passed Position as a Location
        Location<E> location = validate(p);

        int index = location.getIndex();            // getting index of the passed position
        E removed = location.getElement();          // saving the element that is to be removed

        // setting the new element at the same index location as p
        location.setElement(e);

        return removed;                             // returning the removed element
    } // end of set()

    /**
     * Removes the element stored at the given Position and returns it.
     * The given position is invalidated as a result.
     *
     * @param p the Position of the element to be removed
     * @return the removed element
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    public E remove(Position<E> p) throws IllegalArgumentException
    {
        // validating p as a location
        Location<E> location = validate(p);

        int index = location.getIndex();            // getting the index of the location
        E removed = location.getElement();          // saving the element that is to be removed

        for(int i = index + 1; i < size - 1; i++)
        {
            data[i - 1] = data[i];
            data[i - 1].setIndex(index + 1);
        } // end of for

        size--;                                     // decreasing size by one
        location.setIndex(-1);                      // setting index to -1 to make it invalid
        location.setElement(null);                  // helps with garbage collection

        return removed;                             // return the removed element
    } // end of remove

    /**
     * Public utility toString method that returns the String representation of the class
     * @return string representation of the class
     */
    @Override
    public String toString()
    {
        // creating a StringBuilder
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++)
        {
            sb.append("[").append(data[i].getIndex()).append("]");
            sb.append(" ").append(data[i].getElement());
        } // end of for loop

        return sb.toString();

    } // end of toString

} // end of class
