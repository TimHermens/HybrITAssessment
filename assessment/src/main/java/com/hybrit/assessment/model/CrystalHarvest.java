package com.hybrit.assessment.model;

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
@Table(name = "crystal_harvest")
public class CrystalHarvest implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
        
        @Column(name = "harvest_price", nullable = false)
        private BigDecimal harvestPrice;
        
        @ManyToOne(cascade = CascadeType.ALL)
        private Planet planet;

        public CrystalHarvest(BigDecimal harvestPrice, Planet planet) {
                this.harvestPrice = harvestPrice;
                this.planet = planet;
        }

        public CrystalHarvest() {
        }

        public int getId() {
                return id;
        }

        public BigDecimal getHarvestPrice() {
                return harvestPrice;
        }

        public Planet getPlanet() {
                return planet;
        }

        public void setHarvestPrice(BigDecimal harvestPrice) {
                this.harvestPrice = harvestPrice;
        }

        public void setPlanet(Planet planet) {
                this.planet = planet;
        }

        public void setId(int id) {
                this.id = id;
        }
}
