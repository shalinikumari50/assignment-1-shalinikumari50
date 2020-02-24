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
}
