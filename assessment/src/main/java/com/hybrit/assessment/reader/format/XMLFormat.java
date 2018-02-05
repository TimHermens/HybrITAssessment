package com.hybrit.assessment.reader.format;

import com.hybrit.assessment.factory.ProductFactory;
import com.hybrit.assessment.model.KaiburrCrystal;
import com.hybrit.assessment.model.LightSaber;
import com.hybrit.assessment.model.Product;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Tim
 */
public class XMLFormat extends Format {
        
        private static final String TAG_LIGHT_SABER = "saber";
        
        private static final String TAG_ID = "id";
        
        private static final String TAG_NAME = "name";
        
        private static final String TAG_KAIBURR_CRYSTAL = "crystal";
        
        private Document document;
        
        @Override
        public boolean open(String path) {      
                try {
                        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                        this.document = builder.parse(new File(path)); // create a JDOM document
                        return true;
                } catch (ParserConfigurationException ex) {
                        System.err.println(ex.toString());
                } catch (SAXException ex) {
                        System.err.println(ex.toString());
                } catch (IOException ex) {
                        System.err.println(ex.toString());
                }
                
                return false;
        }
        
        @Override
        public Product findProduct() {
                Element sabers = this.document.getDocumentElement();
                
                NodeList saberList = sabers.getElementsByTagName(TAG_LIGHT_SABER);
                int numberOfSabers = saberList.getLength();
                
                for (int saberNumber = 0; saberNumber < numberOfSabers; saberNumber++) {
                        Element saber = (Element) saberList.item(saberNumber);
                        
                        int productId = Integer.parseInt(saber.getElementsByTagName(TAG_ID).item(0).getTextContent());
                        String productName = saber.getElementsByTagName(TAG_NAME).item(0).getTextContent();
                        
                        if (findProductId) {
                                if (this.productIdToFind != productId) {
                                        continue;
                                }
                        }
                        
                        if (this.findProductName) {
                                if (!this.productNameToFind.equalsIgnoreCase(productName)) {
                                        continue;
                                }
                        }
                        
                        LightSaber lightSaber = ProductFactory.createLightSaber();
                        lightSaber.setId(productId);
                        lightSaber.setName(productName);
                        
                        Element crystal = (Element) saber.getElementsByTagName(TAG_KAIBURR_CRYSTAL).item(0);
                        String crystalName = crystal.getElementsByTagName(TAG_NAME).item(0).getTextContent();
                        
                        KaiburrCrystal kaiburrCrystal = ProductFactory.createKaiburrCrystal();
                        kaiburrCrystal.setName(crystalName);
                        
                        lightSaber.setKaiburrCrystal(kaiburrCrystal);
                        
                        return lightSaber;
                }
                
                return null;
        }
}
