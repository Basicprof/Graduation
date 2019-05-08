package ru.vipusk;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vipusk.repository.RepositoryMenagerRestaurant;
import ru.vipusk.rest.RestRestaurant;

import java.util.Arrays;

public class MainSpring {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx= new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
        RepositoryMenagerRestaurant rep = appCtx.getBean(RepositoryMenagerRestaurant.class);
        System.out.println(rep.toString());
        RestRestaurant restRestaurant = appCtx.getBean(RestRestaurant.class);
        System.out.println(restRestaurant.toString());
        appCtx.close();
    }
}
