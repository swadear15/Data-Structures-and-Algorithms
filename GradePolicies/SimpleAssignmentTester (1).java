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

/**
 * This class tests the methods presented in SimpleAssignment and verifies that they work correctly
 * across the program
 * 
 * @author Arsalan Ahmad
 * @author Kush Arora
 *
 */

public class SimpleAssignmentTester {
  
  /**
   * Call the basic SimpleAssignment constructor and test the accessor methods before and after 
   * completing the assignment. 
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  public static boolean testAccessors() {
	SimpleAssignment test1 = new SimpleAssignment(100);
	SimpleAssignment test2 = new SimpleAssignment(100, true);
	
	test1.complete(80);
	
	boolean completeTest = false;;
	if(!test2.isComplete() || test1.isComplete()) {
		completeTest = true;
	}
	boolean pointsTest = false;
	if (test2.getPoints() == 0 && test2.getPoints() == 0) {
		pointsTest = true;
	}
    return completeTest && pointsTest;
  }
  
  // PROVIDED
  // This method calls a number of shorter helper methods, which test various cases for a
  // SimpleAssignment with the bonus option available
  // By breaking these out into shorter tests, you can use the debugger to step through this
  // method and quickly determine which of the tests are failing, if any.
  public static boolean testSimpleBonus() {
    boolean result = testAwardBonus();
    result &= testBonusTwice();
    result &= testNoBonus();
    result &= testBonus105();
    
    return result;
  }
  
  /**
   * Test that a completed assignment that scores less than 95% has the correct bonus value 
   * added to it when awardBonus() is called
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testAwardBonus() {
	SimpleAssignment test = new SimpleAssignment(100, true);
	test.complete(80);
	test.awardBonus();
	
	if (test.getPoints() == 85) {
		return true;
	}

    return false;
  }
  
  /**
   * Verify that calling the awardBonus() method a second time does not modify the earned 
   * points result
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testBonusTwice() { 
	  SimpleAssignment test = new SimpleAssignment(100, true);
		test.complete(80);
		test.awardBonus();
		test.awardBonus();
		
		if (test.getPoints() == 85) {
			return true;
		}

	    return false;
	  
  }
  
  /**
   * Verify that calling the awardBonus() method on an assignment with NO bonus available 
   * does NOT result in a bonus being applied to the earned points result
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testNoBonus() {
	  SimpleAssignment test = new SimpleAssignment(100, false);
		test.complete(80);
		test.awardBonus();
		
		if (test.getPoints() == 80) {
			return true;
		}

	    return false;
	  
  }
  
  /**
   * Verify that calling the awardBonus() method on an assignment whose earned points are > 95% 
   * of possible points does NOT result in a score that exceeds the total possible points
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testBonus105() {
	  SimpleAssignment test = new SimpleAssignment(100, true);
		test.complete(99);
		test.awardBonus();
		
		if (test.getPoints() == 100) {
			return true;
		}
	    return false;
  }
  
  // PROVIDED
  // This method calls a number of shorter helper methods, all of which test error cases
  // in the SimpleAssignment class.
  // By breaking these out into shorter tests, you can use the debugger to step through this
  // method and quickly determine which of the tests are failing, if any.
  public static boolean testSimpleErrorCases() {
    boolean result = testBadConstructorInput();
    result &= testBonusIncomplete();
    result &= testBadPointsEarned();
    result &= testCompleteAssignmentTwice();
    
    return result;
  }
  
  /**
   * Test the SimpleAssignment constructor with bad input
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testBadConstructorInput() {
		 SimpleAssignment badTest = new SimpleAssignment(-1, true);
		 return badTest.POINTS_POSSIBLE == 1;	
  }
  
  /**
   * Test the awardBonus() method on an assignment that has bonus available but is not 
   * yet completed
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testBonusIncomplete() {
	  SimpleAssignment test = new SimpleAssignment(100, true);
		test.awardBonus();
		
		if (test.getPoints() == 0) {
			return true;
		}

	    return false;
	
  }
  
  /**
   * Test the complete() method with input values outside of the allowed range and make 
   * sure that the points returned are what you expect for the given error case
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testBadPointsEarned() {
	  SimpleAssignment test = new SimpleAssignment(100, true);
	  test.complete(-1);
	  
	  SimpleAssignment test2 = new SimpleAssignment(100, true);
	  test2.complete(102);
	  
	  if (test.getPoints() == 0 && test2.getPoints() == 100) {
		  return true;
	  }
	
	
	
    return false;
  }
  
  /**
   * Test calling complete() twice with different values, and make sure that the earned point 
   * value is NOT updated after the assignment has been completed
   * 
   * @return verified the method works if TRUE; returns false otherwise 
   * 
   */
  private static boolean testCompleteAssignmentTwice() {
	 SimpleAssignment test = new SimpleAssignment(100, true);
	 test.complete(99);
	 
	 test.complete(80);
	 
	 if (test.getPoints() == 99) {
		 return true;
	 }
    return false;
  }
  
  // PROVIDED
  // This method reports whether all provided SimpleAssignmentTester methods 
  // have passed.
  public static boolean runAllTests() {
    return testAccessors() && testSimpleBonus() && testSimpleErrorCases();
  }

  public static void main(String[] args) {
    System.out.println("basic: "+(testAccessors()?"PASS":"fail"));
    System.out.println("bonus: "+(testSimpleBonus()?"PASS":"fail"));
    System.out.println("edge cases: "+(testSimpleErrorCases()?"PASS":"fail"));
  }

}
