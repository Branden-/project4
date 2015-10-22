import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class Project3 {

	public static void main(String[] args) {
		//testBST();
		//testAVL();
		//testHashTable();
		//testWordCount();
		//testDocCorrelator();
		testSortPerformance();
	}

	
	static void testAVL(){
		
		AVLTree<String> tree = new AVLTree<String>();
		
		for (int i = 0; i < 10000; i++) {
			tree.incCount(String.valueOf(i));
		}
			System.out.println(tree.dump());
	}
	
	static void testHashTable(){
		HashTable table = new HashTable();
		for (int i = 0; i < 10; i++) {
			table.incCount(String.valueOf(i));
		}
		for (int i = 0; i < 10; i++) {
			table.incCount(String.valueOf(i));
		}
		table.printHashTable();
	}
	
	static void testWordCount() throws FileNotFoundException{
		String[] cmd = {"hamlet.txt", "-b"};
		WordCount.main(cmd);
	}
	
	static void testDocCorrelator(){
		String[] cmd = {"completeWorksofShakespeare.txt", "hamlet.txt", "-h"};
		DocCorrelator.main(cmd);
	}
	
	static void testSortPerformance(){
		String[] sortType = {"-is", "-qs", "-ms"};
		long[] startTime = new long[3];
		long[] endTime = new long[3];
		long[] durTime = new long[3];
		String file = "completeWorksofShakespeare.txt";
		
		for (int i = 0; i < 3; i++){
			startTime[i] = System.nanoTime();
			WordCount.countWords("-b", sortType[i], file);
			endTime[i] = System.nanoTime();
			durTime[i] = endTime[i] - startTime[i];
			System.out.println("For file: " + file + " sort type of " + sortType[i] + " take(ms): " + TimeUnit.NANOSECONDS.toMillis(durTime[i]));
		}
				
				
	}
	
	
}
