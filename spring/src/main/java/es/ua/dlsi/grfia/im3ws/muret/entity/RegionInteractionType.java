package es.ua.dlsi.grfia.im3ws.muret.entity;

import javax.persistence.*;

/**
 * @author drizo
 */
@Entity
public class RegionInteractionType implements IID<Integer>  {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    String name;

    public RegionInteractionType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegionInteractionType)) return false;

        RegionInteractionType that = (RegionInteractionType) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RegionInteractionType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
