package pl.wsb.lab;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DoctorRegistry {
    private List<Doctor> doctors;

    public DoctorRegistry() {
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addDoctor(String firstName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String eMail, Set<String> specialization) {
        int doctorId = doctors.size();
        Doctor newDoctor = new Doctor(firstName, lastName, pesel, birthDate, phoneNumber, eMail, doctorId, specialization);
        doctors.add(newDoctor);
    }

    public List<Doctor> getDoctors() {return doctors;}

    //Szukanie po id
    public Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorID() == id) {
                return doctor;
            }
        }
        return null;
    }

    //Szukanie po specjalizacji
    public List<Doctor> findDoctorsBySpecialization(String spec) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialization().contains(spec)) {
                result.add(doctor);
            }
        }
        return result;
    }

    //Listowanie lekarzy
    public void printDoctors() {
        System.out.println("List of doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
            System.out.println("--------------------");
        }
    }
}
