import java.util.Scanner;

class YoungTallFriend {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] friends = {"Aman", "Rohit", "Sahil"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Taking age and height of friends
        for (int i = 0; i < friends.length; i++) {
            System.out.println("Enter age for " + friends[i]);
            ages[i] = sc.nextInt();

            System.out.println("Enter height for " + friends[i]);
            heights[i] = sc.nextDouble();
        }

        int youngIndex = 0;
        int tallIndex = 0;

        // Checking youngest and tallest friend
        for (int i = 1; i < friends.length; i++) {

            if (ages[i] < ages[youngIndex]) {
                youngIndex = i;   // updating youngest
            }

            if (heights[i] > heights[tallIndex]) {
                tallIndex = i;   // updating tallest
            }
        }

        System.out.println("Youngest friend is: " + friends[youngIndex] +
                           " and age is " + ages[youngIndex]);

        System.out.println("Tallest friend is: " + friends[tallIndex] +
                           " and height is " + heights[tallIndex]);

        sc.close();
    }
}

