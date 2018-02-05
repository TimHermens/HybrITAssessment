package com.hybrit.assessment.service;

import com.hybrit.assessment.model.Product;
import java.util.List;

/**
 *
 * @author Tim
 */
public interface ProductService {
        Product save(Product product);
        Product find(int id);
        Product find(String name);
        List<Product> findAll();
}
