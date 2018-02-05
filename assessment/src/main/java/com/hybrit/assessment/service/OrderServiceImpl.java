package com.hybrit.assessment.service;

import com.hybrit.assessment.dao.InventoryDao;
import com.hybrit.assessment.dao.OrderDao;
import com.hybrit.assessment.dao.ProductDao;
import com.hybrit.assessment.model.Order;
import com.hybrit.assessment.model.OrderLine;
import com.hybrit.assessment.model.Product;
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
        
        @Autowired
        private ProductDao productDao;
        
        @Override
        @Transactional
        public Order save(Order order) {
                Iterator<OrderLine> orderLines = order.getOrderLines().iterator();
                while(orderLines.hasNext()) {
                        OrderLine orderLine = orderLines.next();
                        Product product = this.productDao.find(orderLine.getProduct().getId());
                        orderLine.setProduct(product);
                        ProductInventory productInventory = this.inventoryDao.find(product); // fetch new inventory count in case it's updated
                        productInventory.decreaseQuantity(orderLine.getQuantity());
                        orderLine.getProduct().setProductInventory(productInventory);
                        orderLine.setOrder(order);
                        this.inventoryDao.save(productInventory);
                }
                Order o = this.orderDao.save(order);
                return o;
        }

        @Override
        public List<Order> findAll() {
                return this.orderDao.findAll();
        }
        
}
