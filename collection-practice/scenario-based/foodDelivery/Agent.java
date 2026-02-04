package foodDelivery;

public class Agent {
private String agentId;
private String agentName;
private String agentMobileNumber;
public boolean isAvailable;
public Agent(String agentId, String agentName, String agentMobileNumber, boolean isAvailable) {
	super();
	this.agentId = agentId;
	this.agentName = agentName;
	this.agentMobileNumber = agentMobileNumber;
	this.isAvailable = isAvailable;
}

public String getAgentId() {
	return agentId;
}
public void setAgentId(String agentId) {
	this.agentId = agentId;
}
public String getAgentName() {
	return agentName;
}
public void setAgentName(String agentName) {
	this.agentName = agentName;
}
public String getAgentMobileNumber() {
	return agentMobileNumber;
}
public void setAgentMobileNumber(String agentMobileNumber) {
	this.agentMobileNumber = agentMobileNumber;
}

public boolean isAvailable() {
	return isAvailable;
}

public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}



}
