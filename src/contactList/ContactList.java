package contactList;

import contactNumber.ContactNumber;
import myLinkedList.MyLinkedList;
import validInputs.ValidInputs;

public class ContactList extends MyLinkedList<ContactNumber> {
    private static ValidInputs validInputs;

    static {
        validInputs = new ValidInputs();
    }
}
