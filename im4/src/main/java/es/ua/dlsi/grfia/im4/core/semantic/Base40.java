package es.ua.dlsi.grfia.im4.core.semantic;

public class Base40 {
    private int base40;
    int base40Chroma;

    public Base40(ScientificPitch sp) {
        base40Chroma = sp.getPitchClass().getBase40Chroma();
        base40 = sp.getOctave() * 40 + base40Chroma;
    }

    public int getBase40() {
        return base40;
    }

    public int getBase40Chroma() {
        return base40Chroma;
    }
}
