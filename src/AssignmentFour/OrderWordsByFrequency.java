package AssignmentFour;

// import statements
import java.util.Comparator;

public class OrderWordsByFrequency<E> implements Comparator<Entry<String, Integer>>
{
    /**
     * Comparator that compares two entries in terms of words.
     * It sorts them with the ascending order of their frequencies, and if the words are the
     * same, it goes by the natural ordering of character, i.e. by ASCII values
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return integer value that sorts the values as required
     */
    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)
    {
        if (o1.getValue() < o2.getValue())
        {
            return -1;
        } // end of if
        else if (o1.getValue().equals(o2.getValue()))
        {
            return o1.getKey().compareTo(o2.getKey());
        } // end of else-if

        return 1;
    } // end of compare

} // end of OrderWordsByFrequency
