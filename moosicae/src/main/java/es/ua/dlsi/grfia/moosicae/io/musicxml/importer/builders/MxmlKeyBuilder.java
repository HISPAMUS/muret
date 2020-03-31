package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICommonAlterationKey;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.IKeyFromAccidentalCountBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlKeyBuilder extends IKeyFromAccidentalCountBuilder implements IImporterAdapter<ICommonAlterationKey, XMLImporterParam> {

    public MxmlKeyBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
    }

    @Override
    public ICommonAlterationKey build() throws IMException {
        if (accidentalCount == null) {
            throw new IMException("Missing fifths element");
        }

        int fifths = this.accidentalCount.getValue();
        if (fifths < 0) {
            from(coreObjectFactory.createAccidentalSymbol(getId(), EAccidentalSymbols.FLAT))
                    .from(coreObjectFactory.createKeyAccidentalCount(getId(), -fifths));
        } else if (fifths == 0) {
            from(coreObjectFactory.createKeyAccidentalCount(getId(), 0));
        } else {
            from(coreObjectFactory.createAccidentalSymbol(getId(), EAccidentalSymbols.SHARP))
                    .from(coreObjectFactory.createKeyAccidentalCount(getId(), fifths));
        }

        return super.build();
    }
}
