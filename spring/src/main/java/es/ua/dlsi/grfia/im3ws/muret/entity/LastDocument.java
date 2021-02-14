package es.ua.dlsi.grfia.im3ws.muret.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;


import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * @author drizo
 */
@Entity
public class LastDocument implements IID<Integer>  {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="document_id", nullable = false)
    private Document document;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column (name="timestamp", nullable = false)
    protected Date timestamp;


    public LastDocument() {
    }

    public LastDocument(Document document, User user, Date timestamp) {
        this.document = document;
        this.user = user;
        this.timestamp = timestamp;
    }
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "LastDocument{" +
                "id=" + id +
                ", document=" + document +
                ", user=" + user +
                ", timestamp=" + timestamp +
                '}';
    }
}
