package ru.javawebinar.topjava.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Dishs;
import ru.javawebinar.topjava.model.Restaurant;
import ru.javawebinar.topjava.model.Voting;
import ru.javawebinar.topjava.service.RestaurantServise;
import ru.javawebinar.topjava.to.RestaurantTo;

import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

public abstract class AbstractRestaurantController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected RestaurantServise service;

    public List<RestaurantTo> getAll() {
        log.info("getAll");
        return service.getRestaurantTo();
    }
    public Voting isVote(int id){
        log.info("get {}", id);
        return service.isVote(id);
    }
    public Restaurant get(int id) {
        log.info("get {}", id);
        return service.getRestaurant(id);
    }

    public Restaurant create(Restaurant rest) {
        log.info("create {}", rest);
        checkNew(rest);
        return service.createRestaurant(rest);
    }

  public void update(Dishs dishs, int id) {
        log.info("update {} with id={}", dishs, id);
        assureIdConsistent(dishs, id);
        service.updateDishs(dishs);
    }



}