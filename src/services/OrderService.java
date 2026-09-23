package services;

import java.util.ArrayList;
import java.util.List;

import entities.Order;

public class OrderService {
	
	private List<Order> orders = new ArrayList<>();
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void addOrder(Order order) {
		if(order.getItens().size() == 0) {
			throw new OrderException("An order cannot be finalized without at least one item.");
		}
		orders.add(order);
	}
}
