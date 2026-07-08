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
 * Array-based min-heap implementation of a priority boarding queue storing
 * elements of type Passenger. This class guarantees the min-heap invariant, so
 * that:
 * 
 * The Passenger at the root should be the smallest Passenger in the queue,
 * which corresponds to the passenger having the highest priority.
 * 
 * Children always are greater than their parent.
 * 
 * The Passenger at the root of this min-heap priority queue must be dequeued
 * (board the airplane) next, meaning removed and returned by the dequeue
 * method.
 * 
 * The BoardingQueue.peekBest() must return without removing the Passenger at
 * the root of this min-heap queue, if the queue is not empty.
 * 
 * We rely on the Passenger.compareTo() method to compare Passengers.
 * 
 * The root of a non-empty queue is always at index 0 of this array-heap.
 */
public class BoardingQueue implements PriorityQueueADT<Passenger> { // TODO Define this class to implement the
																	// PriorityQueueADT interface
	// This BoardingQueue stores elements of type Passenger, ONLY.

	// oversize array
	private Passenger[] heap;// array min-heap of Passengers representing this priority queue
	private int size; // size of this priority queue
	// The heap is an oversize array, meaning that the following should be ensured:
	// heap[i] == null for all valid indexes and size == 0 when the heap is EMPTY
	// If the heap is NOT empty:
	// heap[i] != null when i >= 0 && i < size
	// heap[i] == null when i >= size && i < heap.length

	/**
	 * Constructs an empty BoardingQueue with the given capacity
	 * 
	 * @param capacity Capacity of this boarding queue
	 * @throws IllegalArgumentException with a descriptive error message if the
	 *                                  capacity is not a positive integer (greater
	 *                                  than zero)
	 */
	public BoardingQueue(int capacity) {
		// TODO implement this constructor of this class according to the details
		// provided in its
		// javadocs
		if (capacity < 1) {
			throw new IllegalArgumentException("capacity must be greater than 1");
		}
		heap = new Passenger[capacity];
		size = 0;

	}

	/**
	 * Returns the capacity of this BoardingQueue
	 * 
	 * @return the capacity of this BoardingQueue
	 */
	public int capacity() {
		// TODO implement this method

		return heap.length; // default return statement
	}

	/**
	 * Removes all the elements from this Boarding Queue
	 */
	public void clear() {
		// TODO implement this method
		size = 0;
		heap = new Passenger[this.capacity()];
	}

	/**
	 * Checks whether this BoardingQueue is full
	 * 
	 * @return true if this boarding queue is full
	 */
	public boolean isFull() {
		// TODO implement this method
		if (size >= this.capacity()) {
			return true;
		}
		return false; // default return statement
	}

	// toArray() method PROVIDED
	/**
	 * Returns a deep copy of the array-heap of this BoardingQueue. This method can
	 * be used for testing purposes.
	 * 
	 * This method can be used for testing purposes.
	 * 
	 * @return a deep copy of the array-heap storing the Passengers in this queue
	 * @throws a NullPointerException if the heap array of this BoardingQueue is
	 *           null
	 */
	public Passenger[] toArray() {
		return Arrays.copyOf(this.heap, this.heap.length);
	}

	/**
	 * Returns a deep copy of this BoardingQueue containing all of its elements in
	 * the same order. This method does not return the deepest copy, meaning that
	 * you do not need to duplicate Passengers. Only the instance of the heap
	 * (including the array and its size) will be duplicated.
	 * 
	 * @return a deep copy of this BoardingQueue. The returned new boarding queue
	 *         (the deep copy) has the same length and size as this queue.
	 */
	public BoardingQueue deepCopy() {
		// TODO implement this method according to the details provided in its javadocs
		BoardingQueue copy = new BoardingQueue(this.capacity());
		copy.heap = Arrays.copyOf(this.heap, this.heap.length);
		copy.size = this.size;
		return copy; // default return statement
	}

	// toString() method PROVIDED, but commented out
	// TODO uncomment the implementation details of the below
	// BoardingQueue.toString() method after
	// you implement the isEmpty() and dequeue() methods
	/**
	 * Returns a String representing this boarding queue, where each Passenger in
	 * the queue is listed on a separate line, in order from smallest to greatest,
	 * meaning in their boarding order.
	 * 
	 * @return a String representing this boarding queue, and an empty String "" if
	 *         this queue is empty.
	 */
	@Override
	public String toString() {
		String s = "";
		BoardingQueue deepCopy = this.deepCopy();
		while (!deepCopy.isEmpty()) {
			s += deepCopy.dequeue().toString() + "\n";
		}
		return s.trim();

	}

