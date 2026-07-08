//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P06 TA Hiring
// Course: CS 300 Fall 2023
//
// Author: Kush Arora
// Email: ksarora@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Arsalan Ahmad
// Partner Email: ahmad34@wisc.edu
// Partner Lecturer's Name: Mark Mansi
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: N/A
// Online Sources: N/A
//
/////////////////////////////////////////////////////////////////////////////

import java.util.Random;
import java.util.ArrayList;

/**
 * A tester class for the hiring class to make sure all the methods work as intended
 * @author Arsalan Ahmad
 * @author Kush Arora
 */

public class HiringTesting {
	/**
	   * Base tester for greedy hiring that tests for the base case of the method.
	   * @return true if and only if the tester verifies a correct functionality and false if at least one bug is detected
	   */
  public static boolean greedyHiringBaseTest() {
    CandidateList candidates = new CandidateList();
    CandidateList hired = new CandidateList();
    CandidateList actual = Hiring.greedyHiring(candidates, hired, 0);
    CandidateList expected = new CandidateList();
    if (HiringTestingUtilities.compareCandidateLists(expected, actual)) {
      System.out.println("Passed greedyHiringBaseTest");
      return true;
    }
    return false;
  }
  /**
   * Recursive tester for greedy hiring that tests if the method works correctly when it recurses
   * @return true if and only if the tester verifies a correct functionality and false if at least one bug is detected
   */
  public static boolean greedyHiringRecursiveTest() {
    boolean[] candidateOne = new boolean[5];
    candidateOne[0] = true;
    candidateOne[1] = true;
    candidateOne[2] = false;
    candidateOne[3] = false;
    candidateOne[4] = true;
    Candidate candidateOneActual = new Candidate(candidateOne);


    boolean[] candidateTwo = new boolean[5];
    candidateTwo[0] = true;
    candidateTwo[1] = false;
    candidateTwo[2] = true;
    candidateTwo[3] = false;
    candidateTwo[4] = true;
    Candidate candidateTwoActual = new Candidate(candidateTwo);


    boolean[] candidateThree = new boolean[5];
    candidateThree[0] = true;
    candidateThree[1] = false;
    candidateThree[2] = false;
    candidateThree[3] = true;
    candidateThree[4] = false;
    Candidate candidateThreeActual = new Candidate(candidateThree);


    CandidateList candidates = new CandidateList();
    candidates.add(candidateOneActual);
    candidates.add(candidateTwoActual);
    candidates.add(candidateThreeActual);
    CandidateList hired = new CandidateList();

    CandidateList actual = Hiring.greedyHiring(candidates, hired, 2);
    CandidateList expected = new CandidateList();
    expected.add(candidateOneActual);
    expected.add(candidateTwoActual);
    if (HiringTestingUtilities.compareCandidateLists(expected, actual)) {
      System.out.println("Passed greedyHiringBaseTest");
      return true;
    }
    return false; 
  }
  /**
   * Base tester for optimal hiring that tests for the base case of the method.
   * @return true if and only if the tester verifies a correct functionality and false if at least one bug is detected
   */
  public static boolean optimalHiringBaseTest() {
    boolean[] candidateOne = new boolean[5];
    candidateOne[0] = true;
    candidateOne[1] = true;
    candidateOne[2] = false;
    candidateOne[3] = false;
    candidateOne[4] = true;
    Candidate candidateOneActual = new Candidate(candidateOne);

    boolean[] candidateTwo = new boolean[5];
    candidateTwo[0] = true;
    candidateTwo[1] = true;
    candidateTwo[2] = false;
    candidateTwo[3] = false;
    candidateTwo[4] = true;
    Candidate candidateTwoActual = new Candidate(candidateTwo);

    boolean[] candidateThree = new boolean[5];
    candidateThree[0] = false;
    candidateThree[1] = false;
    candidateThree[2] = true;
    candidateThree[3] = false;
    candidateThree[4] = false;
    Candidate candidateThreeActual = new Candidate(candidateThree);

    CandidateList candidates = new CandidateList();
    candidates.add(candidateOneActual);
    candidates.add(candidateTwoActual);
    candidates.add(candidateThreeActual);
    CandidateList hired = new CandidateList();

    CandidateList actual = Hiring.optimalHiring(candidates, hired, 0);
    CandidateList expected = new CandidateList();

    if (HiringTestingUtilities.compareCandidateLists(expected, actual)) {
      System.out.println("Passed optimalHiringBaseTest");
      return true;
    }

    return false; 
  }
  /**
   * Recursive tester for optimal hiring that tests if the method works correctly when it recurses
   * @return true if and only if the tester verifies a correct functionality and false if at least one bug is detected
   */
  public static boolean optimalHiringRecursiveTest() {
    boolean[] candidateOne = new boolean[5];
    candidateOne[0] = true;
    candidateOne[1] = true;
    candidateOne[2] = false;
    candidateOne[3] = true;
    candidateOne[4] = true;
    Candidate candidateOneActual = new Candidate(candidateOne);

    boolean[] candidateTwo = new boolean[5];
    candidateTwo[0] = true;
    candidateTwo[1] = true;
    candidateTwo[2] = false;
    candidateTwo[3] = false;
    candidateTwo[4] = true;
    Candidate candidateTwoActual = new Candidate(candidateTwo);

    boolean[] candidateThree = new boolean[5];
    candidateThree[0] = false;
    candidateThree[1] = false;
    candidateThree[2] = true;
    candidateThree[3] = false;
    candidateThree[4] = false;
    Candidate candidateThreeActual = new Candidate(candidateThree);

    CandidateList candidates = new CandidateList();
    candidates.add(candidateOneActual);
    candidates.add(candidateTwoActual);
    candidates.add(candidateThreeActual);
    CandidateList hired = new CandidateList();

    CandidateList actual = Hiring.optimalHiring(candidates, hired, 2);
    CandidateList expected = new CandidateList();
    expected.add(candidateOneActual);
    expected.add(candidateThreeActual);

    if (HiringTestingUtilities.compareCandidateLists(expected, actual)) {
      System.out.println("Passed optimalHiringRecursiveTest");
      return true;
    }
    return false; 
  }
  /**
   * Fuzz tester, that generates over 100 random samples and tests for all these cases if the method works correctly 
   * @return true if and only if the tester verifies a correct functionality and false if at least one bug is detected
   */
  public static boolean optimalHiringFuzzTest() {
    Random rand = new Random();
    rand.setSeed(0);

    int numHours = rand.nextInt(1, 6);
    int numCandidates = rand.nextInt(1, 11);
    int desiredHires = rand.nextInt(1, numCandidates);

    CandidateList candidates = new CandidateList();
    CandidateList hires = new CandidateList();
    CandidateList actual = new CandidateList();
    ArrayList<CandidateList> expected = new ArrayList<CandidateList>();

    int counter = 0;
    for (int i = 0; i <= 150; i++) {
      candidates = HiringTestingUtilities.generateRandomInput(numHours, numCandidates);
      actual = Hiring.optimalHiring(candidates, hires, desiredHires);
      expected = HiringTestingUtilities.allOptimalSolutions(candidates, desiredHires);
      if (HiringTestingUtilities.compareCandidateLists(expected, actual) == false) {
        counter--;
      }
    }

    if (counter == 0) {
      return true;
    }

    return false; 
  }
  /**
   * Base tester for minCoverage hiring that tests for the base case of the method.
   * @return true if and only if the tester verifies a correct functionality and false if at least one bug is detected
   */
  public static boolean minCoverageHiringBaseTest() {
    boolean[] candidateOne = new boolean[5];
    candidateOne[0] = true;
    candidateOne[1] = true;
    candidateOne[2] = false;
    candidateOne[3] = false;
    candidateOne[4] = true;
    Candidate candidateOneActual = new Candidate(candidateOne, 1);

    boolean[] candidateTwo = new boolean[5];
    candidateTwo[0] = true;
    candidateTwo[1] = false;
    candidateTwo[2] = true;
    candidateTwo[3] = false;
    candidateTwo[4] = true;
    Candidate candidateTwoActual = new Candidate(candidateTwo, 2);


    boolean[] candidateThree = new boolean[5];
    candidateThree[0] = true;
    candidateThree[1] = false;
    candidateThree[2] = false;
    candidateThree[3] = true;
    candidateThree[4] = false;
    Candidate candidateThreeActual = new Candidate(candidateThree, 3);


    CandidateList candidates = new CandidateList();
    candidates.add(candidateOneActual);
    candidates.add(candidateTwoActual);
    candidates.add(candidateThreeActual);
    CandidateList hired = new CandidateList();

    CandidateList actual = Hiring.minCoverageHiring(candidates, hired, 0);
    CandidateList expected = new CandidateList();

    if (HiringTestingUtilities.compareCandidateLists(expected, actual)) {
      System.out.println("Passed minCoverageBaseTest");
      return true;
    }
    return false; 
  }
  /**
   * Recursive tester for minCoverage hiring that tests if the method works correctly when it recurses
   * @return true if and only if the tester verifies a correct functionality and false if at least one bug is detected
   */
  public static boolean minCoverageHiringRecursiveTest() {
    boolean[] candidateOne = new boolean[5];
    candidateOne[0] = true;
    candidateOne[1] = true;
    candidateOne[2] = false;
    candidateOne[3] = false;
    candidateOne[4] = true;
    Candidate candidateOneActual = new Candidate(candidateOne, 1);

    boolean[] candidateTwo = new boolean[5];
    candidateTwo[0] = false;
    candidateTwo[1] = false;
    candidateTwo[2] = true;
    candidateTwo[3] = false;
    candidateTwo[4] = true;
    Candidate candidateTwoActual = new Candidate(candidateTwo, 2);

    boolean[] candidateThree = new boolean[5];
    candidateThree[0] = false;
    candidateThree[1] = false;
    candidateThree[2] = true;
    candidateThree[3] = true;
    candidateThree[4] = false;
    Candidate candidateThreeActual = new Candidate(candidateThree, 3);    

    CandidateList candidates = new CandidateList();
    candidates.add(candidateOneActual);
    candidates.add(candidateTwoActual);
    candidates.add(candidateThreeActual);
    CandidateList hired = new CandidateList();

    CandidateList actual = Hiring.minCoverageHiring(candidates, hired, 4);
    CandidateList expected = new CandidateList();
    expected.add(candidateOneActual);
    expected.add(candidateTwoActual);

    if (HiringTestingUtilities.compareCandidateLists(expected, actual)) {
      System.out.println("Passed minCoverageRecursiveTest");
      return true;
    }
    return false; 
  }
  /**
   * Fuzz thester for minCoverage that generates over 100 samples and makes sure that each sample works correctly by returning the right output
   * @return true if and only if the tester verifies a correct functionality and false if at least one bug is detected
   */
  public static boolean minCoverageHiringFuzzTest() {
    Random rand = new Random();
    rand.setSeed(0);

    int numHours = rand.nextInt(1, 6);
    int numCandidates = rand.nextInt(1, 11);
    int minNumHours = rand.nextInt(1, numHours);

    CandidateList candidates = new CandidateList();
    CandidateList hires = new CandidateList();
    CandidateList actual = new CandidateList();
    ArrayList<CandidateList> expected = new ArrayList<CandidateList>();

    int counter = 0;
    for (int i = 0; i <= 150; i++) {
      candidates =
          HiringTestingUtilities.generateRandomInput(numHours, numCandidates, numCandidates / 2);
      actual = Hiring.minCoverageHiring(candidates, hires, minNumHours);
      expected = HiringTestingUtilities.allMinCoverageSolutions(candidates, minNumHours);
      if (HiringTestingUtilities.compareCandidateLists(expected, actual) == false) {
        counter--;
      }
    }

    if (counter == 0) {
      return true;
    }

    return false; 
  }
}
