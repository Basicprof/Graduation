package ru.vipusk.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vipusk.model.Dishs;
import ru.vipusk.model.Restaurant;
import ru.vipusk.model.Voting;
import ru.vipusk.to.RestaurantTo;
import ru.vipusk.util.RestaurantUtil;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Repository
@Transactional(readOnly = true)
public class JpaReataurantRepository {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public Dishs save(Dishs dishs, int restaurantId) {
        if (!dishs.isNew() && get(restaurantId) == null) {
            return null;
        }
        // meal.setUser(em.getReference(User.class, userId));
        if (dishs.isNew()) {
            dishs.setRestaurant_id(restaurantId);
           Restaurant restaurant = em.getReference(Restaurant.class, restaurantId);
            restaurant.setDishs(dishs);
            em.persist(dishs);
            return dishs;
        } else {
            return em.merge(dishs);
        }
    }
    @Transactional
    public int  saveRestaurant(Restaurant restaurant) {
             if (restaurant.isNew()) {
                   em.persist(restaurant);
                    }
        return restaurant.getId();
    }
    @Transactional
    public Voting isVote(int idRest, int idUser) {
        Restaurant restaurant = em.getReference(Restaurant.class, idRest);
        Set<Voting> votings = restaurant.getVotings();
        if (LocalTime.now().getHour() < 11) {
            Voting voting = votings.stream().filter(v -> v.getUser_id() == idUser).findAny().orElse(null);
            if (voting == null) {
                final Voting v = new Voting( idUser, idRest);
                restaurant.setVotings(v);
                em.persist(v);
                return v;
            } else {
                votings.remove(voting);
            }
        }
        return null;
    }


    public List<Dishs> getAllDishsRestaurantId(int restaurantId) {
        List<Dishs> dishs = em.createNamedQuery(Dishs.ALL_DISHS_ONE_RESTAURANT,Dishs.class)
                .setParameter("idRest",restaurantId).getResultList();

        return  dishs;
    }

    public Restaurant get(int restaurantId) {
        Restaurant restaurant = em.find(Restaurant.class, restaurantId);
        return restaurant != null && restaurant.getId() == restaurantId ? restaurant : null;
    }

    public Dishs getDishs(int idDishs) {
        Dishs dishs = em.find(Dishs.class, idDishs);
        return dishs != null && dishs.getId() == idDishs ? dishs : null;
    }

    public List<Restaurant> getAll() {
        return em.createNamedQuery(Restaurant.ALL_VOTING_DISHS, Restaurant.class)
                .getResultList();
    }


    public List<RestaurantTo> getRestaurantTo() {

        return RestaurantUtil.getWithExcess(
                em.createNamedQuery(Restaurant.ALL_VOTING_DISHS, Restaurant.class).getResultList());

    }
}