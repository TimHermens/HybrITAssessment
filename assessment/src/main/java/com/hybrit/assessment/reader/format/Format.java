package com.hybrit.assessment.reader.format;

import com.hybrit.assessment.model.Product;

/**
 *
 * @author Tim
 */
public abstract class Format {
        String productNameToFind;
        
        int productIdToFind;
        
        boolean findProductName;
        
        boolean findProductId;

        public void setProductNameToFind(String productNameToFind) {
                this.productNameToFind = productNameToFind;
                this.findProductName = true;
                this.findProductId = false;
        }

        public void setProductIdToFind(int productIdToFind) {
                this.productIdToFind = productIdToFind;
                this.findProductId = true;
                this.findProductName = false;
        }
        
        public abstract boolean open(String path);
        
        public abstract Product findProduct();
}
