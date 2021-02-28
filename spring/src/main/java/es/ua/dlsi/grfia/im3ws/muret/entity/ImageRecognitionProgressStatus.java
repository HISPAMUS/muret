package es.ua.dlsi.grfia.im3ws.muret.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 28/2/21
 */
@Entity
public class ImageRecognitionProgressStatus extends Auditable implements IID<Long> {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonBackReference (value="image")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="image_id", nullable = false) // use this construct to let orphanRemoval to work well
    Image image;

    @JsonBackReference(value="imageRecognitionPhase")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="image_recognition_phase_id", nullable = false) // use this construct to let orphanRemoval to work well
    ImageRecognitionPhase imageRecognitionPhase;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private ProgressStatus status;

    @Override
    public Long getId() {
        return id;
    }

    public ImageRecognitionProgressStatus() {
    }

    public ImageRecognitionProgressStatus(Long id, Image image, ProgressStatus state) {
        this.id = id;
        this.image = image;
        this.status = state;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ProgressStatus getStatus() {
        return status;
    }

    public void setStatus(ProgressStatus state) {
        this.status = state;
    }

    public ImageRecognitionPhase getImageRecognitionPhase() {
        return imageRecognitionPhase;
    }

    public void setImageRecognitionPhase(ImageRecognitionPhase imageRecognitionPhase) {
        this.imageRecognitionPhase = imageRecognitionPhase;
    }
}
