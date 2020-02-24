package contactList;

import contactNumber.ContactNumber;
import myLinkedList.MyLinkedList;
import node.Node;
import validInputs.ValidInputs;

import java.util.regex.Pattern;

public class ContactList extends MyLinkedList<ContactNumber> {
    private static ValidInputs validInputs;

    static {
        validInputs = new ValidInputs();
    }

    public Node<ContactNumber> enterContactNumber() {
        System.out.println("Contact Number: ");
        String contactNumber = validInputs.inputValidString();
        //contact number must be 10 digit number
        //contact number can begin with 9,8,7 or 6
        //contact number can have additional initial codes 0 or 91
        boolean matches = Pattern.matches("(0|(91))?[9876][0-9]{9}", contactNumber);
        while (!matches) {
            System.out.println("Enter a valid 10 digit phone number or 'q' to return to menu.\n" +
                    "Don't enter any spaces or special characters!");
            contactNumber = validInputs.inputValidString();
            if (contactNumber.equals("q")) {
                return null;
            }
            matches = Pattern.matches("(0|(91))?[9876][0-9]{9}", contactNumber);
        }
        if (contactNumber.length() == 12) {
            contactNumber = contactNumber.substring(2);
        } else if (contactNumber.length() == 11) {
            contactNumber = contactNumber.substring(1);
        }
        return new Node<>(new ContactNumber(contactNumber));

    }

    public int displayContactNumbers() {
        if (getHead() == null) {
            System.out.println("No contact numbers!");
            return -1;
        }
        System.out.println("Here are all the contact numbers: ");
        return display();
    }

    public int addContactNumber() {
        Node<ContactNumber> contactEntered = enterContactNumber();
        if (contactEntered == null) {
            return -1;
        }
        if (matchFound(contactEntered.toString())) {
            System.out.println("This contact is already added!");
            return 0;
        }
        insertInAlphabeticOrder(contactEntered);
        System.out.println("Contact number added!");
        return 0;
    }

    public int deleteContactNumber(int countOfContacts) {
        if (countOfContacts == 1) {
            System.out.println("Cannot delete the only contact available!");
            return -1;
        }
        System.out.println("Press the number against the contact to delete it :");
        int contactNumberToEdit = validInputs.inputValidInteger(countOfContacts);
        if (contactNumberToEdit == -1) {
            return -1;
        }
        System.out.println("Do you really want to delete " + getNode(contactNumberToEdit) + "? (y/n) :");
        if (validInputs.inputValidChoice('y', 'n') == 'y') {
            delete(contactNumberToEdit);
            System.out.println("Contact number deleted!");
        }
        return 0;
    }

    public int editContactNumber(int countOfContacts) {
        System.out.println("Press the number against the contact to edit it:");
        int contactNumberToEdit = validInputs.inputValidInteger(countOfContacts);
        if (contactNumberToEdit == -1) {
            return -1;
        }
        Node<ContactNumber> contactEntered = enterContactNumber();
        if (contactEntered == null) {
            return -1;
        }
        delete(contactNumberToEdit);
        insertInAlphabeticOrder(contactEntered);
        System.out.println("Contact number edited!");
        return 0;
    }

    public int editMenu() {
        int countOfContacts = displayContactNumbers();
        System.out.println("press:\n" +
                "'a' - to add a contact number\n" +
                "'d' - to delete a contact number\n" +
                "'e' - to edit a contact number\n" +
                "'q' - to return to menu");
        char userChoice = validInputs.inputValidChoice('a', 'd', 'e', 'q');
        if (userChoice == 'e') {
            return editContactNumber(countOfContacts);
        } else if (userChoice == 'd') {
            return deleteContactNumber(countOfContacts);
        } else if (userChoice == 'a') {
            return addContactNumber();
        }
        return -1;
    }

}
