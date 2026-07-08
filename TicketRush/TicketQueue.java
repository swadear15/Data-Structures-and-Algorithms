
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
// Persons: N/A
// Online Sources: N/A
//
//////////////////////////////////////////////////////////////////////////////
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A capacity based linked-list queue for TicketSiteUsers
 *
 * @author Arsalan Ahmad
 */
public class TicketQueue implements QueueADT<TicketSiteUser>, Iterable<TicketSiteUser> {

	// the linked node at the back of the queue
	private LinkedNode<TicketSiteUser> back;

	// the MAXIMUM number of TicketSiteUsers that the queue can hold
	private int capacity;

	// the linked node at the front of the queue
	private LinkedNode<TicketSiteUser> front;

	// the number of TicketSiteUsers in the queue
	private int size;

	/**
	 * Creates an empty queue of TicketSiteUsers with the given capacity.
	 * 
	 * @param capacity - the capacity of this queue
	 * @throws IllegalArgumentException - if the capacity is less than 1
	 */
	public TicketQueue(int capacity) {
		if (capacity < 1) {
			throw new IllegalArgumentException("Capacity must be greater than 1");
		}
		this.capacity = capacity;
		size = 0;
		back = null;
		front = null;
	}

	/**
	 * Reports whether or not this queue is full.
	 * 
	 * @returns true is the number of TicketSiteUsers is the same or more of the
	 *          capacity, false otherwise
	 */
	public boolean isFull() {
		return size == capacity;
	}

	/**
	 * Reports the capacity of the queue.
	 * 
	 * @returns the MAXIMUM number of TicketSiteUsers this queue can hold
	 */
	public int capacity() {
		return capacity;
	}

	@Override
	/**
	 * Reports if this queue is empty.
	 * 
	 * @returns true if the queue has no TicketSiteUsers in it, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0 && front == null && back == null;
	}

	@Override
	/**
	 * Reports the current size of the queue.
	 * 
	 * @returns the number of TicketSiteUsers in the queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Changes the capacity of the queue to the new capacity. If the capacity is
	 * lowered, DO NOT remove any elements. It will be considered full until enough
	 * TicketSiteUsers are dequeued by the application.
	 * 
	 * @param newCapacity - the new MAXIMUM number of TicketSiteUsers this queue can
	 *                    hold
	 * @throws IllegalArgumentException - if the newCapacity is less than 1
	 */
	public void setCapacity(int capacity) {
		if (capacity < 1) {
			throw new IllegalArgumentException("Capacity must be greater than 1");
		}
		this.capacity = capacity;
	}

	@Override
	/**
	 * Creates and returns and instance of a TicketQueueIterator for this queue.
	 * 
	 * @return returns the iterator for this class
	 */
	public Iterator<TicketSiteUser> iterator() {
		// TODO Auto-generated method stub
		TicketQueueIterator x = new TicketQueueIterator(this);
		return x;

	}

	@Override
	/**
	 * Adds the given TicketSiteUser to the back of the queue.
	 * 
	 * @param newObject - element to add at the back (end) of the queue
	 * @throws IllegalStateException    - if the queue is full
	 * @throws IllegalArgumentException - if the TicketSite user is not able to buy
	 *                                  a ticket.
	 */
	public void enqueue(TicketSiteUser newObject) {
		// TODO Auto-generated method stub
		LinkedNode<TicketSiteUser> obj = new LinkedNode<TicketSiteUser>(newObject);
		if (isFull()) {
			throw new IllegalStateException("Queue is full");
		}
		if (!newObject.canBuyTicket()) {
			throw new IllegalArgumentException("This user is not able to buy ticket");
		}
		if (isEmpty()) {
			front = obj;
			back = obj;
			size++;
			return;
		}
		back.setNext(obj);
		back = obj;
		size++;

	}

	@Override
	/**
	 * Removes and returns the TicketSiteUser from the front of the queue.
	 * 
	 * @returns the TicketSiteUser at the front of the queu
	 * @throws NoSuchElementException - if the queue is empty
	 */
	public TicketSiteUser dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is Empty, cannot dequeue");
		}
		if (size == 1) {
			LinkedNode<TicketSiteUser> obj = front;
			front = null;
			back = null;
			size--;
			return obj.getData();
		}
		LinkedNode<TicketSiteUser> obj = front;
		front = front.getNext();
		size--;
		return obj.getData();
	}

	@Override
	/**
	 * Returns the TicketSiteUser from the front of the queue without removing it.
	 * 
	 * @returns the element at the front of the queue
	 * @throws NoSuchElementException - if the queue is empty
	 */
	public TicketSiteUser peek() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is Empty, cannot peek");
		}
		return front.getData();
	}

	/**
	 * Creates and returns a deep copy (not the deepest copy) of this TicketQueue.
	 */
	public TicketQueue deepCopy() {
		TicketQueue newQ = new TicketQueue(capacity);
		LinkedNode<TicketSiteUser> current = this.front;
		while (current != null) {
			newQ.enqueue(current.getData());
			current = current.getNext();
		}
		return newQ;
	}

	@Override
	// String Representation of this class
	public String toString() {
		String s = "";
		LinkedNode<TicketSiteUser> runner = this.front;
		while (runner != null) {
			s += runner.getData() + "\n";
			runner = runner.getNext();
		}
		return s;
	}

}
