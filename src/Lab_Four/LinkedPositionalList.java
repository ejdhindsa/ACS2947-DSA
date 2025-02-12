package Lab_Four;

/**
 * From Data Structures and Algorithms in Java, Sixth Edition, Goodrich et al.
 *
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Lab_Four">Github</a>
 */

public class LinkedPositionalList<E> implements PositionalList<E> {

    private static class Node<E> implements Position<E> {

        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() throws IllegalStateException {
            if (next == null) {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    // add validate and position methods here
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Invalid p");

        Node<E> node = (Node<E>) p;         // safe cast

        if (node.getNext() == null)         // convention for defunct node
            throw new IllegalArgumentException("p is no longer in the list");

        return node;

    } // end of validate()

    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer)
            return null;

        return node;
    } // end of position

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position<E> first() {
        return position(header.getNext());
    }

    public Position<E> last() {
        return position(trailer.getPrev());
    }

    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    //add addBetween method here
    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ)
    {
        Node<E> newest = new Node<>(e, pred, succ);

        pred.setNext(newest);
        succ.setPrev(newest);
        size++;

        return newest;

    } // end of addBetween()

    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    // add addBefore, addAfter, set and remove methods here
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException
    {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    } // end of addBefore()

    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException
    {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    } // end of addAfter()

    public E set(Position<E> p, E e) throws IllegalArgumentException
    {
        Node<E> node = validate(p);

        E answer = node.getElement();
        node.setElement(e);

        return answer;
    } // end of set()

    public E remove(Position<E> p) throws IllegalArgumentException
    {
        Node<E> node = validate(p);
        Node<E> predeccessor = node.getPrev();
        Node<E> succcessor = node.getNext();

        predeccessor.setNext(succcessor);
        succcessor.setPrev(predeccessor);
        size--;

        E answer = node.getElement();
        node.setElement(null);                  // help with garbage collection
        node.setPrev(null);                     // convention for defunct node
        node.setNext(null);

        return answer;
    } // end of remove()

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> n = header.getNext();
        while (n != trailer) {
            sb.append(n.getElement());
            n = n.getNext();
            if (n != trailer) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}

