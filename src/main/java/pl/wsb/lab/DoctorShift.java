package pl.wsb.lab;

import java.time.LocalDate;
import java.time.LocalTime;

public class DoctorShift {
    private LocalTime shiftStart;
    private LocalTime shiftEnd;
    private LocalDate shiftDay;

    public DoctorShift(LocalTime shiftStart, LocalTime shiftEnd, LocalDate shiftDay) {
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.shiftDay = shiftDay;
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
        return "Shift Start: " + shiftStart + ", Shift End: " + shiftEnd + ", Shift Day: " + shiftDay;
    }
}
