

public class Project3 {

	public static void main(String[] args) {
		//testBST();
		//testAVL();
		//testHashTable();
		//testWordCount();
		testDocCorrelator();
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
	
	static void testWordCount(){
		String[] cmd = {"hamlet.txt", "-b"};
		WordCount.main(cmd);
	}
	
	static void testDocCorrelator(){
		String[] cmd = {"completeWorksofShakespeare.txt", "hamlet.txt", "-h"};
		DocCorrelator.main(cmd);
	}
	
	
}
