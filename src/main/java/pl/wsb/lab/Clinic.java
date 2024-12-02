package pl.wsb.lab;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


public class Clinic {
    private DoctorRegistry doctorRegistry;
    private PatientRegistry patientRegistry;

    // 1.1
    public void createPatientProfile(String firstName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String eMail) {
        if (patientRegistry.findPatientByPesel(pesel) != null) {
            throw new IllegalArgumentException("Patient with given PESEL already exists.");
        }
        patientRegistry.addPatient(firstName, lastName, pesel, birthDate, phoneNumber, eMail);
    }

    // 1.2
    public String getPatientInfoByPesel(String pesel) {
        Patient patient = patientRegistry.findPatientByPesel(pesel);
        if (patient == null) {
            throw new IllegalArgumentException("Patient with given PESEL doesn't exist.");
        }
        return patient.toString();
    }

    // 1.3
    public String getPatientsInfoByLastName(String lastName) {
        List<Patient> found_patients = patientRegistry.findPatientsByLastName(lastName);
        if (found_patients.isEmpty()) {
            throw new IllegalArgumentException("There are no patients with given last name.");
        }

        String result = "-Patients-\n";
        for (Patient patient : found_patients) {
            result += patient.toString();
            result += "\n-----------------------------------------\n";
        }
        return result;
    }

    // 2.1
    public void createDoctorProfile(String firstName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String eMail, Set<String> specialization) {
        doctorRegistry.addDoctor(firstName, lastName, pesel, birthDate, phoneNumber, eMail, specialization);
    }

    // 2.2
    public void addSpecializationForDoctor(int doctorId, String specialization) {
        Doctor doctor = doctorRegistry.findDoctorById(doctorId);
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor with given ID doesn't exist: '" + doctorId + "'.");
        }
        if (doctor.getSpecialization().contains(specialization)) {
            throw new IllegalArgumentException("Doctor already has given specialization: '" + specialization + "'.");
        }
        doctor.getSpecialization().add(specialization);

    }

    // 2.3
    public String getDoctorInfoById(int doctorId) {
        Doctor doctor = doctorRegistry.findDoctorById(doctorId);
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor with given ID doesn't exist: '" + doctorId + "'.");
        }
        return doctor.toString();
    }

    // 2.4
    public String getDoctorsInfoBySpecialization(String specialization) {
        List<Doctor> found_doctors = doctorRegistry.findDoctorsBySpecialization(specialization);
        if (found_doctors.isEmpty()) {
            throw new IllegalArgumentException("There are no doctors with given specialization.");
        }
        String result = "";
        result = "-Doctors-\n";
        for (Doctor doctor : found_doctors) {
            result += doctor.toString();
            result += "\n-----------------------------------------\n";
        }
        return result;
    }

}
