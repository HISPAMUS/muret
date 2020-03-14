package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.ICutTime;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class CutTime extends FractionalTimeSignature implements ICutTime {
    public CutTime() {
        super(2, 2);
    }

    @Override
    public String toString() {
        return "CutTime{} " + super.toString();
    }
}
