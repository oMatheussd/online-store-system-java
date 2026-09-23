package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private long id;
	private LocalDate moment;
	private OrderStatus status;
	private Custumer custumer;

	private List<OrderItem> itens = new ArrayList<>();

	public Order(long id, Custumer custumer) {
		this.id = id;
		this.moment = LocalDate.now();
		this.status = OrderStatus.WAITING_PAYMENT;
		this.custumer = custumer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getMoment() {
		return moment;
	}

	public void setMoment(LocalDate moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Custumer getCustumer() {
		return custumer;
	}

	public void setCustumer(Custumer custumer) {
		this.custumer = custumer;
	}

	public List<OrderItem> getItens() {
		return itens;
	}

	public void addItem(OrderItem item) {
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
	
	public double total() {
		double discountPercentage = 0.0;
		double discount = calculateSubtotal() * discountPercentage;
		
		if (calculateSubtotal() > 500.00 && calculateSubtotal() <= 1500.00) {
			discountPercentage = 0.05;
		}
		if (calculateSubtotal() > 1500.00) {
			discountPercentage = 0.1;
		}
		
		return calculateSubtotal() - discount;
	}
	
	public void changeStatus(Order order, OrderStatus status) {
		order.setStatus(status);
	}
}
