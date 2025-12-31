public class Statistics {

    public static double mean(double[] data) {
        double sum = 0;
        for (double d : data) {
            sum += d;
        }
        return sum / data.length;
    }

    public static double standardDeviation(double[] data, double mean) {
        double sum = 0;
        for (double d : data) {
            sum += Math.pow(d - mean, 2);
        }
        return Math.sqrt(sum / data.length);
    }
}
