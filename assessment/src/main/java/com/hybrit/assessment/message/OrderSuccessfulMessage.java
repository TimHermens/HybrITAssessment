package com.hybrit.assessment.message;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Tim
 */
public class OrderSuccessfulMessage implements Serializable {
        private String message;
        
        private List<String> productNames;

        public OrderSuccessfulMessage(String message, List<String> productNames) {
                this.message = message;
                this.productNames = productNames;
        }

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }

        public List<String> getProductNames() {
                return productNames;
        }

        public void setProductNames(List<String> productNames) {
                this.productNames = productNames;
        }
}
