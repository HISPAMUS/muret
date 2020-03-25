package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IStaffLineCount;
import es.ua.dlsi.grfia.moosicae.io.IImporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders.*;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.*;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporter;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Use StAX for parsing
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/03/2020
 */
public class MusicXMLImporter extends XMLImporter implements IImporter {

    private MxmlScorePartWise mxmlScorePartWise;

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

        coreObjectBuilderSuppliers.add("key", MxmlKeyBuilder::new);
        coreObjectBuilderSuppliers.add("fifths", MxmlFifthsBuilder::new);

        coreObjectBuilderSuppliers.add("mode", MxmlModeBuilder::new);

        coreObjectBuilderSuppliers.add("time", MxmTimeSignatureBuilder::new);
        coreObjectBuilderSuppliers.add("beats", MxmlTimeSignatureNumeratorBuilder::new);
        coreObjectBuilderSuppliers.add("beat-type", MxmlTimeSignatureDenominatorBuilder::new);

        coreObjectBuilderSuppliers.add("note", MxmlNoteBuilder::new);
        coreObjectBuilderSuppliers.add("pitch", MxmlPitchBuilder::new);
        coreObjectBuilderSuppliers.add("octave", MxmlOctaveBuilder::new);
        coreObjectBuilderSuppliers.add("step", MxmlDiatonicPitchBuilder::new);
        coreObjectBuilderSuppliers.add("alter", MxmAlterationBuilder::new);

        coreObjectBuilderSuppliers.add("duration", MxmlFigureBuilder::new);

    }

    @Override
    protected void onEndElement(String elementName, Object coreObject) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Parsed element {0} into object {1} = {2}", new Object[] { elementName, coreObject.getClass().getName(), coreObject });
        switch (elementName) {
            case "score-partwise":
                mxmlScorePartWise = (MxmlScorePartWise) coreObject;
                break;
        }
    }

    @Override
    protected IScore buildScore() throws IMException {
        IScore score = coreAbstractFactory.createScore(coreAbstractFactory.createId());
        // now build the score from all parts
        if (mxmlScorePartWise == null) {
            throw new IMException("No mxmlScorePartWise object found"); // see onEndElement
        }

        HashMap<IId, IPart> partHashMap = new HashMap<>();
        for (IPart part: mxmlScorePartWise.getCoreParts()) {
            partHashMap.put(part.getId(), part);
            score.add(part);
        }

        for (MxmlPartContents mxmlImportedPart : mxmlScorePartWise.getMxmlPartsContents()) {
            IPart part = partHashMap.get(mxmlImportedPart.getId());
            if (part == null) {
                throw new IMException("There is a <part> with id='" + mxmlImportedPart.getId() + "' not defined in part-list");
            }

            //TODO voices, staves
            IStaffLineCount staffLineCount = coreAbstractFactory.createStaffLineCount(5);
            IVoice defaultVoice = coreAbstractFactory.createVoice(part, coreAbstractFactory.createId(), null);
            IStaff defaultStaff = coreAbstractFactory.createStaff(score, coreAbstractFactory.createId(), staffLineCount);
            for (MxmlMeasure measure : mxmlImportedPart.getMeasures()) {
                for (IMxmlPartItem item: measure.getItems()) {
                    ICoreItem[] subitems = item.getItems(); //TODO sacar los datos adicionales del MusicXMLNote como es la staff...
                    for (ICoreItem coreItem: subitems) {
                        score.add(defaultVoice, defaultStaff, coreItem);
                    }
                }
                //TODO parámetros barline
                IBarline barline = coreAbstractFactory.createBarline(coreAbstractFactory.createId(), null, null);
                score.add(defaultVoice, defaultStaff, barline);
            }

        }
        return score;
    }
}
