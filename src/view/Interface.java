package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import controller.Controller;
import models.Customer;
import models.Order;
import models.OrderLine;
import models.Product;
import models.Specimen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Interface {
	
	
	Controller Controller = new Controller();
	private JFrame frame;
	private JTextField txtCustomerNumber;
	private JTextField txtCustomerAddress;
	private JTextField txtCustomerName;
	private int ad;
	private JTextField txtProductName;
	private JTextField txtCategory;
	private JTextField txtPrice;
	private JTextField txtOrderNumber;
	private JTextField txtDeliveryDate;
	private JTextField txtSerialNumber;
	private JTextField txtOrderLine;
	private JTextField txtQuantity;
	private JTextArea txtOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("JARF");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 930, 945);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblKund = new JLabel("Kund");
		lblKund.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKund.setBounds(38, 26, 69, 20);
		frame.getContentPane().add(lblKund);
		
		txtCustomerNumber = new JTextField();
		txtCustomerNumber.setBounds(38, 86, 146, 26);
		frame.getContentPane().add(txtCustomerNumber);
		txtCustomerNumber.setColumns(10);
		
		txtCustomerAddress = new JTextField();
		txtCustomerAddress.setBounds(38, 138, 146, 26);
		frame.getContentPane().add(txtCustomerAddress);
		txtCustomerAddress.setColumns(10);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(38, 205, 146, 26);
		frame.getContentPane().add(txtCustomerName);
		txtCustomerName.setColumns(10);
		
		JLabel lblSkrivInKundnummer = new JLabel("Skriv in kundnummer");
		lblSkrivInKundnummer.setBounds(38, 60, 170, 20);
		frame.getContentPane().add(lblSkrivInKundnummer);
		
		JLabel lblSkrivInAdress = new JLabel("Skriv in adress");
		lblSkrivInAdress.setBounds(38, 115, 146, 20);
		frame.getContentPane().add(lblSkrivInAdress);
		
		JLabel lblSkrivInNamn = new JLabel("Skriv in namn");
		lblSkrivInNamn.setBounds(38, 180, 117, 20);
		frame.getContentPane().add(lblSkrivInNamn);
		
		JButton btnAddCustomer = new JButton("Lägg till");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String customerNumber = txtCustomerNumber.getText();
				String address = txtCustomerAddress.getText();
				String name = txtCustomerName.getText();
				
				if(!customerNumber.isEmpty() && !address.isEmpty() && !name.isEmpty()) {
					Customer tempC = Controller.findCustomer(customerNumber);
					if(tempC == null) {
						Customer customer = new Customer(customerNumber, address, name);
						Controller.addCustomer(customer);
						txtOutput.setText("Kund tillagd!");
					}
					else {
					txtOutput.setText("Kunden finns redan!");
					}
				}else {
					txtOutput.setText("Vänligen fyll i alla fälten.");
				}
			txtCustomerNumber.setText("");
			txtCustomerAddress.setText("");
			txtCustomerName.setText("");

				
				
			}
		});
		btnAddCustomer.setBounds(38, 262, 115, 29);
		frame.getContentPane().add(btnAddCustomer);
		
		JButton btnRemoveCustomer = new JButton("Ta bort");
		btnRemoveCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String customerNumber = txtCustomerNumber.getText();
				
				if(!customerNumber.isEmpty()) {
					Customer tempC = Controller.findCustomer(customerNumber);
					if(tempC != null) {
						Controller.removeCustomer(customerNumber);
						txtOutput.setText("Kund borttagen!");
					}
					else {
						txtOutput.setText("Kunden finns inte i registret.");
					}
				}else {
					txtOutput.setText("Vänligen fyll i alla fälten");
				}
			txtCustomerNumber.setText("");
				
			}
		});
		btnRemoveCustomer.setBounds(38, 317, 115, 29);
		frame.getContentPane().add(btnRemoveCustomer);
		
		JButton btnHitta = new JButton("Hitta");
		btnHitta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String customerNumber = txtCustomerNumber.getText();
				
				if(!customerNumber.isEmpty()) {
					Customer tempC = Controller.findCustomer(customerNumber);
					if(tempC != null) {
						txtOutput.setText("Systemet hittade kund med namn: " + tempC.getAddress() + " " + "och adressen: " + tempC.getName());
					}
					else {
						txtOutput.setText("Det finns inget kund med det kundnumret.");
					}
				}else {
					txtOutput.setText("Vänligen fyll i alla fälten.");
				}
				
			txtOutput.setText("");
				
			}
		});
		btnHitta.setBounds(187, 262, 115, 29);
		frame.getContentPane().add(btnHitta);
		
		JButton btnndra = new JButton("Ändra");
		btnndra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String customerNumber = txtCustomerNumber.getText();
				String address = txtCustomerAddress.getText();
				String name = txtCustomerName.getText();
				
				
				Customer tempC = Controller.changeCustomer(customerNumber, address, name);
				txtOutput.setText("Kundens informations har ändrats till: " + "\n" + tempC.getName() + "\n" + "och adressen: " + "" +  tempC.getAddress());
				
			}
		});
		btnndra.setBounds(187, 317, 115, 29);
		frame.getContentPane().add(btnndra);
		
		JLabel lblProdukt = new JLabel("Produkt");
		lblProdukt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProdukt.setBounds(383, 26, 69, 20);
		frame.getContentPane().add(lblProdukt);
		
		txtProductName = new JTextField();
		txtProductName.setBounds(383, 86, 146, 26);
		frame.getContentPane().add(txtProductName);
		txtProductName.setColumns(10);
		
		txtCategory = new JTextField();
		txtCategory.setBounds(383, 138, 146, 26);
		frame.getContentPane().add(txtCategory);
		txtCategory.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(383, 205, 146, 26);
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblSkrivInProduktnamn = new JLabel("Skriv in produktnamn");
		lblSkrivInProduktnamn.setBounds(383, 60, 170, 20);
		frame.getContentPane().add(lblSkrivInProduktnamn);
		
		JLabel lblSkrivInKategori = new JLabel("Skriv in kategori");
		lblSkrivInKategori.setBounds(383, 115, 146, 20);
		frame.getContentPane().add(lblSkrivInKategori);
		
		JLabel lblSkrivInPris = new JLabel("Skriv in pris");
		lblSkrivInPris.setBounds(383, 180, 127, 20);
		frame.getContentPane().add(lblSkrivInPris);
		
		JButton btnAddProduct = new JButton("Lägg till");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productName = txtProductName.getText();
				String category = txtCategory.getText();
				Integer price = new Integer(txtPrice.getText());
				
				if(!productName.isEmpty() && !category.isEmpty() && price != null) {
					Product temp = Controller.findProduct(productName);
					if(temp == null) {
						Product product = new Product(productName, category, price);
						Controller.addProduct(product);
						txtOutput.setText("Produkt tillagd!");
					}
					else {
						txtOutput.setText("Produkten finns redan");
					}
				}else {
					txtOutput.setText("Vänligen fyll i alla fälten.");
				}
			txtProductName.setText("");
			txtCategory.setText("");
			txtPrice.setText("");
				
				
			}
		});
		btnAddProduct.setBounds(383, 262, 115, 29);
		frame.getContentPane().add(btnAddProduct);
		
		JButton btnHitta_1 = new JButton("Hitta");
		btnHitta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productName = txtProductName.getText();
				
				if(!productName.isEmpty()) {
					Product product = Controller.findProduct(productName);
					if(product != null) {
						txtOutput.setText("Systemet hittade produkten med namn: " + "\n" + product.getProductName() + "\n" + "kategori: " + product.getCategory() + "\n" + " pris :" + product.getPrice());
				
					}else {
						txtOutput.setText("Produkten med det namnet finns redan!");
					}
				}
				else {
					txtOutput.setText("Du måste fylla i alla fälten.");
				}
			
			txtProductName.setText("");
				
				
			}
		});
		btnHitta_1.setBounds(525, 262, 115, 29);
		frame.getContentPane().add(btnHitta_1);
		
		JButton btnRemoveProduct = new JButton("Ta bort");
		btnRemoveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productName = txtProductName.getText();
				
				if(!productName.isEmpty()) {
					Product temp = Controller.findProduct(productName);
					if(temp != null) {
						Controller.removeProduct(productName);
						txtOutput.setText("Produkten borttagen!");
					}else {
						txtOutput.setText("Det finns ingen produkt med det namnet.");
					}
				}else {
					txtOutput.setText("Vänligen fyll i alla fälten.");
				}
			
			txtOutput.setText("");
				
			}
		});
		btnRemoveProduct.setBounds(383, 317, 115, 29);
		frame.getContentPane().add(btnRemoveProduct);
		
		JButton btnndra_1 = new JButton("Ändra");
		btnndra_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productName = txtProductName.getText();
				String category = txtCategory.getText();
				Integer price = new Integer(txtPrice.getText());
				
				if(!productName.isEmpty() && !category.isEmpty() && price != null) {
					Product p = Controller.changeProduct(productName, category, price);
					txtOutput.setText("Produktens information är ändrad till kategorin: " + "\n" + p.getCategory() + "\n" + " " + "och priset: " + p.getPrice());
				}
				else {
					txtOutput.setText("Vänligen fyll i alla fälten!");
				}
			}
		});
		btnndra_1.setBounds(525, 317, 115, 29);
		frame.getContentPane().add(btnndra_1);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOrder.setBounds(38, 362, 69, 20);
		frame.getContentPane().add(lblOrder);
		
		txtOrderNumber = new JTextField();
		txtOrderNumber.setBounds(38, 434, 146, 26);
		frame.getContentPane().add(txtOrderNumber);
		txtOrderNumber.setColumns(10);
		
		txtDeliveryDate = new JTextField();
		txtDeliveryDate.setBounds(38, 499, 146, 26);
		frame.getContentPane().add(txtDeliveryDate);
		txtDeliveryDate.setColumns(10);
		
		JLabel lblSkrivInOrdernummer = new JLabel("Skriv in ordernummer");
		lblSkrivInOrdernummer.setBounds(38, 398, 170, 20);
		frame.getContentPane().add(lblSkrivInOrdernummer);
		
		JLabel lblSkrivInLeveransdatum = new JLabel("Skriv in leveransdatum");
		lblSkrivInLeveransdatum.setBounds(38, 463, 170, 20);
		frame.getContentPane().add(lblSkrivInLeveransdatum);
		
		JButton btnAddOrder = new JButton("Lägg till");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idNumber = txtOrderNumber.getText();
				String deliveryDate = txtDeliveryDate.getText();
				
				if(!idNumber.isEmpty() && !deliveryDate.isEmpty()) {
					Order temp = Controller.findOrder(idNumber);
					if(temp == null) {
						Order o =  new Order(idNumber, deliveryDate);
						Controller.addOrder(o);
						txtOutput.setText("Order tillagd!");
					}
					else {
						txtOutput.setText("Ordern finns redan.");
					}
				}else {
					txtOutput.setText("Vänligen fyll i alla fälten");
				}
				
			}
		});
		btnAddOrder.setBounds(38, 541, 115, 29);
		frame.getContentPane().add(btnAddOrder);
		
		JButton btnRemoveOrder = new JButton("Ta bort");
		btnRemoveOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idNumber = txtOrderNumber.getText();
				
				if(!idNumber.isEmpty()) {
					Order temp = Controller.findOrder(idNumber);
					if(temp != null) {
						Controller.removeOrder(idNumber);
						txtOutput.setText("Ordern borttagen!");
					}
					else {
						txtOutput.setText("Det finns ingen order att ta bort.");
					}
				}else {
					txtOutput.setText("Vänligen fyll i alla fälten");
				}
				
				
			}
		});
		btnRemoveOrder.setBounds(40, 586, 115, 29);
		frame.getContentPane().add(btnRemoveOrder);
		
		JLabel lblExemplar = new JLabel("Exemplar");
		lblExemplar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblExemplar.setBounds(383, 362, 95, 20);
		frame.getContentPane().add(lblExemplar);
		
		txtSerialNumber = new JTextField();
		txtSerialNumber.setBounds(383, 434, 146, 26);
		frame.getContentPane().add(txtSerialNumber);
		txtSerialNumber.setColumns(10);
		
		JLabel lblSkrivInSerienummer = new JLabel("Skriv in serienummer");
		lblSkrivInSerienummer.setBounds(383, 398, 170, 20);
		frame.getContentPane().add(lblSkrivInSerienummer);
		
		JButton btnAddSpecimen = new JButton("Lägg till");
		btnAddSpecimen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String serialNumber = txtSerialNumber.getText();
				String productName = txtProductName.getText();
				
				Specimen temp = Controller.findSpecimen(serialNumber);
				Product p = Controller.findProduct(productName);
				
				if(p != null && temp == null) {
					Specimen specimen = new Specimen(productName, p);
					Controller.addSpecimen(specimen);
					txtOutput.setText("Exemplar tillagt till produkten: " + "\n" + p.getProductName());
				}
				else {
					txtOutput.setText("Antingen finns inte produkten eller så finns exemplaret redan.");
				}
			
			txtSerialNumber.setText("");
				
				
				
			}
		});
		btnAddSpecimen.setBounds(383, 498, 115, 29);
		frame.getContentPane().add(btnAddSpecimen);
		
		txtOutput = new JTextArea();
		txtOutput.setLineWrap(true);
		txtOutput.setBounds(40, 660, 744, 177);
		frame.getContentPane().add(txtOutput);
		
		JLabel lblOrderrad = new JLabel("Orderrad");
		lblOrderrad.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOrderrad.setBounds(719, 26, 95, 20);
		frame.getContentPane().add(lblOrderrad);
		
		JLabel lblSkrivInRadnummer = new JLabel("Skriv in radnummer");
		lblSkrivInRadnummer.setBounds(719, 60, 146, 20);
		frame.getContentPane().add(lblSkrivInRadnummer);
		
		txtOrderLine = new JTextField();
		txtOrderLine.setBounds(719, 86, 146, 26);
		frame.getContentPane().add(txtOrderLine);
		txtOrderLine.setColumns(10);
		
		JLabel lblSkrivInAntal = new JLabel("Skriv in antal");
		lblSkrivInAntal.setBounds(719, 115, 146, 20);
		frame.getContentPane().add(lblSkrivInAntal);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(719, 138, 146, 26);
		frame.getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JButton btnAddOrderLine = new JButton("Lägg till");
		btnAddOrderLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = txtOrderLine.getText();
				Integer quantity = new Integer(txtQuantity.getText());
				String productName = txtProductName.getText();
				String idNumber = txtOrderNumber.getText();
				
				Order order = Controller.findOrder(idNumber);
				Product product = Controller.findProduct(productName);
				
				OrderLine temp = Controller.findOrderLine(number);
				
				if(temp == null && product != null && order != null) {
					OrderLine orderline = new OrderLine(idNumber, quantity, product, order);
					
					if(quantity < Controller.getSpecimenQuantity(product)) {
						Controller.addOrderLine(orderline);
						txtOutput.setText("Orderraden tillagd till ordernumret: " + "\n" + order.getIdNumber());
					}
					else if(quantity > Controller.getSpecimenQuantity(product)) {
						txtOutput.setText("Ordern innehåller fler exemplar än vad som finns i lagret");
					}
				}
				else {
					txtOutput.setText("Antingen finns orderraden redan eller så finns inte produkten eller ordern");
				}
			txtOrderLine.setText("");
			txtQuantity.setText("");
				
				
			}
		});
		btnAddOrderLine.setBounds(719, 204, 115, 29);
		frame.getContentPane().add(btnAddOrderLine);
		
		JButton btnRemoveSpecimen = new JButton("Ta bort");
		btnRemoveSpecimen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String serialNumber = txtSerialNumber.getText();
				String productName = txtProductName.getText();
				
				Product p = Controller.findProduct(productName);
				Specimen z = Controller.findSpecimen(serialNumber);
				if(z != null) {
					Controller.removeSpecimen(serialNumber);
					txtOutput.setText("Exemplaret borttaget för produkten: " + "\n" + p.getProductName());
				}
				else {
					txtOutput.setText("Exemplaret finns inte!");
				}
			}
		});
		btnRemoveSpecimen.setBounds(383, 543, 115, 29);
		frame.getContentPane().add(btnRemoveSpecimen);
		
		JButton btnShowTotalAmount = new JButton("Visa totalbelopp");
		btnShowTotalAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int totalAmount = Controller.totalAmount(txtOrderNumber.getText());
				txtOutput.setText("Det totala beloppet ordern är: " + "\n" + totalAmount);
				
				
			}
		});
		btnShowTotalAmount.setBounds(187, 586, 155, 29);
		frame.getContentPane().add(btnShowTotalAmount);
	}

}
