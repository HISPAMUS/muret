package es.ua.dlsi.grfia.moosicae.core.mensural;

import es.ua.dlsi.grfia.moosicae.IMException;

public enum EMensuralPerfections {
	perfectum(3), imperfectum(2), alteratio(2);

	private int divisions;

	EMensuralPerfections(int divisions) {
	    this.divisions = divisions;
    }

    public int getDivisions() {
        return divisions;
    }

    public static EMensuralPerfections getPerfection(int divisions) throws IMException {
	    for (EMensuralPerfections p: EMensuralPerfections.values()) {
	        if (p.divisions == divisions) {
	            return p;
            }
        }
        throw new IMException("Cannot find a mensural perfection for " + divisions + " divisions");
    }
}
