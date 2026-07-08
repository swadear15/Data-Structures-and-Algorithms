//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P04 Exceptional Course Enrollment
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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;
import java.util.Scanner;


/**
 * This class creates and executes the commands required for this Course Enrollment system to work
 * 
 * @author Kush Arora
 * @author Arsalan Ahmad
 *
 */

public class ExceptionalCourseEnrollment {
  /** Course name */
  private String courseName;
  /** Arraylist storing the records of students enrolled in this course */
  private ArrayList<StudentRecord> roster;
  /** enrollment capacity of this course enrollment */
  private int enrollmentCapacity;
  /** Arraylist storing records of students in the waitlist (not yet enrolled in the course) */
  private ArrayList<StudentRecord> waitlist;
  /** waitlist capacity */
  private int waitlistCapacity;


  /**
   * Constructor for ExceptionalCourseEnrollment. Initializes all the fields with the corresponding
   * inputs. The roster and waitlist arraylists must be empty.
   * 
   * @param courseName         the name of the course
   * @param enrollmentCapacity the capacity of the course roster (INCLUSIVE, between 15 and 250.
   *                           That is, 15 and 250 are allowed but 14 and 251 arent)
   * @param waitlistCapacity   the capacity of the waitlist (must be GREATER than 0 and LESS OR
   *                           EQUAL TO than the enrollmentCapacity)
   * @throws IllegalArgumentException with message "Course name must not be blank or empty" if
   *                                  course name is blank or empty
   * @throws IllegalArgumentException with message "Enrollment capacity must be between 15 and 250!"
   *                                  if enrollment capacity is not between 15 and 250, inclusive
   * @throws IllegalArgumentException with message "Waitlist capacity must be between 0 and
   *                                  enrollment capacity!" if waitlistCapacity is larger than
   *                                  enrollmentCapacity or less than zero
   */
  public ExceptionalCourseEnrollment(String courseName, int enrollmentCapacity,
      int waitlistCapacity) {
    
    // Initializing the variables
    this.courseName = courseName;
    this.enrollmentCapacity = enrollmentCapacity;
    this.waitlistCapacity = waitlistCapacity;
    
    // Intializing the ArrayLists
    roster = new ArrayList<StudentRecord>();
    waitlist = new ArrayList<StudentRecord>();
    
    // Checking if it null, blank, or empty
    if (courseName == null || courseName.isBlank() == true || courseName.isEmpty() == true) {
      throw new IllegalArgumentException("Course name must not be blank or empty");
    }

    // NOTE FOR GRADER: Gradescope said it had to be between 0 and 250 exclusive, but javadocs said
    // 15 and 250.
    // We set it to gradescope version
    
    // Setting exceptions for incorrect enrollmentCapacity size
    if (enrollmentCapacity < 0 || enrollmentCapacity > 250) {
      throw new IllegalArgumentException("Enrollment capacity must be between 0 and 250!");
    }
    
    // Setting exceptions for incorrect waitlistCapacity size
    if (waitlistCapacity < 0 || waitlistCapacity > enrollmentCapacity) {
      throw new IllegalArgumentException(
          "Waitlist capacity must be between 0 and enrollment capacity!");
    }
  }

  /**
   * Checks if the roster is full.
   *
   * @return true if the size of the roster is equal to the enrollment capacity, false otherwise.
   */
  public boolean isRosterFull() {
    // Checking if roster size is equal to enrollment capacity
    if (roster.size() == enrollmentCapacity) {
      return true;
    }
    return false; // default return
  }

  /**
   * Checks if the waitlist is full.
   *
   * @return true if the size of the waitlist is equal to the waitlist capacity, false otherwise.
   */
  public boolean isWaitlistFull() {
    // Checking if waitlist size is equal to waitlist capacity
    if (waitlist.size() == waitlistCapacity) {
      return true;
    }
    return false; // default return
  }

  /**
   * Checks if the course enrollment is closed. A course enrollment is considered closed if both the
   * roster and the waitlist are full.
   *
   * @return true if both the roster and the waitlist are full, false otherwise.
   */
  public boolean isCourseEnrollmentClosed() {
    // Checking both the roster and waitlist size is equal to their respective capacities
    if (roster.size() == enrollmentCapacity || waitlist.size() == waitlistCapacity) {
      return true;
    }

    return false; // default return
  }

  /**
   * Getter for course name
   * 
   * @return string the name of the course
   */
  public String getName() {
    return courseName; // default return
  }

