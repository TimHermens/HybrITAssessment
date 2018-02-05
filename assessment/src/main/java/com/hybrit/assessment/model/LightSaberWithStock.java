package com.hybrit.assessment.model;

import com.hybrit.assessment.model.LightSaber;
import com.hybrit.assessment.model.Product;
import java.io.Serializable;

/**
 *
 * @author Gebruiker
 */
public class LightSaberWithStock implements Serializable {
        
        private LightSaber product;
        
        private int stock;

        public LightSaberWithStock() {
        }

        public LightSaber getProduct() {
                return product;
        }

        public void setProduct(LightSaber product) {
                this.product = product;
        }

        

        public int getStock() {
                return stock;
        }

        public void setStock(int stock) {
                this.stock = stock;
        }
        
        
}
