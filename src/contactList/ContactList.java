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
}
