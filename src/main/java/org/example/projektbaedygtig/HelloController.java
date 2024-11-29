package org.example.projektbaedygtig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class HelloController {

    public static ArrayList<ArrayList<String>> getData() {

        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        String filePath = "src/main/resources/SolcelleData.tsv"; // Path to our file
        int maxRows = 100001; // dataset size

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int rowIndex = 0;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skips header line
                    continue;
                }

                // Splits the line
                String[] columns = line.split("\\s+");

                data.add(new ArrayList<>());
                // Parse and stores numerical values in the array for:
                data.get(rowIndex).add(String.valueOf(columns[0])); // _id
                data.get(rowIndex).add(String.valueOf(columns[1]));
                data.get(rowIndex).add(String.valueOf(columns[2])); // sid
                data.get(rowIndex).add(String.valueOf(columns[3])); // total
                data.get(rowIndex).add(String.valueOf(columns[4])); // online
                data.get(rowIndex).add(String.valueOf(columns[5]));// offline


                rowIndex++;

               // It stops if we exceed maxRows
                if (rowIndex >= maxRows) {
                    System.out.println("Warning: Maximum row limit reached!");
                    break;
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return data;
    }

    // Method to prepare and simulate graphing
    public static void prepareGraph(double[][] data, int rows, int xIndex, int yIndex) {
        System.out.println("Preparing data for graphing...");
        System.out.println("X-Axis: Column " + xIndex);
        System.out.println("Y-Axis: Column " + yIndex);

        for (int i = 0; i < rows; i++) {
            System.out.println("X: " + data[i][xIndex] + ", Y: " + data[i][yIndex]);
        }

    }
}
