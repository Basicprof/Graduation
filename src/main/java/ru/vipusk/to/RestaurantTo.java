package ru.vipusk.to;


import ru.vipusk.model.AbstractNamedEntity;
import ru.vipusk.model.Dishs;
import ru.vipusk.model.Voting;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.*;

public class RestaurantTo extends AbstractNamedEntity {

    Map<LocalDate,MenuVotes> menuVoteMap = new HashMap<>();

    public RestaurantTo() {

    }
     public   RestaurantTo(int id, String name, Map<LocalDate,MenuVotes> menuVoteMap){
      super(id,name);
      this.menuVoteMap.putAll(menuVoteMap);
     }


}
