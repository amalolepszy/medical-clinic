package pl.wsb.lab;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public class Clinic {
    private DoctorRegistry doctorRegistry;
    private PatientRegistry patientRegistry;
    private PatientVisitTimeTable patientVisitTimeTable;

    public Clinic() {
        doctorRegistry = new DoctorRegistry();
        patientRegistry = new PatientRegistry();
        patientVisitTimeTable = new PatientVisitTimeTable();
    }

    // 1.1
    public void createPatientProfile(String firstName, String lastName, String pesel, LocalDate birthDate,
            String phoneNumber, String eMail) {
        if (patientRegistry.findPatientByPesel(pesel) != null) {
            throw new IllegalArgumentException("Patient with given PESEL already exists.");
        }
        patientRegistry.addPatient(firstName, lastName, pesel, birthDate, phoneNumber, eMail);
    }

    // 1.2
    public String getPatientInfoByPesel(String pesel) {
        Patient patient = patientRegistry.findPatientByPesel(pesel);
        if (patient == null) {
            throw new IllegalArgumentException("Patient with given PESEL doesn't exist.");
        }
        return patient.toString();
    }

    // 1.3
    public String getPatientsInfoByLastName(String lastName) {
        List<Patient> found_patients = patientRegistry.findPatientsByLastName(lastName);
        if (found_patients.isEmpty()) {
            throw new IllegalArgumentException("There are no patients with given last name.");
        }

        String result = "-Patients-\n";
        for (Patient patient : found_patients) {
            result += patient.toString();
            result += "\n-----------------------------------------\n";
        }
        return result;
    }

    // 2.1
    public void createDoctorProfile(String firstName, String lastName, String pesel, LocalDate birthDate,
            String phoneNumber, String eMail, Set<String> specialization) {
        doctorRegistry.addDoctor(firstName, lastName, pesel, birthDate, phoneNumber, eMail, specialization);
    }

    // 2.2
    public void addSpecializationForDoctor(int doctorId, String specialization) {
        Doctor doctor = doctorRegistry.findDoctorById(doctorId);
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor with given ID doesn't exist: '" + doctorId + "'.");
        }
        if (doctor.getSpecialization().contains(specialization)) {
            throw new IllegalArgumentException("Doctor already has given specialization: '" + specialization + "'.");
        }
        doctor.getSpecialization().add(specialization);

    }

    // 2.3
    public String getDoctorInfoById(int doctorId) {
        Doctor doctor = doctorRegistry.findDoctorById(doctorId);
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor with given ID doesn't exist: '" + doctorId + "'.");
        }
        return doctor.toString();
    }

    // 2.4
    public String getDoctorsInfoBySpecialization(String specialization) {
        List<Doctor> found_doctors = doctorRegistry.findDoctorsBySpecialization(specialization);
        if (found_doctors.isEmpty()) {
            throw new IllegalArgumentException("There are no doctors with given specialization.");
        }
        String result = "";
        result = "-Doctors-\n";
        for (Doctor doctor : found_doctors) {
            result += doctor.toString();
            result += "\n-----------------------------------------\n";
        }
        return result;
    }

    // 4.1
    public void createDoctorShift(int doctorId, LocalTime startShift, LocalTime endShift, LocalDate shiftDay) {
        Doctor doctor = doctorRegistry.findDoctorById(doctorId);
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor with given ID doesn't exist: " + doctorId);
        }
        if (startShift == null || endShift == null || shiftDay == null) {
            throw new IllegalArgumentException("Doctor, start time, end time, and shift day must not be null");
        }
        if (startShift.isAfter(endShift) || startShift.equals(endShift)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }

        DoctorShiftRegistry doctorShiftRegistry = doctor.getDoctorShiftRegistry();
        List<DoctorShift> doctorShifts = doctorShiftRegistry.getDoctorShifts();
        for (DoctorShift doctorShift : doctorShifts) {
            if (doctorShift.getShiftDay().isEqual(shiftDay)) {
                throw new IllegalArgumentException("This doctor has timesheet for that day");
            }
        }

        doctorShiftRegistry.addDoctorShift(startShift, endShift, shiftDay);
    }

    // 4.2
    public List<DoctorShift> getDoctorShiftsForNext7Days(int doctorId) {
        Doctor doctor = doctorRegistry.findDoctorById(doctorId);
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor with given ID doesn't exist: " + doctorId);
        }

        return doctor.getDoctorShiftRegistry().getShiftsForFollowingSevenDays(LocalDate.now());
    }

    // 5.1-5.3
    public void BookAppointment(String patientPesel, int doctor_id, LocalDate date, LocalTime startTime) {
        Patient patient = patientRegistry.findPatientByPesel(patientPesel);
        if (patient == null) {
            throw new IllegalArgumentException("Patient with given PESEL doesn't exist: " + patientPesel);
        }

        Doctor doctor = doctorRegistry.findDoctorById(doctor_id);
        if (doctor == null) {
            throw new IllegalArgumentException("This doctor does not exist: " + patientPesel);
        }
        // 5.2
        int defaultVisitTimeMinutes = 15;
        LocalTime endTime = startTime.plusMinutes(defaultVisitTimeMinutes);
        if (!doctor.HasShiftDuringDateAndTime(date, startTime, endTime)) {
            throw new IllegalArgumentException("Selected doctor doesn't work at the given time");
        }
        // 5.3
        if (patientVisitTimeTable.isDoctorAssignedForTime(doctor, date, startTime, endTime)) {
            throw new IllegalArgumentException("Selected doctor already has an appointment booked for selected time");
        }

        patientVisitTimeTable.addPatientVisit(date, startTime, endTime, doctor);
    }
}
