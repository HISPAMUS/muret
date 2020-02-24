package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;

public enum Perfection {
	perfectum(3), imperfectum(2), alteratio(2);

	private int divisions;

    Perfection(int divisions) {
	    this.divisions = divisions;
    }

    public int getDivisions() {
        return divisions;
    }

    public static Perfection getPerfection(int divisions) throws IM4Exception {
	    for (Perfection p: Perfection.values()) {
	        if (p.divisions == divisions) {
	            return p;
            }
        }
        throw new IM4Exception("Cannot find Perfection for " + divisions + " divisions");
    }
}
