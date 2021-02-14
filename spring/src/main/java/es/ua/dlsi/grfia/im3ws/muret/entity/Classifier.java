package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author drizo
 */
@Entity
public class Classifier  implements IID<Integer> {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String value;
    @Column
    private String description;
    @JsonBackReference(value="classifier_type") // it avoids circular relationships
    @ManyToOne
    @JoinColumn(name="classifier_type_id", referencedColumnName="id")
    private ClassifierType classifierType;

    public Classifier() {
    }

    public Classifier(String value, String description, ClassifierType classifierType) {
        this.value = value;
        this.classifierType = classifierType;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ClassifierType getClassifierType() {
        return classifierType;
    }

    public void setClassifierType(ClassifierType classifierType) {
        this.classifierType = classifierType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classifier that = (Classifier) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(classifierType, that.classifierType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, classifierType);
    }

    @Override
    public String toString() {
        return "Classifier{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
