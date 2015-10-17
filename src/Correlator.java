/**
 * 
 */

/**
 * @author Branden
 *
 */
public class Correlator {

	/**
	 * @param args commandline arguments
	 */
	public static void main(String[] args) {
		if(args.length != 3){
			System.err.println("Incorrect number of arguments");
			System.err.println("Usage: java WordCount [ -b | -a | -h] <FILENAME1> <FILENAME2>");
			System.err.println("-b Use an Ubnalanced BST in the backend");
			System.err.println("-a Use an AVL Tre in the backend");
			System.err.println("-h Use a Hashtable in the backend");
			System.exit(1);
		}
		
		DocCorrelator.main(args);

	}

}
