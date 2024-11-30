import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InterestCalculator interestCalculator = new InterestCalculator();
        double initialCapital = 0.0;
        int duration = 0;
        double interestRate = 0.00;

        System.out.println("How much money (in Euro) would you like to invest?");
        try{
            initialCapital = interestCalculator.validateInitialCapital(scanner.nextDouble());
        }catch(InvalidInitialCapitalException e){
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("How long would you like to invest that money for (in years)?");
        try{
            duration = interestCalculator.validateDuration(scanner.nextInt());
        }catch(InvalidDurationException e){
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("How risky should your investment be? Please enter 1 for low risk (interest rate of 2.5 percent), 2 for medium risk (interest rate of 7 percent) or 3 for high risk (interest rate of 15 percent).");
        int risk = scanner.nextInt();
        try {
            interestRate = interestCalculator.determineInterestRate(risk);
        } catch(InvalidRiskException e) {
            System.out.println(e.getMessage());
            return;
        }

        double finalEquity = interestCalculator.calculateEquityAfterInterest(initialCapital, duration, interestRate);
        System.out.printf("If you invest %.2f Euro for %d years with an interest rate of %.2f, your final equity could be up to %.2f.",
                initialCapital, duration, interestRate, finalEquity);

    }
}