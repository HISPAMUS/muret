package es.ua.dlsi.grfia.im3ws.muret.controller.payload.alignmentPreview;

public class AlignmentPreviewPitch extends AlignmentPreviewItemWithDuration {
    int midiPitch;

    public int getMidiPitch() {
        return midiPitch;
    }

    public void setMidiPitch(int midiPitch) {
        this.midiPitch = midiPitch;
    }
}
