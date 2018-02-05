package com.hybrit.assessment.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Tim
 */
@Entity
@Table(name = "product_kaiburr_crystal")
public class KaiburrCrystal extends Product {        
        @Column(name = "color")
        private String color;
        
        @Column(name = "power_usage", nullable = false)
        private double powerUsage;
        
        @ManyToOne(cascade = CascadeType.ALL)
        private CrystalHarvest crystalHarvest;

        public KaiburrCrystal() {
        }

        public KaiburrCrystal(String color, double powerUsage, CrystalHarvest crystalHarvest) {
                this.color = color;
                this.powerUsage = powerUsage;
                this.crystalHarvest = crystalHarvest;
        }

        public String getColor() {
                return color;
        }

        public double getPowerUsage() {
                return powerUsage;
        }

        public CrystalHarvest getCrystalHarvest() {
                return crystalHarvest;
        }

        public void setColor(String color) {
                this.color = color;
        }

        public void setPowerUsage(double powerUsage) {
                this.powerUsage = powerUsage;
        }

        public void setCrystalHarvest(CrystalHarvest crystalHarvest) {
                this.crystalHarvest = crystalHarvest;
        }
}
