package com.hybrit.assessment.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Tim
 */
@Entity
@Table(name = "planet")
public class Planet implements Serializable {
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        
        @Column(name = "name", nullable = false)
        private String name;

        public Planet() {
        }

        public Planet(String name) {
                this.name = name;
        }
        
        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setId(int id) {
                this.id = id;
        }
}
