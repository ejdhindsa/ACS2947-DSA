package AssignmentFour;

// import staments
import java.util.ArrayList;


/**
 * ACS-2927 | Assignment Four <br>
 * Creates a ProbeHashMap as detailed in the class notes
 * @param <K> Key of the Probe Hash Map
 * @param <V> Value of the Probe Hash Map
 *
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentFour">GitHub</a>
 */
public class ProbeHashMap<K,V> extends AbstractHashMap<K,V>
{
    // instance variables
    private MapEntry<K,V>[] table;          // a fixed array of entries, initially null
    private MapEntry<K,V> DEFUNCT = new MapEntry<>(null, null);       // sentinel

    // ---------- CONSTRUCTORS ---------

    /**
     * No-argument constructor that creates a ProbeHashMap (by calling the super constructor)
     * with no-arguments, that is with capacity 17 and the prime factor 109345121
     */
    public ProbeHashMap()
    {
        super();                // calling superclass (AbstractHashMap)
    } // end of no-argument constructor

    /**
     * Semi-argument constructor that creates an instance of an ProbeHashMap (by calling the super constructor)
     * with the given capacity as provided during the instantiation.
     * It calls the full argument constructor with the capacity as given by the user, and the prime
     * number as provided in the capacitor.
     * @param cap capacity of the hash map
     */
    public ProbeHashMap(int cap)
    {
        super(cap);             // calling superclass (AbstractHashMap)
    } // end of semi-argument constructor

    /**
     * Full argument constructor that creates an instance of ProbeHashMap (by calling the super constructor)
     * with capacity and prime as given by the user.
     * It creates a new random and randomly selects a scale with the help of prime as selected randomly
     * by java's standard random library.
     * It also assigns a shift variable randomly based on the prime provided by the user.
     * @param cap capacity of the hash map
     * @param prime prime factor with which shift and scaling factors are created
     */
    public ProbeHashMap(int cap, int prime)
    {
        super(cap, prime);      // calling superclass (AbstractHashMap)
    } // end of full-argument constructor

    /**
     * Creates an empty table having length equal to current capacity
     */
    protected void createTable()
    {
        table = (MapEntry<K, V>[]) new MapEntry[capacity];      // safe cast
    } // end of createTable()

    /**
     * Returns true if location is either empty or the "defunct" sentinel
     * @param j location in the table that is to be checked
     * @return true if the location is empty, false otherwise
     */
    private boolean isAvailable(int j)
    {
        return (table[j] == null || table[j] == DEFUNCT );
    } // end of isAvailable

    /**
     * Private method that finds a slot, i.e. find a position for the value in the map to be put in
     * @param h index of the arraylist
     * @param k key in the value
     * @return the slot which is available
     */
    private int findSlot(int h, K k)
    {
        int avail = -1;                 // no slot available, thus far
        int j = h;                      // index while scanning table
        do
        {
            if (isAvailable(j))         // may either be empty or defunct
            {
                if (avail == -1)
                    avail = j;          // first available slot
                if (table[j] == null)
                    break;              // if empty search breaks immediately
            } // end of if
            else if (table[j].getKey().equals(k))
            {
                return j;               // successful match
            } // end of else-if
            j = ( j + 1 ) % capacity;   // keep looking (cyclically)
        } while (j != h);               // stop if we return to the start

        return -(avail + 1);            // search has failed

    } // end of findSlot()

    /**
     * Return value associated with key k in the bucket with has value h, or else null
     * @param h hash value in the bucket
     * @param k key in the bucket
     * @return value associated with k and h, or null
     */
    protected V bucketGet(int h, K k)
    {
        int j = findSlot(h, k);
        if (j < 0) return null;         // no match found

        return table[j].getValue();
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
        int j = findSlot(h, k);
        if (j >= 0)                             // this key has an existing entry
            return table[j].setValue(v);

        table [-(j+1)] = new MapEntry<>(k, v);  // convert to proper index
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
        int j = findSlot(h, k);
        if (j < 0) return null;                 // nothing to remove
        V answer = table[j].getValue();
        table[j] = DEFUNCT;                     // mark this slot as deactivated
        n--;
        return answer;
    } // end of bucketRemove()

    /**
     * Returns an iterable collection of all key-value entries of the map
     * @return collection of all key-value entries of the map
     */
    public Iterable<Entry<K, V>> entrySet()
    {
        ArrayList<Entry<K, V>> buffer = new ArrayList<Entry<K, V>>();
        for (int h = 0; h < capacity; h++)
            if (!isAvailable(h))
                buffer.add(table[h]);

        return buffer;
    } // end of entrySet()

} // end of ProbeHashMap Class
