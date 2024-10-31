import java.util.Scanner;

public class InterestCalculator {

    //***Method is used in Main to determine the interest rate based on the risk class input***
    double fetchInterestRate(int risk){
        double interestRate = switch (risk) {
            case 1 -> 2.5;
            case 2 -> 7;
            case 3 -> 15;
            default -> 0;
        };

        return interestRate;
    }

    //***Method is used in Main to calculate the final max-capital after interest gains.***
    double calculateEquityAfterInterest(double initialCapital, int duration, double interestRate) {
        double finalCapital = initialCapital * Math.pow((1 + interestRate/100), duration);
        return finalCapital;
    }
}
