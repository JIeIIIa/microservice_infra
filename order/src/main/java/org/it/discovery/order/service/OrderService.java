package org.it.discovery.order.service;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.it.discovery.order.domain.Order;
import org.it.discovery.order.domain.OrderItem;
import org.it.discovery.order.repository.CustomerRepository;
import org.it.discovery.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;

  private final CustomerRepository customerRepository;

  public void complete(int orderId) {
    Order order = orderRepository.findById(orderId);
    if (order != null) {
      order.setPayed(true);
      orderRepository.save(order);
    }
  }

  public void cancel(int orderId) {
    Order order = orderRepository.findById(orderId);
    if (order != null) {
      order.setCancelled(true);
      orderRepository.save(order);
    }
  }

  public Order createOrder(int bookId, int number, int customerId) {
    Order order = new Order();
    order.addItem(new OrderItem(bookId, number));
    order.setOrderDate(LocalDateTime.now());
    order.setCustomer(customerRepository.findById(customerId));

    return order;
  }

  public void addBook(int orderId, int bookId, int number) {
    Order order = orderRepository.findById(orderId);
    if (order != null) {
      order.addItem(new OrderItem(bookId, number));
      orderRepository.save(order);
    }
  }

}
