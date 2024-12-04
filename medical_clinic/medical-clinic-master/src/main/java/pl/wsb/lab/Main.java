//package pl.wsb.lab;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {

//    public static void main(String[] args) {
//        enum State {
//            PATIENTS,
//            MEDICAL_STAFF,
//            TIMETABLE,
//            BOOK_VISIT
//        }
//        Clinic clinic = new Clinic();
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("1. Dodaj profil lekarza");
//            System.out.println("2. Wylistuj aktualnych lekarzy");
//            System.out.println("3. Dodaj specjalizacje lekarza");
//            System.out.println("4. Szukaj lekarza po ID");
//            System.out.println("5. Wyszukaj lekarza po specjalizacji");
//            System.out.println("6. Wyjście");
//            try {
//                int menu = scanner.nextInt();
//                scanner.nextLine();
//                switch (menu) {
//                    //Dodanie lekarza
//                    case 1:
//                        System.out.println("Podaj imię:");
//                        String firstName = scanner.nextLine();
//                        if (firstName.isEmpty() || !DoctorProfile.isValidName(firstName)) {
//                            throw new IllegalArgumentException("Imię jest niepoprawne.");
//                        }
//
//                        System.out.println("Podaj nazwisko:");
//                        String lastName = scanner.nextLine();
//                        if (lastName.isEmpty() || !DoctorProfile.isValidName(lastName)) {
//                            throw new IllegalArgumentException("Nazwisko jest niepoprawne.");
//                        }
//
//                        System.out.println("Podaj pesel:");
//                        String pesel = scanner.nextLine();
//                        if (!DoctorProfile.isValidPesel(pesel)) {
//                            throw new IllegalArgumentException("Pesel jest nieprawidłowy. Powinien zawierać 11 cyfr.");
//                        }
//
//                        System.out.println("Podaj datę urodzenia (r-m-d):");
//                        String date = scanner.nextLine();
//                        LocalDate birthDate;
//                        try {
//                            birthDate = LocalDate.parse(date);
//                        } catch (Exception e) {
//                            throw new IllegalArgumentException("Niepoprawny format daty.");
//                        }
//
//                        System.out.println("Podaj nr tel.:");
//                        String phoneNumber = scanner.nextLine();
//                        if (!DoctorProfile.isValidPhone(phoneNumber)) {
//                            throw new IllegalArgumentException("Numer telefonu jest nieprawidłowy.");
//                        }
//
//                        System.out.println("Podaj adres email:");
//                        String eMail = scanner.nextLine();
//                        if (!DoctorProfile.isValidEmail(eMail)) {
//                            throw new IllegalArgumentException("Adres email jest nieprawidłowy.");
//                        }
//
//                        List<String> specialization = new ArrayList<>();
//                        String NewSpec;
//                        while (true) {
//                            System.out.println("Podaj wszystkie specjalizacje (wpisz x aby zakończyć):");
//                            NewSpec = scanner.nextLine();
//                            if (NewSpec.equals("x")) {
//                                break;
//                            }
//                            specialization.add(NewSpec);
//                        }
//
//                        Doctor newDoctor = new Doctor(firstName, lastName, pesel, birthDate, phoneNumber, eMail, specialization);
//                        DoctorProfile.addDoctor(newDoctor);
//                        System.out.println("Lekarz został dodany.");
//                        break;
//
//                    //Listowanie lekarzy
//                    case 2:
//                        DoctorProfile.printDoctors();
//                        break;
//
//                    //Dodanie specjalizacji
//                    case 3:
//                        System.out.println("Podaj ID lekarza, któremu chcesz dodać specjalizację:");
//                        DocID = scanner.nextInt();
//                        scanner.nextLine();
//                        doctor = DoctorProfile.findDoctorById(DocID);
//                        if (doctor != null) {
//                            System.out.println("Podaj nową specjalizację:");
//                            String newSpec = scanner.nextLine();
//                            DoctorProfile.addSpecialization(DocID, newSpec);
//                        }
//                        break;
//
//                    //Szukanie po ID
//                    case 4:
//                        System.out.println("Podaj ID lekarza");
//                        DocID = scanner.nextInt();
//                        scanner.nextLine();
//
//                        doctor = DoctorProfile.findDoctorById(DocID);
//                        if (doctor != null) {
//                        }
//                        System.out.println(doctor);
//                        break;
//
//                    //Szukanie po specjalizacji
//                    case 5:
//                        System.out.println("Podaj specjalizacje lekarza");
//                        String spec = scanner.nextLine();
//
//                        doctor = DoctorProfile.findDoctorBySpec(spec);
//                        if (doctor != null) {
//                        }
//                        System.out.println(doctor);
//                        break;
//                    //Wyjście
//                    case 6:
//                        System.exit(0);
//                        break;
//                }
//            } catch (Exception e) {
//                System.out.println("Wystąpił błąd, spróbuj ponownie: " + e.getMessage());
//                scanner.nextLine();
//            }
//        }
//    }
//}
