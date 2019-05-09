package ru.vipusk.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu extends AbstractIdEntity {

    private AtomicInteger voting = new AtomicInteger(0);
    private Map<String, Integer> dishs = new HashMap<>();
    private User admin;

    public Menu(Integer id) {
        super(id);
    }

    public Menu() {

    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }


    public Integer getVoting() {
        return voting.intValue();
    }

    public void incrementVotin() {
        voting.incrementAndGet();
    }

    public void decrimentVotin() {
        voting.decrementAndGet();
    }

    public Map<String, Integer> getDishs() {
        return dishs;
    }

    public void setDishs(String name, Integer cash) {
        this.dishs.put(name, cash);
    }

    public void clear() {
        dishs.clear();
    }

}
