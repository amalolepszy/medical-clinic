package pl.wsb.lab;

import java.time.LocalDate;
import java.time.LocalTime;

public class PatientVisit {

    private final LocalDate visitDate;
    private final LocalTime visitStart;
    private final LocalTime visitEnd;
    private final Doctor assignedDoctor;
    private final Patient patient;

    public PatientVisit(LocalDate visitDate, LocalTime visitStart, LocalTime visitEnd, Doctor assignedDoctor, Patient patient) {
        this.visitDate = visitDate;
        this.visitStart = visitStart;
        this.visitEnd = visitEnd;
        this.assignedDoctor = assignedDoctor;
        this.patient = patient;
    }

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public LocalTime getVisitStart() {
        return visitStart;
    }

    public LocalTime getVisitEnd() {
        return visitEnd;
    }
}
