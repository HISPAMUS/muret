package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IConventionalKeySignature;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IKey;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIScoreDef;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIStaffGroupDef;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIScoreDefBuilder extends MEIObjectBuilder<MEIScoreDef> {
    protected IKey key;
    protected IConventionalKeySignature conventionalKeySignature;
    protected IMeter meter;
    private MEIStaffGroupDef staffGroupDef;

    public MEIScoreDefBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public MEIScoreDefBuilder from(MEIStaffGroupDef staffGroupDef) {
        this.staffGroupDef = staffGroupDef;
        return this;
    }

    @Override
    public MEIScoreDef build() throws IMException {
        return new MEIScoreDef(getId(), key, conventionalKeySignature, meter, staffGroupDef);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<IMeter> meter = MEIAttributesParsers.getInstance().parseMeter(coreObjectFactory, xmlImporterParam);
        if (meter.isPresent()) {
            this.meter = meter.get();
        }

        Optional<IKey> key = MEIAttributesParsers.getInstance().parseKey(coreObjectFactory, xmlImporterParam);
        if (key.isPresent()) {
            this.key = key.get();
        } else {
            Optional<IConventionalKeySignature> conventionalKeySignature = MEIAttributesParsers.getInstance().parseConventionalKeySignature(coreObjectFactory, xmlImporterParam);
            if (conventionalKeySignature.isPresent()) {
                this.conventionalKeySignature = conventionalKeySignature.get();
            }
        }

    }
}
