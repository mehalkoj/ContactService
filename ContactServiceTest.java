package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactServiceTest {


    // Requirement: add contacts with a unique ID
    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Smith", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1"));
    }

    @Test
    public void testAddDuplicateIdFails() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "John", "Smith", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () ->
                service.addContact(new Contact("1", "Jane", "Doe", "0987654321", "456 Oak Ave")));
    }

    // Requirement: delete contacts per contact ID
    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "John", "Smith", "1234567890", "123 Main St"));
        service.deleteContact("1");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("1"));
    }

    @Test
    public void testDeleteMissingContactFails() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99"));
    }

    // Requirement: update updatable fields per contact ID
    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "John", "Smith", "1234567890", "123 Main St"));
        service.updateFirstName("1", "Jane");
        assertEquals("Jane", service.getContact("1").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "John", "Smith", "1234567890", "123 Main St"));
        service.updateLastName("1", "Doe");
        assertEquals("Doe", service.getContact("1").getLastName());
    }

    @Test
    public void testUpdateNumber() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "John", "Smith", "1234567890", "123 Main St"));
        service.updateNumber("1", "0987654321");
        assertEquals("0987654321", service.getContact("1").getNumber());
    }

    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "John", "Smith", "1234567890", "123 Main St"));
        service.updateAddress("1", "456 Oak Ave");
        assertEquals("456 Oak Ave", service.getContact("1").getAddress());
    }
}
