package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IVoicedItem;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class VoicedItem extends CoreObject implements IVoicedItem {
    public VoicedItem(IId id) {
        super(id);
    }

    public abstract VoicedItem clone();
}
