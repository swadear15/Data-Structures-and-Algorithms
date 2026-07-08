//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Airplane Boarding System
// Course: CS 300 Fall 2023
//
// Author: Arsalan Ahmad
// Email: ahmad34@wisc.edu
// Lecturer: Mark Mansi
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: N/A
// Online Sources: N/A
//
//////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * This is a Utility class which implements tester methods to ensure the
 * correctness of the implementation of the main operations defined in cs300
 * fall 2023 p10 Airplane Boarding System.
 *
 */
public class BoardingSystemTester {

	/**
	 * Ensures the correctness of Passenger.compareTo() method when called to
	 * compare two Passenger objects having different boarding groups.
	 * 
	 * @return true if the tester verifies a correct functionality and false if at
	 *         least one bug is detected
	 */
	public static boolean testPassengerCompareToDifferentGroup() {
		// TODO complete the implementation of this tester method
		// [HINT] You can consider at least two Passenger objects, and ensure at least
		// the following:
		// p1.compareTo(p2) < 0, if p1 has a boarding group less than the boarding group
		// of p2.
		// p2.compareTo(p1) > 0
		// where p1, and p2 are references to Passenger objects with different boarding
		// groups.
		// Recall that we defined three boarding groups A, B, and C such that A < B < C.
		Passenger p1 = new Passenger("Arsalan", Group.A, true);
		Passenger.resetPassengerOrder();
		Passenger p2 = new Passenger("Daniel", Group.B, true);
		int compare1 = p1.compareTo(p2);
		int compare2 = p2.compareTo(p1);

		return compare1 < 0 && compare2 > 0; // default return statement
	}

	/**
	 * Ensures the correctness of Passenger.compareTo() method when called to
	 * compare two Passenger objects having the same boarding group, and different
	 * arrival orders.
	 * 
	 * @return true if the tester verifies a correct functionality and false if at
	 *         least one bug is detected
	 */
	public static boolean testPassengerCompareToSameGroupDifferentArrival() {
		// TODO complete the implementation of this tester method
		// [Hint] You can consider at least two Passenger objects having the SAME
		// boarding group, and
		// ensure at least the following:
		// p1.compareTo(p2) < 0, if p1.ARRIVAL_ORDER is less than p2.ARRIVAL_ORDER
		// p2.compareTo(p1) > 0
		Passenger p1 = new Passenger("Arsalan", Group.A, true);
		Passenger p2 = new Passenger("Daniel", Group.A, true);
		int compare1 = p1.compareTo(p2);
		int compare2 = p2.compareTo(p1);

		return compare1 < 0 && compare2 > 0; // default return statement
	}

	/**
	 * Ensures two passengers having the SAME boarding group and with the SAME order
	 * of arrival are equal (compareTo should return 0).
	 * 
	 * @return true if the tester verifies a correct functionality and false if at
	 *         least one bug is detected
	 */
	public static boolean testPassengerCompareToSameGroupSameArrival() {
		// TODO complete the implementation of this tester method
		// Even though this case will not be possible in your priority queue, it is
		// required for testing
		// the full functionality of the compareTo() method.
		// [Hint] You can use the resetPassengerOrder() to create equivalent passengers.
		Passenger.resetPassengerOrder();
		Passenger p1 = new Passenger("Arsalan", Group.A, true);
		Passenger.resetPassengerOrder();
		Passenger p2 = new Passenger("Daniel", Group.A, true);
		int compare1 = p1.compareTo(p2);
		int compare2 = p2.compareTo(p1);
		return compare1 == 0 && compare2 == 0;
	}

	/**
	 * Ensures the correctness of the constructor for BoardingQueue class.
	 * 
	 * This tester should implement at least the following test cases:
	 *
	 * - Calling the constructor of the BoardingQueue class with an invalid capacity
	 * should throw an IllegalArgumentException - Calling the constructor or the
	 * BoardingQueue class with a valid capacity should not throw any errors, and
	 * should result in a new BoardingQueue object which is empty, has size 0, a
	 * capacity equal to the capacity that was passed as a parameter, and the heap
	 * array contains only null references.
	 *
	 * @return true if the constructor of the BoardingQueue functions properly,
	 *         false otherwise
	 */
	public static boolean testBoardingQueueConstructor() {
		// TODO complete the implementation of this tester method
		// [HINT] you can get a copy of the heap array by calling
		// BoardingQueue.toArray() method
		boolean exceptionTest = false;
		try {
			BoardingQueue test1 = new BoardingQueue(-1);
		} catch (IllegalArgumentException e) {
			exceptionTest = true;
		}
		BoardingQueue test = new BoardingQueue(10);
		if (test.capacity() == 10 && exceptionTest && test.size() == 0 && test.toString().equals("")) {
			return true;
		}

		return false; // default return statement
	}

