

import java.awt.*;
import java.util.ArrayList;
import acm.graphics.*;
/**
* This class creates the spaces for the graphical representation of letters and
* spaces for them in the hangman game
*
*/
@SuppressWarnings("serial")
public class GSpace extends GCompound{
	//arraylists to generate spaces
	ArrayList<GLabel> letters = new ArrayList<GLabel>();
	ArrayList<GRect> lines = new ArrayList<GRect>();
	ArrayList<Character> word = new ArrayList<Character>();
	
	//asthetic
	private final int SPACE_HT = 10,SPACE_WID = 30, SPACING = 10;
	private Font font1 = new Font("Arial",18, 18);
	
	/**
	 *
	 * @param w the word split up into an arraylist of characters
	 */
	public GSpace(ArrayList<Character> w){
		super();
		word = w;
	}
	
	/**
	 * this method laysout the lines and the letters above them for the hangman game
	 */
	public void setupLines(){
	
		for(int i = 0; i<word.size(); i++){
			GRect line = new GRect(SPACE_WID, SPACE_HT);
			line.setFillColor(Color.yellow);
			line.setFilled(true);
			lines.add(line);
			
			GLabel letter = new GLabel(word.get(i)+"");
			letter.setVisible(false);
			letter.setFont(font1);
			letters.add(letter);
			
			if(!(word.get(i) == ' ')){
				add(lines.get(i),SPACE_WID*i + SPACING*i,0);
				add(letters.get(i),SPACE_WID*i + SPACING*i ,-5);
			}
		}
	}
	
	/**
	 *
	 * @param l the correct letter huessed so that it can be shown in the appropriate space
	 */
	public void correctLetterGuessed(char l){
		for(int i = 0; i<letters.size(); i++){
			if(word.get(i) == l) {
				letters.get(i).setVisible(true);
			}
		}
	}
	
	/**
	 *
	 * @return returns if the word has been fully guessed
	 */
	public boolean hasWon(){
		int count = 0;
		for(int i=0;i<letters.size(); i++){
			if(letters.get(i).isVisible())
				count++;

		}
		return(count >= letters.size());
	}

}
