package pl.wsb.lab.gui;

import pl.wsb.lab.Clinic;
import pl.wsb.lab.PersonInfoUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class BookAppointmentState {
    public static void renderBookAppointmentState(Clinic clinic, Scanner scanner) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("--- Book appointment ---");
            System.out.println("1. Book appointment with a doctor.");
            System.out.println("2. Go back to main menu.");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1: {
                    try {
                        System.out.println("Patient PESEL: ");
                        String pesel = scanner.nextLine();
                        if (clinic.getPatientInfoByPesel(pesel) == null) {
                            throw new IllegalArgumentException("Patient with given PESEL is not registered");
                        }

                        System.out.println("Doctor ID: ");
                        int doctorId = scanner.nextInt();
                        scanner.nextLine();
                        if (clinic.getDoctorInfoById(doctorId) == null) {
                            throw new IllegalArgumentException("Doctor with given ID: " + doctorId + " does not exist.");
                        }

                        System.out.println("Appointment date (YYYY-MM-DD):");
                        String dateString = scanner.nextLine();
                        LocalDate date;
                        try {
                            date = LocalDate.parse(dateString);
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Wrong date format.");
                        }

                        System.out.println("Appointment start time (HH:MM): ");
                        String startTimeString = scanner.nextLine();
                        LocalTime startTime;
                        try {
                            startTime = LocalTime.parse(startTimeString);
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Wrong time format.");
                        }

                        int defaultAppointmentDuration = 15;
                        LocalTime endTime = startTime.plusMinutes(defaultAppointmentDuration);
                        clinic.bookAppointment(pesel, doctorId, date, startTime, endTime);
                    } catch (Exception e) {
                        System.out.println("Error booking appointment: " + e.getMessage());
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    }

                    System.out.println("Appointment booked.");
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;
                }
                case 2: {
                    return;
                }
            }
        }
    }
}