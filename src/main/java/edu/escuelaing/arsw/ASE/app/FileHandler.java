package edu.escuelaing.arsw.ASE.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Utility class to handle file operations.
 */
public class FileHandler {

    /**
     * Reads a file and returns its content as a linked list of strings.
     *
     * @param filename Name of the file to read.
     * @return LinkedList containing lines of the file.
     * @throws IOException if an I/O error occurs while reading the file.
     */
    public static LinkedList<String> readFile(String filename) throws IOException {
        LinkedList<String> dataList = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
        }
        return dataList;
    }
}
