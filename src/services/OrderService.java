package services;

import java.util.ArrayList;
import java.util.List;

import entities.Order;

public class OrderService {
	
	private List<Order> orders = new ArrayList<>();
	
	public List<Order> getOrders() {
		return orders;
	}
}
