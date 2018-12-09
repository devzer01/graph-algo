package org.gnuzero.trains;

import java.util.*;

/**
 *  represents a node in the Graph
 */
public class Node {

    /**
     * node name
     */
    private String name;

    /**
     * shortest path
     */
    private LinkedList<Node> shortestPath = new LinkedList<>();

    /**
     * all paths
     */
    private List<LinkedList<Node>> paths = new ArrayList<>();

    /**
     *
     */
    private Integer distance = 9999;

    /**
     *
     */
    private Map<Node, Integer> adjacentNodes = new HashMap<>();

    /**
     *
     * @param name
     */
    public Node(String name) {
        this.name = name;
    }

    /**
     *
     * @param destination
     * @param distance
     */
    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    /**
     *
     * @param adjacentNodes
     */
    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    /**
     *
     * return distance from source
     *
     * @return
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     *
     * @return
     */
    public List<Node> getShortestPath() {
        return shortestPath;
    }

    /**
     *
     * @param shortestPath
     */
    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
        this.paths.add(shortestPath);
    }

    /**
     *
     * @param b
     * @return
     */
    public Integer getDistanceToDest(Node b) {
        if (adjacentNodes.get(b) == null) {
            throw new RuntimeException(" No Such Route");
        }
        return adjacentNodes.get(b);
    }

    // getters and setters
}