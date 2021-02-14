package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author drizo
 */
@Entity (name="classifier_type")
public class ClassifierType  implements IID<Integer> {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;

    @JsonManagedReference
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "classifierType")
    private List<Classifier> classifiers;

    public ClassifierType() {
    }

    public ClassifierType(String name, List<Classifier> classifiers) {
        this.name = name;
        this.classifiers = classifiers;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Classifier> getClassifiers() {
        return classifiers;
    }

    public void setClassifiers(List<Classifier> classifiers) {
        this.classifiers = classifiers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassifierType that = (ClassifierType) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Classifier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
