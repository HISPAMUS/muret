package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;

/**
 * @author drizo
 * @date 10/06/2011
 *
 */
public enum Intervals {
	// short names from http://en.wikipedia.org/wiki/Interval_(music)
    // for the base 40 encoding, see http://wiki.ccarh.org/wiki/Base_40

    UNISON_PERFECT(1, IntervalMode.PERFECT, MotionDirection.EQUAL, 0, "P1", 0),
    UNISON_AUGMENTED_ASC(1, IntervalMode.AUGMENTED, MotionDirection.ASCENDING, 1, "A1", 1),
    UNISON_AUGMENTED_DESC(1, IntervalMode.AUGMENTED, MotionDirection.DESCENDING, -1, "-A1", -1),
    UNISON_DOUBLE_AUGMENTED_ASC(1, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.ASCENDING, 2, "AA1", 2),
    UNISON_DOUBLE_AUGMENTED_DESC(1, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.DESCENDING, -2, "-AA1", -2),
    UNISON_DIMINISHED_ASC(1, IntervalMode.DIMINISHED, MotionDirection.ASCENDING, -1, "d1", -1),
    UNISON_DIMINISHED_DESC(1, IntervalMode.DIMINISHED, MotionDirection.DESCENDING, 1, "-d1", 1),
    UNISON_DOUBLE_DIMINISHED_ASC(1, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.ASCENDING, -2, "dd1", -2),
    UNISON_DOUBLE_DIMINISHED_DESC(1, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.DESCENDING, 2, "-dd1", 2),
    //UNISON_TRIPLE_AUGMENTED_ASC (1, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.ASCENDING, 3, "TA1"),
    //UNISON_TRIPLE_AUGMENTED_DESC (1, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.DESCENDING, -3, "-TA1"),

