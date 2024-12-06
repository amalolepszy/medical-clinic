package pl.wsb.lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DoctorShiftRegistryTest {

    @Test
    void testMethodListShiftForNextSevenDays() {
        DoctorShiftRegistry registry = new DoctorShiftRegistry();
        registry.addDoctorShift(LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 1));
        registry.addDoctorShift(LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 3));
        registry.addDoctorShift(LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 5));
        registry.addDoctorShift(LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 10));

        List<DoctorShift> result = registry.getShiftsForFollowingSevenDays(LocalDate.of(2024, 12, 1));
        Assertions.assertEquals(3, result.size());
    }

    @Test
    void testOutForDaysOutOfScope() {
        DoctorShiftRegistry registry = new DoctorShiftRegistry();
        registry.addDoctorShift(LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 10));
        registry.addDoctorShift(LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 14));
        registry.addDoctorShift(LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0), LocalDate.of(2024, 12, 17));

        List<DoctorShift> result = registry.getShiftsForFollowingSevenDays(LocalDate.of(2024, 12, 1));
        Assertions.assertEquals(0, result.size());
    }
}