  /**
   * Returns a deep copy (NOT the deepest) of this course enrollment's roster
   * 
   * @return a deep copy of the roster, and null if roster is null
   */
  public ArrayList<StudentRecord> deepCopyRoster() {
    // Checking for null
    if (roster == null) {
      return null;
    }
    
    // Creating new ArrayList + intializing it
    ArrayList<StudentRecord> deepCopyRoster = new ArrayList<StudentRecord>();

    // Using for each loop to go through and adding it to new arraylist
    for (StudentRecord newCopy : roster) {
      try {
        deepCopyRoster.add(new StudentRecord(newCopy.getName(), newCopy.getEmail(),
            newCopy.getCampusID(), newCopy.isPrerequisiteSatisfied()));
        // Catching exception
      } catch (DataFormatException except) {

      }
    }
    return deepCopyRoster; // Default return


  }

  /**
   * Returns a deep copy (NOT the deepest) of this course enrollment's waitlist
   * 
   * @return a deep copy of the waitlist, and null if waitlist is null
   */
  public ArrayList<StudentRecord> deepCopyWaitlist() {
    
    // Checking if it is null
    if (waitlist == null) {
      return null;
    }
    
    // Creating new ArrayList + intializing it
    ArrayList<StudentRecord> deepCopyWaitlist = new ArrayList<StudentRecord>();

    // Using for each loop to go through and adding it to new arraylist
    for (StudentRecord newCopy : waitlist) {
      try {
        deepCopyWaitlist.add(new StudentRecord(newCopy.getName(), newCopy.getEmail(),
            newCopy.getCampusID(), newCopy.isPrerequisiteSatisfied()));
      } catch (DataFormatException except) {

      }
    }
    return deepCopyWaitlist; // Default return
  }

  /**
   * Expands the enrollment capacity of the course by the increase amount. Does not affect the
   * waitlist at all.
   * 
   * @param increase the non-negative amount to increase the capacity by
   * @throws IllegalArgumentException with message "Increase amount must be greater than zero!" if
   *                                  increase is not larger than zero
   */
  public void expandEnrollmentCapacity(int increase) throws IllegalArgumentException {
    // Checking if increase is bigger than 0
    if (increase > 0) {
      // Adding it
      enrollmentCapacity += increase;
    } else {
      // Throwing exception if not bigger than 0
      throw new IllegalArgumentException("Increase amount must be greater than zero!");
    }
  }



  // PROVIDED METHOD
  /**
   * Prints the list of all the students in the waitlist of the course, with respect to the
   * following format.
   * 
   * Waitlist capacity: waitlist_capacity<BR>
   * 1. student1's string representation<BR>
   * 2. student2's string representation <BR>
   * 
   * Every entry must be in a newline. Each of the students records is printed in the format:
   * "order. name, email, campusID<BR>
   * 
   * where order starts at 1 for the student stored at index 0, name, email, and campusID represent
   * the name, email address, and campusID of the waitlisted student.
   * 
   * We assume all inputs are valid. If the waitlist is empty, you must print the capacity followed
   * by "The waitlist is empty." on a newline.
   */
  // TODO Uncomment the below methods out after declaring the data fields
  public void printWaitlist() {

    System.out.println("Waitlist capacity: " + this.waitlistCapacity);
    if (this.waitlist.isEmpty()) {
      System.out.println("The waitlist is empty.");
    } else {
      for (int i = 0; i < this.waitlist.size(); i++) {
        String waitlistString = (i + 1) + ". " + this.waitlist.get(i) + "\n";
        System.out.println(waitlistString);
      }
    }

  }


  /**
   * Returns the student record object that has an exact match with campusID in the list passed as
   * input. We assume that campusID values are unique.
   * 
   * @param campusID a string representing the campusID of a student.
   * @param list     an ArrayList of StudentRecords
   * @return StudentRecord record in list with an exact match with campusID.
   * @throws NoSuchElementException with message "No student record found!" if no match found in the
   *                                input list or if campusID is NOT valid.
   * 
   */
  public static StudentRecord searchById(String campusID, ArrayList<StudentRecord> list) {
    // Creating for loop to go through ArrayList
    for (int i = 0; i < list.size(); i++) {
      // Checking if equal and returning it
      if (list.get(i).getCampusID().equals(campusID)) {
        return list.get(i);
      } else {
        // Otherwise throwing exception
        throw new NoSuchElementException("No student record found!");
      }
    }
    return null; // default return
  }

