package pl.wsb.lab;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoctorProfile doctorlist = new DoctorProfile();
        Scanner scanner = new Scanner(System.in);

        List<String> ExampleSpec = new ArrayList<>();
        ExampleSpec.add("Internista");
        doctorlist.addDoctor(new Doctor("Jan", "Kowalski", "12345678901", LocalDate.of(1980, 5, 15), "123-456-789", "jan.kowalski@example.com", ExampleSpec));

        while (true) {
            System.out.println("1. Dodaj profil lekarza");
            System.out.println("2. Wylistuj aktualnych lekarzy");
            System.out.println("3. Dodaj specjalizacje lekarza");
            System.out.println("4. Szukaj lekarza po ID");
            System.out.println("5. Wyszukaj lekarza po specjalizacji");
            System.out.println("6. Wyjście");

            int menu = scanner.nextInt();
            scanner.nextLine();
            switch (menu) {
                //Dodanie lekarza
                case 1:
                    System.out.println("Podaj imię:");
                    String name = scanner.nextLine();

                    System.out.println("Podaj nazwisko:");
                    String lastname = scanner.nextLine();

                    System.out.println("Podaj pesel:");
                    String pesel = scanner.nextLine();

                    System.out.println("Podaj date urodzenia (r-m-d):");
                    String date = scanner.nextLine();
                    LocalDate birthdate = LocalDate.parse(date);


                    System.out.println("Podaj nr tel.:");
                    String phone = scanner.nextLine();

                    System.out.println("Podaj adres email:");
                    String email = scanner.nextLine();

                    List<String> specialization = new ArrayList<>();
                    String NewSpec;
                    while (true) {
                        System.out.println("Podaj Wszystkie Specjalizacje(Wpisz x aby zakończyć):");
                        NewSpec = scanner.nextLine();
                        if (NewSpec.equals("x")) {
                            break;
                        }
                        specialization.add(NewSpec);
                    }
                    doctorlist.addDoctor(new Doctor(name, lastname, pesel, birthdate, phone, email, specialization));
                    break;

                    //Listowanie lekarzy
                case 2:
                    doctorlist.listDoctors();
                    break;

                    //Dodanie specjalizacji
                case 3:
                    System.out.println("Podaj ID lekarza, któremu chcesz dodać specjalizację:");
                    int DocID = scanner.nextInt();
                    scanner.nextLine();

                    Doctor doctor = doctorlist.findDoctorById(DocID);
                    if (doctor != null) {
                        System.out.println("Podaj nową specjalizację:");
                        String newSpec = scanner.nextLine();
                        doctor.addSpecialization(newSpec);
                    }
                    break;

                    //Szukanie po ID
                case 4:
                    System.out.println("Podaj ID lekarza");
                    DocID = scanner.nextInt();
                    scanner.nextLine();

                    doctor = doctorlist.findDoctorById(DocID);
                    if (doctor != null) {}
                    System.out.println(doctor);
                    break;

                    //Szukanie po specjalizacji
                case 5:
                    System.out.println("Podaj specjalizacje lekarza");
                    String spec = scanner.nextLine();

                    doctor = doctorlist.findDoctorBySpec(spec);
                    if (doctor != null) {}
                    System.out.println(doctor);
                    break;
                    //Wyjście
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}