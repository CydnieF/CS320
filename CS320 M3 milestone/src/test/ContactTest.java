package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Contact;

class ContactTest {

    @BeforeEach
    void setUp() {
        // Clear the existingContactIDs set before each test to avoid state issues
        Contact.removeContactID("1234512345");
        Contact.removeContactID("0987654321");
        Contact.removeContactID("12345123456");
    }

    @Test
    void testContactClass() {
        Contact contact = new Contact("1234512345", "Cydnie", "Fisher", "1234512345", "123 Fake Address");
        assertEquals("1234512345", contact.getContactID());
        assertEquals("Cydnie", contact.getFirstName());
        assertEquals("Fisher", contact.getLastName());
        assertEquals("1234512345", contact.getPhoneNumber());
        assertEquals("123 Fake Address", contact.getAddress());
    }

    @Test
    void testContactClassIDTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234512345", "Cydnie", "Fisher", "1234512345", "123 Fake Address");
        });
    }

    @Test
    void testContactClassIDNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Cydnie", "Fisher", "1234512345", "123 Fake Address");
        });
    }

    @Test
    void testContactClassFirstNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234512345", "Cydnienametoolong", "Fisher", "1234512345", "123 Fake Address");
        });
    }

    @Test
    void testContactClassFirstNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234512345", null, "Fisher", "1234512345", "123 Fake Address");
        });
    }

    @Test
    void testContactClassLastNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234512345", "Cydnie", "Fisherslastnameistoolong", "1234512345", "123 Fake Address");
        });
    }

    @Test
    void testContactClassLastNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234512345", "Cydnie", null, "1234512345", "123 Fake Address");
        });
    }

    @Test
    void testContactClassInvalidPhoneNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234512345", "Cydnie", "Fisher", "123451234", "123 Fake Address");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234512345", "Cydnie", "Fisher", "12345123451234", "123 Fake Address");
        });
    }

    @Test
    void testContactClassPhoneNumberNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234512345", "Cydnie", "Fisher", null, "123 Fake Address");
        });
    }

    @Test
    void testContactClassAddressTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234512345", "Cydnie", "Fisher", "1234512345", "123 Fake Address qwertyuiopasdfghjklzxcvbnm");
        });
    }

    @Test
    void testContactClassAddressNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234512345", "Cydnie", "Fisher", "1234512345", null);
        });
    }

    @Test
    void testSetFirstName() {
        Contact contact = new Contact("1234512345", "Cydnie", "Fisher", "1234512345", "123 Fake Address");
        contact.setFirstName("NewName");
        assertEquals("NewName", contact.getFirstName());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("NameTooLong");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @Test
    void testSetLastName() {
        Contact contact = new Contact("1234512345", "Cydnie", "Fisher", "1234512345", "123 Fake Address");
        contact.setLastName("NewLast");
        assertEquals("NewLast", contact.getLastName());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("LastNameTooLong");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    @Test
    void testSetPhoneNumber() {
        Contact contact = new Contact("1234512345", "Cydnie", "Fisher", "1234512345", "123 Fake Address");
        contact.setPhoneNumber("0987654321");
        assertEquals("0987654321", contact.getPhoneNumber());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("1234567"); // Too short
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("123456789012"); // Too long
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber(null);
        });
    }

    @Test
    void testSetAddress() {
        Contact contact = new Contact("1234512345", "Cydnie", "Fisher", "1234512345", "123 Fake Address");
        contact.setAddress("New Address");
        assertEquals("New Address", contact.getAddress());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("Address That Is Way Too Long For This Field To Handle");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    @Test
    void testRemoveContactID() {
        Contact contact = new Contact("1234512345", "Cydnie", "Fisher", "1234512345", "123 Fake Address");
        Contact.removeContactID("1234512345");

        // Ensure we can create a new contact with the same ID after removal
        Contact newContact = new Contact("1234512345", "NewFirst", "NewLast", "0987654321", "New Address");
        assertEquals("1234512345", newContact.getContactID());
    }

    // Additional tests to cover all scenarios
    @Test
    void testContactClassDuplicateID() {
        new Contact("1234512345", "Cydnie", "Fisher", "1234512345", "123 Fake Address");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234512345", "Another", "Person", "0987654321", "Another Address");
        });
    }

    @Test
    void testSetFirstNameInvalid() {
        Contact contact = new Contact("0987654321", "Cydnie", "Fisher", "1234512345", "123 Fake Address");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("TooLongName");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @Test
    void testSetLastNameInvalid() {
        Contact contact = new Contact("0987654321", "Cydnie", "Fisher", "1234512345", "123 Fake Address");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("TooLongLastName");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    @Test
    void testSetPhoneNumberInvalid() {
        Contact contact = new Contact("0987654321", "Cydnie", "Fisher", "1234512345", "123 Fake Address");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("123"); // Too short
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("12345678901"); // Too long
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber(null);
        });
    }

    @Test
    void testSetAddressInvalid() {
        Contact contact = new Contact("0987654321", "Cydnie", "Fisher", "1234512345", "123 Fake Address");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("12345678901234567890123456789012345678901"); // Too long
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }
}
