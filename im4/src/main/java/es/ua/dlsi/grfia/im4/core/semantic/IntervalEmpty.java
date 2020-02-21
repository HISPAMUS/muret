/*
 * Copyright (C) 2016 David Rizo Valero
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
public class IntervalEmpty extends Interval {
    
    public IntervalEmpty() {
	    this.mode = IntervalMode.UNDEFINED;
	    this.direction = MotionDirection.UNDEFINED;
	    this.name = 0;
	    this.semitones = 0;
	    this.additionalOctaves = 0;
	    this.base40Difference = 0;
	    this.simpleName = 0; // empty
    }
    
}
