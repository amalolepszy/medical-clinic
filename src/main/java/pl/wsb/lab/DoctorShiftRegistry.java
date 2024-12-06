package pl.wsb.lab;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DoctorShiftRegistry {

    private List<DoctorShift> doctorShifts;

    public DoctorShiftRegistry() {
        this.doctorShifts = new ArrayList<>();
    }

    public List<DoctorShift> getDoctorShifts() {
        return doctorShifts;
    }

    public void setDoctorShifts(List<DoctorShift> doctorShifts) {
        this.doctorShifts = doctorShifts;
    }

    public void addDoctorShift(LocalTime shiftStart, LocalTime shiftEnd, LocalDate dateOfVisit) {
        DoctorShift newDoctorShift = new DoctorShift(shiftStart, shiftEnd, dateOfVisit);
        doctorShifts.add(newDoctorShift);
    }

    public List<DoctorShift> getShiftsForFollowingSevenDays(LocalDate dayOfVisit) {
        List<DoctorShift> result = new ArrayList<>();
        LocalDate plus7Days = dayOfVisit.plusDays(7);
        for (DoctorShift shift : doctorShifts) {
            if (shift.getShiftDay().isEqual(dayOfVisit) || (shift.getShiftDay().isAfter(dayOfVisit) && shift.getShiftDay().isBefore(plus7Days))) {
                result.add(shift);
            }
        }
        return result;
    }

    public boolean IsShiftDuringDateAndTime(LocalDate date, LocalTime startTime, LocalTime endTime) {
        for (DoctorShift doctorShift : doctorShifts) {
            if (doctorShift.getShiftDay().isEqual(date) && (doctorShift.getShiftStart().isBefore(startTime) || doctorShift.getShiftStart().equals(startTime)) && (doctorShift.getShiftEnd().isAfter(endTime) || doctorShift.getShiftEnd().equals(endTime))) {
                return true;
            }
        }
        return false;
    }
}
