package pl.wsb.lab;

import java.time.LocalDate;
import java.time.LocalTime;

public class DoctorShift {

    private Doctor doctor;

    private LocalTime shiftStart;
    private LocalTime shiftEnd;
    private LocalDate shiftDay;

    public DoctorShift(Doctor doctor, LocalTime shiftStart, LocalTime shiftEnd, LocalDate shiftDay) {
        this.doctor = doctor;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.shiftDay = shiftDay;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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
        return "DoctorShift{" +
                "doctor=" + doctor +
                ", shiftStart=" + shiftStart +
                ", shiftEnd=" + shiftEnd +
                ", shiftDay=" + shiftDay +
                '}';
    }
}
