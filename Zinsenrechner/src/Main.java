import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double initialCapital = readDouble("How much money (in Euro) would you like to invest?");
        int duration = readInt("How long would you like to invest that money for (in years)?");
        int risk = readInt("How risky should your investment be? Please enter 1 for low risk (interest rate of 2.5 percent), 2 for medium risk (interest rate of 7 percent) or 3 for high risk (interest rate of 15 percent).");

        double interestRate = fetchInterestRate(risk);

        double finalEquity = calculateEquityAfterInterest(initialCapital, duration, interestRate);

        System.out.printf("If you invest %.2f Euro for %d years with an interest rate of %.2f, your final equity will be %.2f.",
                initialCapital, duration, interestRate, finalEquity);

    }


    private static double calculateEquityAfterInterest(double initialCapital, int duration, double interestRate) {
        double finalCapital = initialCapital * Math.pow((1 + interestRate/100), duration);
        return finalCapital;
    }

    private static double readDouble(String caption) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(caption);
        return scanner.nextDouble();
    }

    private static int readInt(String caption) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(caption);
        return scanner.nextInt();
    }

    private static double fetchInterestRate(int risk){
        double interestRate = switch (risk) {
            case 1 -> 2.5;
            case 2 -> 7;
            case 3 -> 15;
            default -> 0;
        };

        return interestRate;
    }
}
