public class NumberCheckerDivisors {

    public static boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++)
            if (number % i == 0)
                sum += i;
        return sum == number;
    }

    public static boolean isAbundant(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++)
            if (number % i == 0)
                sum += i;
        return sum > number;
    }

    public static boolean isDeficient(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++)
            if (number % i == 0)
                sum += i;
        return sum < number;
    }

    public static boolean isStrong(int number) {
        int original = number;
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += factorial(digit);
            number /= 10;
        }
        return sum == original;
    }

    static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++)
            fact *= i;
        return fact;
    }
}

