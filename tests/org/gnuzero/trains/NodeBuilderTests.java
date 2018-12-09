package org.gnuzero.trains;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class NodeBuilderTests
{
    @Test
    public void testParseEdgesThrowException()
    {
        String[] list = {"AB2", "AB334"};
        try {
            NodeBuilder.parseEdge(list);
            fail();
        } catch (Exception e) {
            System.out.println(" element is bigger than allowed limit of chars throws exception");
            assertTrue(true);
        }
    }

    @BeforeClass
    public static void testName()
    {
        System.out.println("Running node builder tests");
    }
}
