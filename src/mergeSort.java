import java.util.ArrayList;

/**
 * Created by Branden on 10/22/2015.
 */
public class mergeSort {

    public static <E extends DataCount<? super E>>
    void mergeSortByDescendingCount(
            E[] counts) {
        Object[] tmpArray = new Object[counts.length];

        mergeSortDescending(counts, (E[])tmpArray, 0, counts.length - 1);
    }

    /**
     * Internal method for the mergesort algorithm that makes recursive calls
     * that divide and conquer the array
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param left the left-most index of the subArray
     * @param right the right-most index of the subarray
     * @param <E> generic data type
     */
    private static <E extends Comparable<? super E>>
    void mergeSortDescending(DataCount<E> [] a, ArrayList<DataCount<E>> tmpArray,
                             int left, int right){
        if(left < right) {
            int center = (left + right) / 2;
            mergeSortDescending(a, tmpArray, left, center);
            mergeSortDescending(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    /**
     * Internal method that merges two sorted halves of a subarray.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param leftPos the left-most index of the subarray.
     * @param rightPos the index of the start of the second half.
     * @param rightEnd the right-most index of the subarray
     * @param <E>
     */
    private static <E extends Comparable<? super E>>
    void merge(DataCount<E> [] a, ArrayList<DataCount<E>> tmpArray,
               int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        //cycle through sub arrays and do comparisons filling the tmpArray
        //this does our real sorting
        while( leftPos <= leftEnd && rightPos <= rightEnd ){ //sort according to count, larger first
            if( a[leftPos].count > a[rightPos].count ){
                tmpArray.add(tmpPos++, a[ leftPos++ ]);


            }
            else if( a[leftPos].count == a[rightPos].count ){
                //counts are equal, sort alphabetically
                if( a[leftPos].data.compareTo( a[rightPos].data ) <= 0 ){
                    tmpArray.add(tmpPos++, a[ leftPos++ ]);
                }
                else {
                    tmpArray.add(tmpPos++, a[ rightPos++ ]);
                }
            }
            else {
                tmpArray.add(tmpPos++, a[ rightPos++ ] );
            }
        }

        //Copy rest of first half if any left
        while( leftPos <= leftEnd ){
            tmpArray.add(tmpPos++, a[ leftPos++ ]);
        }

        //copy rest of right half if any left
        while( rightPos <= rightEnd ){
            tmpArray.add(tmpPos++, a[ rightPos++ ]);
        }

        //Copy tmpArray back
        for(int i = 0; i < numElements; i++, rightEnd-- ){
            a[ rightEnd ] = tmpArray.get(rightEnd);
        }


    }

}
