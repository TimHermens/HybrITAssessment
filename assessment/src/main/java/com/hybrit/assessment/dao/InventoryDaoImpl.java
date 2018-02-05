package com.hybrit.assessment.dao;

import com.hybrit.assessment.model.Product;
import com.hybrit.assessment.model.ProductInventory;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tim
 */
@Repository
public class InventoryDaoImpl implements InventoryDao {

        @Autowired
        private SessionFactory sessionFactory;
        
        @Override
        public List<ProductInventory> findAll() {
                return (List<ProductInventory>) this.sessionFactory
                        .getCurrentSession().createQuery("from ProductInventory")
                        .list();
        }

        @Override
        public ProductInventory save(ProductInventory productInventory) {
                System.out.println("updating");
                this.sessionFactory.getCurrentSession().merge(productInventory);
                return productInventory;
        }

        @Override
        public ProductInventory find(Product product) {
                return (ProductInventory) this.sessionFactory.getCurrentSession()
                        .createQuery("from ProductInventory p where p.product = :product_id")
                        .setParameter("product_id", product).uniqueResult();
        }
        
}
