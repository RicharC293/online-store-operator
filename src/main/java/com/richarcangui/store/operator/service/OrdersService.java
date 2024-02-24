package com.richarcangui.store.operator.service;

import com.richarcangui.store.operator.model.db.Order;
import com.richarcangui.store.operator.model.request.OrderRequest;

import java.util.List;

public interface OrdersService {
	
	Order createOrder(OrderRequest request);

	Order getOrder(String id);

	List<Order> getOrders();

}
