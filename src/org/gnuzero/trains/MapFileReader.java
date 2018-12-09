package org.gnuzero.trains;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

import static javax.script.ScriptEngine.FILENAME;

public class MapFileReader
{
    private String content = null;

    public MapFileReader(String content)
    {
        this.content = content;
    }

    public String[] getEdges()
    {
        return  content.replace("\"", "")
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "")
                .split(",");
    }

    public Object[] getNodes()
    {
        String[] array = content.replace("\"", "")
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "")
                .replace(",", "")
                .replaceAll("[0-9]", "")
                .split("(?!^)");
        Set<String> set = new LinkedHashSet<String>(Arrays.asList(array ));
        return set.toArray();
    }

    /**
     * refer to the readme.MD file regarding the format
     * of the input file with edge
     * NodeNodeDistance (comma separated)
     * @param filename String
     * @return String
     */
    public static MapFileReader readFile(String filename)
    {
        BufferedReader br = null;
        FileReader fr = null;
        String currentLine = null;

        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            do {
                currentLine = br.readLine(); //read the first line of data
            } while(br.readLine() != null);

            if (br != null)
                br.close();

            if (fr != null)
                fr.close();

        } catch (IOException e) {

        } finally {
            return new MapFileReader(currentLine);
        }
    }
}
