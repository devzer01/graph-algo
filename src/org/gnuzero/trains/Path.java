package org.gnuzero.trains;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Path {

    /**
     * (List of List for storing paths)
     */
    private static List<List<String>> pathList = new ArrayList<>();

    /**
     * add to path list
     * @param localPathList
     */
    static void addLocalPathList(ArrayList<String> localPathList)
    {
        ArrayList newArrayList = (ArrayList) localPathList.clone();
        pathList.add(newArrayList);
    }

    /**
     *
     * @param max
     * @return
     */
    static List<List<String>> printLocalPathList(int max)
    {
        List<List<String>> local = new ArrayList<>();
        for (List<String> list : pathList) {
            if (list.size() <= max || max == 0) {
                //System.out.println(list);
                local.add(list);
            }
        }
        if (max == 0) {
            return pathList;
        }
        return local;
    }

    /**
     *
     * @param distance
     * @return
     */
    public static List<List<String>> printLocalPathLessThan(int distance)
    {
        List<List<String>> local = new ArrayList<>();
        for (List<String> list : pathList) {
            if (Graph.distanceList(list) < distance) {
                System.out.println(list);
                local.add(list);
            }
        }
        return local;
    }

    /**
     *
     * @param lists
     * @param <T>
     * @return
     */
    @SafeVarargs
    private static <T> List<T> concat(List<T>... lists) {
        return Stream.of(lists).flatMap(List::stream).collect(Collectors.toList());
    }

    static void combinePaths()
    {
        List<String> first = pathList.get(0);
        List<String> second = pathList.get(pathList.size() - 1);
        pathList.add(concat(first, second));
        pathList.add(concat(second, first));
    }

    private boolean sameNode = false;

    //Constructor
    public Path(){

    }

    public static void clearPaths() {
        pathList.clear();
    }

    // Prints all paths from
    // 's' to 'd'
    void printAllPaths(String s, String d)
    {
        HashMap<String, Boolean> isVisited = new HashMap<>();
        ArrayList<String> pathList = new ArrayList<>();

        //add source to path[]
        pathList.add(s);

        if (s.equals(d)) {
            this.sameNode = true;
        }

        //Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList);

    }


    /**
     * recursive call to visit all possible paths from start to finish
     * @param start
     * @param stop
     * @param visitedPaths
     * @param localPath
     */
    private void printAllPathsUtil(String start, String stop,
                                   HashMap<String, Boolean> visitedPaths,
                                   ArrayList<String> localPath) {

        visitedPaths.put(start, true);
        boolean same = true;
        if (this.sameNode && visitedPaths.size() <= 1) same = false;

        //terminate clause, use boolean to make code traverse over the start point
        if (start.equals(stop) && same)
        {
            Path.addLocalPathList(localPath);
            visitedPaths.put(start, false);
            return ;
        }

        Map<Node, Integer> map = Graph.getNode(start).getAdjacentNodes();

        for (Map.Entry<Node, Integer> i : map.entrySet())
        {
            //we travel to each node from the starting point
            if (visitedPaths.get(i.getKey()) == null || visitedPaths.get(i.getKey()) != null &&  !visitedPaths.get(i.getKey().getName()))
            {
                localPath.add(i.getKey().getName());
                printAllPathsUtil(i.getKey().getName(), stop, visitedPaths, localPath);
                localPath.remove(i.getKey().getName());
            }
        }
        visitedPaths.put(start, false);
    }

}
