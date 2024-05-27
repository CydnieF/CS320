/*
The contact object shall have a required unique contact ID string that cannot be
longer than 10 characters. The contact ID shall not be null and shall not be updatable.

The contact object shall have a required firstName String field that cannot be
longer than 10 characters. The firstName field shall not be null.
The contact object shall have a required lastName String field that cannot be
longer than 10 characters. The lastName field shall not be null.

The contact object shall have a required phone String field that must
be exactly 10 digits. The phone field shall not be null.

The contact object shall have a required address field that must be
no longer than 30 characters. The address field shall not be null.
*/
package main;

import java.util.Set;
import java.util.HashSet;

public class Contact {
    private static final Set<String> existingContactIDs = new HashSet<>();
    private String contactID;  // contactID shouldn't be modified
    private String firstName;
    private String lastName;
    private String number;
    private String address;

    // constructor for Contact
    public Contact (String contactID, String firstName, String lastName, String phoneNumber, String address){
        // contact ID cannot be null or greater than 10
        if (contactID == null || (contactID.length() > 10) || existingContactIDs.contains(contactID)) {
            throw new IllegalArgumentException("Invalid ID");
        }
        // first name cannot be null or greater than 10
        if (firstName == null || (firstName.length() > 10)) {
            throw new IllegalArgumentException("Invalid first name");
        }
        // last name cannot be null or greater than 10
        if (lastName == null || (lastName.length() > 10)) {
            throw new IllegalArgumentException("Invalid last name");
        }
        // phone number cannot be null and must be 10 digits
        if (phoneNumber == null || (phoneNumber.length() != 10)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        // address cannot be null or greater than 30
        if (address == null || (address.length() > 30)) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = phoneNumber;
        this.address = address;

        existingContactIDs.add(contactID);
    }

    public String getContactID() {
        return contactID;
    }
    
    public String getFirstName() {
        return firstName;
    }

    // first name cannot be null or greater than 10
    public void setFirstName(String firstName) {
        if (firstName == null || (firstName.length() > 10)) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || (lastName.length() > 10)) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return number;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || (phoneNumber.length() != 10)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.number = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || (address.length() > 30)) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
    public static void removeContactID (String contactID) {
        existingContactIDs.remove(contactID);
    }
}