package ru.vipusk.model;

import java.time.LocalDate;
import java.util.*;

public class Restaurant extends AbstractNameEntity {

    private Map<LocalDate, Menu> menuOfTheDay = new HashMap<>();

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    public Restaurant(String name) {
        super(name);
    }

    public Integer isVoteToDey() {
        return menuOfTheDay.get(LocalDate.now()).getVoting();
    }

    public Menu getMenu(LocalDate localDate) {
        return menuOfTheDay.get(localDate);
    }

    public void incrementVoting() {

        menuOfTheDay.get(LocalDate.now()).incrementVotin();

    }

    public void dicrementVoting() {

        menuOfTheDay.get(LocalDate.now()).decrimentVotin();


    }

    public void setMenu(Menu menu) {
        menuOfTheDay.putIfAbsent(LocalDate.now(), menu);
    }

    public void updateMenu(Menu menu) {
        menuOfTheDay.computeIfPresent(LocalDate.now(), (k, v) -> v = menu);
    }

    public List<Menu> getALL() {
        List<Menu> list = new ArrayList<>(menuOfTheDay.values());
        return list;
    }


}
