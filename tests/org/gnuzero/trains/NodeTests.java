package org.gnuzero.trains;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Map;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class NodeTests
{
    @Test
    public void testNodeCreate()
    {
        Node node = new Node("A");
        assertTrue(node.getName().equals("A"));
        System.err.println(" Can create Node");
    }

    @Test
    public void testNodeDistance()
    {
        Node node = new Node("A");
        node.setDistance(10);
        assertTrue(node.getDistance() == 10);
        System.err.println(" Can set Node Distance");
    }

    @Test
    public void testNodeAddAdjacent()
    {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        nodeA.addDestination(nodeB, 10);
        Map<Node, Integer> adjacent = nodeA.getAdjacentNodes();
        assertTrue(adjacent.get(nodeB) == 10);
        System.err.println(" Can add Adjacent Node");
    }

    @Test
    public void testSetShortestPath()
    {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        LinkedList<Node> list = new LinkedList<>();
        list.add(0, nodeA);
        list.addFirst(nodeB);
        nodeA.setShortestPath(list);
        assertTrue(nodeA.getShortestPath().get(0).getName().equals("B"));
        System.err.println(" Can set Shortest Path in Node");
    }

    @BeforeClass
    public static void testName()
    {
        System.out.println("Running Unit tests for Node");
    }
}
