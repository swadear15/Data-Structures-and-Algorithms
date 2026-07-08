import java.time.LocalTime;
import java.util.Iterator;

public class BusStopTreeTester {

  /**
   * Tests that compareTo returns the correct value when comparing a bus with a different arrival.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testBusCompareToDifferentArrivalTime() {
    // TODO: Default return value.
	  int[] stopIds1 = {1, 2, 3, 4, 5};
	    String[] stopTimes1 = {"05:00", "07:00", "09:00", "11:00", "13:00"};
	    String[] stopTimes2 = {"04:00", "06:00", "08:00", "10:00", "12:00"};
	    // routes are different objects, but otherwise identical
	    BusRoute route1 =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);
	    BusRoute route2 =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes2);
	    Bus bus1 = new Bus(BusStop.getStop(2), route1);
	    Bus bus2 = new Bus(BusStop.getStop(2), route2);

	    // compare bus1 to bus2 and vice versa
	    boolean correctComparison1 = bus1.compareTo(bus2) == 1; // should return 1
	    boolean correctComparison2 = bus2.compareTo(bus1) == -1; // should return -1

	    // test passes if both comparisons return 0
	    return correctComparison1 && correctComparison2;
  }

  /**
   * For two buses with the same arrival time but different routes, test that compareTo returns the
   * correct value.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testBusCompareToSameArrivalTimeDifferentRoute() {
    // TODO: Default return value.
	  int[] stopIds1 = {1, 2, 3, 4, 5};
	    String[] stopTimes1 = {"05:00", "07:00", "09:00", "11:00", "13:00"};
	    // routes are different objects, but otherwise identical
	    BusRoute route1 =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);
	    BusRoute route2 =
	        BusRoute.dummyRoute("ROUTE 2", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);
	    Bus bus1 = new Bus(BusStop.getStop(2), route1);
	    Bus bus2 = new Bus(BusStop.getStop(2), route2);

	    // compare bus1 to bus2 and vice versa
	    boolean correctComparison1 = bus1.compareTo(bus2) < 0;
	    boolean correctComparison2 = bus2.compareTo(bus1) > 0; 

	    // test passes if both comparisons return 0
	    return correctComparison1 && correctComparison2;
  }


  /**
   * For two buses with the same arrival time and route name, but different directions, test that
   * compareTo returns the correct value.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testBusCompareToSameArrivalTimeSameRouteDifferentDirection() {
    // TODO: Default return value.
	  int[] stopIds1 = {1, 2, 3, 4, 5};
	    String[] stopTimes1 = {"05:00", "07:00", "09:00", "11:00", "13:00"};
	    // routes are different objects, but otherwise identical
	    BusRoute route1 =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);
	    BusRoute route2 =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    Bus bus1 = new Bus(BusStop.getStop(2), route1);
	    Bus bus2 = new Bus(BusStop.getStop(2), route2);

	    // compare bus1 to bus2 and vice versa
	    boolean correctComparison1 = bus1.compareTo(bus2)  < 0; 
	    boolean correctComparison2 = bus2.compareTo(bus1) > 0; 

	    // test passes if both comparisons return 0
	    return correctComparison1 && correctComparison2;
  }

  /**
   * Tests that compareTo returns the correct value (0) when comparing a bus with the same arrival
   * time, route name, and direction.
   * 
   * @return true if the test passes, false otherwise.
   */
  private static boolean testBusCompareToSameBus() {
    int[] stopIds1 = {1, 2, 3, 4, 5};
    String[] stopTimes1 = {"05:00", "07:00", "09:00", "11:00", "13:00"};
    // routes are different objects, but otherwise identical
    BusRoute route1 =
        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);
    BusRoute route2 =
        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);
    Bus bus1 = new Bus(BusStop.getStop(2), route1);
    Bus bus2 = new Bus(BusStop.getStop(2), route2);

    // compare bus1 to bus2 and vice versa
    boolean correctComparison1 = bus1.compareTo(bus2) == 0; // should return 0
    boolean correctComparison2 = bus2.compareTo(bus1) == 0; // should return 0

    // test passes if both comparisons return 0
    return correctComparison1 && correctComparison2;
  }

  /**
   * Tests that isValidBST returns true for an empty BST.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testIsValidBSTEmpty() {
    // TODO: Default return value.
	Node<Bus> newBus = null;
    return BusStopTree.isValidBST(newBus);
  }


  /**
   * Tests that isValidBST returns false for an invalid BST.
   * 
   * Should use a tree with depth > 2. Make sure to include a case where the left subtree contains a
   * node that is greater than the right subtree. (See the example in the spec for more details.)
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testIsValidBSTInvalid() {
    // TODO: Default return value.
	  int[] stopIds1 = {1, 2, 3, 4, 5};
	    String[] stopTimes1 = {"05:00", "07:00", "09:00", "11:00", "13:00"};


	    BusRoute route1 =
	        BusRoute.dummyRoute("A1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);

	    BusRoute route2 =
	        BusRoute.dummyRoute("B1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);

	    BusRoute route3 =
	        BusRoute.dummyRoute("C1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route4 =
	        BusRoute.dummyRoute("D1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route5 =
	        BusRoute.dummyRoute("E1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route6 =
	        BusRoute.dummyRoute("F1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route7 =
	        BusRoute.dummyRoute("G1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route8 =
	        BusRoute.dummyRoute("H1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route9 =
	        BusRoute.dummyRoute("I1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route10 =
	        BusRoute.dummyRoute("J1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route11 =
	        BusRoute.dummyRoute("K1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route12 =
	        BusRoute.dummyRoute("L1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route13 =
	        BusRoute.dummyRoute("M1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route14 =
	        BusRoute.dummyRoute("N1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route15 =
	        BusRoute.dummyRoute("O1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);


	    Bus bus1 = new Bus(BusStop.getStop(2), route1);
	    Bus bus2 = new Bus(BusStop.getStop(2), route2);
	    Bus bus3 = new Bus(BusStop.getStop(2), route3);
	    Bus bus4 = new Bus(BusStop.getStop(2), route4);
	    Bus bus5 = new Bus(BusStop.getStop(2), route5);
	    Bus bus6 = new Bus(BusStop.getStop(2), route6);
	    Bus bus7 = new Bus(BusStop.getStop(2), route7);
	    Bus bus8 = new Bus(BusStop.getStop(2), route8);
	    Bus bus9 = new Bus(BusStop.getStop(2), route9);
	    Bus bus10 = new Bus(BusStop.getStop(2), route10);
	    Bus bus11 = new Bus(BusStop.getStop(2), route11);
	    Bus bus12 = new Bus(BusStop.getStop(2), route12);
	    Bus bus13 = new Bus(BusStop.getStop(2), route13);
	    Bus bus14 = new Bus(BusStop.getStop(2), route14);
	    Bus bus15 = new Bus(BusStop.getStop(2), route15);

	    Node<Bus> n1 = new Node<Bus>(bus1);
	    Node<Bus> n2 = new Node<Bus>(bus2);
	    Node<Bus> n3 = new Node<Bus>(bus3);
	    Node<Bus> n4 = new Node<Bus>(bus4);
	    Node<Bus> n5 = new Node<Bus>(bus5);
	    Node<Bus> n6 = new Node<Bus>(bus6);
	    Node<Bus> n7 = new Node<Bus>(bus7);
	    Node<Bus> n8 = new Node<Bus>(bus8);
	    Node<Bus> n9 = new Node<Bus>(bus9);
	    Node<Bus> n10 = new Node<Bus>(bus10);
	    Node<Bus> n11 = new Node<Bus>(bus11);
	    Node<Bus> n12 = new Node<Bus>(bus12);
	    Node<Bus> n13 = new Node<Bus>(bus13);
	    Node<Bus> n14 = new Node<Bus>(bus14);
	    Node<Bus> n15 = new Node<Bus>(bus15);
	    
	    n8.setLeft(n4);
	    n8.setRight(n12);
	    n4.setLeft(n6);
	    n4.setRight(n2);
	    n2.setLeft(n1);
	    n2.setRight(n3);
	    n6.setLeft(n5);
	    n6.setRight(n7);
	    n12.setLeft(n10);
	    n12.setRight(n14);
	    n10.setLeft(n9);
	    n10.setRight(n11);
	    n14.setLeft(n13);
	    n14.setRight(n15);

	    return !(BusStopTree.isValidBST(n8));

  }


  /**
   * Tests that isValidBST returns true for a valid BST.
   * 
   * Should use a tree with depth > 2.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testIsValidBSTValid() {
    // TODO: Default return value.
	  int[] stopIds1 = {1, 2, 3, 4, 5};
	    String[] stopTimes1 = {"05:00", "07:00", "09:00", "11:00", "13:00"};


	    BusRoute route1 =
	        BusRoute.dummyRoute("A1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);

	    BusRoute route2 =
	        BusRoute.dummyRoute("B1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);

	    BusRoute route3 =
	        BusRoute.dummyRoute("C1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route4 =
	        BusRoute.dummyRoute("D1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route5 =
	        BusRoute.dummyRoute("E1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route6 =
	        BusRoute.dummyRoute("F1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route7 =
	        BusRoute.dummyRoute("G1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route8 =
	        BusRoute.dummyRoute("H1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route9 =
	        BusRoute.dummyRoute("I1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route10 =
	        BusRoute.dummyRoute("J1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route11 =
	        BusRoute.dummyRoute("K1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route12 =
	        BusRoute.dummyRoute("L1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route13 =
	        BusRoute.dummyRoute("M1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route14 =
	        BusRoute.dummyRoute("N1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);
	    
	    BusRoute route15 =
	        BusRoute.dummyRoute("O1", BusRoute.BusDirection.INCOMING, stopIds1, stopTimes1);


	    Bus bus1 = new Bus(BusStop.getStop(2), route1);
	    Bus bus2 = new Bus(BusStop.getStop(2), route2);
	    Bus bus3 = new Bus(BusStop.getStop(2), route3);
	    Bus bus4 = new Bus(BusStop.getStop(2), route4);
	    Bus bus5 = new Bus(BusStop.getStop(2), route5);
	    Bus bus6 = new Bus(BusStop.getStop(2), route6);
	    Bus bus7 = new Bus(BusStop.getStop(2), route7);
	    Bus bus8 = new Bus(BusStop.getStop(2), route8);
	    Bus bus9 = new Bus(BusStop.getStop(2), route9);
	    Bus bus10 = new Bus(BusStop.getStop(2), route10);
	    Bus bus11 = new Bus(BusStop.getStop(2), route11);
	    Bus bus12 = new Bus(BusStop.getStop(2), route12);
	    Bus bus13 = new Bus(BusStop.getStop(2), route13);
	    Bus bus14 = new Bus(BusStop.getStop(2), route14);
	    Bus bus15 = new Bus(BusStop.getStop(2), route15);

	    Node<Bus> n1 = new Node<Bus>(bus1);
	    Node<Bus> n2 = new Node<Bus>(bus2);
	    Node<Bus> n3 = new Node<Bus>(bus3);
	    Node<Bus> n4 = new Node<Bus>(bus4);
	    Node<Bus> n5 = new Node<Bus>(bus5);
	    Node<Bus> n6 = new Node<Bus>(bus6);
	    Node<Bus> n7 = new Node<Bus>(bus7);
	    Node<Bus> n8 = new Node<Bus>(bus8);
	    Node<Bus> n9 = new Node<Bus>(bus9);
	    Node<Bus> n10 = new Node<Bus>(bus10);
	    Node<Bus> n11 = new Node<Bus>(bus11);
	    Node<Bus> n12 = new Node<Bus>(bus12);
	    Node<Bus> n13 = new Node<Bus>(bus13);
	    Node<Bus> n14 = new Node<Bus>(bus14);
	    Node<Bus> n15 = new Node<Bus>(bus15);
	    
	    n8.setLeft(n4);
	    n8.setRight(n12);
	    n4.setLeft(n2);
	    n4.setRight(n6);
	    n2.setLeft(n1);
	    n2.setRight(n3);
	    n6.setLeft(n5);
	    n6.setRight(n7);
	    n12.setLeft(n10);
	    n12.setRight(n14);
	    n10.setLeft(n9);
	    n10.setRight(n11);
	    n14.setLeft(n13);
	    n14.setRight(n15);

	    return BusStopTree.isValidBST(n8);
  }


  /**
   * Tests that addBus correctly adds a bus to an empty BST.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testAddBusEmpty() {
    // TODO: Default return value.
	  int[] stopIds1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	    String[] stopTimes1 = {"05:00", "07:00", "09:00", "11:00", "13:00"};
	    BusRoute route1 =
		        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);
	    Bus bus1 = new Bus(BusStop.getStop(3), route1);
	    BusStopTree tree = new BusStopTree(3);
	    boolean add = tree.addBus(bus1);
    return add && tree.height() == 1;
  }

  /**
   * Tests that addBus correctly adds a bus to a non-empty BST.
   * 
   * Each time you add a bus, make sure that 1) addBus() returns true, 2) the BST is still valid, 3)
   * the BST size has been incremented.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testAddBus() {
    // TODO: Default return value.
	  int[] stopIds1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	    String[] stopTimes1 = {"05:00", "07:00", "09:00", "11:00", "13:00"};

	    // routes are different objects, have the same arrival time but different routes
	    BusRoute route1 =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);
	    BusRoute route2 =
	        BusRoute.dummyRoute("ROUTE 2", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);
	    BusRoute route3 =
	        BusRoute.dummyRoute("ROUTE 3", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);

	    Bus bus1 = new Bus(BusStop.getStop(3), route1);
	    Bus bus2 = new Bus(BusStop.getStop(3), route2);
	    Bus bus3 = new Bus(BusStop.getStop(3), route3);

	    BusStopTree tree = new BusStopTree(3);

	    boolean add1 = tree.addBus(bus1);
	    boolean add2 = tree.addBus(bus2);
	    boolean add3 = tree.addBus(bus3);

	    return add1 && add2 && add3 && tree.size() == 3;

  }

  /**
   * Tests that addBus returns false when adding a duplicate bus. The BST should not be modified
   * (same size).
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testAddBusDuplicate() {
    // TODO: Default return value.
	  int[] stopIds1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	    String[] stopTimes1 = {"05:00", "07:00", "09:00", "11:00", "13:00"};

	    // routes are different objects, have the same arrival time but different routes
	    BusRoute route1 =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);
	    BusRoute route2 =
	        BusRoute.dummyRoute("ROUTE 2", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);
	    BusRoute route3 =
	        BusRoute.dummyRoute("ROUTE 3", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);

	    Bus bus1 = new Bus(BusStop.getStop(3), route1);
	    Bus bus2 = new Bus(BusStop.getStop(3), route2);
	    Bus bus3 = new Bus(BusStop.getStop(3), route3);

	    BusStopTree tree = new BusStopTree(3);

	    boolean add1 = tree.addBus(bus1);
	    boolean add2 = tree.addBus(bus2);
	    boolean add3 = tree.addBus(bus2);

	    return add1 && add2 && !add3 && tree.height() == 2;
  }


  /**
   * Tests that contains returns true when the BST contains the Bus, and false otherwise.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testContains() {
    // TODO: Default return value.
	  int[] stopIds1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	    String[] stopTimes1 = {"05:00", "07:00", "09:00", "11:00", "13:00"};

	    // routes are different objects, have the same arrival time but different routes
	    BusRoute route1 =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);
	    BusRoute route2 =
	        BusRoute.dummyRoute("ROUTE 2", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);
	    BusRoute route3 =
	        BusRoute.dummyRoute("ROUTE 3", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);

	    Bus bus1 = new Bus(BusStop.getStop(3), route1);
	    Bus bus2 = new Bus(BusStop.getStop(3), route2);
	    Bus bus3 = new Bus(BusStop.getStop(3), route3);

	    BusStopTree tree = new BusStopTree(3);

	    tree.addBus(bus1);
	    tree.addBus(bus2);

	    return tree.contains(bus2) && !tree.contains(bus3) && tree.contains(bus1) && tree.size() == 2;
  }


  /**
   * Tests that getFirstNodeAfter returns the correct <code>Node<Bus></code> when the correct
   * <code>Node<Bus></code> is the node passed in as the root node parameter.
   * 
   * @return
   */
  public static boolean testGetFirstNodeAfterRoot() {
    // TODO: Default return value.
	  int[] stopIds1 = {1, 2, 3, 4, 5};
	    String[] stopTimes1 = {"05:00", "07:00", "09:00", "11:00", "13:00"};

	    // routes are different objects, have the same arrival time but different routes
	    BusRoute route1 =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds1, stopTimes1);

	    Bus bus1 = new Bus(BusStop.getStop(3), route1);

	    BusStopTree tree = new BusStopTree(3);
	    boolean add1 = tree.addBus(bus1);

	    Node<Bus> firstNode = tree.getFirstNodeAfter(LocalTime.parse("05:00"), tree.getRoot());
	    Node<Bus> expected = new Node<Bus>(bus1);

	    return firstNode.getValue().compareTo(expected.getValue()) == 0 && add1;
  }

  /**
   * Tests that getFirstNodeAfter returns the correct <code>Node<Bus></code> when the correct
   * <code>Node<Bus></code> is in the left subtree.
   * 
   * @return
   */
  public static boolean testGetFirstNodeAfterLeftSubtree() {
    // TODO: Default return value.
	  BusStopTree tree1 = new BusStopTree(3);
	    
	    int[] stopIds = {1, 2, 3, 4, 5};
	    
	    String[] stopTimes = {"06:00", "08:00", "10:00", "11:00", "13:00"};
	    
	    String[] stopTimes2 = {"05:00", "07:00", "09:00", "10:00", "12:00"};

	    // routes are different objects, have the same arrival time but different routes
	    BusRoute routeOne =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds, stopTimes);
	    
	    BusRoute routeTwo =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds, stopTimes2);

	    Bus bus1 = new Bus(BusStop.getStop(3), routeOne); // Time are different
	    Bus bus2 = new Bus(BusStop.getStop(3), routeTwo); // Time are different

	    
	    boolean checkTwo = tree1.addBus(bus1);
	    boolean checkThree = tree1.addBus(bus2);
	    

	    Node<Bus> first = tree1.getFirstNodeAfter(LocalTime.parse("08:30"), tree1.getRoot());
	    Node<Bus> check = new Node<Bus>(bus2);

	    return first.getValue().compareTo(check.getValue()) == 0 && checkTwo && checkThree;
  }

  /**
   * Tests that getFirstNodeAfter returns the correct <code>Node<Bus></code> when the correct
   * <code>Node<Bus></code> is in the right subtree.
   * 
   * @return
   */
  public static boolean testGetFirstNodeAfterRightSubtree() {
    // TODO: Default return value.
	  BusStopTree tree1 = new BusStopTree(3);
	    
	    int[] stopIds = {1, 2, 3, 4, 5};
	    
	    String[] stopTimes = {"06:00", "08:00", "10:00", "11:00", "13:00"};
	    
	    String[] stopTimes2 = {"07:00", "09:00", "11:00", "12:00", "14:00"};

	    // routes are different objects, have the same arrival time but different routes
	    BusRoute routeOne =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds, stopTimes);
	    
	    BusRoute routeTwo =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds, stopTimes2);

	    Bus bus1 = new Bus(BusStop.getStop(3), routeOne); // Time are different
	    Bus bus2 = new Bus(BusStop.getStop(3), routeTwo); // Time are different

	    
	    boolean checkTwo = tree1.addBus(bus1);
	    boolean checkThree = tree1.addBus(bus2);
	    

	    Node<Bus> first = tree1.getFirstNodeAfter(LocalTime.parse("10:30"), tree1.getRoot());
	    Node<Bus> check = new Node<Bus>(bus2);

	    return first.getValue().compareTo(check.getValue()) == 0 && checkTwo && checkThree;
  }

  /**
   * Tests that removeBus correctly removes a Bus that is a LEAF NODE. Make sure that 1) removeBus
   * returns the removed Bus, 2) the BST is still valid, 3) the BST size has been decremented.
   * 
   * Note: this test is optional and you will not be graded on it. However, it is highly encouraged.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testRemoveBusLeaf() {
    // TODO: OPTIONAL (but highly encouraged)
    return false;
  }

  /**
   * Tests that removeBus correctly removes a Bus that is a non-leaf node with ONE child. Make sure
   * that 1) removeBus returns the removed Bus, 2) the BST is still valid, 3) the BST size has been
   * decremented.
   * 
   * Note: this test is optional and you will not be graded on it. However, it is highly encouraged.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testRemoveBusNodeOneChild() {
    // TODO: OPTIONAL (but highly encouraged)
    return false;
  }

  /**
   * Tests that removeBus correctly removes a Bus that is a non-leaf node with TWO children. Make
   * sure that 1) removeBus returns the removed Bus, 2) the BST is still valid, 3) the BST size has
   * been decremented.
   * 
   * Note: this test is optional and you will not be graded on it. However, it is highly encouraged.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testRemoveBusNodeTwoChildren() {
    // TODO: OPTIONAL (but highly encouraged)
    return false;
  }


  /**
   * Tests that removeBus returns false when removing a Bus that is not in the BST. The BST should
   * not be modified.
   * 
   * Note: this test is optional and you will not be graded on it. However, it is highly encouraged.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testRemoveBusNodeNotInBST() {
    // TODO: OPTIONAL (but highly encouraged)
    return false;
  }

  /**
   * Tests the creation of an BusFilteredIterator where NONE of the buses go to the destination.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testGetNextBusesToEmpty() {
    // TODO: Default return value.
	  BusStopTree tree1 = new BusStopTree(3);
	    
	    int[] stopIds = {1, 2, 3, 4, 5};
	    
	    String[] stopTimes = {"06:00", "08:00", "10:00", "11:00", "13:00"};
	    
	    String[] stopTimes2 = {"07:00", "09:00", "11:00", "12:00", "14:00"};

	    // routes are different objects, have the same arrival time but different routes
	    BusRoute routeOne =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds, stopTimes);
	    
	    BusRoute routeTwo =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds, stopTimes2);

	    Bus bus1 = new Bus(BusStop.getStop(3), routeOne); // Time are different
	    Bus bus2 = new Bus(BusStop.getStop(3), routeTwo); // Time are different

	    
	    boolean checkTwo = tree1.addBus(bus1);
	    boolean checkThree = tree1.addBus(bus2);
	    
	    if (tree1.getNextBusTo(LocalTime.parse("10:00"), BusStop.getStop(2)) == null){
	    	return true;
	    }
	    
	    
	    return false;
  }

  /**
   * Tests the creation of an BusFilteredIterator where SOME of the buses go to the destination.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testGetNextBusesToSome() {
    // TODO: Default return value.
	  BusStopTree tree1 = new BusStopTree(3);
	    
	    int[] stopIds = {1, 2, 3, 4, 5};
	    
	    String[] stopTimes = {"06:00", "08:00", "10:00", "11:00", "13:00"};
	    

	    // routes are different objects, have the same arrival time but different routes
	    BusRoute routeOne =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds, stopTimes);
	    
	    BusRoute routeTwo =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds, stopTimes);

	    Bus bus1 = new Bus(BusStop.getStop(2), routeOne); 
	    Bus bus2 = new Bus(BusStop.getStop(3), routeOne); 

	    
	    tree1.addBus(bus1);
	    tree1.addBus(bus2);
	    
	    Iterator<Bus> i = tree1.getNextBusesTo(LocalTime.parse("10:00"), BusStop.getStop(3));
	    if (i.hasNext()) {
	    	return i.next().compareTo(bus2) == 0;
	    }
	   
	    
	    
	    return false;
  }

  /**
   * Tests the creation of an BusFilteredIterator where ALL of the buses go to the destination.
   * 
   * @return true if the test passes, false otherwise.
   */
  public static boolean testGetNextBusesToAll() {
    // TODO: Default return value.
	  BusStopTree tree1 = new BusStopTree(3);

	    int[] stopIds = {1, 2, 3, 4, 5};

	    String[] stopTimes = {"07:00", "09:00", "11:00", "12:00", "14:00"};

	    String[] stopTimes2 = {"07:00", "09:00", "11:00", "12:00", "14:00"};


	    BusRoute routeOne =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds, stopTimes);

	    BusRoute routeTwo =
	        BusRoute.dummyRoute("ROUTE 1", BusRoute.BusDirection.OUTGOING, stopIds, stopTimes2);

	    Bus bus1 = new Bus(BusStop.getStop(3), routeOne); // Times are different
	    Bus bus2 = new Bus(BusStop.getStop(3), routeTwo); // Times are different


	    tree1.addBus(bus1);
	    tree1.addBus(bus2);

	    BusStop stop = BusStop.getStop(3);

	    Iterator<Bus> filteredIterator = tree1.getNextBusesTo(LocalTime.parse("11:00"), stop);

	    if (filteredIterator.hasNext())
	    {
	      return filteredIterator.next().compareTo(bus2) == 0;
	    }

	    return false;
  }

  public static void main(String[] args) {
    // Populate BusStop with dummy data. This only has to be done once.
    BusStop.createDummyStops();
    System.out.println("COMPARE TO TESTERS: ");
    System.out
        .println("testBusCompareToDifferentArrivalTime: " + testBusCompareToDifferentArrivalTime());
    System.out.println("testBusCompareToSameArrivalTimeDifferentRoute: "
        + testBusCompareToSameArrivalTimeDifferentRoute());
    System.out.println("testBusCompareToSameArrivalTimeSameRouteDifferentDirection: "
        + testBusCompareToSameArrivalTimeSameRouteDifferentDirection());
    System.out.println("testBusCompareToSameBus: " + testBusCompareToSameBus());
    System.out.println("");
    
    System.out.println("VALID BST TESTERS: ");
    System.out.println("testIsValidBSTEmpty: " + testIsValidBSTEmpty());
    System.out.println("testIsValidBSTInvalid: " + testIsValidBSTInvalid());
    System.out.println("testIsValidBSTValid: " + testIsValidBSTValid());
    System.out.println("");
    
    System.out.println("ADD TESTERS: ");
    System.out.println("testAddBusEmpty: " + testAddBusEmpty());
    System.out.println("testAddBus: " + testAddBus());
    System.out.println("testAddBusDuplicate: " + testAddBusDuplicate());
    System.out.println("");
    
    
    System.out.println("OTHER TESTERS: ");
    System.out.println("testContains: " + testContains());
    System.out.println("testGetFirstNodeAfterRoot: " + testGetFirstNodeAfterRoot());
    System.out.println("testGetFirstNodeAfterLeftSubtree: " + testGetFirstNodeAfterLeftSubtree());
    System.out.println("testGetFirstNodeAfterRightSubtree: " + testGetFirstNodeAfterRightSubtree());
    System.out.println("testGetNextBusesToEmpty: " + testGetNextBusesToEmpty());
    System.out.println("testGetNextBusesToSome: " + testGetNextBusesToSome());
    System.out.println("testGetNextBusesToAll: " + testGetNextBusesToAll());
    
    System.out.println("REMOVE TESTERS: ");
    System.out.println("testRemoveBusLeaf: " + testRemoveBusLeaf());
    System.out.println("testRemoveBusNodeOneChild: " + testRemoveBusNodeOneChild());
    System.out.println("testRemoveBusNodeTwoChildren: " + testRemoveBusNodeTwoChildren());
    System.out.println("testRemoveBusNodeNotInBST: " + testRemoveBusNodeNotInBST());
    System.out.println("");
  }

}
