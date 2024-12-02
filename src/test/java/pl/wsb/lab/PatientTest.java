package pl.wsb.lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PatientTest {

    private class TestingPatientFactory {
        public Patient createTestingPatient() {
            return new Patient("John", "White", "00000000000", LocalDate.of(2000, 1, 1), "123456789", "test@test.com");
        }
    }

    @Test
    void fullNameIsReturnedCorrectly() {
        TestingPatientFactory factory = new TestingPatientFactory();
        Patient testingPatient = factory.createTestingPatient();
        String fullNameUnderTests = testingPatient.getFullName();
        String expectedFullName = "John White";
        Assertions.assertEquals(expectedFullName, fullNameUnderTests);
    }

    @Test
    void ageIsCalculatedCorrectly() {
        TestingPatientFactory factory = new TestingPatientFactory();
        Patient testingPatient = factory.createTestingPatient();
        int age = testingPatient.calculateAge();
        int expectedAge = 24;
        Assertions.assertEquals(age, expectedAge);
    }
}
