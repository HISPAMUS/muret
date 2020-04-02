package es.ua.dlsi.grfia.moosicae.core.prototypes;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IKey;
import es.ua.dlsi.grfia.moosicae.core.enums.*;


/**
 * Both the conventional and theoretical keys
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class Keys extends Prototypes<IKey> {

    public Keys(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);

        for (EConventionalKeys conventionalKey: EConventionalKeys.values()) {
            this.add(conventionalKey.name(), coreAbstractFactory.createConventionalKey(null, conventionalKey));
        }

        for (ETheoreticalKeys theoreticalKey: ETheoreticalKeys.values()) {
            this.add(theoreticalKey.name(), coreAbstractFactory.createTheoreticalKey(null, theoreticalKey));
        }
    }
}
