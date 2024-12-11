package com.mobile.effect;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// public class dataAnalyser {
    

//     private List<String[]> data;

    
//     public dataAnalyser(List<String[]> data) {
//         this.data = data;
//     }

//     // Method to calculate average usage hours
//     public double calculateAverageUsage() {
//         double totalUsage = 0;
//         int count = 0;

//         for (String[] row : data) {
//             try {
//                 double usage = Double.parseDouble(row[1]); 
//                 totalUsage += usage;
//                 count++;
//             } catch (NumberFormatException e) {
//                 System.out.println("Invalid data format: " + Arrays.toString(row));
//             }
//         }

//         return count == 0 ? 0 : totalUsage / count;
//     }

   
//     public String findMaxUsageDay() {
//         double maxUsage = 0;
//         String maxDay = "";

//         for (String[] row : data) {
//             try {
//                 double usage = Double.parseDouble(row[1]); 
//                 if (usage > maxUsage) {
//                     maxUsage = usage;
//                     maxDay = row[0]; 
//                 }
//             } catch (NumberFormatException e) {
//                 System.out.println("Invalid data format: " + Arrays.toString(row));
//             }
//         }

//         return maxDay;
//     }

 
//     public Map<String, List<String[]>> groupDataByCategory() {
//         Map<String, List<String[]>> groupedData = new HashMap<>();

//         for (String[] row : data) {
//             String category = row[2]; // Assuming category is in column 3
//             groupedData.computeIfAbsent(category, k -> new ArrayList<>()).add(row);
//         }

//         return groupedData;
//     }

//     public void generateReport() {
//         System.out.println("===== Data Analysis Report =====");
//         System.out.println("Average Usage Hours: " + calculateAverageUsage());
//         System.out.println("Day with Maximum Usage: " + findMaxUsageDay());

//         System.out.println("Data Grouped by Category:");
//         Map<String, List<String[]>> groupedData = groupDataByCategory();
//         for (String category : groupedData.keySet()) {
//             System.out.println("Category: " + category + ", Entries: " + groupedData.get(category).size());
//         }
//     }
// }

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dataAnalyser {
    private List<String[]> data;

    public dataAnalyser(List<String[]> data) {
        this.data = data;
    }

    // Method to calculate average usage hours
    public double calculateAverageUsage() {
        double totalUsage = 0;
        int count = 0;

        for (String[] row : data) {
            try {
                double usage = Double.parseDouble(row[1]);  // Assuming usage is in column 1
                totalUsage += usage;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid data format: " + Arrays.toString(row));
            }
        }

        return count == 0 ? 0 : totalUsage / count;
    }

    // Method to calculate average stress level (assuming stress level is in column 2)
    public double calculateAverageStressLevel() {
        double totalStress = 0;
        int count = 0;

        for (String[] row : data) {
            try {
                double stressLevel = Double.parseDouble(row[2]);  // Assuming stress level is in column 2
                totalStress += stressLevel;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid data format: " + Arrays.toString(row));
            }
        }

        return count == 0 ? 0 : totalStress / count;
    }

    public Map<String, List<String[]>> groupDataByCategory() {
        Map<String, List<String[]>> groupedData = new HashMap<>();
        for (String[] row : data) {
            String category = row[3];  // Assuming category is in column 3
            groupedData.computeIfAbsent(category, k -> new ArrayList<>()).add(row);
        }
        return groupedData;
    }
    
    public void generateReport() {
        System.out.println("===== Data Analysis Report =====");
        System.out.println("Average Usage Hours: " + calculateAverageUsage());
        System.out.println("Average Stress Level: " + calculateAverageStressLevel());
        Map<String, List<String[]>> groupedData = groupDataByCategory();
        for (String category : groupedData.keySet()) {
            System.out.println("Category: " + category + ", Entries: " + groupedData.get(category).size());
        }
    }
}

