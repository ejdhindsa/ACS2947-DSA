package AssignmentThree.QuestionTwo;

import java.util.Comparator;

/**
 * ACS-2947 - Assignment Three
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentThree">GitHub</a>
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V>
{
    /** primary collection of priority queue entries */
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    /** creates an empty priority queue based on the natural ordering of its keys */
    public HeapPriorityQueue() {
        super();
    } // end of HeapPriorityQueue()

    /** Creates an empty priority queue using the given comparator to order keys */
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    } // end of HeapPriorityQueue()

    // protected utilities

    protected int parent(int j) {
        return (j-1) / 2;
    } // end of parent()

    protected int left(int j) {
        return (j*2) + 1;
    } // end of left()

    protected int right(int j) {
        return (j*2) + 2;
    } // end of right

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    } // end of hasLeft()

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    } // end of hasRight()

    /**
     * Exchange entries at indices i and j of the arraylist
     * @param i entry at index i
     * @param j entry at index j
     */
    protected void swap(int i, int j)
    {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    } // end of swap()

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap property
     * @param j entry that is to be moved higher
     */
    protected void upheap(int j)
    {
        while (j > 0)                   // continue until reaching root (or break statment)
        {
            int parent = parent(j);
            if (compare(heap.get(j), heap.get(parent)) >= 0)
                break;

            swap(j, parent);
            j = parent;
        } // end of while
    } // end of upheap

    /**
     * Moves the entry at index j lower, if necessary, to restore the heap property
     * @param j entry that is to be moved below
     */
    protected void downheap(int j)
    {
        while(hasLeft(j))               // continue to bottom or break statement
        {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;

            if (hasRight(j))
            {
                int rightIndex = right(j);

                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex;       // right child is smaller
            } // end of if

            if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
            {
                break;                                  // heap property has been restored
            } // end of if

            swap(j, smallChildIndex);
            j = smallChildIndex;                        // continue at position of the child

        } // end of while
    } // end of downheap

    // ------------- PUBLIC METHODS ---------------

    /**
     * returns the number of items in the priority queue
     * @return number of items in the queue
     */
    public int size() {
        return heap.size();
    } // end of size

    /**
     * Returns (but does not remove) an entry with minimal key (if any)
     * @return entry with the minimal key
     */
    public Entry<K, V> min()
    {
        if(heap.isEmpty())
            return null;

        return heap.get(0);
    } // end of min()

    /**
     * Inserts a key value pair and returns the entry created
     * @param key key of the entry
     * @param value value of the entry
     * @return the entry that has been created
     */
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException
    {
        checkKey(key);                  // auxiliary key checking method (could throw exception)
        Entry<K, V> newest = new PQEntry<>(key, value);

        heap.add(newest);               // add to the end of the list
        upheap(heap.size() - 1);      // upheap newly added entry
        return newest;

    } // end of insert()

    /**
     * Removes and returns an entry with minimal key.
     * @return the removed entry (or null if empty)
     */
    public Entry<K, V> removeMin()
    {
        if (heap.isEmpty())
            return null;

        Entry<K, V> answer = heap.get(0);
        swap(0, heap.size() -1);
        heap.remove(heap.size() - 1);
        downheap(0);

        return answer;
    } // end of removeMin()

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < heap.size(); i++)
        {
            Entry<K, V> entry = heap.get(i);
            sb.append(entry.getValue());

            if (i < heap.size() - 1)
                sb.append(", ");
        } // end of for

        sb.append("]");

        return sb.toString();

    } // end of toString()

} // end of HeapPriorityQueue
