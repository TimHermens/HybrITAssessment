package com.hybrit.assessment.service;

import com.hybrit.assessment.dao.ProductDao;
import com.hybrit.assessment.model.Product;
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
public class ProductServiceImpl implements ProductService {

        @Autowired
        private ProductDao productDao;
        
        @Override
        @Transactional
        public Product save(Product product) {
                return this.productDao.save(product);
        }

        @Override
        public Product find(int id) {
                return this.productDao.find(id);
        }

        @Override
        public Product find(String name) {
                return this.productDao.find(name);
        }

        @Override
        public List<Product> findAll() {
                return this.productDao.findAll();
        }
        
}
