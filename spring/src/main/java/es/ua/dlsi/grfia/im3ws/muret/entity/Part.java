package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author drizo
 */
@Entity
public class Part extends Auditable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String comments;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="project_id", referencedColumnName="id")
    @JoinColumn(name="project_id", nullable = false)
    private Project project;

    public Part() {
    }

    public Part(String name, String comments, Project project) {
        this.name = name;
        this.comments = comments;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part that = (Part) o;
        return name.equals(that.name) &&
                project.equals(that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, project);
    }
}
