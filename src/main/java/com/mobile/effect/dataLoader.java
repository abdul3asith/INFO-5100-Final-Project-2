package com.mobile.effect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class dataLoader {
    public static void main(String[] args) {
        String filePath = "E:/Northeastern University/SemesterOne/ApplcnEngg.Design/FinalProject/mobileimpact/data/mobile_usage.csv"; 
        // List<String[]> data = new ArrayList<>();
        // String filePath = "E:/Northeastern University/SemesterOne/ApplcnEngg.Design/FinalProject/mobileimpact/data/mobile_usage.csv"; 
    List<String[]> data = loadData(filePath);
        if (data != null) {
            dataAnalyser analyser = new dataAnalyser(data);
            analyser.generateReport();
        }
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found at: " + file.getAbsolutePath());
                return;
            }
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] row = line.split(",");
                    data.add(row);
                }
                dataAnalyser analyser = new dataAnalyser(data);
                analyser.generateReport();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        static List<String[]> loadData(String filePath) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'loadData'");
        }

    // public static List<String[]> loadData(String string) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'loadData'");
    // }
    
}
