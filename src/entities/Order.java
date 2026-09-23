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
}
