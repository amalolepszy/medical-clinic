package pl.wsb.lab;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientRegistry {
    private List<Patient> patients;

    public PatientRegistry() {
        this.patients = new ArrayList<>();
    }

    public void addPatient(String firstName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String eMail) {
        Patient newPatient = new Patient(firstName, lastName, pesel, birthDate, phoneNumber, eMail);
        patients.add(newPatient);
    }
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public Patient findPatientByPesel(String pesel) {
        for (Patient patient : patients) {
            if (patient.getPesel() == pesel) {
                return patient;
            }
        }
        return null;
    }

    public List<Patient> findPatientsByLastName(String lastName) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getLastName().equalsIgnoreCase(lastName)){
                result.add(patient);
            }
        }
        return result;
    }

    public List<Patient> getAllPatients() {
        return patients;
//        return new ArrayList<>(patients);
    }
}
