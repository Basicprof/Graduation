package ru.vipusk.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.vipusk.model.Dishs;
import ru.vipusk.model.Restaurant;
import ru.vipusk.model.Voting;
import ru.vipusk.repository.jpa.JpaReataurantRepository;
import ru.vipusk.to.RestaurantTo;
import ru.vipusk.web.SecurityUtil;


import java.util.List;

import static ru.vipusk.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantRestController {
    private static final Logger LOG = LoggerFactory.getLogger(RestaurantRestController.class);

    private final JpaReataurantRepository jpaReataurantRepository;


    @Autowired
    public RestaurantRestController(JpaReataurantRepository repositoryMenagerRestaurant) {
        this.jpaReataurantRepository = repositoryMenagerRestaurant;
    }


    public Voting isVote(Integer idRest) {
        int userId = SecurityUtil.authUserId();
        LOG.info("isVote User {} voting Restaurant {}", userId, idRest);
        Assert.notNull(idRest, "idRest  must not be null");
        return jpaReataurantRepository.isVote(idRest, userId);//jpaReataurantRepository.getVote(idRest,date);
    }


    public Restaurant getRestaurant(Integer idRest) {
        Assert.notNull(idRest, "idRest  must not be null");

        LOG.info("get  Restaurant {}", idRest);
        return jpaReataurantRepository.get(idRest);
    }


    public Dishs getDishs(int idDishs) {
        Assert.notNull(idDishs, "idDishs  must not be null");
        LOG.info("getDishs  {} for Restaurant  ", idDishs);
        return jpaReataurantRepository.getDishs(idDishs);

    }

    public void updateDishs(Dishs dishs) {
        int adminId = SecurityUtil.authUserId();
        LOG.info("updateMenu  {} for Restaurant   Admin {}", dishs.getId(), adminId);
        Assert.notNull(dishs, "dishs  must not be null");
        checkNotFoundWithId(jpaReataurantRepository.save(dishs, dishs.getRestaurant_id()),dishs.getId());

    }

    public Dishs createDishs(int idRest, Dishs dishs) {
        int userId = SecurityUtil.authUserId();
        Assert.notNull(idRest, "idRest  must not be null");
        Assert.notNull(dishs, "dishs must not be null");
        LOG.info("createDishs  {} for Restaurant {} User {}", dishs.getId(), idRest, userId);

        return jpaReataurantRepository.save(dishs, idRest);

    }

    public List<Dishs> getAllDishsRestaurantId(int idRest) {
        int adminId = SecurityUtil.authUserId();
        LOG.info("getAllDishsRestaurantId  RestaurantId {}", idRest);
        Assert.notNull(idRest, "idRest  must not be null");

        return jpaReataurantRepository.getAllDishsRestaurantId(idRest);
    }

    public int createRestaurant(Restaurant restaurant) {
        int adminId = SecurityUtil.authUserId();
        LOG.info("createRestaurant  {} Admin {}", restaurant.getId(), adminId);
        Assert.notNull(restaurant, "restaurant  must not be null");

        return jpaReataurantRepository.saveRestaurant(restaurant);
    }

    public List<RestaurantTo> getRestaurantTo() {
        int userId = SecurityUtil.authUserId();
        LOG.info("getRestaurantTos   {}", userId);

        return jpaReataurantRepository.getRestaurantTo();
    }
}
