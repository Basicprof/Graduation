package ru.vipusk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "voting")
public class Voting extends AbstractBaseEntity {




    @Column
    private Integer user_id;
    @Column(name = "restaurant_id", insertable = false, updatable = false)
    private Integer restaurant_id;


    @Column(name = "DATE_TIME", columnDefinition = "timestamp default now()")
    @NotNull
    private LocalDateTime registered = LocalDateTime.now();


    public Voting() {
    }


    public Voting( Integer user_id, Integer restaurant_id) {

        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
    }

    public Voting(Integer id,   Integer user_id, Integer restaurant_id, @NotNull LocalDateTime registered) {
        super(id);
        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
        this.registered = registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public LocalDate getRegistered() {
        return registered.toLocalDate();
    }


}
