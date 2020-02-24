package person;

import contactList.ContactList;

public class Person {
    private String firstName;
    private String lastName;
    private ContactList contactList;
    private String emailAddress;

    public Person(String firstName, String lastName, ContactList contactList, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactList = contactList;
        this.emailAddress = emailAddress;
    }
}
