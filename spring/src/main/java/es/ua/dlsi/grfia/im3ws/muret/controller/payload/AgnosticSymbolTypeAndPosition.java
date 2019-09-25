package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class AgnosticSymbolTypeAndPosition {
    String position;
    String shape;
    int start;
    int end;

    public AgnosticSymbolTypeAndPosition(String agnosticSymbolType, String positionInStaff) {
        this.position = positionInStaff;
        this.shape = agnosticSymbolType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return shape + ":" + position;
    }
}
