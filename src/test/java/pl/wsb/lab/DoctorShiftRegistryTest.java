package pl.wsb.lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DoctorShiftRegistryTest {

    public Doctor createTestingDoctor() {
        return new Doctor("John", "White", "00000000000", LocalDate.of(2000, 1, 1), "123456789", "test@test.com", 0, Set.of("one", "two", "three"));
    }

    public Doctor createTestingDoctor2() {
        return new Doctor("John", "White", "00000000000", LocalDate.of(2000, 1, 1), "123456789", "test@test.com", 1, Set.of("one", "two", "three"));
    }

    DoctorShiftRegistry registry = new DoctorShiftRegistry(new ArrayList<>());

    void addShift(Doctor doctor, LocalTime start, LocalTime end, LocalDate day) {
        registry.addDoctorShift(doctor, start, end, day);
    }

    @Test
    void testMethodListShiftForNextSevenDays() {
        Doctor doctor = createTestingDoctor();
        addShift(doctor, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 1));
        addShift(doctor, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 3));
        addShift(doctor, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 5));
        addShift(doctor, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 10));

        List<DoctorShift> result = registry.listShiftForNextSevenDays(doctor, LocalDate.of(2024, 12, 1));
        Assertions.assertEquals(3, result.size());
    }

    @Test
    void testOutForDaysOutOfScope() {
        Doctor doctor = createTestingDoctor();
        addShift(doctor, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 10));
        addShift(doctor, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 14));
        addShift(doctor, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 17));

        List<DoctorShift> result = registry.listShiftForNextSevenDays(doctor, LocalDate.of(2024, 12, 1));
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void testOutForDaysParticularDoctor() {
        Doctor doctor = createTestingDoctor();
        Doctor doctor2 = createTestingDoctor2();
        addShift(doctor, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 4));
        addShift(doctor2, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 5));
        addShift(doctor2, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 6));

        List<DoctorShift> result = registry.listShiftForNextSevenDays(doctor, LocalDate.of(2024, 12, 1));
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void GetShiftsForSeveralDoctors() {
        Doctor doctor = createTestingDoctor();
        Doctor doctor2 = createTestingDoctor2();
        addShift(doctor, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 4));
        addShift(doctor2, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 5));
        addShift(doctor2, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 6));

        List<DoctorShift> result = registry.getDoctorShifts();
        Assertions.assertEquals(result.size(), 3);
        Assertions.assertEquals(result.get(0).getAssignedDoctor(), doctor);
        Assertions.assertEquals(result.get(1).getAssignedDoctor(), doctor2);
        Assertions.assertEquals(result.get(2).getAssignedDoctor(), doctor2);
        Assertions.assertEquals(result.get(0).getShiftDay(), LocalDate.of(2024, 12, 4));
        Assertions.assertEquals(result.get(1).getShiftDay(), LocalDate.of(2024, 12, 5));
        Assertions.assertEquals(result.get(2).getShiftDay(), LocalDate.of(2024, 12, 6));
    }
}
