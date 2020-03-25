package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IStaffLineCount;
import es.ua.dlsi.grfia.moosicae.io.IImporter;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.builders.*;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.*;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporter;

import java.util.HashMap;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/03/2020
 */
public class MEIImporter extends XMLImporter implements IImporter {
    private MEIScoreDef meiScoreDef;
    private MEISection section;
    private HashMap<Integer, IStaff> staffNumbers;

    public MEIImporter(ICoreAbstractFactory abstractFactory) {
        super(abstractFactory);
        coreObjectBuilderSuppliers.add("scoreDef", MEIScoreDefBuilder::new);
        coreObjectBuilderSuppliers.add("staffGrp", MEIStaffGroupBuilder::new);
        coreObjectBuilderSuppliers.add("staffDef", MEIStaffDefBuilder::new);
        coreObjectBuilderSuppliers.add("section", MEISectionBuilder::new);
        coreObjectBuilderSuppliers.add("measure", MEIMeasureBuilder::new);
        coreObjectBuilderSuppliers.add("staff", MEIStaffBuilder::new);
        coreObjectBuilderSuppliers.add("layer", MEILayerBuilder::new);

        coreObjectBuilderSuppliers.add("note", MEINoteBuilder::new);
    }

    private void convert(IScore score, IStaffGroup parent, MEISystemDef systemDef) {
        if (systemDef instanceof MEIStaffDef) {
            MEIStaffDef meiStaffDef = (MEIStaffDef) systemDef;
            //TODO line count parameter in MEI
            IStaffLineCount staffLineCount = coreAbstractFactory.createStaffLineCount(5);
            IStaff staff;
            if (parent == null) {
                staff = coreAbstractFactory.createStaff(score, null, staffLineCount);
            } else {
                staff = coreAbstractFactory.createStaff(parent, null, staffLineCount);
            }
            staffNumbers.put(meiStaffDef.getN(), staff);
        } else if (systemDef instanceof MEIStaffGroupDef) {
            MEIStaffGroupDef meiStaffGroupDef = (MEIStaffGroupDef) systemDef;
            IStaffGroup staffGroup;
            if (parent == null) {
                staffGroup = coreAbstractFactory.createStaffGroup(score, null);
            } else {
                staffGroup = coreAbstractFactory.createStaffGroup(parent, null);
            }
            for (MEISystemDef child: meiStaffGroupDef.getChildren()) {
                convert(score, staffGroup, child);
            }
        }
    }

    private void insertContents(IScore score, IPart part, IVoice voice, MEISection section) throws IMException {
        for (MEIMeasure measure: section.getMeasures()) {
            for (MEIStaff measureStaff: measure.getStaves()) {
                IStaff staff = staffNumbers.get(measureStaff.getN());
                if (staff == null) {
                    throw new IMException("Cannot find a staff with n=" + measureStaff.getN());
                }
                for (MEILayer layer: measureStaff.getLayers()) {
                    for (ICoreItem coreItem: layer.getItems()) {
                        //TODO insertar los elementos comunes
                        score.add(voice, staff, coreItem);//TODO la voice debería salir de layer
                    }
                }
            }
        }
    }

    @Override
    protected IScore buildScore() throws IMException {
        if (meiScoreDef == null) {
            throw new IMException("Missing element scoreDef");
        }
        if (section == null) {
            throw new IMException("Missing element section");
        }

        // TODO everything goes to a part
        staffNumbers = new HashMap<>();
        IScore score = coreAbstractFactory.createScore(null);
        IPart part = coreAbstractFactory.createPart(score, null,null);
        IVoice voice = coreAbstractFactory.createVoice(part, null, null);
        convert(score, null, meiScoreDef.getMeiStaffGroupDef());
        insertContents(score, part, voice, section);
        return score;
    }


    @Override
    protected void onEndElement(String elementName, Object end) {
        switch (elementName) {
            case "scoreDef":
                this.meiScoreDef = (MEIScoreDef) end;
                break;
            case "section":
                this.section = (MEISection) end;
        }

    }
}
