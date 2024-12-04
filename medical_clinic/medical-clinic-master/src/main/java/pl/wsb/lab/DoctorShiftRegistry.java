package pl.wsb.lab;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DoctorShiftRegistry {

    private List<DoctorShift> doctorShifts;

    public DoctorShiftRegistry(List<DoctorShift> doctorShifts) {
        this.doctorShifts = doctorShifts;
    }

    public List<DoctorShift> getDoctorShifts() {
        return doctorShifts;
    }

    public void setDoctorShifts(List<DoctorShift> doctorShifts) {
        this.doctorShifts = doctorShifts;
    }

    public void addDoctorShift(Doctor doctor, LocalTime shiftStart, LocalTime shiftEnd, LocalDate dateOfVisit){
        DoctorShift newDoctorShift = new DoctorShift(doctor,shiftStart,shiftEnd,dateOfVisit);
        doctorShifts.add(newDoctorShift);
    }

    public List<DoctorShift> listShiftForNextSevenDays(Doctor doctor, LocalDate dayOfVisit){
        List<DoctorShift> result = new ArrayList<>();
        LocalDate plus7Days = dayOfVisit.plusDays(7);
        for(DoctorShift shift: doctorShifts){
            if (shift.getDoctor().equals(doctor) &&
                    (shift.getShiftDay().isEqual(dayOfVisit) ||
                            (shift.getShiftDay().isAfter(dayOfVisit) && shift.getShiftDay().isBefore(plus7Days))))
                result.add(shift);
            }
        return result;
    }
}
