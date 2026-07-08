
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 Ticket rush
// Course: CS 300 Fall 2023
//
// Author: Arsalan Ahmad
// Email: ahmad34@wisc.edu
// Lecturer: Mark Mansi
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
//Persons: N/A
// Online Sources: N/A
//
//////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

/**
 * A series of static tester methods to check the correctness of the TicketQueue
 * and the TicketQueueIterator.
 * 
 * @author Arsalan Ahmad
 */
public class TicketQueueTester {

	/**
	 * Checks the correctness of the TicketQueue's peek() method, including case(s)
	 * where it should throw exceptions.
	 * 
	 * @returns true if all test cases pass, false otherwise
	 */
	public static boolean testPeek() {
		TicketQueue test = new TicketQueue(100);
		Ticket tick = new Ticket("Nuggets Game", "Ball Arena", "Section IV", "108", 40.5);
		TicketSiteUser user = new TicketSiteUser("arsalan", "password", "1111222233334444");
		boolean emptyPeek = false;
		try {
			test.peek();
		} catch (NoSuchElementException e) {
			emptyPeek = true;
		}
		user.login("arsalan", "password");
		test.enqueue(user);
		TicketSiteUser user2 = new TicketSiteUser("mark", "password", "4444333322221111");
		user2.login("mark", "password");
		test.enqueue(user2);
		TicketSiteUser peeker = test.peek();
		test.peek();
		if (test.size() == 2 && emptyPeek && user.toString().equals(peeker.toString())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks the correctness of the TicketQueue's enqueue() method, including
	 * case(s) where it should throw exceptions.
	 * 
	 * @returns true if all test cases pass, false otherwise
	 */
	public static boolean testEnqueue() {
		TicketQueue test = new TicketQueue(2);
		Ticket tick = new Ticket("Nuggets Game", "Ball Arena", "Section IV", "108", 40.5);
		TicketSiteUser user = new TicketSiteUser("arsalan", "password", "1111222233334444");
		user.login("arsalan", "password");
		test.enqueue(user);
		TicketSiteUser user2 = new TicketSiteUser("mark", "password", "4444333322221111");
		user2.login("mark", "wrong password");
		boolean badUser = false;
		try {
			test.enqueue(user2);
		} catch (IllegalArgumentException e) {
			badUser = true;
		}
		user2.login("mark", "password");
		test.enqueue(user2);
		TicketSiteUser user3 = new TicketSiteUser("user3", "password", "0000999988887777");
		user3.login("user3", "password");
		boolean queueFull = false;
		try {
			test.enqueue(user3);
		} catch (IllegalStateException e) {
			queueFull = true;
		}
		TicketSiteUser peeker = test.peek();
		if (queueFull && badUser && test.size() == 2 && (user.toString().equals(peeker.toString()))) {
			return true;
		}
		return false;
	}

	/**
	 * Checks the correctness of the TicketQueue's dequeue() method, including
	 * case(s) where it should throw exceptions.
	 * 
	 * @returns true if all test cases pass, false otherwise
	 */
	public static boolean testDequeue() {
		TicketQueue test = new TicketQueue(100);
		Ticket tick = new Ticket("Nuggets Game", "Ball Arena", "Section IV", "108", 40.5);
		TicketSiteUser user = new TicketSiteUser("arsalan", "password", "1111222233334444");
		boolean noDq = false;
		try {
			test.dequeue();
		} catch (NoSuchElementException e) {
			noDq = true;
		}
		user.login("arsalan", "password");
		test.enqueue(user);
		TicketSiteUser user2 = new TicketSiteUser("mark", "password", "4444333322221111");
		user2.login("mark", "password");
		test.enqueue(user2);
		test.dequeue();
		boolean firstDq = false;
		if (test.size() == 1) {
			firstDq = true;
		}
		test.dequeue();
		boolean secondDq = false;
		if (test.isEmpty()) {
			secondDq = true;
		}
		return firstDq && secondDq && noDq;
	}

	/**
	 * Checks the correctness of the TicketQueue's constructor, including case(s)
	 * where it should throw exceptions. Also checks the correctness of isEmpty(),
	 * isFull(), size(), capacity(), and toString() on a newly created TicketQueue.
	 * 
	 * @returns true if all test cases pass, false otherwise
	 */
	public static boolean testConstructor() {
		boolean badArgument = false;
		try {
			TicketQueue y = new TicketQueue(0);
		} catch (IllegalArgumentException e) {
			badArgument = true;
		}
		TicketQueue x = new TicketQueue(100);
		return x.capacity() == 100 && badArgument && x.size() == 0 && x.isEmpty();
	}

	/**
	 * Checks the correctness of the TicketQueueIterator method(s) and iterating
	 * through a TicketQueue. You DO NOT need to test if the TicketQueueIterator
	 * constructor throws an exception when the queue parameter is null.
	 * 
	 * @returns true if all test cases pass, false otherwise
	 */
	public static boolean testIterator() {
		TicketQueue ticketQueue = new TicketQueue(5);
		TicketSiteUser user1 = new TicketSiteUser("arsalan", "password", "1111222233334441");
		TicketSiteUser user2 = new TicketSiteUser("mark", "password", "1111222233334442");
		TicketSiteUser user3 = new TicketSiteUser("john", "password", "1111222233334443");

		user1.login("arsalan", "password");
		user2.login("mark", "password");
		user3.login("john", "password");

		ticketQueue.enqueue(user1);
		ticketQueue.enqueue(user2);
		ticketQueue.enqueue(user3);

		TicketSiteUser[] expectedUsers = { user1, user2, user3 };

		int index = 0;
		for (TicketSiteUser user : ticketQueue) {
			index++;
		}
		if (index == expectedUsers.length) {
			return true;
		}
		return false;
	}

	// a test suite method to run all your test methods
	private static boolean runAllTests() {
		boolean peek = testPeek(), enqueue = testEnqueue(), dequeue = testDequeue(), constructor = testConstructor(),
				iterator = testIterator();
		System.out.println("test peek: " + (peek ? "pass" : "FAIL"));
		System.out.println("test enqueue: " + (enqueue ? "pass" : "FAIL"));
		System.out.println("test dequeue: " + (dequeue ? "pass" : "FAIL"));
		System.out.println("test constructor: " + (constructor ? "pass" : "FAIL"));
		System.out.println("test iterator: " + (iterator ? "pass" : "FAIL"));

		return peek && enqueue && dequeue && constructor && iterator;

	}

	public static void main(String[] args) {
		runAllTests();
	}
}
