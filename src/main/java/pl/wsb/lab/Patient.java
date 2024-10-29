package pl.wsb.lab;

import java.time.LocalDate;
import java.time.Period;

public class Patient {

    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDate birthDate; // YYYY-MM-DD
    private String phoneNumber;
    private String eMail;

    public Patient(String firsName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String eMail) {
        this.firstName = firsName;
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
}
