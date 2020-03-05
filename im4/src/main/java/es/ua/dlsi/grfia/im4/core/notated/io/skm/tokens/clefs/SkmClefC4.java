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

package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.clefs;
import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmClef;


/**
 *
 * @author drizo
 */
public class SkmClefC4 extends SkmClef {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*clefC4";

    public SkmClefC4() {
        super(SKM);
    }
    @Override
    public SkmClefC4 clone() {
        	return new SkmClefC4();
    }

}