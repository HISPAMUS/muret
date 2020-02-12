package es.ua.dlsi.grfia.im3ws.muret.controller.payload.alignmentPreview;

import java.util.ArrayList;
import java.util.List;

public class AlignmentPreview {
    List<AlignmentPreviewPart> parts;
    List<AlignmentPreviewImage> images;
    AlignmentPreviewDissonanceMap dissonanceMap;
    List<AlignmentPreviewProblem> problems;

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
        if (parts == null) {
            parts = new ArrayList<>();
        }
        parts.add(alignmentPreviewPart);
    }

    public void add(AlignmentPreviewImage alignmentPreviewImage) {
        if (images == null) {
            images = new ArrayList<>();
        }
        images.add(alignmentPreviewImage);
    }


    public void add(AlignmentPreviewProblem alignmentPreviewProblem) {
        if (problems == null) {
            problems = new ArrayList<>();
        }
        problems.add(alignmentPreviewProblem);
    }
}
