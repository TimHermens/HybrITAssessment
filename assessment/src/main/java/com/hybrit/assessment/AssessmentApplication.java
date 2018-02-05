package com.hybrit.assessment;

import com.hybrit.assessment.factory.AccessorFactory;
import com.hybrit.assessment.factory.ForceUserFactory;
import com.hybrit.assessment.model.ForceUser;
import com.hybrit.assessment.model.KaiburrCrystal;
import com.hybrit.assessment.model.LightSaber;
import com.hybrit.assessment.model.Order;
import com.hybrit.assessment.model.OrderLine;
import com.hybrit.assessment.model.Product;
import com.hybrit.assessment.service.ForceUserService;
import com.hybrit.assessment.service.OrderService;
import com.hybrit.assessment.service.ProductService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication(scanBasePackages = "com.hybrit.assessment")
public class AssessmentApplication {
        
        @Autowired
        private ProductService productService;
        
        @Autowired
        private ForceUserService forceUserService;
        
        @Autowired
        private OrderService orderService;
        
        private static String[] args;

        /**
         * The main method. The args parameter is expected to hold three
         * parameters: (1) path to a light sabers xml file, (2) the age of a
         * padawan, (3) the name or id of a light saber.
         * @param args
         */
	public static void main(String[] args) {
                AssessmentApplication.args = args;
                SpringApplication.run(AssessmentApplication.class, args);
	}
        
        @Bean
        public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
                HibernateJpaSessionFactoryBean fact = new HibernateJpaSessionFactoryBean();
                fact.setEntityManagerFactory(emf);
                return fact;
        }
        
        @EventListener(ApplicationReadyEvent.class)
        public void init() {
                Order order = new Order();
                order.setDate(new Date());
                ForceUser user = this.forceUserService.find(1); //new ForceUser();
                order.setForceUser(user);
                List<OrderLine> orderLines = new ArrayList();
                OrderLine orderLine = new OrderLine();
                orderLine.setOrder(order);
                Product product = this.productService.find(4);
                orderLine.setProduct(product);
                orderLine.setQuantity(1);
                orderLine.setUnitPrice(product.getPrice());
                orderLines.add(orderLine);
                order.setOrderLines(orderLines);
                this.orderService.save(order);
                
                String sabersXmlPath = "";
                ForceUser forceUser = null;
                
                if(args != null) {
                        if(args.length >= 1) {
                                sabersXmlPath = args[0]; 
                        }
                        if(args.length >= 2) {
                                int age = 0;
                                try {
                                        age = Integer.parseInt(args[1]);
                                        forceUser = this.getForceUser(age);                            

                                } catch (NumberFormatException exception) {
                                        System.err.println(String.format("Invalid age provided: %s", age));
                                }

                        }
                        if(args.length >= 3) {
                                String saber = args[2]; // either the id or name
                                this.printSaberInformation(sabersXmlPath, saber, forceUser);
                        }
                }
        }
        
        private ForceUser getForceUser(int age) {
                // print the force value for the age
                ForceUser forceUser = ForceUserFactory.createForceUser();
                forceUser.setAge(age);
                
                if (forceUser.getHasUnlimitedForce()) {
                        System.out.println("F = unlimited");
                } else {
                        System.out.println(String.format("F = %s", forceUser.getForce()));
                }
                
                return forceUser;
        }
        
        private void printSaberInformation(String sabersXmlPath, String saber, ForceUser forceUser) {
                AccessorFactory factory = AccessorFactory.getFactory(sabersXmlPath);
                        
                if (factory != null) {
                        LightSaber foundProduct;
                        KaiburrCrystal crystal = null;

                        try {
                                int saberId = Integer.parseInt(saber);
                                foundProduct = (LightSaber) factory.createReader().findProduct(sabersXmlPath, saberId);
                        } catch (NumberFormatException exception) {
                                // argument is not an id, but a name
                                foundProduct = (LightSaber) factory.createReader().findProduct(sabersXmlPath, saber);
                        }
                        
                        if (foundProduct != null) {
                                crystal = (KaiburrCrystal) this.productService.find(foundProduct.getKaiburrCrystal().getName());
                        }
                        
                        if (crystal != null) {
                                System.out.println("Jedi power usage:");
                                if (forceUser.getHasUnlimitedForce()) {
                                        System.out.println("\tF needed = unlimited");
                                }
                                else {
                                        System.out.println(String.format("\tF needed = %sF", forceUser.getForce() * crystal.getPowerUsage() / 100));
                                }
                                System.out.println("Crystal detail:");
                                System.out.println(String.format("\tCrystal type: %s", crystal.getName()));
                                System.out.println(String.format("\tPrice: %s", crystal.getPrice().toString()));
                        }
                }
        }
}
