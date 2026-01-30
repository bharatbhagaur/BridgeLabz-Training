package streamapi;

import java.util.*;
class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;

    Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    public boolean isAvailableOnWeekend() {
        return availableOnWeekend;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getName() {
        return name;
    }
}

public class Hospital {
    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Amit", "Cardiology", true),
            new Doctor("Dr. Neha", "Neurology", false),
            new Doctor("Dr. Ravi", "Orthopedic", true),
            new Doctor("Dr. Pooja", "Dermatology", true),
            new Doctor("Dr. Karan", "Neurology", true)
        );

        doctors.stream()
               .filter(Doctor::isAvailableOnWeekend)   // weekend doctors
               .sorted(Comparator.comparing(Doctor::getSpecialty))
               .forEach(d ->
                   System.out.println(d.getName() + " | "
                           + d.getSpecialty())
               );
    }
}

