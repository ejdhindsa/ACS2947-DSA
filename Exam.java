public class Exam
{
    /** ---------------------------- SORTING --------------------------------- */

    // --------------------- START MERGE SORT -------------------------

    /**
    - Merge Sort : Coding Steps
    - Check if array is size 0 or 1, if true return
    - Divide array into two parts from half
    - Recursively divide the array again
    - Merge the results (In a merge method):
        - Use i and j for length of S1 and S2
        - Loop until their total is less than S.length
        - If length of j = S1 or (i < s1.length and comp.compare(S1[i], S2[j] < 0))
            - s[i+j] = s1[i++]
        - Else
            - s[i+j] = s2[j++]
     */

    public static <K> void mergeSort(K[] S, Comparator<K> comp)
    {
        int n = S.length;

        // return if length is 0 or 1 since already sorted
        if (n < 2)
            return;

        // divide the array into two parts
        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);         // first half
        K[] S2 = Arrays.copyOfRange(S, mid, n);         // second half

        // conquer with recursion
        mergeSort(S1, comp);
        mergeSort(S2, comp);

        // merge results
        merge(S1, S2, S, comp)

    } // end of mergeSort

    public <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp)
    {
        int i =0;
        int j = 0;

        while (i+j < S.length)
        {
            if (j == S2.length || (i < S1.length && comp.compare(i, j) < 0))
                S[i+j] = S1[i++];
            else
                S[i+j] = S2[j++];
        } // end of while

    } // end of merge
    // --------------------------- END OF MERGE SORT ----------------------------

    // ------------------------ START QUICK SORT----------------------------

    /**
     * Quick Sort: Coding Guide
     * If the size of the queue is less than 2, return it is already sorted
     * Create three queues, L, E, G
     * Select a pivot point
     * Add anything greater than that pivot point to G
     * Equal to the pivot point in E
     * Smaller than that pivot point to L
     * Call quickSort() again on L and G
     * Concatenate everythign by running a while loop on L, E and G
     */
    public static K[] void quickSort(Queue<K> S, Comparator<K> comp)
    {
        // if size of queue is 0 or 1, it is already sorted
        int n = S.size();
        if (n < 2)
            return;

        K pivot = S.first();                    // using first as pivot
        Queue<K> L = new LinkedQueue<>();
        Queue<K> E = new LinkedQueue<>();
        Queue<K> G = new LinkedQueue<>();

        while(!S.Empty())
        {
            K element = S.dequeue();
            int c = comp.compare(element, pivot);

            // starting and if else chain to check element against the pivot
            if (c < 0)
                L.enqueue(element);
            else if (c == 0)
                E.enqueue(element);
            else
                G.enqueue(element)

        } // end of while

        // conquer
        quickSort(L, comp);
        quickSort(G, comp);

        // concatenate results
        while(!L.isEmpty)
            S.enqueue(L.dequeue);
        while(!E.isEmpty)
            S.enqueue(E.dequeue);
        while(!G.isEmpty)
            S.enqueue(G.deqeueu);

    } // ----------------------- END OF QUICK SORT -----------------------------------

    // -------------------- START OF QUICK SORT IN PLACE --------------------------
    /**
     * coding Guide: Quick sort in place
     * Needs to be done with an array
     * int a = left end
     * int b = right end -1
     * return if a > b (array is trivially sorted)
     * pivot = last element S[b]
     * run a loop until left is less than right
     *      until left is less than right and compare of left and pivot is < 0
     *          left++
     *      until left is less than right and compare right and pivot is > 0
     *          right++
     *      swap elements using temp if left <= right
     * using temp, change swap left and b
     * call quick sort again on the array from a to left -1 and left + 1 to b
     */
    public static K[] void quickSortInPlace(K[] S, Comparator<K> comp, int a, int b)
    {
        if (a >= b)
            return;             // sub array is trivially sorted

        int left = a;
        int right = b - 1;
        K pivot = S[b];
        K temp;

        while(left <= right)
        {
            // scan until reaching value equal or larger than the pivot (or right marker)
            while(left <= right && comp.compare(S[left], pivot) < 0)
                left++;
            // scan until reaching value equal or smaller than the pivot (or left marker)
            while (left <= right && comp.compar(S[right], pivot) > 0)
                right--;
            // indices do no strictly cross
            if (left <= right)
            {
                temp = S[left];
                S[left] = S[right];
                S[right] = temp;
                left++;
                right--;
            } // end of if
        } // end of while

        // put pivot into its final place (currently marked by left index)
        temp = S[left];
        S[left] = S[b];
        S[b] = temp;

        // make recursice call
        quickSortInPlace(S, comp, a, left - 1);
        quickSortInPlace(S, comp, left+1 , b);

    } // -------------------- END OF QUICK SORT IN PLACE ----------------------

    /** ------------------------------ MAPS --------------------------------------- */

    // ----------------------- ABSTRACT HASHMAP --------------------

    // ---- KEY SET METHODS ----

    /**
     * Coding Guide:
     * Create a KeyIterator class
     *      uses the iterator from entrySet
     *      make hasNext, next and remove
     * create a keyIterable method
     *      has a iterator method that calls the keyIterable class
     * create a keyset method that calls the keyIterable class
     */
    private class KeyIterator implements Iterator<K>
    {
        private Iterator<Entry<K, V>> entries = entrySet().iterator();      // reuse entrySet()

        public boolean hasNext() { return entries.hasNext(); }
        public K next() { return entries.next().getKey(); }
        public void remove() {throw new UnsupportedOperationException(); }

    } // end of keyIterator

    private class KeyIterable implements Iterable<K>
    {
        public Iterator<K> iterator
        {
            return new KeyIterator();
        } // end of iterator
    } // end of KeyIterable()

    public Iterable<K> keySet()
    {
        return new KeyIterable();
    } // end of keySet()

    // ---- END OF KEY SET -----

    // ---- VALUE ITERATOR METHODS -----

    /**
     * Coding guide, same as keySet() but with values
     */
    public class ValueIterator implements Iterator<V>
    {
        Iterator<Entry<K, V>> values = new entrySet().iterator();

        public boolean hasNext() { return values.hasNext(); }
        public V next() { return values.next().getValue(); }
        public void remove() { throw new UnsupportedOperationException(); }
    } // end of ValueIterator

    public class ValueIterable implements Iterable<V>
    {
        public Iterator<V> iterator()
        {
            return new ValueIterator();
        } // end of iterator
    } // end of valueIterable

    public Iterable<V> valueSet()
    {
        return new ValueIterable()
    } // end of valueSet()

    // -------------- UNSORTED TABLE MAP ---------------

    // ---- EntrySet() ----
    /**
     * Coding Guide: Same as ValueSet() and KeySet(), minor differences
     */
    public class EntryIterator implements Iterator<Entry<K, V>>
    {
        private it j = 0;

        public boolean hasNext() { return j < table.size(); }

        public Entry<K, V> next()
        {
            if (j == table.size())
                return new NoSuchElementException();

            return table.get(j);
        } // end of next()

        public void remove() { throw new UnsupportedOperationException(); }

    } // end of class

    public class EntryIterable implements Iterable<Entry<K, V>>
    {
        public Iterator<Entry<K, V>> iterator() { return new EntryIterator(); }
    } // end of class

    public Iterator<Entry<K, V>> entrySet()
    {
        return new EntryIterable();
    } // end of entrySet()
    // ---- END OF ENTRY SET ----

    // ------------------- ABSTRACT HASH MAP METHODS --------------------

    public V get(K key) {
        return bucketGet(hashValue(key), key);
    } // end of get

    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    } // end of remove

    public V put(K key, V value) {
        V answer = bucketPut(hashValue(h), K key, V value);
        if (n > capacity / 2)
            resize(2 * capacity - 1);   // minus one tells that it cannot be an even number
        return answer;
    } // end of value

    // [(ai+b) mod p] mod N
    public int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode()*scale + shift) % prime) % capacity)
    } // end of hashValue()

    /**
     * Coding Guide:
     * Create a new arraylist of entries
     * run a for-each loop on entrySet() and add all to the arraylist
     * set capacity to be new capacity
     * set n to be 0
     * make new table by createTable()
     * put all the elements back using a for-each loop on the arraylist and using the put function
     */
    private void resize(int newCapacity) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(n);
        for(Entry<K, V> e : entrySet())
            buffer.add(e);
        capacity = newCapacity;
        createTable();
        n = 0;
        for(Entry<K, V> e : buffer)
            put(e.getKey(), e.getValue());
    } // end of resize

    /*
    Methods like:
    createTable(), bucketPut(), bucketGet(), bucketRemove() are made in subclasses
     */

    // ---------------------- END OF ABSTRACT HASH MAP METHODS --------------------

    // ------------------------- CHAIN HASH MAP -------------------------------

    private void createTable() {
        table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    } // end of createTable()

    protected V bucketGet(int k, K key)
    {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) return null;
        return bucket.get(k);
    } // end of bucketGet()

    public V bucketPut(int h, K k, V v)
    {
        UnsortedTableMap<K, V> bucket = table[h];

        if (bucket == null)
            bucket = table[h] = new UnsortedTableMap<>(h);

        int oldSize = bucket.Size();
        V answer = bucket.put(k, v);
        n += (bucket.size() - oldSize);             // size may have decreased
        return answer;

    } // end of bucketPut()

    protected bucketRemove(int h, K key) {
        UnsortedTableMap<K, V> bucket= table[h];
        if (bucket == null) return null;
        int oldSize = bucket.size();
        V answer = bucket.remove(key);
        n -= (oldSize - bucket.size());
        return answer;
    } // end of bucketRemove()

    public Iterable<Entry<K, V>> entrySet()
    {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++)
            if (table[h] != null)
                for(Entry<K, V> entry : table[h].entrySet())
                    buffer.add(entry);

        return buffer;
    } // end of entrySet()

    // --------------------- END OF CHAIN HASH MAP ----------------------

    // ----------------------- PROBE HASH MAP --------------------------

    private boolean isAvailable(int j) {
        return (table[j] == null || table[j] ==  DEFUNCT);
    } // end of isAvailable()

    private int findSlot(int h, K k)
    {
        int avail = -1;                 // no slot available (thus far)
        int j = h;
        do {
            if (isAvailable(j)) {
                if (avail == -1) avail = j;         // first available slot
                if (table[j] == null) break;        // if empty, search fails immediately
            }
            else if (table[j].getKey().equals(k))
                return j;                           // successful match
            j = (j + 1) % capacity;                 // cyclically looking
        } while (j != h);                           // stop if we return to the start

        return -(avail + 1);                        // search has failed
    } // end of findSlot()

    protected V bucketGet(int h, K k)
    {
        int j = findSlot(h, k);
        if (j < 0) return null;
        return table[j].getValue();
    } // end of bucketGet()

    protected V bucketPut(int h, K k, V v)
    {
        int j = findSlot(h, k);
        if (j >= 0)
            return table[j].setValue(v);

        table[-(j+1)] = new MapEntry<>(k, v);
        n++;
        return null;
    } // end of bucketPut()

    protected V bucketRemove(int h, K k)
    {
        int j = findSlot(h, k);
        if (j < 0) return null;
        V answer = table[j].getValue();
        table[j] = DEFUNCT;
        n--;
        return answer;
    } // end of bucketRemove()

    public Iterable<Entry<K, V>> entrySet()
    {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++)
            if (!isAvailable(h))
                buffer.add(h);

        return buffer;
    } // end of entrySet()

    /** ----------------------------------- TREES --------------------------------------- */

    // --------------- TREE ------------------

    public int depth(Position<E> p)
    {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    } // end of depth

    public int height(Position<E> p)
    {
        int h = 0;
        for(Position<E> c : children(p) )
            h = Math.max(h, 1 + height(c));

        return h;
    } // end of height

    /**
     * Coding Guide:
     * Validate p
     * Check if it has two children, if it does, it is not possible
     * Check whether it is the right or the left child
     * Set its grandparent to be the parent of the child
     * if the tree is root, set its parent to be null
     * if node is not root, set it to be the right or the right child
     * save the current value
     * make the current node defunct
     * return the current value
     */
    public E remove(Position<E> p) throws IllegalArgumentException
    {
        Node<E> node = validate(p);
        if(numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");

        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());

        // set grandparent of child to be the parent
        if (child != null)
            child.setParent(node.getParent());

        // if node was root, make the child root
        if (node == root)
            root = child;
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        } // end of else

        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return temp;

    } // end of remove()

    // ---- TRANSVERSALS ----

    private class ElementIterator implements Iterator<E>
    {
        Iterator<Position<E>> postIterator = positions().iterator();
        public boolean hasNext() { return postIterator.hasNext(); }
        public E next() { return postIterator.next().getElement(); }
        public void remove() { postIterator.remove(); }
    } // end of class

    public Iterator<E> iterator() {return new ElementIterator(); }

    /** PREORDER */
    /*
    Coding guide:
    A preorder method creates an arraylist, it will be the snapshot
    Check if the array is empty
    If not, call the preorderSubtree method that will recursively go throught the tree
    The said method, adds p to the snapshot
    In a for each loop for its children,
    It calls itself recursively on its children (c) and snapshot
     */
    private void preOrderSubtree(Position<E> p, List<Position<E>> snapshot)
    {
        snapshot.add(p);
        for (Position<E> c : children(p))
            preOrderSubtree(c, snapshot);
    } // end od preOrderSubtree

    public Iterable<Position<E>> preorder()
    {
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            preOrderSubtree(root(), snapshot);
        return snapshot;
    } // end of preorder

    /** POSTORDER */
    /*
    Coding guide:
    Same as preorder, only adding to snapshot is after the for-each loop
     */
    public Iterator<Position<E>> postorder()
    {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postOrderSubtree(root(), snapshot);
        return snapshot;
    } // end of preOrder()

    private void postOrderSubtree(Postion<E> p, List<E> snapshot)
    {
        for(Position<E> c : children(p))
            postOrderSubtree(c, snapshot);

        snapshot.add(p);
    } // end of postOrderSubtree

    /** BREADTH-FIRST */
    /*
    Coding Guide:
    Create an array list named snapshot
    If the tree is not empty:
    Make a Queue
    Add root to the queue
    Start a while loop while fringe (queue) is not empty
    Make position p of fringe dequeue
    Add p to snapshot
    In a for loop, go through children of p
    Add them to the queue as well
    Return snapshot
     */
    public Iterable<Position<E>> breadthFirst()
    {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty)
        {
            Queue<Position<E>> fringe = new LinkedQueue();
            fringe.enqueue(root());
            while(!fringe.isEmpty())
            {
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for (Position<P> c : children(p))
                    fringe.enqueue(c);
            } // end of while
        } // end of if

        return snapshot;

    } // end of breadthFirst()

    /** INORDER */
    /*
     Coding Guide:
     In inorder method:
        Make an arraylist of type list
        If tree is not empty
        Call inorderSubtree on root and snapshot
     In inorderSubtree method:
        Check if p has a left child
        Call inorder subtree on the left child
        Add p to the snapshot
        Check if p has a right child
        Call inorder subtree on the right child
     */
    public Iterable<Position<P>> inorder()
    {
        List<Position<P>> snapshot = new ArrayList<>();
        if(!isEmpty)
            inorderSubtree(root(), snapshot);

        rerturn snapshot()
    } // end of inorder()

    private void inorderSubtree(Position<E> p, List<E> snapshot)
    {
        if (left(p) != null)
            inorderSubtree(left(p), snapshot);
        snapshot.add(p);
        if (right(p) !=)
            inorderSubtree(right(p), snapshot);
    } // end of inorderSubtree

    /** -------------------------- PRIORITY QUEUES ------------------------ */

    protected boolean checkKey(K key) throws IllegalArgumentException
    {
        try {
            return (comp.compare(key, key)) == 0 // see if the key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        } // end of catch
    } // end of boolean

    protected void swap(int i, int j)
    {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    } // end of swap

    public Entry<K, V> insert (K key, V value) throws IllegalArgumentException
    {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        upheap(heap.size() - 1);
        return newest;
    } // end of insert

    protected void upheap(int j)
    {
        while(j > 0)
        {
            int p = parent(j);
            if(compare(heap.get(j), heap.get(p) ) >= 0) break;
            swap(j, p);
            j = p;
        } // end of while
    } // end of upheap

    public Entry<K, V> removeMin()
    {
        if(heap.isEmpty()) return null;
        Entry<K, V> answer = heap.get(0);
        swap(0, heap.size() -1);
        heap.remove(heap.size() - 1);
        downheap(0);
        return answer;
    } // end of removeMin()

    protected void downheap(int j)
    {
        while(hasLeft(j))
        {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j))
            {
                int rightIndex = right(j);
                if(compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex;
            } // end of if
            if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
                break;

            swap(j, smallChildIndex);
            j = smallChildIndex;
        } // end of while
    }


} // end of Exam
