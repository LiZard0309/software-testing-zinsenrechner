import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class InterestCalculatorTest {


    InterestCalculator interestCalculator = new InterestCalculator();

    //~~~~~~~~ Tests for determineInterestRate() ~~~~~~~~~~

    //+++Equivalence Classes for input parameter "risk"+++
    //1) valid Equivalence Class: numbers (integer) from 1 to 3 --> concrete test cases: 0, 1, 3, 4
    //2) invalid Equivalence Classes: everything else that is not in this range. --> test cases are covered by valid equivalence class.
    //Note: testing for invalid String input is not necessary due to scanner.nextInt() method.

    @ParameterizedTest
    @DisplayName("Interest Rate - Valid Cases")
    @CsvSource({
            "1, 2.5",
            "2, 7.0",
            "3, 15.0"
    })
    void determineInterestRateValidCases(int input, double expected) {

        double actual = 0;

        try {
            actual = interestCalculator.determineInterestRate(input);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Interest Rate - Invalid Cases")
    @CsvSource({
            "0",
            "4"
    })
    void determineInterestRateInvalidCases(int input) {
        InvalidRiskException e = assertThrows(InvalidRiskException.class, () -> interestCalculator.determineInterestRate(input));

        String actual = e.getMessage();
        String expected = "Invalid input: Please enter a number from 1 to 3.";
        assertTrue(actual.contains(expected));
    }


    //~~~~~~~~ Tests for validateInitialCapital() ~~~~~~~~~~

    //+++Equivalence Classes for input parameter "initial capital"+++
    //1) valid EC: Double with two digits after the decimal point, ranging from 100.00 to 10000000.00
    // --> Test Cases - concrete values: 99.99, 100.00, 100.01, 9999999.99, 10000000.00, 10000000.01
    // More than two digits after the decimal point can be entered too (but should be invalidated later)
    //2) invalid EC: everything outside of this range --> Test cases already covered in valid EC + 99.999, 10000000.001 (to test digits after comma validation)
    //Note: testing for invalid String input is not necessary due to scanner.nextDouble() method.

    @ParameterizedTest
    @DisplayName("Initial Capital - Valid Cases")
    @CsvSource({
            "100.00, 100.00",
            "100.01, 100.01",
            "9999999.99, 9999999.99",
            "10000000.00, 10000000.00"
    })
    void validateInitialCapitalValidCases(double input, double expected) {

        double actual = 0;

        try {
            actual = interestCalculator.validateInitialCapital(input);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Initial Capital - Invalid Cases")
    @CsvSource({
            "99.99",
            "99.999",
            "10000000.001",
            "10000000.01"
    })
    void validateInitialCapitalInvalidCases(double input) {
        InvalidInitialCapitalException e = assertThrows(InvalidInitialCapitalException.class, () -> interestCalculator.validateInitialCapital(input));
        assertEquals("The capital to invest must be a value between 100,00 and 10.000.000,00 EURO and must not have more than 2 decimals.", e.getMessage());
    }


    //~~~~~~~~ Tests for validateDuration() ~~~~~~~~~~
    //+++Equivalence Classes for input parameter "duration"+++
    //1) Valid equivalence class: 1 to 30 years --> concrete test cases: 0, 1, 2, 29, 30, 31
    //2) Invalid equivalence class: everything else that is not in this range. --> test cases are covered by valid equivalence class.
    //Note: testing for invalid String input is not necessary due to scanner.nextInt() method.

    @ParameterizedTest
    @DisplayName("Duration - Valid Cases")
    @CsvSource({
            "1, 1",
            "2, 2",
            "29, 29",
            "30, 30"
    })
    void validateDuration(int input, int expected) {

        int actual = 0;

        try {
            actual = interestCalculator.validateDuration(input);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Duration - Invalid Cases")
    @CsvSource({
            "0",
            "31"
    })
    void validateDurationInvalidCases(int input) {
        InvalidDurationException e = assertThrows(InvalidDurationException.class, () -> interestCalculator.validateDuration(input));
        assertEquals("The duration of investment has to be at least a year and can go up to 30 years. Investments are only possible for full years.", e.getMessage());
    }


    //~~~~~~~~ Tests for calculateEquityAfterInterest() ~~~~~~~~~~

    //+++About Equivalence Classes for input parameters:+++
    //initialCapital, duration and validatedInterestRate are either explicitly or implicitly (in case of interestRate) validated by validateInitialCapital(), validateDuration() and determineInterestRate()+++
    //--> Those values don't need to be tested again because only valid values can be passed to calculateEquityAfterInterest.

    //Logical test case --> equals the result of the formula for compound interest: Amount = Principal (1 + Interest rate/100) to the power of Time in years
    //Concrete test case --> inputs: initialCapital = 100; duration = 10 years; validatedInterestRate = 2.5 --> expected output finalCapital = 128,01

    @Test
    @DisplayName("Final Equity")
    void calculateEquityAfterInterest() {

        //assign
        double inputCapital = 100.00;
        int inputDuration = 10;
        double inputValidatedInterestRate = 2.5;
        double expected = 128.01;

        //act
        double actual = 0.00;
        try {
            actual = interestCalculator.calculateEquityAfterInterest(inputCapital, inputDuration, inputValidatedInterestRate);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        //assert
        assertEquals(expected, actual);
    }
}