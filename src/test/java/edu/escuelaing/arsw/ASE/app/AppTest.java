package edu.escuelaing.arsw.ASE.app;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.LinkedList;

public class AppTest {

    @Test
    public void testFileLoading() {
        String filename = "src/test/java/edu/escuelaing/arsw/ASE/app/metadata.csv";
        try {
            LinkedList<String> dataList = FileHandler.readFile(filename);
            assertFalse("La lista de datos no debería estar vacía", dataList.isEmpty());
            // Puedes agregar más aserciones según sea necesario para verificar el contenido cargado del archivo
        } catch (Exception e) {
            fail("Error al cargar el archivo: " + e.getMessage());
        }
    }

    @Test
    public void testCalculateStats() {
        // Preparar datos de prueba
        LinkedList<String> dataList = new LinkedList<>();
        dataList.add("1,100");
        dataList.add("2,200");
        dataList.add("3,400");

        // Llamar al método para calcular estadísticas
        StatisticsCalculator.calculateStats(dataList);

        // Definir valores esperados
        double expectedMean = 233.33333333333334; // Calculado según tus datos

        // Verificar resultados
        assertEquals("The calculated average is not the expected one", expectedMean, StatisticsCalculator.mean, 0.01);
    }
}
