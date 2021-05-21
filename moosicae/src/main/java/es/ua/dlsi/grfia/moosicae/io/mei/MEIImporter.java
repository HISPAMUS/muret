package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IStaffLineCount;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreGraph;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreStaffSubgraph;
import es.ua.dlsi.grfia.moosicae.io.IImporter;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.builders.*;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.*;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLValidators;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporter;
import es.ua.dlsi.grfia.moosicae.utils.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * Do not reuse it for several MEI files
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/03/2020
 */
public class MEIImporter extends XMLImporter implements IImporter {
    private IScore score;
    private IScoreGraph scoreGraph;
    private MEISection section;
    private HashMap<Integer, IScoreStaffSubgraph> staffNumbers;
    private MEIScore meiScore;
    /**
     * In MEI the scoreDef outside the measure can be used to specify meter or key changes.
     * We move them into the next coming measure.
     * The IScoreStaffSubgraph may be null for common objects
     */
    private List<Pair<IScoreStaffSubgraph, IMooObject>> pendingObjects;
    //private HashMap<Integer, MEIStaffDef> staffDefs;

    public MEIImporter() {
        coreObjectBuilderSuppliers.add("score", MEIScoreBuilder::new);
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
        coreObjectBuilderSuppliers.add("rest", MEIRestBuilder::new);
        coreObjectBuilderSuppliers.add("accid", MEIAlterationBuilder::new);

        coreObjectBuilderSuppliers.add("beam", MEIBeamBuilder::new);

        staffNumbers = new HashMap<>();
        pendingObjects = new LinkedList<>();
        score = ICoreAbstractFactory.getInstance().createScore(null);
        scoreGraph = score.getScoreGraph();
    }

    @Override
    public void validate(File fileToBeValidated) throws IMException {
        //RelaxNG.validate("http://music-encoding.org/schema/4.0.0/mei-all.rng", stream);
        XMLValidators.validateRelaxNG(this.getClass().getResourceAsStream("/schemata/mei/mei-all.rng"), fileToBeValidated);
    }

