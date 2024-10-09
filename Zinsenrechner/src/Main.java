import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }

    // Jetzt brauchen wir noch eine Funktion, die uns das Risikolevel in einen Zinssatz umwandelt. Evtl. ein switch mit cases?

    private static double calculateEquityAfterInterest(double initialCapital, int duration, double interestRate) {
        double finalCapital = initialCapital * Math.pow((1 + interestRate/100), duration);
        return finalCapital;
    }

    private static double readDouble(String caption) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(caption);
        return scanner.nextDouble();
    }

}
