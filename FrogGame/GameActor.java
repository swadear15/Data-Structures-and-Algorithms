//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P05 Frog Feeding Frenzy
// Course: CS 300 Fall 2023
//
// Author: Kush Arora
// Email: ksarora@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Arsalan Ahmad
// Partner Email: ahmad34@wisc.edu
// Partner Lecturer's Name: Mark Mansi
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: N/A
// Online Sources: N/A
//
//////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

/**
 * An instantiable class for all game actors in the Froggie Feeding Frenzie game. Game actors are 
 * images that are drawn the screen that also have hitboxes.
 * 
 * @author Kush Arora
 * @author Arsalan Ahmad
 */

public class GameActor {
	// the x,y-coordinates of the center stored as [x,y]
		private float[] coordinates;
		// the hitbox associated with this GameActor
		private Hitbox hitbox;
		// the image associated with this GameActor
		protected processing.core.PImage image;
		// PApplet to use to draw GameActors to the screen
		protected static processing.core.PApplet processing;
		
		/**
		   * Creates a new Bouncing Bug object using the given parameters.
		   * 
		   * @param x, the x-coordinate for the center of this object and its hitbox
		   * @param y, the y-coordinate for the center of this object and its hitbox
		   * @param imgPath, the path to the image that will be loaded in
		   */
		GameActor(float x, float y, String imgPath){
			if(GameActor.processing == null)
			      throw new IllegalStateException("Processing is null. setProcessing() must be called before "
			          + "creating any GameActor objects.");
			coordinates = new float[2];
			coordinates[0] = x;
			coordinates[1] = y;
			image = processing.loadImage(imgPath);
			hitbox = new Hitbox(x,y,image.width,image.height);
		}
		
		/**
		   * Sets the processing for all GamActors
		   * 
		   * @param processing, the instance of a PApplet to draw onto
		   */
		public static void setProcessing(processing.core.PApplet processing) {
			GameActor.processing = processing;
		}
		
		/**
	     * Getter for the x-coordinate.
	     * 
	     * @return the x-coordinate of center of this GameActor
	     */
		public float getX() {
			return coordinates[0];
		}
		
		/**
	     * Getter for the y-coordinate.
	     * 
	     * @return the y-coordinate of center of this GameActor
	     */
		public float getY() {
			return coordinates[1];
		}
		
		/**
	     * Setter for the x-coordinate.
	     * 
	     * @param newX, the new x-coordinate for the center of this GameActor
	     */
		public void setX(float newX) {
			coordinates[0] = newX;
		}
		
		/**
	     * Setter for the y-coordinate.
	     * 
	     * @param newY, the new x-coordinate for the center of this GameActor
	     */
		public void setY(float newY) {
			coordinates[1] = newY;
		}
		
		/**
	     * Getter for the Hitbox.
	     * 
	     * @param the Hitbox of this GameActor
	     */
		public Hitbox getHitbox() {
			return hitbox;
		}
		
		/**
	     * Moves this GameActors Hitbox to the provided x,y-coordinates
	     * 
	     * @param x, the new x-coordinate for the center of the GameActor's hitbox
	     * @param y, the new y-coordinate for the center of the GameActor's hitbox
	     */
		public void moveHitbox(float x, float y) {
			hitbox.setPosition(x, y);
		}
		
		/**
	     * Draws the image of the GameActor to the screen. (OPTIONAL)Visualize the Hitbox to 
	     * help with debugging.
	     */
		public void draw() {
			processing.image(image, coordinates[0], coordinates[1]);
		}
	
}
