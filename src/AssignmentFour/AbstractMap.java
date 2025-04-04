package AssignmentFour;

// import library statements
import java.util.Iterator;

/**
 * ACS-2927 | Assignment Four <br>
 * Public abstract class that creates a base for the map, creating basic implementation
 * of the Abstract Map class.
 * @param <K> Generic parameter that holds the keys in the map
 * @param <V> Generic parameter that holds all the values in the map
 *
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentFour">GitHub</a>
 */
public abstract class AbstractMap<K, V> implements Map<K, V>
{
    /**
     * Returns a boolean true or false if the map is empty
     * @return boolean true if empty, false otherwise
     */
    public boolean isEmpty()
    {
        return size() == 0;
    } // end of isEmpty()

    // --------------- NESTED MAP_ENTRY CLASS -----------------

    /**
     * Nested Map_Entry class that creates a map entry with the values Key and Value such that
     * the entry interface is used and its methods are then implemented.
     * The reason for the nested class is to enforce the principle of encapsulation and to ensure
     * that the sensitive information from MapEntry does not seep outside hither class.
     * @param <K>
     * @param <V>
     */
    protected static class MapEntry<K, V> implements Entry<K, V>
    {
        // instance variables
        private K key;              // key of the MapEntry
        private V value;            // value of the MapEntry

        /**
         * Full-argument constructor for the map entry class that sets the key and the value
         * of the map entry object
         * @param key key of the map
         * @param value value of the map
         */
        public MapEntry(K key, V value)
        {
            this.key = key;             // the key of the MapEntry
            this.value = value;         // the value of the MapEntry
        } // end of full-arg constructor

        // ---------------- ACCESS METHODS ----------------

        /**
         * Public access method that returns the key of the map
         * @return key of the map
         */
        @Override
        public K getKey() {
            return key;
        } // end of getKey()

        /**
         * Public access method that returns the value of the map
         * @return value of the map
         */
        @Override
        public V getValue() {
            return value;
        } // end of getValue()

        // ----------------- UPDATE METHODS ----------------

        /**
         * Public update method that sets the key of the map
         * @param key key of the map
         */
        protected void setKey(K key) {
            this.key = key;
        } // end of setKey()

        /**
         * Public update method that sets the value of the map but also returns
         * the old value of the map
         * @param value value of the map
         * @return old value of the map
         */
        protected V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        } // end of setValue()

        // -------------- UTILITY METHODS ------------------

        @Override
        public String toString()
        {
            StringBuilder builder = new StringBuilder();

            builder.append("{");
            builder.append(key);
            builder.append(", ");
            builder.append(value);
            builder.append("}");

            return builder.toString();
        } // end of toString

    } // ------------- END OF NESTED MapEntry CLASS ---------------

    /**
     * Nested private class that enforces the iterator class using the iterator interface.
     */
    private class KeyIterator implements Iterator<K>
    {
        // entries that hold the values
        private Iterator<Entry<K, V>> entries = entrySet().iterator();

        /**
         * Boolean value if there exists a next key
         * @return boolean true if next exists, false otherwise
         */
        public boolean hasNext() {
            return entries.hasNext();
        } // end of hasNext()

        /**
         * Public next method that returns the next element in the said iterator class for
         * the iterator implementation
         * @return key value from the map
         */
        public K next() {
            return entries.next().getKey();
        } // end of next()

        /**
         * Implementation of the remove method is not supported in this case, therefore
         * an unsupported operation exception is thrown
         */
        public void remove() {
            throw new UnsupportedOperationException();
        } // end of remove()

    } // --------------------- END OF INNER CLASS -------------------

    /**
     * Private KeyIterable class that implements the Iterable class which creates a
     * iterator method that returns a KeyIterator()
     */
    private class KeyIterable implements Iterable<K>
    {
        /**
         * Public method that returns iterator that iterates through all the keys
         * @return Iterator that returns the keys
         */
        public Iterator<K> iterator() {
            return new AbstractMap.KeyIterator();
        } // end of iterator

    } // end of KeyIterable inner class

    /**
     * Public iterable that returns the iterable type object having and containing all the
     * key values aka keySet
     * @return keySet as a form of Iterable object
     */
    public Iterable<K> keySet() {
        return new AbstractMap.KeyIterable();
    } // end of keySet()


    /**
     * Nested private class that iterates through all the values of the map
     */
    private class ValueIterator implements Iterator<V>
    {
        // entries that hold the values
        private Iterator<Entry<K, V>> entries = entrySet().iterator();

        /**
         * Boolean value if there exists a next value
         * @return boolean true if next exists, false otherwise
         */
        public boolean hasNext() {
            return entries.hasNext();
        } // end of hasNext()

        /**
         * Public next method that returns the next element in the said iterator class for
         * the iterator implementation
         * @return value from the map
         */
        public V next() {
            return entries.next().getValue();
        } // end of next()

        /**
         * Implementation of the remove method is not supported in this case, therefore,
         * an unsupported operation exception is thrown
         */
        public void remove() {
            throw new UnsupportedOperationException();
        } // end of remove()

    } // end of ValueIterator

    /**
     * Private ValueIterable class that implements the Iterable class which creates a
     * iterator method that returns a ValueIterable()
     */
    private class ValueIterable implements Iterable<V>
    {
        /**
         * Public method that returns iterator that iterates through all the values
         * @return Iterator that returns the values
         */
        public Iterator<V> iterator() {
            return new AbstractMap.ValueIterator();
        } // end of iterator()

    } // end of ValueIterable()

    /**
     * Public iterable that returns the iterable type object having and containing all the
     * values aka valueSet
     * @return valueSet as a form of Iterable object
     */
    public Iterable<V> values() {
        return new AbstractMap.ValueIterable();
    } // end of values()

} // end of class
