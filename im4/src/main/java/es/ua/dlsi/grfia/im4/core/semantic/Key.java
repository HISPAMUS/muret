package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;

import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Key extends SemanticItem implements Comparable<Key> {
    /**
     * Key associated to a number of sharps in the instrumentKey signature G, D, A, E, B,
     * F#, C#
     */
    private static final int KEY_SIGNATURE_SHARPS[] = { 7, 2, 9, 4, 11, 6, 1 };
    /**
     * Order of sharp alterations F, C, G, D, A, E, B
     */
    public static final DiatonicPitch KEY_SIGNATURE_STAFF_SHARPS[] = { DiatonicPitch.F, DiatonicPitch.C, DiatonicPitch.G, DiatonicPitch.D,
            DiatonicPitch.A, DiatonicPitch.E, DiatonicPitch.B };
    /**
     * Key associated to a number of flats in the instrumentKey signature F, Bb, Eb, Ab,
     * Db, Gb, Cb
     */
    private static final int KEY_SIGNATURE_FLATS[] = { 5, 10, 3, 8, 1, 6, 11 };
    /**
     * Order of sharp alterations B, E, A, D, G, C, F
     */
    public static final DiatonicPitch KEY_SIGNATURE_STAFF_FLATS[] = { DiatonicPitch.B, DiatonicPitch.E, DiatonicPitch.A, DiatonicPitch.D,
            DiatonicPitch.G, DiatonicPitch.C, DiatonicPitch.F }; // the inverse of
    // KEY_SIGNATURE_STAFF_SHARPS
    /**
     * Pitch class
     */
    PitchClass pitchClass;
    /**
     * Mode: major, minor or uknown
     */
    Mode mode;
    /**
     * number of alterations (positive for sharp or negative for flat)
     */
    Integer fifths;

    /**
     * Used for convenience in GUI
     */
    public Key() {
    }

    public Key(PitchClass pc, Mode mode) throws IM4Exception {
        this.pitchClass = pc;
        this.mode = mode;
        computeFifths();
    }

    public Key(PitchClasses pc, Mode mode) throws IM4Exception {
        this.pitchClass = pc.getPitchClass();
        this.mode = mode;
        computeFifths();
    }

    // TODO Javi Test de todo esto
    /**
     * @param ififths
     *            Number of fifths: positive for sharps, negative for flats
     * @param cmode
     * @throws IM4Exception
     */
    public Key(int ififths, String cmode) throws IM4Exception {
        this(ififths, Mode.stringToMode(cmode));
    }

    public static final PitchClass[] OCTAVE_SHARPS = { PitchClasses.C.getPitchClass(),
            PitchClasses.C_SHARP.getPitchClass(), PitchClasses.D.getPitchClass(), PitchClasses.D_SHARP.getPitchClass(),
            PitchClasses.E.getPitchClass(), PitchClasses.F.getPitchClass(), PitchClasses.F_SHARP.getPitchClass(),
            PitchClasses.G.getPitchClass(), PitchClasses.G_SHARP.getPitchClass(), PitchClasses.A.getPitchClass(),
            PitchClasses.A_SHARP.getPitchClass(), PitchClasses.B.getPitchClass() };

    public static final PitchClass[] OCTAVE_FLATS = { PitchClasses.C.getPitchClass(),
            PitchClasses.D_FLAT.getPitchClass(), PitchClasses.D.getPitchClass(), PitchClasses.E_FLAT.getPitchClass(),
            PitchClasses.E.getPitchClass(), PitchClasses.F.getPitchClass(), PitchClasses.G_FLAT.getPitchClass(),
            PitchClasses.G.getPitchClass(), PitchClasses.A_FLAT.getPitchClass(), PitchClasses.A.getPitchClass(),
            PitchClasses.B_FLAT.getPitchClass(), PitchClasses.B.getPitchClass() };

    /**
     *
     * @param ififths negative for flats, positive for sharps
     * @param mode
     * @throws IM4Exception
     */
    public Key(int ififths, Mode mode) throws IM4Exception {
        init(ififths, mode);
    }

    private void init(int ififths, Mode mode) throws IM4Exception {
        if (ififths > 7 || ififths < -7) {
            throw new IM4Exception("Invalid number of flats/sharps in instrumentKey signature: " + ififths);
        }
        int result;
        if (ififths == 0) {
            result = 0;
        } else if (ififths > 0) { // sharps
            result = KEY_SIGNATURE_SHARPS[ififths - 1];
        } else { // <0, flats
            result = KEY_SIGNATURE_FLATS[-ififths - 1];
        }

        this.mode = mode;
        if (mode.equals(Mode.MINOR)) {
            result = (result - 3 + 12) % 12;
        }
        if (ififths > 0) {
            this.pitchClass = OCTAVE_SHARPS[result];
        } else {
            this.pitchClass = OCTAVE_FLATS[result];
        }

        this.fifths = ififths;
    }

    /**
     *
     * @param fifths ififths negative for flats, positive for sharps
     * @param pc
     * @param mode
     */
    public Key(int fifths, PitchClasses pc, Mode mode) {
        this.pitchClass = pc.getPitchClass();
        this.mode = mode;
        this.fifths = fifths;
    }

    public Key(Accidentals accidentals, int number, Mode mode) throws IM4Exception {
        switch (accidentals) {
            case FLAT:
                init(-number, mode);
                break;
            case SHARP:
                init(number, mode);
                break;
            default:
                throw new IM4Exception("Invalid accidental for key signature creation: " + accidentals);
        }
    }

    /**
     * @return the mode
     */
    public final Mode getMode() {
        return mode;
    }

    public final boolean hasMode() {
        return mode != Mode.UNKNOWN;
    }

    /**
     * * It does not take into account the time
     *
     * @param o
     */
    @Override
    public int compareTo(Key o) {
        int diff = this.pitchClass.compareTo(o.pitchClass);
        if (diff == 0) {
            return mode.compareTo(o.mode);
        } else {
            return diff;
        }
    }
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        if (pitchClass == null) {
            return "";
        } else {
            return pitchClass + "" + mode.getName();
        }
    }

    /**
     * Get the degree of the pitch class in the tonality
     *
     * @param note
     * @return 1..7
     * @throws IM4Exception
     */
    public int computeDegree(PitchClass note) throws IM4Exception {
        Interval interval = Interval.compute(this.pitchClass, note, MotionDirection.ASCENDING);
        if (interval.getName() == 8) {
            interval.setName(1);
        }
        int degree = (note.getNoteName().getOrder() + 7 - this.pitchClass.getNoteName().getOrder()) % 7;
        if (degree < 0 || degree >= 7) {
            throw new IM4Exception("Invalid computed degree: " + degree);
        }

        return degree + 1;
    }

    /**
     * It returns the 0..11 position of the note starting from the tonic
     *
     * @param pc
     * @return
     */
    public int computeSemitonesFromKey(PitchClass pc) {
        return computeSemitonesFromTonic(pc.getSemitonesFromC());
        // return ((pc.getSemitonesFromC() + 12) -
        // pitchClass.getSemitonesFromC()) % 12;
    }

    /**
     * It returns the 0..11 position of the note starting from the tonic
     *
     * @param semitonesFromC
     * @return
     */
    public int computeSemitonesFromTonic(int semitonesFromC) {
        return ((semitonesFromC + 12) - pitchClass.getSemitonesFromC()) % 12;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mode == null) ? 0 : mode.hashCode());
        result = prime * result + ((pitchClass == null) ? 0 : pitchClass.hashCode());
        return result;
    }
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Key other = (Key) obj;
        if (mode != other.mode) {
            return false;
        }
        if (pitchClass == null) {
            if (other.pitchClass != null) {
                return false;
            }
        } else if (!pitchClass.equals(other.pitchClass)) {
            return false;
        }
        return true;
    }

    public PitchClass getPitchClass() {
        return this.pitchClass;
    }

    /**
     * Package visibility for junit
     *
     * @return
     * @throws IM4Exception
     */
    void computeFifths() throws IM4Exception {
        /*
         * int majorkeyNote; if (mode == Mode.MINOR) { majorkeyNote =
         * (this.pitchClass.getSemitonesFromC() + 3) % 12; } else { majorkeyNote
         * = this.pitchClass.getSemitonesFromC(); } if (majorkeyNote == 0) {
         * return 0; } else { int sharps = -1; for (int i = 0; sharps == -1 && i
         * < KEY_SIGNATURE_SHARPS.length; i++) { if (majorkeyNote ==
         * KEY_SIGNATURE_SHARPS[i]) { sharps = i; } } int flats = -1; for (int i
         * = 0; flats == -1 && i < KEY_SIGNATURE_FLATS.length; i++) { if
         * (majorkeyNote == KEY_SIGNATURE_FLATS[i]) { flats = i; } } if (sharps
         * == -1 && flats == -1) { throw new IM4Exception(
         * "Cannot find the correct number of fifths for export the instrumentKey " +
         * this.toString()); } if ((sharps == -1 || sharps > flats) && flats !=
         * -1) { return -flats - 1; } else { return sharps + 1; } }
         */

        Mode _mode;
        if (mode.equals(Mode.UNKNOWN)) {
            _mode = Mode.MAJOR;
            Logger.getLogger(Key.class.getName()).log(Level.INFO, "Mode is unknown, using Major for computing fifths");
        } else {
            _mode = mode;
        }

        for (KeysEnum k : KeysEnum.values()) {
            if (k.getKey().getMode().equals(_mode)
                    && k.getKey().getPitchClass().equals(this.getPitchClass())) {
                this.fifths = k.getKey().getFifths();
                break;
            }
        }
        if (this.fifths == null) {
            throw new IM4Exception("Cannot find fifths for key " + this.toString());
        }
    }

    /**
     * Get the number of alterations (positive for sharp or negative for flat)
     *
     * @return
     */
    public int getFifths() throws IM4Exception {
        if (fifths == null) {
            computeFifths();
        }
        return fifths;
    }


	 /**  @param tonality
	 * @return null if not a instrumentKey
	 * @throws IM4Exception
	 */
    public static Key parseString(String tonality) {
        try {
            return getKeyFromName(tonality);
        } catch (Throwable t) {
            return null;
        }
    }

    /**
     *
     * @param tonality
     * @return Always a key or throws an exception
     * @throws IM4Exception
     */
    // TODO podríamos hacer una pequeña gramática
    public static Key getKeyFromName(String tonality) throws IM4Exception {
        String noteNameStr = tonality.substring(0, 1);
        DiatonicPitch noteName = DiatonicPitch.valueOf(noteNameStr.toUpperCase());
        Mode mode;
        if (noteNameStr.toLowerCase().equals(noteNameStr)) { // it is lowercase
            mode = Mode.MINOR;
        } else {
            mode = Mode.MAJOR;
        }
        int pos = 1;
        Accidentals acc = Accidentals.NATURAL;
        if (pos < tonality.length()) {
            String s2 = tonality.substring(pos, pos + 1);
            if (s2.equals("b")) {
                acc = Accidentals.FLAT;
                pos++;
            } else if (s2.equals("#")) {
                acc = Accidentals.SHARP;
                pos++;
            }
        }
        if (pos < tonality.length()) {
            String s2or3 = tonality.substring(pos, pos + 1);
            if (s2or3.equals("M")) {
                mode = Mode.MAJOR;
            } else if (s2or3.equals("m")) {
                mode = Mode.MINOR;
            }
        }
        return new Key(new PitchClass(noteName, acc), mode);
    }

    public String getAbbreviationString() {
        StringBuilder ksb = new StringBuilder();
        ksb.append(pitchClass.getNoteName().name());
        if (pitchClass.getAccidental() != null && pitchClass.getAccidental() != Accidentals.NATURAL) {
            ksb.append(pitchClass.getAccidental().getAbbrName());
        }
        if (mode != Mode.UNKNOWN) {
            ksb.append(mode.getNameChar());
        }
        return ksb.toString();
    }


    /**
     * Given the degree, it returns the note belonging to the major or minor
     * scale
     *
     * @param degree
     * @return
     * @throws IM4Exception
     */
    public PitchClass computeRoot(Degree degree) throws IM4Exception {
        IntervalMode imode;
        if (degree.ordinal() == 1 || degree.ordinal() == 4 || degree.ordinal() == 5) {
            imode = IntervalMode.PERFECT;
        } else if ((mode.equals(Mode.MINOR))
                && (degree.equals(Degree.III) || degree.equals(Degree.VI) || degree.equals(Degree.VII))) {
            imode = IntervalMode.MINOR;
        } else {
            imode = IntervalMode.MAJOR;
        }

        Interval i = new Interval(degree.ordinal(), imode, MotionDirection.ASCENDING);
        return i.computePitchClassFrom(this.pitchClass);
    }

    public Key computeRelativeMinor() throws IM4Exception {
        if (this.mode != Mode.MAJOR) {
            throw new IM4Exception("This is not a major instrumentKey");
        }

        Interval interval = Intervals.THIRD_MINOR_DESC.createInterval();
        PitchClass dest = interval.computePitchClassFrom(this.pitchClass);
        return new Key(dest, Mode.MINOR);
    }

    public Key computeRelativeMajor() throws IM4Exception {
        if (this.mode != Mode.MINOR) {
            throw new IM4Exception("This is not a minor instrumentKey");
        }

        Interval interval = Intervals.THIRD_MINOR_ASC.createInterval();
        PitchClass dest = interval.computePitchClassFrom(this.pitchClass);
        return new Key(dest, Mode.MAJOR);
    }

    /**
     *
     * @return Sharp or flat or none
     */
    public Accidentals getAccidental() {
        if (this.fifths > 0) {
            return Accidentals.SHARP;
        } else if (this.fifths < 0) {
            return Accidentals.FLAT;
        } else {
            // return Accidentals.NONE;
            return Accidentals.NATURAL;
        }
    }

    /**
     * @return e.g. B, E or F, C etc... Empty array (not null) if none
     */
    public DiatonicPitch[] getAlteredNoteNames() {
        if (this.fifths > 0) {
            DiatonicPitch[] result = new DiatonicPitch[this.fifths];
            System.arraycopy(KEY_SIGNATURE_STAFF_SHARPS, 0, result, 0, this.fifths);
            return result;
        } else if (this.fifths < 0) {
            DiatonicPitch[] result = new DiatonicPitch[-this.fifths];
            System.arraycopy(KEY_SIGNATURE_STAFF_FLATS, 0, result, 0, -this.fifths);
            return result;
        } else {
            return new DiatonicPitch[] {};
        }
    }

    public TreeMap<DiatonicPitch, PitchClass> getAlteredNoteNamesSet() {
        DiatonicPitch[] nn = getAlteredNoteNames();
        TreeMap<DiatonicPitch, PitchClass> ts = new TreeMap<>();
        Accidentals acc = getAccidental();
        for (DiatonicPitch nn1 : nn) {
            ts.put(nn1, new PitchClass(nn1, acc));
        }
        return ts;

    }

    /**
     * It returns the accidental given a note name for this instrumentKey
     *
     * @param noteName
     * @return
     */
    public Accidentals getNoteNameKeySignatureAccidental(DiatonicPitch noteName) {
        if (this.fifths > 0) {
            for (int i = 0; i < this.fifths; i++) {
                if (KEY_SIGNATURE_STAFF_SHARPS[i].equals(noteName)) {
                    return Accidentals.SHARP;
                }
            }
            return Accidentals.NATURAL;
        } else if (this.fifths < 0) {
            for (int i = 0; i < -this.fifths; i++) {
                if (KEY_SIGNATURE_STAFF_FLATS[i].equals(noteName)) {
                    return Accidentals.FLAT;
                }
            }
            return Accidentals.NATURAL;
        } else {
            return Accidentals.NATURAL;
        }
    }

    @Override
    public Key clone() {
        try {
            return new Key(pitchClass, mode);
        } catch (IM4Exception ex) {
            Logger.getLogger(Key.class.getName()).log(Level.SEVERE, null, ex);
            throw new IM4RuntimeException(ex);
        }
    }

    public boolean isEmpty() {
        return this.pitchClass == null;
    }
}
