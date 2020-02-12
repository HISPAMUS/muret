package es.ua.dlsi.grfia.im3ws.muret.controller.payload.alignmentPreview;

import java.util.ArrayList;
import java.util.List;

public class AlignmentPreviewPart {
    long id;
    String name;
    List<AlignmentPreviewStaff> staves;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AlignmentPreviewStaff> getStaves() {
        return staves;
    }

    public void setStaves(List<AlignmentPreviewStaff> staves) {
        this.staves = staves;
    }

    public void add(AlignmentPreviewStaff alignmentPreviewStaff) {
        if (staves == null) {
            staves = new ArrayList<>();
        }
        staves.add(alignmentPreviewStaff);
    }
}
