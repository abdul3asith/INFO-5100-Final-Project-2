package com.mobile.effect;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.opencsv.CSVReader;

public class App extends JFrame {

    private static final String DATA_FILE = "E:/Northeastern University/SemesterOne/ApplcnEngg.Design/FinalProject/mobileimpact/data/mobile_usage.csv"; 

    public App(String title) {
        super(title);


        List<double[]> data = loadDataset(DATA_FILE);

    
        JPanel piePanel = createPieChartPanel(data);
      
        JPanel linePanel = createLineChartPanel(data);
     
        JPanel barPanel = createBarChartPanel(data);

       
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(piePanel);
        add(linePanel);
        add(barPanel);

        setSize(800, 1200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

   
    private List<double[]> loadDataset(String filePath) {
        List<double[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                double screenTime = Double.parseDouble(nextLine[0]);
                double sleepHours = Double.parseDouble(nextLine[1]);
                double stressLevel = Double.parseDouble(nextLine[2]);
                double physicalActivity = Double.parseDouble(nextLine[3]);
                data.add(new double[]{screenTime, sleepHours, stressLevel, physicalActivity});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

   
    private JPanel createPieChartPanel(List<double[]> data) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        int lowScreenTime = 0, mediumScreenTime = 0, highScreenTime = 0;

        for (double[] record : data) {
            double screenTime = record[0];
            if (screenTime < 2) lowScreenTime++;
            else if (screenTime < 4) mediumScreenTime++;
            else highScreenTime++;
        }

        dataset.setValue("Screen Time < 2 Hours", lowScreenTime);
        dataset.setValue("Screen Time 2-4 Hours", mediumScreenTime);
        dataset.setValue("Screen Time > 4 Hours", highScreenTime);

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Screen Time Distribution", dataset, true, true, false);

        return new ChartPanel(pieChart);
    }
    

    private JPanel createLineChartPanel(List<double[]> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
        for (double[] record : data) {
            double screenTime = record[0];
            double sleepHours = record[1];
            dataset.addValue((Double) sleepHours, "Sleep Hours", (Double) screenTime);
        }
    
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Screen Time vs Sleep Hours",
                "Screen Time (Hours)", "Sleep Hours",
                dataset, PlotOrientation.VERTICAL, true, true, false);
    
        return new ChartPanel(lineChart);
    }
  
    private JPanel createBarChartPanel(List<double[]> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (double[] record : data) {
            double screenTime = record[0];
            double physicalActivity = record[3];
            dataset.addValue(physicalActivity, "Physical Activity (%)", screenTime + " Hours");
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Screen Time vs Physical Activity",
                "Screen Time", "Physical Activity (%)",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        return new ChartPanel(barChart);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App visualization = new App(
                    "Impact of Mobile Phones on Human Health");
        });
    }
}
