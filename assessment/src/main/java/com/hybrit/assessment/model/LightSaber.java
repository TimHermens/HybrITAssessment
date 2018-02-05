package com.hybrit.assessment.model;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Tim
 */
@Entity
@Table(name = "product_light_saber")
public class LightSaber extends Product {
        
        @ManyToOne(cascade = CascadeType.ALL)
        private KaiburrCrystal kaiburrCrystal;

        public LightSaber(KaiburrCrystal kaiburrCrystal, String name, BigDecimal price) {
                super(name, price);
                this.kaiburrCrystal = kaiburrCrystal;
        }

        public LightSaber() {
        }

        public KaiburrCrystal getKaiburrCrystal() {
                return kaiburrCrystal;
        }

        @Override
        public BigDecimal getPrice() {
                return super.getPrice().add(this.kaiburrCrystal.getPrice());
        }

        public void setKaiburrCrystal(KaiburrCrystal kaiburrCrystal) {
                this.kaiburrCrystal = kaiburrCrystal;
        }
}
