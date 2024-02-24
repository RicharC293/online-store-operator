package com.richarcangui.store.operator.controller;

import com.richarcangui.store.operator.model.db.Order;
import com.richarcangui.store.operator.model.request.OrderRequest;
import com.richarcangui.store.operator.service.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrdersController {

    private final OrdersService service; //Inyeccion por constructor mediante @RequiredArgsConstructor. Y, también es inyección por interfaz.

    @PostMapping("/orders")
    @Operation(
            summary = "Crear una nueva orden",
            description = "Crea una nueva orden con los productos especificados."
    )
    public ResponseEntity<Order> createOrder(@RequestBody @Valid OrderRequest request) { //Se valida con Jakarta Validation API

        log.info("Creating order...");
        Order created = service.createOrder(request);

        if (created != null) {
            return ResponseEntity.ok(created);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders() {

        List<Order> orders = service.getOrders();
        if (orders != null) {
            return ResponseEntity.ok(orders);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable String id) {

        Order order = service.getOrder(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
