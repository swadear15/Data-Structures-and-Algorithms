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
 * A class used to run the FrogFrenzy game that utilizes several different game characters for its sucesss.
 * 
 * @author Kush Arora
 * @author Arsalan Ahmad
 */
public class FrogGame extends PApplet {
  private ArrayList<GameActor> gameActors; //array list of the gameActors in the game
  private int score; //the player's current score
  private PImage backgroundImg; //the image to use for the background
  private boolean isGameOver; //keeps track if the game is over, is true if the game is over
  private Random randGen; //random number generator
  private static final int BUG_COUNT = 5; //how many bugs should be on the screen at all times
  
  
  // Main method that starts running the game
  public static void main(String[] args) {
	  PApplet.main("FrogGame");
  }
  
  // Settings method used to set the size of the window
  @Override
  public void settings(){
	//TODO #1 call PApplet's size() method giving it 800 as the width and 600 as the height
	super.size(800, 600);
  }
  
  // Setup method to initialize the game for its beginning state
  
  @Override
  public void setup() {
    //TODO #2 add PApplet method calls from write-up
	  this.getSurface().setTitle("Froggie Feeding Frenzie");
	  this.imageMode(PApplet.CENTER);
	  this.rectMode(PApplet.CENTER);
	  this.focused = true;
	  this.textAlign(PApplet.CENTER);
	  this.textSize(30);
    //TODO #3 initialize randGen
	  randGen = new Random();
    //TODO #4 load in and save the backgroundImg
	  backgroundImg = loadImage("images"+File.separator+"background.jpg");
    //TODO #5 initialize gameActors to an empty ArrayList
	  gameActors = new ArrayList<GameActor>();
    //TODO #7 set the processing variable for all classes where necessary (update this as needed)
	  Hitbox.setProcessing(this);
	  GameActor.setProcessing(this);
	  Tongue.setProcessing(this);
    //TODO #16 call initGame()
	 initGame();

  }

  // Draw method that draws the background, the characters, and the text in the game
  // Also rund the logic check to make sure the game operrates
  @Override
  public void draw() {
	//TODO #6 call PApplet's image() method to draw the backgroundImg at the center of the screen
	  if (isGameOver) {
		  text("GAME OVER", width/2, height/2);
	  }
	  else {
		  image(backgroundImg,400,300);
		  for (int i = 0; i < gameActors.size(); i++) {
			  if (gameActors.get(i) instanceof BouncingBug) {
				  ((BouncingBug) gameActors.get(i)).move();
			  }
			  if (gameActors.get(i) instanceof CirclingBug) {
				  ((CirclingBug) gameActors.get(i)).move();
			  }
			  if (gameActors.get(i) instanceof StrongBug) {
				  ((StrongBug) gameActors.get(i)).move();
			  }
			  if (gameActors.get(i) instanceof Frog) {
				  ((Frog) gameActors.get(i)).move();
			  }
			  gameActors.get(i).draw();
			  
		  }
		//TODO #19 run all the game logic checks
		runGameLogicChecks();
		//TODO #14 print "Health: " + frog's health at (80,40) and "Score: " + score at (240,40)
	    //     to the screen
	    //     (note in the code logic this step to be performed takes place AFTER TODO #19)
		for (int i = 0; i < gameActors.size(); i++) {
			if (gameActors.get(i) instanceof Frog) {
				text("Health: " + ((Frog) gameActors.get(i)).getHealth(), 80, 40);
				text("Score: " + (this.score),240, 40);
			}
		}
		  
	  }
	  

	//TODO #8 draw every GameActor in the ArrayList to the screen
	  
	  
	//TODO #9 update the code you wrote for TODO #8 to have all Movable GameActors move
	  
	//TODO #19 run all the game logic checks

	//TODO #14 print "Health: " + frog's health at (80,40) and "Score: " + score at (240,40)
    //     to the screen
    //     (note in the code logic this step to be performed takes place AFTER TODO #19) 

	//TODO #20 update the code you wrote above to do the following:
	  //(1) if the game is over, do NONE of the above steps. Instead print "GAME OVER" to
    //    the center of the screen.
	  //(2) otherwise do the above steps
	
	
	
	
  }
  
  // Add new bug method generates a random new bug of any of four types and adds it to the ArrayList
  
  private void addNewBug() {
	//TODO #10 implement this method, see below for more details. 
    //This creates a bug of a random type and adds it to the list of GameActors.
      //(1) generate a random number in the range [0,4)
      //(2) generate a random x value in the range [0, windowWidth) for the bug
      //(3) generate a random y value in the range [0, windowHeight - 150) for the bug
      //(4) depending on the value generated in step (1) 
      //    create the following bug and add it to the arraylist
		 // 0 -> a new regular Bug at (x,y) that is worth 25 points
         // 1 -> a new BouncingBug at (x,y) that has a dx of 2 and a dy of 5
         // 2 -> a new CirclingBug at (x,y) with a radius of 25 and a random set of RGB values [0,256)
         // 3 -> a new StrongBug at (x,y) with an initial health of 3		
	int random = randGen.nextInt(4);
	float randX = (float) randGen.nextInt(width);
	float randY = (float) randGen.nextInt(height);
	
	if (random == 0) {
		Bug newBug = new Bug(randX, randY, 25);
		gameActors.add(newBug);
	}
	if (random == 1) {
		BouncingBug newBB = new BouncingBug(randX, randY, 2, 5);
		gameActors.add(newBB);
	}
	if (random == 2) {
		int r = randGen.nextInt(256);
		int g = randGen.nextInt(256);
		int b = randGen.nextInt(256);
		int[] tintColors = new int[] {r,g,b};
		CirclingBug newCB = new CirclingBug(randX, randY, 25, tintColors);
		gameActors.add(newCB);
	}
	if (random == 3) {
		StrongBug newSB = new StrongBug(randX, randY, 3);
		gameActors.add(newSB);
	}
  }

  
  // Checks if mouse was pressed
  @Override
  public void mousePressed() {
    //TODO #11 if mouse is over the Frog call its mousePressed method
	  for (int i = 0; i < gameActors.size(); i++) {
		  if (gameActors.get(i) instanceof Frog) {
			  ((Frog) gameActors.get(i)).mousePressed();;
			  break;
		  }
	  }
  }
  
