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
 * This class models a collection of scores which are worth a given percentage of a student's grade.
 *  When calculating the point values for this type of assignment group, the lowest N scores are 
 *  dropped, which is facilitated using a pair of static utility methods.
 * 
 * @author Arsalan Ahmad
 * @author Kush Arora
 *
 */

public class DropAssignmentGroup {
  // An ArrayList containing the assignments associated with this DropAssignmentGroup
  private ArrayList<SimpleAssignment> assignments;

  // The number of assignments to be dropped from this group; must be strictly positive
  private int numDropped;

  // The percent of the total grade this DropAssignmentGroup comprises
  public final double PERCENT_OF_TOTAL;


  /**
   * Basic constructor, initializes an assignment group which is worth the given percentage of a
   * student's grade and which allows a given number of dropped scores. 
   * 
   * @param percent - the percent of the total grade that this assignment group represents, 
   * assumed to be between 0 and 1. 
   * 
   * @param drops - the number of assignments to be dropped; if the given number is less than 1, the
   * constructor will set it to 1.
   * 
   */
  public DropAssignmentGroup(double percent, int drops) {

    assignments = new ArrayList<SimpleAssignment>();

    PERCENT_OF_TOTAL = percent;

    numDropped = drops;

  }

  /**
   * Accesses the total number of earned points across all assignments in this DropAssignmentGroup,
   * after dropping the lowest N (numDropped) 
   * 
   * @return the sum of all earned points of all non-dropped assignments in this DropAssignmentGroup
   * 
   */
  public double getPoints() {
    
    // start by dropping lowest N

    ArrayList<SimpleAssignment> newArray = dropLowestN(assignments, numDropped);
    
    // loop through array and add points of all assignments

    double totalPoints = 0.0;

    for (int i = 0; i < newArray.size(); i++) {
      totalPoints += newArray.get(i).getPoints();
    }
    return totalPoints;
  }



  /**
   * Accesses the total number of points possible across all assignments in this
   * DropAssignmentGroup, after dropping the lowest N (numDropped). Be careful - not all assignments
   * in this group are required to have the same number of points possible. 
   * 
   * @return the sum of all possible points of all non-dropped assignments in this 
   * DropAssignmentGroup
   * 
   */
  public int getTotalPossible() {
    // start by dropping the lowestN
    ArrayList<SimpleAssignment> newArray = dropLowestN(assignments, numDropped);
    
    // loop through array and add total points
    int totalMaxPoints = 0;
    for (int i = 0; i < newArray.size(); i++) {
      totalMaxPoints += newArray.get(i).POINTS_POSSIBLE;
    }
    return totalMaxPoints;
  }


  /**
   * Determines whether all assignments currently in this DropAssignmentGroup have been completed,
   * after dropping the lowest N (numDropped). 
   * 
   * @return true if ALL non-dropped assignments in this DropAssignmentGroup have been 
   * completed; false otherwise
   * 
   */
  public boolean isComplete() {
    // start by dropping the lowest N
    ArrayList<SimpleAssignment> newArray = dropLowestN(assignments, numDropped);
    
    // loop through array and if an assignment isn't complete, return false
    for (int i = 0; i < newArray.size(); i++) {
      if (!newArray.get(i).isComplete()) {
        return false;
      }
    }
    return true;
  }

  /**
   * Accesses the number of assignments currently stored in this DropAssignmentGroup, NOT accounting
   * for drops 
   * 
   * @return the number of assignments present in this DropAssignmentGroup
   * 
   */
  public int getNumAssignments() {
    // return size to get number of elements
    return assignments.size();
  }

  /**
   * Retrieves an assignment at the given index in the DropAssignmentGroup, NOT accounting for
   * drops 
   * 
   * @param i - the index of the assignment to access (0-based)
   * @return the assignment at the given index, or null if the index is out of bounds
   * 
   */
  public SimpleAssignment getAssignment(int i) {
    // returns the assignment at index i
    return assignments.get(i);
  }

  /**
   * Adds a single assignment object to this DropAssignmentGroup 
   * 
   * @param assignment - theSimpleAssignment to add
   * 
   */
  public void addAssignment(SimpleAssignment assignment) {
    // simply add assignment to arraylist
    assignments.add(assignment);
  }

  /**
   * Adds a batch of assignments to this DropAssignmentGroup in the order they appear 
   * 
   * @param assignmentBatch - a perfect-size array of SimpleAssignments to add; you may assume there are no
   * null values present in this array
   * 
   */
  public void addAssignments(SimpleAssignment[] assignmentBatch) {
    
    // loop through array and add each element
    for (int i = 0; i < assignmentBatch.length; i++) {
      assignments.add(assignmentBatch[i]);
    }
  }

  /**
   * Without modifying the input ArrayList, creates a NEW ArrayList which contains all but the
   * lowest- scoring N (numDropped) assignments from the input ArrayList. If the input ArrayList
   * contains N (numDropped) or fewer assignments, the returned ArrayList will be empty. 
   * 
   * @param assignments - an ArrayList containing all assignments 
   * 
   * @param n - the number of assignments to drop
   * 
   * @return a COPY of the input ArrayList which contains all but the lowest-scoring n (NOT
   * numDropped) assignments
   * 
   */
  public static ArrayList<SimpleAssignment> dropLowestN(ArrayList<SimpleAssignment> assignments,
      int n) {
    ArrayList<SimpleAssignment> newArray = new ArrayList<SimpleAssignment>();
    
    // check if dropped is greater than amount of assignments
    if (n >= assignments.size()) {
      return newArray;
    }
    
    // copy parameter into a new array
    for (int i = 0; i < assignments.size(); i++) {
      newArray.add(assignments.get(i));
    }
    
    int index;
    // using the get lowest n method, we find the index of the lowest and remove it n times
    for (int i = 0; i < n; i++) {
      index = getLowestScoreIndex(newArray);
      newArray.remove(index);
    }
    return newArray;
  }


  /**
   * Finds the index of the lowest scoring assignment in the given ArrayList. In the case of ties,
   * this method should prefer the assignment with the lower index. No other form of tie-breaking
   * (e.g. points possible, completeness, etc) should be implemented. 
   * 
   * @param assignments - an ArrayList containing the assignments to analyze 
   * 
   * @return the index (0-based) of the lowest scoring assignment
   * 
   */
  public static int getLowestScoreIndex(ArrayList<SimpleAssignment> assignments) {
    
    // smallest variable set to first element to keep track
    double smallest = assignments.get(0).getPoints();
    
    // Loop through arraylist to assign smallest value in array
    for (int i = 1; i < assignments.size(); i++) {
      if (assignments.get(i).getPoints() < smallest) {
        smallest = assignments.get(i).getPoints();
      }
    }
    
    // reLoop through the array to find the index of the smallest
    int index = 0;
    for (int i = 0; i < assignments.size(); i++) {
      if (smallest == assignments.get(i).getPoints()) {
        index = i;
      }
    }
    return index;
  }



  /**
   * Creates a String representation of this DropAssignmentGroup. Each assignment is listed by
   * number (1-based) and its String representation. 
   * 
   * @return a String containing all of the non-dropped assignments in this DropAssignmentGroup
   * 
   */
  @Override
  public String toString() {
    String returnString = "";
    int counter = 1;
    returnString = returnString + counter + ". " + assignments.get(0);
    counter += 1;
    for (int i = 1; i < assignments.size(); i++)
    {
      returnString = returnString + "\n" + counter + ". " + assignments.get(i);
      counter += 1;
    }
    return returnString;
  }
}
