package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IVoicedSingle;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class VoicedSingle extends Voiced implements IVoicedSingle {
    public VoicedSingle(IId id) {
        super(id);
    }

    public abstract VoicedSingle clone();
}
