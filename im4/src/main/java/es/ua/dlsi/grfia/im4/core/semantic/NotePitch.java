package es.ua.dlsi.grfia.im4.core.semantic;

import javax.rmi.CORBA.Tie;

public class NotePitch {
    /**
     * Optional accidental qualifier
     */
    private final AccidentalQualifier accidentalQualifier;

    private final ScientificPitch scientificPitch;

    TieType tie;

    public NotePitch(AccidentalQualifier accidentalQualifier, ScientificPitch scientificPitch) {
        this.accidentalQualifier = accidentalQualifier;
        this.scientificPitch = scientificPitch;
    }

    public NotePitch(ScientificPitch scientificPitch) {
        this.scientificPitch = scientificPitch;
        this.accidentalQualifier = null;
    }

    public AccidentalQualifier getAccidentalQualifier() {
        return accidentalQualifier;
    }

    public ScientificPitch getScientificPitch() {
        return scientificPitch;
    }

    public TieType getTie() {
        return tie;
    }

    public void setTie(TieType tie) {
        this.tie = tie;
    }
}
