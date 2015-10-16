
public class WordFreq{
	public String word;
	public double frequency;
	
	public WordFreq(String word, double frequency){
		this.word = new String(word);
		this.frequency = frequency;
	}
	
	int compareTo(WordFreq cmp){
		return word.compareTo(cmp.word);
	}
	}