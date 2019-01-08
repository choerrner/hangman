import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
* Program that handles the checking of the word and and starting or ending the game
*
*/
public class Model {
	
	Hangman display;
	String word;
	
	ArrayList<Character> correctGuesses = new ArrayList<Character>();
	ArrayList<Character> incorrectGuesses = new ArrayList<Character>();
	
	/**
	 *
	 * @param hangman the graphics aspect so the two classes can communicate
	 */
	public Model(Hangman hangman){
		display = hangman;
	}
	
	/**
	 * starts new game with new word
	 */
	public void newGame(){
		Dictionary dic;
		try {
			dic = new Dictionary();
			word = dic.getRandomWord();
		} catch (FileNotFoundException e) {
			System.err.println("Cannot find Dictionary");
		}
		display.layoutGame(word);
		correctGuesses.clear();
		incorrectGuesses.clear();
	}
	
	/**
	 *whenever a letter is guessed there is a check if it is in the word
	 * @param c the character guessed
	 */
	public void letterGuessed(char c){
		
		Character ch = new Character(c);
		c = Character.toUpperCase(ch);
		
		if(correctGuesses.contains(c) || incorrectGuesses.contains(c)){
			display.repeatNotification(c);
			return;
		} else if(word.indexOf(c) >=0){
			display.correctGuess(c);
			display.correctNotification();
			correctGuesses.add(c);
			return;
		} else{
			display.incorrectGuess();
			display.wrongNotification();
			incorrectGuesses.add(c);
			display.showIncorrect(incorrectGuesses);
				return;
		}
	}

	/**
	 *
	 * @return the number of incorrect guesses that have been made
	 */
	public int getWrongGuesses(){
		return incorrectGuesses.size();

	}
}
