package ru.vipusk.rest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.vipusk.model.Menu;
import ru.vipusk.model.Restaurant;
import ru.vipusk.model.User;
import ru.vipusk.model.util.SecurityUtil;
import ru.vipusk.model.util.exception.NotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.vipusk.RestaurentTestData.*;

import java.time.LocalDate;
import java.util.List;


@ContextConfiguration({
        "classpath:spring/inmemory.xml"
})
@RunWith(SpringRunner.class)
//@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class RestRestaurantTest {
 private static final Logger LOG = LoggerFactory.getLogger(RestRestaurantTest.class);
    static {

     MENU_1.setDishs("Картошка фри", 155);
     MENU_1.setDishs("Суп с фрикадельками", 128);
     MENU_1.setDishs("Пантиока Заморская", 100);
     MENU_1.setAdmin(FEDIA);
     MENU_2.setDishs("Борщ Украинский", 165);
     MENU_2.setDishs("Вареники с Вищнями", 111);
     MENU_2.setDishs("Запеканка", 102);
     MENU_2.setAdmin(JORA);
     MENU_3.setDishs("Суп Харчо", 154);
     MENU_3.setDishs("Драники", 122);
     MENU_3.setDishs("Утка пекинская", 104);
     MENU_3.setAdmin(FEDIA);
     MENU_4.setDishs("Суп с фрикаедльками", 148);
     MENU_4.setDishs("Гуляш с пюре", 132);
     MENU_4.setDishs("Салат Весенний", 99);
     MENU_4.setAdmin(JORA);
     MENU_5.setDishs("Щи Русские", 147);
     MENU_5.setDishs("Пельмени Сибирские", 124);
     MENU_5.setDishs("Венегрет", 105);
     MENU_5.setAdmin(JORA);
 }
    @Autowired
    RestRestaurant restRestaurant;

    @Before
    public void setUp() throws Exception {
    restRestaurant.clear();
        restRestaurant.createRestaurant(new Restaurant(100000, "Кристал"));
        restRestaurant.createRestaurant(new Restaurant(100001, "Бердянск"));
        restRestaurant.createRestaurant(new Restaurant(100002, "Седьмое Небо"));
        restRestaurant.createRestaurant(new Restaurant(100003, "Вишенка"));
        restRestaurant.createRestaurant(new Restaurant(100004, "Лас Вегас"));
        restRestaurant.setUser(KOLYA);
        restRestaurant.setUser(VASYA);
        restRestaurant.setUser(PETYA);
        restRestaurant.setUser(JORA);
        restRestaurant.setUser(FEDIA);
        restRestaurant.createMenu(100000, MENU_1);
        restRestaurant.createMenu(100001, MENU_2);
        restRestaurant.createMenu(100002, MENU_3);
        restRestaurant.createMenu(100003, MENU_4);
        restRestaurant.createMenu(100004, MENU_5);
        SecurityUtil.setAuthUserId(100011);
        restRestaurant.newVote(100000);
        SecurityUtil.setAuthUserId(100011);
        restRestaurant.newVote(100001);
        SecurityUtil.setAuthUserId(100011);
        restRestaurant.newVote(100002);
        SecurityUtil.setAuthUserId(100011);
        restRestaurant.newVote(100003);
        SecurityUtil.setAuthUserId(100011);
        restRestaurant.newVote(100004);
        SecurityUtil.setAuthUserId(100011);

        restRestaurant.newVote(100000);
        SecurityUtil.setAuthUserId(100012);
        restRestaurant.newVote(100001);
        SecurityUtil.setAuthUserId(100012);
        restRestaurant.newVote(100002);
        SecurityUtil.setAuthUserId(100012);
        restRestaurant.newVote(100003);

        SecurityUtil.setAuthUserId(100013);
        restRestaurant.newVote(100000);
        SecurityUtil.setAuthUserId(100013);
        restRestaurant.newVote(100001);
        SecurityUtil.setAuthUserId(100013);
        restRestaurant.newVote(100002);
        SecurityUtil.setAuthUserId(100013);

        restRestaurant.newVote(100000);
        SecurityUtil.setAuthUserId(100013);
        restRestaurant.newVote(100001);

        SecurityUtil.setAuthUserId(100011);
        restRestaurant.newVote(100000);

    }


    @Test
    public void newVote() {

        SecurityUtil.setAuthUserId(100011);
        restRestaurant.newVote(100004);
        Integer integ = restRestaurant.isVoteToDey(100004);
        assertThat(integ).isEqualTo(1);
    }

    @Test
    public void isVoteToDey() {

        SecurityUtil.setAuthUserId(100011);
        restRestaurant.newVote(100004);
        Integer integ = restRestaurant.isVoteToDey(100004);
        assertThat(integ).isEqualTo(1);
    }

    @Test
    public void getAll() {
        List<Restaurant> restrestaurantlist = restRestaurant.getAll();
        assertThat(restrestaurantlist).isEqualTo(RESTAURANTLIST);
    }

    @Test
    public void getRestaurant() {
        Restaurant RESTAURANT = restRestaurant.getRestaurant(100003);
        assertThat(RESTAURANT).isEqualTo(VICHENKA);
    }

    @Ignore
    @Test(expected = NotFoundException.class)
    public void updateMenuException() {
        Menu newMenu = new Menu();
        newMenu.setId(333);
        restRestaurant.updateMenu(100001, newMenu);
    }

    @Test
    public void updateMenu() {
        Menu oldMenu = restRestaurant.getRestaurant(100001).getMenu(LocalDate.now());
        oldMenu.clear();
        oldMenu.setDishs("Борщ Кавкаский", 133);
        oldMenu.setDishs("Индюшатина в соусе Аля Франце", 99);
        oldMenu.setDishs("Кампот вишневый с пироженым", 103);
        oldMenu.setAdmin(FEDIA);
        // restRestaurant.updateMenu(100001, oldMenu);
        Menu UPDATEMENU = restRestaurant.getMenu(100001, oldMenu.getId());


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
        Menu menu = restRestaurant.getMenu(100003, 1000019);
        assertMatch(menu, newMenu);
    }

    @Test
    public void createRestaurant() {
        Restaurant newRestaurant = new Restaurant(100020, "ФРАНСУАЗА");
        restRestaurant.createRestaurant(newRestaurant);
        Restaurant restaurantBasa = restRestaurant.getRestaurant(100020);


    }
}