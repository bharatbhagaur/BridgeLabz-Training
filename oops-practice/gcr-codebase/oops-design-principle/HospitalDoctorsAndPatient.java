import java.util.*;

class Patient {
    String name;

    // constructor to initialize patient
    Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;
    ArrayList<Patient> patients; // association: doctor sees multiple patients

    // constructor to initialize doctor
    Doctor(String name) {
        this.name = name;
        patients = new ArrayList<>();
    }

    // method to show communication between doctor and patient
    void consult(Patient p) {
        patients.add(p);
        System.out.println("Doctor " + name + " is consulting patient " + p.name);
    }
}

class Hospital {
    String hospitalName;
    ArrayList<Doctor> doctors;
    ArrayList<Patient> patients;

    // constructor to initialize hospital
    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    // add doctor to hospital
    void addDoctor(Doctor d) {
        doctors.add(d);
    }

    // add patient to hospital
    void addPatient(Patient p) {
        patients.add(p);
    }
}

public class HospitalDoctorsAndPatient {
    public static void main(String[] args) {
        // creating hospital
        Hospital hospital = new Hospital("City Hospital");

        // creating doctors
        Doctor d1 = new Doctor("Dr. Rao");
        Doctor d2 = new Doctor("Dr. Singh");

        // creating patients
        Patient p1 = new Patient("Amit");
        Patient p2 = new Patient("Neha");

        // adding doctors and patients to hospital
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        // consultations (association + communication)
        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);
    }
}