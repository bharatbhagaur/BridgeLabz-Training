public class MutualRecursion {

    
    static boolean isEven(int n) {
        if (n == 0) {
            return true;
        }

        return isOdd(n - 1);
    }

    
    static boolean isOdd(int n) {
        if (n == 0) {
            return false;
        }

        return isEven(n - 1);
    }

    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Testing isEven() and isOdd():");

        for (int n = 0; n <= 10; n++) {
            System.out.println(
                n + " -> Even: " + isEven(n) +
                ", Odd: " + isOdd(n)
            );
        }


        System.out.println("\nTrace for isOdd(7):");

        System.out.println("isOdd(7)");
        System.out.println("  -> isEven(6)");
        System.out.println("     -> isOdd(5)");
        System.out.println("        -> isEven(4)");
        System.out.println("           -> isOdd(3)");
        System.out.println("              -> isEven(2)");
        System.out.println("                 -> isOdd(1)");
        System.out.println("                    -> isEven(0)");
        System.out.println("                       -> true");

        System.out.println("\nFinal answer: isOdd(7) = " + isOdd(7));
    }
}