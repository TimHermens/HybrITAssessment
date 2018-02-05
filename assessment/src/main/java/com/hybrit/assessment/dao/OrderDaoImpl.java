package com.hybrit.assessment.dao;

import com.hybrit.assessment.model.Order;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tim
 */
@Repository
public class OrderDaoImpl implements OrderDao {

        @Autowired
        private SessionFactory sessionFactory;
        
        @Override
        public Order save(Order order) {
                this.sessionFactory.getCurrentSession().merge(order);
                return order;
        }

        @Override
        public List<Order> findAll() {
                List<Order> orders = (List<Order>) this.sessionFactory.getCurrentSession()
                        .createQuery("from Order").list();
                return orders;
        }
        
}