    SECOND_MINOR_ASC(2, IntervalMode.MINOR, MotionDirection.ASCENDING, 1, "m2", 5),
    SECOND_MINOR_DESC(2, IntervalMode.MINOR, MotionDirection.DESCENDING, -1, "-m2", -5),
    SECOND_MAJOR_ASC(2, IntervalMode.MAJOR, MotionDirection.ASCENDING, 2, "M2", 6),
    SECOND_MAJOR_DESC(2, IntervalMode.MAJOR, MotionDirection.DESCENDING, -2, "-M2", -6),
    SECOND_AUGMENTED_ASC(2, IntervalMode.AUGMENTED, MotionDirection.ASCENDING, 3, "A2", 7),
    SECOND_AUGMENTED_DESC(2, IntervalMode.AUGMENTED, MotionDirection.DESCENDING, -3, "-A2", -7),
    SECOND_DIMINISHED_ASC(2, IntervalMode.DIMINISHED, MotionDirection.ASCENDING, 0, "d2", 4),
    SECOND_DIMINISHED_DESC(2, IntervalMode.DIMINISHED, MotionDirection.DESCENDING, 0, "-d2", -4),
    SECOND_DOUBLE_AUGMENTED_ASC(2, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.ASCENDING, 4, "AA2", 8),
    SECOND_DOUBLE_AUGMENTED_DESC(2, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.DESCENDING, -4, "-AA2", -8),
    SECOND_DOUBLE_DIMINISHED_ASC(2, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.ASCENDING, -1, "dd2", 3),
    SECOND_DOUBLE_DIMINISHED_DESC(2, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.DESCENDING, 1, "-dd2", -3),
    THIRD_DOUBLE_DIMINISHED_ASC(3, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.ASCENDING, 1, "dd3", 9),
    THIRD_DOUBLE_DIMINISHED_DESC(3, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.DESCENDING, -1, "-dd3", -9),
    THIRD_DIMINISHED_ASC(3, IntervalMode.DIMINISHED, MotionDirection.ASCENDING, 2, "d3", 10),
    THIRD_DIMINISHED_DESC(3, IntervalMode.DIMINISHED, MotionDirection.DESCENDING, -2, "-d3", -10),
    THIRD_MINOR_ASC(3, IntervalMode.MINOR, MotionDirection.ASCENDING, 3, "m3", 11),
    THIRD_MINOR_DESC(3, IntervalMode.MINOR, MotionDirection.DESCENDING, -3, "-m3", -11),
    THIRD_MAJOR_ASC(3, IntervalMode.MAJOR, MotionDirection.ASCENDING, 4, "M3", 12),
    THIRD_MAJOR_DESC(3, IntervalMode.MAJOR, MotionDirection.DESCENDING, -4, "-M3", -12),
    THIRD_AUGMENTED_ASC(3, IntervalMode.AUGMENTED, MotionDirection.ASCENDING, 5, "A3", 13),
    THIRD_AUGMENTED_DESC(3, IntervalMode.AUGMENTED, MotionDirection.DESCENDING, -5, "-A3", -13),
    THIRD_DOUBLE_AUGMENTED_ASC(3, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.ASCENDING, 6, "AA3", 14),
    THIRD_DOUBLE_AUGMENTED_DESC(3, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.DESCENDING, -6, "-AA3", -14),
    FOURTH_DOUBLE_DIMINISHED_ASC(4, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.ASCENDING, 3, "dd4", 15),
    FOURTH_DOUBLE_DIMINISHED_DESC(4, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.DESCENDING, -3, "-dd4", -15),
    FOURTH_DIMINISHED_ASC(4, IntervalMode.DIMINISHED, MotionDirection.ASCENDING, 4, "d4", 16),
    FOURTH_DIMINISHED_DESC(4, IntervalMode.DIMINISHED, MotionDirection.DESCENDING, -4, "-d4", -16),
    FOURTH_PERFECT_ASC(4, IntervalMode.PERFECT, MotionDirection.ASCENDING, 5, "P4", 17),
    FOURTH_PERFECT_DESC(4, IntervalMode.PERFECT, MotionDirection.DESCENDING, -5, "-P4", -17),
    FOURTH_AUGMENTED_ASC(4, IntervalMode.AUGMENTED, MotionDirection.ASCENDING, 6, "A4", 18),
    FOURTH_AUGMENTED_DESC(4, IntervalMode.AUGMENTED, MotionDirection.DESCENDING, -6, "-A4", -18),
    FOURTH_DOUBLE_AUGMENTED_ASC(4, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.ASCENDING, 7, "AA4", 19),
    FOURTH_DOUBLE_AUGMENTED_DESC(4, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.DESCENDING, -7, "-AA4", -19),
    // F flat to Cbb (not used in http://wiki.ccarh.org/wiki/Base_40
    FOURTH_TRIPLE_AUGMENTED_ASC(4, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.ASCENDING, 8, "AAA4", 20),
    FOURTH_TRIPLE_AUGMENTED_DESC(4, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.DESCENDING, -8, "-AAA4", -20),
    /// end of comment
    FIFTH_DOUBLE_DIMINISHED_ASC(5, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.ASCENDING, 5, "d5", 21),
    FIFTH_DOUBLE_DIMINISHED_DESC(5, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.DESCENDING, -5, "-d5", -21),
    FIFTH_DIMINISHED_ASC(5, IntervalMode.DIMINISHED, MotionDirection.ASCENDING, 6, "d5", 22),
    FIFTH_DIMINISHED_DESC(5, IntervalMode.DIMINISHED, MotionDirection.DESCENDING, -6, "-d5", -22),
    FIFTH_PERFECT_ASC(5, IntervalMode.PERFECT, MotionDirection.ASCENDING, 7, "P5", 23),
    FIFTH_PERFECT_DESC(5, IntervalMode.PERFECT, MotionDirection.DESCENDING, -7, "-P5", -23),
    FIFTH_AUGMENTED_ASC(5, IntervalMode.AUGMENTED, MotionDirection.ASCENDING, 8, "A5", 24),
    FIFTH_AUGMENTED_DESC(5, IntervalMode.AUGMENTED, MotionDirection.DESCENDING, -8, "-A5", -24),
    FIFTH_DOUBLE_AUGMENTED_ASC(5, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.ASCENDING, 9, "AA5", 25),
    FIFTH_DOUBLE_AUGMENTED_DESC(5, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.DESCENDING, -9, "-AA5", -25),
    SIXTH_DOUBLE_DIMINISHED_ASC(6, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.ASCENDING, 6, "dd6", 26),
    SIXTH_DOUBLE_DIMINISHED_DESC(6, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.DESCENDING, -6, "-dd6", -26),
    SIXTH_DIMINISHED_ASC(6, IntervalMode.DIMINISHED, MotionDirection.ASCENDING, 7, "d6", 27),
    SIXTH_DIMINISHED_DESC(6, IntervalMode.DIMINISHED, MotionDirection.DESCENDING, -7, "-d6", -27),
    SIXTH_MINOR_ASC(6, IntervalMode.MINOR, MotionDirection.ASCENDING, 8, "m6", 28),
    SIXTH_MINOR_DESC(6, IntervalMode.MINOR, MotionDirection.DESCENDING, -8, "-m6", -28),
    SIXTH_MAJOR_ASC(6, IntervalMode.MAJOR, MotionDirection.ASCENDING, 9, "M6", 29),
    SIXTH_MAJOR_DESC(6, IntervalMode.MAJOR, MotionDirection.DESCENDING, -9, "-M6", -29),
    SIXTH_AUGMENTED_ASC(6, IntervalMode.AUGMENTED, MotionDirection.ASCENDING, 10, "A6", 30),
    SIXTH_AUGMENTED_DESC(6, IntervalMode.AUGMENTED, MotionDirection.DESCENDING, -10, "-A6", -30),
    SIXTH_DOUBLE_AUGMENTED_ASC(6, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.ASCENDING, 11, "AA6", 31),
    SIXTH_DOUBLE_AUGMENTED_DESC(6, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.DESCENDING, -11, "-AA6", -31),
    SEVENTH_DOUBLE_DIMINISHED_ASC(7, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.ASCENDING, 8, "dd7", 32),
    SEVENTH_DOUBLE_DIMINISHED_DESC(7, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.DESCENDING, -8, "-dd7", -32),
    SEVENTH_DIMINISHED_ASC(7, IntervalMode.DIMINISHED, MotionDirection.ASCENDING, 9, "d7", 33),
    SEVENTH_DIMINISHED_DESC(7, IntervalMode.DIMINISHED, MotionDirection.DESCENDING, -9, "-d7", -33),
    SEVENTH_MINOR_ASC(7, IntervalMode.MINOR, MotionDirection.ASCENDING, 10, "m7", 34),
    SEVENTH_MINOR_DESC(7, IntervalMode.MINOR, MotionDirection.DESCENDING, -10, "-m7", -34),
    SEVENTH_MAJOR_ASC(7, IntervalMode.MAJOR, MotionDirection.ASCENDING, 11, "M7", 35),
    SEVENTH_MAJOR_DESC(7, IntervalMode.MAJOR, MotionDirection.DESCENDING, -11, "-M7", -35),
    SEVENTH_AUGMENTED_ASC(7, IntervalMode.AUGMENTED, MotionDirection.ASCENDING, 12, "A7", 36),
    SEVENTH_AUGMENTED_DESC(7, IntervalMode.AUGMENTED, MotionDirection.DESCENDING, -12, "-A7", -36),
    SEVENTH_DOUBLE_AUGMENTED_ASC(7, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.ASCENDING, 13, "AA7", 37),
    SEVENTH_DOUBLE_AUGMENTED_DESC(7, IntervalMode.DOUBLE_AUGMENTED, MotionDirection.DESCENDING, -13, "-AA7", -37);/*,
	
     OCTAVE_PERFECT_ASC(8, IntervalMode.PERFECT, MotionDirection.ASCENDING, 12, "P8", 40),
     OCTAVE_PERFECT_DESC(8, IntervalMode.PERFECT, MotionDirection.DESCENDING, -12, "-P8", -40),

     // not in ccarh
     OCTAVE_DOUBLE_DIMINISHED_ASC(8, IntervalMode.PERFECT, MotionDirection.ASCENDING, 11, "d8", 40),
     OCTAVE_PERFECT_DESC(8, IntervalMode.PERFECT, MotionDirection.DESCENDING, -12, "-P8", -40);*/


