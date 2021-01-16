package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IPart;
import es.ua.dlsi.grfia.moosicae.core.IScore;


import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class IScoreBuilder extends CoreObjectBuilder<IScore> {
    private List<IPart> partList;

    public IScoreBuilder add(IPart part) {
        this.partList.add(part);
        return this;
    }

    @Override
    public IScore build() throws IMException {
        if (partList.isEmpty()) {
            throw new IMException("Missing at least one part");
        }

        IScore score = ICoreAbstractFactory.getInstance().createScore(getId());
        for (IPart part: partList) {
            score.add(part);
        }

        return score;
    }

}
