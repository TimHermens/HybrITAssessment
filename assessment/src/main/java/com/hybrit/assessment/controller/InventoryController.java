package com.hybrit.assessment.controller;

import com.hybrit.assessment.model.ProductInventory;
import com.hybrit.assessment.service.InventoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tim
 */

@RestController
@RequestMapping("/rest")
public class InventoryController {
        
        @Autowired
        private InventoryService inventoryService;
        
        @GetMapping(path = "/inventory", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<ProductInventory>> findAll() {
                return ResponseEntity.ok().body(this.inventoryService.findAll());
        }
        
        
}
