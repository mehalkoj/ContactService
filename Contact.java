package org.example;


public class Contact {
    private final String ID;
    private String firstName;
    private String lastName;
    private String number;
    private String address;

    public Contact(String ID, String firstName, String lastName, String number, String address) {
        if (ID == null || ID.length() > 10) {
            throw new IllegalArgumentException("ID must be between 1 and 10 characters");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be between 1 and 10 characters");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be between 1 and 10 characters");
        }
        if (number == null || number.length() != 10) {
            throw new IllegalArgumentException("Number must be exactly 10 digits");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be no longer than 30 characters");
        }

        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
    }

    // No setID method on purpose -> the ID is not updatable
    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be between 1 and 10 characters");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be between 1 and 10 characters");
        }
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number == null || !number.matches("\\d{10}") {
            throw new IllegalArgumentException("Number must be exactly 10 digits");
        }
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be no longer than 30 characters");
        }
        this.address = address;
    }
}
