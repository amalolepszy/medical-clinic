package pl.wsb.lab;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDate birthDate; // YYYY-MM-DD
    private String phoneNumber;
    private String eMail;

    public Person(String firstName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }

    class Patient extends Person {
        public Patient(String firstName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String eMail) {
            super(firstName, lastName, pesel, birthDate, phoneNumber, eMail);
        }
    }

    public static class Doctor extends Person {
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int calculateAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEMail() {
        return eMail;
    }
}


