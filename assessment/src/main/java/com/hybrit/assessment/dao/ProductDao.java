package com.hybrit.assessment.dao;

import com.hybrit.assessment.model.Product;
import java.util.List;

/**
 *
 * @author Tim
 */
public interface ProductDao {
        Product save(Product product);
        Product find(int id);
        Product find(String name);
        List<Product> findAll();
        List<Product> findCrystals();
}
