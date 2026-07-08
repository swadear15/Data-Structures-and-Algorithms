
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
import java.util.NoSuchElementException;

/**
 * This class uses a singly-linked list data structure to maintain a list of
 * exercises organized according to their WorkoutType.
 *
 * @author Arsalan Ahmad
 */
public class WorkoutBuilder implements ListADT<Exercise> {

	// The number of exercises with WorkoutType equal to COOLDOWN in this
	// WorkoutBuilder list
	private int cooldownCount;

	// The node containing the element at index 0 of this singly-linked list
	private LinkedExercise head;

	// The number of exercises with WorkoutType equal to PRIMARY in this
	// WorkoutBuilder list
	private int primaryCount;

	// The total number of exercises contained in this WorkoutBuilder list
	private int size;

	// The node containing the last element of this singly-linked list
	private LinkedExercise tail;

	// The number of exercises with WorkoutType equal to WARMUP in this
	// WorkoutBuilder list
	private int warmupCount;

	/**
	 * Default constructor that initializes all instance variables to their initial
	 * state
	 *
	 */
	public WorkoutBuilder() {
		cooldownCount = 0;
		head = null;
		primaryCount = 0;
		size = 0;
		tail = null;
		warmupCount = 0;
	}

	/**
	 * Accesses the total number of elements in this WorkoutBuilder list
	 * 
	 * @return int - the size of this list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Accesses the number of warm-up exercises stored in this WorkoutBuilder list
	 * 
	 * @return int - the count of exercises with WorkoutType equal to WARMUP
	 */
	public int getWarmupCount() {
		return warmupCount;
	}

	/**
	 * Accesses the number of primary exercises stored in this WorkoutBuilder list
	 * 
	 * @return int - the count of exercises with WorkoutType equal to PRIMARY
	 */
	public int getPrimaryCount() {
		return primaryCount;
	}

	/**
	 * Accesses the number of cool-down exercises stored in this WorkoutBuilder list
	 * 
	 * @return int - the count of exercises with WorkoutType equal to COOLDOWN
	 */
	public int getCooldownCount() {
		return cooldownCount;
	}

	/**
	 * Checks whether this WorkoutBuilder list is empty
	 * 
	 * @return true if this list contains no elements and neither its head nor tail
	 *         refer to LinkedExercise objects
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0) && (tail == null) && (head == null);
	}

	/**
	 * Removes all elements from this list. The list will be empty after this call
	 * returns.
	 */
	public void clear() {
		cooldownCount = 0;
		head = null;
		primaryCount = 0;
		size = 0;
		tail = null;
		warmupCount = 0;
	}

	/**
	 * Finds the index of a given exercise in this WorkoutBuilder list, if it is
	 * present. Note that Exercise contains an overridden equals() method for use
	 * here.
	 * 
	 * @param findObject - the exercise to search for in this list
	 * @return the index of this object in the list if it is present; -1 if it is
	 *         not
	 */
	@Override
	public int indexOf(Exercise findObject) {
		LinkedExercise current = head;
		int index = 0;
		while (current != null) {
			if (head.getExercise().equals(findObject)) {
				return index;
			}
			index++;
			current = current.getNext();
		}
		return -1;
	}

