package pl.wsb.lab.gui;

import pl.wsb.lab.Clinic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class DoctorShiftsState {
    public static void renderDoctorShiftsState(Clinic clinic, Scanner scanner) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("--- Doctor shifts ---");
            System.out.println("1. Assign Doctor to shift.");
            System.out.println("2. Print Doctor shifts for next week.");
            System.out.println("3. Go back to main menu.");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1: {
                    try {
                        System.out.println("DoctorID: ");
                        int doctorId = scanner.nextInt();
                        scanner.nextLine();
                        if (clinic.getDoctorInfoById(doctorId) == null) {
                            throw new IllegalArgumentException("Doctor with given ID: " + doctorId + " does not exist.");
                        }

                        System.out.println("Shift date (YYYY-MM-DD):");
                        String dateString = scanner.nextLine();
                        LocalDate date;
                        try {
                            date = LocalDate.parse(dateString);
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Wrong date format.");
                        }

                        System.out.println("Start time (HH:MM): ");
                        String startTimeString = scanner.nextLine();
                        LocalTime startTime;
                        try {
                            startTime = LocalTime.parse(startTimeString);
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Wrong time format.");
                        }

                        System.out.println("End time (HH:MM): ");
                        String endTimeString = scanner.nextLine();
                        LocalTime endTime;
                        try {
                            endTime = LocalTime.parse(endTimeString);
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Wrong time format.");
                        }

                        clinic.createDoctorShift(doctorId, startTime, endTime, date);
                    } catch (Exception e) {
                        System.out.println("Error creating Doctor shift: " + e.getMessage());
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    }

                    System.out.println("Doctor shift created.");
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;
                }
                case 2: {
                    try {
                        System.out.println("DoctorID: ");
                        int doctorId = scanner.nextInt();
                        scanner.nextLine();
                        if (clinic.getDoctorInfoById(doctorId) == null) {
                            throw new IllegalArgumentException("Doctor with given ID: " + doctorId + " does not exist.");
                        }

                        String result = clinic.getDoctorShiftsForNext7Days(doctorId);
                        System.out.println(result);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println("Error Doctor shifts: " + e.getMessage());
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    }
                }
                case 3: {
                    return;
                }
            }
        }
    }
}