    private void importStaffDefs(IStaffGroup parent, MEISystemDef systemDef) {
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
            IScoreStaffSubgraph scoreStaffSubgraph = ICoreAbstractFactory.getInstance().createScoreStaffSubgraph(staff);
            scoreGraph.addStaffSubgraph(scoreStaffSubgraph);
            staffNumbers.put(meiStaffDef.getN(), scoreStaffSubgraph);
            importStaffDefStaff(meiStaffDef, scoreStaffSubgraph);
        } else if (systemDef instanceof MEIStaffGroupDef) {
            MEIStaffGroupDef meiStaffGroupDef = (MEIStaffGroupDef) systemDef;
            IStaffGroup staffGroup;
            if (parent == null) {
                staffGroup = ICoreAbstractFactory.getInstance().createStaffGroup(score, null);
            } else {
                staffGroup = ICoreAbstractFactory.getInstance().createStaffGroup(parent, null);
            }
            for (MEISystemDef child: meiStaffGroupDef.getChildren()) {
                importStaffDefs(staffGroup, child);
            }
        }
    }


    private void importScoreDef(MEIScoreDef scoreDef) {
        if (scoreDef.getMeiStaffGroupDef() != null) {
            importStaffDefs(null, scoreDef.getMeiStaffGroupDef());
        }

        Optional<IMeter> meter = scoreDef.getMeter();
        if (meter.isPresent()) {
            pendingObjects.add(new Pair<>(null, meter.get()));
        }
        Optional<IKey> key = scoreDef.getKey();
        if (key.isPresent()) {
            pendingObjects.add(new Pair<>(null, key.get()));
        } else { // else because in the case of importing both key and key signature (it should'n happen) we prefer the key (that is a key signature with a mode)
            Optional<IConventionalKeySignature> conventionalKeySignature = scoreDef.getConventionalKeySignature();
            if (conventionalKeySignature.isPresent()) {
                pendingObjects.add(new Pair<>(null, conventionalKeySignature.get()));
            }
        }
    }


    private void importStaffDefStaff(MEIStaffDef meiStaffDef, IScoreStaffSubgraph scoreStaffSubgraph) {
        if (meiStaffDef.getClef().isPresent()) {
            pendingObjects.add(new Pair<>(scoreStaffSubgraph, meiStaffDef.getClef().get()));
        }
        if (meiStaffDef.getMeter().isPresent()) {
            pendingObjects.add(new Pair<>(scoreStaffSubgraph, meiStaffDef.getMeter().get()));
        }

        if (meiStaffDef.getKey().isPresent()) {
            pendingObjects.add(new Pair<>(scoreStaffSubgraph, meiStaffDef.getKey().get()));
        } else { // else because in the case of importing both key and key signature (it should'n happen) we prefer the key (that is a key signature with a mode)
            Optional<IConventionalKeySignature> conventionalKeySignature = meiStaffDef.getConventionalKeySignature();
            if (conventionalKeySignature.isPresent()) {
                pendingObjects.add(new Pair<>(scoreStaffSubgraph, conventionalKeySignature.get()));
            }
        }

    }



    @Override
    protected IScore buildScore() throws IMException {
        // TODO now everything goes to a part
        if (meiScore == null) {
            throw new IMException("Top meiScore (generated from <score> element) not found");
        }

        for (MEISection meiSection: meiScore.getSections()) {
            importSection(meiSection);
        }
        try {
            score.getScoreGraph().printDot(new File("/tmp/grafo.dot")); //TODO Quitar
        } catch (FileNotFoundException e) {
            throw new IMException(e);
        }
        return score;
    }

    private void importSection(MEISection section) throws IMException {
        for (IMeiSectionItem meiSectionItem: section.getSectionItems()) {
            if (meiSectionItem instanceof MEIScoreDef) {
                importScoreDef((MEIScoreDef)meiSectionItem);
            } else if (meiSectionItem instanceof MEIMeasure) {
                importMeasure((MEIMeasure)meiSectionItem);
            } else if (meiSectionItem instanceof MEISection) {
                importSection((MEISection) meiSectionItem); //TODO How are they hierarchically linked?
            } else {
                throw new IMException("Unsupported IMeiSectionItem meiSectionItem subclass: " + meiSectionItem.getClass());
            }
        }
    }

    private void importMeasure(MEIMeasure meiMeasure) throws IMException {
        IMeasure measure = ICoreAbstractFactory.getInstance().createMeasure(meiMeasure.getId(),
                meiMeasure.getNumber().isPresent() ? meiMeasure.getNumber().get() : null,
                meiMeasure.getLeftBarline().isPresent() ? meiMeasure.getLeftBarline().get() : null,
                meiMeasure.getRightBarline().isPresent() ? meiMeasure.getRightBarline().get() : null);

        scoreGraph.addCommonContentNode(measure);

        // pending objects defined before the measure and belonging specifically to a staff
        for (MEIStaff measureStaff : meiMeasure.getStaves()) {
            IScoreStaffSubgraph staffSubgraph = this.staffNumbers.get(measureStaff.getN());
            if (staffSubgraph == null) {
                throw new IMException("Staff with N=" + measureStaff.getN() + " not previously defined");
            }
            // pending objects defined before the measure and belonging specifically to a staff
            for (Iterator<Pair<IScoreStaffSubgraph, IMooObject>> iterator = pendingObjects.listIterator(); iterator.hasNext(); ) {
                Pair<IScoreStaffSubgraph, IMooObject> pair = iterator.next();
                if (pair.getLeft() == staffSubgraph) {
                    scoreGraph.addContentNode(staffSubgraph, pair.getRight());
                    iterator.remove();
                }
            }
        }


        // pending objects defined before the measure and not belonging specifically to any staff
        for (Iterator<Pair<IScoreStaffSubgraph, IMooObject>> iterator = pendingObjects.listIterator(); iterator.hasNext(); ) {
            Pair<IScoreStaffSubgraph, IMooObject> pair = iterator.next();
            if (pair.getLeft() == null) {
                scoreGraph.addCommonContentNode(pair.getRight());
                iterator.remove();
            }
        }

        if (!pendingObjects.isEmpty()) {
            throw new IMRuntimeException("The pending objects list should be empty");
        }

        // not measure contents are inserted
        for (MEIStaff measureStaff : meiMeasure.getStaves()) {
            IScoreStaffSubgraph staffSubgraph = this.staffNumbers.get(measureStaff.getN());
            if (staffSubgraph == null) {
                throw new IMException("Staff with N=" + measureStaff.getN() + " not previously defined");
            }
            for (MEILayer layer : measureStaff.getLayers()) { //TODO ¿Layers - voices?
                for (IVoiced voiced : layer.getItems()) { //TODO Revisar el concepto de Voiced
                    scoreGraph.addContentNode(staffSubgraph, voiced);
                }
            }
        }
    }


    @Override
    protected void onEndElement(String elementName, Object end) {
        switch (elementName) {
            case "score":
                this.meiScore = (MEIScore) end;
                break;
        }
    }

}
