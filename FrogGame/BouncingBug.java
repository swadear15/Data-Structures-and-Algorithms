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

// A subclass of Bug that is Movable. These bugs bounce around the screen like a DVD player logo.
// @author Kush Arora
// @author Arsalan Ahmad
public class BouncingBug extends Bug implements Moveable{
	    // the number of pixels to move horizontally and vertically, formatted [dx,dy]
		private int[] speedNums;
		// a random generator to determine the initial directions
		private Random randGen;
		// keeps track if bug is moving left or right
		private boolean goLeft;
		// keeps track if bug is moving up or down
		private boolean goDown;
		// a constant, number of points ALL BouncingBugs are worth, 100
		private static final int POINTS = 100;
		
		
		/**
		   * Creates a new Bouncing Bug object using the given parameters.
		   * 
		   * @param x, the x-coordinate for the center of this BouncingBug
		   * @param y, the y-coordinate for the center of this BouncingBug
		   * @param dx, the number of pixels to move horizontally
		   * @param dy, the number of pixels to move vertically
		   */
		public BouncingBug(float x, float y, int dx, int dy) {
			super(x, y, POINTS);
			speedNums = new int[] {dx, dy};
			randGen = new Random();
			int directions = randGen.nextInt(1) + 1;
			if (directions == 1) {
				goLeft = true;
				goDown = false;
			}
			else {
				goLeft = false;
				goDown = true;
			}
		}
		
		/**
		   * Reports if the BouncingBug needs to move.
		   * 
		   * @return true, this Bug ALWAYS moves
		   */
		public boolean shouldMove() {
			return true;
		}
		
		/**
	     * Moves this BouncingBug dx pixels left or right 
	     * (depending on the current horizontal direction) and dy pixels up or down 
	     * (depending on the current vertical direction). The Bug's Hitbox should also move with the 
	     * BouncingBug. The bug only changes its xy-coordinates if it should move. If the center of the 
	     * Bouncing Bug hits an end of the window it will switch directions. Ex. The Bug is going down 
	     * and left and hits the left side of the screen then the Bug will be going down and right.
	     */
		public void move() {
			if (this.getX() >= processing.width) {
				goLeft = true;
			}
			else if (this.getX() <= 0){
				goLeft = false;
			}
			
			if (this.getY() >= processing.height) {
				goDown = false;
			}
			else if (this.getY() <= 0){
				goDown = true;
			}
			
			if (goLeft) {
				this.getHitbox().setPosition((this.getX() - speedNums[0]), this.getY());
				this.setX(this.getX() - speedNums[0]);
			}
			else {
				this.getHitbox().setPosition((this.getX() + speedNums[0]), this.getY());
				this.setX(this.getX() + speedNums[0]);
			}
			
			if (goDown) {
				this.getHitbox().setPosition((this.getX()), this.getY() + speedNums[1]);
				this.setY(this.getY() + speedNums[1]);
			}
			else {
				this.getHitbox().setPosition(this.getX(), this.getY() - speedNums[1]);
				this.setY(this.getY() - speedNums[1]);
				
			}
			
		}
}
