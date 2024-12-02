package pl.wsb.lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class DoctorRegistryTest {
    private class TestingDoctorRegistryFactory {
        public DoctorRegistry createTestingDoctorRegistry() {
            DoctorRegistry registry = new DoctorRegistry();
            registry.addDoctor("John", "White", "00000000000", LocalDate.of(2000, 1, 1), "123456789", "test@test.com", Set.of("one", "two", "three"));
            registry.addDoctor("Albert", "Einstein", "00000000001", LocalDate.of(2000, 1, 1), "123456789", "test@test.com", Set.of("one"));
            registry.addDoctor("Jesse", "Pinkman", "00000000002", LocalDate.of(2000, 1, 1), "123456789", "test@test.com", Set.of("two", "four"));
            return registry;
        }
    }

    @Test
    void findDoctorById() {
        TestingDoctorRegistryFactory registryFactory = new TestingDoctorRegistryFactory();
        DoctorRegistry registry = registryFactory.createTestingDoctorRegistry();

        Doctor found = registry.findDoctorById(2);
        Assertions.assertEquals(found, registry.getDoctors().get(2));

        // No such doctor
        Doctor not_found = registry.findDoctorById(200);
        Assertions.assertEquals(not_found, null);
    }

    @Test
    void findOneDoctorBySpecialization() {
        TestingDoctorRegistryFactory registryFactory = new TestingDoctorRegistryFactory();
        DoctorRegistry registry = registryFactory.createTestingDoctorRegistry();

        List<Doctor> found = registry.findDoctorsBySpecialization("four");
        Assertions.assertEquals(found.size(), 1);
        Assertions.assertEquals(found.get(0), registry.getDoctors().get(2));

        // No such doctor
        List<Doctor> not_found = registry.findDoctorsBySpecialization("five");
        Assertions.assertEquals(not_found.size(), 0);
    }

    @Test
    void findMultipleDoctorsBySpecialization() {
        TestingDoctorRegistryFactory registryFactory = new TestingDoctorRegistryFactory();
        DoctorRegistry registry = registryFactory.createTestingDoctorRegistry();

        List<Doctor> found = registry.findDoctorsBySpecialization("two");
        Assertions.assertEquals(found.size(), 2);
        Assertions.assertEquals(found.get(0), registry.getDoctors().get(0));
        Assertions.assertEquals(found.get(1), registry.getDoctors().get(2));
    }
}
