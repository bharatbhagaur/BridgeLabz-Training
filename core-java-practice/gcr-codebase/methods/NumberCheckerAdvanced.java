public class NumberCheckerAdvanced {

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits)
            sum += d;
        return sum;
    }

    public static double sumOfSquares(int[] digits) {
        double sum = 0;
        for (int d : digits)
            sum += Math.pow(d, 2);
        return sum;
    }

    public static boolean isHarshad(int number, int[] digits) {
        return number % sumOfDigits(digits) == 0;
    }

    // Frequency of digits
    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];

        for (int i = 0; i < 10; i++)
            freq[i][0] = i;

        for (int d : digits)
            freq[d][1]++;

        return freq;
    }
}
