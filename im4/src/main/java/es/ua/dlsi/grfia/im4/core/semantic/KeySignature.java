package es.ua.dlsi.grfia.im4.core.semantic;

//TODO ¿cómo especificamos cosas como en mensural B- y b-?

import java.util.Arrays;
import java.util.List;

/**
 * It's not the key, it just contains the accidentals specification
 */
public class KeySignature extends SemanticItem {
    private final PitchClass [] pitchClasses;

    public KeySignature(List<PitchClass> pitchClasses) {
        super(null);
        this.pitchClasses = new PitchClass[pitchClasses.size()];
        for (int i=0; i<this.pitchClasses.length; i++) {
            this.pitchClasses[i] = pitchClasses.get(i).clone();
        }
        setSkmEncodingJustInConstructor(buildSkmEncoding());
    }

    protected String buildSkmEncoding() {
        StringBuilder stringBuilder = new StringBuilder("*k[");
        for (PitchClass pitchClass: pitchClasses) {
            stringBuilder.append(pitchClass.getNoteName().name().toLowerCase());
            if (pitchClass.getAccidental() != Accidentals.NATURAL) {
                stringBuilder.append(pitchClass.getAccidental().getSkmEncoding());
            } // else do not add anything
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override
    public SemanticItem clone() {
        return new KeySignature(Arrays.asList(pitchClasses));
    }
}
