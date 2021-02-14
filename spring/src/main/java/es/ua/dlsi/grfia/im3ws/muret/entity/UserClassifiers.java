package es.ua.dlsi.grfia.im3ws.muret.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author drizo
 */
@Entity
public class UserClassifiers implements IID<Integer>  {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name="classifier_type_id", nullable = false)
    private ClassifierType classifierType;
    @ManyToOne
    @JoinColumn(name="classifier_id", nullable = false)
    private Classifier classifier;

    public UserClassifiers(User user, ClassifierType classifierType, Classifier classifier) {
        this.user = user;
        this.classifierType = classifierType;
        this.classifier = classifier;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ClassifierType getClassifierType() {
        return classifierType;
    }

    public void setClassifierType(ClassifierType classifierType) {
        this.classifierType = classifierType;
    }

    public Classifier getClassifier() {
        return classifier;
    }

    public void setClassifier(Classifier classifier) {
        this.classifier = classifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserClassifiers that = (UserClassifiers) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(classifierType, that.classifierType) &&
                Objects.equals(classifier, that.classifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, classifierType, classifier);
    }

    @Override
    public String toString() {
        return "UserClassifiers{" +
                "id=" + id +
                ", user=" + user +
                ", classifierType=" + classifierType +
                ", classifier=" + classifier +
                '}';
    }
}

