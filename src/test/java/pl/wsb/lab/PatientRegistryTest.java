package pl.wsb.lab;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PatientRegistryTest {
    private static class TestingPatientRegistryFactory {
        public PatientRegistry createTestingPatientRegistry() {
            PatientRegistry registry = new PatientRegistry();
            registry.addPatient("John", "White", "00000000000", LocalDate.of(2000, 1, 1), "123456789", "test@test.com");
            registry.addPatient("Albert", "Einstein", "00000000001", LocalDate.of(2000, 1, 1), "123456789",
                    "test@test.com");
            registry.addPatient("Jesse", "Pinkman", "00000000002", LocalDate.of(2000, 1, 1), "123456789",
                    "test@test.com");
            registry.addPatient("Jesse", "White", "00000000003", LocalDate.of(2000, 1, 1), "123456789",
                    "test@test.com");
            return registry;
        }
    }

    @Test
    void findByPeselTest() {
        TestingPatientRegistryFactory factory = new TestingPatientRegistryFactory();
        PatientRegistry registry = factory.createTestingPatientRegistry();

        Patient found = registry.findPatientByPesel("00000000002");
        Assertions.assertEquals("Pinkman", found.getLastName());

        // no such patient
        Patient not_found = registry.findPatientByPesel("00000000006");
        Assertions.assertNull(not_found);
    }

    @Test
    void findByNameTest() {
        PatientRegistryTest.TestingPatientRegistryFactory factory = new TestingPatientRegistryFactory();
        PatientRegistry registry = factory.createTestingPatientRegistry();

        List<Patient> found = registry.findPatientsByLastName("White");
        Assertions.assertEquals(2, found.size());

        // no such patient
        List<Patient> not_found = registry.findPatientsByLastName("Fring");
        Assertions.assertEquals(0, not_found.size());
    }
}
