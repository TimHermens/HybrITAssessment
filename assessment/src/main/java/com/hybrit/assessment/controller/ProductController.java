package com.hybrit.assessment.controller;

import com.hybrit.assessment.model.LightSaberWithStock;
import com.hybrit.assessment.model.Product;
import com.hybrit.assessment.model.ProductInventory;
import com.hybrit.assessment.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tim
 */
@RestController
@RequestMapping("/rest")
public class ProductController {
        
        @Autowired
        private ProductService productService;
        
        @GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Product>> findAll() {
                return ResponseEntity.ok().body(this.productService.findAll());
        }
        
        @PostMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity createLightSaber(@RequestBody LightSaberWithStock lightSaberWithStock) {
                this.productService.save(lightSaberWithStock);
                return ResponseEntity.status(205).build();
        }
        
        @GetMapping(path = "/crystals", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Product>> findCrystals() {
                return ResponseEntity.ok().body(this.productService.findCrystals());
        }
}
