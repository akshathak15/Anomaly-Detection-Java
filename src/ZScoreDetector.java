public class ZScoreDetector {

    public static boolean isAnomaly(double value, double mean, double stdDev) {
        if (stdDev == 0) return false;

        double zScore = Math.abs((value - mean) / stdDev);
        return zScore > 1.5;
    }
}
