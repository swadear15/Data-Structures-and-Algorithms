//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 Workout Builder
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

/**
 * This class models a node for use in a singly-linked list. This node can ONLY
 * contain elements of type Exercise.
 *
 * @author Arsalan Ahmad
 */

public class LinkedExercise {
	// The Exercise contained in this linked node, which cannot be replaced after
	// this node is created
	private Exercise exercise;

	// The next linked node in this list
	private LinkedExercise next;

	/**
	 * Creates a new node containing the provided exercise data with no following
	 * node
	 *
	 * @param data - the exercise to store in this node
	 */
	public LinkedExercise(Exercise data) {
		exercise = data;
		next = null;
	}

	/**
	 * Creates a new node containing the provided exercise data and next node
	 *
	 * @param data - the exercise to store in this node
	 * @param next - the next node in this list, which MAY be null
	 */
	public LinkedExercise(Exercise data, LinkedExercise next) {
		exercise = data;
		this.next = next;
	}

	/**
	 * Accesses the exercise stored in this linked node
	 *
	 * @return the Exercise stored in this linked node
	 */
	public Exercise getExercise() {
		return exercise;
	}

	/**
	 * Accesses the next linked node in the list, which may be null
	 *
	 * @return the reference to the node which follows this one in the list
	 */
	public LinkedExercise getNext() {
		return next;
	}

	/**
	 * Changes the node which follows this one to be the provided value, which may
	 * be null
	 *
	 * @param node - the reference to set as the next node in the list
	 */
	public void setNext(LinkedExercise node) {
		next = node;
	}

	@Override
	/**
	 * Returns a String representation of this linked exercise. This String will be:
	 * exercise.toString() + " -> " // if next field is NOT null exercise.toString()
	 * + " -> END" // if next field is null
	 *
	 * @Overrides toString in class Object
	 * @return a String representation of this linked exercise object
	 */
	public String toString() {
		String x;
		if (next == null) {
			x = exercise.toString() + " -> END";
		} else {
			x = exercise.toString() + " -> ";
		}
		return x;
	}
}
