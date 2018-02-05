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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Tim
 */
@Entity
@Table(name = "order_line")
@JsonIgnoreProperties(value = { "order" }, allowGetters = true)
public class OrderLine implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
        
        @Column(name = "quantity", nullable = false)
        private int quantity;
        
        @Column(name = "unit_price", nullable = false)
        private BigDecimal unitPrice;
        
        @ManyToOne(cascade = CascadeType.ALL)
        private Product product;
        
        @ManyToOne
        @JsonIgnore
        private Order order;

        public OrderLine() {
        }

        public OrderLine(int quantity, BigDecimal unitPrice, Product product) {
                this.quantity = quantity;
                this.unitPrice = unitPrice;
                this.product = product;
        }

        public int getId() {
                return id;
        }

        public int getQuantity() {
                return quantity;
        }

        public BigDecimal getUnitPrice() {
                return unitPrice;
        }

        public Product getProduct() {
                return product;
        }

        @JsonIgnore
        public Order getOrder() {
                return order;
        }

        public void setQuantity(int quantity) {
                this.quantity = quantity;
        }

        public void setUnitPrice(BigDecimal unitPrice) {
                this.unitPrice = unitPrice;
        }

        public void setProduct(Product product) {
                this.product = product;
        }

        public void setOrder(Order order) {
                this.order = order;
        }

        public void setId(int id) {
                this.id = id;
        }
}
