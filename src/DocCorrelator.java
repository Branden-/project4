import java.util.*;
import java.util.concurrent.TimeUnit;

class DocCorrelator {
	
	//variables to time how long it takes to execute the different data structures
	static long startTime1;
	static long startTime2;
	static long endTime1;
	static long endTime2;
	static long measuredTime1;
	static long measuredTime2;
	
	
	/**
	 * constructor for the DocCorrelator class
	 * @param file1 file name of first file to examine
	 * @param file2 filename second file to examine
	 * @param flag the commandline argument to use what flag
	 * @return the correlation number
	 */
	public static double DocCorrelate(String file1, String file2, String flag){
		startTime1 = System.nanoTime();
		DataCount<String>[]list1 = WordCount.countWords(file1, flag);
		startTime2 = System.nanoTime();
		DataCount<String>[]list2 = WordCount.countWords(file2, flag);
		
		WordFreq[] list1Nor = docNormalize(list1);
		WordFreq[] list2Nor = docNormalize(list2);
		double correlator = 0;
		int i, ii;
		
		for (i = 0; i < list1Nor.length; i++){
			for(ii = 0; ii < list2Nor.length; ii++){
				if(list1Nor[i].compareTo(list2Nor[ii]) == 0){
					correlator = correlator + Math.pow(list1Nor[i].frequency - list2Nor[ii].frequency, 2);
				}
			}
		}
		
		printComparison(list1Nor, list2Nor);
		endTime1 = endTime2 = System.nanoTime();
		measuredTime1 = endTime1 - startTime1;
		measuredTime2 = endTime1 - startTime2;
		System.out.println("The correlator number: " + correlator + "(%^2)");
		System.out.println("It took " + TimeUnit.NANOSECONDS.toSeconds(measuredTime1) + 
				" seconds to tokenize, sort and count the words in the file " + file1);
		System.out.println("It took " + TimeUnit.NANOSECONDS.toSeconds(measuredTime2) + 
				" seconds tokenize, sort and count the words in the file " + file2);
		return correlator;
	}
	
	/**
	 * @param list
	 * @return
	 */
	static public WordFreq[] docNormalize(DataCount<String>[] list){
		ArrayList<WordFreq> listNor = new ArrayList<WordFreq>();
		final double min_freq = 0.0001;
		final double max_freq = 0.01;
		double freq = 0;
		int i;
		int wordSum = 0;
		WordFreq newData;

		for (i = 0; i < list.length; i++){
		wordSum = wordSum + list[i].count;
		}
		
		for (i = 0; i < list.length; i++){
			freq = ((double)list[i].count / wordSum) * 100;
			if(freq >= min_freq && freq <= max_freq){
				newData = new WordFreq(list[i].data, freq);
				listNor.add(newData);
			}
		}
		
		return listNor.toArray(new WordFreq[listNor.size()]);
	}
	
	/**
	 * @param list1
	 * @param list2
	 */
	public static void printComparison(WordFreq[] list1, WordFreq[] list2){
		int max_length = Math.max(list1.length, list2.length);
		
		for(int i = 0; i < max_length; i++){
			if(i < list1.length){
				System.out.printf("%20s\t%.5f%s\t\t", list1[i].word, list1[i].frequency, "%");
			}
			if(i < list2.length){
				System.out.printf("%20s\t%.5f%s\t\t", list2[i].word, list2[i].frequency, "%");
			}
			System.out.println();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DocCorrelate(args[0], args[1], args[2]);
	}
	

}
