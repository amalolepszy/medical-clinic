package pl.wsb.lab;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PatientTest {

    private static class TestingPatientFactory {
        public Patient createTestingPatient() {
            return new Patient("John", "White", "00000000000", LocalDate.of(2000, 1, 1), "123456789", "test@test.com");
        }
    }

    @Test
    void fullNameIsReturnedCorrectlyTest() {
        TestingPatientFactory factory = new TestingPatientFactory();
        Patient testingPatient = factory.createTestingPatient();
        String fullNameUnderTests = testingPatient.getFullName();
        String expectedFullName = "John White";
        Assertions.assertEquals(expectedFullName, fullNameUnderTests);
    }

    @Test
    void ageIsCalculatedCorrectlyTest() {
        TestingPatientFactory factory = new TestingPatientFactory();
        Patient testingPatient = factory.createTestingPatient();
        int age = testingPatient.calculateAge();
        int expectedAge = 24;
        Assertions.assertEquals(expectedAge, age);
    }
}
