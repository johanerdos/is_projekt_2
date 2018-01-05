package models;

import java.util.ArrayList;

public class ProductRegister {
	private ArrayList<Product>products = new ArrayList<Product>();
	private ArrayList<Specimen>specimens = new ArrayList<Specimen>();
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	public ArrayList<Specimen> getSpecimens() {
		return specimens;
	}
	public void setSpecimens(ArrayList<Specimen> specimens) {
		this.specimens = specimens;
	}
	
	public Product findProduct(String productName) {
		for (Product tempP : products) {
			if(tempP.getProductName().equals(productName)){
				return tempP;
			}
		}
		return null;
	}
	public Specimen findSpecimen(String serialNumber) {
		for (Specimen tempS : specimens) {
			if(tempS.getSerialNumber().equals(serialNumber)) {
				return tempS;
			}
		}
		return null;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	public void addSpecimen(Specimen specimen) {
		specimens.add(specimen);
	}
	public Product removeProduct(String productName) {
		Product tempP = this.findProduct(productName);
		if(tempP != null) {
			products.remove(tempP);
		}
		return null;
	}
	public Specimen removeSpecimen(String serialNumber) {
		Specimen tempS = this.findSpecimen(serialNumber);
		if(tempS != null) {
			specimens.remove(tempS);
		}
		return null;
	}
	public Product changeProduct(String productName, String category, int price) {
			Product tempP = this.findProduct(productName);
			if(tempP != null) {
				tempP.setCategory(category);
				tempP.setPrice(price);
				return tempP;
			}
			return null;
	}
	public String findSpecimenQuantity(Product product) {
		String temp = "";
		temp += "Produkten" + product.getProductName() + "innehåller följande serienummer: " + "\n";
		for(Specimen tmp : specimens) {
			if(tmp.getProduct().equals(product)) {
			temp += "Serienummer #" + tmp.getSerialNumber() + "\n";
			}
		}
		return temp;
	}
	
	public int getSpecimenQuantity(Product product){
		int quantity = 0;
		for(Specimen sp : specimens) {
			if(sp.getProduct().equals(product)) {
				quantity += 1;
			}
		}
		return quantity;
	}
	
	
}
