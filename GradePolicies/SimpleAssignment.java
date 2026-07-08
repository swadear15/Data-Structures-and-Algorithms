//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P03 Grade Policies 
// Course:   CS 300 Fall 2023
//
// Author:   Arsalan Ahmad
// Email:    ahmad34@wisc.edu
// Lecturer: Mark Mansi
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:  Kush Arora 
// Partner Email: ksarora@wisc.edu
// Partner Lecturer's Name: Hobbes Legault
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         N/A
// Online Sources:  N/A
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Random;

/**
 * This class models a basic assignment with points possible, points earned, and an optional 
 * bonus of 5% of possible points.
 * 
 * @author Arsalan Ahmad
 * @author Kush Arora
 *
 */

public class SimpleAssignment {
  
  // Indicates whether a 5% bonus is offered (and has not yet been applied) for this assignment
  private boolean bonusAvailable;

  // Indicates whether this assignment has been completed or not
  private boolean isComplete;
  
  // The number of points possible on this assignment; must be strictly positive
  public final int POINTS_POSSIBLE;
  
  // The score the student received on this assignment; only set when the assignment is completed
  private double pointsEarned;
  
  /**
   * 
   * Basic constructor, creates an assignment that has not been completed and does not have a bonus
   * available.
   * 
   * If the provided points value is less than 1, set it to 1.
   * 
   * @param points - the maximum possible points on the assignment
   * 
   */
  public SimpleAssignment(int points) {
    // Initializes if it is under 1
    if (points < 1) {
      POINTS_POSSIBLE = 1;
    }
    else {
      // Otherwise sets the points possible to points
      POINTS_POSSIBLE = points;
    }
    // Sets points earned to 0
    pointsEarned = 0;
  }

  /**
   * 
   * Overloaded constructor, creates an assignment that has not been completed and could have a
   * bonus available.
   * 
   * If the provided points value is less than 1, set it to 1.
   * 
   * @param points - the maximum possible points on the assignment
   * 
   * @param bonus  - true if a 5% bonus is available, false otherwise
   * 
   */
  public SimpleAssignment(int points, boolean bonus) {
    // Initializes if it is under 1
    if (points < 1) {
      POINTS_POSSIBLE = 1;
    }
    else {
      // Otherwise sets the points possible to points
      POINTS_POSSIBLE = points;
    }
    // Sets the bonus
    bonusAvailable = bonus;
    // Sets pointsEarned to 0
    pointsEarned = 0;
  }

  /**
   * 
   * Returns the number of points earned on the assignment. If the assignment has not yet been
   * completed, returns 0.
   * 
   * @return the number of points earned on the assignment
   * 
   */
  public double getPoints() {
    // Checks if it is complete, then returns points
    if (isComplete) {
      return pointsEarned;
    }
    // Otherwise it returns 0
    return 0;
  }

  /**
   * 
   * Reports whether this assignment has been completed yet
   * 
   * @return true if this assignment has been completed, false otherwise
   * 
   */
  public boolean isComplete() {
    // Returns if it is complete
    return isComplete;
  }

  /**
   * 
   * Completes the assignment and records the provided score.
   * 
   * If this assignment has already been completed, this method does nothing.
   * 
   * @param score - the score to record for this assignment. If less than 0, recorded score is 0.
   * 
   *              If greater than the number of points possible, recorded score is the number of
   *              points possible.
   * 
   */
  public void complete(double score) {
    // Checks if it isn't complete
    if (!isComplete) {
      // Makes it true
      isComplete = true;
      // Checks if score is less then 0
      if (score < 0) {
        // Sets points earned to 0
        pointsEarned = 0;
      }
      // Otherwise if it is above the max it sets it to the max
      else if (score > POINTS_POSSIBLE) {
        pointsEarned = POINTS_POSSIBLE;
      }
      else {
        // Sets it to the score
        pointsEarned = score;
      }
    }
  }

  /**
   * 
   * If the assignment has been completed and there is a bonus available,
   * 
   * adds 5% of possible points to the earned points total, up to a maximum of the number of
   * possible points.
   * 
   * Once the bonus has been recorded, it is no longer available.
   * 
   * Note: the points earned on any given assignment CANNOT exceed the points possible
   * 
   */

  public void awardBonus() {
    // Checks if bonus is available, then does the appropriate calculates and set bonus to false
    if (bonusAvailable && isComplete) {
      pointsEarned += POINTS_POSSIBLE / 20;
      bonusAvailable = false;
    }
    // Sets points Earned to max if above max
    if (pointsEarned > POINTS_POSSIBLE) {
      pointsEarned = POINTS_POSSIBLE;
    }
  }

  /**
   * Creates and returns a String representation of this SimpleAssignment. This includes the 
   * score as a number of points earned out of points possible, or an asterisk out of points 
   * possible if the assignment has not yet been completed.
   * 
   * @return a String containing the score, e.g. "45.0/50" or a star indicating the assignment is
   *  not yet complete
   *  
   */
  @Override
  public String toString() {
    // Returning the appropriate toString
    return pointsEarned + "/" + POINTS_POSSIBLE;
  }


  /**
   * 
   * Creates random assignment scores with a mean of 80% and a standard
   * deviation
   * of 15%.
   * 
   * @param n the number of assignment scores to create
   * 
   * @param maxScore the maximum score value to create
   * 
   * @return an array of the SimpleAssignments created under those requirements
   * 
   */
  public static SimpleAssignment[] makeRandomAssignments(int n, int maxScore) {
    // Setting the random variable
    Random rand = new Random();
    // Creating a new array for the result
    SimpleAssignment[] result = new SimpleAssignment[n];
    double mean = 0.80;
    double std = 0.15;
    // Going through the array doing the appropriate calculations
    for (int i = 0; i < n; i++) {
      double pctScore = rand.nextGaussian(mean, std);
      result[i] = new SimpleAssignment(maxScore);
      result[i].complete(pctScore * maxScore);
    }
    // Returns result
    return result;
  }
}
