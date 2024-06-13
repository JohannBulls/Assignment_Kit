package edu.escuelaing.arsw.ASE.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public static LinkedList<Double> readNumbersFromFile(String filePath) {
        LinkedList<Double> numbers = new LinkedList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\s+");
                for (String value : values) {
                    numbers.add(Double.parseDouble(value));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }
}
