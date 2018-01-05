package controller;

import models.CustomerRegister;
import models.ProductRegister;
import models.Customer;
import models.Order;
import models.OrderLine;
import models.Product;
import models.Specimen;

public class Controller {
	ProductRegister productRegister = new ProductRegister();
	CustomerRegister customerRegister = new CustomerRegister();
	
	public void addCustomer(Customer customer) {
		customerRegister.addCustomer(customer);
	}
	public void addProduct(Product product) {
		productRegister.addProduct(product);
	}
	public void addOrder(Order order) {
		customerRegister.addOrder(order);
	}
	public void addOrderLine(OrderLine orderLine) {
		customerRegister.addOrderLine(orderLine);
	}
	public void addSpecimen(Specimen specimen) {
		productRegister.addSpecimen(specimen);
	}
	public Customer findCustomer(String customerNumber) {
		return customerRegister.findCustomer(customerNumber);
		
	}
	public Product findProduct(String productName) {
		return productRegister.findProduct(productName);
	}
	public Order findOrder(String idNumber) {
		return customerRegister.findOrder(idNumber);
	}
	public OrderLine findOrderLine(String number) {
		return customerRegister.findOrderLine(number);
	}
	public Specimen findSpecimen(String serialNumber) {
		return productRegister.findSpecimen(serialNumber);
	}
	public void removeCustomer(String customerNumber) {
		customerRegister.removeCustomer(customerNumber);
	}
	public void removeProduct(String productName) {
		productRegister.removeProduct(productName);
	}
	public void removeOrder(String idNumber) {
		customerRegister.removeOrder(idNumber);
	}
	public void removeOrderLine(String number) {
		customerRegister.removeOrderLine(number);
	}
	public void removeSpecimen(String serialNumber) {
		productRegister.removeSpecimen(serialNumber);
	}
	public Customer changeCustomer(String customerNumber, String address, String name) {
		return customerRegister.changeCustomer(customerNumber, name, address);
	}
	public Product changeProduct(String productName, String category, int price) {
		return productRegister.changeProduct(productName, category, price);
	}
	public int totalAmount(String idNumber) {
		return customerRegister.totalAmount(idNumber);
	}
	public int getSpecimenQuantity(Product product) {
		return productRegister.getSpecimenQuantity(product);
	}
	

}
