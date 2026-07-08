
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 Ticket rush
// Course: CS 300 Fall 2023
//
//Author: Arsalan Ahmad
// Email: ahmad34@wisc.edu
// Lecturer: Mark Mansi
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: N/A
// Online Sources: N/A
//
//////////////////////////////////////////////////////////////////////////////
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for a TicketQueue that keeps the original queue intact. This
 * iterator will return elements in the order of the queue from front to back.
 * 
 * @author Arsalan Ahmad
 */
public class TicketQueueIterator implements Iterator<TicketSiteUser> {

	// deep copy of a TicketQueue
	private TicketQueue userQueue;

	/**
	 * Constructor for a TicketQueueIterator that sets the data field to be a deep
	 * copy of the given queue
	 * 
	 * @param queue - the TicketQueue for this iterator to use
	 * @throws IllegalArgumentException - if the queue is null
	 */
	public TicketQueueIterator(TicketQueue queue) {
		if (queue == null) {
			throw new NoSuchElementException("Queue is null");
		}
		userQueue = queue.deepCopy();
	}

	/**
	 * Determines whether or not there is another TicketSiteUser in the queue.
	 * 
	 * @returns true if there are more TicketSiteUsers in the queue, false otherwise
	 */
	public boolean hasNext() {
		if (!userQueue.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the next TicketSiteUser in the queue, based on the order from front
	 * to back.
	 * 
	 * @returns the next TicketSiteUser in the queue
	 * @throws NoSuchElementException - if there are no more TicketSiteUsers in the
	 *                                queue.
	 */
	public TicketSiteUser next() {
		if (!hasNext()) {
			throw new NoSuchElementException("Queue is empty");
		}
		return userQueue.dequeue();
	}

}
