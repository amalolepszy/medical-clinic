package pl.wsb.lab;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class Clinic {

    private List<Person> patients;

    public Person createPatientProfile(String firstName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String eMail) {
        Person newPatient = new Person(firstName, lastName, pesel, birthDate, phoneNumber, eMail);
        this.patients.add(newPatient);
        return newPatient;
    }

    public Person getPatientByPesel(String pesel) {
        // your implementation
        return null;
    }

    public List<Doctor> Doctors = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        Doctors.add(doctor);
    }

    //Listowanie lekarzy
    public void printDoctors() {
        System.out.println("List of doctors:");
        for (Doctor doctor : Doctors) {
            System.out.println(doctor);
            System.out.println("--------------------");
        }
    }

    //Dodanie specializacji
    public void addSpecialization(int doctorId, String specialization) {
        Doctor doctor = findDoctorById(doctorId);
        if (doctor != null) {
            if (!doctor.getSpecialization().contains(specialization)) {
                doctor.getSpecialization().add(specialization);
                System.out.println("Specjalizacja " + specialization + " została dodana.");
            } else {
                throw new IllegalArgumentException("Lekarz posiada już tę specjalizację.");
            }
        }
    }

    //Szukanie po id
    public Doctor findDoctorById(int id) {
        for (Doctor doctor : Doctors) {
            if (doctor.getDoctorID() == id) {
                return doctor;
            }
        }
        throw new IllegalArgumentException("Lekarz o podanym ID nie istnieje.");
    }

    //Szukanie po spejalizacji
    public Doctor findDoctorBySpec(String spec) {
        for (Doctor doctor : Doctors) {
            if (doctor.getSpecialization().contains(spec)) {
                return doctor;
            }
        }
        throw new IllegalArgumentException("Lekarz o podanej specjalizacji nie istnieje.");
    }

    //Sprawdzenie długości PESEL
    public static boolean isValidPesel(String pesel) {
        if (pesel.length() != 11) {
            return false;
        }
        return true;
    }

    //Sprawdzenie długości numeru telefonu
    public static boolean isValidPhone(String phone) {
        if (phone.length() != 9) {
            return false;
        }
        return true;
    }

    //Sprawdzenie adresu email
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.indexOf('.') > email.indexOf('@');
    }

    //Sprawdzenie imienia i nazwiska
    public static boolean isValidName(String name) {
        return name.chars().allMatch(Character::isLetter);
    }
}
