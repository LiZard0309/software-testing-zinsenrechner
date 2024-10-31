import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws wrongInputException {

        InputScanner inputScanner = new InputScanner();
        InterestCalculator interestCalculator = new InterestCalculator();

        //TODO: Refactor into loop for new calculations until user ends loop

        double initialCapital = inputScanner.readDouble("How much money (in Euro) would you like to invest?");
        int duration = inputScanner.readInt("How long would you like to invest that money for (in years)?");
        int risk = inputScanner.readInt("How risky should your investment be? Please enter 1 for low risk (interest rate of 2.5 percent), 2 for medium risk (interest rate of 7 percent) or 3 for high risk (interest rate of 15 percent).");

        double interestRate = interestCalculator.fetchInterestRate(risk);
        double finalEquity = interestCalculator.calculateEquityAfterInterest(initialCapital, duration, interestRate);

        System.out.printf("If you invest %.2f Euro for %d years with an interest rate of %.2f, your final equity could be up to %.2f.",
                initialCapital, duration, interestRate, finalEquity);

    }
}
