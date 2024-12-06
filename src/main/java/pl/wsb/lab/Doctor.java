package pl.wsb.lab;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.TreeSet;

public class Doctor extends Person {
    private int doctorID;
    private Set<String> specialization;
    private DoctorShiftRegistry doctorShiftRegistry;

    public Doctor(String firstName, String lastName, String pesel, LocalDate birthDate, String phoneNumber,
            String eMail, int doctorId, Set<String> specialization) {
        super(firstName, lastName, pesel, birthDate, phoneNumber, eMail);
        this.doctorID = doctorId;
        this.specialization = new TreeSet<>();
        this.specialization.addAll(specialization);
        this.doctorShiftRegistry = new DoctorShiftRegistry();
    }

    @Override
    public String toString() {
        return "Doctor ID: " + doctorID + "\n" + super.toString() + "\nSpecialization: "
                + String.join(", ", specialization);
    }

    public int getDoctorID() {
        return doctorID;
    }

    public Set<String> getSpecialization() {
        return specialization;
    }

    public DoctorShiftRegistry getDoctorShiftRegistry() {
        return doctorShiftRegistry;
    }

    public boolean HasShiftDuringDateAndTime(LocalDate date, LocalTime startTime, LocalTime endTime) {
        return doctorShiftRegistry.IsShiftDuringDateAndTime(date, startTime, endTime);
    }
}
