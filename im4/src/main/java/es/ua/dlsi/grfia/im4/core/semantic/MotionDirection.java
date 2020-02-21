package es.ua.dlsi.grfia.im4.core.semantic;
/**
@author drizo
@date 10/06/2011
 **/
public enum MotionDirection {
	ASCENDING ("/"),
	EQUAL ("-"),
	DESCENDING ("\\"), 
	UNDEFINED (""); // used for harmonic intervals
	
	private final String string;
	MotionDirection(String dir) {
		this.string = dir;
	}
	/**
	 * @return the string
	 */
	public final String getString() {
		return string;
	}
	public static MotionDirection invert(MotionDirection direction) {
		if (direction == ASCENDING) {
			return DESCENDING;
		} else if (direction == DESCENDING) {
			return ASCENDING;
		} else {
			return EQUAL; // it remains equal
		}
	}
	
}
