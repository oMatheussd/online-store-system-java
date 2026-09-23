package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import services.OrderException;

public class Order {

	private long id;
	private LocalDateTime moment;
	private OrderStatus status;
	private Customer custumer;

	private List<OrderItem> itens = new ArrayList<>();

	public Order(long id, Customer custumer) {
		this.id = id;
		this.moment = LocalDateTime.now();
		this.status = OrderStatus.WAITING_PAYMENT;
		this.custumer = custumer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Customer getCustumer() {
		return custumer;
	}

	public void setCustumer(Customer custumer) {
		this.custumer = custumer;
	}

	public List<OrderItem> getItens() {
		return itens;
	}

	public void addItem(OrderItem item) {
		if (item.getQuantity() < 1) {
			throw new OrderException("The quantity of an item must be greater than zero.");
		}

		if (item.getPrice() < 0.0) {
			throw new OrderException("The price of a product cannot be negative.");
		}

		itens.add(item);
	}

	public void removeItem(OrderItem item) {
		itens.remove(item);
	}

	public double calculateSubtotal() {
		double total = 0;

		for (OrderItem i : itens) {
			total += i.subtotal();
		}
		return total;
	}

	private double discount() {
		double discountPercentage = 0.0;

		if (calculateSubtotal() > 500.00 && calculateSubtotal() <= 1500.00) {
			discountPercentage = 0.05;
		}
		if (calculateSubtotal() > 1500.00) {
			discountPercentage = 0.1;
		}
		
		double discount = calculateSubtotal() * discountPercentage;

		return discount;
	}

	public double total() {
		return calculateSubtotal() - discount();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		sb.append("ORDER SUMMARY: \n\n");

		sb.append("Order id: " + id + "\n");
		sb.append("Order moment: " + moment.format(fmt) + "\n");
		sb.append("Order status: " + status + "\n\n");

		sb.append("Custumer: \n");
		sb.append(custumer.getName() + "\n");
		sb.append(custumer.getEmail() + "\n");
		sb.append(custumer.getPhone() + "\n\n");
		sb.append("Order items: \n");
		for (OrderItem o : itens) {
			sb.append(o + "\n");
		}

		sb.append("\n");
		sb.append("Subtotal: $ " + String.format("%.2f", calculateSubtotal()) + ("\n"));
		sb.append("Discount: $ " + String.format("%.2f", discount()) + ("\n"));
		sb.append("Total: $ " + String.format("%.2f", total()) + ("\n"));

		return sb.toString();
	}
}
