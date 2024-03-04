/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author janle
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FileEditor {

    public static void initializeFile() {
        try {
            File file = new File("expensesRecords.txt");
            if (!file.exists()) {
                new FileWriter("expensesRecords.txt");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Es gab ein Fehler, starten Sie das Programm neu. \n" + "Sollte der Fehler weiter bestehen wenden Sie sich an den Support.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static List<String> getAllRecords() {
        List<String> records = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("expensesRecords.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                records.add(line);
            }

            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Es gab ein Fehler, starten Sie das Programm neu. \n" + "Sollte der Fehler weiter bestehen wenden Sie sich an den Support.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        System.out.println(records);
        return records;
    }

    public static void addARecord(float inputAmount, String inputCategory) {
        try {
            List<String> excistingRecords = getAllRecords();
            BufferedWriter writer = new BufferedWriter(new FileWriter("expensesRecords.txt"));

            for (int i = 0; i < excistingRecords.size(); i++) {
                if (i == 0) {
                    writer.write(excistingRecords.get(i));
                } else {
                    writer.write("\n" + excistingRecords.get(i));
                }
            }

            if (excistingRecords.size() == 0) {
                writer.write(inputCategory);
                writer.write("\n" + String.valueOf(inputAmount));
            } else {
                writer.write("\n" + inputCategory);
                writer.write("\n" + String.valueOf(inputAmount));
            }

            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Es gab ein Fehler, starten Sie das Programm neu. \n" + "Sollte der Fehler weiter bestehen wenden Sie sich an den Support.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
