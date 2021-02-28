package es.ua.dlsi.grfia.im3ws.muret.entity;

import javax.persistence.*;

/**
 * @author drizo
 */
@Entity
public class ImageRecognitionPhase implements IID<Integer>  {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    String name;


    public ImageRecognitionPhase() {
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
        if (!(o instanceof ImageRecognitionPhase)) return false;

        ImageRecognitionPhase that = (ImageRecognitionPhase) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "ImageRecognitionPhase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
