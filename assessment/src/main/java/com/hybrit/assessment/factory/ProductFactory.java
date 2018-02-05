package com.hybrit.assessment.factory;

import com.hybrit.assessment.model.KaiburrCrystal;
import com.hybrit.assessment.model.LightSaber;

/**
 *
 * @author Tim
 */
public class ProductFactory {
        
        public static LightSaber createLightSaber() {
                return new LightSaber();
        }
        
        public static KaiburrCrystal createKaiburrCrystal() {
                return new KaiburrCrystal();
        }
}
