package validInputs;

import myInvalidNameException.MyInvalidNameException;
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

    public String inputValidName() {
        //a valid name contains only alphabets(a-z or A-Z)
        int flag = 0;
        while (true) {
            String input = inputValidString();
            if (input.matches(".*[^a-zA-Z].*")) {
                if (flag == 1 && input.equals("0")) {
                    return null;
                }
                try {
                    throw new MyInvalidNameException("The name should not contain any special characters or digits!");
                } catch (MyInvalidNameException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Enter a valid name or '0' to return to menu");
                flag = 1;
                continue;
            }
            return input;
        }
    }

    // to take a integer as input whose upper bound is specified
    public int inputValidInteger(int count) {
        int number;
        int flag = 0;
        while (true) {
            String numberString = inputValidString();
            if (numberString.equals("q") && flag == 1) {
                return -1;
            }
            try {
                number = Integer.parseInt(numberString);
            } catch (NumberFormatException nfe) {
                System.out.println("Enter valid input or 'q' to return to menu");
                flag = 1;
                continue;
            }

            if (number > count || number < 1) {
                System.out.println("Enter valid number or 'q' to return to menu");
                flag = 1;
                continue;
            }
            return number;
        }
    }

    public char inputValidChoice(char char1, char char2) {
        char choice;
        choice = inputValidChar();
        while (choice != char1 && choice != char2) {
            System.out.println("Enter '" + char1 + "' or '" + char2 + "' to give your response");
            choice = inputValidChar();
        }
        return choice;
    }

    public char inputValidChoice(char char1, char char2, char char3, char char4) {
        char choice;
        choice = inputValidChar();
        while (choice != char1 && choice != char2 && choice != char3 && choice != char4) {
            System.out.println("Enter '" + char1 + "' , '" + char2 + "' , '" + char3 + "' or '" + char4 + "' to give your response");
            choice = inputValidChar();
        }
        return choice;
    }
}
