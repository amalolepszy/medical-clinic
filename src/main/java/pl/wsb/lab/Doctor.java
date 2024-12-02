package pl.wsb.lab;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Doctor extends Person {
    private int doctorID;
    private Set<String> specialization;

    public Doctor(String firstName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String eMail, int doctorId, Set<String> specialization) {
        super(firstName, lastName, pesel, birthDate, phoneNumber, eMail);
        this.doctorID = doctorId;
        this.specialization = new TreeSet<>();
        this.specialization.addAll(specialization);
    }

    @Override
    public String toString() {
        return "Doctor ID: " + doctorID + "\n" + super.toString() + "\nSpecialization: " + String.join(", ", specialization);
    }


    public int getDoctorID() {
        return doctorID;
    }

    public Set<String> getSpecialization() {
        return specialization;
    }

}
