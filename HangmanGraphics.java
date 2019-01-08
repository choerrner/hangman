
/** HangmanGraphics.java: This file contains the graphics for building a hangman.
*/

import java.awt.Color;

import acm.graphics.*;

@SuppressWarnings("serial")
public class HangmanGraphics extends GCompound {

	/** Make the graphics for a hangman.
	 * @param wid the width of the allocated area for the hangman graphics
	 * @param ht the height of the allocated area for the hangman graphics
	 */

	public HangmanGraphics(double wid, double ht) {
		super();
		width = wid;
		height = ht;
		if (width / height < WIDTH_TO_HEIGHT_RATIO)
			height = width / WIDTH_TO_HEIGHT_RATIO;
		else if (width / height > WIDTH_TO_HEIGHT_RATIO)
			width = height * WIDTH_TO_HEIGHT_RATIO;
	}
	
	public void drawNextPart() {
		drawPart(part++);
	}
	
	/**
	 * Draw a particular part of a hangman object.
	 * @param part the part number
	 */
	private void drawPart(int part) {
		switch (part) {
			case 0: addGallows(); break;
			case 1: addFace(); break;
			case 2: addBody(); break;
			case 3: addLeftArm(); break;
			case 4: addRightArm(); break;
			case 5: addLeftLeg(); break;
			case 6: addRightLeg(); break;
		}
	}
	
	/**
	 * Resets the hangman object by removing all of the parts.
	 */

	public void reset() {
		removeAll();
		part = 0;
		drawNextPart();
	}
	
	/**
	 * Returns the maximum number of hangman parts that can be drawn.
	 */
	public int getMaxParts() {
		return MAX_PARTS;
	}
	
	// The following methods add the hangman parts to the GCompound.
	private void addGallows(){
		GPolygon gallows = createGallows();
		add(gallows, -width/2, -height/2);
	}
	
	private void addFace(){
		GOval face = new GOval(50,50);
		face.setFilled(true);
		face.setFillColor(HANGMAN_COLOR);
		
		add(face, 0, -100);
	}
	
	private void addBody(){
		GRect body = new GRect(15, 100);
		body.setFilled(true);
		body.setFillColor(HANGMAN_COLOR);
		
		add(body, 20, -50);
	}
	
	private void addLeftArm(){
		GRect LArm = new GRect(70, 15);
		LArm.setFilled(true);
		LArm.setFillColor(HANGMAN_COLOR);
		
		add(LArm, 20, -50);
	}
	
	private void addRightArm(){
		GRect RArm = new GRect(70, 15);
		RArm.setFilled(true);
		RArm.setFillColor(HANGMAN_COLOR);
		
		add(RArm, -35, -50);

	}
	
	private void addLeftLeg(){
		GPolygon LLeg = new GPolygon();
		LLeg.addVertex(0,0);
		//LLeg.addEdge(0, 5);
		LLeg.addEdge(15, 50);
		LLeg.addEdge(15, 0);
		LLeg.addEdge(-15, -50);
		
		LLeg.setFilled(true);
		LLeg.setFillColor(HANGMAN_COLOR);
		
		add(LLeg, 30, 50);
	}
	
	private void addRightLeg(){
		GPolygon RLeg = new GPolygon();
		RLeg.addVertex(0, 0);
		RLeg.addEdge(-15, 50);
		RLeg.addEdge(-15, 0);
		RLeg.addEdge(15, -50);
		
		RLeg.setFilled(true);
		RLeg.setFillColor(HANGMAN_COLOR);
		
		add(RLeg, 25, 50);
		
	}

	/** Defines the GPolygon with respect to the upper left corner. */
	public GPolygon createGallows() {
		GPolygon gallows = new GPolygon();
		gallows.addVertex( 0.00, 1.00 ); // lower left bottom of base
		gallows.addVertex( 0.00, 0.90 ); // lower left top of base
		gallows.addVertex( 0.10, 0.90 ); // lower left of upright
		gallows.addVertex( 0.10, 0.00 ); // upper left of upright
		gallows.addVertex( 0.70, 0.00 ); // upper right of upright
		gallows.addVertex( 0.70, 0.10 ); // lower right bottom of top
		gallows.addVertex( 0.66, 0.10 ); // upper right of rope
		gallows.addVertex( 0.66, 0.25 ); // lower right of rope
		gallows.addVertex( 0.64, 0.25 ); // lower left of rope
		gallows.addVertex( 0.64, 0.10 ); // upper left of rope
		gallows.addVertex( 0.20, 0.10 ); // lower left bottom of top
		gallows.addVertex( 0.20, 0.90 ); // lower right bottom of upright
		gallows.addVertex( 1.00, 0.90 ); // upper right of base
		gallows.addVertex( 1.00, 1.00 ); // lower right of base
		gallows.scale(GALLOWS_WIDTH*width, GALLOWS_HEIGHT*height);
		gallows.setFilled(true);
		gallows.setFillColor(GALLOWS_COLOR);
		return gallows;
	}
	
	private static final int MAX_PARTS = 6;
	private static final Color GALLOWS_COLOR = Color.BLACK;
	private static final Color HANGMAN_COLOR = Color.YELLOW;
	
	/* Constants specifying feature percentages as fractions of other features */
	private static final double WIDTH_TO_HEIGHT_RATIO = 2./3.;
	private static final double GALLOWS_WIDTH = 1.00; // as a % of object width
	private static final double GALLOWS_HEIGHT = 1.00; // as a % of object height
	
	/* Private instance variables */

	private double width, height;
	private int part;
}
