package lamdaexpression;

import java.util.*;

public class HospitalPatientIdPrint {

    public static void main(String[] args) {

        // List of patient IDs
        List<Integer> patientIds = Arrays.asList(
                101, 102, 103, 104, 105
        );

        // Printing patient IDs using method reference
        patientIds.forEach(System.out::println);
    }
}
