package ru.vipusk.to;

import ru.vipusk.model.Dishs;

import java.util.List;
import java.util.Set;

public class MenuVotes {
    List<Dishs> dishs;

    Integer votings;

    public MenuVotes(Integer votings, List<Dishs> dishs) {
        this.dishs = dishs;
        this.votings = votings;
    }

    public Integer getVotings() {
        return votings;
    }

    public List<Dishs> getDishs() {
        return dishs;
    }


}
