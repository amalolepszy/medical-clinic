package pl.wsb.lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

public class DoctorTest {

    private class TestingDoctorFactory {
        public Doctor createTestingDoctor() {
            return new Doctor("John", "White", "00000000000", LocalDate.of(2000, 1, 1), "123456789", "test@test.com", 0, Set.of("one", "two", "three"));
        }
    }

    @Test
    void toStringContainsProperInfo() {
        DoctorTest.TestingDoctorFactory factory = new DoctorTest.TestingDoctorFactory();
        Doctor doc = factory.createTestingDoctor();
        Assertions.assertTrue(doc.toString().contains("John"));
        Assertions.assertTrue(doc.toString().contains("123456789"));
        Assertions.assertTrue(doc.toString().contains("two"));
    }
}
