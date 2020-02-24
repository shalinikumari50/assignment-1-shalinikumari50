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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ContactList getContactList() {
        return contactList;
    }

    public void setContactList(ContactList contactList) {
        this.contactList = contactList;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
