package AssignmentFour;

// import statements
import java.util.LinkedList;

public class LinkedChainHashMap<K, V> extends AbstractHashMap<K, V>
{
    // a fixed capacity array of LinkedList that serve a buckets
    private LinkedList<MapEntry<K, V>>[] table;          // initialised within create table

    // ------------ CONSTRUCTOR ---------------

    public LinkedChainHashMap() {
        super();
    } // end of no-arg constructor

    public LinkedChainHashMap(int initialCapacity) {
        super(initialCapacity);
    } // end of semi-arg constructor

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
        MapEntry<K, V> e = bucket.get(h);
        return e.getValue();                // return the value field from the map entry

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
                return oldValue;
            } // end of if
        } // end of for

        // key doesn't exist, add new entry
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

        int oldSize = bucket.size();

        MapEntry<K, V> e = bucket.remove(h);
        V answer = e.getValue();
        n -= (oldSize - bucket.size());                 // size may have decreased

        return answer;
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

    public int getCollisions()
    {
        int collisions = 0;

        for (int h = 0; h < capacity; h++)
        {
            if (table[h] != null && !table[h].isEmpty())
                collisions += table[h].size() - 1;
        } // end of for

        return collisions;
    } // end of getCollisions

} // end of class
