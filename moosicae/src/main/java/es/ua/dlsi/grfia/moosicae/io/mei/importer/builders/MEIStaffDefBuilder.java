package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.ICommonAlterationKeySignature;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIStaffDef;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIStaffDefBuilder extends MEIObjectBuilder<MEIStaffDef> {
    protected IClef clef;
    protected ICommonAlterationKeySignature commonAlterationKey;
    protected IMeter meter;
    private Integer n;

    public MEIStaffDefBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }


    @Override
    public MEIStaffDef build() throws IMException {
        return new MEIStaffDef(getId(), clef, commonAlterationKey, meter, n);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> nattr = xmlImporterParam.getAttribute("n");
        if (nattr.isPresent()) {
            n = Integer.parseInt(nattr.get());
        }

        Optional<IClef> clef = MEIAttributesParsers.getInstance().parseClef(coreObjectFactory, xmlImporterParam);
        if (clef.isPresent()) {
            this.clef = clef.get();
        }

        Optional<ICommonAlterationKeySignature> commonAlterationKey = MEIAttributesParsers.getInstance().parseCommonAlterationKey(coreObjectFactory, xmlImporterParam);
        if (commonAlterationKey.isPresent()) {
            this.commonAlterationKey = commonAlterationKey.get();
        }

        Optional<IMeter> meter = MEIAttributesParsers.getInstance().parseMeter(coreObjectFactory, xmlImporterParam);
        if (meter.isPresent()) {
            this.meter = meter.get();
        }

    }
}
