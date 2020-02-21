package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;

/**
 * @author  drizo
 * @date  28/06/2011
 */
public class ScientificPitch implements Comparable<ScientificPitch>, Cloneable {
    /**
     * Middle C
     */
	public static final ScientificPitch C4 = new ScientificPitch(PitchClasses.C.getPitchClass(), 4);
    
	/**
	 * Pitch class
	 */
	final PitchClass pitchClass;

    /**
	 * Octave name
	 */
	final int octave;

	/**
	 * Computed
	 */
	//CANNOT COMPUTE AND SAVE, IF PITCH CLASS CHANGES IT IS NO LONGER VALID int base40;
	//private int base40Chroma;
		
	public ScientificPitch(PitchClass pc, int oct) {
		this.pitchClass = pc;
		this.octave = oct;
		//computeBase40();
	}

	public ScientificPitch(PitchClasses pc, int oct) {
		this.pitchClass = pc.getPitchClass();
		this.octave = oct;
		//computeBase40();
	}
	
	public ScientificPitch(DiatonicPitch noteName, Accidentals accidental, Integer octave) {
		this(new PitchClass(noteName, accidental), octave);
	}

	/**
	 * @return the pitchClass
	 */
	public final PitchClass getPitchClass() {
		return pitchClass;
	}



	/**
	 * @return the octave
	 */
	public final int getOctave() {
		return octave;
	}


	public int computeMidiPitch()  {
		int result = pitchClass.getSemitonesFromC() + (octave+1)*12;
		if (result < 0 ||result > 127) {
			throw new RuntimeException("Invalid MIDI pitch: " + result + " for scientific pitch " + this.toString());
		}
		return result;		
	}

	@Override
	public int compareTo(ScientificPitch other) {
		int res = computeMidiPitch() - other.computeMidiPitch();
		if (res == 0) {
			res = this.octave - other.octave;
			if (res == 0) {
				res = this.pitchClass.compareTo(other.pitchClass);				
			}
		}
		return res;
	}

	/** (non-Javadoc)
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return pitchClass.toString()  + octave;
	}


	/** (non-Javadoc)
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + octave;
		result = prime * result
				+ ((pitchClass == null) ? 0 : pitchClass.hashCode());
		return result;
	}


	/** (non-Javadoc)
	 * @see Object#equals(Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScientificPitch other = (ScientificPitch) obj;
		if (octave != other.octave)
			return false;
		if (pitchClass == null) {
			if (other.pitchClass != null)
				return false;
		} else if (!pitchClass.equals(other.pitchClass))
			return false;
		return true;
	}

	public MotionDirection computeDirection(ScientificPitch previous) {
		if (previous == null) {
			return MotionDirection.UNDEFINED; // TODO ¿No deberia ser NONE?
		} else {
			int comp = previous.compareTo(this);
			if (comp == 0) {
				return MotionDirection.UNDEFINED;
			} else if (comp < 0) {
				return MotionDirection.ASCENDING;
			} else {
				return MotionDirection.DESCENDING;
			}
		} 
	}
	
	@Override
	public ScientificPitch clone() {
	    return new ScientificPitch(pitchClass, octave);
	}

	public ScientificPitch transpose(Interval interval) throws IM4Exception {
	    return interval.computeScientificPitchFrom(this);
	}

	public Base40 computeBase40() {
	    return new Base40(this);
    }

    // see https://newt.phys.unsw.edu.au/jw/notes.html
    public double computeFrequency(double aTunning) {
        //return (aTunning / 32) * (2 ^ ((computeMidiPitch() - 9) / 12));
        int midiPitch = computeMidiPitch();
        int midiPitchNoteA = 69;
        return Math.pow(2, (midiPitch-midiPitchNoteA)/12.0)*aTunning;
    }

    public double computeFrequency() {
        return computeFrequency(440.0);
    }

	/*
	public int getBase40() {
	    return base40;
	}
	
	public int getBase40Chroma() {
		return base40Chroma;
	}

	private void computeBase40() {
            if (pitchClass != null) {
                base40Chroma = pitchClass.getBase40Chroma();
                base40 = octave * 40 + base40Chroma;
            }
	}*/

	/**
	 * Format: A#3, C4, Cb3, Cbb3, Cx5
	 * @return
	 */
	public static ScientificPitch parse(String string) {
		String diatonicPitch = string.substring(0, 1);
		String right = string.substring(1);

		Accidentals accidental = null;
		for (Accidentals accidentals: Accidentals.values()) {
			if (right.startsWith(accidentals.getAbbrName())) {
				accidental = accidentals;
				right = right.substring(accidental.getAbbrName().length());
				break;
			}
		}

		String octave = right;

		return new ScientificPitch(DiatonicPitch.valueOf(diatonicPitch),
				accidental,
				Integer.parseInt(octave));
	}
}
