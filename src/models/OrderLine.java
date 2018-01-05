package models;

public class OrderLine {
	private String number;
	private int quantity;
	private Product product;
	private Order order;
	
	public OrderLine (String number, int quantity, Product product, Order order) {
		this.number = number;
		this.quantity = quantity;
		this.product = product;
		this.order = order;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
