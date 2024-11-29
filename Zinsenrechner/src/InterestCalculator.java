public class InterestCalculator {

    //***Method is used in Main to determine the interest rate based on the risk class input***
    double determineInterestRate(int risk){
        double interestRate = switch (risk) {
            case 1 -> 2.5;
            case 2 -> 7;
            case 3 -> 15;
            default -> 0;
        };

        return interestRate;
    }

    //***Method is used in Main to calculate the final max-capital after interest gains.***

    //+++initialCapital+++
    //1) gültige Äquivalenzklasse: 100.00 bis 10000000.00 --> Konkrete Testfälle: 99.99, 100.00, 100.01, 9999999.99, 10000000.00, 10000000.01, mehr als 2 Nachkommastellen werden in der Eingabe aber akzeptiert
    //2) ungültige Äquivalenzklasse: alles, was sich nicht in diesem Bereich befindet

    //+++duration+++
    //1) gültige Äquivalenzklasse: 1 bis 30 Jahre --> Konkrete Testfälle: 0, 1, 2, 29, 30, 31
    //2) ungültige Äquivalenzklasse: alles, was sich nicht in diesem Bereich befindet.

    //+++interestRate+++
    //1) gültige Äquivalenzklasse: [2.5, 7, 15] --> Konkrete Testfälle: 2, 2.5, 5, 7, 10.5, 15, 15.5
    //2) ungültige Äquivalenzklasse: jede Zahl, die NICHT 2.5, 7 oder 15 ist.

    double calculateEquityAfterInterest(double initialCapital, int duration, double interestRate) {

        //TODO: Hier einen Check einbauen, dass nur Zahlen >=100 und <=10.000.000!
        double finalCapital = initialCapital * Math.pow((1 + interestRate/100), duration);
        return finalCapital;
    }
}
