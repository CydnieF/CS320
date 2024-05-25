/*
The contact service shall be able to add contacts with a unique ID.

The contact service shall be able to delete contacts per contact ID.

The contact service shall be able to update contact fields per
contact ID. The following fields are updatable:
firstName
lastName
Number
Address
 */
package main;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Add a new contact
    public void addContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        if (contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        Contact newContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
        contacts.put(contactID, newContact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactID);
        Contact.removeContactID(contactID);  // Remove the ID from the unique ID set
    }

    // Update the first name of a contact by ID
    public void updateFirstName(String contactID, String newFirstName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setFirstName(newFirstName);
    }

    // Update the last name of a contact by ID
    public void updateLastName(String contactID, String newLastName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setLastName(newLastName);
    }

    // Update the phone number of a contact by ID
    public void updatePhoneNumber(String contactID, String newPhoneNumber) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setPhoneNumber(newPhoneNumber);
    }

    // Update the address of a contact by ID
    public void updateAddress(String contactID, String newAddress) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setAddress(newAddress);

    }
}
