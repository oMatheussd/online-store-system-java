package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Custumer;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import services.OrderService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		OrderService os = new OrderService();

		System.out.println("Enter customer data: ");
		System.out.println();
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Phone: ");
		String phone = sc.nextLine();

		Custumer c1 = new Custumer(name, email, phone);

		System.out.println();
		System.out.println("Enter order data:");
		System.out.print("Order id: ");
		long id = sc.nextLong();

		Order o1 = new Order(id, c1);

		System.out.println();
		System.out.print("How many items to this order? ");
		int quantity = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < quantity; i++) {
			System.out.println();
			System.out.println("Enter item #" + (i + 1) + ":");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			sc.nextLine();
			
			Product p = new Product(productName, productPrice);
			OrderItem item = new OrderItem(productQuantity, productPrice, p);
			o1.addItem(item);
			
		}
		
		os.addOrder(o1);

		sc.close();
	}
}
