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
 * A subclass of Bug that is Movable. These bugs only move when they are not at max health. 
 * When hit they become smaller and start moving horizontally across the screen.
 * 
 * @author Kush Arora
 * @author Arsalan Ahmad
 */

public class StrongBug extends Bug implements Moveable {
	// the max health of this StrongBug
	private final int MAX_HEALTH;
	// the number of points ALL StrongBugs are worth, 500
	private static final int POINTS = 500;
	// the current health of this StringBug, updates when Bug takes damage
	private int currentHealth;
	
	/**
	   * Creates a new Bouncing Bug object using the given parameters.
	   * 
	   * @param x, the x-coordinate for the center of this StrongBug
	   * @param y, the y-coordinate for the center of this StrongBug
	   * @param health, the max health for this StrongBug
	   */
	public StrongBug(float x, float y, int health) {
		super(x, y, POINTS);
		if (health < 1) {
			throw new IllegalArgumentException("The max health of a strongBug must be at least 1");
		}
		else {
			MAX_HEALTH = health;
		}
		currentHealth = health;
	}
	
	/**
     * Reports if this StrongBug is dead.
     * 
     * @return true if its currentHealth is 0 or less, false otherwise
     */
	public boolean isDead() {
		if (currentHealth <= 0) {
			return true;
		}
		return false;
	}
	
	/**
     * Decreases the health of this StrongBug by 1.
     * 
     */
	public void loseHealth() {
		currentHealth -= 1;
	}
	
	/**
     * Reports if the StrongBug needs to move.
     * 
     * @return true if the bug is NOT at full health, false otherwise
     */
	public boolean shouldMove() {
		if (currentHealth == MAX_HEALTH) {
			return false;
		}
		return true;
	}
	
	/**
     * Moves this StrongBug 3 units to the right, wrapping around the screen when the center hits 
     * the edge of the window. The Hitbox should move with the StrongBug. The x,y-coordinate of 
     * only changes if the StrongBug should move.
     */
	public void move() {
		if (shouldMove()) {
			float move = this.getX() + 3;
			if (move >= processing.width) {
				move=0; 
			}
			this.getHitbox().setPosition(move, getY());
			setX(move);
		}
		
	}
	
	/**
     * Determines whether or not this bug has been eaten by the Frog.
     * If the Bug has been hit by the frog:
     * 1. decrease the StrongBug's health
     * 2. resize the image to 75% of its current height and 75% of it's current width
     * 3. change the dimensions of the hitbox to match the new image dimensions.
     * 
     * @param f, the frog that has possibly eaten this bug
     * 
     * @return true if this Bug's Hitbox overlaps that Frog's Tongue's Hitbox, false otherwise
     */
	public boolean isEatenBy(Frog f) {
		if (this.getHitbox().doesCollide(f.getTongueHitbox())) {
			loseHealth();
			int resizeX = (int) (0.75 * image.width);
			int resizeY = (int) (0.75 * image.height);
			if (resizeX > 0 && resizeY > 0) {
				if (!isDead()) {
					image.resize(resizeX, resizeY);
					this.getHitbox().changeDimensions((float) (0.75 * image.width), (float) (0.75 * image.height));
					return false;
				}
				else {
					return true;
				}
		}
		}
		
		return false;
	}
}
