import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * An executable that counts the words in a files and prints out the counts in
 * descending order. You will need to modify this file.
 */
public class WordCount {

    /**
     * Reads in a text file and tally's up all the words that appear in it
     * this particular method has been deprecated for project 4
     * @param file filename (if not in project directory, must include path)
     * @param flag the commandline option
     * @return a string array of words that includes the frequency of the each word
     */
    public static DataCount<String>[] countWords(String file, String flag){
        DataCounter<String> counter;
        switch(flag){
            case "-b":
                counter = new BinarySearchTree<String>();
                break;
            case "-a":
                counter = new AVLTree<String>();
                break;
            case "-h":
                counter = new HashTable();

            default: counter = new HashTable();
        }



        try {
            FileWordReader reader = new FileWordReader(file);
            String word = reader.nextWord();
            while (word != null) {
                counter.incCount(word);
                word = reader.nextWord();
            }
        } catch (IOException e) {
            System.err.println("Error processing " + file + e);
            System.exit(1);
        }

        DataCount<String>[] counts = counter.getCounts();
        insertionSortByDescendingCount(counts);

        return counts;
    }

    /**
     * Reads in a text file and tally's up all the words that appear in it.
     * Method will use different data structures, and sorting methods depending
     * on what options are passed adn print according to the second option.
     * @param dataStructure use -a, -b or -h to choose AVL tree, unbalanced binary search tree or hashtable respectively
     * @param sortMethod -is, -qs, or -ms to use insertion sort, quicksort or merger sort respectively
     * @param file filename (if not in project directory include path)
     * @return sorted string array of the words and their frequencies/number of unique words
     */
    public static DataCount<String>[] countWords(String dataStructure, String sortMethod, String file) {
    	 DataCounter<String> counter;
    	 switch(dataStructure){
    	 	case "-b": 
    	 		counter = new BinarySearchTree<String>();
    	 		break;
    	 	case "-a": 
    	 		counter = new AVLTree<String>();
    	 		break;
    	 	case "-h": 
    	 		counter = new HashTable();
    	 		
    	 	default: counter = new HashTable();
    	 }

        try {
            FileWordReader reader = new FileWordReader(file);
            String word = reader.nextWord();
            while (word != null) {
                counter.incCount(word);
                word = reader.nextWord();
            }
        } catch (IOException e) {
            System.err.println("Error processing " + file + e);
            System.exit(1);
        }
        
        DataCount<String>[] counts = counter.getCounts();
        switch (sortMethod){
            case "-is":
                insertionSortByDescendingCount(counts);
                break;
            case "-qs":
                quickSortByDescendingCount(counts);
                break;
            case "-ms":
                mergeSortByDescendingCount(counts);
                break;
            default: insertionSortByDescendingCount(counts);
        }

        
        return counts;
    }

    /**
     * insertion sort
     *
     * Sort the count array in descending order of count. If two elements have
     * the same count, they should be in alphabetical order (for Strings, that
     * is. In general, use the compareTo method for the DataCount.data field).
     * 
     * This code uses insertion sort. You should modify it to use a different
     * sorting algorithm. NOTE: the current code assumes the array starts in
     * alphabetical order! You'll need to make your code deal with unsorted
     * arrays.
     * 
     * The generic parameter syntax here is new, but it just defines E as a
     * generic parameter for this method, and constrains E to be Comparable. You
     * shouldn't have to change it.
     * 
     * @param counts array to be sorted.
     */
    private static <E extends Comparable<? super E>> void insertionSortByDescendingCount(
            DataCount<E>[] counts) {
        for (int i = 0; i < counts.length; i++) {
            DataCount<E> x = counts[i];
            int j;
           // System.out.println("x:" + x.data + " i:" + i + " length:" + counts.length);
            for (j = i - 1; j >= 0; j--) {
                if (counts[j].count > x.count ||
                	(counts[j].count == x.count &&  counts[j].data.compareTo(x.data) < 0)) {
                	//System.out.println("count:" + counts[j].data + " j:" + j);
                    break;
                }
                counts[j + 1] = counts[j];
            }
            counts[j + 1] = x;
        }
    }

