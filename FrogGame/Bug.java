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
 * An instantiable class maintains data about a Bug in the Froggie Feeding Frenzie game.
 * These bugs do not move, can be drawn to the screen, and detect if it has been hit (eaten) by a Frog.
 * 
 * @author Kush Arora
 * @author Arsalan Ahmad
 */

public class Bug extends GameActor  {
	// path to the image used for bugs, all bugs use the same image
	private static final String IMG_PATH = "images"+File.separator+"bug.png";
	
	// how many points this bug gives for being eaten
	private int points;
	
	/**
	   * Creates a new Bouncing Bug object using the given parameters.
	   * 
	   * @param x, the x-coordinate for the center of this Bug and its hitbox
	   * @param y, the y-coordinate for the center of this Bug and its hitbox
	   * @param points, the number of points this bug is worth
	   */
	Bug(float x, float y, int points){
		super(x, y, IMG_PATH);
		this.points = points;
	}
	
	/**
	   * Gets how many points this Bug is worth
	   * @return the number of points this bug is worth
	   */
	public int getPoints() {
		return points;
	}
	
	/**
	   * Gets how many points this Bug is worth
	   * @param f, the frog that has possibly eaten this bug
	   * @return the number of points this bug is worth
	   */
	public boolean isEatenBy(Frog f) {
	try {
		if (this.getHitbox().doesCollide(f.getTongueHitbox())) {
			return true;
		}
		return false;
	}
	catch (Exception e) {
		return false;
	}
	}
}
