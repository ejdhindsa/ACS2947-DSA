package AssignmentThree.QuestionTwo;

import java.util.Comparator;

/**
 * ACS-2947 - Assignment Three
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentThree">GitHub</a>
 */
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V>
{
    // ------------- Nested PQEntry Class ------------
    protected static class PQEntry<K, V> implements Entry<K, V>
    {
        // instance variables for PQEntry
        private K key;
        private V value;

        public PQEntry(K key, V value)
        {
            this.key = key;
            this.value = value;
        } // end of PQEntry

        // methods of the Entry interface

        public K getKey() {
            return key;
        } // end of getKey()

        public V getValue() {
            return value;
        } // end of getValue()

        // utilities that not exposed as part of the Entry interface
        protected void setKey(K key) {
            this.key = key;
        } // end of setKey()

        protected void setValue(V value) {
            this.value = value;
        } // end of setValue()

    } // --------------- END OF NESTED CLASS -----------------

    /**
     * THe comparator defining the ordering of keys in the priority queue.
     */
    private Comparator<K> comp;

    /**
     * Creates an empty priority queue using the given comparator to order keys
     * @param c given comparator with which the items will be ordered
     */
    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    } // end of full arg-constructor

    /**
     * Creates an empty priority queue based on the natural ordering of its keys
     */
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    } // end of no-arg constructor

    /**
     * Method for comparing two entries according to keys
     * @param a first entry which is to be compared
     * @param b second entry which is to be compared
     * @return int based on the comparison of both the entries
     */
    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    } // end of compare()

    /**
     * Determines whether a key is invalid
     * @param key key that is to be checked
     * @return boolean true if the key is valid, false otherwise
     * @throws IllegalArgumentException if the key is incompatible
     */
    protected boolean checkKey(K key) throws IllegalArgumentException
    {
        try {
            return(comp.compare(key, key) == 0); // check if the key is being compared to itself
        } // end of try
        catch (ClassCastException e)
        {
            throw new IllegalArgumentException("Incompatible key type");
        } // end of catch

    } // end of checkKey()

    /**
     * Tests whether the priority queue is empty
     * @return boolean true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    } // end of isEmpty()

} // end of AbstractPriorityQueue
