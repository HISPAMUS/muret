package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

/**
 * @author drizo
 */
@Entity
public class RegionType {
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

    public RegionType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}
