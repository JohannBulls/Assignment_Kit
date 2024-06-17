package edu.escuelaing.arsw.ASE.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class to run the application.
 */
public class Main {

    /**
     * Main method to execute the program.
     * @param args Command-line arguments. Expects a single argument: filename.
     */
    public static void main(String[] args) {
        // Check if the correct number of arguments is provided
        if (args.length != 1) {
            System.err.println("Usage: java Main <filename>");
            System.exit(1);
        }

        String filename = args[0];

        try {
            // Read file data into a linked list
            LinkedList<String> fileData = FileHandler.readFile(filename);

            // Parse file data into a list of lists of doubles
            List<List<Double>> data = parseData(fileData);

            // Calculate and print statistics for the parsed data
            if (!data.isEmpty()) {
                calculateAndPrintStats(data);
            } else {
                System.out.println("No data found in the file: " + filename);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    /**
     * Parses the data read from file into a structured list of lists of doubles.
     * Each inner list represents a column of data.
     * @param data Linked list containing lines of data from the file.
     * @return List of lists of doubles representing parsed data columns.
     */
    public static List<List<Double>> parseData(LinkedList<String> data) {
        List<List<Double>> parsedData = new ArrayList<>();

        data.forEach(line -> {
            String[] parts = line.split(",");
            for (int i = 0; i < parts.length; i++) {
                if (parsedData.size() <= i) {
                    parsedData.add(new ArrayList<>());
                }
                double value = Double.parseDouble(parts[i].trim());
                parsedData.get(i).add(value);
            }
        });

        return parsedData;
    }

    /**
     * Calculates and prints mean and standard deviation statistics for each column of data.
     * @param data List of lists of doubles representing data columns.
     */
    public static void calculateAndPrintStats(List<List<Double>> data) {
        for (int i = 0; i < data.size(); i++) {
            List<Double> column = data.get(i);
            double mean = StatisticsCalculator.calculateMean(column);
            double stdDeviation = StatisticsCalculator.calculateStandardDeviation(column);

            System.out.println("Column " + (i + 1) + ":");
            System.out.println("  Mean: " + mean);
            System.out.println("  Standard deviation: " + stdDeviation);
            System.out.println();
        }
    }
}
