package AssignmentFour;

import java.util.Comparator;

/**
 * ACS-2927 | Assignment Four <br>
 * Public class that implements the sorting algorithm known as QuickSort that uses the principle of
 * Divide and Conquer to sort values.
 * It takes a comparator to sort the values based on hwo the comparator deals with the values.
 * This is an in-place version of the sorting algorithm, i.e. it uses less resources than the basic
 * quick sort method.
 *
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentFour">GitHub</a>
 */
public class QuickSort
{
    /**
     * Quick-sort contents of a Queue
     * @param S Array S which is to be sorted
     * @param comp comparator with which the queue is sorted
     * @param <K> Generic type K to which the elements belong
     */
    public static <K> void quickSortInPlace(K[] S, Comparator<K> comp, int a, int b)
    {
        if (a >= b)
            return;                 // array is trivially sorted

        int left = a;
        int right = b - 1;
        K pivot = S[b];
        K temp;                     // temp object used for swapping

        while (left <= right)
        {
            // scan until reaching value equal or larger than pivot (or right marker)
            while (left <= right && comp.compare(S[left], pivot) < 0)
                left++;

            // scan until reaching value equal or smaller than pivot (or left markeer)
            while (left <= right && comp.compare(S[right], pivot) > 0)
                right--;

            if (left <= right)          // indices did not strictly cross
            {
                // so swap values and shrink range
                temp = S[left];
                S[left] = S[right];
                S[right] = temp;
                left++;
                right--;
            } // end of if

        } // end of while

        // put pivot into its final place (currently marked by left index)
        temp = S[left];;
        S[left] = S[b];
        S[b] = temp;

        // make recursive calls
        quickSortInPlace(S, comp, a, left - 1);
        quickSortInPlace(S, comp, left + 1, b);

    } // end of quickSort()

} // end of class
