import java.util.Random;

public class FootballTeamStats {

    // Method to calculate sum of heights
    static int calculateSum(int[] heights) {
        int total = 0;
        for (int h : heights)
            total += h;
        return total;
    }

    // Method to calculate mean height
    static double calculateMean(int[] heights) {
        return (double) calculateSum(heights) / heights.length;
    }

    // Method to find shortest height
    static int findShortest(int[] heights) {
        int minHeight = heights[0];
        for (int h : heights)
            if (h < minHeight)
                minHeight = h;
        return minHeight;
    }

    // Method to find tallest height
    static int findTallest(int[] heights) {
        int maxHeight = heights[0];
        for (int h : heights)
            if (h > maxHeight)
                maxHeight = h;
        return maxHeight;
    }

    public static void main(String[] args) {

        int[] heights = new int[11];
        Random random = new Random();

        // Generate random heights (150–250 cm)
        for (int i = 0; i < heights.length; i++)
            heights[i] = 150 + random.nextInt(101);

        System.out.println("Player Heights:");
        for (int h : heights)
            System.out.print(h + " ");

        System.out.println("\nShortest Height: " + findShortest(heights));
        System.out.println("Tallest Height: " + findTallest(heights));
        System.out.println("Mean Height: " + calculateMean(heights));
    }
}
