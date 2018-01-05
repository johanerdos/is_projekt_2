package models;

public class Order {
	private String idNumber;
	private String deliveryDate;
	
	public Order (String idNumber, String deliveryDate) {
		this.idNumber = idNumber;
		this.deliveryDate = deliveryDate;
	}
	
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
}
