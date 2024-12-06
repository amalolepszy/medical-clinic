package pl.wsb.lab;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoctorRegistryTest {
    private static class TestingDoctorRegistryFactory {
        public DoctorRegistry createTestingDoctorRegistry() {
            DoctorRegistry registry = new DoctorRegistry();
            registry.addDoctor("John", "White", "00000000000", LocalDate.of(2000, 1, 1), "123456789", "test@test.com",
                    Set.of("one", "two", "three"));
            registry.addDoctor("Albert", "Einstein", "00000000001", LocalDate.of(2000, 1, 1), "123456789",
                    "test@test.com", Set.of("one"));
            registry.addDoctor("Jesse", "Pinkman", "00000000002", LocalDate.of(2000, 1, 1), "123456789",
                    "test@test.com", Set.of("two", "four"));
            return registry;
        }
    }

    @Test
    void findDoctorByIdTest() {
        TestingDoctorRegistryFactory registryFactory = new TestingDoctorRegistryFactory();
        DoctorRegistry registry = registryFactory.createTestingDoctorRegistry();

        Doctor found = registry.findDoctorById(2);
        Assertions.assertEquals(registry.getDoctors().get(2), found);

        // No such doctor
        Doctor not_found = registry.findDoctorById(200);
        Assertions.assertEquals(null, not_found);
    }

    @Test
    void findOneDoctorBySpecializationTest() {
        TestingDoctorRegistryFactory registryFactory = new TestingDoctorRegistryFactory();
        DoctorRegistry registry = registryFactory.createTestingDoctorRegistry();

        List<Doctor> found = registry.findDoctorsBySpecialization("four");
        Assertions.assertEquals(1, found.size());
        Assertions.assertEquals(registry.getDoctors().get(2), found.get(0));

        // No such doctor
        List<Doctor> not_found = registry.findDoctorsBySpecialization("five");
        Assertions.assertEquals(0, not_found.size());
    }

    @Test
    void findMultipleDoctorsBySpecializationTest() {
        TestingDoctorRegistryFactory registryFactory = new TestingDoctorRegistryFactory();
        DoctorRegistry registry = registryFactory.createTestingDoctorRegistry();

        List<Doctor> found = registry.findDoctorsBySpecialization("two");
        Assertions.assertEquals(2, found.size());
        Assertions.assertEquals(registry.getDoctors().get(0), found.get(0));
        Assertions.assertEquals(registry.getDoctors().get(2), found.get(1));
    }
}
