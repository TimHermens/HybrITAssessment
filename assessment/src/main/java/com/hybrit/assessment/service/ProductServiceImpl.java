package com.hybrit.assessment.service;

import com.hybrit.assessment.dao.ProductDao;
import com.hybrit.assessment.model.LightSaberWithStock;
import com.hybrit.assessment.model.KaiburrCrystal;
import com.hybrit.assessment.model.LightSaber;
import com.hybrit.assessment.model.Product;
import com.hybrit.assessment.model.ProductInventory;
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

        @Override
        public List<Product> findCrystals() {
                return this.productDao.findCrystals();
        }

        @Override
        @Transactional
        public Product save(LightSaberWithStock product) {
                LightSaber lightsaber = product.getProduct();
                KaiburrCrystal crystal = (KaiburrCrystal) this.productDao.find(lightsaber.getKaiburrCrystal().getId());
                lightsaber.setKaiburrCrystal(crystal);
                ProductInventory inventory = new ProductInventory();
                inventory.setQuantity(product.getStock());
                inventory.setProduct(lightsaber);
                lightsaber.setProductInventory(inventory);
                Product retProduct = this.productDao.save(lightsaber);
                return retProduct;
        }
        
}
