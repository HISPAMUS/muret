package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.IExporter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLExporterVisitorParam;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLParamExportMode;
import es.ua.dlsi.grfia.moosicae.utils.xml.DTDDeclaration;
import es.ua.dlsi.grfia.moosicae.utils.xml.XMLElement;
import es.ua.dlsi.grfia.moosicae.utils.xml.XMLPreambleElement;
import es.ua.dlsi.grfia.moosicae.utils.xml.XMLTree;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class MusicXMLExporter implements IExporter {
    public static final String CONTEXT_LAST_KEY_SIGNATURE = "lastKeySignature";

    private MusicXMLExporterVisitor musicXMLExporterVisitor;
    private MxmlPartIDs mxmlPartIDs;

    public MusicXMLExporter() {
        musicXMLExporterVisitor = new MusicXMLExporterVisitor();
    }

    @Override
    public String exportScore(IScore score) throws IMException {
        mxmlPartIDs = new MxmlPartIDs();
        DTDDeclaration dtdDeclaration = new DTDDeclaration(
        "score-partwise", "PUBLIC", "-//Recordare//DTD MusicXML 3.1 Partwise//EN", "http://www.musicxml.org/dtds/partwise.dtd"
        );
        XMLTree xmlTree = new XMLTree("score-partwise", dtdDeclaration);
        xmlTree.getRoot().addAttribute("version", "3.1");

        XMLPreambleElement xmlVersion = new XMLPreambleElement("xml");
        xmlVersion.addAttribute("version", "1.0");
        xmlVersion.addAttribute("encoding", "UTF-8");
        xmlTree.addPreamble(xmlVersion);

        XMLElement xmlScore = xmlTree.getRoot();
        exportPartDefinitions(score, xmlScore);
        exportParts(score, xmlScore);

        return xmlTree.toString();
    }

    private void exportPartDefinitions(IScore score, XMLElement xmlScore) {
        XMLElement xmlPartList = xmlScore.addChild("part-list");
        for (IPart part: score.getParts()) {
            XMLElement xmlPart = xmlPartList.addChild("score-part");
            xmlPart.addAttribute("id", mxmlPartIDs.getID(part));
            if (part.getName().isPresent()) {
                xmlPart.addChild("part-name", part.getName().get().getValue());
            }
        }
    }

    // used to sort the elements inside the attributes element to conform MusicXML schema
    private static HashMap<String, Integer> ATTRIBUTE_ELEMENT_CHILDREN_ORDER;
    {
        ATTRIBUTE_ELEMENT_CHILDREN_ORDER = new HashMap<>();
        ATTRIBUTE_ELEMENT_CHILDREN_ORDER.put("divisions", 0);
        ATTRIBUTE_ELEMENT_CHILDREN_ORDER.put("key", 1);
        ATTRIBUTE_ELEMENT_CHILDREN_ORDER.put("time", 2);
        ATTRIBUTE_ELEMENT_CHILDREN_ORDER.put("clef", 3);
    }


    private void exportParts(IScore score, XMLElement xmlScore) throws IMException {
        for (IPart part: score.getParts()) {
            IKey lastKey = null;
            IMeter lastMeter = null;
            XMLElement xmlPart = xmlScore.addChild("part");
            xmlPart.addAttribute("id", mxmlPartIDs.getID(part));

            //TODO measures
            XMLElement xmlMeasure = xmlPart.addChild("measure");
            xmlMeasure.addAttribute("number", "1");

            // add to the measure <attributes>
            XMLElement xmlAttributes = null;

            //if (primer measure TODO
            {
                xmlAttributes = xmlMeasure.addChild("attributes");
                xmlAttributes.addChild("divisions", Integer.toString(MusicXMLExporterVisitor.MAX_DUR));
            }


            boolean nonAttributesFound = false;
            //TODO ordenar por tiempos - ver qué staves pertenecen a partes
            for (IStaff staff: score.getAllStaves()) {
                IKeySignature lastKeySignature = null;
                for (ICoreItem staffElement: staff.getStaffSymbols()) {
                    XMLElement parentElement = xmlMeasure; // by default
                    if (staffElement instanceof INonDurational) {
                        if (!nonAttributesFound) {
                            // add to the measure <attributes>
                            if (xmlAttributes == null) {
                                xmlAttributes = xmlMeasure.addChild("attributes");
                            }
                            parentElement = xmlAttributes;
                        }

                    } else {
                        nonAttributesFound = true;
                    }

                    XMLExporterVisitorParam xmlExporterVisitorParam = new XMLExporterVisitorParam(XMLParamExportMode.element, parentElement);

                    if (lastKeySignature != null) {
                        xmlExporterVisitorParam.addProperty(CONTEXT_LAST_KEY_SIGNATURE, lastKeySignature);
                    }
                    staffElement.export(musicXMLExporterVisitor, xmlExporterVisitorParam);

                    if (staffElement instanceof IKeySignature) {
                        lastKeySignature = (IKeySignature) staffElement;
                    } else if (staffElement instanceof IKey) {
                        lastKeySignature = ((IKey) staffElement).getKeySignature();
                    }

                }
            }

            // not sort the xmlAttributes in otder to conform the MusicXML schema
            if (xmlAttributes != null) {
                xmlAttributes.sortElements(ATTRIBUTE_ELEMENT_CHILDREN_ORDER);
            }
        }
    }
}
