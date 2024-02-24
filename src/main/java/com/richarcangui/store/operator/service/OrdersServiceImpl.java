package com.richarcangui.store.operator.service;

import com.richarcangui.store.operator.data.OrderJpaRepository;
import com.richarcangui.store.operator.facade.ProductsFacade;
import com.richarcangui.store.operator.model.Product;
import com.richarcangui.store.operator.model.db.Order;
import com.richarcangui.store.operator.model.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl implements OrdersService {

  @Autowired //Inyeccion por campo (field injection). Es la menos recomendada.
  private ProductsFacade productsFacade;

  @Autowired //Inyeccion por campo (field injection). Es la menos recomendada.
  private OrderJpaRepository repository;

  @Override
  public Order createOrder(OrderRequest request) {

    List<Product> products = request.getProducts().stream().map(productsFacade::getProduct).filter(Objects::nonNull).toList();

    if(products.size() != request.getProducts().size()) {
      return null;
    } else {
      Order order = Order.builder().products(products.stream().map(Product::getId).collect(Collectors.toList())).build();
      repository.save(order);
      return order;
    }
  }

  @Override
  public Order getOrder(String id) {
    return repository.findById(Long.valueOf(id)).orElse(null);
  }

  @Override
  public List<Order> getOrders() {
    List<Order> orders = repository.findAll();
    return orders.isEmpty() ? null : orders;
  }
}
