package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICommonAlterationKey;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIScoreDef;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIStaffGroupDef;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIScoreDefBuilder extends MEIObjectBuilder<MEIScoreDef> {
    protected ICommonAlterationKey commonAlterationKey;
    protected IMeter meter;
    private MEIStaffGroupDef staffGroupDef;

    public MEIScoreDefBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public MEIScoreDefBuilder from(ICommonAlterationKey commonAlterationKey) {
        this.commonAlterationKey = commonAlterationKey;
        return this;
    }

    public MEIScoreDefBuilder from(MEIStaffGroupDef staffGroupDef) {
        this.staffGroupDef = staffGroupDef;
        return this;
    }

    public MEIScoreDefBuilder from(IMeter meter) {
        this.meter = meter;
        return this;
    }

    @Override
    public MEIScoreDef build() throws IMException {
        return new MEIScoreDef(getId(), commonAlterationKey, meter, staffGroupDef);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
    }
}
