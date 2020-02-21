package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;

import java.util.Objects;

public class Interval implements Comparable<Interval> {

	/**
	 * 1st = 1, 2nd = 2, 3rd = 3, 8 ... The tempo 0 means empty
	 *
	 */
	protected int simpleName = 0;
	/**
	 * It may be a 13th
	 *
	 */
	protected int name = 0;

	/**
	 * Major, minor, diminished, augmented
	 */
	protected IntervalMode mode;
	/**
	 * Direction
	 */
	protected MotionDirection direction;

	protected int semitones;

	/**
	 * For the compound intervals. The 13th will have name=5 and
	 * octave=additionalOctaves
	 */
	protected int additionalOctaves;

	/**
	 * See http://wiki.ccarh.org/wiki/Base_40
	 */
	protected int base40Difference;

	/**
	 * @param name
	 * @param mode
	 * @param direction
	 * @throws IM4Exception
	 */
	public Interval(int name, IntervalMode mode, MotionDirection direction) throws IM4Exception {
		super();
		this.mode = mode;
		this.direction = direction;
		setName(name);
	}

	protected Interval() {
	}

	/**
	 * If this is ascending, generate the same desdending
	 */
	public Interval createContraryInterval() throws IM4Exception {
		if (direction.equals(MotionDirection.ASCENDING)) {
			return new Interval(name, mode, MotionDirection.DESCENDING);
		} else if (direction.equals(MotionDirection.DESCENDING)) {
			return new Interval(name, mode, MotionDirection.ASCENDING);
		} else {
			return new Interval(name, mode, direction);
		}
	}

	private Interval(Intervals itv, int additionalOctaves) {
		this.name = itv.getName() + (7 * additionalOctaves);
		this.simpleName = itv.getName();
		this.direction = itv.getDirection();
		this.mode = itv.getMode();
		this.semitones = itv.getSemitones() + additionalOctaves * 12;
		base40Difference = itv.getBase40Difference();
		this.additionalOctaves = additionalOctaves;
	}

	/**
	 * Package visibility, used by Intervals enum
	 *
	 * @param name2
	 * @param mode2
	 * @param direction2
	 * @param semitones2
	 */
	Interval(int name2, IntervalMode mode2, MotionDirection direction2, int semitones2, int base40Difference) {
		if (name2 < 1 || name2 >= 8) {
			throw new IM4RuntimeException("Invalid simple interval name: " + name2);
		}
		this.simpleName = name2;
		this.name = name2;
		this.mode = mode2;
		this.direction = direction2;
		this.semitones = semitones2;
		this.base40Difference = base40Difference;
	}

	public int getAdditionalOctaves() {
		return additionalOctaves;
	}

	public void setAdditionalOctaves(int newAdditionalOctaves) {
		int semitonesChange = newAdditionalOctaves*12 - this.additionalOctaves*12;
		
		this.additionalOctaves = newAdditionalOctaves;
		this.name = simpleName + (7 * additionalOctaves);
		this.semitones += semitonesChange;
	}

	public boolean isCompound() {
		return additionalOctaves >= 1;
	}

	/**
	 * @return the name (1 = 1st, 2 = 2nd...)
	 */
	public final int getName() {
		return name;
	}

	public int getSimpleName() {
		return simpleName;
	}

	/**
	 * @param name
	 *            the name to set
	 * @throws IM4Exception
	 */
	public final void setName(int name) throws IM4Exception {
		this.name = name;
		if (name < 8) {
			simpleName = name;
		} else {
			simpleName = name % 8 + 1;
			additionalOctaves = name / 8;
		}

		if (this.name == 1 && this.mode == IntervalMode.PERFECT) {
			this.direction = MotionDirection.EQUAL;
		}
		boolean found = false;
		for (int i = 0; !found && i < Intervals.values().length; i++) {
			Intervals itv = Intervals.values()[i];
			if (simpleName == itv.getName() && mode.equals(itv.getMode()) && direction.equals(itv.getDirection())) {
				found = true;
				this.semitones = itv.getSemitones() + additionalOctaves * 12;
				base40Difference = itv.getBase40Difference();
			}
		}
		if (!found) {
			throw new IM4Exception("Cannot find semitones for interval " + this.toString()); // TODO
																								// Intervalos
																								// compuestos
		}
	}

	/**
	 * @return the mode
	 */
	public final IntervalMode getMode() {
		return mode;
	}

	/**
	 * @param mode
	 *            the mode to set
	 */
	public final void setMode(IntervalMode mode) {
		this.mode = mode;
	}

