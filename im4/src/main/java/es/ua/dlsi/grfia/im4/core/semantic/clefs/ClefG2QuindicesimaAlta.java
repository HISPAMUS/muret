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

package es.ua.dlsi.grfia.im4.core.semantic.clefs;

import es.ua.dlsi.grfia.im4.core.semantic.Clef;
import es.ua.dlsi.grfia.im4.core.semantic.DiatonicPitch;
import es.ua.dlsi.grfia.im4.core.semantic.PositionInStaff;

import static es.ua.dlsi.grfia.im4.core.semantic.PositionsInStaff.*;

/**
 *
 * @author drizo
 */
public class ClefG2QuindicesimaAlta extends Clef {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*clefG2^^2";

    public ClefG2QuindicesimaAlta() {
        super(SKM, DiatonicPitch.G, 2, 6, 2,
                new PositionInStaff[] {LINE_5, SPACE_3, SPACE_5, LINE_4, SPACE_2, SPACE_4, LINE_3},
                new PositionInStaff[] {LINE_3, SPACE_4, SPACE_2, LINE_4, LINE_2, SPACE_3, SPACE_1});

    }
    @Override
    public Clef clone() {
    		return new ClefG2QuindicesimaAlta();
    }
    
}
