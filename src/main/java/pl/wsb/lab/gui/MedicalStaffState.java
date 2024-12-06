package pl.wsb.lab.gui;

import pl.wsb.lab.Clinic;
import pl.wsb.lab.PersonInfoUtil;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MedicalStaffState {
    public static void renderMedicalStaffState(Clinic clinic, Scanner scanner) {
        while (true) {
            System.out.flush();
            System.out.println("--- Medical Staff ---");
            System.out.println("1. Create Doctor Profile.");
            System.out.println("2. Add Specialization to doctor.");
            System.out.println("3. Find doctor by ID.");
            System.out.println("4. Find doctors by specialization.");
            System.out.println("5. Go back to main menu.");
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

                        System.out.println("Specialization(s) - type 'done' to finish");
                        Set<String> specializations = new TreeSet<>();
                        while (true) {
                            String specialization = scanner.nextLine();
                            if (specialization.equalsIgnoreCase("done")) {
                                break;
                            }
                            specializations.add(specialization.toLowerCase());
                        }

                        clinic.createDoctorProfile(firstName, lastName, pesel, birthDate, phoneNumber, eMail, specializations);
                    } catch (Exception e) {
                        System.out.println("Error creating Doctor Profile: " + e.getMessage());
                        break;
                    }

                    System.out.println("Doctor profile created.");
                    break;
                }
                case 2: {
                    try {
                        System.out.println("Doctor ID to add new specializations: ");
                        int doctorId = scanner.nextInt();
                        scanner.nextLine();
                        if (clinic.getDoctorInfoById(doctorId) == null) {
                            throw new IllegalArgumentException("Doctor with given ID: " + doctorId + " does not exist.");
                        }
                        System.out.println("Add new specializations - type 'done' to finish");
                        while (true) {
                            String specialization = scanner.nextLine();
                            if (specialization.equalsIgnoreCase("done")) {
                                break;
                            }
                            clinic.addSpecializationForDoctor(doctorId, specialization);
                        }
                        System.out.println("Specializations successfully added.");
                        break;
                    } catch (Exception e) {
                        System.out.println("Error adding doctor specializations: " + e.getMessage());
                        break;
                    }
                }
                case 3: {
                    try {
                        System.out.println("Doctor ID: ");
                        int doctorId = scanner.nextInt();
                        scanner.nextLine();
                        String doctorInfo = clinic.getDoctorInfoById(doctorId);
                        System.out.println("Found Doctor:");
                        System.out.println(doctorInfo);
                        break;
                    } catch (Exception e) {
                        System.out.println("Error finding Doctor: " + e.getMessage());
                        break;
                    }
                }
                case 4: {
                    try {
                        System.out.println("Specialization: ");
                        String specialization = scanner.nextLine();
                        String doctorInfo = clinic.getDoctorsInfoBySpecialization(specialization);
                        System.out.println("Found Doctor(s):");
                        System.out.println(doctorInfo);
                        break;
                    } catch (Exception e) {
                        System.out.println("Error finding Doctors: " + e.getMessage());
                        break;
                    }
                }
                case 5: {
                    return;
                }
            }
        }
    }
}
