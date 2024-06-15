package edu.escuelaing.arsw.ASE.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class FileHandler {

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
