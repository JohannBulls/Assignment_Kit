package edu.escuelaing.arsw.ASE.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatisticsCalculator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java StatisticsCalculator <filename>");
            System.exit(1);
        }

        String filename = args[0];

        try {
            List<List<Double>> data = readData(filename);
            if (!data.isEmpty()) {
                calculateAndPrintStats(data);
            } else {
                System.out.println("No se encontraron datos en el archivo: " + filename);
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
    }

    public static List<List<Double>> readData(String filename) throws IOException {
        List<List<Double>> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                for (int i = 0; i < parts.length; i++) {
                    if (data.size() <= i) {
                        data.add(new ArrayList<>());
                    }
                    double value = Double.parseDouble(parts[i].trim());
                    data.get(i).add(value);
                }
            }
        }

        return data;
    }

    public static void calculateAndPrintStats(List<List<Double>> data) {
        for (int i = 0; i < data.size(); i++) {
            List<Double> column = data.get(i);
            double mean = calculateMean(column);
            double stdDeviation = calculateStandardDeviation(column);

            System.out.println("Columna " + (i + 1) + ":");
            System.out.println("  Media: " + mean);
            System.out.println("  Desviación estándar: " + stdDeviation);
            System.out.println();
        }
    }

    public static double calculateMean(List<Double> data) {
        double sum = 0.0;
        for (double value : data) {
            sum += value;
        }
        return sum / data.size();
    }

    public static double calculateStandardDeviation(List<Double> data) {
        double mean = calculateMean(data);
        double sumSquaredDiff = 0.0;
        for (double value : data) {
            sumSquaredDiff += Math.pow(value - mean, 2);
        }
        return Math.sqrt(sumSquaredDiff / data.size());
    }
}
