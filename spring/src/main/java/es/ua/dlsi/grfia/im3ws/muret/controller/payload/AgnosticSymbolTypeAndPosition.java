package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class AgnosticSymbolTypeAndPosition {
    String positionInStaff;
    String agnosticSymbolType;
    int start;
    int end;

    public AgnosticSymbolTypeAndPosition(String agnosticSymbolType, String positionInStaff) {
        this.positionInStaff = positionInStaff;
        this.agnosticSymbolType = agnosticSymbolType;
    }

    public String getPositionInStaff() {
        return positionInStaff;
    }

    public void setPositionInStaff(String positionInStaff) {
        this.positionInStaff = positionInStaff;
    }

    public String getAgnosticSymbolType() {
        return agnosticSymbolType;
    }

    public void setAgnosticSymbolType(String agnosticSymbolType) {
        this.agnosticSymbolType = agnosticSymbolType;
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
        return agnosticSymbolType + ":" + positionInStaff;
    }
}
