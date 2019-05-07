package ru.vipusk;

import ru.vipusk.model.Admin;
import ru.vipusk.model.Menu;
import ru.vipusk.model.Restaurant;
import ru.vipusk.model.User;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurentTestData {

 public static final Admin FEDIA = new Admin(100006, "Федя");
    public static final Admin JORA = new Admin(100007, "Жера");

    public static final User KOLYA = new User(100011, "Коля");
    public static final User VASYA = new User(100012, "Вася");
    public static final User PETYA = new User(100013, "Петя");

    public static final Menu MENU_1 = new Menu(100014);
    public static final Menu MENU_2 = new Menu(100015);
    public static final Menu MENU_3 = new Menu(100016);
    public static final Menu MENU_4 = new Menu(100017);
    public static final Menu MENU_5 = new Menu(100018);

    public static final Restaurant KRISTAL     = new Restaurant(100000, "Кристал");
    public static final Restaurant BERDYANSK   = new Restaurant(100001, "Бердянск");
    public static final Restaurant SEDMOE_NEBO = new Restaurant(100002, "Седьмое Небо");
    public static final Restaurant VICHENKA    = new Restaurant(100003, "Вишенка");
    public static final Restaurant LAS_VEGAS   = new Restaurant(100004, "Лас Вегас");
    public static final List<Restaurant> RESTAURANTLIST = Arrays.asList(KRISTAL, BERDYANSK,  SEDMOE_NEBO,VICHENKA,LAS_VEGAS );

    {


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
    public static void assertMatch(Menu actual, Menu expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected);
    }

    public static void assertMatch(Iterable<Menu> actual, Menu... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Menu> actual, Iterable<Menu> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields().isEqualTo(expected);
    }
}