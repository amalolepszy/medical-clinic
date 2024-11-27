package pl.wsb.lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PatientTest {

    private class testingPatientFactory {
        public Patient getTestingPatient() {
            return new Patient("John", "White", "00000000000", LocalDate.of(2000, 1, 1), "123456789", "test@test.com");
        }
    }

    @Test
    void checkIfFullNameIsReturnedCorrectly() {
        testingPatientFactory factory = new testingPatientFactory();
        Patient testingPatient = factory.getTestingPatient();
        String fullNameUnderTests = testingPatient.getFullName();
        String expectedFullName = "John White";
        Assertions.assertEquals(expectedFullName, fullNameUnderTests);
    }

    @Test
    void checkAgeIsCalculatedCorrectly() {
        testingPatientFactory factory = new testingPatientFactory();
        Patient testingPatient = factory.getTestingPatient();
        int age = testingPatient.calculateAge();
        int expectedAge = 24;
        Assertions.assertEquals(age, expectedAge);
    }
}