	/**
	 * Returns the exercise stored at the given index of this list without removing
	 * it.
	 * 
	 * @param index - position within this list
	 * @return the exercise stored at the given index of this list
	 * @throws IndexOutOfBoundsException - with a descriptive error message if the
	 *                                   index is not valid for the current size of
	 *                                   this list
	 */
	@Override
	public Exercise get(int index) {
		LinkedExercise current = head;
		// Check for out of bounds
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Bad Index");
		}
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getExercise();
	}

	/**
	 * Adds the provided Exercise to the appropriate position in the list for its
	 * WorkoutType, and increments the corresponding counter fields: WARMUP: adds to
	 * the FRONT (head) of the list PRIMARY: adds after all warm-ups and before any
	 * cool-downs; if there are any existing primary exercises, adds before all of
	 * those as well COOLDOWN: adds to the END (tail) of the lis
	 * 
	 * @param newObject - the exercise to add to the WorkoutBuilder list
	 */
	@Override
	public void add(Exercise newObject) {
		LinkedExercise newObj = new LinkedExercise(newObject);

		// This the Null Edge Case when there is nothin in the list, head and tail are
		// set to the new object
		if (head == null) {
			head = newObj;
			tail = newObj;
			if (newObject.getType() == WorkoutType.WARMUP) {
				warmupCount++;
			} else if (newObject.getType() == WorkoutType.PRIMARY) {
				primaryCount++;
			} else if (newObject.getType() == WorkoutType.COOLDOWN) {
				cooldownCount++;
			}
			size++;
			
		} else {
			// The second case is when we add the type Warmup to the beginning of the list
			if (newObject.getType() == WorkoutType.WARMUP) {
				newObj.setNext(head);
				head = newObj;

				// The third case is when the workout is a primary so we make sure to add it
				// after the last warmup
			} else if (newObject.getType() == WorkoutType.PRIMARY) {
				LinkedExercise current = head;
				while (current.getNext() != null && current.getNext().getExercise().getType() == WorkoutType.WARMUP) {
					current = current.getNext();
				}
				newObj.setNext(current.getNext());
				current.setNext(newObj);
				if (primaryCount == 0) {
					if (cooldownCount == 0) {
						tail = newObj;
					}
				}
				// The final case is when cooldown is the workout type, here we just add it to
				// the end of the list
			} else if (newObject.getType() == WorkoutType.COOLDOWN) {
				tail.setNext(newObj);
				tail = newObj;
			}
			
			
			// Adds the counts based on the type
			if (newObject.getType() == WorkoutType.WARMUP) {
				warmupCount++;
			} else if (newObject.getType() == WorkoutType.PRIMARY) {
				primaryCount++;
			} else if (newObject.getType() == WorkoutType.COOLDOWN) {
				cooldownCount++;
			}
			size++;

		}

	}

