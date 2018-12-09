package org.gnuzero.trains;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PathTests
{
    @Test
    public void testPathAdd()
    {
        Path path = new Path();
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        Path.addLocalPathList(list);
        System.out.println(" can add to path list and retrieve");
        int size = Path.printLocalPathList(0).get(0).size();
        assertTrue(size == 3);
    }

    @BeforeClass
    public static void testName()
    {
        System.out.println("Run path Unit tests");
    }
}
