package com.hybrit.assessment.service;

import com.hybrit.assessment.model.Order;
import java.util.List;

/**
 *
 * @author Tim
 */
public interface OrderService {
        Order save(Order order);
        List<Order> findAll();
}
