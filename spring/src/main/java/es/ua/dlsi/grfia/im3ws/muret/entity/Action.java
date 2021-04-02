package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * We use this structure of having the references of all objects for retrieval convenience.
 * No integrity constraint is added to be able to delete objects without affecting this action table
 * @author drizo
 */
@Entity
public class Action implements IID<Long>, Comparable<Action>  {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="id")
    protected User user;

    @ManyToOne
    @JoinColumn(name="action_type_id", referencedColumnName="id")
    protected ActionType actionType;

    @Temporal(TIMESTAMP)
    @Column
    protected Date timestamp;

    @Column (name="document_id")
    Integer documentID;

    @Column (name="section_id")
    Long sectionID;

    @Column (name="image_id")
    Long imageID;

    @Column (name="page_id")
    Long pageID;

    @Column (name="region_id")
    Long regionID;

    @Column (name="symbol_id")
    Long symbolID;

    @Column (name="classifier_id")
    String classifierID;

    public Action() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getDocumentID() {
        return documentID;
    }

    public void setDocumentID(Integer documentID) {
        this.documentID = documentID;
    }

    public Long getImageID() {
        return imageID;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }

    public Long getRegionID() {
        return regionID;
    }

    public void setRegionID(Long regionID) {
        this.regionID = regionID;
    }

    public Long getSymbolID() {
        return symbolID;
    }

    public void setSymbolID(Long symbolID) {
        this.symbolID = symbolID;
    }

    public Long getSectionID() {
        return sectionID;
    }

    public void setSectionID(Long sectionID) {
        this.sectionID = sectionID;
    }

    public Long getPageID() {
        return pageID;
    }

    public void setPageID(Long pageID) {
        this.pageID = pageID;
    }

    public String getClassifierID() {
        return classifierID;
    }

    public void setClassifierID(String classifierID) {
        this.classifierID = classifierID;
    }

    @Override
    public int compareTo(Action o) {
        if (this == o) {
            return 0;
        }

        int diff = this.timestamp.compareTo(o.getTimestamp());
        if (diff == 0) {
            return hashCode() - o.hashCode();
        } else {
            return diff;
        }
    }
}
