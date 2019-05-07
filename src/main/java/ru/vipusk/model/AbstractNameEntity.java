package ru.vipusk.model;

public abstract class AbstractNameEntity extends AbstractIdEntity {

    private String name;

    public AbstractNameEntity(String name) {
        this.name = name;
    }

    public AbstractNameEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public AbstractNameEntity() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
