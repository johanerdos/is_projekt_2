package models;

import java.util.ArrayList;

public class CustomerRegister {
	private ArrayList<Customer>customers = new ArrayList<Customer>();
	private ArrayList<Order>orders = new ArrayList<Order>();
	private ArrayList<OrderLine>orderLines = new ArrayList<OrderLine>();
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}
	public Order findOrder(String idNumber) {
		for (Order tempO : orders ) {
			if(tempO.getIdNumber().equals(idNumber)) {
				return tempO;
			}
		}
		return null;
	}
	public Customer findCustomer(String customerNumber) {
		for(Customer tempC : customers) {
			if(tempC.getCustomerNumber().equals(customerNumber)) {
				return tempC;
			}
		}
		return null;
	}
	public OrderLine findOrderLine(String number) {
		for(OrderLine tempO : orderLines) {
			if(tempO.getNumber().equals(number)) {
				return tempO;
			}
		}
		return null;
	}
	public Customer removeCustomer(String customerNumber) {
		Customer tempC = this.findCustomer(customerNumber);
		if(tempC != null) {
			customers.remove(tempC);
		}
		return null;
	}
	public Order removeOrder(String idNumber) {
		Order tempO = this.findOrder(idNumber);
		if(tempO != null) {
			orders.remove(tempO);
		}
		return null;
	}
	public OrderLine removeOrderLine(String number) {
		OrderLine tempO = this.findOrderLine(number);
		if(tempO != null) {
			orderLines.remove(tempO);
		}
		return null;
	}
	public Customer changeCustomer(String customerNumber, String name, String address) {
		Customer tempC = this.findCustomer(customerNumber);
		if(tempC != null) {
			tempC.setName(name);
			tempC.setAddress(address);
			return tempC;
		}
		return null;
	}
	public int totalAmount(String idNumber) {
		int total = 0;
		for(OrderLine orderline : orderLines) {
			if(orderline.getOrder().getIdNumber().equals(idNumber)) {
				total += (orderline.getProduct().getPrice() * orderline.getQuantity());
			}
		}
		return total;
	}
	
	
}
