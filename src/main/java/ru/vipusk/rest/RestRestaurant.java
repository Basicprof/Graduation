package ru.vipusk.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.vipusk.model.Menu;
import ru.vipusk.model.Restaurant;
import ru.vipusk.model.User;
import ru.vipusk.model.util.SecurityUtil;
import ru.vipusk.repository.jpa.JpaRepositoryMenagerRestaurant;

import java.time.LocalDate;
import java.util.List;

import static ru.vipusk.model.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestRestaurant {
    private static final Logger LOG = LoggerFactory.getLogger(RestRestaurant.class);

    private final JpaRepositoryMenagerRestaurant repositoryMenagerRestaurant;


    @Autowired
    public RestRestaurant(JpaRepositoryMenagerRestaurant repositoryMenagerRestaurant) {
        this.repositoryMenagerRestaurant = repositoryMenagerRestaurant;
    }

    public void clear(){
        LOG.info("Clear JpaRepositoryMenagerRestaurant ");
        repositoryMenagerRestaurant.clear();
    }
    public void newVote(Integer idRest) {
        int userId = SecurityUtil.authUserId();
        LOG.info("get User {} voting Restaurant {}", userId, idRest);
        Assert.notNull(idRest, "idRest  must not be null");

        repositoryMenagerRestaurant.newVote(idRest, userId);

    }

    public Integer isVoteToDey(Integer idRest) {
        LOG.info("isVoteToDey  for Restaurant {}", idRest);
        Assert.notNull(idRest, "idRest  must not be null");
        return repositoryMenagerRestaurant.isVoteToDey(idRest);
    }

    public List<Restaurant> getAll() {
        LOG.info("getAll  Restaurants  ");

        return repositoryMenagerRestaurant.getRestaurants();
    }

    public Restaurant getRestaurant(Integer idRest) {
        Assert.notNull(idRest, "idRest  must not be null");

        LOG.info("get  Restaurant {}", idRest);
        return repositoryMenagerRestaurant.getRestaurant(idRest);
    }

    public Menu getMenu(int idRest, int idMenu) {
        Assert.notNull(idRest, "idRest  must not be null");
        Assert.notNull(idMenu, "idMenu  must not be null");
        LOG.info("getMenu  {} for Restaurant {}", idMenu, idRest);
        return checkNotFoundWithId(repositoryMenagerRestaurant.getRestaurant(idRest).getMenu(LocalDate.now()), idMenu);

    }

    public void updateMenu(int idRest, Menu menu) {
        int adminId = SecurityUtil.authUserId();
        LOG.info("updateMenu  {} for Restaurant {} Admin {}", menu.getId(), idRest, adminId);
        Assert.notNull(idRest, "idRest  must not be null");
        Assert.notNull(menu, "menu  must not be null");
        repositoryMenagerRestaurant.getRestaurant(idRest).updateMenu(menu);
    }

    public void createMenu(int idRest, Menu menu) {
        int userId = SecurityUtil.authUserId();
        Assert.notNull(idRest, "idRest  must not be null");
        Assert.notNull(menu, "menu  must not be null");
        LOG.info("createMenu  {} for Restaurant {} User {}", menu.getId(), idRest, userId);

        repositoryMenagerRestaurant.setMenu(idRest, menu);

    }

    public void createRestaurant(Restaurant restaurant) {
        int adminId = SecurityUtil.authUserId();
        LOG.info("createRestaurant  {} Admin {}", restaurant.getId(), adminId);
        Assert.notNull(restaurant, "restaurant  must not be null");

        repositoryMenagerRestaurant.setRestaurants(restaurant);
    }

    public void setUser(User user) {
        int adminId = SecurityUtil.authUserId();
        LOG.info("setUser  {} Admin {}", user.getId(), adminId);
        Assert.notNull(user, "user  must not be null");

        repositoryMenagerRestaurant.getUsers().add(user);

    }

}