    /**
     * Sort the count array in descending order using the quick sort algorithm
     * @param counts an array containing a count of the words and the word associated with count
     * @param <E> generic data type
     */
    private static <E extends Comparable<? super E>> void quickSortByDescendingCount(
            DataCount<E>[] counts) {

    }

    private static DataCount<E extends Comparable<? super E>>
     median3( DataCount<E>[] a, int left, int right){
        int center = (left + right)/2;
        if (a[right].data > a[left].data) {
            //swapReferences
        }
        return a[0];
    }

    private static <E extends Comparable<? super E>>
    void quicksort( DataCount<E>[] a, int left, int right){
        int CUTOFF = 10;
        if( left + CUTOFF <= right){
            DataCount<E> pivot = median3( a, left, right);

            //Begin partitioning
            int i = left, j = right - 1;

            for(;;){
                while( a[++i].count < pivot.count){}
                while( a[--j].count > pivot.count){}
            }
        }


    }


    /**
     * Sort the count array in descending order using the merge sort algorithm.
     * @param counts an array containing a count of the words and the word associated with count
     * @param <E>
     */
    private static <E extends Comparable<? super E>> void mergeSortByDescendingCount(
            DataCount<E>[] counts) {
        DataCount<E> [] tmpArray = (DataCount<E>) new DataCount<E extends Comparable<? super E>>[counts.length];

        mergeSortDescending(counts, tmpArray, 0, counts.length - 1);
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
    void mergeSortDescending(DataCount<E> [] a, DataCount<E> [] tmpArray, int left, int right){
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
    void merge(DataCount<E> [] a, DataCount<E> [] tmpArray, int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        //cycle through sub arrays and do comparisons filling the tmpArray
        //this does our real sorting
        while( leftPos <= leftEnd && rightPos <= rightEnd ){ //sort according to count, larger first
            if( a[leftPos].count > a[rightPos].count ){
                tmpArray [ tmpPos++ ] = a[ leftPos++ ];
            }
            else if( a[leftPos].count == a[rightPos].count ){ //counts are equal, sort alphabetically
                if( a[leftPos].data.compareTo( a[rightPos].data ) >= 0 ){
                    tmpArray [ tmpPos++ ] = a[ leftPos++ ];
                }
                else {
                    tmpArray [ tmpPos++ ] = a[ rightPos++ ];
                }
            }
            else {
                tmpArray [ tmpPos++ ] = a[ rightPos++ ];
            }
        }

        //Copy rest of first half if any left
        while( leftPos <= leftEnd ){
            tmpArray[ tmpPos++ ] = a[ leftPos++ ];
        }

        //copy rest of right half if any left
        while( rightPos <= rightEnd ){
            tmpArray[ tmpPos++ ] = a[ leftPos++ ];
        }

        //Copy tmpArray back
        for(int i = 0; i < numElements; i++, rightEnd-- ){
            a[ rightEnd ] = tmpArray[ rightEnd ];
        }


    }


    
    public static <E extends Comparable<? super E>> void printWords(DataCount<E>[] counts){
    	for (DataCount<E> c : counts)
            System.out.println(c.count + " \t" + c.data);
    }

    public static String openFile(String filename) throws FileNotFoundException {
        String fileOutput = "";
        try {
            File inputFile = new File(filename);
            //read entire text file by using end of file delimiter
            fileOutput = new Scanner(inputFile).useDelimiter("\\Z").next();
        }
        catch (FileNotFoundException F){
            System.err.println("Error message missing, Bad programmer!");
            System.exit(1);
        }

        return fileOutput;
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 4) {
            String filename = "WordCountCommandlineErrorMsg.txt";
            System.err.println(openFile(filename));
            System.exit(1);
        }

        switch (args[1]){
            case "-frequency":
                printWords(countWords(args[0], args[2], args[3]));
                break;
            case "-num_unique":
                System.out.println("There are " +
                        countWords(args[0], args[2], args[3]).length + " unique words.");
                break;
            default: printWords(countWords(args[0], args[2], args[3]));
        }


    }
}