//	private void addWarmup(Exercise newObject) {
//		LinkedExercise newObj = new LinkedExercise(newObject, head);
//		head = newObj;
//		if (tail == null) {
//			tail = newObj;
//		}
//		warmupCount++;
//		size++;
//	}
//	
//	private void addCooldown(Exercise newObject) {
//		LinkedExercise newObj = new LinkedExercise(newObject);
//		LinkedExercise prevTail = new LinkedExercise(tail.getExercise());
//		if (head != null) {
//			LinkedExercise current = head;
//			while (current.getNext() != tail) {
//				current = current.getNext();
//			}
//			current.setNext(prevTail);
//			tail = newObj;
//			prevTail.setNext(tail);
//		}
//		else {
//			head = newObj;
//			tail = newObj;
//		}
//		cooldownCount++;
//        size++;
//	}
//	
//	private void addPrimary(Exercise newObject) {
//		LinkedExercise newObj = new LinkedExercise(newObject);
//		if (head != null) {
//			LinkedExercise current = head;
//			while (current.getNext() != null && current.getNext().getExercise().getType() == WorkoutType.WARMUP) {
//                current = current.getNext();
//            }
//			newObj.setNext(current.getNext());
//			current.setNext(newObj);
//			if (tail.getNext() == null) {
//				tail = newObj;
//			}
//		}
//		else {
//			head = newObj;
//			tail = newObj;
//		}
//		primaryCount++;
//        size++;
//		
//	}

	/**
	 * Removes an exercise of the provided type from the list, if one exists, and
	 * decrements the corresponding counter fields: WARMUP: removes the FIRST (head)
	 * element from the list PRIMARY: removes the FIRST exercise of type PRIMARY
	 * from the list COOLDOWN: removes the LAST (tail) element from the list
	 * 
	 * @param type - the type of exercise to remove from the list
	 * @return the exercise object that has been removed from the list
	 * @throws NoSuchElementException - if there are no exercises in the list with
	 *                                the given WorkoutType
	 */
	public Exercise removeExercise(int exerciseID) throws NoSuchElementException {
		// Null case if there is nothing to remove
		if (head == null) {
			throw new NoSuchElementException("No Elements in List");
		}
		
		// First case where the element to remove is the head
		LinkedExercise current = head;
		if (current.getExercise().getExerciseID() == exerciseID) {
			Exercise temp1 = current.getExercise();
			head = current.getNext();
			if (head == null) {
				tail = null;
			}
			if (temp1.getType() == WorkoutType.WARMUP) {
				warmupCount--;
			} else if (temp1.getType() == WorkoutType.PRIMARY) {
				primaryCount--;
			} else if (temp1.getType() == WorkoutType.COOLDOWN) {
				cooldownCount--;
			}

			size--;
			return temp1;
		}
		
		// Second case where the element to remove is within the list
		while (current.getNext() != null && current.getNext().getExercise().getExerciseID() != exerciseID) {
			current = current.getNext();
		}
		if (current.getNext() != null) {
			Exercise temp2 = current.getNext().getExercise();
			current.setNext(current.getNext().getNext());
			if (current.getNext() == null) {
				tail = current;
			}
			if (temp2.getType() == WorkoutType.WARMUP) {
				warmupCount--;
			} else if (temp2.getType() == WorkoutType.PRIMARY) {
				primaryCount--;
			} else if (temp2.getType() == WorkoutType.COOLDOWN) {
				cooldownCount--;
			}

			size--;
			return temp2;
		}
		// Throws exception if the ID is not found in the list 
		throw new NoSuchElementException("This ID does not exist");
	}

	/**
	 * Removes the exercise with the provided ID number from the list, if it is
	 * present, and adjusts any corresponding counter fields as necessary. This
	 * method uses a linear search algorithm.
	 * 
	 * @param exerciseID - the unique identifier of the exercise to be removed
	 * @return the exercise object that has been removed from the list
	 * @throws NoSuchElementException - if there are no exercises in the list with
	 *                                the given WorkoutType
	 */
	public Exercise removeExercise(WorkoutType type) throws NoSuchElementException {
		// Null Case where there are no eleements to remove
		if (head == null) {
			throw new NoSuchElementException("No Elements in List");
		}
		
		// First case where the workout type to remove is the head
		LinkedExercise current = head;
		if (current.getExercise().getType() == type) {
			Exercise temp1 = current.getExercise();
			head = current.getNext();
			if (temp1.getType() == WorkoutType.WARMUP) {
				warmupCount--;
			} else if (temp1.getType() == WorkoutType.PRIMARY) {
				primaryCount--;
			} else if (temp1.getType() == WorkoutType.COOLDOWN) {
				cooldownCount--;
			}

			size--;
			if (head == null) {
				tail = null;
			}
			return temp1;
		}
		
		// Second case that loops through the linked list to check for type and removes it from the list
		while (current.getNext() != null && current.getNext().getExercise().getType() != type) {
			current = current.getNext();
		}
		if (current.getNext() != null) {
			Exercise temp2 = current.getNext().getExercise();
			current.setNext(current.getNext().getNext());
			if (current.getNext() == null) {
				tail = current;
			}
			if (temp2.getType() == WorkoutType.WARMUP) {
				warmupCount--;
			} else if (temp2.getType() == WorkoutType.PRIMARY) {
				primaryCount--;
			} else if (temp2.getType() == WorkoutType.COOLDOWN) {
				cooldownCount--;
			}

			size--;
			return temp2;
		}
		// Another case where the exercise type to remove doesnt exist
		throw new NoSuchElementException("No exercises that match the type to remove");
	}

	/**
	 * Returns a String representation of the contents of this list, as the
	 * concatenated String representations of all LinkedExercise nodes in this list.
	 *
	 * @Overrides toString in class Object
	 * @return return a String representation of the content of this list. If this
	 *         list is empty, an empty String ("") will be returned.
	 */
	@Override
	public String toString() {
		String x = "";
		LinkedExercise current = head;
		while (current != null) {
			x += current.toString();
			current = current.getNext();
		}
		return x;

	}

}
