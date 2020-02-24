package contactApp;

import contactList.ContactList;
import myLinkedList.MyLinkedList;
import person.Person;
import validInputs.ValidInputs;

import java.util.regex.Pattern;

public class ContactApp {
    private static ValidInputs validInputs;

    static {
        validInputs = new ValidInputs();
    }

    private MyLinkedList<Person> personMyLinkedList;

    public ContactApp() {
        personMyLinkedList = new MyLinkedList<>();
    }

    public String enterName() {
        while (true) {
            System.out.println("Please enter the name of the Person");
            System.out.println("First Name: ");
            String firstName = validInputs.inputValidName();
            if (firstName == null) {
                return null;
            }
            System.out.println("Last Name: ");
            String lastName = validInputs.inputValidName();
            if (lastName == null) {
                return null;
            }
            if (personMyLinkedList.matchFound(firstName + " " + lastName)) {
                System.out.println("Contact with this name already exists!");
                System.out.println("To try again with a different name, enter 't' or to return to menu, enter 'q'");
                char choice = validInputs.inputValidChoice('q', 't');
                if (choice == 'q') {
                    return null;
                } else {
                    continue;
                }
            }
            return firstName + " " + lastName;
        }
    }

    public ContactList enterContactList() {
        ContactList contactList = new ContactList();
        char choice = 'y';
        int flag = 0;
        while (choice != 'n') {
            if (contactList.addContactNumber() == -1) {
                if (flag == 0) {
                    return null;
                }
                return contactList;
            }
            flag = 1;
            System.out.println("Would you like to add another contact number? (y/n):");
            choice = validInputs.inputValidChoice('y', 'n');
        }
        return contactList;
    }

    public String enterEmail() {
        String emailAddress;
        System.out.println("Email Address: ");
        emailAddress = validInputs.inputValidString();
        String regex = "(?:[a-zA-Z0-9]+[._-])*[a-zA-Z0-9]+@(?:[a-zA-Z0-9]+[._-])*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}";
        boolean matches = Pattern.matches(regex, emailAddress);
        while (!matches) {
            System.out.println("Enter a valid email address or 'q' to skip email address entry");
            emailAddress = validInputs.inputValidString();
            if (emailAddress.equals("q")) {
                return null;
            }
            matches = Pattern.matches(regex, emailAddress);
        }
        return emailAddress;
    }
}
