package pl.wsb.lab;

import java.time.LocalDate;
import java.time.LocalTime;

public class PatientVisit {

    private LocalDate visitDate;
    private LocalTime visitStart;
    private LocalTime visitEnd;
    private Doctor assignedDoctor;

    public PatientVisit(LocalDate visitDate, LocalTime visitStart, LocalTime visitEnd, Doctor assignedDoctor) {
        this.visitDate = visitDate;
        this.visitStart = visitStart;
        this.visitEnd = visitEnd;
        this.assignedDoctor = assignedDoctor;
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
