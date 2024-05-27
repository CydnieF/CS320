package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Contact;
import main.ContactService;

class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
        // Reset the existingContactIDs set before each test
        Contact.removeContactID("1");
        Contact.removeContactID("2");
        Contact.removeContactID("3");
    }

    @Test
    public void testAddContact() {
        contactService.addContact("1", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(contactService.getContact("1"));
    }

    @Test
    public void testAddContactDuplicateID() {
        contactService.addContact("1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact("1", "Jane", "Smith", "0987654321", "456 Elm St");
        });
    }

    @Test
    public void testDeleteContact() {
        contactService.addContact("2", "John", "Doe", "1234567890", "123 Main St");
        contactService.deleteContact("2");
        assertNull(contactService.getContact("2"));
    }

    @Test
    public void testDeleteContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("3");
        });
    }

    @Test
    public void testUpdateFirstName() {
        contactService.addContact("3", "John", "Doe", "1234567890", "123 Main St");
        contactService.updateFirstName("3", "Jane");
        assertEquals("Jane", contactService.getContact("3").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        contactService.addContact("3", "John", "Doe", "1234567890", "123 Main St");
        contactService.updateLastName("3", "Smith");
        assertEquals("Smith", contactService.getContact("3").getLastName());
    }

    @Test
    public void testUpdatePhoneNumber() {
        contactService.addContact("3", "John", "Doe", "1234567890", "123 Main St");
        contactService.updatePhoneNumber("3", "0987654321");
        assertEquals("0987654321", contactService.getContact("3").getPhoneNumber());
    }

    @Test
    public void testUpdateAddress() {
        contactService.addContact("3", "John", "Doe", "1234567890", "123 Main St");
        contactService.updateAddress("3", "456 Elm St");
        assertEquals("456 Elm St", contactService.getContact("3").getAddress());
    }

    @Test
    public void testUpdateContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("4", "Jane");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("4", "Smith");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhoneNumber("4", "0987654321");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("4", "456 Elm St");
        });
    }

    @Test
    public void testGetContactNotFound() {
        assertNull(contactService.getContact("5"));
    }
}
