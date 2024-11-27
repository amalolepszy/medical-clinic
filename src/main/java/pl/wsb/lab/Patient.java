package pl.wsb.lab;

import java.time.LocalDate;

class Patient extends Person {
    public Patient(String firstName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String eMail) {
        super(firstName, lastName, pesel, birthDate, phoneNumber, eMail);
    }
}