	/**
	 * Tests the functionality of BoardingQueue.peekBest() method by calling
	 * peekBest on an empty queue and verifying it throws a NoSuchElementException.
	 * 
	 * @return true if BoardingQueue.peekBest() verifies a correct functionality,
	 *         false otherwise
	 */
	public static boolean testPeekBestEmptyQueue() {
		// TODO complete the implementation of this tester method
		BoardingQueue test = new BoardingQueue(10);
		Passenger.resetPassengerOrder();
		boolean tryPeek = false;
		try {
			test.peekBest();
		} catch (NoSuchElementException e) {
			tryPeek = true;
		}
		return tryPeek; // default return statement
	}

	/**
	 * Tests the functionality of BoardingQueue.peekBest() method by calling
	 * peekBest on a non-empty queue and ensures it
	 * 
	 * 1) returns the Passenger having the highest priority (the minimum), and 2)
	 * does not remove that Passenger from the boarding queue.
	 * 
	 * @return true if the tester verifies a correct functionality and false if at
	 *         least one bug is detected
	 */
	public static boolean testPeekBestNonEmptyQueue() {
		// TODO complete the implementation of this tester method
		BoardingQueue test = new BoardingQueue(10);
		Passenger.resetPassengerOrder();
		Passenger p1 = new Passenger("Arsalan", Group.B, true);
		Passenger p2 = new Passenger("Daniel", Group.A, true);
		test.enqueue(p1);
		test.enqueue(p2);
		boolean peekTest = test.peekBest().equals(p2);
		return peekTest && test.size() == 2;
	}

	/**
	 * Tests the functionality of the BoardingQueue.enqueue() method by calling
	 * enqueue() on an empty queue and ensuring the method 1) adds the Passenger and
	 * 2) increments the size.
	 * 
	 * @return true if the tester verifies a correct functionality and false if at
	 *         least one bug is detected
	 */
	public static boolean testEnqueueToEmptyQueue() {
		// TODO complete the implementation of this tester method
		BoardingQueue test = new BoardingQueue(10);
		Passenger.resetPassengerOrder();
		Passenger p1 = new Passenger("Arsalan", Group.B, true);
		//Passenger pass2 = new Passenger("Daniel", Group.A, true);
		//Passenger pass3 = new Passenger("Mark", Group.B, true);
		test.enqueue(p1);
		// test.enqueue(pass2);
		// test.enqueue(pass3);
		boolean isItThere = test.peekBest().equals(p1);

		return test.size() == 1 && isItThere;
	}

	/**
	 * Tests the functionality of the BoardingQueue.enqueue() method by calling
	 * enqueue() on a non-empty queue and ensuring it
	 * 
	 * 1) inserts the Passenger at the proper position of the heap, increments the
	 * size by one, and returns true, if the queue was not already full.
	 * 
	 * 2) returns false, without making any changes to the size of the queue or the
	 * array heap, if the method is called on a full queue.
	 * 
	 * Try adding at least 5 Passengers.
	 * 
	 * @return true if tester verifies a correct functionality and false if at least
	 *         one bug is detected
	 */
	public static boolean testEnqueueToNonEmptyQueue() {
		// TODO complete the implementation of this tester method
		// [HINT] you can get a copy of the heap array by calling
		// BoardingQueue.toArray() method
		// Create empty queue
		BoardingQueue test = new BoardingQueue(5);
		Passenger.resetPassengerOrder();
		
		Passenger p1 = new Passenger("B", Group.C, true);
		Passenger p2 = new Passenger("A", Group.C, true);
		Passenger p3 = new Passenger("C", Group.A, true);
		Passenger p4 = new Passenger("D", Group.B, true);
		Passenger p5 = new Passenger("G", Group.A, true);

		if (!test.enqueue(p1) || test.size() != 1) {
			return false;
		}
		if (!test.enqueue(p2) || test.size() != 2) {
			return false;
		}
		if (!test.enqueue(p3) || test.size() != 3) {
			return false;
		}

		if (!test.enqueue(p4) || test.size() != 4) {
			return false;
		}

		if (!test.enqueue(p5)) {
			return false;
		}
		Passenger[] arrayTest = new Passenger[5];
		arrayTest = test.toArray();
		boolean inRightOrder = true;

		if (arrayTest[0].compareTo(p3) != 0) {
			inRightOrder = false;
		}
		if (arrayTest[1].compareTo(p5) != 0) {
			inRightOrder = false;
		}
			
		if (arrayTest[2].compareTo(p1) != 0) {
			inRightOrder = false;
		}
			
		if (arrayTest[3].compareTo(p2) != 0) {
			inRightOrder = false;
		}
		if (arrayTest[4].compareTo(p4) != 0) {
			inRightOrder = false;
		}
			

		return inRightOrder && !test.isEmpty();

	}