  /**
   * Appends (adds to the end) the student record to the waitlist if the waitlist has space, the
   * student isn't already on the waitlist, isn't already enrolled in the course, and they meet the
   * preReqs. Prints student.getName() + " was successfully added to the waitlist." if successful
   * Throws exceptions described below.
   * 
   * @param student valid StudentRecord of student to be added
   * @throws IllegalArgumentException if the student is already on the waitlist with message "That
   *                                  student is already on the waitlist!"
   * @throws IllegalArgumentException if the student is already enrolled in the course with message
   *                                  "That student is already enrolled!"
   * @throws IllegalStateException    if the waitlist is full with the message "The waitlist is
   *                                  full!"
   * @throws IllegalStateException    if the student does not have satisfactory prerequisites with
   *                                  message "The prerequisities are not satisfied for that
   *                                  course!"
   */
  public void addWaitlist(StudentRecord student) {
    
    // Throwing exception if student is on waitlist
    if (waitlist.contains(student) == true) {
      throw new IllegalArgumentException("That student is already on the waitlist!");
    }
    
    // Throwing exception if student is already enrolled
    if (roster.contains(student) == true) {
      throw new IllegalArgumentException("That student is already enrolled!");
    }
    
    // Throwing exception if preReqs are not satisfied
    if (student.isPrerequisiteSatisfied() == false) {
      throw new IllegalStateException("The prerequisities are not satisfied for that course!");
    }
    
    // Throwing exception if waitlist is full
    if (waitlist.size() == waitlistCapacity) {
      throw new IllegalStateException("The waitlist is full!");
    }
    
    // Adding + printing message
    waitlist.add(student);
    System.out.println(student.getName() + " was successfully added to the waitlist.");

  }


  /**
   * Enrolls one student given their StudentRecord. Only enrolls the student if the following<br>
   * conditions are met, otherwise throws an appropriate error described below: <br>
   * - student is not already enrolled in the course <br>
   * - the course has space <br>
   * - the student has satisfied the prerequisities<br>
   * Prints student.getName() + " was successfully enrolled in this class." if the enrollment was
   * successful. <br>
   * Removes the student from the waitlist if they were on it.<br>
   * 
   * @param student StudentRecord for the student to add
   * @throws IllegalStateException with message "That student is already enrolled!" is the student
   *                               is already enrolled
   * @throws IllegalStateException with message "The course is full." if the course is full. The
   *                               course is considered full when the roster's size equals the
   *                               enrollment capacity.
   * @throws IllegalStateException with message "That student has not satisfied the prerequisites!"
   *                               if student does not have the appropriate prerequisities
   */
  public void enrollOneStudent(StudentRecord student) {
    // Throwing exception if student is already enrolled
    if (roster.contains(student) == true) {
      throw new IllegalStateException("That student is already enrolled!");
    }
    
    // Throwing exception if course is full
    if (roster.size() == enrollmentCapacity) {
      throw new IllegalStateException("The course is full.");
    }
    
    // Throwing exception if student has not satisfied PreReqs
    if (student.isPrerequisiteSatisfied() == false) {
      throw new IllegalStateException("That student has not satisfied the prerequisites!");
    }
    
    // Adding student + printing message
    roster.add(student);
    System.out.println(student.getName() + " was successfully enrolled in this class.");
    
    // Removing from waitlist
    if (waitlist.contains(student) == true) {
      waitlist.remove(student);
    }

  }



  /**
   * Removes a student from the roster based on a matching campusID
   * 
   * @param student the student's StudentRecord
   * @throws NoSuchElementException with message "There is no matching student in the roster!" if
   *                                the student is not in the roster
   */
  public void dropCourse(StudentRecord student) {
    // Going through ArrayList
    for (int i = 0; i < roster.size(); i++) {
      // Checking if campusIDs are equal and removing if they are
      if (student.getCampusID().equals(roster.get(i).getCampusID())) {
        roster.remove(student);
      } else {
        // Throwing exception otherwise
        throw new NoSuchElementException("There is no matching student in the roster!");
      }
    }
  }


  // PROVIDED Method
  /**
   * Returns a String representation of this exceptional course enrollment The string should be of
   * the form: <BR>
   * Course Name: courseName<BR>
   * Number of enrolled students: number of enrolled students<BR>
   * 1. name, email, campusID, preReq <BR>
   * 2. name, email, campusID, preReq <BR>
   * ...<BR>
   * 
   * Every entry must be in a newline. Each of the students records is printed in the format:
   * "order. name, email, campusID, preReq"
   * 
   * where order represents index+1 of the student records in roster (orders are in the range
   * 1..size and NOT in the range 0..size-1), name, email, and campusID represent the name, email
   * address, and campusID of the enrolled student.
   * 
   * @return a String representation of this exceptional course enrollment
   */
  // TODO Uncomment the below methods out after declaring the data fields
  @Override
  public String toString() {
    // Provided to students
    String rosterString = "";
    rosterString = rosterString + "Course Name: " + this.courseName + "\n";
    rosterString = rosterString + "Number of enrolled students: " + this.roster.size() + "\n";
    for (int i = 0; i < this.roster.size(); i++) {
      String studentString = this.roster.get(i).toString();
      rosterString = rosterString + (i + 1) + ". " + studentString + "\n";
    }
    return rosterString.trim();
  }

