package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICommonAlterationKey;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIScoreDef;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIStaffDef;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIStaffDefBuilder extends MEIObjectBuilder<MEIStaffDef> {
    protected ICommonAlterationKey commonAlterationKey;
    protected IMeter meter;
    private Integer n;

    public MEIStaffDefBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public MEIStaffDefBuilder from(ICommonAlterationKey commonAlterationKey) {
        this.commonAlterationKey = commonAlterationKey;
        return this;
    }

    public MEIStaffDefBuilder from(IMeter meter) {
        this.meter = meter;
        return this;
    }

    @Override
    public MEIStaffDef build() throws IMException {
        return new MEIStaffDef(getId(), commonAlterationKey, meter, n);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> nattr = xmlImporterParam.getAttribute("n");
        if (nattr.isPresent()) {
            n = Integer.parseInt(nattr.get());
        }
    }
}