  //Checks if mouse released
  @Override
  public void mouseReleased() {
	  //TODO #12 call the Frog's mouseReleased method
	  for (int i = 0; i < gameActors.size(); i++) {
		  if (gameActors.get(i) instanceof Frog) {
			  ((Frog) gameActors.get(i)).mouseReleased();;
			  break;
		  }
	  }
  }
  
  //Checks if certain keys are pressed, and reacts based of which key was pressed
  @Override
  public void keyPressed() {
    //TODO #13 if the key is a space, have the frog starts attacking 
	  if (key == ' ') {
		  for (int i = 0; i < gameActors.size(); i++) {
			  if (gameActors.get(i) instanceof Frog) {
				  ((Frog) gameActors.get(i)).startAttack();
				  break;
			  }
		  }
		  
	  }
	  //TODO #17 if the key is a lowercase 'r', reset the game to its initial state
	  if (key == 'r') {
		  initGame();
	  }
  }

  // Method to initialize game
  public void initGame() {
	//TODO #15 implement this method, see below for more details. This methods sets the game to 
	//its initial state before playing.
	   //(1) set the score to 0
	  score = 0;
	   //(2) make the game NOT over
	  isGameOver = false;
	   //(3) clear out the arraylist
	  gameActors.clear();
	   //(4) create and add Frog with 100 health to the list. Its x value should be half the 
	   //     width of the screen. Its y value should be the height of the screen minus 100
	  Frog ogFrog = new Frog(400, 200, 100);
	  gameActors.add(ogFrog);
	   //(5) add new bugs (of random varieties) to the list UP TO the BUG_COUNT
	  for (int i = 0; i < BUG_COUNT; i++) {
		  addNewBug();
	  }
  }
  
  //Checks the logic of the game to make sure it functions correctly
  private void runGameLogicChecks() {
	//TODO #18 implement this method, see below for details. This method runs all nessisary 
	//game logic checks. Feel free to decompose it into smaller helper methods.
	    //(1) if the Frog's tongue hits the edge of the screen, then it stops attacking
		  //(2) Check every bug to see if it has been hit by the Frog.
		    //(a) if a non-StrongBug is hit do the following
			    //(a1) stop the frog's attack
		      //(a2) remove it from the game
			    //(a3) update the score
			    //(a4) add a new bug (of a random variety) to the game
		    //(b) of a StrongBug is hit do the following
		      //(b1) stop the frog's attack
			    //(b2) the StrongBug takes damage and loses health
			    //(b3) if the StrongBug is dead do steps a1 - a4
		  //(3) check if the frog hits any of the bugs 
		    //(a) if it hit any of the bugs it takes damage and loses health 
		    //    NOTE: it can be hit my multiple bugs at the same time loses health for each. 
		    //      Ex. is hit by 2 different bugs simultanously then should take 2 damage.
		    //(b) if the frog is dead then update the game so it is over
	  //System.out.println(gameActors.size());
	  int frog = frogIndex(gameActors);
	  if (((Frog) gameActors.get(frog)).tongueHitBoundary()) {
		  ((Frog) gameActors.get(frog)).stopAttack();
	  }
	  for (int i = 0; i < gameActors.size(); i++) {
		  if (gameActors.get(i) instanceof StrongBug) {
			  if ( ((StrongBug) gameActors.get(i)).isEatenBy((Frog) gameActors.get(frog))) {
				  ((Frog) gameActors.get(frog)).stopAttack();
				  ((StrongBug) gameActors.get(i)).loseHealth();
				  if (((StrongBug) gameActors.get(i)).isDead()) {
					  score += ((StrongBug) gameActors.get(i)).getPoints();;
					  gameActors.remove(i);
					  addNewBug();
					  
				  }
			  }
			  	
		  }
		  else {
			  if (gameActors.get(i) instanceof Bug) {
				  if (((Bug) gameActors.get(i)).isEatenBy((Frog) gameActors.get(frog))){
					  ((Frog) gameActors.get(frog)).stopAttack();
					  score += ((Bug) gameActors.get(i)).getPoints();
					  gameActors.remove(i);
					  addNewBug();
				  }
			  }
		  }
		  if (gameActors.get(i) instanceof Bug) {
			  if (((Frog) gameActors.get(frog)).isHitBy((Bug) gameActors.get(i))) {
				  ((Frog) gameActors.get(frog)).loseHealth();
				  if (((Frog) gameActors.get(frog)).isDead()) {
					  gameActors.remove(frog);
					  isGameOver = true;
				  }
			  }
		  }
	  }
		  
	  
	  
	  
	  
	  
  }
  // helper methods
  // This method finds the index of the frog in the gameActors arraylist
  private int frogIndex(ArrayList<GameActor> gameActors) {
	  for (int i = 0; i < gameActors.size(); i++) {
		  if (gameActors.get(i) instanceof Frog) {
			  return i;
		  }
	  }
	  return 0;
  }
}