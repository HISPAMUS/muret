package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.im3.core.score.NotationType;

import java.util.List;

public class AgnosticEncodingJSON {
    private NotationType notationType;
    private List<AgnosticSymbolTypeAndPosition> agnosticSymbols;

    public AgnosticEncodingJSON() {
    }

    public NotationType getNotationType() {
        return notationType;
    }

    public void setNotationType(NotationType notationType) {
        this.notationType = notationType;
    }

    public List<AgnosticSymbolTypeAndPosition> getAgnosticSymbols() {
        return agnosticSymbols;
    }

    public void setAgnosticSymbols(List<AgnosticSymbolTypeAndPosition> agnosticSymbols) {
        this.agnosticSymbols = agnosticSymbols;
    }

    @Override
    public String toString() {
        return notationType + "->" + agnosticSymbols;
    }
}
