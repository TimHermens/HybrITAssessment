package com.hybrit.assessment.service;

import com.hybrit.assessment.dao.InventoryDao;
import com.hybrit.assessment.dao.OrderDao;
import com.hybrit.assessment.model.Order;
import com.hybrit.assessment.model.OrderLine;
import com.hybrit.assessment.model.ProductInventory;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tim
 */
@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

        @Autowired
        private OrderDao orderDao;
        
        @Autowired
        private InventoryDao inventoryDao;
        
        @Override
        @Transactional
        public Order save(Order order) {
                Iterator<OrderLine> orderLines = order.getOrderLines().iterator();
                while(orderLines.hasNext()) {
                        OrderLine orderLine = orderLines.next();
                        int productId = orderLine.getProduct().getId();
                        ProductInventory productInventory = this.inventoryDao.find(orderLine.getProduct());
                        productInventory.decreaseQuantity(orderLine.getQuantity());
                        this.inventoryDao.save(productInventory);
                }
                return this.orderDao.save(order);
        }

        @Override
        public List<Order> findAll() {
                return this.orderDao.findAll();
        }
        
}