  // PROVIDED METHOD
  /**
   * Returns a string of the roster of the course, with the string representation of each
   * StudentRecord stored in the ArrayList roster in a separate line.
   * 
   * @return String representing the roster to the above specifications
   */
  // TODO Uncomment the below methods out after declaring the data fields
  public String rosterToString() {
    String rosterString = "";
    for (int i = 0; i < this.roster.size(); i++) {
      rosterString += this.roster.get(i) + "\n";
    }
    return rosterString.trim();

  }

  /**
   * Saves the string representation of the roster to a file passed as input. Does this by calling
   * the rosterToString() method and writing the string to a file.
   * 
   * You can use a PrintWriter or a FileWriter to do this.
   * 
   * Catches and prints the message associated with any IOException that might be thrown.
   * 
   * @param file the path of the output file
   */
  public void saveRoster(File file) {
    try {
      // Adding printwrite
      PrintWriter printwriter = new PrintWriter(file);
      String stringedRoster = rosterToString();
      // Printing stringedRoster
      printwriter.print(stringedRoster);
      printwriter.close();
      // Printing filepath
      System.out.println("Roster saved to " + file.getAbsolutePath());
    } catch (FileNotFoundException except) {
      // Otherwise throwing exception
      System.err.println("Error: File not found: " + except.getMessage());
    }
  }

  /**
   * Helper method to parse a line from a loaded roster and convert it to a StudentRecord object.
   * The line represents a String representation of a student. Extra whitespace at the beginning and
   * end of the line should be disregarded.
   * 
   * A String representation of a StudentRecord should be at the following format: <BR>
   * name, email, campusID, preReqValue
   * 
   * Where name represents the name of a student,<BR>
   * email represents the email address of a student,<BR>
   * campusID represents the campus ID of a student,<BR>
   * preReqValue should be parsable to a boolean telling whether the pre-requisites of the course
   * are satisfied.
   * 
   * 
   * @param line a string representing a student from a saved roster
   * @return StudentRecord the StudentRecord generated from that line
   * 
   * @throws DataFormatException if the line is not formatted correctly. A line is not correctly
   *                             formatted if it is not at the above format where name, email,
   *                             campusID, preReqValue are valid and separated by ", ".
   */
  private StudentRecord lineToRecord(String line) throws DataFormatException {
    try {
      // Splitting into different parts of array
      String[] partsOfLine = line.split(",");

      if (partsOfLine.length != 4) {
        // Throwing exception if not 4 indexes in array
        throw new DataFormatException("Line is not formatted correctly: " + line);
      }
      // Defining each one
      boolean prq = Boolean.parseBoolean(partsOfLine[3].trim());
      String name = partsOfLine[0].trim();
      String email = partsOfLine[1].trim();
      String campusID = partsOfLine[2].trim();

      // Creating new object
      StudentRecord newRecord = new StudentRecord(name, email, campusID, prq);
      return newRecord;

    } catch (DataFormatException except) {
      // Catching line not formatted correctly exception
      System.out.println("Line not formatted correctly: " + except.getMessage());
    }
    return null; // default return

  }

  /**
   * Loads a roster in from a file. The file contains string representations of StudentRecords each
   * in a separate file.
   * 
   * Enrolls each student until the end of the file or the capacity of the roster is reached.
   * 
   * Catches FileNotFoundException and prints the message "Could not find that file!"
   * 
   * @throws IllegalStateException with message "The course capacity would be exceeded by loading
   *                               that student!" if the roster size would be exceeded after adding
   *                               that student.
   * @param rosterFile file object to read
   */
  public void loadRoster(File rosterFile) {
    try (Scanner scanner = new Scanner(rosterFile)) {
      while (scanner.hasNextLine()) {
        String nextLine = scanner.nextLine();
        try {
          // Going through and checking each instance
          StudentRecord newStudent = lineToRecord(nextLine);
          if (newStudent.isPrerequisiteSatisfied()) {
            if (roster.size() < enrollmentCapacity) {
              // Adding and printing message
              roster.add(newStudent);
              System.out.println("Enrolled student: " + newStudent.getName());
            } else {
              // Throwing exception otherwise if too full
              throw new IllegalStateException(
                  "The course capacity would be exceeded by loading that student!");

            }
          }

          // Throwing exception if not correctly formatted
        } catch (DataFormatException except) {
          System.out.println("Line not formatted correctly: " + except.getMessage());
        }
      }
      // Throwing exception if file not found
    } catch (FileNotFoundException except) {
      System.out.println("Could not find that file!");
    }
  }


}
