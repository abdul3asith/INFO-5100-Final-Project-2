// package com.mobile.effect;



// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.SwingUtilities;

// import org.jfree.chart.ChartFactory;
// import org.jfree.chart.ChartPanel;
// import org.jfree.chart.JFreeChart;
// import org.jfree.data.category.DefaultCategoryDataset;
// import org.jfree.data.xy.XYSeries;
// import org.jfree.data.xy.XYSeriesCollection;

// public class dataVisualizer {

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             JFrame frame = new JFrame("Mobile Usage Data Visualization");
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             frame.add(createChartPanel());
//             frame.pack();
//             frame.setVisible(true);
//         });
//     }
//     public static void createScatterPlot(double[] screenTime, double[] stressLevels) {
//         XYSeries series = new XYSeries("Screen Time vs Stress");
//         for (int i = 0; i < screenTime.length; i++) {
//             series.add(screenTime[i], stressLevels[i]);
//         }

//         XYSeriesCollection dataset = new XYSeriesCollection(series);
//         JFreeChart chart = ChartFactory.createScatterPlot(
//             "Screen Time vs Stress",
//             "Screen Time (hours)",
//             "Stress Level (1-10)",
//             dataset
//         );
//         ChartPanel panel = new ChartPanel(chart);
//         panel.setPreferredSize(new java.awt.Dimension(800, 600));
//         javax.swing.JFrame frame = new javax.swing.JFrame("Data Visualization");
//         frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
//         frame.getContentPane().add(panel);
//         frame.pack();
//         frame.setVisible(true);
//     }

//     private static JPanel createChartPanel() {
//         String chartTitle = "Average Daily Mobile Usage (Hours)";
//         String categoryAxisLabel = "Date";
//         String valueAxisLabel = "Usage (Hours)";

//         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//         dataset.addValue(4, "Usage", "2024-11-20");
//         dataset.addValue(5, "Usage", "2024-11-21");
//         dataset.addValue(3.5, "Usage", "2024-11-22");
//         dataset.addValue(6, "Usage", "2024-11-23");
//         dataset.addValue(4.5, "Usage", "2024-11-24");

//         JFreeChart chart = ChartFactory.createBarChart(
//                 chartTitle,        
//                 categoryAxisLabel, 
//                 valueAxisLabel,   
//                 dataset           
//         );

   
//         return new ChartPanel(chart);
//     }
// }



package com.mobile.effect;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class dataVisualizer {

    public static void main(String[] args) {
        // Assuming we have already loaded and analyzed the data
        List<String[]> data = dataLoader.loadData("E:/Northeastern University/SemesterOne/ApplcnEngg.Design/FinalProject/mobileimpact/data/mobile_usage.csv");  // Your DataLoader code
        dataAnalyser analyser = new dataAnalyser(data);
        
        double[] screenTime = {4.5, 5.0, 3.5, 6.0, 4.5};  // Example data, use actual values from analysis
        double[] stressLevels = {5, 6, 4, 7, 6};  // Example data, use actual values from analysis
        
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mobile Usage Data Visualization");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(createChartPanel(screenTime, stressLevels));
            frame.pack();
            frame.setVisible(true);
        });
    }

    // Create scatter plot with analyzed data (screen time vs stress levels)
    public static JPanel createChartPanel(double[] screenTime, double[] stressLevels) {
        XYSeries series = new XYSeries("Screen Time vs Stress");
        for (int i = 0; i < screenTime.length; i++) {
            series.add(screenTime[i], stressLevels[i]);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createScatterPlot(
            "Screen Time vs Stress",
            "Screen Time (hours)",
            "Stress Level (1-10)",
            dataset
        );
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new java.awt.Dimension(800, 600));
        return panel;
    }
}
