package oceanFleet;

import java.util.ArrayList;
import java.util.List;

public class VesselUtil {
	private List<Vessel> vesselList ;

	public List<Vessel> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<Vessel> vesselList) {
		this.vesselList = vesselList;
	}
	
	public void addVesselPerformance(Vessel vessel) {
		vesselList.add(vessel);
	}
	public Vessel getVesselById(String vesselId) {
		for(Vessel vessel : vesselList) {
			if(vessel.getVesselId().equals(vesselId)) {
				return vessel;
			}
		}
		return null;
	}
	public List<Vessel> getHighPerformanceVessels() {

	    List<Vessel> highPerformanceList = new ArrayList<>();

	    if (vesselList == null || vesselList.isEmpty()) {
	        return highPerformanceList;
	    }

	    // Step 1: Find highest average speed
	    double maxSpeed = vesselList.get(0).getAverageSpeed();

	    for (Vessel vessel : vesselList) {
	        if (vessel.getAverageSpeed() > maxSpeed) {
	            maxSpeed = vessel.getAverageSpeed();
	        }
	    }

	    // Step 2: Add all vessels having maxSpeed
	    for (Vessel vessel : vesselList) {
	        if (vessel.getAverageSpeed() == maxSpeed) {
	            highPerformanceList.add(vessel);
	        }
	    }

	    return highPerformanceList;
	}

	
	}
