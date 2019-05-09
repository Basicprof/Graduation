package ru.vipusk.model;


public abstract class AbstractIdEntity {

    public static final int START_SEQ = 100000;
    private Integer id;

    public boolean isNew(){
        return id == null;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
   public AbstractIdEntity(Integer id) {
         this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractIdEntity that = (AbstractIdEntity) o;
        return id!=null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 :id ;
    }

    public AbstractIdEntity() {
    }
}
