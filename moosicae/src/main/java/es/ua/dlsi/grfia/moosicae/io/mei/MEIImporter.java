package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IStaffLineCount;
import es.ua.dlsi.grfia.moosicae.io.IImporter;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.builders.*;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.*;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLValidators;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporter;

import java.io.File;
import java.util.HashMap;
import java.util.Optional;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/03/2020
 */
public class MEIImporter extends XMLImporter implements IImporter {
    private MEIScoreDef meiScoreDef;
    private MEISection section;
    private HashMap<Integer, IStaff> staffNumbers;
    private HashMap<Integer, MEIStaffDef> staffDefs;

    public MEIImporter(ICoreAbstractFactory abstractFactory) {
        super(abstractFactory);
        coreObjectBuilderSuppliers.add("scoreDef", MEIScoreDefBuilder::new);
        coreObjectBuilderSuppliers.add("staffGrp", MEIStaffGroupBuilder::new);
        coreObjectBuilderSuppliers.add("staffDef", MEIStaffDefBuilder::new);
        coreObjectBuilderSuppliers.add("keySig", MEIKeyOrKeySignatureBuilder::new);
        coreObjectBuilderSuppliers.add("keyAccid", MEIKeyAccidBuilder::new);

        coreObjectBuilderSuppliers.add("meterSig", MEIMeterSigBuilder::new);
        coreObjectBuilderSuppliers.add("meterSigGrp", MEIMeterSigGrpBuilder::new);

        coreObjectBuilderSuppliers.add("section", MEISectionBuilder::new);
        coreObjectBuilderSuppliers.add("measure", MEIMeasureBuilder::new);
        coreObjectBuilderSuppliers.add("staff", MEIStaffBuilder::new);
        coreObjectBuilderSuppliers.add("layer", MEILayerBuilder::new);

        coreObjectBuilderSuppliers.add("note", MEINoteBuilder::new);
        coreObjectBuilderSuppliers.add("accid", MEIAlterationBuilder::new);
    }

    @Override
    public void validate(File fileToBeValidated) throws IMException {
        //RelaxNG.validate("http://music-encoding.org/schema/4.0.0/mei-all.rng", stream);
        XMLValidators.validateRelaxNG(this.getClass().getResourceAsStream("/schemata/mei/mei-all.rng"), fileToBeValidated);
    }

    private void convert(IScore score, IVoice voice, IStaffGroup parent, MEISystemDef systemDef) {
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
            staffDefs.put(meiStaffDef.getN(), meiStaffDef);
        } else if (systemDef instanceof MEIStaffGroupDef) {
            MEIStaffGroupDef meiStaffGroupDef = (MEIStaffGroupDef) systemDef;
            IStaffGroup staffGroup;
            if (parent == null) {
                staffGroup = coreAbstractFactory.createStaffGroup(score, null);
            } else {
                staffGroup = coreAbstractFactory.createStaffGroup(parent, null);
            }
            for (MEISystemDef child: meiStaffGroupDef.getChildren()) {
                convert(score, voice, staffGroup, child);
            }
        }
    }

    private void insertContents(MEIScoreDef scoreDef, MEISection section, IScore score, IPart part, IVoice voice) throws IMException {
        boolean firstMeasure = true;
        for (MEIMeasure measure: section.getMeasures()) {
            for (MEIStaff measureStaff: measure.getStaves()) {
                IStaff staff = staffNumbers.get(measureStaff.getN());
                if (staff == null) {
                    throw new IMException("Cannot find a staff with n=" + measureStaff.getN());
                }

                if (firstMeasure) {
                    MEIStaffDef meiStaffDef = staffDefs.get(measureStaff.getN());
                    if (meiStaffDef == null) {
                        throw new IMException("Cannot find a staffDef with n=" + measureStaff.getN());
                    }

                    if (meiStaffDef.getClef().isPresent()) {
                        score.add(voice, staff, meiStaffDef.getClef().get());
                    }

                    addCommonDefElements(meiStaffDef, score, voice, staff);

                    addCommonDefElements(scoreDef, score, voice, staff);

                }


                for (MEILayer layer: measureStaff.getLayers()) {
                    for (IVoicedItem coreItem: layer.getItems()) {
                        //TODO insertar los elementos comunes
                        score.add(voice, staff, coreItem);//TODO la voice debería salir de layer
                    }
                }
            }
            firstMeasure = false;
        }
    }

    private void addCommonDefElements(IMEIDef imeiDef, IScore score, IVoice voice, IStaff staff) {
        Optional<IMeter> meter = imeiDef.getMeter();
        if (meter.isPresent()) {
            score.add(voice, staff, meter.get());
        }
        Optional<IKey> key = imeiDef.getKey();
        if (key.isPresent()) {
            score.add(voice, staff, key.get());
        } else { // else because in the case of importing both key and key signature (it should'n happen) we prefer the key (that is a key signature with a mode)
            Optional<IConventionalKeySignature> conventionalKeySignature = imeiDef.getConventionalKeySignature();
            if (conventionalKeySignature.isPresent()) {
                score.add(voice, staff, conventionalKeySignature.get());
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
        staffDefs = new HashMap<>();
        IScore score = coreAbstractFactory.createScore(null);
        IPart part = coreAbstractFactory.createPart(score, null,null);
        IVoice voice = coreAbstractFactory.createVoice(part, null, null);
        convert(score, voice, null, meiScoreDef.getMeiStaffGroupDef());
        insertContents(meiScoreDef, section, score, part, voice);
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
