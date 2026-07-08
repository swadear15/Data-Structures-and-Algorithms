//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P03 Grade Policies 
// Course:   CS 300 Fall 2023
//
// Author:   Kush Arora
// Email:    ksarora@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Arsalan Ahmad
// Partner Email:   ahmad34@wisc.edu
// Partner Lecturer's Name: Mark Mansi
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

/**
 * A wrapper class for an AssignmentGroup object, this class models a collection of scores which 
 * are worth a given percentage of a student's grade. When calculating the point values for this 
 * type of assignment group, points are scaled to a given percentage of possible points, and 
 * everything over that cap is considered full credit.
 * 
 * @author Kush Arora
 * @author Arsalan Ahmad
 *
 */

public class ScalingAssignmentGroup {
  
  // The AssignmentGroup object that stores the assignments for this ScalingAssignmentGroup
  private AssignmentGroup group;
  
  // The percent of the total grade this ScalingAssignmentGroup comprises
  public final double PERCENT_OF_TOTAL;
  
  // The factor by which to scale the total number of possible points in this 
  // ScalingAssignmentGroup, assumed to be between 0 and 1.
  private double scalingFactor;
  
  /**
   * Basic constructor, initializes an assignment group which is worth the given percentage of a 
   * student's grade which will be scaled by the given scaling factor. This method also 
   * creates the AssignmentGroup that this object will use to store its assignments.
   * 
   * @param percent of the total grade that this assignment group represents, assumed 
   * to be between 0 and 1.
   * 
   * @param scale is the factor by which the points of this assignment group should be 
   * scaled, assumed to be between 0 and 1.
   */
  public ScalingAssignmentGroup(double percent, double scale) {
    // Initializes group 
    group = new AssignmentGroup(percent);
    
    // Intializes percent to PERCENT_OF_TOTAL
    PERCENT_OF_TOTAL = percent;
    
    // Sets the custom scale
    scalingFactor = scale;
  }
  
  /**
   * Adds a single assignment object to this ScalingAssignmentGroup
   * 
   * @param assignment is the SimpleAssignment to add
   * 
   */
  public void addAssignment(SimpleAssignment assignment) {
    // Adds the assignment to group
    group.addAssignment(assignment);
  }

  /**
   * Adds a batch of assignments to this ScalingAssignmentGroup in the order they appear
   * 
   * @param assignmentBatch is a perfect-size array of SimpleAssignments to add
   * 
   */
  public void addAssignments(SimpleAssignment[] assignmentBatch) {
    // Adds the assignmentBatch to group
    group.addAssignments(assignmentBatch);
  }
  
  /**
   * Retrieves an assignment at the given index in the ScalingAssignmentGroup
   *  
   * @param i is the index of the assignment to access (0-based)
   * 
   * @return the assignment at the given index, or null if the index is out of bounds
   */
  public SimpleAssignment getAssignment(int i) {
    // Returns the assignment at the given index
    return group.getAssignment(i);
  }
  
  /**
   * Accesses the number of assignments currently stored in this ScalingAssignmentGroup
   * 
   * @return the number of assignments present in this ScalingAssignmentGroup
   */
  public int getNumAssignments() {
    // Returns the amount of assignments in the group
    return group.getNumAssignments();
  }

  /**
   * Retrieves the total earned points of the assignments in this group, and returns either 
   * the actual number of earned points or, if the total is higher than the scaled points possible, 
   * returns the maximum number of points possible.
   * 
   * @return the number of earned points across all assignments in this group, which cannot 
   * exceed the number of possible points when accounting for the scalingFactor
   */
  public double getPoints() {
    // Sets a points value to a double
    double points = group.getPoints();
    // Checks if points is higher than the scaled total
    if (points > getTotalPossible())
    {
      // Returns scaled total otherwise
      return getTotalPossible();
    }
    // Returns the points from the scale
    return points;
  }
  
  /**
   * Retrieves the total number of possible points of the assignments in this group, multiplied 
   * by this ScalingAssignmentGroup's scalingFactor value.
   * 
   * @return the total number of points possible, scaled by the scalingFactor
   */
  public double getTotalPossible() {
    // Returns the scaled value of total points possible
    return (double)(group.getTotalPossible()) * scalingFactor;
  }

  /**
   * Reports whether all assignments in this group are completed
   * 
   * @return true if all assignments in this group are completed, false otherwise
   */
  public boolean isComplete() {
    // Returns the isComplete method of group
    return group.isComplete();
  }
  
  /**
   * Creates a String representation of this ScalingAssignmentGroup. This is given as a percent of 
   * possible points, calculated as getPoints()/getTotalPossible(). 
   * For any total earned point value over the ceiling percent of total possible points, 
   * this will be 1.
   * 
   * @return a String containing the percent of points earned for this ScalingAssignmentGroup, 
   * scaled by the given scalingFactor
   */
  @Override
  public String toString() {
    // Gets the calculated return
    double calculatedStringReturn =
        ((group.getPoints() * scalingFactor) / (group.getTotalPossible() * scalingFactor));
    // Default "1" value return in percent
    if (calculatedStringReturn >= 1) {
      return 1 * 100 + "%";
    } else {
      // Final percent return
      return (calculatedStringReturn * 100) + "%";
    }
  }
}
