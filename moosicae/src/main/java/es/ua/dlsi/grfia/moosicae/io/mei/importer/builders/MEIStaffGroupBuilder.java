package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIStaffGroupDef;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEISystemDef;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MEIStaffGroupBuilder extends MEIObjectBuilder<MEIStaffGroupDef> {
    private final List<MEISystemDef> systemDefList;

    public MEIStaffGroupBuilder() {
        systemDefList = new LinkedList<>();
    }

    public MEIStaffGroupBuilder add(MEISystemDef systemDef) {
        this.systemDefList.add(systemDef);
        return this;
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        MEIObjectBuilder.readMEI(this, xmlImporterParam);
    }

    @Override
    public MEIStaffGroupDef build() throws IMException {
        return new MEIStaffGroupDef(getId(), systemDefList.toArray(new MEISystemDef[0]));
    }
}
