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

package es.ua.dlsi.grfia.im4.core.semantic.mensural.meters.hispanic;

//TODO Integrar con C32 "internacional"

import es.ua.dlsi.grfia.im4.core.Time;
import es.ua.dlsi.grfia.im4.core.semantic.mensural.meters.Perfection;
import es.ua.dlsi.grfia.im4.core.semantic.mensural.meters.TimeSignatureMensural;
import es.ua.dlsi.grfia.im4.core.semantic.meters.SignTimeSignature;

/**
 *
 * @author drizo
 */
public class TimeSignatureProporcionMayor extends TimeSignatureMensural {

    public TimeSignatureProporcionMayor() {
    		super(Perfection.imperfectum, Perfection.imperfectum, Perfection.perfectum, Perfection.imperfectum);
    }

    @Override
    public String toString() {
    		return "C/Z";
    }


    @Override
	public boolean equals(Object other) {
		return other instanceof TimeSignatureProporcionMayor;
	}

	@Override
	public Time getDuration() {
		return getBreveDuration();
	}


	@Override
	public SignTimeSignature clone() {
		return new TimeSignatureProporcionMayor();
	}

	@Override
	public String getSignString() {
		return "C|3/2";
	}
}
