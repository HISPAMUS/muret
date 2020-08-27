package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IStaffLineCount;
import es.ua.dlsi.grfia.moosicae.io.IImporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders.*;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.*;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLValidators;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Use StAX for parsing
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/03/2020
 */
public class MusicXMLImporter extends XMLImporter implements IImporter {

    private MxmlScorePartWise mxmlScorePartWise;
    private MxmlPartIDs mxmlPartIDs;

    public MusicXMLImporter(ICoreAbstractFactory abstractFactory) {
        super(abstractFactory);
        coreObjectBuilderSuppliers.add("score-partwise", MxmlScorePartWiseBuilder::new);
        coreObjectBuilderSuppliers.add("score-part", MxmlPartDefinitionBuilder::new);
        coreObjectBuilderSuppliers.add("part-name", MxmlNameBuilder::new);
        coreObjectBuilderSuppliers.add("part", MxmlPartContentsBuilder::new);
        coreObjectBuilderSuppliers.add("measure", MxmlMeasureBuilder::new);
        coreObjectBuilderSuppliers.add("divisions", MxmlDivisionsBuilder::new);

        coreObjectBuilderSuppliers.add("attributes", MxmlAttributesBuilder::new);

        coreObjectBuilderSuppliers.add("clef", MxmlClefBuilder::new);
        coreObjectBuilderSuppliers.add("sign", MxmlClefSignBuilder::new);
        coreObjectBuilderSuppliers.add("line", MxmlClefLineBuilder::new);
        coreObjectBuilderSuppliers.add("clef-octave-change", MxmlClefOctaveTranspositionBuilder::new);

        coreObjectBuilderSuppliers.add("key", MusicXMLKeyOrKeySignatureBuilder::new);
        coreObjectBuilderSuppliers.add("fifths", MxmlFifthsBuilder::new);
        coreObjectBuilderSuppliers.add("key-step", MxmlDiatonicPitchBuilder::new);
        coreObjectBuilderSuppliers.add("key-alter", MxmAlterationBuilder::new);
        coreObjectBuilderSuppliers.add("cancel", MxmlKeyCancelBuilder::new);

        coreObjectBuilderSuppliers.add("mode", MxmlModeBuilder::new);

        coreObjectBuilderSuppliers.add("time", MxmTimeSignatureBuilder::new);
        coreObjectBuilderSuppliers.add("beats", MxmlTimeSignatureNumeratorBuilder::new);
        coreObjectBuilderSuppliers.add("beat-type", MxmlTimeSignatureDenominatorBuilder::new);
        coreObjectBuilderSuppliers.add("interchangeable", MxmTimeSignatureBuilder::new);

        coreObjectBuilderSuppliers.add("note", MxmlNoteBuilder::new);
        coreObjectBuilderSuppliers.add("pitch", MxmlPitchBuilder::new);
        coreObjectBuilderSuppliers.add("octave", MxmlOctaveBuilder::new);
        coreObjectBuilderSuppliers.add("step", MxmlDiatonicPitchBuilder::new);
        coreObjectBuilderSuppliers.add("alter", MxmAlterationBuilder::new);

        coreObjectBuilderSuppliers.add("duration", MxmlFigureBuilder::new);

    }

    @Override
    public void validate(File fileToBeValidated) throws IMException {
        try {
            InputStream musicXML = this.getClass().getResourceAsStream("/schemata/musicxml/musicxml.xsd");
            if (musicXML == null) {
                throw new IMException("Cannot find musicxml xsd");
            }
            InputStream xlink = this.getClass().getResourceAsStream("/schemata/musicxml/xlink.xsd");
            if (xlink == null) {
                throw new IMException("Cannot find xlink xsd");
            }
            InputStream xml = this.getClass().getResourceAsStream("/schemata/musicxml/xml.xsd");
            if (xml == null) {
                throw new IMException("Cannot find xml xsd");
            }
            XMLValidators.validateAgainstXSD(new InputStream[] {xml, xlink, musicXML}, fileToBeValidated, "partwise.dtd");
        } catch (Exception e) {
            throw new IMException("Not valid MusicXML file", e);
        }

        //

    }

    @Override
    protected void onEndElement(String elementName, Object coreObject) {
        switch (elementName) {
            case "score-partwise":
                mxmlScorePartWise = (MxmlScorePartWise) coreObject;
                break;
        }
    }

    @Override
    protected IScore buildScore() throws IMException {
        IScore score = coreAbstractFactory.createScore(null);
        mxmlPartIDs = new MxmlPartIDs();
        // now build the score from all parts
        if (mxmlScorePartWise == null) {
            throw new IMException("No mxmlScorePartWise object found"); // see onEndElement
        }

        HashMap<String, IPart> partHashMap = new HashMap<>();
        for (IPart part: mxmlScorePartWise.getCoreParts()) {
            partHashMap.put(mxmlPartIDs.getID(part), part);
            score.add(part);
        }

        for (MxmlPartContents mxmlImportedPart : mxmlScorePartWise.getMxmlPartsContents()) {
            IPart part = partHashMap.get(mxmlImportedPart.getId().get().getValue());
            if (part == null) {
                throw new IMException("There is a <part> with id='" + mxmlImportedPart.getId() + "' not defined in part-list");
            }

            //TODO voices, staves
            IStaffLineCount staffLineCount = coreAbstractFactory.createStaffLineCount(5);
            IVoice defaultVoice = coreAbstractFactory.createVoice(part, null, null);
            IStaff defaultStaff = coreAbstractFactory.createStaff(score, null, staffLineCount);
            for (MxmlMeasure measure : mxmlImportedPart.getMeasures()) {
                for (IMxmlPartItem item: measure.getItems()) {
                    IVoicedItem[] subitems = item.getItems(); //TODO sacar los datos adicionales del MusicXMLNote como es la staff...
                    for (IVoicedItem coreItem: subitems) {
                        score.add(defaultVoice, defaultStaff, coreItem);
                    }
                }
                //TODO parámetros barline
                IBarline barline = coreAbstractFactory.createBarline(null, null, null);
                score.add(defaultVoice, defaultStaff, barline);
            }

        }
        return score;
    }
}
