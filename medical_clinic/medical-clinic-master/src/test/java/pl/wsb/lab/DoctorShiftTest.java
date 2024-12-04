package pl.wsb.lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Set;

public class DoctorShiftTest {

    public DoctorRegistry createTestingDoctorRegistry() {
        DoctorRegistry registry = new DoctorRegistry();
        registry.addDoctor("John", "White", "00000000000", LocalDate.of(2000, 1, 1), "123456789", "test@test.com", Set.of("one", "two", "three"));
        registry.addDoctor("Albert", "Einstein", "00000000001", LocalDate.of(2000, 1, 1), "123456789", "test@test.com", Set.of("one"));
        registry.addDoctor("Jesse", "Pinkman", "00000000002", LocalDate.of(2000, 1, 1), "123456789", "test@test.com", Set.of("two", "four"));
        return registry;
    }

    public Doctor Doctor() {
        return new Doctor("Barry", "Allen",
                "12345678901", LocalDate.of(1999, 1, 1),
                "801802803", "test123@gmail.com", 1, Set.of("one", "two"));
    }

    public DoctorShift createDoctorTimesheet() {
        return new DoctorShift(Doctor(),
                LocalTime.of(8, 0, 0),
                LocalTime.of(16, 0, 0),
                LocalDate.of(2024, 11, 10));
    }

    //4.1
    @Test
    void createDoctorShiftTest() {


        DoctorShiftTest factory = new DoctorShiftTest();
        DoctorShift testingDoctorTimeSheet = factory.createDoctorTimesheet();
        Doctor doctor = testingDoctorTimeSheet.getDoctor();
        LocalDate date = testingDoctorTimeSheet.getShiftDay();
        LocalTime startTime = testingDoctorTimeSheet.getShiftStart();
        LocalTime endTime = testingDoctorTimeSheet.getShiftEnd();
        LocalDate expectedDate = LocalDate.of(2024, 11, 10);
        LocalTime expectedStartTime = LocalTime.of(8, 0, 0);
        LocalTime expectedEndTime = LocalTime.of(16, 0, 0);

        Assertions.assertEquals(doctor.getFirstName(), "Barry");
        Assertions.assertEquals(doctor.getLastName(), "Allen");
        Assertions.assertEquals(date, expectedDate);
        Assertions.assertEquals(startTime, expectedStartTime);
        Assertions.assertEquals(endTime, expectedEndTime);

    }

    @Test
    void createShiftTest() {
        Clinic clinic = new Clinic(new DoctorRegistry(), new DoctorShiftRegistry(new ArrayList<>()));
        clinic.createDoctorProfile("Barry", "Allen",
                "12345678901", LocalDate.of(1999, 1, 1),
                "801802803", "test123@gmail.com", Set.of("one", "two"));
        clinic.createDoctorShift(new Doctor("Barry", "Allen",
                        "12345678901", LocalDate.of(1999, 1, 1),
                        "801802803", "test123@gmail.com", 0, Set.of("one", "two")), LocalTime.of(8, 0, 0),
                LocalTime.of(16, 0, 0),
                LocalDate.of(2024, 11, 10));

        Assertions.assertEquals(clinic.getDoctorShiftRegistry().getDoctorShifts().size(), 1);
    }



}




