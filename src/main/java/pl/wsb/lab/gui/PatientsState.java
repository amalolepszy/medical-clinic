package pl.wsb.lab.gui;

import pl.wsb.lab.Clinic;
import pl.wsb.lab.PersonInfoUtil;

import java.time.LocalDate;
import java.util.Scanner;

public class PatientsState {
    public static void renderPatientsState(Clinic clinic, Scanner scanner) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("--- Patients ---");
            System.out.println("1. Create Patient Profile.");
            System.out.println("2. Find Patient by PESEL number.");
            System.out.println("3. Find matching Patients by last name.");
            System.out.println("4. Go back to main menu.");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1: {
                    try {
                        System.out.println("Name: ");
                        String firstName = scanner.nextLine();
                        if (firstName.isEmpty() || !PersonInfoUtil.isValidName(firstName)) {
                            throw new IllegalArgumentException("Invalid name: " + firstName + ".");
                        }

                        System.out.println("Last Name: ");
                        String lastName = scanner.nextLine();
                        if (lastName.isEmpty() || !PersonInfoUtil.isValidName(lastName)) {
                            throw new IllegalArgumentException("Invalid last name: " + lastName + ".");
                        }

                        System.out.println("Podaj PESEL: ");
                        String pesel = scanner.nextLine();
                        if (!PersonInfoUtil.isValidPesel(pesel)) {
                            throw new IllegalArgumentException("PESEL should have 11 digits.");
                        }

                        System.out.println("Birthdate (YYYY-MM-DD):");
                        String date = scanner.nextLine();
                        LocalDate birthDate;
                        try {
                            birthDate = LocalDate.parse(date);
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Wrong date format.");
                        }

                        System.out.println("Phone number: ");
                        String phoneNumber = scanner.nextLine();
                        if (!PersonInfoUtil.isValidPhone(phoneNumber)) {
                            throw new IllegalArgumentException("Phone number should have 9 digits.");
                        }

                        System.out.println("E-Mail address: ");
                        String eMail = scanner.nextLine();
                        if (!PersonInfoUtil.isValidEmail(eMail)) {
                            throw new IllegalArgumentException("Wrong e-mail format.");
                        }

                        try {
                            clinic.createPatientProfile(firstName, lastName, pesel, birthDate, phoneNumber, eMail);
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Error creating Patient Profile: " + e.getMessage());
                        }
                    } catch (Exception e) {
                        System.out.println("Error creating Patient Profile: " + e.getMessage());
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    }

                    System.out.println("Patient profile created.");
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;
                }
                case 2: {
                    try {
                        System.out.println("PESEL number: ");
                        String pesel = scanner.nextLine();
                        if (!PersonInfoUtil.isValidPesel(pesel)) {
                            throw new IllegalArgumentException("PESEL should have 11 digits.");
                        }
                        String result = clinic.getPatientInfoByPesel(pesel);
                        System.out.println("Found patient:");
                        System.out.println(result);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println("Error finding Patient: " + e.getMessage());
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    }
                }
                case 3: {
                    try {
                        System.out.println("Last Name: ");
                        String lastName = scanner.nextLine();
                        if (!PersonInfoUtil.isValidName(lastName)) {
                            throw new IllegalArgumentException("Invalid last name.");
                        }
                        String result = clinic.getPatientsInfoByLastName(lastName);
                        System.out.println("Found patient(s):");
                        System.out.println(result);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println("Error finding Patient: " + e.getMessage());
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();;
                        break;
                    }
                }
                case 4: {
                    return;
                }
            }
        }
    }
}
