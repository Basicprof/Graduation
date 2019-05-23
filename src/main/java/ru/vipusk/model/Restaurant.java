package ru.vipusk.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("JpaQlInspection")
@NamedQueries({
//        @NamedQuery(name = Restaurant.ALL_SORTED, query = "SELECT m FROM Restaurant m WHERE m.user.id=:userId ORDER BY m.dateTime DESC"),
//        @NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM Restaurant m WHERE m.id=:id AND m.user.id=:userId"),
        @NamedQuery(name = Restaurant.GET_BETWEEN, query = "SELECT r FROM Restaurant r " +
                "LEFT JOIN FETCH  r.votings v WHERE v.registered BETWEEN :startDate AND :endDate ORDER BY v.restaurant_id DESC"),
        @NamedQuery(name = Restaurant.ALL_VOTING_DISHS, query = "SELECT DISTINCT r FROM Restaurant r  ORDER BY r.id ASC "),

//        @NamedQuery(name = Restaurant.UPDATE, query = "UPDATE Restaurant m SET m.dateTime = :datetime, m.calories= :calories," +
//                "m.description=:desc where m.id=:id and m.user.id=:userId")
})
@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractNamedEntity {
//    public static final String ALL_SORTED = "Restaurant.getAll";
//    public static final String DELETE = "Restaurant.delete";
    public static final String GET_BETWEEN = "Restaurant.getBetween";
    public static final String ALL_VOTING_DISHS = "Restaurant.getAllVotingDishs";

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "ID", nullable = false)
    private Set<Voting> votings = new HashSet<>() ;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "ID", nullable = false)
    private List<Dishs> menus = new ArrayList<>();

    public Restaurant(String name) {
        super(name);
    }

    public Restaurant(Integer rest_id, String name) {
        super(rest_id, name);
    }

    public Restaurant() {
    }

    public List<Voting> getVotingsBetween(LocalDateTime date) {


        return this.votings.stream().filter(v -> v.getRegistered().equals(date.toLocalDate())).collect(Collectors.toList());
    }
    public Set<Voting> getVotings( ) {


        return this.votings;
    }
    public void setVotings(Voting voting) {

        this.votings.add(voting);

    }

    public void setDishs(Dishs dishs) {
        menus.add(dishs);
    }

    public List<Dishs> getMenus() {
        return menus;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                '}';
    }
}
