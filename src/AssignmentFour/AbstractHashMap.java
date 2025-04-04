package AssignmentFour;

// import statement for libraries
import java.util.LinkedList;
import java.util.Random;

/**
 * ACS-2927 | Assignment Four <br>
 * Following is the abstract implementation of the AbstractHashMap that extends AbstractMap, it provides
 * some concrete methods that are inherited by its subclasses.
 * @param <K> Key of the Hash Map
 * @param <V>  Value of the Hash Map
 *
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentFour">GitHub</a>
 */
public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V>
{
    // instance variables
    protected int n = 0;        // number of entries in the dictionary
    protected int capacity;     // length of the table
    private int prime;          // prime factor
    private long scale, shift;  // the shift and scaling factors

    // ------------ CONSTRUCTORS --------------

    /**
     * Full argument constructor that creates an instance of AbstractHashMap with capacity and prime
     * as given by the user.
     * It creates a new random and randomly selects a scale with the help of prime as selected randomly
     * by java's standard random library.
     * It also assigns a shift variable randomly based on the prime provided by the user.
     * @param capacity capacity of the hash map
     * @param prime prime factor with which shift and scaling factors are created
     */
    public AbstractHashMap(int capacity, int prime)
    {
        this.capacity = capacity;                   // capacity of the hashmap
        this.prime = prime;                         // prime factor
        Random rnd = new Random();                  // random variable
        scale = rnd.nextInt(prime - 1) + 1;   // scale variable
        shift = rnd.nextInt(prime);                 // shift variable
        createTable();                              // calls the create table method
    } // end of full-argument constructor

    /**
     * Semi-argument constructor that creates an instance of an AbstractHashMap with the given
     * capacity as provided during the instantiation.
     * It calls the full argument constructor with the capacity as given by the user, and the prime
     * number as provided in the capacitor.
     * @param capacity capacity of the hash map
     */
    public AbstractHashMap(int capacity)
    {
        // calls super constructor
        // given capacitor, with the prime factor 109345121
        this(capacity, 109345121);
    } // end of semi-arg constructor

    /**
     * No-argument constructor that creates an AbstractHashMap with no-arguments, that is with
     * the capacity 17 and the prime factor 109345121
     */
    public AbstractHashMap()
    {
        this(17);
    } // end of no-arg constructor

    // ----------- PUBLIC METHODS ------------

    /**
     * Public access method that returns the size of the hashmap
     * @return size of the hashmap
     */
    public int size() {
        return n;
    } // end of size

    /**
     * Public access method which takes the key as the parameter and returns that is associated to
     * the key to the user
     * @param key  the key whose associated value is to be returned
     * @return
     */
    public V get(K key) {
        return bucketGet(hashValue(key), key);
    } // end of get

    /**
     * Public update method that takes a key as the parameter and removes the value that it
     * is associated to in the hashmap
     * @param key  the key whose entry is to be removed from the map
     * @return the value that has been removed
     */
    public V remove (K key) {
        return bucketRemove(hashValue(key), key);
    } // end of remove

    /**
     * Public update method that places the value and the key associated to the said value in
     * the hashmap.
     * If the size of the hashmap increases its capacity (since the load factor must be maintained
     * at 0.5), it increases its new capacity to be one less than twice the original capacity
     * @param key    key with which the specified value is to be associated
     * @param value  value to be associated with the specified key
     * @return the value and key that have been added to the hashmap
     */
    public V put (K key, V value)
    {
        V answer = bucketPut(hashValue(key), key, value);
        if (n > capacity / 2)                   // keep load factor <= 0.5
            resize(2 * capacity -1);            // or find a nearby prime

        return answer;
    } // end of put

    // ------------ PRIVATE UTILITIES ----------------

    /**
     * Private method that returns the hash value of the key that has been provided.
     * It works with the simple formula (always positive) as given in the method
     * @param key the key of which the hash value is required
     * @return hashValue of the key
     */
    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    } // end of hashValue()

    /**
     * Private resize method that resizes the hashmap to the new capacity that has been provided
     * as the parameter in the said method
     * @param newCapacity new capacity of the hashmap
     */
    private void resize(int newCapacity)
    {
        // creating a new arraylist with size n
        LinkedList<Entry<K, V>> buffer = new LinkedList<Entry<K, V>>();

        // populating buffer with existing values
        for (Entry<K, V> e : entrySet())
            buffer.add(e);

        capacity = newCapacity;         // setting capacity to the new capacity
        createTable();                  // calling the create table method
        n = 0;                          // setting current size to zero
        for (Entry<K, V> e : buffer)
            put(e.getKey(), e.getValue());  // placing all key and values of the  previous hashmap to current

    } // end of resize()

    // ------------- PROTECTED HASHMAP METHODS ---------------
    // ----------- ( implemented in subclasses ) -------------

    protected abstract void createTable();

    protected abstract V bucketGet(int h, K k);

    protected abstract V bucketPut(int h, K k, V v);

    protected abstract V bucketRemove(int h, K k);

} // end of class
