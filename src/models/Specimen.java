package models;

public class Specimen {
	private String serialNumber;
	private Product product;
	
	public Specimen(String serialNumber, Product product) {
		this.serialNumber = serialNumber;
		this.product = product;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
