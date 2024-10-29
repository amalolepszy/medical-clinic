package pl.wsb.lab;

import java.time.LocalDate;
import java.util.List;

public class Clinic {

    private List<Patient> patients;

    public Patient createPatientProfile(String firstName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String eMail) {
        Patient newPatient = new Patient(firstName, lastName, pesel, birthDate, phoneNumber, eMail);
        this.patients.add(newPatient);
        return newPatient;
    }

    public Patient getPatientByPesel(String pesel) {
        // your implementation
        return null;
    }
}
