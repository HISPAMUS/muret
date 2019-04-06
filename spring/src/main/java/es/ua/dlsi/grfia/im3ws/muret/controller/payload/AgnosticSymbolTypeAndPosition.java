package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class AgnosticSymbolTypeAndPosition {
    String positionInStaff;
    String agnosticSymbolType;

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

    @Override
    public String toString() {
        return "AgnosticSymbolTypeAndPosition{" +
                "positionInStaff='" + positionInStaff + '\'' +
                ", agnosticSymbolType='" + agnosticSymbolType + '\'' +
                '}';
    }
}
