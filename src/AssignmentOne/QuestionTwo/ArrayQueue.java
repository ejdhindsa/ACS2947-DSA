package AssignmentOne.QuestionTwo;

/**
 * ACS-2927 | Assignment One <br>
 * The ArrayQueue class implements an array using the notes as provided in the class lectures.
 * ArrayQueue works on the FIFO, i.e. first-in-first-out principle.
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Assignment_One">GitHub</a>
 */

public class ArrayQueue<E> implements Queue<E>
{
    // NOTE:
    // This class has not been documented as it was provided with the lecture notes
    // and simply is a direct copy-paste of the provided code

    // instance variable of ArrayQueue
    private static final int CAPACITY = 1000;
    private E[] data;
    private int front = 0;
    private int size = 0;

    public ArrayQueue()
    {
        this(CAPACITY);
    } // end of no arg constructor

    public ArrayQueue(int capacity)
    {
        data = (E[]) new Object[capacity];
    } // end of full-arg constructor

    public int size()
    {
        return size;
    } // end of size()

    public boolean isEmpty()
    {
        return size == 0;
    } //  end of isEmpty()

    public void enqueue(E element) throws IllegalStateException
    {
        if (size == data.length)
            throw new IllegalStateException("Queue is full");

        int avail = (front + size) % data.length;
        data[avail] = element;
        size++;

    } // end of enqueue

    public E first()
    {
        if (isEmpty())
            return null;
        return data[front];
    } // end of first

    public E dequeue()
    {
        if (isEmpty())
            return null;

        E answer = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        return answer;

    } // end of dequeue

    @Override
    public String toString()
    {
        // creating an instance of StringBuilder
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        // using a for loop to print everything
        for(int i = 0; i < size; i++)
        {
            // this appends the data into the queue while also considering the rotating effect that
            // the queue has
            sb.append(data[(front + i) % data.length]);

            if (i < size - 1)
                sb.append(", ");            // only append if not the last element

        } // end of for loop
        sb.append("]");

        return sb.toString();

    } // end of toString()

} // end of arrayQueue