	/**
	 * Tests the functionality of BoardingQueue.dequeue() method by calling
	 * dequeue() on an empty queue and ensures a NoSuchElementException is thrown in
	 * that case.
	 * 
	 * @return true if tester verifies a correct functionality and false if at least
	 *         one bug is detected
	 */
	public static boolean testDequeueEmpty() {
		// TODO complete the implementation of this tester method
		BoardingQueue test = new BoardingQueue(4);
		Passenger.resetPassengerOrder();
		boolean emptyDQ = false;
		try {
			test.dequeue();
		} catch (NoSuchElementException e) {
			emptyDQ = true;
		}
		return emptyDQ; // default return statement
	}

	/**
	 * Tests the functionality of BoardingQueue.dequeue() method by calling
	 * dequeue() on a queue of size one and ensures the method call returns the
	 * correct Passenger, size is zero, and the array heap contains null references,
	 * only.
	 * 
	 * @return true if tester verifies a correct functionality and false if at least
	 *         one bug is detected
	 */
	public static boolean testDequeueBoardingQueueSizeOne() {
		// TODO complete the implementation of this tester method
		// [HINT] you can get a copy of the heap array by calling
		// BoardingQueue.toArray() method
		BoardingQueue test = new BoardingQueue(10);
		Passenger.resetPassengerOrder();
		Passenger p1 = new Passenger("Arsalan", Group.B, true);
		test.enqueue(p1);
		boolean isItThere = test.peekBest().equals(p1);
		boolean originalSize = test.size() == 1;
		test.dequeue();

		return test.size() == 0 && isItThere && originalSize;
	}

	/**
	 * Tests the functionality of BoardingQueue.dequeue() when called on a non-empty
	 * boarding queue.
	 * 
	 * This tests ensures the dequeue() method removes, and returns the passenger
	 * with the highest boarding priority in the queue, the size of the queue must
	 * be decremented by one, and the contents of the heap array is as expected.
	 * 
	 * @return true if PriorityCareAdmissions.dequeue() returns the correct
	 *         Passenger each time it is called and size is appropriately
	 *         decremented, false otherwise
	 */
	public static boolean testDequeueBoardingQueueNonEmpty() {
		// TODO complete the implementation of this tester method
		// [HINT] Try considering calling dequeue from a boarding queue whose size is at
		// least 6.
		// Consider cases where percolate-down recurses on left and right.
		// You can call dequeue multiple times to cover multiple operational cases of
		// percolate down
		// method (for instance percolate down can reach the bottom level of the heap or
		// not)
		BoardingQueue queue = new BoardingQueue(10);
		Passenger.resetPassengerOrder();
		
		Passenger p1 = new Passenger("B", Group.C, true);
		Passenger p2 = new Passenger("A", Group.A, true);
		Passenger p3 = new Passenger("C", Group.A, true);
		Passenger p4 = new Passenger("D", Group.C, true);
		Passenger p5 = new Passenger("E", Group.C, true);
		Passenger p6 = new Passenger("F", Group.B, true);

		queue.enqueue(p1);
		queue.enqueue(p2);
		queue.enqueue(p3);
		queue.enqueue(p4);
		queue.enqueue(p5);
		queue.enqueue(p6);

		boolean compareCheck = true;

		if (queue.dequeue().compareTo(p2) != 0) {
			compareCheck = false;
		}
		if (queue.dequeue().compareTo(p3) != 0) {
			compareCheck = false;
		}
		if (queue.dequeue().compareTo(p6) != 0) {
			compareCheck = false;
		}
		if (queue.dequeue().compareTo(p1) != 0) {
			compareCheck = false;
		}
		if (queue.dequeue().compareTo(p4) != 0) {
			compareCheck = false;
		}
		if (queue.dequeue().compareTo(p5) != 0) {
			compareCheck = false;
		}

		return compareCheck;
	}

