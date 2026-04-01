package foodDelivery;

public class Order {
	
private String orderId;
private String orderType;
private double orderQuantity;
private String paymentType;

public Order(String orderId, String orderType, double orderQuantity, String paymentType) {
	super();
	this.orderId = orderId;
	this.orderType = orderType;
	this.orderQuantity = orderQuantity;
	this.paymentType = paymentType;
}

public String getOrderId() {
	return orderId;
}

public void setOrderId(String orderId) {
	this.orderId = orderId;
}

public String getOrderType() {
	return orderType;
}

public void setOrderType(String orderType) {
	this.orderType = orderType;
}

public double getOrderQuantity() {
	return orderQuantity;
}

public void setOrderQuantity(double orderQuantity) {
	this.orderQuantity = orderQuantity;
}

public String getPaymentType() {
	return paymentType;
}

public void setPaymentType(String paymentType) {
	this.paymentType = paymentType;
}


}