	/**
	 * @param direction
	 *            the direction to set
	 */
	public final void setDirection(MotionDirection direction) {
		this.direction = direction;
	}

	/**
	 * @return the direction
	 */
	public final MotionDirection getDirection() {
		return direction;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 47 * hash + this.name;
		hash = 47 * hash + Objects.hashCode(this.mode);
		hash = 47 * hash + Objects.hashCode(this.direction);
		return hash;
	}

	public boolean equalsWithoutDirection(Intervals itvs) {
		return itvs.getMode() == this.mode && itvs.getName() == this.name;
	}

	/**
	 * 
	 * @param obj
	 *            Interval, VagueInterval
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Interval) {
			return compareTo((Interval) obj) == 0;
		} else if (obj instanceof VagueInterval) {
			boolean result = true;
			VagueInterval vi = (VagueInterval) obj;
			if (vi.getName() != 0) {
				result = result && this.name == vi.getName();
			}
			if (vi.getDirection() != null) {
				result = result && this.direction.equals(vi.getDirection());
			}
			if (vi.getMode() != null) {
				result = result && this.mode.equals(vi.getMode());
			}

			return result;
		} else if (obj instanceof Intervals) {
			Intervals itvs = (Intervals) obj;
			return itvs.getDirection() == this.direction && itvs.getMode() == this.mode && itvs.getName() == this.name;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}
		final Interval other = (Interval) obj;
		if (this.name != other.name) {
			return false;
		}
		if (this.mode != other.mode) {
			return false;
		}
        return this.direction == other.direction;
    }

	/**
	 * It uses the http://wiki.ccarh.org/wiki/Base_40 encoding to compute the
	 * interval The span of calculation is an octave. e.g: from=C, to=A, result
	 * = 6th ascending. If from=A, to=C, result = 6th descending
	 *
	 * @param from
	 * @param to
	 * @return
	 * @throws IM4Exception
	 */
	public static Interval compute(PitchClass from, PitchClass to) throws IM4Exception {
		int diff = to.getBase40Chroma() - from.getBase40Chroma();
		MotionDirection direction;
		if (diff > 0) {
			direction = MotionDirection.ASCENDING;
		} else if (diff == 0) {
			direction = MotionDirection.EQUAL;
		} else {
			direction = MotionDirection.DESCENDING;
		}

		// for octaves
		int sumoctave = 0;
		if (diff >= 38) {
			diff -= 40;
			sumoctave = 1;
		} else if (diff <= -38) {
			diff += 40;
			sumoctave = 1;
		}

		for (Intervals itv : Intervals.values()) {
			if (itv.getDirection() == direction && diff == itv.getBase40Difference()) {
				// da return new Interval(itv.getName()+sumoctave,
				// itv.getMode(), direction);
				return new Interval(itv, sumoctave);
			}
		}

		throw new IM4Exception("Cannot compute the interval from " + from.toString() + " to " + to.toString());
	}

	/**
	 * It uses the http://wiki.ccarh.org/wiki/Base_40 encoding to compute the
	 * interval
	 *
	 * @param from
	 * @param to
	 * @param forceDirection
	 *            Forces the interval to be computed using this interval
	 *            direction: e.g. from = A, to=C, direction=ascending,
	 *            result=3rd ascending. It the interval is a 1P, the direction
	 *            is set to EQUAL
	 * @return
	 * @throws IM4Exception
	 */
	public static Interval compute(PitchClass from, PitchClass to, MotionDirection forceDirection) throws IM4Exception {
		int diff = to.getBase40Chroma() - from.getBase40Chroma();

		if (diff > 0 && forceDirection == MotionDirection.DESCENDING) {
			diff -= 40; // a octave below
		} else if (diff < 0 && forceDirection == MotionDirection.ASCENDING) {
			diff += 40; // a octave below
		} else if (diff == 0) {
			forceDirection = MotionDirection.EQUAL;
		}

		// for octaves
		int sumoctave = 0;
		if (diff >= 38) {
			diff -= 40;
			sumoctave = 1;
		} else if (diff <= -38) {
			diff += 40;
			sumoctave = 1;
		}
		for (Intervals itv : Intervals.values()) {
			if (itv.getDirection() == forceDirection && diff == itv.getBase40Difference()) {
				// da return new Interval(itv.getName()+sumoctave,
				// itv.getMode(), forceDirection);
				return new Interval(itv, sumoctave);
			}
		}

		throw new IM4Exception(
				"Cannot compute the " + forceDirection + " interval from " + from.toString() + " to " + to.toString());
	}

