package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {


    @Test
    public void testValidContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

    // ID requirement: not null, no longer than 10 characters
    @Test
    public void testIdTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testIdNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
    }

    // ID requirement: not updatable (no setter exists, so it stays the same)
    @Test
    public void testIdIsNotUpdatable() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1", contact.getID());
    }

    // firstName requirement: not null, no longer than 10 characters
    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "ThisIsTooLong", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", null, "Doe", "1234567890", "123 Main St"));
    }

    // lastName requirement: not null, no longer than 10 characters
    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "ThisIsTooLong", "1234567890", "123 Main St"));
    }

    @Test
    public void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", null, "1234567890", "123 Main St"));
    }

    // phone (Number) requirement: not null, exactly 10 digits
    @Test
    public void testNumberNotTenDigits() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe", "12345", "123 Main St"));
    }

    @Test
    public void testNumberNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe", null, "123 Main St"));
    }

        // phone (Number) requirement: they must be digits
    @Test
    public void testNumberNotDigits() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe", "12345abcde", "123 Main St"));
    }

    // address requirement: not null, no longer than 30 characters
    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe", "1234567890",
                        "This address is definitely longer than thirty characters"));
    }

    @Test
    public void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1", "John", "Doe", "1234567890", null));
    }
}
