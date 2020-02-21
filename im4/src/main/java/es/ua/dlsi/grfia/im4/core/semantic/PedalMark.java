package es.ua.dlsi.grfia.im4.core.semantic;

public class PedalMark extends MarkItem {
    StartEnd startEnd;

    public PedalMark(StartEnd startEnd) {
        this.startEnd = startEnd;
    }

    public StartEnd getStartEnd() {
        return startEnd;
    }
}
