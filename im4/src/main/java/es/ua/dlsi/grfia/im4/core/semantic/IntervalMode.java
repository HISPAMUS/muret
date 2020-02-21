package es.ua.dlsi.grfia.im4.core.semantic;
/**
@author drizo
@date 10/06/2011
 **/
public enum IntervalMode {
	MAJOR,
	MINOR,
	PERFECT,
	AUGMENTED,
	DIMINISHED,
	DOUBLE_AUGMENTED,
	DOUBLE_DIMINISHED,
	TRIPLE_AUGMENTED,
	TRIPLE_DIMINISHED, 
	UNDEFINED;

	public static IntervalMode complementary(IntervalMode mode) {
		switch (mode) {
		case PERFECT: return PERFECT;
		case MAJOR: return MINOR;
		case MINOR: return MAJOR;
		case AUGMENTED: return DIMINISHED;
		case DIMINISHED: return AUGMENTED;
		case DOUBLE_AUGMENTED: return DOUBLE_DIMINISHED;
		case DOUBLE_DIMINISHED: return DOUBLE_AUGMENTED;
		case TRIPLE_AUGMENTED: return TRIPLE_DIMINISHED;
		case TRIPLE_DIMINISHED: return TRIPLE_AUGMENTED;
		default: throw new RuntimeException("Not a valid interval mode: " + mode);
		}
	}
}
