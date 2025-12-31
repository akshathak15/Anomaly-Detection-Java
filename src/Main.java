import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Double> valuesList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(
                new FileReader("data/sample_data.csv")
            );

            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                valuesList.add(Double.parseDouble(line));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading file");
            e.printStackTrace();
            return;
        }

        double[] data = new double[valuesList.size()];
        for (int i = 0; i < valuesList.size(); i++) {
            data[i] = valuesList.get(i);
        }

        double mean = Statistics.mean(data);
        double stdDev = Statistics.standardDeviation(data, mean);

        System.out.println("Mean: " + mean);
        System.out.println("Standard Deviation: " + stdDev);
        System.out.println("--------------------------------");

        for (double value : data) {
            boolean anomaly = ZScoreDetector.isAnomaly(value, mean, stdDev);
            System.out.println(value + " -> " + (anomaly ? "ANOMALY" : "Normal"));
        }
    }
}
