package pl.wsb.lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class PatientVisitTimeTableTest {

    Doctor testingDoctor;
    Doctor testingDoctor2;

    private PatientVisitTimeTableTest() {
        this.testingDoctor = new Doctor("John", "White", "00000000000", LocalDate.of(2000, 1, 1), "123456789", "test@test.com", 0,
                Set.of("one", "two", "three"));
        this.testingDoctor2 = new Doctor("Jesse", "Pinkman", "00000000000", LocalDate.of(2000, 1, 1), "123456789", "test@test.com", 0,
                Set.of("one", "two", "three"));
    }

    private class TestingPatientVisitTimeTableFactory {
        public PatientVisitTimeTable createTestingPatientVisitTimeTable() {
            PatientVisitTimeTable table = new PatientVisitTimeTable();
            table.addPatientVisit(LocalDate.of(2000, 1, 1), LocalTime.of(10, 0), LocalTime.of(10, 15), testingDoctor);
            table.addPatientVisit(LocalDate.of(2000, 1, 1), LocalTime.of(10, 30), LocalTime.of(10, 45), testingDoctor);
            // different day
            table.addPatientVisit(LocalDate.of(2000, 1, 2), LocalTime.of(10, 30), LocalTime.of(10, 45), testingDoctor);
            // different doctor
            table.addPatientVisit(LocalDate.of(2000, 1, 1), LocalTime.of(10, 0), LocalTime.of(10, 15), testingDoctor2);
            return table;
        }
    }

    @Test
    void isDoctorAssignedForTimeFreeDoctorTest() {
        TestingPatientVisitTimeTableFactory factory = new TestingPatientVisitTimeTableFactory();
        PatientVisitTimeTable table = factory.createTestingPatientVisitTimeTable();
        Assertions.assertFalse(table.isDoctorAssignedForTime(testingDoctor, LocalDate.of(2000, 1, 1), LocalTime.of(10, 15), LocalTime.of(10, 30)));
    }

    @Test
    void isDoctorAssignedForTimeConflictTest() {
        TestingPatientVisitTimeTableFactory factory = new TestingPatientVisitTimeTableFactory();
        PatientVisitTimeTable table = factory.createTestingPatientVisitTimeTable();
        Assertions.assertTrue(table.isDoctorAssignedForTime(testingDoctor, LocalDate.of(2000, 1, 1), LocalTime.of(10, 1), LocalTime.of(10, 16)));
    }

    @Test
    void isDoctorAssignedForTimeMultipleDoctorsTest() {
        TestingPatientVisitTimeTableFactory factory = new TestingPatientVisitTimeTableFactory();
        PatientVisitTimeTable table = factory.createTestingPatientVisitTimeTable();
        Assertions.assertTrue(table.isDoctorAssignedForTime(testingDoctor2, LocalDate.of(2000, 1, 1), LocalTime.of(10, 0), LocalTime.of(10, 15)));
    }

    @Test
    void isDoctorAssignedForTimeDifferentDayTest() {
        TestingPatientVisitTimeTableFactory factory = new TestingPatientVisitTimeTableFactory();
        PatientVisitTimeTable table = factory.createTestingPatientVisitTimeTable();
        Assertions.assertTrue(table.isDoctorAssignedForTime(testingDoctor, LocalDate.of(2000, 1, 2), LocalTime.of(10, 30), LocalTime.of(10, 45)));
        Assertions.assertFalse(table.isDoctorAssignedForTime(testingDoctor2, LocalDate.of(2000, 1, 2), LocalTime.of(10, 30), LocalTime.of(10, 45)));
    }

    @Test
    void isDoctorAssignedForTimeOneAfterAppointmentTest() {
        TestingPatientVisitTimeTableFactory factory = new TestingPatientVisitTimeTableFactory();
        PatientVisitTimeTable table = factory.createTestingPatientVisitTimeTable();
        Assertions.assertFalse(table.isDoctorAssignedForTime(testingDoctor, LocalDate.of(2000, 1, 1), LocalTime.of(10, 15), LocalTime.of(10, 30)));
    }
}
