package org.example.projektbaedygtig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

    public class TSVReaderForGraph {
    /**
     * This program reads numerical data from a TSV file and stores it in a 2D array.
     @param args Command-line arguments (not used).

     Functionality:
     - Reads data from a TSV file line by line.
     - Stores each record as a row in a 2D array (`data[][]`).
     - Allows flexible selection of X and Y axes for graphing.

     Data columns:
     - Column 0: `_id`
     - Column 1: `sid`
     - Column 2: `total`
     - Column 3: `online`
     - Column 4: `offline`
     Usage:
     - Use the `prepareGraph` method to define which columns to use for the X and Y axes.
     - For example, `prepareGraph(data, rowIndex, 2, 3)` uses `total` as X and `online` as Y.
     */

    public static void main(String[] args) {
        String filePath = "src/main/resources/SolcelleData.tsv"; // Path to our file
        int maxRows = 10000; // dataset size
        double[][] data = new double[maxRows][5]; // Array for numerical data (_id, sid, total, online, offline)

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
                String[] columns = line.split("\t");

                // Parse and stores numerical values in the array for:
                data[rowIndex][0] = Double.parseDouble(columns[0]); // _id
                data[rowIndex][1] = Double.parseDouble(columns[2]); // sid
                data[rowIndex][2] = Double.parseDouble(columns[3]); // total
                data[rowIndex][3] = Double.parseDouble(columns[4]); // online
                data[rowIndex][4] = Double.parseDouble(columns[5]); // offline

                rowIndex++;

                // It stops if we exceed maxRows
                if (rowIndex >= maxRows) {
                    System.out.println("Warning: Maximum row limit reached!");
                    break;
                }
            }

            // Call the method to prepare and graph data
            prepareGraph(data, rowIndex, 2, 3); // Example: X = total, Y = online

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
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
