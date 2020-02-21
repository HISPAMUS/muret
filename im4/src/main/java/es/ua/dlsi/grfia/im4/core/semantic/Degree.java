package es.ua.dlsi.grfia.im4.core.semantic;

/**
 * Use ordinal() of enum to retrieve the int equivalent
 * @author drizo
 *
 */
public enum Degree {
	NONE, // used here in order to set tempo 1 for I, 2 for II
	I,
	II,
	III,
	IV,
	V,
	VI,
	VII;
	
	public Degree add(Degree degree) {
		int res = (this.ordinal()+degree.ordinal()-1);
		if (res > 7) {
			res = res % 8 +1;
		}
		return Degree.values()[res];	
	}
	
	public int getNumber() {
		return this.ordinal();
	}
	
	public static Degree[] validValues() {
		return new Degree[] {I,II,III, IV, V, VI, VII};
	}
}

