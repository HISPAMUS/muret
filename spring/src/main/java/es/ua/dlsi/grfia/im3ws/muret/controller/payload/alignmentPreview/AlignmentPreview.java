package es.ua.dlsi.grfia.im3ws.muret.controller.payload.alignmentPreview;

import java.util.ArrayList;
import java.util.List;

public class AlignmentPreview {
    List<AlignmentPreviewPart> parts;
    List<AlignmentPreviewImage> images;
    AlignmentPreviewDissonanceMap dissonanceMap;
    List<AlignmentPreviewProblem> problems;

    public AlignmentPreview() {
        this.parts = new ArrayList<>();
        this.images = new ArrayList<>();
        this.dissonanceMap = new AlignmentPreviewDissonanceMap();
        this.problems = new ArrayList<>();
    }

    public List<AlignmentPreviewPart> getParts() {
        return parts;
    }

    public void setParts(List<AlignmentPreviewPart> parts) {
        this.parts = parts;
    }

    public AlignmentPreviewDissonanceMap getDissonanceMap() {
        return dissonanceMap;
    }

    public void setDissonanceMap(AlignmentPreviewDissonanceMap dissonanceMap) {
        this.dissonanceMap = dissonanceMap;
    }

    public List<AlignmentPreviewImage> getImages() {
        return images;
    }

    public void setImages(List<AlignmentPreviewImage> images) {
        this.images = images;
    }

    public List<AlignmentPreviewProblem> getProblems() {
        return problems;
    }

    public void setProblems(List<AlignmentPreviewProblem> problems) {
        this.problems = problems;
    }

    public void add(AlignmentPreviewPart alignmentPreviewPart) {
        parts.add(alignmentPreviewPart);
    }

    public void add(AlignmentPreviewImage alignmentPreviewImage) {
        images.add(alignmentPreviewImage);
    }


    public void add(AlignmentPreviewProblem alignmentPreviewProblem) {
        problems.add(alignmentPreviewProblem);
    }
}
