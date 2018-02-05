package com.hybrit.assessment.controller;

import com.hybrit.assessment.model.ForceUser;
import com.hybrit.assessment.service.ForceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tim
 */
@RestController
@RequestMapping("/rest")
public class ForceUserController {
        
        @Autowired
        private ForceUserService forceUserService;
        
        @GetMapping(path = "/forceuser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<ForceUser> findForceUser(@PathVariable("id") int id) {
                ForceUser forceUser = this.forceUserService.find(id);
                
                if (forceUser != null) {
                        return ResponseEntity.ok().body(forceUser);
                }
                else {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
        }
}
