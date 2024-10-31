import java.util.Scanner;

public class InputScanner {

    //***Method is used in Main to: read value of starting capital (in Euro as a double).***
    double readDouble(String caption) throws wrongInputException {
        double value = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println(caption);

        try{
            value = scanner.nextDouble();
        } catch (Exception e){
            throw new wrongInputException("Wrong input: please enter a positive number between 100,00 and 10.000.000,00 EURO.");
        }
        return value;
    }


    //*** Method is used in Main to: ***
    //**    1) read input of duration of investment (as an integer value for calendar years)**
    //**    2) read input of risk class (as an integer value from 1-3)**
    int readInt(String caption) throws wrongInputException{
        int value = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println(caption);

        try{
            value = scanner.nextInt();
        } catch (Exception e){
            throw new wrongInputException("Wrong input: please enter an integer value.");
        }
        return value;
    }
}
