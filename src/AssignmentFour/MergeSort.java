package AssignmentFour;

// import statements
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort
{
    /**
     * Merge sort method that sorts the array by dividing it into two separate arrays recursively and
     * then joining them in order
     * @param S Array that is to be sorted
     * @param comp comparator which provides the base of the sorting
     * @param <K> Literal type of array and the argument of the comparator
     */
    public static <K> void mergeSort(K[] S, Comparator<K> comp)
    {
        int n = S.length;

        if (n < 2)
            return;                                     // array is trivially sorted

        // divide
        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);    // copy of the first half
        K[] S2 = Arrays.copyOfRange(S, mid, n);         // copy of the second half

        // conquer (with recursion)
        mergeSort(S1, comp);                            // sort copy of the first half
        mergeSort(S2, comp);                            // sort copy of the second half

        // merge results
        merge(S1, S2, S, comp);                         // merge sorted halves back into original
    } // end of mergeSort

    /**
     * Method that merges two divided arrays and moves the index as required to match the
     * order provided by the comparator passed as an argument in the method
     * @param S1 first half of the array
     * @param S2 second half of the array
     * @param S combined array
     * @param comp comparator which provides the base of the sorting
     * @param <K> Literal type of array and the argument of the comparator
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp)
    {
        // instance variables
        int i = 0;
        int j = 0;

        while (i + j < S.length)
        {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                S[i+j] = S1[i++];               // copy ith element of S1 and increment i
            else
                S[i+j] = S2[j++];               // copy jth element of S2 and increment j
        } // end of while

    } // end of merge

} // end of MergeSort class
