package com.hybrit.assessment.dao;

import com.hybrit.assessment.model.Order;
import java.util.List;

/**
 *
 * @author Tim
 */
public interface OrderDao {
        Order save(Order order);
        List<Order> findAll();
}
