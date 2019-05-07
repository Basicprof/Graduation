package ru.vipusk.rest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.vipusk.RestaurentCreateData;
import ru.vipusk.model.Menu;
import ru.vipusk.model.Restaurant;
import ru.vipusk.model.util.SecurityUtil;
import ru.vipusk.model.util.exception.NotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.vipusk.RestaurentTestData.*;

import java.time.LocalDate;
import java.util.List;

public class RestRestaurantTest {
    RestRestaurant restRestaurant ;

    @Before
    public void setUp() throws Exception {
      RestaurentCreateData restaurentCreateData = new RestaurentCreateData();
        this.restRestaurant =  restaurentCreateData.getRestRestaurant();
    }



    @Test
    public void newVote() {

        SecurityUtil.setAuthUserId(100011);
        restRestaurant.newVote(100004);
        Integer integ =restRestaurant.isVoteToDey(100004);
        assertThat( integ).isEqualTo( 1);
    }

    @Test
    public void isVoteToDey() {

        SecurityUtil.setAuthUserId(100011);
        restRestaurant.newVote(100004);
        Integer integ =restRestaurant.isVoteToDey(100004);
        assertThat( integ).isEqualTo( 1);
    }

    @Test
    public void getAll() {
       List<Restaurant> RESTRESTAURANTLIST = restRestaurant.getAll();
       assertThat(RESTRESTAURANTLIST).isEqualTo( RESTAURANTLIST);
    }

    @Test
    public void getRestaurant() {
        Restaurant RESTAURANT = restRestaurant.getRestaurant(100003);
        assertThat(RESTAURANT).isEqualTo(  VICHENKA);
    }
@Ignore
    @Test(expected = NotFoundException.class)
public void updateMenuException(){
        Menu newMenu = new Menu();
        newMenu.setId(333);
    restRestaurant.updateMenu(100001, newMenu);
}
    @Test
    public void updateMenu() {
        Menu oldMenu =   restRestaurant.getRestaurant(100001).getMenu(LocalDate.now());
        oldMenu.clear();
        oldMenu.setDishs("Борщ Кавкаский", 133);
        oldMenu.setDishs("Индюшатина в соусе Аля Франце", 99);
        oldMenu.setDishs("Кампот вишневый с пироженым", 103);
        oldMenu.setAdmin(FEDIA);
       // restRestaurant.updateMenu(100001, oldMenu);
        Menu UPDATEMENU = restRestaurant.getMenu(100001,oldMenu.getId());



        assertThat(UPDATEMENU).isEqualToIgnoringGivenFields(oldMenu);
    }

    @Test
    public void createMenu() {
        Menu newMenu = new Menu(1000019);
        newMenu.setDishs("Борщ Кавкаский", 151);
        newMenu.setDishs("Индюшатина в соусе Аля Франце", 121);
        newMenu.setDishs("Кампот вишневый с пироженым", 132);
        newMenu.setAdmin(FEDIA);

        restRestaurant.createMenu(100003, newMenu);
        Menu menu = restRestaurant.getMenu(100003,1000019 );
        assertMatch(menu,newMenu);
    }

    @Test
    public void createRestaurant() {
        Restaurant newRestaurant = new Restaurant(100020, "ФРАНСУАЗА");
        restRestaurant.createRestaurant(newRestaurant);
        Restaurant restaurantBasa = restRestaurant.getRestaurant(100020);


    }
}