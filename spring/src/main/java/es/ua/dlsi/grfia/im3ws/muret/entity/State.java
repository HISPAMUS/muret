package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class State implements IID<Long>  {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="state")
    @Enumerated(EnumType.STRING)
    private States state;

    @JsonBackReference (value="changedBy") // it avoids circular relationships
    @ManyToOne
    @JoinColumn(name="changed_by", referencedColumnName="id")
    private User changedBy;

    private String comments;

    public State() {
    }

    public State(States state, User changedBy, String comments) {
        this.state = state;
        this.changedBy = changedBy;
        this.comments = comments;
    }
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public User getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(User changedBy) {
        this.changedBy = changedBy;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state1 = (State) o;
        return Objects.equals(id, state1.id) &&
                state == state1.state &&
                changedBy.equals(state1.changedBy) &&
                Objects.equals(comments, state1.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, changedBy, comments);
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", state=" + state +
                ", changedBy=" + changedBy +
                ", comments='" + comments + '\'' +
                '}';
    }
}
