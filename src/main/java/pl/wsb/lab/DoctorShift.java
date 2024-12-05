package pl.wsb.lab;

import java.time.LocalDate;
import java.time.LocalTime;

public class DoctorShift {

    private Doctor assignedDoctor;
    private LocalTime shiftStart;
    private LocalTime shiftEnd;
    private LocalDate shiftDay;

    public DoctorShift(Doctor doctor, LocalTime shiftStart, LocalTime shiftEnd, LocalDate shiftDay) {
        this.assignedDoctor = doctor;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.shiftDay = shiftDay;
    }

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(Doctor doctor) {
        this.assignedDoctor = doctor;
    }

    public LocalTime getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(LocalTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public LocalTime getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(LocalTime shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    public LocalDate getShiftDay() {
        return shiftDay;
    }

    public void setShiftDay(LocalDate shiftDay) {
        this.shiftDay = shiftDay;
    }

    @Override
    public String toString() {
        return "Doctor Shift: " +
                "Assigned Doctor: " + assignedDoctor +
                ", Shift Start: " + shiftStart +
                ", Shift End: " + shiftEnd +
                ", Shift Day: " + shiftDay;
    }
}
