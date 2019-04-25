package es.ua.dlsi.grfia.im3ws.muret.entity;

import javax.persistence.*;

/**
 * @author drizo
 */
@Entity
public class ActionType {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    String name;

    @Column
    String description;

    @Column
    @Enumerated(EnumType.STRING)
    Phase phase;

    public ActionType() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }
}
