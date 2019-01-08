import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
* Model and Console of a HANGMAN program. Creates an instance of the model and
* the graphics program.
*
* Uses the keyboard.
*
* Makes use of the ACM Graphics Program 
* found at https://cs.stanford.edu/people/eroberts/jtf/index.html
*
*/

@SuppressWarnings("serial")
public class Hangman extends GraphicsProgram{
	
	private static final int APP_HEIGHT = 500;
	private static final int APP_WIDTH = 1000;
	
	JButton newGame;
	Model model;
	HangmanGraphics body;
	JLabel message;
	String Word;
	boolean gameRunning= true;
	GSpace space;
	private static final double WRONG_GUESS_PLACE_X = .4;
	private static final double WRONG_GUESS_PLACE_Y = .7;

	Font FONT_1 = new Font("Comic Sans MS", Font.BOLD, 16);
	ArrayList<Character> letters = new ArrayList<Character>();
	
	public static void main(String[] args){
		new Hangman().start();
	}

	@Override
	/**
	 * initiates the model and the view
	 */
	public void init(){
		setSize(APP_WIDTH, APP_HEIGHT);
		setBackground(new Color(166,237,193));
		model = new Model(this);
		message = new JLabel("Welcome to HANGMAN! Type a letter to guess...");
		message.setFont(FONT_1);
		add(message, NORTH);
		add(new JButton("New Game"), SOUTH);
		addActionListeners();
		addKeyListeners();
		this.setFocusable(true);
		this.hasFocus();

		model.newGame();
	}
	
	/**
	 * takes the word created by the model and makes a new instance
	 * of Hangman Graphics, and adds the first piece (the gallow)
	 *
	 * @param word the word randomly picked from the dictionary
	 */
	public void layoutGame(String word){
		Word = word;
		GRect rect = new GRect(200, 50);
		rect.setFilled(true);
		rect.setFillColor(Color.white);
		add(rect, (getWidth() * WRONG_GUESS_PLACE_X) - (6) ,(getHeight() * WRONG_GUESS_PLACE_Y) -(rect.getHeight()/2) );

		body = new HangmanGraphics(getWidth()*.7,getHeight()*.7);
		body.drawNextPart();
		add(body,getWidth()/6,getHeight()/2);
		setupWord();

	}
	
	/**
	 * creates a new instance of the GSpaces class, and then adds it to the screen
	 */
	public void setupWord(){
		for(int i = 0; i<Word.length(); i++){
			letters.add((char)Word.charAt(i));
		}
		space = new GSpace(letters);
		space.setupLines();
		add(space,getWidth()/3,getHeight()/2);
	}
	
	/**
	 * takes an array list of characters and displays them in the
	 * white box that took way too long to create
	 *
	 * @param c the array list of characters to be used as incorrect guesses
	 */
	public void showIncorrect(ArrayList<Character> c){
		double ARRAY_X = getWidth() * WRONG_GUESS_PLACE_X;
		double ARRAY_Y = (getHeight() * WRONG_GUESS_PLACE_Y);
		
		ArrayList<GLabel> incorrectLetters = new ArrayList<GLabel>();
		
		//adds the array list of incorrect guesses across the screen
		for(int x =0; x<c.size(); x++){
			GLabel label = new GLabel(c.get(x) + "");
			label.setFont(FONT_1);
			label.setColor(Color.red);
			incorrectLetters.add(label);
			add(incorrectLetters.get(x), ARRAY_X + (x*20), ARRAY_Y );
		}
	}
	
	/**
	 * sends a correctly guessed letter to the space class
	 * to be set visible
	 *
	 * @param c the correct letter that was guessed
	 */
	public void correctGuess(char c){
		space.correctLetterGuessed(c);
	}
	
	/**
	 * draws the next body part
	 *
	 */
	public void incorrectGuess(){
		body.drawNextPart();
	}
	
	
	
//***************************NOTIFICATIONS*******************************//
	
	
	/**
	 * welcomes the user to the game
	 */
	public void startNotification() {
		message.setText("Welcome to HANGMAN! Type a letter to guess...");
	}
	
	/**
	 * tells the user they've won
	 */
	public void winNotification() {
		message.setText("You've guessed the word! Hit NEW GAME to play again");
	}
	
	/**
	 * tells the user they've lost
	 * sets gameRunning boolean to false
	 */
	
	public void loseNotification() {
		message.setText("You've LOST! Hit NEW GAME to play again");
		gameRunning = false;
	}
	
	/**
	 * tells the user they guessed correctly
	 */
	public void correctNotification() {
		message.setText("Correct guess! Guess other letter");
	}
	
	/**
	 * tells the user they guessed incorrectly
	 */
	public void wrongNotification() {
		message.setText("Incorrect guess! Guess other letter");
	}
	
	/**
	 * tells the user they repeated a guess
	 * @param c the letter they've already guessed
	 */
	public void repeatNotification(char c) {
		message.setText("You've already guessed " + c + " ! Guess other letter");
	}

	/**
	 * resets game if NEW GAME is PRESSED
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("New Game")){
			removeAll();
			letters.clear();
			model.newGame();
			gameRunning = true;
		}
	}
	
	/**
	 * checks to see if lost, if so, the game stops and alerts user
	 */
	public void checkLose(){
		if(model.getWrongGuesses()>=body.getMaxParts()){
			loseNotification();
			gameRunning = false;
		}
	}
	
	/**
	 * uses space.hasWon to check if all correct letters were revealed
	 * alerts the user if so
	 */
	public void checkWin(){
		if(space.hasWon()){
			gameRunning = false;
			winNotification();
		}
	}
	
	/**
	 * gives the letter to the model to check whether it is in the word
	 * also checks to see if the game has been won or lost
	 *
	 */
	public void keyPressed(KeyEvent e) {
		if(gameRunning){
			model.letterGuessed(e.getKeyChar());
			checkLose();

			checkWin();
		}
	}
	
}
