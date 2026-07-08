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

import java.util.List;
/**
 * A simple program for solving various hiring problems.
 * Each of the three methods in the Hiring class will solve a variant of the hiring problem. 
 * In this problem, we imagine that you have a list of candidates TAs to hire, the times that they are available throughout
 * the day, and their pay rates.
 * @author Arsalan Ahmad
 * @author Kush Arora
 */
public class Hiring {
  /**
   * Given a set of `candidates` that we can hire, a list of candidates we've already hired, and a
   * maximum number of tas to hire, return the set of hires made using a greedy strategy that always
   * chooses the candidate that increases hours covered the most. In this function, we will ignore
   * pay rates.
   * 
   * @param candidates - the set of available candidates to hire from (excluding those already
   *                   hired)
   * @param hired      - the list of those currently hired
   * @param hiresLeft  - the maximum number of candidates to hire
   * @return a list of hired candidates
   */
  public static CandidateList greedyHiring(CandidateList candidates, CandidateList hired,
      int hiresLeft) {
    if (hiresLeft == 0) {
      return hired;
    }

    Candidate best = null;
    int max = -1;

    for (Candidate candidate : candidates) {
      CandidateList hired2 = new CandidateList(hired);
      hired2.add(candidate);

      int tempHour = hired2.numCoveredHours() - hired.numCoveredHours();

      if (tempHour > max) {
        max = tempHour;
        best = candidate;
      }
    }

    if (best != null) {
      hired.add(best);
      CandidateList remainingCandidates = new CandidateList(candidates);
      remainingCandidates.remove(best);

      return greedyHiring(remainingCandidates, hired, hiresLeft - 1);
    } else {
      return null;
    }
  }

  /**
   * Given a set of `candidates` that we can hire, a list of candidates we've already hired, and a
   * maximum number of tas to hire, return the set of hires that maximizes number of scheduled
   * hours. In this function, we will ignore pay rates.
   * 
   * @param candidates - the set of available candidates to hire from (excluding those already
   *                   hired)
   * @param hired      - the list of those currently hired
   * @param hiresLeft  - the maximum number of candidates to hire
   * @return a list of hired candidates
   */
  public static CandidateList optimalHiring(CandidateList candidates, CandidateList hired,
      int hiresLeft) {

    // these are the two base cases to either return the hired list or null
    if (hiresLeft == 0 && hired.size() == 0) {
      return null;
    } else if (hiresLeft == 0) {
      return hired;
    }

    CandidateList best = null;
    int max = 0;

    // loops through the candidates and creates a new potential hiring list for differenct
    // combinations and finds the best one
    for (int i = 0; i < candidates.size(); i++) {
      Candidate potentialHire = candidates.get(i);
      CandidateList hired2 = new CandidateList(hired);
      CandidateList candidates2 = new CandidateList(candidates);

      hired2.add(potentialHire);
      candidates2.remove(potentialHire);

      CandidateList potentialHireList = optimalHiring(candidates2, hired2, hiresLeft - 1);

      // checks to see if each potential combination of hires is better than the best one already
      if (potentialHireList != null) {
        int tempHours = potentialHireList.numCoveredHours();
        if (tempHours > max) {
          max = tempHours;
          best = potentialHireList;
        }
      }
    }

    return best;
  }

  /**
   * Knapsack dual problem: find the minimum-budget set of hires to achieve a threshold number of
   * hours. That is, given a set of candidates, a set of already-hired candidates, and a minimum
   * number of hours we want covered, what is the cheapest set of candidates we can hire that cover
   * at least that minimum number of hours specified.
   * 
   * @param candidates - the set of available candidates to hire from (excluding those already
   *                   hired)
   * @param hired      - the list of those currently hired
   * @param minHours   - the minimum number of hours we want to cover total
   * @return a list of hired candidates or null if no set of candidates achieves the requested
   *         number of hours
   */
  public static CandidateList minCoverageHiring(CandidateList candidates, CandidateList hired,
      int minHours) {
    // Method has similar logic than optimal hiring as it creates multiple potential hiring lists
    // and compares to see which
    // is more cost efficient

    if (minHours <= 0) {
      return hired;
    }


    if (candidates.isEmpty()) {
      return null;
    }

    CandidateList best = null;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < candidates.size(); i++) {
      Candidate potentialHire = candidates.get(i);
      CandidateList hired2 = new CandidateList(hired);
      CandidateList candidates2 = new CandidateList(candidates);

      hired2.add(potentialHire);
      candidates2.remove(potentialHire);

      CandidateList potentialList = optimalHiring(candidates2, hired2,
          minHours - numHours(potentialHire.getAvailability()));

      // checks to see if each potential combination of hires is lest costly than the best one
      if (potentialList != null) {
        int total = potentialList.totalCost();
        if (total < min) {
          min = total;
          best = potentialList;
        }
      }
    }


    return best;



  }

  /**
   * Private helper method that just counts how many hours an individual candidate is available used in
   * minCoverage to subract min hours in recursive call
   * 
   * @param boolean array availability - the array of when each ta is available
   * @return count - int of hours
   */
  private static int numHours(boolean[] availability) {
    int x = 0;
    for (boolean a : availability) {
      if (a) {
        x++;
      }
    }
    return x;
  }


}