	/**
	 * Tests the functionality of the clear() method. Should implement at least the
	 * following scenarios:
	 * 
	 * - clear can be called on an empty queue with no errors.
	 * 
	 * - clear can be called on a non-empty queue with no errors.
	 * 
	 * After calling clear(), this tester ensures that the queue is empty, meaning
	 * its size is zero and its heap array contains only null references.
	 *
	 * @return true if the tester verifies a correct functionality and false if at
	 *         least one bug is detected
	 */
	public static boolean testBoardingQueueClear() {
		// TODO complete the implementation of this tester method
		BoardingQueue test = new BoardingQueue(6);
		Passenger.resetPassengerOrder();
		Passenger p1 = new Passenger("Arsalan", Group.B, true);
		Passenger p2 = new Passenger("Daniel", Group.A, true);
		Passenger p3 = new Passenger("Mark", Group.C, true);
		Passenger p4 = new Passenger("Alex", Group.A, true);
		Passenger p5 = new Passenger("Mario", Group.B, true);
		Passenger p6 = new Passenger("John", Group.C, true);
		test.enqueue(p1);
		test.enqueue(p2);
		test.enqueue(p3);
		test.enqueue(p4);
		test.enqueue(p5);
		test.enqueue(p6);

		test.clear();
		boolean tryPeek = false;
		try {
			test.peekBest();
		} catch (NoSuchElementException e) {
			tryPeek = true;
		}

		return tryPeek && test.size() == 0;
	}

	/**
	 * Main method to run this tester class.
	 * 
	 * @param args list of input arguments if any
	 */
	public static void main(String[] args) {
		System.out.println("Passenger Compare Testers: ");
		System.out.println("testPassengerCompareToDifferentGroup: "
				+ (testPassengerCompareToDifferentGroup() ? "Pass" : "Failed!"));
		System.out.println("testPassengerCompareToSameGroupDifferentArrival: "
				+ (testPassengerCompareToSameGroupDifferentArrival() ? "Pass" : "Failed!"));
		System.out.println("testPassengerCompareToSameGroupSameArrival: "
				+ (testPassengerCompareToSameGroupSameArrival() ? "Pass" : "Failed!"));
		System.out.println("");

		System.out.println("Boarding Queue Testers: ");
		System.out.println("testBoardingQueueConstructor: " + (testBoardingQueueConstructor() ? "Pass" : "Failed!"));
		System.out.println("testPeekBestEmptyQueue: " + (testPeekBestEmptyQueue() ? "Pass" : "Failed!"));
		System.out.println("testPeekBestNonEmptyQueue: " + (testPeekBestNonEmptyQueue() ? "Pass" : "Failed!"));
		System.out.println("testEnqueueToEmptyQueue: " + (testEnqueueToEmptyQueue() ? "Pass" : "Failed!"));
		System.out.println("testEnqueueToNonEmptyQueue: " + (testEnqueueToNonEmptyQueue() ? "Pass" : "Failed!"));
		System.out.println("testDequeueEmpty: " + (testDequeueEmpty() ? "Pass" : "Failed!"));
		System.out.println(
				"testDequeueBoardingQueueSizeOne: " + (testDequeueBoardingQueueSizeOne() ? "Pass" : "Failed!"));
		System.out.println(
				"testDequeueBoardingQueueNonEmpty: " + (testDequeueBoardingQueueNonEmpty() ? "Pass" : "Failed!"));
		System.out.println("testBoardingQueueClear: " + (testBoardingQueueClear() ? "Pass" : "Failed!"));
	}

}
