package edu.escuelaing.arsw.ASE.app;

import java.util.List;

/**
 * Class containing static methods to calculate statistical measures such as mean and standard deviation.
 */
public class StatisticsCalculator {

    /**
     * Calculates the mean (average) of a list of numbers.
     * @param data List of numbers (doubles).
     * @return Mean value rounded to two decimal places.
     */
    public static double calculateMean(List<Double> data) {
        if (data.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        double mean = sum / data.size();
        // Round to two decimal places
        return Math.round(mean * 100.0) / 100.0;
    }

    /**
     * Calculates the standard deviation of a list of numbers.
     * @param data List of numbers (doubles).
     * @return Standard deviation value rounded to two decimal places.
     */
    public static double calculateStandardDeviation(List<Double> data) {
        if (data.isEmpty()) {
            return 0.0;
        }
        double mean = calculateMean(data);
        double sum = 0;
        for (double num : data) {
            sum += Math.pow(num - mean, 2);
        }
        double variance = sum / data.size();
        double stdDeviation = Math.sqrt(variance);
        // Round to two decimal places
        return Math.round(stdDeviation * 100.0) / 100.0;
    }
}

