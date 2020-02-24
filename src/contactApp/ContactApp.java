package contactApp;

import myLinkedList.MyLinkedList;
import person.Person;
import validInputs.ValidInputs;

public class ContactApp {
    private static ValidInputs validInputs;

    static {
        validInputs = new ValidInputs();
    }

    private MyLinkedList<Person> personMyLinkedList;

    public ContactApp() {
        personMyLinkedList = new MyLinkedList<>();
    }
}
