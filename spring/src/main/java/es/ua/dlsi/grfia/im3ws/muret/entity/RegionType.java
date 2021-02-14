package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

/**
 * @author drizo
 */
@Entity
public class RegionType implements IID<Integer>  {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    String name;

    /**
     * RGB Color without #, e.g. FF0000
     */
    @Column
    String hexargb;

    @Column
    String help;

    @ManyToOne
    @JoinColumn(name="region_interaction_type_id")
    RegionInteractionType regionInteractionType;


    public RegionType() {
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

    public String getHexargb() {
        return hexargb;
    }

    public void setHexargb(String hexargb) {
        this.hexargb = hexargb;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public RegionInteractionType getRegionInteractionType() {
        return regionInteractionType;
    }

    public void setRegionInteractionType(RegionInteractionType regionInteractionType) {
        this.regionInteractionType = regionInteractionType;
        System.out.println(">>>" + this.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegionType)) return false;

        RegionType that = (RegionType) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RegionType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hexargb='" + hexargb + '\'' +
                ", help='" + help + '\'' +
                ", regionInteractionType=" + regionInteractionType +
                '}';
    }
}
