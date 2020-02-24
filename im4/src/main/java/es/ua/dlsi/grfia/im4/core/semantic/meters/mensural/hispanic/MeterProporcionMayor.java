/*
 * Copyright (C) 2013 David Rizo Valero
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

package es.ua.dlsi.grfia.im4.core.semantic.meters.mensural.hispanic;

//TODO Integrar con C32 "internacional" - ver **mens

import es.ua.dlsi.grfia.im4.core.Time;
import es.ua.dlsi.grfia.im4.core.semantic.Perfection;
import es.ua.dlsi.grfia.im4.core.semantic.meters.mensural.MeterMensural;
import es.ua.dlsi.grfia.im4.core.semantic.meters.Meter;

/**
 *
 * @author drizo
 */
public class MeterProporcionMayor extends MeterMensural {
	/**
	 * Package visibility to be used by the factory
	 */
	public static final String SKM = "*met(C/Z)";


	public MeterProporcionMayor() {
    		super(SKM, Perfection.imperfectum, Perfection.imperfectum, Perfection.perfectum, Perfection.imperfectum);
    }

    @Override
	public boolean equals(Object other) {
		return other instanceof MeterProporcionMayor;
	}

	@Override
	public Time getDuration() {
		return getBreveDuration();
	}

	@Override
	public Meter clone() {
		return new MeterProporcionMayor();
	}

}
