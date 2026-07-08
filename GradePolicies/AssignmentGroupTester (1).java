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
 * This class tests the methods presented in AssignmentGroupTester and verifies that they work 
 * correctly across the program
 * 
 * @author Kush Arora
 * @author Arsalan Ahmad
 *
 */


public class AssignmentGroupTester {

  /**
   * Using the getNumAssignments() and getAssignment(i) accessor methods,verify that the 
   * addAssignment() method works properly in AssignmentGroup
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  public static boolean testAddOneAssignment() {
	  SimpleAssignment test = new SimpleAssignment(100, true);
	  SimpleAssignment test2 = new SimpleAssignment(50, true);
	  AssignmentGroup group1 = new AssignmentGroup(100);
	  group1.addAssignment(test);
	  group1.addAssignment(test2);
	  if (group1.getNumAssignments() == 2 && group1.getAssignment(1).POINTS_POSSIBLE == 50) {
		  return true;
	  }  
    return false;
  }
  
  /**
   * Using the getNumAssignments() and getAssignment(i) accessor methods, 
   * verify that the addAssignments() method works properly in AssignmentGroup
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  public static boolean testAddManyAssignments() {
	  SimpleAssignment test = new SimpleAssignment(100, true);
	  SimpleAssignment test2 = new SimpleAssignment(50, true);
	  AssignmentGroup group1 = new AssignmentGroup(100);
	  SimpleAssignment[] assignmentBatch = new SimpleAssignment[2];
	  assignmentBatch[0] = test;
	  assignmentBatch[1] = test2;
	  group1.addAssignments(assignmentBatch);
	  if (group1.getNumAssignments() == 2 && group1.getAssignment(1).POINTS_POSSIBLE == 50) {
		  return true;
	  }
    return false;
  }
  
  // PROVIDED
  // Verify that the getTotalPossible() method returns the expected value
  // in EACH of the classes which implements the method
  public static boolean testGetTotal() {
    boolean result = testGroupTotal();
    result &= testDropTotal();
    result &= testScaledTotal();
    
    return result;
  }
  
  /**
   * Verify that getTotalPossible() works as expected in AssignmentGroup
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testGroupTotal() {
	  SimpleAssignment test = new SimpleAssignment(100, true);
	  SimpleAssignment test2 = new SimpleAssignment(50, true);
	  AssignmentGroup group1 = new AssignmentGroup(100);  
	  SimpleAssignment[] assignmentBatch = new SimpleAssignment[2];
	  assignmentBatch[0] = test;
	  assignmentBatch[1] = test2;
	  group1.addAssignments(assignmentBatch);
	  if (group1.getTotalPossible() == 150) {
		  return true;
	  }
      return false;
  }
  
  /**
   * Verify that getTotalPossible() works as expected in DropAssignmentGroup
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testDropTotal() {
	  SimpleAssignment test = new SimpleAssignment(100, true);
	  SimpleAssignment test2 = new SimpleAssignment(50, true);
	  test.complete(100);
	  test2.complete(20);
	  DropAssignmentGroup group1 = new DropAssignmentGroup(80, 1);
	  
	  SimpleAssignment[] assignmentBatch = new SimpleAssignment[2];
	  assignmentBatch[0] = test;
	  assignmentBatch[1] = test2;
	  group1.addAssignments(assignmentBatch);
	  
	  if (group1.getTotalPossible() == 100) {
		  return true;
	  }
    return false;
  }
  
  /**
   * Verify that getTotalPossible() works as expected in ScalingAssignmentGroup
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testScaledTotal() {
	  SimpleAssignment test = new SimpleAssignment(100, true);
	  SimpleAssignment test2 = new SimpleAssignment(50, true);
	  test.complete(40);
	  test2.complete(20);
	  
	  
	  ScalingAssignmentGroup group1 = new ScalingAssignmentGroup(80, 0.5);
	  
	  SimpleAssignment[] assignmentBatch = new SimpleAssignment[2];
	  assignmentBatch[0] = test;
	  assignmentBatch[1] = test2;
	  group1.addAssignments(assignmentBatch);
	  
	  if (group1.getTotalPossible() == 75) {
		  return true;
	  }
    return false;
  }
  
  // PROVIDED
  // Verify that the getPoints() method returns the expected value in EACH
  // of the classes which implements the method
  public static boolean testGetPoints() {
    boolean result = testGroupPoints();
    result &= testDropPoints();
    result &= testScaledPoints();
    
    return result;
  }
  
  /**
   * Verify that getPoints() works as expected in AssignmentGroup
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testGroupPoints() {
	  SimpleAssignment test = new SimpleAssignment(100, true);
	  SimpleAssignment test2 = new SimpleAssignment(50, true);
	  test.complete(100);
	  test2.complete(20);
	  
	  
	  AssignmentGroup group1 = new AssignmentGroup(100);
	  
	  SimpleAssignment[] assignmentBatch = new SimpleAssignment[2];
	  assignmentBatch[0] = test;
	  assignmentBatch[1] = test2;
	  group1.addAssignments(assignmentBatch);
	  
	  if (group1.getPoints() == 120) {
		  return true;
	  }
    return false;
  }
  
  /**
   * Verify that getPoints() works as expected in DropAssignmentGroup
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testDropPoints() {
	  SimpleAssignment test = new SimpleAssignment(100, true);
	  SimpleAssignment test2 = new SimpleAssignment(50, true);
	  test.complete(80);
	  test2.complete(20);
	  
	  
	  DropAssignmentGroup group1 = new DropAssignmentGroup(100, 1);
	  
	  SimpleAssignment[] assignmentBatch = new SimpleAssignment[2];
	  assignmentBatch[0] = test;
	  assignmentBatch[1] = test2;
	  group1.addAssignments(assignmentBatch);
	  
	  if (group1.getPoints() == 80) {
		  return true;
	  }
    return false;
  }
  
  /**
   * Verify that getPoints() works as expected in ScalingAssignmentGroup
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testScaledPoints() {
	
	  SimpleAssignment test = new SimpleAssignment(100, true);
	  SimpleAssignment test2 = new SimpleAssignment(100, true);
	  test.complete(100);
	  test2.complete(100);
	  
	  
	  ScalingAssignmentGroup group1 = new ScalingAssignmentGroup(100,0.5);
	  
	  SimpleAssignment[] assignmentBatch = new SimpleAssignment[2];
	  assignmentBatch[0] = test;
	  assignmentBatch[1] = test2;
	  group1.addAssignments(assignmentBatch);
	  
	  if (group1.getPoints() == 100) {
		  return true;
	  }
    return false;
  }
  
  /**
   * Verify that the isComplete() accessor method works as expected in AssignmentGroup
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  public static boolean testComplete() {
	  SimpleAssignment test = new SimpleAssignment(100, true);
	  SimpleAssignment test2 = new SimpleAssignment(50, true);
	  test.complete(100);
	  test2.complete(20);
	  
	  
	  AssignmentGroup group1 = new AssignmentGroup(100);
	  
	  SimpleAssignment[] assignmentBatch = new SimpleAssignment[2];
	  assignmentBatch[0] = test;
	  assignmentBatch[1] = test2;
	  group1.addAssignments(assignmentBatch);
	  
	 
	  
	  if (group1.isComplete()) {
		  return true;
	  }
    return false;
  }
  
  public static void main(String[] args) {
    if (SimpleAssignmentTester.runAllTests()) {
      System.out.println("add one: "+(testAddOneAssignment()?"PASS":"fail"));
      System.out.println("add many: "+(testAddManyAssignments()?"PASS":"fail"));
      System.out.println("get total: "+(testGetTotal()?"PASS":"fail"));
      System.out.println("get points: "+(testGetPoints()?"PASS":"fail"));
      System.out.println("complete: "+(testComplete()?"PASS":"fail"));
    }
    else {
      System.out.println("Your SimpleAssignment implementation does NOT pass its tests!\n"
          + "Do NOT continue with AssignmentGro until you have passed all SimpleAssignment tests.");
    }
  }
  
}
