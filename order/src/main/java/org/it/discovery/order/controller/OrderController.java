package org.it.discovery.order.controller;

import lombok.AllArgsConstructor;
import org.it.discovery.order.service.OrderService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping("/order")
  public int createOrder(int bookId, int number, int customerId) {
    return orderService.createOrder(bookId, number, customerId).getId();
  }

  @PutMapping("/order")
  public void addBook(int orderId, int bookId, int number) {
    orderService.addBook(orderId, bookId, number);
  }

  @PutMapping("/order/{id}")
  public void completeOrder(@PathVariable("id") int orderId) {
    orderService.complete(orderId);
  }

  @DeleteMapping("/order/{id}")
  public void cancel(@PathVariable("id") int orderId) {
    orderService.cancel(orderId);
  }

}