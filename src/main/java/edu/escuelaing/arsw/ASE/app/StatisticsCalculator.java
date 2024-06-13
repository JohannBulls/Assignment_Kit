package edu.escuelaing.arsw.ASE.app;
public class StatisticsCalculator {
    public static double calculateMean(LinkedList<Double> numbers) {
        double sum = 0.0;
        int count = 0;
        for (double number : numbers) {
            sum += number;
            count++;
        }
        return count == 0 ? 0 : sum / count;
    }

    public static double calculateStandardDeviation(LinkedList<Double> numbers) {
        double mean = calculateMean(numbers);
        double sum = 0.0;
        int count = 0;
        for (double number : numbers) {
            sum += Math.pow(number - mean, 2);
            count++;
        }
        return count == 0 ? 0 : Math.sqrt(sum / count);
    }
}
