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

            //if (primer measure
            {
                xmlAttributes = xmlMeasure.addChild("attributes");
                xmlAttributes.addChild("divisions", Integer.toString(MusicXMLExporterVisitor.MAX_DUR));
            }


            boolean nonAttributesFound = false;
            //TODO ordenar por tiempos - ver qué staves pertenecen a partes
            for (IStaff staff: score.getAllStaves()) {
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
                    staffElement.export(musicXMLExporterVisitor, xmlExporterVisitorParam);
                }
            }
        }
    }
}
