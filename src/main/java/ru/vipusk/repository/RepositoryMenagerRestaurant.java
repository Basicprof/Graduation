package ru.vipusk.repository;


import org.springframework.stereotype.Repository;
import ru.vipusk.model.Menu;
import ru.vipusk.model.Restaurant;
import ru.vipusk.model.User;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class RepositoryMenagerRestaurant {


    private List<Restaurant> restaurants = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public RepositoryMenagerRestaurant() {

    }
    public List<User> getUsers(){
        return users;
    }

    public Restaurant getRestaurant(Integer idRest) {


        return restaurants.get(getIndexRest(idRest));
    }

    public void setRestaurants(Restaurant restaurants) {
        this.restaurants.add(restaurants);
    }


    public List<Restaurant> getRestaurants() {
        Collections.sort(restaurants, Comparator.comparing(Restaurant::getId));
        return restaurants;
    }

    public void setMenu(int  idRest, Menu menu) {

         final Restaurant restaurant = restaurants.get(getIndexRest(idRest));

        if (restaurant.getALL().size()==0) {
            restaurant.setMenu(menu);

        } else restaurant.updateMenu(menu);

    }

    public void newVote(int idRest, int idUser) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(getIndexUser(idUser)).getId() == idUser) {
                if (LocalTime.now().getHour() < 23.00) {
                    if (!users.get(getIndexUser(idUser)).isNew()) {
                        restaurants.get(getIndexRest(idRest)).incrementVoting();
                        users.get(getIndexUser(idUser)).setVotingToDey(true);
                    } else {
                        restaurants.get(getIndexRest(idRest)).dicrementVoting();
                        users.get(getIndexUser(idUser)).setVotingToDey(false);
                    }
                }else {
                    if(users.get(getIndexUser(idUser)).isVotingToDey()){
                        users.get(getIndexUser(idUser)).setVotingToDey(false);
                    }
                }

            }
        }
    }
    public Integer isVoteToDey(int idRest) {
        return restaurants.get(getIndexRest(idRest)).isVoteToDey();
    }

    public Integer getIndexRest(int idRest) {
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getId() == idRest)
                return i;
        }
        return -1;
    }

    public Integer getIndexUser(int idUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == idUser )
                return i;
        }
        return -1;
    }


}
