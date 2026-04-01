package foodDelivery;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

public class DeliveryService {

	Queue<Order> storeOrders=new LinkedList<>();
	
	List<Agent> storeDeliveryAgents = new LinkedList<>();	
	  // Active deliveries: OrderId -> Agent
    HashMap<String, Agent> activeDeliveries = new HashMap<>();
	
    // Add agent
	public void addAgent(Agent agent) {
		storeDeliveryAgents.add(agent);
	}
	 // Add order (FIFO)
	public void addOrder(Order order) {
		storeOrders.offer(order);
	} 
	// Assign order FIFO to nearest available agent
	public void assignOrder() throws NoAgentAvailableException{
		Order order = storeOrders.poll();
		if(order==null) {
		       System.out.println("No orders to assign");
			return;
		}
		Agent nearestAgent=null;
		// nearest = first available
		for(Agent agent :storeDeliveryAgents) {
			if(agent.isAvailable()) {
				nearestAgent=agent;
				break;
			}
		}
		if(nearestAgent==null) {
			storeOrders.offer(order);
			throw new NoAgentAvailableException("Agent is not available");
		}
		 // Assign order
        nearestAgent.setAvailable(false);
        activeDeliveries.put(order.getOrderId(), nearestAgent);
        

        System.out.println("Order " + order.getOrderId() + " assigned to Agent " + nearestAgent.getAgentName());
	}
	  // Cancel delivery
    public void cancelOrder(String orderId) {

        Agent agent = activeDeliveries.remove(orderId);

        if (agent != null) {
            agent.setAvailable(true);
            System.out.println("Order " + orderId + " cancelled. Agent is now available.");
        } else {
            System.out.println("Order not found in active deliveries.");
        }
    }

    // View active deliveries
    public void viewActiveDeliveries() {

        if (activeDeliveries.isEmpty()) {
            System.out.println("No active deliveries");
            return;
        }

        for (Entry<String, Agent> entry : activeDeliveries.entrySet()) {
            System.out.println("OrderId: " + entry.getKey() +
                    " | Agent: " + entry.getValue().getAgentName() +
                    " | Mobile: " + entry.getValue().getAgentMobileNumber());
        }
    }
}
		
	;

