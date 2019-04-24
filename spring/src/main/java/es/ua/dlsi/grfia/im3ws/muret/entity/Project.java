package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import es.ua.dlsi.im3.core.score.NotationType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author drizo
 */
@Entity
public class Project extends Auditable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String path;
    @Column
    private String composer;
    @Column
    private String comments;

    @Column (name="notation_type")
    @Enumerated(EnumType.STRING)
    private NotationType notationType;

    @Column (name="manuscript_type")
    @Enumerated(EnumType.STRING)
    private ManuscriptType manuscriptType;

    /**
     * Comma separated list of image ids - when an image is not present here is sorted at the end of the list
     */
    @Column (name = "images_ordering")
    private String imagesOrdering;

    @Lob
    @Column (name = "thumbnail_base64_encoding", columnDefinition = "LONGTEXT")
    private String thumbnailBase64Encoding;

    @JsonManagedReference
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "project")
    private List<Image> images;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="state_id")
    State state;

    public Project() {
    }

    public Project(String name, String path, String composer, Date creationDate, Date lastModifiedDate, User createdBy, User lastModifiedBy , String thumbnailBase64Encoding, String comments, String imagesOrdering, NotationType notationType, ManuscriptType manuscriptType, State state, List<Image> images) {
        this.name = name;
        this.composer = composer;
        this.notationType = notationType;
        this.path = path;
        this.thumbnailBase64Encoding = thumbnailBase64Encoding;
        this.createdDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.images = images;
        this.comments = comments;
        this.imagesOrdering = imagesOrdering;
        this.manuscriptType = manuscriptType;
        this.state = state;
    }
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getThumbnailBase64Encoding() {
        return thumbnailBase64Encoding;
    }

    public void setThumbnailBase64Encoding(String thumbnailBase64Encoding) {
        this.thumbnailBase64Encoding = thumbnailBase64Encoding;
    }

    public NotationType getNotationType() {
        return notationType;
    }

    public void setNotationType(NotationType notationType) {
        this.notationType = notationType;
    }

    public ManuscriptType getManuscriptType() {
        return manuscriptType;
    }

    public void setManuscriptType(ManuscriptType manuscriptType) {
        this.manuscriptType = manuscriptType;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getImagesOrdering() {
        return imagesOrdering;
    }

    public void setImagesOrdering(String imagesOrdering) {
        this.imagesOrdering = imagesOrdering;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
