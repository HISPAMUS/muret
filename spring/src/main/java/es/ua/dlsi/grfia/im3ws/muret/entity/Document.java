package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import es.ua.dlsi.im3.core.score.NotationType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.List;

/**
 * The ordering has been moved from a fields "imagesOrdering" and "sectionOrdering" to an ordering field both in sectino
 * and images because being smaller the update and insertion, it is more convenient and faster in selecting, that is the
 * most used operation
 * @author drizo
 */
@Entity
public class Document extends Auditable implements IID<Integer>  {
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

    @Lob
    @Column (name = "thumbnail_base64_encoding", columnDefinition = "LONGTEXT")
    private String thumbnailBase64Encoding;

    @JsonManagedReference (value="document")
    //@OrderColumn(name = "ordering", nullable = false) -- these images are not guaranteed to be ordered
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "document")
    private List<Image> images;

    @JsonManagedReference (value="document")
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "document")
    // don't use because it requires non sparse values @OrderColumn(name = "ordering", nullable = false)
    private List<Part> parts;

    @JsonManagedReference (value="document")
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "document")
    // don't use because it requires non sparse values @OrderColumn(name = "ordering", nullable = false)
    private List<Section> sections;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="state_id")
    State state;

    @JsonBackReference (value="collection")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="collection_id", nullable = false)
    private Collection collection;


    public Document() {
    }

    public Document(String name, String path, String composer, Date creationDate, Date lastModifiedDate, User createdBy, User lastModifiedBy , String thumbnailBase64Encoding, String comments, NotationType notationType, ManuscriptType manuscriptType, State state, List<Image> images, List<Part> parts, Collection collection, List<Section> sections) {
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
        this.manuscriptType = manuscriptType;
        this.state = state;
        this.parts = parts;
        this.collection = collection;
        this.sections = sections;
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

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
