package es.ua.dlsi.grfia.im4.core.semantic;

/**
@author drizo
@date 15/06/2011
 **/
public enum PitchClasses {
	C_DFLAT(DiatonicPitch.C, Accidentals.DOUBLE_FLAT,0),
	C_FLAT(DiatonicPitch.C, Accidentals.FLAT,1),
	C(DiatonicPitch.C, Accidentals.NATURAL,2),
	C_SHARP(DiatonicPitch.C, Accidentals.SHARP,3),
	C_DSHARP(DiatonicPitch.C, Accidentals.DOUBLE_SHARP,4),

	D_TFLAT(DiatonicPitch.D, Accidentals.TRIPLE_FLAT,5),
	D_DFLAT(DiatonicPitch.D, Accidentals.DOUBLE_FLAT,6),
	D_FLAT(DiatonicPitch.D, Accidentals.FLAT,7),
	D(DiatonicPitch.D, Accidentals.NATURAL,8),
	D_SHARP(DiatonicPitch.D, Accidentals.SHARP,9),
	D_DSHARP(DiatonicPitch.D, Accidentals.DOUBLE_SHARP,10),

	E_TFLAT(DiatonicPitch.E, Accidentals.TRIPLE_FLAT,11),
	E_DFLAT(DiatonicPitch.E, Accidentals.DOUBLE_FLAT,12),
	E_FLAT(DiatonicPitch.E, Accidentals.FLAT,13),
	E(DiatonicPitch.E, Accidentals.NATURAL,14),
	E_SHARP(DiatonicPitch.E, Accidentals.SHARP,15),
	E_DSHARP(DiatonicPitch.E, Accidentals.DOUBLE_SHARP,16),

	F_DFLAT(DiatonicPitch.F, Accidentals.DOUBLE_FLAT,17),
	F_FLAT(DiatonicPitch.F, Accidentals.FLAT,18),
	F(DiatonicPitch.F, Accidentals.NATURAL,19),
	F_SHARP(DiatonicPitch.F, Accidentals.SHARP,20),
	F_DSHARP(DiatonicPitch.F, Accidentals.DOUBLE_SHARP,21),
	
	G_DFLAT(DiatonicPitch.G, Accidentals.DOUBLE_FLAT,23),
	G_FLAT(DiatonicPitch.G, Accidentals.FLAT,24),
	G(DiatonicPitch.G, Accidentals.NATURAL,25),
	G_SHARP(DiatonicPitch.G, Accidentals.SHARP,26),
	G_DSHARP(DiatonicPitch.G, Accidentals.DOUBLE_SHARP,27),

	A_TFLAT(DiatonicPitch.A, Accidentals.TRIPLE_FLAT,28),
	A_DFLAT(DiatonicPitch.A, Accidentals.DOUBLE_FLAT,29),
	A_FLAT(DiatonicPitch.A, Accidentals.FLAT,30),
	A(DiatonicPitch.A, Accidentals.NATURAL,31),
	A_SHARP(DiatonicPitch.A, Accidentals.SHARP,32),
	A_DSHARP(DiatonicPitch.A, Accidentals.DOUBLE_SHARP,33),

	B_TFLAT(DiatonicPitch.B, Accidentals.TRIPLE_FLAT,34),
	B_DFLAT(DiatonicPitch.B, Accidentals.DOUBLE_FLAT,35),
	B_FLAT(DiatonicPitch.B, Accidentals.FLAT,36),
	B(DiatonicPitch.B, Accidentals.NATURAL,37),
	B_SHARP(DiatonicPitch.B, Accidentals.SHARP,38),
	B_DSHARP(DiatonicPitch.B, Accidentals.DOUBLE_SHARP,39);
	
	
	//PitchClass pc; // cannot initialize
	DiatonicPitch notename;
	Accidentals accidental;
	/**
	 * See http://wiki.ccarh.org/wiki/Base_40
	 */
	int base40ChromaValue;
	
	/**
	 * @param notename
	 * @param accidental
	 */
	PitchClasses(DiatonicPitch notename, Accidentals accidental, int base40ChromaValue) {
		this.notename = notename;
		this.accidental = accidental;
		this.base40ChromaValue = base40ChromaValue;
	}
	/**
	 * @return the notename
	 */
	public final DiatonicPitch getNotename() {
		return this.notename;
	}
	/**
	 * @return the accidental
	 */
	public final Accidentals getAccidental() {
		return this.accidental;
	}
	/**
	 * @return the pc
	 */
	public final PitchClass getPitchClass() {
		return new PitchClass(notename, accidental);
	}

	public int getBase40ChromaValue() {
	    return base40ChromaValue;
	}
	
	
	
}
