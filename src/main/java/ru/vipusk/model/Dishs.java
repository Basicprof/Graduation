package ru.vipusk.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "dishs")
@NamedQueries({
         @NamedQuery(name = Dishs.ALL_DISHS_ONE_RESTAURANT, query = "SELECT DISTINCT d FROM Dishs d WHERE d.restaurant_id =:idRest"),
 })
public class Dishs extends AbstractNamedEntity {
    public static final String ALL_DISHS_ONE_RESTAURANT = "Dishs.getAllVotingDishs";

    @Column
    private Integer price;

    @Column(name = "restaurant_id", insertable = false, updatable = false)
    private Integer restaurant_id;


    @Column(name = "DATE", columnDefinition = "timestamp default now()")
    @NotNull
    private LocalDate date = LocalDate.now();


    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }


    public Integer getRestaurant_id() {
        return restaurant_id;
    }


    public Dishs() {
    }

    public Dishs(Integer price, Integer restaurant_id) {
        this.price = price;
        this.restaurant_id = restaurant_id;
    }

    public Dishs(Integer id, Integer restaurant_id, String name, Integer price) {
        super(id, name);
        this.price = price;
        this.restaurant_id = restaurant_id;
    }

    public Dishs(Integer id, String name, Integer price) {
        super(id, name);
        this.price = price;
    }

    public Dishs(String name, Integer price, Integer restaurant_id) {
        super(name);
        this.price = price;
        this.restaurant_id = restaurant_id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
