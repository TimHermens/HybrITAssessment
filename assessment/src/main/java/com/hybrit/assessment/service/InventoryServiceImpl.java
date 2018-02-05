package com.hybrit.assessment.service;

import com.hybrit.assessment.dao.InventoryDao;
import com.hybrit.assessment.model.ProductInventory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * If your DAOs are transactional, and you call different DAOs in each service, 
 * then you would have multiple txs, which is not what you want. Make the 
 * service calls transactional, and all DAO calls inside those methods will 
 * participate in the tx for the method.
 * @author Tim
 */
@Service
@Transactional(readOnly = true)
public class InventoryServiceImpl implements InventoryService {
        
        @Autowired
        private InventoryDao inventoryDao;

        @Override
        public List<ProductInventory> findAll() {
                return this.inventoryDao.findAll();
        }

        @Override
        @Transactional
        public ProductInventory save(ProductInventory productInventory) {
                return this.inventoryDao.save(productInventory);
        }
        
}
