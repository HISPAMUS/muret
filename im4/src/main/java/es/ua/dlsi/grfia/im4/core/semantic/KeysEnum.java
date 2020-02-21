/*
 * Copyright (C) 2015 David Rizo Valero
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.ua.dlsi.grfia.im4.core.semantic;

/**
 *
 * @author drizo
 */
public enum KeysEnum {
    CM(0, PitchClasses.C, Mode.MAJOR),
    Am(0, PitchClasses.A, Mode.MINOR),
    FM(-1, PitchClasses.F, Mode.MAJOR),
    Dm(-1, PitchClasses.D, Mode.MINOR),
    BbM(-2, PitchClasses.B_FLAT, Mode.MAJOR),
    Gm(-2, PitchClasses.G, Mode.MINOR),
    EbM(-3, PitchClasses.E_FLAT, Mode.MAJOR),
    Cm(-3, PitchClasses.C, Mode.MINOR),
    AbM(-4, PitchClasses.A_FLAT, Mode.MAJOR),
    Fm(-4, PitchClasses.F, Mode.MINOR),
    DbM(-5, PitchClasses.D_FLAT, Mode.MAJOR),
    Bbm(-5, PitchClasses.B_FLAT, Mode.MINOR),
    GbM(-6, PitchClasses.G_FLAT, Mode.MAJOR),
    Ebm(-6, PitchClasses.E_FLAT, Mode.MINOR),
    CbM(-7, PitchClasses.C_FLAT, Mode.MAJOR),
    Abm(-7, PitchClasses.A_FLAT, Mode.MINOR),
    GM(1, PitchClasses.G, Mode.MAJOR),
    Em(1, PitchClasses.E, Mode.MINOR),
    DM(2, PitchClasses.D, Mode.MAJOR),
    Bm(2, PitchClasses.B, Mode.MINOR),
    AM(3, PitchClasses.A, Mode.MAJOR),
    Fsm(3, PitchClasses.F_SHARP, Mode.MINOR),
    EM(4, PitchClasses.E, Mode.MAJOR),
    Csm(4, PitchClasses.C_SHARP, Mode.MINOR),
    BM(5, PitchClasses.B, Mode.MAJOR),
    Gsm(5, PitchClasses.G_SHARP, Mode.MINOR),
    FsM(6, PitchClasses.F_SHARP, Mode.MAJOR),
    Dsm(6, PitchClasses.D_SHARP, Mode.MINOR),
    CsM(7, PitchClasses.C_SHARP, Mode.MAJOR),
    Asm(7, PitchClasses.A_SHARP, Mode.MINOR);
    
	Key key;

	private KeysEnum(int fifths, PitchClasses pc, Mode mode) {
		key = new Key(fifths, pc, mode);
	}

	public Key getKey() {
		return key;
	}

}
