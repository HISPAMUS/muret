package es.ua.dlsi.grfia.im3ws.muret.model;

/**
 * Information required to render a staff
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/06/2020
 */
public class SemanticStaffContext {
    String clef;
    String keySignature;
    String meter;

    public SemanticStaffContext(String clef, String keySignature, String meter) {
        this.clef = clef;
        this.keySignature = keySignature;
        this.meter = meter;
    }

    public String getClef() {
        return clef;
    }

    public void setClef(String clef) {
        this.clef = clef;
    }

    public String getKeySignature() {
        return keySignature;
    }

    public void setKeySignature(String keySignature) {
        this.keySignature = keySignature;
    }

    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
        this.meter = meter;
    }
}
