package ru.vipusk;



import ru.vipusk.model.Admin;
import ru.vipusk.model.Menu;
import ru.vipusk.model.Restaurant;
import ru.vipusk.model.User;
import ru.vipusk.rest.RestRestaurant;

public class RestaurentCreateData {

 private  RestRestaurant restRestaurant;

    public RestaurentCreateData(RestRestaurant restRestaurant) {
        this.restRestaurant = restRestaurant;
    }





    public RestRestaurant getRestRestaurant() {
        return restRestaurant;
    }

    {Admin FEDIA = new Admin(100006, "Федя");
        Admin JORA = new Admin(100007, "Жера");

        User KOLYA = new User(100011, "Коля");
        User VASYA = new User(100012, "Вася");
        User PETYA = new User(100013, "Петя");
        restRestaurant.createRestaurant(new Restaurant(100000, "Кристал"));
        restRestaurant.createRestaurant(new Restaurant(100001, "Бердянск"));
        restRestaurant.createRestaurant(new Restaurant(100002, "Седьмое Небо"));
        restRestaurant.createRestaurant(new Restaurant(100003, "Вишенка"));
        restRestaurant.createRestaurant(new Restaurant(100004, "Лас Вегас"));
        restRestaurant.setUser(KOLYA);
        restRestaurant.setUser(VASYA);
        restRestaurant.setUser(PETYA);

        Menu menu_1 = new Menu(100014);
        menu_1.setDishs("Картошка фри", 155);
        menu_1.setDishs("Суп с фрикадельками", 128);
        menu_1.setDishs("Пантиока Заморская", 100);
        menu_1.setAdmin(FEDIA);
        Menu menu_2 = new Menu(100015);
        menu_2.setDishs("Борщ Украинский", 165);
        menu_2.setDishs("Вареники с Вищнями", 111);
        menu_2.setDishs("Запеканка", 102);
        menu_2.setAdmin(JORA);
        Menu menu_3 = new Menu(100016);
        menu_3.setDishs("Суп Харчо", 154);
        menu_3.setDishs("Драники", 122);
        menu_3.setDishs("Утка пекинская", 104);
        menu_3.setAdmin(FEDIA);
        Menu menu_4 = new Menu(100017);
        menu_4.setDishs("Суп с фрикаедльками", 148);
        menu_4.setDishs("Гуляш с пюре", 132);
        menu_4.setDishs("Салат Весенний", 99);
        menu_4.setAdmin(JORA);
        Menu menu_5 = new Menu(100018);
        menu_4.setDishs("Щи Русские", 147);
        menu_4.setDishs("Пельмени Сибирские", 124);
        menu_4.setDishs("Венегрет", 105);
        menu_4.setAdmin(JORA);

        restRestaurant.createMenu(100000, menu_1);
        restRestaurant.createMenu(100001, menu_2);
        restRestaurant.createMenu(100002, menu_3);
        restRestaurant.createMenu(100003, menu_4);
        restRestaurant.createMenu(100004, menu_5);
    }
}
