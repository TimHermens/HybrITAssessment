package com.hybrit.assessment.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Tim
 */
@Entity
@Table(name = "`order`")
public class Order implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private int id;
        
        @Column(name = "`date`", nullable = false)
        private Date date;
        
        @ManyToOne(cascade = CascadeType.ALL)
        private ForceUser forceUser;
        
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
        private List<OrderLine> orderLines;

        public Order() {
        }

        public Order(Date date, ForceUser forceUser, List<OrderLine> orderLines) {
                this.date = date;
                this.forceUser = forceUser;
                this.orderLines = orderLines;
        }

        public int getId() {
                return id;
        }

        public Date getDate() {
                return date;
        }

        public ForceUser getForceUser() {
                return forceUser;
        }

        public List<OrderLine> getOrderLines() {
                return orderLines;
        }

        public void setDate(Date date) {
                this.date = date;
        }

        public void setForceUser(ForceUser forceUser) {
                this.forceUser = forceUser;
        }

        public void setOrderLines(List<OrderLine> orderLines) {
                this.orderLines = orderLines;
        }

        public void setId(int id) {
                this.id = id;
        }
}
