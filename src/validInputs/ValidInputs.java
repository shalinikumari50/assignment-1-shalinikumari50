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

    public String inputValidString() {
        String inputFromUser;
        while (true) {
            inputFromUser = scanner.nextLine().trim();

            try {
                // check if user directly pressed enter key
                isEmpty(inputFromUser);
            } catch (MyNoInputException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return inputFromUser;
        }
    }

    public char inputValidChar() {
        char input;
        while (true) {
            String inputFromUser = inputValidString();

            //check if user entered more than one character i.e. a string instead of a character
            if (inputFromUser.length() > 1) {
                System.out.println("Enter a single character");
                continue;
            }
            input = inputFromUser.charAt(0);
            return input;
        }
    }
}
