package org.gnuzero.trains;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Graph
{

    /**
     *  holds the nodes (Set)
     */
    private static Set<Node> nodes = new HashSet<>();



    /**
     * return the set of all nodes
     * currently in Graph
     * @return
     */
    static Set<Node> getNodes(){
        return nodes;
    }

    /**
     * add a node to the node set,
     * if node already exists throws @RuntimeException
     * @param nodeA
     */
    static void addNode(Node nodeA) {
        if (getNode(nodeA.getName()) == null) {
            nodes.add(nodeA);
        } else {
            throw new RuntimeException("node already in graph");
        }
    }

    /**
     * returns node by name (String)
     * @param name
     * @return
     */
    static Node getNode(String name){
        Iterator<Node> itr = nodes.iterator();
        while (itr.hasNext()) {
            Node node = itr.next();
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }

    /**
     *
     * iterates over a path accumulating
     * the distance between each edge
     *
     * @param list
     * @return
     */
    static Integer distanceList(List<String> list) {
        Integer edgeDistance = 0;
        String lastNode = null;
        for (int i = 0; i < list.size(); i++) {
            if (lastNode != null) {
                edgeDistance += distance(lastNode, list.get(i));
            }
            lastNode = list.get(i);
        }
        return edgeDistance;
    }

    /**
     *
     * returns the distance to start node to end node
     *
     * @param start
     * @param end
     * @return
     */
    private static Integer distance(String start, String end) { ;
        Node nodeA = getNode(start);
        Node nodeB = getNode(end);
        if (nodeA == null) {
            return 0;
        }

        return nodeA.getDistanceToDest(nodeB);

    }



    public static void calculateDistanceFromSource(Node source) {

        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    getMinimumDistance(adjacentNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
    }

    private static void getMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static Node getLowestDistanceNode(Set<Node> nodeSet) {
        Node lowestNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : nodeSet) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestNode = node;
            }
        }
        return lowestNode;
    }

    /**
     *
     */
    static void main(String filename) {
        MapFileReader mapFileReader = MapFileReader.readFile(filename);

        NodeBuilder.parseNode(mapFileReader.getNodes());
        NodeBuilder.parseEdge(mapFileReader.getEdges());
    }
}
