package edu.escuelaing.arsw.ASE.app;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StatisticsCalculatorTest {

    /**
     * Test case to verify the correctness of mean and standard deviation calculation
     * for two columns of data parsed from a CSV file.
     *
     * @throws IOException if there is an error reading the test data file.
     */
    @Test
    public void testCalculateMeanAndStdDeviation() throws IOException {
        String filename = "metadata.csv";
        LinkedList<String> fileData = FileHandler.readFile(getFilePath(filename));
        List<List<Double>> data = Main.parseData(fileData);

        assertEquals(2, data.size());

        for (int i = 0; i < data.size(); i++) {
            List<Double> column = data.get(i);
            double mean = StatisticsCalculator.calculateMean(column);
            double stdDeviation = StatisticsCalculator.calculateStandardDeviation(column);

            switch (i) {
                case 0:
                    assertEquals(550.6, mean, 0.1);
                    assertEquals(542.67, stdDeviation, 0.1);
                    break;
                case 1:
                    assertEquals(60.32, mean, 0.01);
                    assertEquals(59.06, stdDeviation, 0.01);
                    break;
                default:
                    assertTrue(false);
                    break;
            }
        }
    }

    /**
     * Utility method to get the file path of a resource file in the classpath.
     *
     * @param filename Name of the resource file.
     * @return Absolute file path of the resource file.
     */
    private String getFilePath(String filename) {
        return getClass().getClassLoader().getResource(filename).getPath();
    }
}
