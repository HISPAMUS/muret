package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.ICommonTime;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class CommonTime extends FractionalTimeSignature implements ICommonTime {
    public CommonTime() {
        super(2,2);
    }

    @Override
    public String toString() {
        return "CommonTime{} " + super.toString();
    }
}
