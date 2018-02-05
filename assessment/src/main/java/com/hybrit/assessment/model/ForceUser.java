package com.hybrit.assessment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "force_user")
@JsonIgnoreProperties(value = { "FORCE_INCREASE_PER_AGE", "AGE_UNLIMITED_FORCE", 
        "FORCE_TRESHOLD_JEDI", "isJediMaster" }, allowGetters = true)
public class ForceUser implements Serializable {
        private static final double FORCE_INCREASE_PER_AGE = 10;
        
        private static final int AGE_UNLIMITED_FORCE = 18;
        
        private static final double FORCE_TRESHOLD_JEDI = 93.2;
        
        @Column(name = "is_jedi_master", nullable = false)
        private boolean isJediMaster = false;
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
        
        @Column(name = "age", nullable = false)
        private int age;
        
        @Column(name = "`force`")
        private double force;
        
        @Column(name = "title", nullable = false)
        private String title;
        
        @Column(name = "has_unlimited_force", nullable = false)
        private boolean hasUnlimitedForce = false;

        public ForceUser() {
        }

        public ForceUser(int age, boolean isJediMaster) {
                this.isJediMaster = isJediMaster;
                this.setAge(age);
        }

        public int getAge() {
                return age;
        }

        public double getForce() {
                return force;
        }

        public String getTitle() {
                return title;
        }

        public int getId() {
                return id;
        }

        public boolean getHasUnlimitedForce() {
                return hasUnlimitedForce;
        }

        public void setAge(int age) {
                this.age = age;
                
                this.updateForce();
                this.updateHasUnlimitedForce();
        }

        public void setId(int id) {
                this.id = id;
        }

        private void updateForce() {
                this.force = this.age * FORCE_INCREASE_PER_AGE;
                
                this.updateTitle();
        }

        private void updateTitle() {
                if (this.force >= FORCE_TRESHOLD_JEDI) {
                        this.title = Title.Jedi.toString();
                } else {
                        this.title = Title.Padawan.toString();
                }
                
                if (this.isJediMaster) {
                        this.title = Title.JediMaster.toString();
                }
        }

        private void updateHasUnlimitedForce() {
                if (this.age >= AGE_UNLIMITED_FORCE) {
                        this.hasUnlimitedForce = true;
                }
        }
        
        public enum Title {
                Padawan,
                Jedi,
                JediMaster
        }
}


