package es.ua.dlsi.grfia.im4.core.semantic;
/**
 * used only to be able to easy compare intervals where not all values are fixed
@author drizo
@date 27/11/2011
 **/
public enum VagueInterval {
	UNISON (1, null, null),
	SECOND (2, null, null),
	SECOND_DESC (2, null, MotionDirection.DESCENDING),
	SECOND_ASC (2, null, MotionDirection.ASCENDING),
	THIRD (3, null, null),
	FOURTH (4, null, null),
	FIFTH (5, null, null),
	SIXTH (6, null, null),
	SEVENTH (7, null, null),
	;
	/**
	 * @see Interval
	 */
	int name;
	/**
	 * @see Interval
	 */
	IntervalMode mode;
	/**
	 * @see Interval
	 */
	MotionDirection direction;
	
	VagueInterval(int name, IntervalMode mode,
                  MotionDirection direction) {
		this.name = name;
		this.mode = mode;
		this.direction = direction;
	}

	/**
	 * @return the name
	 */
	public final int getName() {
		return name;
	}

	/**
	 * @return the mode
	 */
	public final IntervalMode getMode() {
		return mode;
	}

	/**
	 * @return the direction
	 */
	public final MotionDirection getDirection() {
		return direction;
	}
	
}
