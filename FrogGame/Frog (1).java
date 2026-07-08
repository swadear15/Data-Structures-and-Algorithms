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

// An instantiable class maintains data about a Frog in the Froggie Feeding Frenzie game. 
// They an be drawn to the screen, dragged around by the mouse, and attack Bugs with its Tongue.

// @author Kush Arora
// @author Arsalan Ahmad

public class Frog extends GameActor implements Moveable{
	// how much health the frog has
	private int health;
	// path to the image to use for the frog
	private static final String IMG_PATH = "images"+File.separator+"frog.png";
	// keeps track of if the Frog is being dragged by the mouse
	private boolean isDragging;
	// the previous x-coordinate of the mouse
	private float oldMouseX;
	// the previous y-coordinate of the mouse
	private float oldMouseY;
	// the tongue belonging to this frog
	private Tongue tongue;
	
	/**
	   * Constructor for a new Frog object using the provided parameters. The Frog is NOT dragging by default.
	   * 
	   * @param floatX, the x-coordinate for the center of the circle path
	   * @param floatY, the y-coordinate for the center of the circle path
	   * @param health, the radius of this CirclingBug's circle path.
	   */
	Frog(float x, float y, int health)
	{
		super(x, y, IMG_PATH);
		
		if (health < 1)
		{
			throw new IllegalArgumentException("Health is less than 1!");
		}
		
		this.health = health;
		tongue = new Tongue(x, y);
	}
	
	/**
	   * Draws the image of the Frog to the screen. 
	   * If the Frog's tongue is active: 
	   * (1)draw the tongue and 
	   * (2) extend the tongue by moving it's x-coordinate to the Frog's x-coordinate and up 2 pixels.
	   */
	public void draw() {
		if (tongue.isActive()) {
			tongue.draw();
		    tongue.extend(getX(), -2);
		}
		super.draw();
	}
	/**
	   * Gets the current health of the Frog
	   * 
	   * @return the current health of this Frog
	   */
	public int getHealth()
	{
		return health;
	}
	
	/**
	   * Gets the Hitbox for this Frog's tongue.
	   * 
	   * @return this Frog's tongue's hitbox
	   * @throws IllegalStateException - if the tongue is currently inactive
	   */
	
	public Hitbox getTongueHitbox()
	{
		if (!tongue.isActive())
		{
			//throw new IllegalStateException("Tongue is not active");
		}
		return tongue.getHitbox();
	}
	
	/**
	   * Determines if this frog is dead.
	   * @return true if this Frog's health is 0 or lower, false otherwise
	   */
	
	public boolean isDead()
	{
		if (health <= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	   * Determines whether or not this Frog has run into a Bug.
	   * 
	   * @param b - , the Bug to check that if it collides with the Frog
	   * @return true if the Bug's Hitbox and Frog's Hitbox overlap, false otherwise.
	   */
	public boolean isHitBy(Bug b)
	{
		if (getHitbox().doesCollide(b.getHitbox())) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	   * Determines if the mouse is over the Frog's image
	   * @return true, if the mouse is inside the Frog's bounding box of the image, false otherwise
	   */
	
	public boolean isMouseOver()
	{
		float maxWidth = this.getX() + (image.width / 2);
		float minWidth = this.getX() - (image.width / 2);
		
		float maxHeight = this.getY() + (image.height / 2);
		float minHeight = this.getY() + (image.height / 2);
		
		if (processing.mouseX > minWidth && processing.mouseX < maxWidth) {
			if(processing.mouseY > minHeight && processing.mouseY < maxHeight) {
				return true;
			}
		}
		return false;
	}
	
	// Decreases the health of this Frog by 1.
	public void loseHealth()
	{
		health -= 1;
	}
	
	// Changes this Frog so it is now being dragged. 
	// This method should only be called externally when the mouse is over this frog and has been clicked.
	public void mousePressed()
	{
		if (processing.mousePressed) {
		      isDragging = true;
		}
	}
	
	// Changes this Frog so it is no longer being dragged. 
	// This method should only be called externally when the mouse has been released.
	public void mouseReleased()
	{
		if (processing.mousePressed == false) {
		      isDragging = false;
		}
	}
	
	
	/**
	   * Moves the Frog by dragging it by the mouse, if it should be dragging. (See write-up for more details on implementing the dragging functionality.) 
	   * The starting point of the tongue and the Hitbox need to move along with the Frog. 
	   * If the Frog's tongue is NOT active, move the tongue's endpoint along with the Frog as well. The Frog only moves if it should move.
	   */
	public void move()
	{
		float slopeY = Frog.processing.mouseY - oldMouseY;
	    float slopeX = Frog.processing.mouseX - oldMouseX;
	    
	    oldMouseY = Frog.processing.mouseY;
	    oldMouseX = Frog.processing.mouseX;
	    
	    if (isDragging) {
	        this.setX(this.getX() + slopeX);
	        this.setY(this.getY() + slopeY);
	        this.getHitbox().setPosition(this.getX(), this.getY());
	        
	        if (tongue.isActive()) {
	            this.tongue.updateStartPoint(this.getX(), this.getY());
	            this.tongue.getHitbox().setPosition(this.getX(), this.getY());
	        } else {
	            this.tongue.updateStartPoint(this.getX(), this.getY());
	            this.tongue.getHitbox().setPosition(this.getX(), this.getY());
	            this.tongue.updateEndPoint(this.getX(), this.getY());
	        }
	    }
	}
	
	/**
	   * Reports if the Frog needs to move on the screen.
	   * 
	   * @SpecifiedBy shouldMove in interface Moveable
	   * @throws IllegalStateException - if the tongue is currently inactive
	   * @return true if the Frog is being dragged, false otherwise
	   */
	
	public boolean shouldMove()
	{
		if (isDragging == true)
		{
			return true;
		}
		return false;
	}
	
	// Starts an attack by resetting the tongue to it's default state and activating the tongue.
	public void startAttack()
	{
		tongue.reset();
		tongue.activate();
	}
	
	// Stops the attack by deactivating the tongue.
	public void stopAttack()
	{
		tongue.deactivate();
	}
	
	/**
	   * Reports if this Frog's tongue has hit the top of the screen.
	   * @return true if the tongue has hit the top of the screen, false otherwise
	   */
	public boolean tongueHitBoundary()
	{
		if (tongue.hitScreenBoundary() == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
