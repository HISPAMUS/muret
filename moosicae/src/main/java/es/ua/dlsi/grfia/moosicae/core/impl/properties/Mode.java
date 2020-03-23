package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
import es.ua.dlsi.grfia.moosicae.core.enums.EModes;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class Mode extends EnumCoreProperty<EModes> implements IMode {
    public Mode(@NotNull IId id, @NotNull EModes enumValue) {
        super(id, enumValue);
    }

    @Override
    public Mode clone() {
        return new Mode(IdGenerator.getInstance().generateUniqueId(), value);
    }

}
