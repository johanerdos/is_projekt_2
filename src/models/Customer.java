package models;

public class Customer {
	private String customerNumber;
	private String name;
	private String address;
	
	public Customer (String customerNumber, String name, String address) {
		this.customerNumber = customerNumber;
		this.name = name;
		this.address = address;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
}
