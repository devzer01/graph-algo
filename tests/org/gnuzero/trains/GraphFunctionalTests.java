package org.gnuzero.trains;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GraphFunctionalTests {

    private final String ROUTE_FILE = "routes.txt";

    @After
    public void clear(){
        Graph.getNodes().clear();
    }

    private void printListofStringList(List<List<String>> lists)
    {
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void testMax3Stops()
    {
        Graph.main(ROUTE_FILE);
        Path path = new Path();
        // arbitrary source
        String s = "A";

        // arbitrary destination
        String d = "C";
        System.out.print("The number of trips starting at A and ending at C with exactly 4 stops. ");
        path.printAllPaths(s, d);
        List<List<String>> paths = path.printLocalPathList(3);
        System.out.println(paths.size());
        assertTrue(paths.size() == 3);
    }

    @Test
    public void testAtoCShortIs3()
    {
        Graph.main(ROUTE_FILE);
        Node nodeA = Graph.getNode("A");
        Node nodeC = Graph.getNode("C");
        Graph.calculateDistanceFromSource(nodeA);
        System.out.print("The length of the shortest route (in terms of distance to travel) from A to C is ");
        System.out.println(nodeC.getDistance());
        assertTrue(nodeC.getDistance() == 9);

    }

    @Test
    public void testBtoBShortIs0()
    {
        Graph.main(ROUTE_FILE);
        Graph.getNode("B").addDestination(Graph.getNode("B"),0);
        Node nodeA = Graph.getNode("B");
        Node nodeC = Graph.getNode("B");
        Graph.calculateDistanceFromSource(nodeA);
        System.out.print("The length of the shortest route (in terms of distance to travel) from B to B is ");
        System.out.println(nodeC.getDistance());
        assertTrue(nodeC.getDistance() == 0);
    }

    @Test
    public void testCtoCAll()
    {
        // Create a sample graph
        Path path = new Path();
        Graph.main("routes.txt");

        // arbitrary source
        String s = "C";

        // arbitrary destination
        String d = "C";

        System.out.print("The number of different routes from C to C with a distance of less than 30 is ");
        path.printAllPaths(s, d);
        path.combinePaths();
        List<List<String>> paths = path.printLocalPathList(30);
        System.out.println(paths.size());
        assertEquals(12, paths.size());
        System.out.println("Paths are as follows : ");
        printListofStringList(paths);
    }


    @Test
    public void testMax4FromCtoCStops()
    {
        Graph.main(ROUTE_FILE);
        Path path = new Path();
        // arbitrary source
        String s = "C";

        // arbitrary destination
        String d = "C";

        path.printAllPaths(s, d);
        System.out.print("The number of trips starting at C and ending at C with a maximum of 3 stops is ");
        List<List<String>> paths = Path.printLocalPathList(4);
        System.out.println(paths.size());
        assertTrue(paths.size()  == 2);
        System.out.println("Paths are as follows : ");
        printListofStringList(paths);
    }

    /*
        The distance of the route A-B-C.
        The distance of the route A-D.
        The distance of the route A-D-C.
        The distance of the route A-E-B-C-D.
        The distance of the route A-E-D.
     */
    @Test
    public void testGraphPathDistance()
    {
        Graph.main(ROUTE_FILE);

//        System.out.print("The distance of the route A-B-C is ");
//        List<String> test1 = new ArrayList<>();
//        test1.add("A");
//        test1.add("B");
//        test1.add("C");
//        int  distance = Graph.distanceList(test1);
//        System.out.print(distance + "\n");
//        assertTrue(distance == 9);
//
//        System.out.print("The distance of the route A-D is ");
//
//        List<String> test2 = new ArrayList<>();
//        test2.add("A");
//        test2.add("D");
//        int  distance1 = Graph.distanceList(test2);
//        System.out.print(distance1 + "\n");
//        assertTrue(distance1 == 5);
//
//        System.out.print("The distance of the route A-D-C is");
//        List<String> test4 = new ArrayList<>();
//        test4.add("A");
//        test4.add("D");
//        test4.add("C");
//        int  distance4 = Graph.distanceList(test4);
//        System.out.println(distance4);
//        assertTrue(distance4 == 13);
//
//        System.out.print("The distance of the route A-E-B-C-D is ");
//        List<String> test3 = new ArrayList<>();
//        test3.addAll(Arrays.asList("A","E", "B", "C", "D"));
//        int  distance2 = Graph.distanceList(test3);
//        System.out.print(distance2 + "\n");
//        assertTrue(distance2 == 22);

        System.out.print("The distance of the route A-E-D is ");
        List<String> test5 = new ArrayList<>();
        test5.add("A");
        test5.add("E");
        test5.add("D");
        try {
            int distance5 = Graph.distanceList(test5);
            fail();
        } catch (RuntimeException e) {
            System.out.println("NONE EXISTING ROUTE");
            assertTrue(true);
        }


    }

}