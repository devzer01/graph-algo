package org.gnuzero.trains;

import java.util.*;

public class NodeBuilder
{
    /**
     * add edges to nodes
     * @param list
     */
    public static void parseEdge(String[] list)
    {
        for (int i = 0; i < list.length; i++) {
            String element = list[i].replace(" ", "");
            Graph.getNode(element.substring(0, 1)).addDestination(
                    Graph.getNode(element.substring(1,2)),
                    Integer.parseInt(element.substring(2))
            );
        }
        return;
    }

    public static Set<Node> parseNode(Object[] unique)
    {
        for (int i =0 ; i < unique.length; i++) {
            Graph.addNode(new Node((String) unique[i]));
        }

        //for array
        return Graph.getNodes();
    }
}
