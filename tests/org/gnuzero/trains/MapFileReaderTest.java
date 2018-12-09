package org.gnuzero.trains;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class MapFileReaderTest {

    private final String ROUTE_FILE = "input/routes.txt";

    @Test
    public void testOpenFile() {
        MapFileReader content = MapFileReader.readFile(ROUTE_FILE);
        assertTrue(content != null);
        System.err.println(" Can open file ");
    }

    @Test
    public void testReadFile()
    {
        MapFileReader content = MapFileReader.readFile(ROUTE_FILE);
        assertTrue(content.getEdges()[0].contains("A"));
        System.err.println(" Can read content");
    }

    @Test
    public void testNoneExistingFile() {
        try {
            MapFileReader content = MapFileReader.readFile("notafile.txt");
            content.getNodes();
            fail();
        } catch (Exception e) {
            assertTrue(true);
            System.err.println(" none existing file produce null result");
        }
    }

    @Test
    public void testParseNodes()
    {
        MapFileReader content = MapFileReader.readFile(ROUTE_FILE);
        NodeBuilder.parseNode(content.getNodes());
        Node nodeA = Graph.getNode("A");
        assertTrue(nodeA != null);
        assertTrue(nodeA.getName().equals("A"));
        System.err.println(" parse node create node and Add to Graph");
    }

    @After
    public void clearNodes()
    {
        Graph.getNodes().clear();
    }

    @BeforeClass
    public static void testName()
    {
        System.out.println("Running Unit tests for MapFileReader");
    }
}
