package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;

public class NotePitch {
    /**
     * Optional accidental qualifier
     */
    private final AccidentalQualifier accidentalQualifier;

    private final ScientificPitch scientificPitch;

    private final Tie tie;

    public NotePitch(ScientificPitch scientificPitch, AccidentalQualifier accidentalQualifier, Tie tie) {
        this.accidentalQualifier = accidentalQualifier;
        this.scientificPitch = scientificPitch;
        this.tie = tie;
    }

    public AccidentalQualifier getAccidentalQualifier() {
        return accidentalQualifier;
    }

    public ScientificPitch getScientificPitch() {
        return scientificPitch;
    }


    public String buildSkmEncoding() throws IM4Exception {
        StringBuilder sb = new StringBuilder();

        String middleOctaveNote = scientificPitch.getPitchClass().getNoteName().name().toLowerCase();

        if (scientificPitch.getOctave() < 4) {
            int characters = 4 - scientificPitch.getOctave();
            middleOctaveNote = middleOctaveNote.toUpperCase();
            for (int i=0; i<characters; i++) {
                sb.append(middleOctaveNote);
            }
        } else if (scientificPitch.getOctave() == 4) {
            sb.append(middleOctaveNote);
        } else {
            int characters = 1 + scientificPitch.getOctave() - 4;
            for (int i=0; i<characters; i++) {
                sb.append(middleOctaveNote);
            }
        }

        if (scientificPitch.getPitchClass().isAltered()) {
            if (scientificPitch.getPitchClass().getAccidental().equals(Accidentals.SHARP)) {
                sb.append('#');
            } else if (scientificPitch.getPitchClass().getAccidental().equals(Accidentals.FLAT)) {
                sb.append('-');
            } else {
                throw new IM4Exception("Unsupported accidental in key signature: " + scientificPitch.getPitchClass().getAccidental());
            }
        }

        if (this.accidentalQualifier != null) {
        }
        return sb.toString();
    }
}
