package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable {
    @CreatedBy
    @JsonBackReference(value="createdBy") // it avoids circular relationships
    @ManyToOne
    @JoinColumn(name="created_by", referencedColumnName="id")
    protected User createdBy;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column (name="created_date")
    protected Date createdDate;

    @JsonBackReference (value="changedBy") // it avoids circular relationships
    @ManyToOne
    @JoinColumn(name="last_modified_by", referencedColumnName="id")
    @LastModifiedBy
    protected User lastModifiedBy;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column (name="last_modified_date")
    protected Date lastModifiedDate;

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
