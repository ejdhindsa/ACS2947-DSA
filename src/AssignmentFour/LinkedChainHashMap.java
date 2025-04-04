package AssignmentFour;

// import statements
import java.util.LinkedList;

/**
 * ACS-2927 | Assignment Four <br>
 * Class that creates an instance of LinkedChainHashMap.
 * It extends AbstractHashMap using its concrete methods and implements the abstract methods from the said
 * parent class.
 * Rather than using an ArrayList, the hash map uses Linked List to achieve the hash map configuration.
 * @param <K> Key of the Hash Map
 * @param <V> Value of the Hash Map
 *
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentFour">GitHub</a>
 */
public class LinkedChainHashMap<K, V> extends AbstractHashMap<K, V>
{
    // a fixed capacity array of LinkedList that serve a buckets
    private LinkedList<MapEntry<K, V>>[] table;          // initialised within createTable()

    // ------------ CONSTRUCTOR ---------------

    /**
     * No-argument constructor that creates a LinkedChainHashMap with no-arguments, that is with
     * the capacity 17 and the prime factor 109345121, this is done by calling the
     * super(), i.e. AbstractHashMap.
     */
    public LinkedChainHashMap() {
        super();
    } // end of no-arg constructor

    /**
     * Semi-argument constructor that creates an instance of a LinkedChainHashMap with the given
     * capacity as provided during the instantiation, this is done by calling the
     * super(), i.e. AbstractHashMap.
     * It calls the full argument constructor with the capacity as given by the user, and the prime
     * number as provided in the capacitor.
     * @param initialCapacity capacity of the hash map
     */
    public LinkedChainHashMap(int initialCapacity) {
        super(initialCapacity);
    } // end of semi-arg constructor

    /**
     * Full argument constructor that creates an instance of LinkedChainHashMap with capacity and prime
     * as given by the user, this is done by calling the super(), i.e. AbstractHashMap.
     * It creates a new random and randomly selects a scale with the help of prime as selected randomly
     * by java's standard random library.
     * It also assigns a shift variable randomly based on the prime provided by the user.
     * @param initialCapacity capacity of the hash map
     * @param prime prime factor with which shift and scaling factors are created
     */
    public LinkedChainHashMap(int initialCapacity, int prime) {
        super(initialCapacity, prime);
    } // end of full-argument constructor

    // -------------- UPDATE METHODS ---------------

    /**
     * Creates an empty table having length equal to current capacity
     */
    protected  void createTable()
    {
        table = (LinkedList<MapEntry<K,V>>[]) new LinkedList[capacity];
    } // end of create table

    /**
     * Returns the value associated with key k in bucket with hash value h,
     * or else null
     * @param h hash value of the bucket
     * @param k key associated with the bucket
     * @return value associated with the key
     */
    protected V bucketGet(int h, K k)
    {
        LinkedList<MapEntry<K, V>> bucket = table[h];

        if (bucket == null)
            return null;

        // find the MapEntry E from the hashValue h
        for (MapEntry<K, V> entry : bucket)
        {
            if (entry.getKey().equals(k))
            {
                return entry.getValue();            // if key is found, return value associated to key
            } // end of if
        } // end of enhanced-for

        return null;                // if not found, return null
    } // end of bucketGet()

    /**
     * Associates key k with value v in the bucket with hash value h; returns old value
     * @param h hash value of the bucket
     * @param k key to be associated with
     * @param v value in the bucket
     * @return old value, or null
     */
    protected V bucketPut(int h, K k, V v)
    {
        LinkedList<MapEntry<K, V>> bucket = table[h];

        if (bucket == null)
            bucket = table[h] = new LinkedList<>();

        // Check if key already exists
        for (MapEntry<K, V> entry : bucket)
        {
            if (entry.getKey().equals(k))
            {
                V oldValue = entry.getValue();
                entry.setValue(v);
                return oldValue;                    // key exists so the old value is returned
            } // end of if
        } // end of for

        // in case key does not exist, add a new key and return null
        bucket.add(new MapEntry<>(k, v));
        n++;
        return null;
    } // end of bucketPut()

    /**
     * Removes entry having Key k from the bucket with hash value h (if any)
     * @param h hash value of the bucket
     * @param k key of the value
     * @return removed value (if any)
     */
    protected V bucketRemove(int h, K k)
    {
        LinkedList<MapEntry<K, V>> bucket = table[h];

        if (bucket == null)
            return null;

        // iterating through and finding the key
        for (MapEntry<K, V> entry : bucket)
        {
            if (entry.getKey().equals(k))
            {
                V oldValue = entry.getValue();
                bucket.remove(entry);
                n--;
                return oldValue;
            } // end of if
        } // end of enhanced-for

        return null;                // nothing to remove, return null
    } // end of bucketRemove()

    /**
     * Returns an iterable collection of all key-value entries of the map
     * @return collection of all key-value entries of the map
     */
    public Iterable<Entry<K, V>> entrySet()
    {
        LinkedList<Entry<K, V>> buffer = new LinkedList<>();

        for (int h = 0; h < capacity; h++)
        {
            if (table[h] != null)
                buffer.addAll(table[h]);
        } // end of for

        return buffer;
    } // end of entrySet()

    /**
     * Returns the number of collisions in the hash map.
     * A collision occurs when a bucket contains more than one entry.
     * @return total number of collisions
     */
    public int getCollisions()
    {
        int collisions = 0;

        for (LinkedList<MapEntry<K, V>> bucket : table)
        {
            // for each bucket with more than one entry,
            // count all entries but first as collisions
            if (bucket != null && !bucket.isEmpty())
                collisions += bucket.size() - 1;
        } // end of for

        return collisions;
    } // end of getCollisions

} // end of class
