package com.hybrit.assessment.dao;

import com.hybrit.assessment.model.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tim
 */
@Repository
public class ProductDaoImpl implements ProductDao {
        @Autowired
        private SessionFactory sessionFactory;

        @Override
        public Product save(Product product) {
                this.sessionFactory.getCurrentSession().merge(product);
                return product;
        }

        @Override
        public Product find(int id) {
                return this.sessionFactory.getCurrentSession().get(Product.class, id);
        }

        @Override
        public Product find(String name) {                
                return (Product) this.sessionFactory.getCurrentSession()
                        .createQuery("from Product p where p.name = :name")
                        .setParameter("name", name).uniqueResult();
        }

        @Override
        public List<Product> findAll() {
                return this.sessionFactory.getCurrentSession().createQuery("from Product").list();
        }

        @Override
        public List<Product> findCrystals() {
                return this.sessionFactory.getCurrentSession().createQuery("from KaiburrCrystal").list();
        }
}
