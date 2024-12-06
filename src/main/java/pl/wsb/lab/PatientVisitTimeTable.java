package pl.wsb.lab;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PatientVisitTimeTable {
    List<PatientVisit> patientVisits;

    public PatientVisitTimeTable() {
        this.patientVisits = new ArrayList<>();
    }

    void addPatientVisit(LocalDate visitDate, LocalTime visitStart, LocalTime visitEnd, Doctor assignedDoctor) {
        PatientVisit patientVisit = new PatientVisit(visitDate, visitStart, visitEnd, assignedDoctor);
        patientVisits.add(patientVisit);
    }

    // Checks whether given time intersects with any of the stored visits.
    boolean isDoctorAssignedForTime(Doctor doctor, LocalDate date, LocalTime startTime, LocalTime endTime) {
        for (PatientVisit patientVisit : patientVisits) {
            if (patientVisit.getAssignedDoctor() == doctor && patientVisit.getVisitDate().isEqual(date)
                    && (patientVisit.getVisitStart().equals(startTime)
                            || (startTime.isBefore(patientVisit.getVisitStart())
                                    && endTime.isAfter(patientVisit.getVisitStart()))
                            || (startTime.isBefore(patientVisit.getVisitEnd())
                                    && endTime.isAfter(patientVisit.getVisitEnd())))) {
                return true;
            }
        }
        return false;
    }
}
