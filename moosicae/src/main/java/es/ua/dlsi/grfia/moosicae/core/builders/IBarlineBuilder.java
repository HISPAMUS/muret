package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBarline;
import es.ua.dlsi.grfia.moosicae.core.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IBarlineBuilder extends CoreObjectBuilder<IBarline>  {
    private IBarlineType barlineType;
    private Integer barNumber;

    public IBarlineBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }


    public void setBarlineType(IBarlineType barlineType) {
        this.barlineType = barlineType;
    }

    public void setBarNumber(Integer barNumber) {
        this.barNumber = barNumber;
    }

    @Override
    public IBarline build() throws IMException {
        return coreObjectFactory.createBarline(Optional.ofNullable(barNumber), Optional.ofNullable(barlineType));
    }
}
