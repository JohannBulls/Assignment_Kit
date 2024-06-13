package edu.escuelaing.arsw.ASE.app;

public class Main {
    public static void main(String[] args) {
        String filePath = "";
        LinkedList<Double> numbers = FileReader.readNumbersFromFile(filePath);

        double mean = StatisticsCalculator.calculateMean(numbers);
        double standardDeviation = StatisticsCalculator.calculateStandardDeviation(numbers);

        System.out.println("Mean: " + mean);
        System.out.println("Standard Deviation: " + standardDeviation);
    }
}
