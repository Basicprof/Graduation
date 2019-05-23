package ru.vipusk;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vipusk.web.restaurant.RestaurantRestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;

public class MainSpring {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx= new ClassPathXmlApplicationContext(" classpath:spring/spring-db.xml");
        System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
        RestaurantRestController rep = appCtx.getBean(RestaurantRestController.class);
        System.out.println(rep.toString());

        appCtx.close();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaRush");
        EntityManager entityManager = emf.createEntityManager();
    }
}
