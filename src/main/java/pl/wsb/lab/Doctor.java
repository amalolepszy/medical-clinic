package pl.wsb.lab;

import java.time.LocalDate;
import java.util.List;

public class Doctor extends Person {
    private static int NextID = 1;
    private int doctorID;
    private List<String> specialization;

    public Doctor(String firstName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String eMail, List<String> specialization) {
        super(firstName, lastName, pesel, birthDate, phoneNumber, eMail);
        this.doctorID = NextID++;
        this.specialization = specialization;
    }

    public String toString() {
        return "Doctor ID: " + doctorID + "\n" +
                "Name: " + getFirstName() + "\n" +
                "Last Name: " + getLastName() + "\n" +
                "Pesel: " + getPesel() + "\n" +
                "Date of birth: " + getBirthDate() + "\n" +
                "age: " + calculateAge() + "\n" +
                "Phone number: " + getPhoneNumber() + "\n" +
                "Email address: " + getEMail() + "\n" +
                "Specjalization: " + String.join(", ", specialization);
    }


    public int getDoctorID() {
        return doctorID;
    }

    public List<String> getSpecialization() {
        return specialization;
    }

}
