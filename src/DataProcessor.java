/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author janle
 */
import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    public static List<String> processDataForDisplay(List<String> receivedData) {
        List<String> processedData = new ArrayList<String>();

        for (int i = 0; i < receivedData.size(); i += 2) {
            processedData.add(receivedData.get(i) + " | " + receivedData.get(i + 1));
        }

        return processedData;
    }

    public static String getTotalSpendings(List<String> receivedData) {
        try {
            float totalSpendingsFloat = 0;
            int dataSize = receivedData.size();
            for (int i = 0; i < dataSize; i += 2) {
                totalSpendingsFloat += Float.parseFloat(receivedData.get(i + 1));
            }

            String result = String.valueOf(totalSpendingsFloat);
            return result;
        } catch (Exception ex) {
            System.out.println(ex);
            return "Fehler beim Berechnen";
        }
    }
}
