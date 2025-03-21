package AssignmentThree.QuestionOne;

/**
 * ACS-2947 - Assignment Three
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentThree">GitHub</a>
 */
public class LinkedStack<E> implements Stack<E>
{
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();        // an empty list

    public LinkedStack() {}             // new stack relies on the initially empty list

    public int size() {
        return list.size();
    } // end of size

    public boolean isEmpty() {
        return list.isEmpty();
    } // end of isEmpty

    public void push (E element) {
        list.addFirst(element);
    } // end of push

    public E top() {
        return list.first();
    } // end of top

    public E pop() {
        return list.removeFirst();
    } // end of pop

    @Override
    public String toString()
    {
        return list.toString();
    } // end of toString()

} // end of class
