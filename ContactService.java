package org.example;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // In-memory store of contacts keyed by their unique ID
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if (contacts.containsKey(contact.getID())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getID(), contact);
    }

    public void deleteContact(String ID) {
        if (!contacts.containsKey(ID)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(ID);
    }

    public void updateFirstName(String ID, String firstName) {
        getContact(ID).setFirstName(firstName);
    }

    public void updateLastName(String ID, String lastName) {
        getContact(ID).setLastName(lastName);
    }

    public void updateNumber(String ID, String number) {
        getContact(ID).setNumber(number);
    }

    public void updateAddress(String ID, String address) {
        getContact(ID).setAddress(address);
    }

    public Contact getContact(String ID) {
        Contact contact = contacts.get(ID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        return contact;
    }
}
