package com.hybrit.assessment.reader;

import com.hybrit.assessment.model.Product;
import com.hybrit.assessment.reader.format.Format;

/**
 *
 * @author Tim
 */
public class Reader {
        
        /**
        * The storage format.
        */
       private Format format;

       /**
        * Initialize the Reader object.
        * @param format The storage format to read the presentation from.
        */
       public Reader(Format format) {
                this.format = format;
       }
        
        public Product findProduct(String path, String productName) {
                this.format.setProductNameToFind(productName);
                return this.findProduct(path);
        }
        
        public Product findProduct(String path, int productId) {
                this.format.setProductIdToFind(productId);
                return this.findProduct(path);
        }
        
        private Product findProduct(String path) {
                boolean fileOpened = this.format.open(path);
                
                if (fileOpened) {
                        return this.format.findProduct();
                }
                
                return null;
        }
}
