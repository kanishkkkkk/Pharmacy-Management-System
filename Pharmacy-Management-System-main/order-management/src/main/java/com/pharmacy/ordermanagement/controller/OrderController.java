package com.pharmacy.ordermanagement.controller;

import com.pharmacy.ordermanagement.Entity.Order;
import com.pharmacy.ordermanagement.Service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    Logger logger =LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity getOrder() {
        try {
            return ResponseEntity.ok(orderService.getOrder());
        } catch (Exception e) {
            e.printStackTrace();
            logger.trace("FATAL ERROR");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No order found");

        }
    }
    @PostMapping("/order")
    public ResponseEntity createDrug(@RequestBody Order order) {
        try {
            return ResponseEntity.ok(orderService.saveOrder(order));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No order created");
        }
    }
    @PutMapping("/order/{orderId}")
    public ResponseEntity updateDrug(@RequestBody Order order, @PathVariable("orderId") String id) {
        try {
            return ResponseEntity.ok(orderService.updateOrder(order,id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No order found");
        }
    }
    @DeleteMapping("/order/{orderId}")
    public ResponseEntity deleteOrder(@PathVariable("orderId") String id) {
        try {
            return ResponseEntity.ok(orderService.deleteOrder(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No order found");
        }
    }


}
