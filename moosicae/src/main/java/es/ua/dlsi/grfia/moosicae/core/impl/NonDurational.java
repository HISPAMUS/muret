package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.INonDurational;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class NonDurational  extends VoicedSingle implements INonDurational {
    public NonDurational(IId id) {
        super(id);
    }

    public abstract NonDurational clone();
}
