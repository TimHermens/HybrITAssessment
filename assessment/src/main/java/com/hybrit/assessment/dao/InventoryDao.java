package com.hybrit.assessment.dao;

import com.hybrit.assessment.model.Product;
import com.hybrit.assessment.model.ProductInventory;
import java.util.List;

/**
 *
 * @author Tim
 */
public interface InventoryDao {
        ProductInventory find(Product product);
        List<ProductInventory> findAll();
        ProductInventory save(ProductInventory productInventory);
}
