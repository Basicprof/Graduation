package ru.vipusk.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import ru.vipusk.RestaurantTestData;
import ru.vipusk.model.Dishs;
import ru.vipusk.model.Restaurant;
import ru.vipusk.model.Voting;
import ru.vipusk.to.RestaurantTo;
import ru.vipusk.web.SecurityUtil;
import ru.vipusk.web.restaurant.RestaurantRestController;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.vipusk.RestaurantTestData.*;
import static ru.vipusk.RestaurantTestData.assertMatch;
import static ru.vipusk.UserTestData.USER_ID;


@ContextConfiguration({
        "classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class RestaurantRestTest {
    private static final Logger LOG = LoggerFactory.getLogger(RestaurantRestTest.class);

    @Autowired
    RestaurantRestController restRestaurant;


    public RestaurantRestTest() {  }


    @Before
    public void setUp() {
        SecurityUtil.setAuthUserId(USER_ID);
    }

    @Test
    public void isVote() {

        Voting votes = restRestaurant.isVote(RESTAURANT1_ID);
        if (votes == null) {
            assertThat(votes).isEqualTo(null);
        } else {
            assertThat(votes).isEqualTo(votes);
        }
    }

    @Test
    public void getRestaurantTo() {
        List<RestaurantTo> restaurants = restRestaurant.getRestaurantTo();
        assertThat(restaurants.size()).isEqualTo(5);
    }


    @Test
    public void getDishs() {
        Dishs DISHS = restRestaurant.getDishs(DISHS_ID);
        assertMatch(DISHS, DISHS1);
    }

    @Test
    public void getAllDishsOneRestaurant() {
        List<Dishs> DISHS = restRestaurant.getAllDishsRestaurantId(RESTAURANT1_ID);
        assertMatch(DISHS, DISHS1, DISHS2, DISHS3);
    }

    @Test
    public void updateDishs() {
        Dishs oldDishs = getUpdatedDishs(restRestaurant.getDishs(DISHS_ID));
       restRestaurant.updateDishs(oldDishs);
       assertMatch(restRestaurant.getDishs(DISHS_ID), oldDishs);
    }

    @Test
    public void createDishs() {
        Dishs newDishs = getCreatedDishs();
        Dishs created = restRestaurant.createDishs(RESTAURANT1_ID, newDishs);
        List<Dishs> list = restRestaurant.getAllDishsRestaurantId(RESTAURANT1_ID);


        assertMatch(newDishs, created);
        assertMatch(list, DISHS1, DISHS2, DISHS3, newDishs);

    }

    @Test
    public void createRestaurant() {
        Restaurant restaurant = RestaurantTestData.getCreatedRestaurant();
        int idRest = restRestaurant.createRestaurant(restaurant);
        assertMatch(restaurant, restRestaurant.getRestaurant(idRest));
    }
}