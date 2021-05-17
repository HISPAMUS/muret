package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIStaffDef;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIStaffDefBuilder extends MEIObjectBuilder<MEIStaffDef> {
    protected IClef clef;
    protected IKey key;
    private IConventionalKeySignature conventionalKeySignature;
    protected IMeter meter;
    private Integer n;


    @Override
    public MEIStaffDef build() throws IMException {
        return new MEIStaffDef(getId(), n, clef, conventionalKeySignature, key, meter);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> nattr = xmlImporterParam.getAttribute("n");
        if (nattr.isPresent()) {
            n = Integer.parseInt(nattr.get());
        }

        Optional<IClef> clef = MEIAttributesParsers.getInstance().parseClef(xmlImporterParam, true);
        if (clef.isPresent()) {
            this.clef = clef.get();
        }

        Optional<IKey> key = MEIAttributesParsers.getInstance().parseKey(xmlImporterParam);
        if (key.isPresent()) {
            this.key = key.get();
        } else {
            Optional<IConventionalKeySignature> conventionalKeySignature = MEIAttributesParsers.getInstance().parseConventionalKeySignature(xmlImporterParam);
            if (conventionalKeySignature.isPresent()) {
                this.conventionalKeySignature = conventionalKeySignature.get();
            }
        }
    }
}
