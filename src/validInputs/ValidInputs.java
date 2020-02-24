package validInputs;

import myNoInputException.MyNoInputException;

import java.util.Scanner;

public class ValidInputs {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public void isEmpty(String inputFromUser) throws MyNoInputException {
        if (inputFromUser.equals("")) {
            throw new MyNoInputException("Enter a valid input");
        }
    }
}