	/**
	 * Restores the min-heap of the priority queue by percolating its root down the
	 * tree. If the element at the given index does not violate the min-heap
	 * ordering property (it is smaller than its smallest child), then this method
	 * does not modify the heap. Otherwise, if there is a heap violation, then swap
	 * the element with the correct child and continue percolating the element down
	 * the heap.
	 * 
	 * We assume that index is in bounds (greater or equal to zero and less than
	 * size).
	 * 
	 * @param index index of the element in the heap to percolate downwards
	 */
	protected void percolateDown(int index) {
		// TODO implement this method with respect to the details provided in its
		// javadocs style method
		// header
		// We recommend implementing a recursive version of this method to get more
		// practice on
		// recursive thinking
		int left = 2 * index + 1;
		boolean isLeft = false;
		int right = 2 * index + 2;
		int perc = index;
		if (left < size) {
			if (heap[left] != null) {
				if (heap[left].compareTo(heap[perc]) < 0) {
					perc = left;
					isLeft = true;
				}
			}
		}
		if (right < size) {
			if (heap[right] != null) {
				if (heap[right].compareTo(heap[perc]) < 0) {
					if (isLeft) {
						if (heap[right].compareTo(heap[left]) < 0){
							perc = right;
						}
					}
					else {
						perc = right;
					}
				}
			}
		}
		if (perc != index) {
			swap(index, perc);
			percolateDown(perc);
		}
	}

	// TODO
	/**
	 * Restores the min-heap invariant of this priority queue by percolating a leaf
	 * up the heap. If the element at the given index does not violate the min-heap
	 * invariant (it is greater than its parent), then this method does not modify
	 * the heap. Otherwise, if there is a heap violation, swap the element with its
	 * parent and continue percolating the element up the heap. We assume that index
	 * is in bounds (greater or equal to zero and less than size).
	 * 
	 * @param index index of the element in the heap to percolate upwards
	 */
	protected void percolateUp(int index) {
		// TODO implement this method with respect to the details provided in its
		// javadocs style method
		// header
		// We recommend implementing a recursive version of this method to get more
		// practice on
		// recursive thinking
		if (index != 0) {
			int parent = (index - 1) / 2;
			if (heap[index].compareTo(heap[parent]) < 0) {
				swap(index, parent);
				percolateUp(parent);
			}
		}

	}

	// TODO implement the abstract methods defined in the PriorityQueueADT with
	// respect to the details
	// in their javadocs.
	// Be sure that the enqueue() method takes an input of type Passenger
	// The return type of peekBest() and dequeue() methods MUST be Passenger
	// The details of what every method is supposed to do is provided in the details
	// of the javadocs
	// style method headers of the abstract methods defined in the PriorityQueueADT
	// generic interface.
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}

	/**
	 * size of the heap
	 * 
	 * @return int - size of heap
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * Peeks the next best passenger in the heap
	 * 
	 * @return the next best passenger in the heap
	 */
	@Override
	public Passenger peekBest() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new NoSuchElementException("Nothing to peek");
		}
		return heap[0];
	}

	/**
	 * Enqueues a passenger from the heap and returns whether it was done
	 * succesfully
	 * 
	 * @param the passenger to be enqueued
	 * @return true if passenger e was enqueued succesfully, false otherwise
	 * @throws NoSuchElementException if parameter is null
	 * @throws IndexOutOfBoundsExceptions if queue is full
	 */
	@Override
	public boolean enqueue(Passenger e) {
		// TODO Auto-generated method stub
		if (e == null) {
			throw new NullPointerException("Passenger null");
		}
		
		if (!isFull()) {
			heap[size] = e;
			percolateUp(size);
			size++;
			return true;
		}
		return false;

	}

	/**
	 * Dequues a passenger from the heap and returns it
	 * 
	 * @return the passenger removed from the heap
	 * @throws NoSuchElementException if the boarding queue is empty
	 */
	@Override
	public Passenger dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new NoSuchElementException("Empty Boarding Queue!");
		}
		Passenger returnVal = heap[0];
		heap[0] = heap[size - 1];
		heap[size - 1] = null;
		percolateDown(0);
		size--;
		return returnVal;
		
	}

	/**
	 * Helper method that swaps two elements in the heap
	 */
	private void swap(int i, int j) {
		Passenger t = heap[i];
		heap[i] = heap[j];
		heap[j] = t;
	}

}
