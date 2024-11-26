package org.example.projektbaedygtig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TSVReaderForGraph {
    public static void main(String[] args) {
        String filePath = "src/main/resources/SolcelleData.tsv"; // Path to your file
        int maxRows = 1000; // Adjust based on your dataset size
        double[][] data = new double[maxRows][5]; // Array for numerical data (_id, sid, total, online, offline)

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int rowIndex = 0;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header line
                    continue;
                }

                // Split the line by tab
                String[] columns = line.split("\t");

                // Parse and store numerical values in the array
                data[rowIndex][0] = Double.parseDouble(columns[0]); // _id
                data[rowIndex][1] = Double.parseDouble(columns[2]); // sid
                data[rowIndex][2] = Double.parseDouble(columns[3]); // total
                data[rowIndex][3] = Double.parseDouble(columns[4]); // online
                data[rowIndex][4] = Double.parseDouble(columns[5]); // offline

                rowIndex++;

                // Stop if we exceed maxRows
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

        // Here, you can pass the data to your preferred graphing library
    }
}
