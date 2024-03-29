
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
*  Class that creates a dictionary of words to use. Words.txt come from
*  https://www.hangmanwords.com/words
*
**/
public class Dictionary {
	
	Scanner scan;
	ArrayList<String> words;
	
	public Dictionary() throws FileNotFoundException {
		scan = new Scanner(new File("Words.txt"));
		words = new ArrayList<String>();
		
		while(scan.hasNextLine()) {
			words.add((scan.nextLine()).toUpperCase());
		}
		
	}
	
	public String getRandomWord() {
		int index = (int) (Math.random() * words.size());
		
		return words.get(index);
		
	}
	


}
