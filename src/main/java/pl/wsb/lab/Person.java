package pl.wsb.lab;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private final String firstName;
    private final String lastName;
    private final String pesel;
    private final LocalDate birthDate; // YYYY-MM-DD
    private final String phoneNumber;
    private final String eMail;

    public Person(String firstName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int calculateAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEMail() {
        return eMail;
    }

    public String toString() {
        return "Name: " + getFirstName() + "\n" + "Last Name: " + getLastName() + "\n" + "PESEL: " + getPesel() + "\n" + "Date of birth: " + getBirthDate() + "\n" + "age: " + calculateAge() + "\n" + "Phone number: " + getPhoneNumber() + "\n" + "Email address: " + getEMail();
    }
}