	// this group is here only to make things coherent...
	/*SECOND_DOUBLE_DIMINISHED_ASC (2, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.ASCENDING, -1, "d2"),
     SECOND_DOUBLE_DIMINISHED_DESC (2, IntervalMode.DOUBLE_DIMINISHED, MotionDirection.DESCENDING, 1, "-d2"),	
     SECOND_DIMINISHED_ASC (2, IntervalMode.DIMINISHED, MotionDirection.ASCENDING, 0, "d2"),
     SECOND_DIMINISHED_DESC (2, IntervalMode.DIMINISHED, MotionDirection.DESCENDING, 0, "-d2"),
     SECOND_TRIPLE_AUGMENTED_ASC (2, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.ASCENDING, 5, "TA2"),
     SECOND_TRIPLE_AUGMENTED_DESC (2, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.DESCENDING, -5, "-TA2"),
     THIRD_TRIPLE_AUGMENTED_ASC (3, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.ASCENDING, 7, "TA3"),
     THIRD_TRIPLE_AUGMENTED_DESC (3, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.DESCENDING, -7, "-TA3"),
     FIFTH_TRIPLE_AUGMENTED_ASC (5, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.ASCENDING, 10, "TA5"),
     FIFTH_TRIPLE_AUGMENTED_DESC (5, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.DESCENDING, -10, "-TA5"),
     SIXTH_TRIPLE_AUGMENTED_ASC (6, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.ASCENDING, 12, "TA6"),
     SIXTH_TRIPLE_AUGMENTED_DESC (6, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.DESCENDING, -12, "-TA6"),
     SEVENTH_TRIPLE_AUGMENTED_ASC (7, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.ASCENDING, 14, "TA7"),
     SEVENTH_TRIPLE_AUGMENTED_DESC (7, IntervalMode.TRIPLE_AUGMENTED, MotionDirection.DESCENDING, -14, "-TA7");*/
    private final int name;
    private final IntervalMode mode;
    private final MotionDirection direction;
    private final int semitones;
    private final int base40Difference;
    private final String shortName;

