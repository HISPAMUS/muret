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

package es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.mensural.EMensuralPerfections;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;
import es.ua.dlsi.grfia.moosicae.core.mensural.IProportioTripla;
import es.ua.dlsi.grfia.moosicae.utils.Time;
import org.jetbrains.annotations.NotNull;

/**
 * "Proporción mayor"
 * Meter in Music, 1600-1800: Performance, Perception, and Notation. George Houle: "Michael Praetorius explains 'Signis proportionatis in tactu inequali.
 * The tactus inequalis is divided into majore C|3/2, called 'proportio tripla'...
 * @author drizo
 */
public class ProportioTripla extends Mensuration implements IProportioTripla {

    public ProportioTripla(@NotNull IId id) {
    		super(id, EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.perfectum, EMensuralPerfections.imperfectum);
    }

	@Override
	public String toString() {
		return "ProportioTripla{C/Z or C|3/2} " + super.toString();
	}

	@Override
	public Time getBarDuration() {
		return getBreveDuration();
	}


	@Override
	public ProportioTripla clone() {
		return new ProportioTripla(id);
	}

	@Override
	public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {

	}
}
