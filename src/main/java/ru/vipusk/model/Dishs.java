package ru.vipusk.model;

public class Dishs extends AbstractIdEntity {
    private String name;
    private int price;


    public Dishs(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Dishs() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
