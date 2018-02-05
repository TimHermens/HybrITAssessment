package com.hybrit.assessment.service;

import com.hybrit.assessment.model.ProductInventory;
import java.util.List;

/**
 *
 * @author Tim
 */
public interface InventoryService {
        List<ProductInventory> findAll();
        ProductInventory save(ProductInventory productInventory);
}
