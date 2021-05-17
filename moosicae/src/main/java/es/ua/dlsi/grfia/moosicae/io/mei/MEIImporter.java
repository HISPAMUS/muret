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

    public MEIImporter() {
        coreObjectBuilderSuppliers.add("scoreDef", MEIScoreDefBuilder::new);
        coreObjectBuilderSuppliers.add("staffGrp", MEIStaffGroupBuilder::new);
        coreObjectBuilderSuppliers.add("staffDef", MEIStaffDefBuilder::new);
        coreObjectBuilderSuppliers.add("keySig", MEIKeyOrKeySignatureBuilder::new);
        coreObjectBuilderSuppliers.add("clef", MEIClefBuilder::new);
        coreObjectBuilderSuppliers.add("keyAccid", MEIKeyAccidBuilder::new);

        coreObjectBuilderSuppliers.add("meterSig", MEIMeterSigBuilder::new);
        coreObjectBuilderSuppliers.add("meterSigGrp", MEIMeterSigGrpBuilder::new);

        coreObjectBuilderSuppliers.add("section", MEISectionBuilder::new);
        coreObjectBuilderSuppliers.add("measure", MEIMeasureBuilder::new);
        coreObjectBuilderSuppliers.add("staff", MEIStaffBuilder::new);
        coreObjectBuilderSuppliers.add("layer", MEILayerBuilder::new);

        coreObjectBuilderSuppliers.add("note", MEINoteBuilder::new);
        coreObjectBuilderSuppliers.add("accid", MEIAlterationBuilder::new);

        coreObjectBuilderSuppliers.add("beam", MEIBeamBuilder::new);
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
            IStaffLineCount staffLineCount = ICoreAbstractFactory.getInstance().createStaffLineCount(5);
            IStaff staff;
            if (parent == null) {
                staff = ICoreAbstractFactory.getInstance().createStaff(score, null, staffLineCount);
            } else {
                staff = ICoreAbstractFactory.getInstance().createStaff(parent, null, staffLineCount);
            }
            staffNumbers.put(meiStaffDef.getN(), staff);
            staffDefs.put(meiStaffDef.getN(), meiStaffDef);
        } else if (systemDef instanceof MEIStaffGroupDef) {
            MEIStaffGroupDef meiStaffGroupDef = (MEIStaffGroupDef) systemDef;
            IStaffGroup staffGroup;
            if (parent == null) {
                staffGroup = ICoreAbstractFactory.getInstance().createStaffGroup(score, null);
            } else {
                staffGroup = ICoreAbstractFactory.getInstance().createStaffGroup(parent, null);
            }
            for (MEISystemDef child: meiStaffGroupDef.getChildren()) {
                convert(score, voice, staffGroup, child);
            }
        }
    }

    private void insertContents(MEIScoreDef scoreDef, MEISection section, IScore score, IPart part, IVoice voice) throws IMException {
        boolean firstMeasure = true;
        for (MEIMeasure meiMeasure: section.getMeasures()) {
            IMeasure measure = ICoreAbstractFactory.getInstance().createMeasure(meiMeasure.getId(),
                    meiMeasure.getNumber().isPresent() ? meiMeasure.getNumber().get() : null,
                    meiMeasure.getLeftBarline().isPresent() ? meiMeasure.getLeftBarline().get() : null,
                    meiMeasure.getRightBarline().isPresent() ? meiMeasure.getRightBarline().get() : null);
            score.add(measure);
            for (MEIStaff measureStaff: meiMeasure.getStaves()) {
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
                        IClef clef = meiStaffDef.getClef().get();
                        insert(score, voice, measure, staff, clef);
                    }

                    addCommonDefElements(meiStaffDef, score, voice, staff, measure);

                    addCommonDefElements(scoreDef, score, voice, staff, measure);

                }


                for (MEILayer layer: measureStaff.getLayers()) {
                    for (IVoiced voiced: layer.getItems()) {
                        //TODO insertar los elementos comunes
                        insert(score, voice, measure, staff, voiced);
                    }
                }
            }
            firstMeasure = false;
        }

        /*Nothing to do as voiced items are already connected
        for (IConnector connector: section.getConnectors()) {
        }*/
    }


    private void insert(IScore score, IVoice voice, IMeasure measure, IStaff staff, IVoiced voiced) throws IMException {
        if (voiced instanceof IVoicedSingle) {
            IVoicedSingle single = (IVoicedSingle) voiced;
            score.add(voice, staff, single);//TODO la voice debería salir de layer
            measure.add(single);
        } else if (voiced instanceof IVoicedComposite) {
            //TODO Añadir a single voice el parámetro staff para poder moverlo con cross-staff a otro
            IVoicedComposite composite = (IVoicedComposite) voiced;
            voice.addChild(composite);
            //TODO Ver qué pasa con barrados que cruzan las barras de compás y por tanto están en distintos compases
            for (IVoiced child: ((IVoicedComposite) voiced).getChildren()) {
                insert(score, voice, measure, staff, child);
            }
        } else {
            throw new IMException("Unsupported voiced type: " + voiced.getClass().getName());
        }

    }

    private void addCommonDefElements(IMEIDef imeiDef, IScore score, IVoice voice, IStaff staff, IMeasure measure) throws IMException {
        Optional<IMeter> meter = imeiDef.getMeter();
        if (meter.isPresent()) {
            insert(score, voice, measure, staff, meter.get());
        }
        Optional<IKey> key = imeiDef.getKey();
        if (key.isPresent()) {
            insert(score, voice, measure, staff, key.get());
        } else { // else because in the case of importing both key and key signature (it should'n happen) we prefer the key (that is a key signature with a mode)
            Optional<IConventionalKeySignature> conventionalKeySignature = imeiDef.getConventionalKeySignature();
            if (conventionalKeySignature.isPresent()) {
                insert(score, voice, measure, staff, conventionalKeySignature.get());
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
        IScore score = ICoreAbstractFactory.getInstance().createScore(null);
        IPart part = ICoreAbstractFactory.getInstance().createPart(score, null,null);
        IVoice voice = ICoreAbstractFactory.getInstance().createVoice(part, null, null);
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
                break;
        }

    }
}
