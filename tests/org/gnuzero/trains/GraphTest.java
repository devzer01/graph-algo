package org.gnuzero.trains;

import org.gnuzero.trains.Graph;
import org.gnuzero.trains.Node;
import org.gnuzero.trains.NodeTests;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GraphTest {

    @BeforeClass
    public static void testName()
    {
        System.out.println("Running Unit tests for GraphTest");
    }


    @Test
    public void testAddNode()
    {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Graph.addNode(nodeA);
        Graph.addNode(nodeB);
        System.out.print(" Added Node exists in Graph ");
        assertTrue(Graph.getNode("A").getName().equals("A"));
        System.out.println("");
    }

    @After
    public void clear()
    {
        Graph.getNodes().clear();
    }

    @Test
    public void testGetNode()
    {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Graph.addNode(nodeA);
        Graph.addNode(nodeB);
        System.out.print(" Can retrieve all nodes ");
        assertTrue(Graph.getNodes().size() == 2);
        System.out.println("");
    }

    @Test
    public void testAddSameNode()
    {
        System.out.print(" Adding duplicate node throws exception ");
        Node nodeA = new Node("A");
        try {
            Graph.addNode(nodeA);
            Graph.addNode(nodeA);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
        System.out.println("");
    }
}