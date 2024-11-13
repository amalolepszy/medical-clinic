package pl.wsb.lab;

import java.util.ArrayList;
import java.util.List;


public class DoctorProfile {

    public List<Doctor> Doctors = new ArrayList<>();


    public void addDoctor(Doctor doctor) {
        Doctors.add(doctor);
    }
    //Listowanie lekarzy
    public void listDoctors() {
        System.out.println("List of doctors:");
        for (Doctor doctor : Doctors) {
            System.out.println(doctor);
            System.out.println("--------------------");
        }
    }
    //Szukanie po id
    public Doctor findDoctorById(int id) {
        for (Doctor doctor : Doctors) {
            if (doctor.getDoctorID() == id) {
                return doctor;
            }
        }
        System.out.println("Lekarz o podanym ID nie istnieje.");
        return null;
    }
    //Szukanie po spejalizacji
    public Doctor findDoctorBySpec(String spec) {
        for (Doctor doctor : Doctors) {
            if (doctor.getDoctorSpec().contains(spec)) {
                return doctor;
            }
        }
        System.out.println("Lekarz o podanej specjalizacji nie istnieje.");
        return null;
    }
}