    Intervals(int name, IntervalMode mode, MotionDirection direction, int semitones, String shortName, int base40Difference) {
	this.name = name;
	this.mode = mode;
	this.direction = direction;
	this.semitones = semitones;
	this.base40Difference = base40Difference;
	this.shortName = shortName;
	//interval.setShortName(shortName);
    }

    /**
     * @return the interval
     */
    public final Interval createInterval() {
	Interval itv = new Interval(name, mode, direction, semitones, base40Difference);
	return itv;
    }

    /**
     *
     * @param name 1st, 2nd, ...
     * @param semitones (absolute tempo)
     * @param direction
     * @return
     * @throws IM4Exception
     */
    public static Interval getInterval(int name, int semitones, MotionDirection direction) throws IM4Exception {
	//System.out.println("-------");
	int abss = Math.abs(semitones);
	for (Intervals itv : Intervals.values()) {
	    //Interval itt = itv.createInterval();
	    //System.out.println(itt.toString() + " - " + itt.getSemitones());
	    if (itv.name == name && Math.abs(itv.semitones) == abss && itv.direction == direction) {
		return itv.createInterval();
	    }
	}
	throw new IM4Exception("No interval found for an interval '" + name + "' and " + semitones + " semitones and direction " + direction);
    }

    public static Interval getIntervalFromSemitones(int semitones, IntervalMode mode, MotionDirection direction) throws IM4Exception {
	//System.out.println("-------");
	for (Intervals itv : Intervals.values()) {
	    //Interval itt = itv.createInterval();
	    //System.out.println(itt.toString() + " - " + itt.getSemitones());
	    if (itv.getMode() == mode && itv.semitones == semitones && itv.direction == direction) {
		return itv.createInterval();
	    }
	}
	throw new IM4Exception("No interval found for " + semitones + " semitones and direction " + direction + " and mode " + mode);
    }

    // TODO Test this method!!!
    /**
     * Gets diatonic or flatted intervals, i.e., given the number of semitones:
     * 0:unison, 1:2m, 2:2M, 3:3m, 4:3M, 5:4P, 6:5dim, 7:5P, 8:6m, 9:6M, 10:7m, 11:7M
     * @param semitones
     * @param direction
     * @return
     * @throws IM4Exception
     */
    public static Interval getFlatIntervalFromSemitones(int semitones, MotionDirection direction) throws IM4Exception {
	//System.out.println("-------");
	for (Intervals itv : Intervals.values()) {
	    //Interval itt = itv.createInterval();
	    //System.out.println(itt.toString() + " - " + itt.getSemitones());
	    if (itv.semitones == semitones && itv.direction == direction) {
	    	IntervalMode m = itv.getMode();
	    	if (semitones==4 && m==IntervalMode.MAJOR)
	    		return itv.createInterval();
	    	if (m==IntervalMode.PERFECT || m==IntervalMode.MAJOR || m==IntervalMode.MINOR)
	    		return itv.createInterval();
	    }
	}
	throw new IM4Exception("No interval found for " + semitones + " semitones and direction " + direction);
    }
    
    /**
     *
     * @param semitonesWithSign negative for descending, positive for ascending
     * @return
     * @throws IM4Exception
     */
    public static Interval getMajorPerfectIntervalFromSemitones(int semitonesWithSign) throws IM4Exception {
	//System.out.println("-------");
	for (Intervals itv : Intervals.values()) {
		    //Interval itt = itv.createInterval();
	    //System.out.println(itt.toString() + " - " + itt.getSemitones());
	    if ((itv.getMode() == IntervalMode.MAJOR || itv.getMode() == IntervalMode.PERFECT) && itv.semitones == semitonesWithSign) {
		return itv.createInterval();
	    }
	}
	throw new IM4Exception("No major or perfect interval found for " + semitonesWithSign + " semitones");
    }

    public IntervalMode getMode() {
	return mode;
    }

    public MotionDirection getDirection() {
	return direction;
    }

    public int getSemitones() {
	return semitones;
    }

    public int getName() {
	return name;
    }

    public int getBase40Difference() {
	return base40Difference;
    }

    public String getShortName() {
        return shortName;
    }
}