	/**
	 * It uses the http://wiki.ccarh.org/wiki/Base_40 encoding to compute the
	 * interval
	 *
	 * @param from
	 * @param to
	 * @return
	 * @throws IM4Exception
	 */
	public static Interval compute(ScientificPitch from, ScientificPitch to) throws IM4Exception {
		//int diff = to.getBase40() - from.getBase40();
        Base40 toB40 = to.computeBase40();
        Base40 fromB40 = from.computeBase40();
        int diff = toB40.getBase40() - fromB40.getBase40();
		int diffInOctave = diff % 40;
		int octaves = diff / 40;
		MotionDirection direction;
		if (diffInOctave > 0) {
			direction = MotionDirection.ASCENDING;
		} else if (diffInOctave == 0) {
			direction = MotionDirection.EQUAL;
		} else {
			direction = MotionDirection.DESCENDING;
		}

		for (Intervals itv : Intervals.values()) {
			if (itv.getDirection() == direction && diffInOctave == itv.getBase40Difference()) {
				// da return new Interval(itv.getName() + octaves*8,
				// itv.getMode(), direction);
				return new Interval(itv, octaves);
			}
		}

		throw new IM4Exception("Cannot compute the interval from " + from.toString() + " to  " + to.toString());
	}

	public void invert() {
		this.name = 9 - this.name;
		this.direction = MotionDirection.invert(this.direction);
		this.mode = IntervalMode.complementary(this.mode);

	}

	public int getSemitones() {
		return semitones;
	}

	public void setSemitones(int semitones) {
		this.semitones = semitones;
	}

	/*
	 * void setShortName(String shortName) { this.shortName = shortName; }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name + "_" + this.mode + "_" + this.direction;
	}

	/**
	 * Get a pitch class given the interval
	 *
	 * @param from
	 * @return
	 * @throws IM4Exception
	 */
	public PitchClass computePitchClassFrom(PitchClass from) throws IM4Exception {
		int newPCBase40 = (40 + (from.getBase40Chroma() + base40Difference + 40 * additionalOctaves)) % 40; // sum
																											// 40
		for (PitchClasses pc : PitchClasses.values()) {
			if (newPCBase40 == pc.getBase40ChromaValue()) {
				return pc.getPitchClass();
			}
		}

		throw new IM4Exception("Cannot compute the new pitch class from " + from + " for interval " + this);
	}

	/**
	 * Get a pitch class given the interval
	 *
	 * @param from
	 * @return
	 * @throws IM4Exception
	 */
	public ScientificPitch computeScientificPitchFrom(ScientificPitch from) throws IM4Exception {
        Base40 fromB40 = from.computeBase40();

		int newPCBase40 = (fromB40.getBase40() + base40Difference + 40 * additionalOctaves);

		int newPCBase40_folded = newPCBase40 % 40;
		int octave = newPCBase40 / 40;

		for (PitchClasses pc : PitchClasses.values()) {
			if (newPCBase40_folded == pc.getBase40ChromaValue()) {
				return new ScientificPitch(pc.getPitchClass(), octave);
			}
		}

		throw new IM4Exception("Cannot compute the new scientific pitch from " + from + " for interval " + this);
	}

	// TODO Código casi repetido con computeScientificPitchFrom

	/**
	 * Add an interval
	 *
	 * @param itv
	 * @return
	 * @throws IM4Exception
	 */
	public Interval addInterval(Interval itv) throws IM4Exception {
		if (this.direction != itv.getDirection()) {
			throw new IM4Exception("Cannot add two intervals with different direction");
		}
		int newname = this.name + itv.name - 1;
		int newsemis = this.semitones + itv.semitones;
		return Intervals.getInterval(newname, newsemis, this.direction);
	}

	@Override
	public int compareTo(Interval o) {
		return base40Difference - o.base40Difference;
	}

	/**
	 * 
	 * @return true for 1P, 3m, 3M, 5P, 6m, 6M, 8
	 */
	public boolean isConsonant() {
		return equalsWithoutDirection(Intervals.UNISON_PERFECT) || equalsWithoutDirection(Intervals.THIRD_MINOR_DESC)
				|| equalsWithoutDirection(Intervals.THIRD_MAJOR_DESC)
				|| equalsWithoutDirection(Intervals.FIFTH_PERFECT_DESC)
				|| equalsWithoutDirection(Intervals.SIXTH_MINOR_ASC)
				|| equalsWithoutDirection(Intervals.SIXTH_MAJOR_ASC);

	}
}
