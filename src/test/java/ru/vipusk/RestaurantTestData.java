package ru.vipusk;


import ru.vipusk.model.AbstractNamedEntity;
import ru.vipusk.model.Dishs;
import ru.vipusk.model.Restaurant;
import ru.vipusk.model.Voting;
import ru.vipusk.to.RestaurantTo;
import ru.vipusk.util.RestaurantUtil;
import ru.vipusk.web.SecurityUtil;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.vipusk.UserTestData.USER_ID;
import static ru.vipusk.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {
    public static final int RESTAURANT1_ID = START_SEQ + 2;
    public static final int DISHS_ID = START_SEQ + 7;
    public static final int VOTING_ID = START_SEQ + 23;
    public static final Restaurant RESTAURANT1 = new Restaurant(RESTAURANT1_ID, "Седьмое небо");
    public static final Restaurant RESTAURANT2 = new Restaurant(RESTAURANT1_ID + 1, "Кристалл");
    public static final Restaurant RESTAURANT3 = new Restaurant(RESTAURANT1_ID + 2, "ЛасВегас");
    public static final Restaurant RESTAURANT4 = new Restaurant(RESTAURANT1_ID + 3, "Вишенка");
    public static final Restaurant RESTAURANT5 = new Restaurant(RESTAURANT1_ID + 4, "Устрица");

    public static final List<Restaurant> RESTAURANTS = new ArrayList<>();

    public static final Dishs DISHS1       = new Dishs(DISHS_ID, RESTAURANT1_ID, "Запеканка", 155);
    public static final Dishs DISHS2       = new Dishs(DISHS_ID + 1, RESTAURANT1_ID, "Пюре с котлетой", 128);
    public static final Dishs DISHS3       = new Dishs(DISHS_ID + 2, RESTAURANT1_ID, "Кампот", 100);
    public static final Dishs DISHS4       = new Dishs(DISHS_ID + 3, RESTAURANT1_ID + 1, "Суп с клецками", 165);
    public static final Dishs DISHS5       = new Dishs(DISHS_ID + 4, RESTAURANT1_ID + 1, "Десерт", 111);
    public static final Dishs DISHS6       = new Dishs(DISHS_ID + 5, RESTAURANT1_ID + 1, "Вермишель", 102);
    public static final Dishs DISHS7       = new Dishs(DISHS_ID + 6, RESTAURANT1_ID + 2, "Чай", 154);
    public static final Dishs DISHS8       = new Dishs(DISHS_ID + 7, RESTAURANT1_ID + 2, "Молочный суп", 122);
    public static final Dishs DISHS9       = new Dishs(DISHS_ID + 8, RESTAURANT1_ID + 2, "Плов", 104);
    public static final Dishs DISHS10      = new Dishs(DISHS_ID + 9, RESTAURANT1_ID + 3, "Сациви", 148);
    public static final Dishs DISHS11      = new Dishs(DISHS_ID + 10, RESTAURANT1_ID + 3, "Кисель", 132);
    public static final Dishs DISHS12      = new Dishs(DISHS_ID + 11, RESTAURANT1_ID + 3, "Суп Харчо", 99);
    public static final Dishs DISHS13      = new Dishs(DISHS_ID + 12, RESTAURANT1_ID + 4, "Гуляш", 147);
    public static final Dishs DISHS14      = new Dishs(DISHS_ID + 13, RESTAURANT1_ID + 4, "Гречка", 124);
    public static final Dishs DISHS15      = new Dishs(DISHS_ID + 14, RESTAURANT1_ID + 4, "Борщ", 105);
    public static final Voting  VOTING1    = new Voting(   VOTING_ID,    100000,100002, LocalDateTime.now());
    public static final Voting  VOTING2    = new Voting(VOTING_ID+1,  100000,100002, LocalDateTime.of( 2019,11,13, 15,44));
    public static final Voting  VOTING3    = new Voting(VOTING_ID+2,  100000,100002, LocalDateTime.of( 2019,10,15, 15,44));
    public static final Voting  VOTING4    = new Voting(VOTING_ID+3,  100000,100002, LocalDateTime.of( 2019,9,16, 15,44));
    public static final Voting  VOTING5    = new Voting(VOTING_ID+4,  100000,100003, LocalDateTime.of( 2019,7,16, 15,44));
    public static final Voting  VOTING7    = new Voting(VOTING_ID+5,  100000,100002, LocalDateTime.of( 2019,8,17, 15,44));
    public static final Voting  VOTING6    = new Voting(VOTING_ID+6,  100000,100003, LocalDateTime.now());
    public static final Voting  VOTING8    = new Voting(VOTING_ID+7,  100000,100003, LocalDateTime.of( 2019,5,14, 15,44));
    public static final Voting  VOTING9    = new Voting(VOTING_ID+8,  100000,100003, LocalDateTime.of( 2019,4,15, 15,44));
    public static final Voting  VOTING10   = new Voting(VOTING_ID+9,  100000,100003, LocalDateTime.of( 2019,3,17, 15,44));
    public static final Voting  VOTING11   = new Voting(VOTING_ID+10,  100000,100004, LocalDateTime.of( 2019,2,21, 15,44));
    public static final Voting  VOTING12   = new Voting(VOTING_ID+11,  100000,100004, LocalDateTime.of( 2019,1,23, 15,44));
    public static final Voting  VOTING13   = new Voting(VOTING_ID+12,  100000,100004, LocalDateTime.now());
    public static final Voting  VOTING14   = new Voting(VOTING_ID+13,  100000,100004, LocalDateTime.of( 2019,12,25, 15,44));
    public static final Voting  VOTING15   = new Voting(VOTING_ID+14,  100000,100004, LocalDateTime.of( 2019,11,26, 15,44));
    public static final Voting  VOTING16   = new Voting(VOTING_ID+15,  100000,100005, LocalDateTime.of( 2019,10,27, 15,44));
    public static final Voting  VOTING17   = new Voting(VOTING_ID+16,  100000,100005, LocalDateTime.of( 2019,9,28, 15,44));
    public static final Voting  VOTING18   = new Voting(VOTING_ID+17,  100000,100005, LocalDateTime.of( 2019,8,29, 15,44));
    public static final Voting  VOTING19   = new Voting(VOTING_ID+18,  100000,100005, LocalDateTime.now());
    public static final Voting  VOTING20   = new Voting(VOTING_ID+19,  100000,100005, LocalDateTime.of( 2019,6,1, 15,44));
    public static final Voting  VOTING21   = new Voting(VOTING_ID+20,  100000,100006, LocalDateTime.of( 2019,5,11, 15,44));
    public static final Voting  VOTING22   = new Voting(VOTING_ID+21,  100000,100006, LocalDateTime.of( 2019,4,14, 15,44));
    public static final Voting  VOTING23   = new Voting(VOTING_ID+22,  100000,100006, LocalDateTime.of( 2019,1,17, 15,44));
    public static final Voting  VOTING24   = new Voting(VOTING_ID+23,  100000,100006, LocalDateTime.of( 2019,3,6, 15,44));
    public static final Voting  VOTING25   = new Voting(VOTING_ID+24,  100000,100006, LocalDateTime.now());
  static  {
        RESTAURANT1.setVotings(VOTING1);
        RESTAURANT1.setVotings(VOTING2);
        RESTAURANT1.setVotings(VOTING3);
        RESTAURANT1.setVotings(VOTING4);
        RESTAURANT1.setVotings(VOTING5);
        RESTAURANT2.setVotings(VOTING6);
        RESTAURANT2.setVotings(VOTING7);
        RESTAURANT2.setVotings(VOTING8);
        RESTAURANT2.setVotings(VOTING9);
        RESTAURANT2.setVotings(VOTING10);
        RESTAURANT3.setVotings(VOTING11);
        RESTAURANT3.setVotings(VOTING12);
        RESTAURANT3.setVotings(VOTING13);
        RESTAURANT3.setVotings(VOTING14);
        RESTAURANT3.setVotings(VOTING15);
        RESTAURANT4.setVotings(VOTING16);
        RESTAURANT4.setVotings(VOTING17);
        RESTAURANT4.setVotings(VOTING18);
        RESTAURANT4.setVotings(VOTING19);
        RESTAURANT4.setVotings(VOTING20);
        RESTAURANT5.setVotings(VOTING21);
        RESTAURANT5.setVotings(VOTING22);
        RESTAURANT5.setVotings(VOTING23);
        RESTAURANT5.setVotings(VOTING24);
        RESTAURANT5.setVotings(VOTING25);
        RESTAURANT1.setDishs(DISHS1);
        RESTAURANT1.setDishs(DISHS2);
        RESTAURANT1.setDishs(DISHS3);
        RESTAURANT2.setDishs(DISHS4);
        RESTAURANT2.setDishs(DISHS5);
        RESTAURANT2.setDishs(DISHS6);
        RESTAURANT3.setDishs(DISHS7);
        RESTAURANT3.setDishs(DISHS8);
        RESTAURANT3.setDishs(DISHS9);
        RESTAURANT4.setDishs(DISHS10);
        RESTAURANT4.setDishs(DISHS11);
        RESTAURANT4.setDishs(DISHS12);
        RESTAURANT5.setDishs(DISHS13);
        RESTAURANT5.setDishs(DISHS14);
        RESTAURANT5.setDishs(DISHS15);
    }
    public static final List<Restaurant>GETRESTAURANTS =Arrays.asList(RESTAURANT1,RESTAURANT2,RESTAURANT3,RESTAURANT4,RESTAURANT5);
    public static final List<Dishs> LIST_DISHS = Arrays.asList(DISHS1, DISHS2, DISHS3);

    public static Dishs getCreatedDishs() {
        return new Dishs(null, RESTAURANT1_ID, "Новое блюдо", 255);
    }

    public static Voting getCreatedVoting(Integer rest_id) {
        return new Voting(  USER_ID, rest_id);
    }

    public static Dishs getUpdatedDishs(Dishs dishs) {
        return new Dishs(dishs.getId(), dishs.getRestaurant_id(), "Обновленное Блюдо", 200);
    }

    public static Restaurant getCreatedRestaurant() {
        Restaurant restaurant = new Restaurant("Золотая Устрица");
        return restaurant;
    }


    public static void assertMatch(AbstractNamedEntity actual, AbstractNamedEntity expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "menus" );
    }

    public static void assertMatch(Iterable<? extends AbstractNamedEntity> actual, AbstractNamedEntity... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<? extends AbstractNamedEntity> actual, Iterable<? extends AbstractNamedEntity> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields( ).isEqualTo(expected);
    }
}
