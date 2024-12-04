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
     void addShift(Doctor doctor,LocalTime start, LocalTime end, LocalDate day){
        registry.addDoctorShift(doctor,start,end,day);
    }

    @Test
    void testMethodListShiftForNextSevenDays() {
        addShift(createTestingDoctor(), LocalTime.of(8,0,0),LocalTime.of(16,0,0),LocalDate.of(2024,12,1));
        addShift(createTestingDoctor(), LocalTime.of(8,0,0),LocalTime.of(16,0,0),LocalDate.of(2024,12,3));
        addShift(createTestingDoctor(), LocalTime.of(8,0,0),LocalTime.of(16,0,0),LocalDate.of(2024,12,5));
        addShift(createTestingDoctor(), LocalTime.of(8,0,0),LocalTime.of(16,0,0),LocalDate.of(2024,12,10));

        List<DoctorShift> result = registry.listShiftForNextSevenDays(createTestingDoctor(),LocalDate.of(2024,12,1));
        Assertions.assertEquals(3,result.size());
     }
     @Test
    void testOutForDaysOutOfScope(){

         addShift(createTestingDoctor(), LocalTime.of(8,0,0),LocalTime.of(16,0,0),LocalDate.of(2024,12,10));
         addShift(createTestingDoctor(), LocalTime.of(8,0,0),LocalTime.of(16,0,0),LocalDate.of(2024,12,14));
         addShift(createTestingDoctor(), LocalTime.of(8,0,0),LocalTime.of(16,0,0),LocalDate.of(2024,12,17));

         List<DoctorShift> result = registry.listShiftForNextSevenDays(createTestingDoctor(),LocalDate.of(2024,12,1));
         Assertions.assertEquals(0,result.size());
     }
     @Test
    void testOutForDaysParticularDoctor(){

        addShift(createTestingDoctor(), LocalTime.of(8,0,0),LocalTime.of(16,0,0),LocalDate.of(2024,12,4));
        addShift(createTestingDoctor2(), LocalTime.of(8,0,0),LocalTime.of(16,0,0),LocalDate.of(2024,12,5));
        addShift(createTestingDoctor2(), LocalTime.of(8,0,0),LocalTime.of(16,0,0),LocalDate.of(2024,12,6));

        List<DoctorShift> result = registry.listShiftForNextSevenDays(createTestingDoctor(),LocalDate.of(2024,12,1));
        Assertions.assertEquals(1,result.size());
    }

}