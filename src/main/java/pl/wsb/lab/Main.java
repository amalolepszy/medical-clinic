package pl.wsb.lab;

import pl.wsb.lab.gui.BookAppointmentState;
import pl.wsb.lab.gui.DoctorShiftsState;
import pl.wsb.lab.gui.MedicalStaffState;
import pl.wsb.lab.gui.PatientsState;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("--- Medical clinic ---");
            System.out.println("1. Patients");
            System.out.println("2. Medical staff");
            System.out.println("3. Timetables");
            System.out.println("4. Book an appointment");
            System.out.println("5. Exit");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1: {
                    PatientsState.renderPatientsState(clinic, scanner);
                    break;
                }
                case 2: {
                    MedicalStaffState.renderMedicalStaffState(clinic, scanner);
                    break;
                }
                case 3: {
                    DoctorShiftsState.renderDoctorShiftsState(clinic, scanner);
                    break;
                }
                case 4: {
                    BookAppointmentState.renderBookAppointmentState(clinic, scanner);
                    break;
                }
                case 5: {
                    System.exit(0);
                    break;
                }
            }
        }
    }
}