package es.ua.dlsi.grfia.im4.core.semantic;

public class Custos extends SemanticItem {
    final DiatonicPitch diatonicPitch;
    final int octave;

    public Custos(DiatonicPitch diatonicPitch, int octave) {
        super("*custos" + diatonicPitch.getSkmEncoding());
        this.diatonicPitch = diatonicPitch;
        this.octave = octave;
    }

    public DiatonicPitch getDiatonicPitch() {
        return diatonicPitch;
    }

    public int getOctave() {
        return octave;
    }

    @Override
    public Custos clone() {
        return new Custos(diatonicPitch, octave);
    }
}
