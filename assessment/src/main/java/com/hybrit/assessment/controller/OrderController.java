package com.hybrit.assessment.controller;

import com.hybrit.assessment.message.OrderSuccessfulMessage;
import com.hybrit.assessment.model.Order;
import com.hybrit.assessment.model.OrderLine;
import com.hybrit.assessment.model.ProductInventory;
import com.hybrit.assessment.service.InventoryService;
import com.hybrit.assessment.service.OrderService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tim
 */
@RestController
@RequestMapping("/rest")
public class OrderController {
        
        @Autowired
        private OrderService orderService;
        
        @PostMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<OrderSuccessfulMessage> orderProduct(@RequestBody Order order) {
                order.setDate(new Date());
                Order retOrder = this.orderService.save(order);
                Iterator<OrderLine> orderLines = retOrder.getOrderLines().iterator();
                List<String> productNames = new ArrayList();
                while(orderLines.hasNext()) {
                        productNames.add(orderLines.next().getProduct().getName());
                }
                OrderSuccessfulMessage message = new OrderSuccessfulMessage("Order successful", productNames);
                return ResponseEntity.status(201).body(message);
        }
        
        @GetMapping(path = "/ordery", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<OrderSuccessfulMessage> order() {
                return ResponseEntity.status(201).body(new OrderSuccessfulMessage("Order successful", Arrays.asList("a","b")));
        }
        
        @GetMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Order>> orders() {
                return ResponseEntity.ok().body(this.orderService.findAll());
        }
}
