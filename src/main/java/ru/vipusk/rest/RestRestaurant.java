package ru.vipusk.rest;

import ru.vipusk.model.Menu;
import ru.vipusk.model.Restaurant;
import ru.vipusk.model.User;
import ru.vipusk.model.util.SecurityUtil;
import ru.vipusk.repository.RepositoryMenagerRestaurant;

import java.time.LocalDate;
import java.util.List;

import static ru.vipusk.model.util.ValidationUtil.checkNew;
import static ru.vipusk.model.util.ValidationUtil.checkNotFoundWithId;

public class RestRestaurant {
    private RepositoryMenagerRestaurant repositoryMenagerRestaurant = new RepositoryMenagerRestaurant();


    public void newVote(Integer idRest) {

        repositoryMenagerRestaurant.newVote(idRest, SecurityUtil.authUserId());

    }

    public Integer isVoteToDey(Integer idRest) {
        return repositoryMenagerRestaurant.isVoteToDey(idRest);
    }

    public List<Restaurant> getAll() {
        return repositoryMenagerRestaurant.getRestaurants();
    }

    public Restaurant getRestaurant(Integer idRest) {
        return repositoryMenagerRestaurant.getRestaurant(idRest);
    }

    public Menu getMenu(int idRest, int idMenu) {
        return checkNotFoundWithId(repositoryMenagerRestaurant.getRestaurant(idRest).getMenu(LocalDate.now()), idMenu);

    }

    public void updateMenu(int idRest, Menu menu) {

        repositoryMenagerRestaurant.getRestaurant(idRest).updateMenu(menu);
    }

    public void createMenu(int idRest, Menu menu) {

        repositoryMenagerRestaurant.setMenu(idRest, menu);

    }

    public void createRestaurant(Restaurant restaurant) {

        repositoryMenagerRestaurant.setRestaurants(restaurant);
    }

    public void setUser(User user) {

        repositoryMenagerRestaurant.getUsers().add(user);

    }

}
