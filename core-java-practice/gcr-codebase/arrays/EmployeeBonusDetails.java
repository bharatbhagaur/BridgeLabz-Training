import java.util.Scanner;

public class EmployeeBonusDetails {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int empCount = 10;

        double[] salaryArr = new double[empCount];
        double[] serviceArr = new double[empCount];
        double[] bonusArr = new double[empCount];
        double[] finalSalaryArr = new double[empCount];

        double totalBonus = 0;
        double totalSalary = 0;
        double totalFinalSalary = 0;

        // Taking employee details
        for (int i = 0; i < empCount; i++) {

            System.out.print("Enter salary of employee " + (i + 1) + ": ");
            double sal = sc.nextDouble();

            System.out.print("Enter years of service of employee " + (i + 1) + ": ");
            double yrs = sc.nextDouble();

            if (sal <= 0 || yrs < 0) {
                System.out.println("Invalid input, please enter again");
                i--;
                continue;
            }

            salaryArr[i] = sal;
            serviceArr[i] = yrs;
        }

        // Calculating bonus and new salary
        for (int i = 0; i < empCount; i++) {

            if (serviceArr[i] > 5) {
                bonusArr[i] = salaryArr[i] * 0.05;
            } else {
                bonusArr[i] = salaryArr[i] * 0.02;
            }

            finalSalaryArr[i] = salaryArr[i] + bonusArr[i];

            totalBonus += bonusArr[i];
            totalSalary += salaryArr[i];
            totalFinalSalary += finalSalaryArr[i];
        }

        System.out.println("\n----- Salary Report -----");
        System.out.println("Total bonus given is: " + totalBonus);
        System.out.println("Total old salary was: " + totalSalary);
        System.out.println("Total new salary now is: " + totalFinalSalary);

        sc.close();
    }
}

