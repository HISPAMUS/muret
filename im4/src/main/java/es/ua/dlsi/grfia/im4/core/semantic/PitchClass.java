package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;

/**
@author drizo
@date 06/06/2011
 **/
public class PitchClass implements Comparable<PitchClass> {

	/**
	 * An octave where the black keys are mapped using sharps
	 */
	public static final PitchClass [] OCTAVE_SHARPS = {
			PitchClasses.C.getPitchClass(),
			PitchClasses.C_SHARP.getPitchClass(),
			PitchClasses.D.getPitchClass(),
			PitchClasses.D_SHARP.getPitchClass(),
			PitchClasses.E.getPitchClass(), 
			PitchClasses.F.getPitchClass(),
			PitchClasses.F_SHARP.getPitchClass(),
			PitchClasses.G.getPitchClass(),
			PitchClasses.G_SHARP.getPitchClass(),
			PitchClasses.A.getPitchClass(),
			PitchClasses.A_SHARP.getPitchClass(),
			PitchClasses.B.getPitchClass() 
	};

	
	DiatonicPitch noteName;
	Accidentals accidental;
	int semitonesFromC;
	/**
	 * @return the semitonesFromC
	 */
	public final int getSemitonesFromC() {
		return semitonesFromC;
	}
	/**
	 * @return the noteName
	 */
	public final DiatonicPitch getNoteName() {
		return noteName;
	}
	/**
	 * @param noteName the noteName to set
	 */
	public final void setNoteName(DiatonicPitch noteName) {
		this.noteName = noteName;
		computeSemitonesFromC();
	}
	/**
	 * @return the accidental
	 */
	public final Accidentals getAccidental() {
		return accidental;
	}
	/**
	 * @param accidental the accidental to set
	 */
	public final void setAccidental(Accidentals accidental) {
		if (accidental == null) {
			this.accidental = Accidentals.NATURAL;
		} else {
			this.accidental = accidental;
		}
		computeSemitonesFromC();
	}
	
	/**
	 * Used for convenience in GUI
	 */
	public PitchClass() {	    
	}
	/**
	 * @param noteName
	 * @param accidental
	 */
	public PitchClass(DiatonicPitch noteName, Accidentals accidental) {
		super();
		this.noteName = noteName;
		setAccidental(accidental);
	}
	public PitchClass(DiatonicPitch noteName) {
		this.noteName = noteName;
		this.accidental = Accidentals.NATURAL;
		computeSemitonesFromC();
	}
	/**
	 * Used to avoid continuous computations
	 */
	private void computeSemitonesFromC() {
		this.semitonesFromC = noteName.getSemitonesFromC() + accidental.getAlteration();
	}
	@Override
	public int compareTo(PitchClass o) {
		int diff = semitonesFromC - o.semitonesFromC;
		if (diff == 0) {
			return this.noteName.getOrder() - o.noteName.getOrder();
		} else {
			return diff;
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	    if (noteName == null) {
		return "";
	    } else {
		return noteName.toString() + accidental.toString();
	    }
	}
	
	/** (non-Javadoc)
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accidental == null) ? 0 : accidental.hashCode());
		result = prime * result
				+ ((noteName == null) ? 0 : noteName.hashCode());
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
		PitchClass other = (PitchClass) obj;
		if (accidental.getAlteration() != other.accidental.getAlteration())
			return false;
        return noteName == other.noteName;
    }
	public boolean isRest() {
		return noteName == DiatonicPitch.REST;
	}
	
	public int getBase40Chroma() {
	    for (PitchClasses pc: PitchClasses.values()) {
		if (pc.getPitchClass().equals(this)) {
		    return pc.getBase40ChromaValue();
		}
	    }
	    throw new IM4RuntimeException("Cannot find an equivalent PitchClasses enum for pitch class "+ this);
	    
	}
	
    public boolean isEmpty() {
    		return this.noteName == null;
    }

    public boolean isAltered() {
		return accidental != null && !accidental.equals(Accidentals.NATURAL);
    }
}
