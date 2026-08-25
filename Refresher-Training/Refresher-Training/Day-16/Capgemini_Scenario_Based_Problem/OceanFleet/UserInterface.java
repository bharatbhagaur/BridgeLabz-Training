import java.util.*;

class Vessel {

    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    // No-argument constructor
    public Vessel() {
    }

    // Four-argument constructor
    public Vessel(String vesselId, String vesselName,
                  double averageSpeed, String vesselType) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }

    // Getters and Setters

    public String getVesselId() {
        return vesselId;
    }

    public void setVesselId(String vesselId) {
        this.vesselId = vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }
}


class VesselUtil {

    private List<Vessel> vesselList;

    public VesselUtil() {
        vesselList = new ArrayList<>();
    }

    public List<Vessel> getVesselList() {
        return vesselList;
    }

    public void setVesselList(List<Vessel> vesselList) {
        this.vesselList = vesselList;
    }

    // Requirement 1
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    // Requirement 2
    public Vessel getVesselById(String vesselId) {

        for (Vessel vessel : vesselList) {

            // equals() is case-sensitive
            if (vessel.getVesselId().equals(vesselId)) {
                return vessel;
            }
        }

        return null;
    }

    // Requirement 3
    public List<Vessel> getHighPerformanceVessels() {

        List<Vessel> result = new ArrayList<>();

        if (vesselList.isEmpty()) {
            return result;
        }

        // Find highest speed
        double maxSpeed = vesselList.get(0).getAverageSpeed();

        for (Vessel vessel : vesselList) {

            if (vessel.getAverageSpeed() > maxSpeed) {
                maxSpeed = vessel.getAverageSpeed();
            }
        }

        // Add all vessels having highest speed
        for (Vessel vessel : vesselList) {

            if (vessel.getAverageSpeed() == maxSpeed) {
                result.add(vessel);
            }
        }

        return result;
    }
}


public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VesselUtil util = new VesselUtil();

        System.out.println("Enter the number of vessels to be added");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter vessel details");

        for (int i = 0; i < n; i++) {

            String input = sc.nextLine();

            // vesselId:vesselName:averageSpeed:vesselType
            String[] data = input.split(":");

            String vesselId = data[0];
            String vesselName = data[1];
            double averageSpeed = Double.parseDouble(data[2]);
            String vesselType = data[3];

            Vessel vessel = new Vessel(
                    vesselId,
                    vesselName,
                    averageSpeed,
                    vesselType
            );

            util.addVesselPerformance(vessel);
        }

        System.out.println("Enter the Vessel Id to check speed");

        String searchId = sc.nextLine();

        Vessel vessel = util.getVesselById(searchId);

        if (vessel != null) {

            System.out.println(
                    vessel.getVesselId() + " | " +
                    vessel.getVesselName() + " | " +
                    vessel.getVesselType() + " | " +
                    vessel.getAverageSpeed() + " knots"
            );

        } else {

            System.out.println(
                    "Vessel Id " + searchId + " not found"
            );
        }

        System.out.println("High performance vessels are");

        List<Vessel> highPerformance =
                util.getHighPerformanceVessels();

        for (Vessel v : highPerformance) {

            System.out.println(
                    v.getVesselId() + " | " +
                    v.getVesselName() + " | " +
                    v.getVesselType() + " | " +
                    v.getAverageSpeed() + " knots"
            );
        }

        sc.close();
    }
}