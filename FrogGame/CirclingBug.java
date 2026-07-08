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

// A subclass of Bug that is Movable and moves in a circle. When drawn to the screen they also have a tint applied to the image
// @author Kush Arora
// @author Arsalan Ahmad
public class CirclingBug extends Bug implements Moveable {
	// keeps track of how long the bug has been moving
		private double ticks;
		// the radius of the circle path this bug moves on
		private double radius;
		// the x,y-coordinates for the center of the circle path
		private float[] circleCenter;
		// color used to tint the image when being drawn [Red,Green,Blue]
		private int[] tintColor;
		// constant, number of points ALL CirclingBugs are worth 200
		private static final int POINTS = 200;
		
		/**
		   * Creates a new Bouncing Bug object using the given parameters.
		   * 
		   * @param circleX, the x-coordinate for the center of the circle path
		   * @param circleY, the y-coordinate for the center of the circle path
		   * @param radius, the radius of this CirclingBug's circle path
		   * @param tintColor, an array containing the Red,Green, and Blue values for the tint color 
		   * You can assume that this array is ALWAYS length 3.
		   */	
		public CirclingBug(float circleX, float circleY, double radius, int[] tintColor) {
			super((float) radius + (float) circleX, (float) radius + (float) circleY, POINTS);
			circleCenter = new float[] {circleX, circleY};
			this.tintColor = tintColor;
			this.radius = radius;
			ticks = 0.0;
		}
		
		/**
		   * Reports if the CirclingBug needs to move.
		   * 
		   * @return true, this Bug ALWAYS moves
		   */
		public boolean shouldMove() {
			return true;
		}
		
		
		/**
	     * Moves this CirclingBug to the next position on its circular path. 
	     * (See write-up for more details on how to calculate this path.) The Hitbox should move with 
	     * the CirclingBug. The bug only changes its xy-coordinates if it should move. Ticks will 
	     * advance by 0.05 whenever this method is called.
	     */
		public void move() {
			ticks +=0.05;
			double cosx = Math.cos(ticks);
			double siny = Math.sin(ticks);
			
		    this.setX((float) (radius * cosx) + (float) circleCenter[0]);
		    this.getHitbox().setPosition((float) (radius * cosx) + (float) circleCenter[0], this.getY());
		    
	        this.setY( (float) (radius * siny) + (float) circleCenter[1]);
	        this.getHitbox().setPosition(this.getX(), (float) (radius * siny) + (float) circleCenter[1]);
		}
		
		/**
	     * Draws the image to the screen, tinting it with the tintColor before drawing it. 
	     * After the image is drawn to the screen the tinting effect will need to done undone by 
	     * tinting it again with white. (255, 255, 255)
	     */
		public void draw() {
			processing.tint(tintColor[0], tintColor[1], tintColor[2]);
			processing.image(image, circleCenter[0], circleCenter[1]);
			processing.tint(255,255,255);
		}
}
