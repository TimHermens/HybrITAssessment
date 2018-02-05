package com.hybrit.assessment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 *
 * @author Tim
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@JsonIgnoreProperties(value = { "productInventory" }, allowGetters = true)
public class Product implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
        
        @Column(name = "name", unique = true, nullable = false)        
        private String name;
        
        @Column(name = "price", nullable = false)
        private BigDecimal price = new BigDecimal(0);
        
        @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
        @JsonIgnore
        private ProductInventory productInventory;

        public Product(String name, BigDecimal price) {
                this.name = name;
                this.price = price;
        }

        public Product() {
        }

        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public BigDecimal getPrice() {
                return price;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setPrice(BigDecimal price) {
                this.price = price;
        }

        @JsonIgnore
        public ProductInventory getProductInventory() {
                return productInventory;
        }

        public void setProductInventory(ProductInventory productInventory) {
                this.productInventory = productInventory;
        }
        
        
}
