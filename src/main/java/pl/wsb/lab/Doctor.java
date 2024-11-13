package pl.wsb.lab;

import java.time.LocalDate;
import java.util.List;

public class Doctor {

    // fields //
    private static int NextID = 1;
    private int DoctorID;
    private String name;
    private String lastname;
    private String pesel;
    private LocalDate birthdate;
    private int age;
    private String phone;
    private String email;
    private List<String> specialization;

    // constructors //
    public Doctor(String name, String lastname, String pesel, LocalDate birthdate, String phone, String email, List<String> specialization) {
        this.DoctorID = NextID++;
        this.name = name;
        this.lastname = lastname;
        this.pesel = pesel;
        this.birthdate = birthdate;
        this.age = calculateage(birthdate);
        this.phone = phone;
        this.email = email;
        this.specialization = specialization;
    }

    private int calculateage(LocalDate birthdate) {
        return LocalDate.now().getYear() - birthdate.getYear();
    }


    public String toString() {
        return "Doctor ID: " + DoctorID + "\n" +
                "Name: " + name + "\n" +
                "Last Name: " + lastname + "\n" +
                "Pesel: " + pesel + "\n" +
                "Date of birth: " + birthdate + "\n" +
                "age: " + age + "\n" +
                "Phone number: " + phone + "\n" +
                "Email address: " + email + "\n" +
                "Specjalization: " + String.join(", ", specialization);
    }

    public int getDoctorID() {
        return DoctorID;
    }
    public List<String> getDoctorSpec() {
        return specialization;
    }
    //Dodanie specializacji
    public void addSpecialization(String specialization) {
        if (!this.specialization.contains(specialization)) {
            this.specialization.add(specialization);
            System.out.println("Specjalizacja " + specialization + " została dodana.");
        } else {
            System.out.println("Lekarz posiada już tę specjalizację.");
        }
    }
}
