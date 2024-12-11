package com.mobile.effect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dataPreprocessor {
    public static void main(String[] args) {
        String filePath = "data/mobile_usage.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read the header
            String header = br.readLine();
            System.out.println("Header: " + header);

            // Process the data
            List<String[]> data = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(","); // Assuming the delimiter is a comma
                data.add(row);
            }

            // Example: Display the data
            System.out.println("Parsed Data:");
            for (String[] row : data) {
                System.out.println(Arrays.toString(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
