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
import java.util.Random;

/**
 * This class models a collection of scores which are worth a given percentage of a student's grade. 
 * No adjustments are made to these scores.
 * 
 * @author Kush Arora
 * @author Arsalan Ahmad
 *
 */

public class AssignmentGroup {
  
  // An ArrayList containing the assignments associated with this AssignmentGroup
  private ArrayList<SimpleAssignment> assignments;
  
  // The percent of the total grade this AssignmentGroup comprises
  public final double PERCENT_OF_TOTAL;

  
  /**
   * Basic constructor, initializes an assignment group which is worth the given percentage 
   * of a student's grade.
   * 
   * @param percent of the total grade that this assignment group represents, assumed 
   * to be between 0 and 1.
   */
  public AssignmentGroup(double percent) {
    // Initializing the ArrayList
    assignments = new ArrayList<SimpleAssignment>();
    
    // Initializing the percent variable
    PERCENT_OF_TOTAL = percent;
  }
  
  /**
   * Adds a single assignment object to this AssignmentGroup
   * 
   * @param assignment is the the SimpleAssignment to add
   */
  public void addAssignment(SimpleAssignment assignment) {
    // Adding the assignment to the ArrayList
    assignments.add(assignment);
  }

  /**
   * Adds a batch of assignments to this AssignmentGroup in the order they appear
   * 
   * @param assignmentBatch is theperfect-size array of SimpleAssignments to add
   */
  public void addAssignments(SimpleAssignment[] assignmentBatch) {
    // Going through each index of the assignmentBatch array
    for (int i = 0; i < assignmentBatch.length; i++) {
      // Adding the assignment to the ArrayList
      assignments.add(assignmentBatch[i]);
    }
  }
  
  /**
   * Retrieves an assignment at the given index in the AssignmentGroup
   * 
   * @param i is the index of the assignment to access (0-based)
   * 
   * @return the assignment at the given index, or null if the index is out of bounds
   */
  public SimpleAssignment getAssignment(int i) {
    // Checking if the ArrayList is not empty
    if (assignments.size() != 0) {
      // Returning the object at the index
      return assignments.get(i);
    }
    // Default return if ArrayList is null
    return null;
  }

  /**
   * Accesses the number of assignments currently stored in this AssignmentGroup
   * 
   * @return the number of assignments present in this AssignmentGroup
   */
  public int getNumAssignments() {
    // Returns the size of the ArrayList
    return assignments.size();
  }

  /**
   * Accesses the total number of earned points across all assignments in this AssignmentGroup
   * 
   * @return the sum of all earned points of all assignments in this AssignmentGroup
   */
  public double getPoints() {
    // Initializes a default 0 points
    double totalPoints = 0.0;
    // Goes through the ArrayList
    for (int i = 0; i < assignments.size(); i++) {
      // Adds the point of the assignment to the totalPoints double
      totalPoints += assignments.get(i).getPoints();
    }
    // Returns the final overall point count
    return totalPoints;
  }
  
  /**
   * Accesses the total number of points possible across all assignments in this AssignmentGroup
   * 
   * @return the sum of all possible points of all assignments in this AssignmentGroup
   */
  public int getTotalPossible() {
    // Creates a default variable at 0
    int totalMaxPoints = 0;
    // Goes through the ArrayList
    for (int i = 0; i < assignments.size(); i++) {
      // Adds the max points possible of each assignments to the totalMaxPoints variable
      totalMaxPoints += assignments.get(i).POINTS_POSSIBLE;
    }
    // Returns the overall potential max points accross the assignment group
    return totalMaxPoints;
  }
  
  /**
   * Determines whether all assignments currently in this AssignmentGroup have been completed.
   * 
   * @return true if ALL assignments in this AssignmentGroup have been completed; false otherwise
   */
  public boolean isComplete() {
    // Creates a default checker variable
    int testerComplete = -1;
    // Goes through the ArrayList
    for (int i = 0; i < assignments.size(); i++) {
      // If it finds an incomplete assignment, it adds 1 to the checker variable testerComplete
      if (assignments.get(i).isComplete() == false) {
        testerComplete += 1;
      }
    }
    // If testerComplete is not at -1, then it must not all be complete and returns false
    if (testerComplete != -1) {
      return false;
    } else {
      // Everything is complete, returns true
      return true;
    }
  }
  
  /**
   * Creates a String representation of this AssignmentGroup. Each assignment is listed 
   * by number (1-based) and its String representation.
   * 
   * @return a String containing all of the assignments in this AssignmentGroup
   */
  @Override
  public String toString() {
    // Creates a default returnString
    String returnString = "";
    // Counter for the toString at front
    int counter = 1;
    // Original line
    returnString = returnString + counter + ". " + assignments.get(0);
    counter += 1;
    // Goes through and creates a new line for assignment
    for (int i = 1; i < assignments.size(); i++) {
      returnString = returnString + "\n" + counter + ". " + assignments.get(i);
      counter += 1;
    }
    // Returns the final string
    return returnString;
  }
}
