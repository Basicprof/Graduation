package ru.vipusk.util;

import ru.vipusk.model.Dishs;
import ru.vipusk.model.Restaurant;
import ru.vipusk.model.Voting;
import ru.vipusk.to.MenuVotes;
import ru.vipusk.to.RestaurantTo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class RestaurantUtil {
    public static List<RestaurantTo> getWithExcess(Collection<Restaurant> restaurants) {
        final List<RestaurantTo> restaurantTos = new ArrayList<>(restaurants.size());
        Map<LocalDate, List<Dishs>> dateDishsMap ;
        Map<LocalDate, Long> dateVotingMap  ;

        for (Restaurant oneRest : restaurants) {
            final Map<LocalDate, MenuVotes> dateMenuVoteMap = new HashMap<>();
            dateDishsMap = oneRest.getMenus().stream()
                    .collect(Collectors.groupingBy(Dishs::getDate));
            dateVotingMap = oneRest.getVotings().stream().collect(
                    Collectors.groupingBy(Voting::getRegistered, Collectors.counting()
                    ));
            final Map<LocalDate, List<Dishs>> finalDateDishsMap = dateDishsMap;
            dateVotingMap.forEach((k, v) ->
            {
                dateMenuVoteMap.put(k, new MenuVotes(v.intValue(),
                        finalDateDishsMap.get(k) == null ? new ArrayList<Dishs>() : finalDateDishsMap.get(k)));
            });
            restaurantTos.add(new RestaurantTo(oneRest.getId(), oneRest.getName(), dateMenuVoteMap));
            dateDishsMap.clear();
            dateVotingMap.clear();
        }
        return restaurantTos;
    }

}