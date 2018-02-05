package com.hybrit.assessment.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Tim
 */
@Entity
@Table(name = "product_inventory")
public class ProductInventory implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
        
        @Column(name = "quantity")
        private int quantity;
        
        @OneToOne
        private Product product;

        public ProductInventory() {
        }

        public ProductInventory(int quantity, Product product) {
                this.quantity = quantity;
                this.product = product;
        }

        public int getId() {
                return id;
        }

        public int getQuantity() {
                return quantity;
        }

        public Product getProduct() {
                return product;
        }

        public void setQuantity(int quantity) {
                this.quantity = quantity;
        }

        public void setProduct(Product product) {
                this.product = product;
        }

        public void setId(int id) {
                this.id = id;
        }
        
        public void decreaseQuantity(int delta) {
                int quantity = this.quantity - delta;
                if (quantity < 0) {
                        quantity = 0;
                }
                this.setQuantity(quantity);
        }
}
