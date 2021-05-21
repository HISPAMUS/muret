package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.INoteHead;
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
    private List<MEITie> pendingTies;
    private List<MEIMark> pendingMarks;
    private HashMap<IId, IMooObject> mooObjects; // used for linking elements
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
        coreObjectBuilderSuppliers.add("multiRest", MEIMultiRestBuilder::new);
        coreObjectBuilderSuppliers.add("accid", MEIAlterationBuilder::new);

        coreObjectBuilderSuppliers.add("beam", MEIBeamBuilder::new);
        coreObjectBuilderSuppliers.add("tie", MEITieBuilder::new);
        coreObjectBuilderSuppliers.add("fermata", MEIFermataBuilder::new);

        staffNumbers = new HashMap<>();
        pendingObjects = new LinkedList<>();
        pendingMarks = new LinkedList<>();
        mooObjects = new HashMap<>();
        pendingTies = new LinkedList<>();
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

        Optional<IKey> key = scoreDef.getKey();
        if (key.isPresent()) {
            pendingObjects.add(new Pair<>(null, key.get()));
        } else { // else because in the case of importing both key and key signature (it should'n happen) we prefer the key (that is a key signature with a mode)
            Optional<IConventionalKeySignature> conventionalKeySignature = scoreDef.getConventionalKeySignature();
            if (conventionalKeySignature.isPresent()) {
                pendingObjects.add(new Pair<>(null, conventionalKeySignature.get()));
            }
        }

        Optional<IMeter> meter = scoreDef.getMeter();
        if (meter.isPresent()) {
            pendingObjects.add(new Pair<>(null, meter.get()));
        }
    }


    private void importStaffDefStaff(MEIStaffDef meiStaffDef, IScoreStaffSubgraph scoreStaffSubgraph) {
        if (meiStaffDef.getClef().isPresent()) {
            pendingObjects.add(new Pair<>(scoreStaffSubgraph, meiStaffDef.getClef().get()));
        }
        if (meiStaffDef.getKey().isPresent()) {
            pendingObjects.add(new Pair<>(scoreStaffSubgraph, meiStaffDef.getKey().get()));
        } else { // else because in the case of importing both key and key signature (it should'n happen) we prefer the key (that is a key signature with a mode)
            Optional<IConventionalKeySignature> conventionalKeySignature = meiStaffDef.getConventionalKeySignature();
            if (conventionalKeySignature.isPresent()) {
                pendingObjects.add(new Pair<>(scoreStaffSubgraph, conventionalKeySignature.get()));
            }
        }
        if (meiStaffDef.getMeter().isPresent()) {
            pendingObjects.add(new Pair<>(scoreStaffSubgraph, meiStaffDef.getMeter().get()));
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

        importTies();

        importMarks();

        /*try {
            score.getScoreGraph().printDot(new File("/tmp/grafo.dot"));
        } catch (FileNotFoundException e) {
            throw new IMException(e);
        }*/
        return score;
    }

    private void importMarks() throws IMException {
        for (MEIMark mark: pendingMarks) {
            IMooObject meiObject = findMooObject(mark.getStartId());
            if (!(meiObject instanceof IVoiced)) {
                throw new IMException("The id " + mark.getStartId() + " does not belong to a voiced object");
            }
            IVoiced voiced = (IVoiced) meiObject;
            mark.toMooObject(mark, voiced);
        }
        pendingMarks.clear();
    }

    private void importTies() throws IMException {
        for (MEITie meiTie: pendingTies) {
            linkTie(meiTie);
        }
        pendingTies.clear();
    }

    private IMooObject findMooObject(IId id) throws IMException {
        IMooObject mooObject = mooObjects.get(id);
        if (mooObject == null) {
            throw new IMException("Cannot find and object with id = " + id.getValue());
        }
        return mooObject;
    }
    private void linkTie(MEITie meiTie) throws IMException {
        IMooObject from = findMooObject(meiTie.getStartId());
        INoteHead fromNoteHead;
        if (from instanceof INote) {
            fromNoteHead = ((INote) from).getNoteHead();
        } else {
            throw new IMException("Expected a note for the tie and found " + from.getClass()); //TODO Chords
        }

        IMooObject to = findMooObject(meiTie.getEndId());
        INoteHead toNoteHead;
        if (to instanceof INote) {
            toNoteHead = ((INote) to).getNoteHead();
        } else {
            throw new IMException("Expected a note for the tie and found " + to.getClass()); //TODO Chords
        }

        fromNoteHead.tieTo(toNoteHead);
    }

    private void importSection(MEISection section) throws IMException {
        for (IMeiSectionItem meiSectionItem: section.getSectionItems()) {
            if (meiSectionItem instanceof MEIScoreDef) {
                importScoreDef((MEIScoreDef)meiSectionItem);
            } else if (meiSectionItem instanceof MEIMeasure) {
                importMeasure((MEIMeasure)meiSectionItem);
            } else if (meiSectionItem instanceof MEISection) {
                importSection((MEISection) meiSectionItem); //TODO How are they hierarchically linked?
            } else if (meiSectionItem instanceof MEITie) {
                pendingTies.add((MEITie) meiSectionItem);
            } else if (meiSectionItem instanceof MEIMark) {
                pendingMarks.add((MEIMark) meiSectionItem);
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
                    importItem(staffSubgraph, voiced);
                }
            }
        }
    }

    private void importItem(IScoreStaffSubgraph staffSubgraph, IVoiced voiced) {
        if (voiced instanceof IVoicedComposite) {
            for (IVoiced child: ((IVoicedComposite) voiced).getChildren()) {
                importItem(staffSubgraph, child);
            }
        } else {
            scoreGraph.addContentNode(staffSubgraph, voiced);
            mooObjects.put(voiced.getId(), voiced);
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
