package es.ua.dlsi.grfia.im4.io.mei;

import es.ua.dlsi.grfia.im4.core.*;
import es.ua.dlsi.grfia.im4.io.IExporter;
import es.ua.dlsi.grfia.im4.utils.xml.XMLElement;
import es.ua.dlsi.grfia.im4.utils.xml.XMLPreambleElement;
import es.ua.dlsi.grfia.im4.utils.xml.XMLTree;

import java.util.Optional;

public class MEIExporter implements IExporter {
    private final XMLTree xmlTree;

    public MEIExporter() {
        this.xmlTree = new XMLTree("mei");
        this.xmlTree.getRoot().addAttribute("xmlns", "http://www.music-encoding.org/ns/mei");
        this.xmlTree.getRoot().addAttribute("meiversion", "4.0.0");
        XMLPreambleElement xmlVersion = new XMLPreambleElement("xml");
        xmlVersion.addAttribute("version", "1.0");
        this.xmlTree.addPreamble(xmlVersion);

        XMLPreambleElement namespace = new XMLPreambleElement("xml-model");
        namespace.addAttribute("href", "http://music-encoding.org/schema/4.0.0/mei-all.rng");
        namespace.addAttribute("type", "application/xml");
        namespace.addAttribute("schematypens", "http://relaxng.org/ns/structure/1.0");
        this.xmlTree.addPreamble(namespace);

        XMLPreambleElement schematron = new XMLPreambleElement("xml-model");
        schematron.addAttribute("href", "http://music-encoding.org/schema/4.0.0/mei-all.rng");
        schematron.addAttribute("type", "application/xml");
        schematron.addAttribute("schematypens", "http://purl.oclc.org/dsdl/schematron");
        this.xmlTree.addPreamble(schematron);
    }



    @Override
    public String exportScore(IScore score) {
        exportHeader(score.getMetadata());

        XMLElement xmlScore = xmlTree.getRoot().addChild("music").addChild("body").addChild("score");

        exportScoreDef(xmlScore, score);

        /*// for
        IClef clef = null; // ....
        XMLElement xmlElement = null;
        MEIExporterContext meiExporterContext = null;
        /// clef.export(meiExporterVisitor, meiExporterContext);*/
        return xmlTree.toString();
    }

    private <T> Optional<T> findFirst(IStaff staff, Class<T> type) {
        for (IStaffSymbol staffSymbol: staff.getStaffSymbols()) {
            if (staffSymbol instanceof ISymbolInStaff &&
                    type.isInstance(((ISymbolInStaff) staffSymbol).getSymbol())) {
                return (Optional<T>) Optional.of((T) ((ISymbolInStaff) staffSymbol).getSymbol());
            }
        }
        return Optional.empty();
    }

    private <T> Optional<T> getCommonBeginning(IScore score, Class<T> type) {
        T last = null;
        for (IStaves staves: score.getStaves()) {
            for (IStaff staff: staves.getStaves()) {
                Optional<T> staffFirst = findFirst(staff, type);
                if (staffFirst == null) {
                    return Optional.empty();
                }

                if (last == null) {
                    last = staffFirst.get();
                } else if (!last.equals(staffFirst.get())) {
                    return Optional.empty();
                }
            }
        }
        if (last == null) {
            return Optional.empty();
        } else {
            return Optional.of(last);
        }
    }


    private void exportScoreDef(XMLElement xmlScore, IScore score) {
        XMLElement xmlScoreDef = xmlScore.addChild("scoreDef");
        Optional<IMeter> commonBeginningMeter = getCommonBeginning(score, IMeter.class);
        if (commonBeginningMeter.isPresent()) {
            export(xmlScoreDef, commonBeginningMeter.get(), true);
        }

        Optional<IKey> commonBeginningKey = getCommonBeginning(score, IKey.class);
        if (commonBeginningKey.isPresent()) {
            export(xmlScoreDef, commonBeginningKey.get(), true);
        }

        //TODO - gropus
        export(xmlScoreDef, score.getStaves());
    }

    private void export(XMLElement xmlScoreDef, IStaves[] scoreStaves) {
        XMLElement xmlStaffGrp = xmlScoreDef.addChild("staffGrp");
        for (IStaves staves : scoreStaves) {
            for (IStaff staff : staves.getStaves()) {
                exportDef(xmlStaffGrp, staff);
            }
        }
    }

    private void exportDef(XMLElement xmlStaffGrp, IStaff staff) {
        //TODO - cosas como compases especiales, transposiciones.... - habrá que indicar qué compases se han exportado ya (common...)
        //TODO Debemos guardar la equivalencia de nº de staff
        XMLElement xmlStaffDef = new XMLElement("staffDef");
        xmlStaffDef.addAttribute("n", "1").
                addAttribute("lines", "5");

        Optional<IClef> firstClef = findFirst(staff, IClef.class);
        if (firstClef.isPresent()) {
            export(xmlStaffDef, firstClef.get(), true);
        }
    }

    private void export(XMLElement xmlScoreDef, IClef clef, boolean exportAsAttributes) {
        //TODO
        if (exportAsAttributes) {
            xmlScoreDef.addAttribute("clef.line", Integer.toString(clef.getLine()));
            xmlScoreDef.addAttribute("clef.shape", "G"); //TODO - Ahora está ClefSigns, debería ser Interface?
        }
    }


    private void export(XMLElement xmlScoreDef, IMeter meter, boolean exportAsAttributes) {
        //TODO
        if (exportAsAttributes) {
            xmlScoreDef.addAttribute("meter.count", "6");
            xmlScoreDef.addAttribute("meter.unit", "8");
        }
    }


    private void export(XMLElement xmlScoreDef, IKey key, boolean exportAsAttributes) {
        //TODO
        if (exportAsAttributes) {
            xmlScoreDef.addAttribute("key.sig", "1f");
        }
    }


    private void exportHeader(IMetadata metadata) {
        XMLElement xmlMeiHead = new XMLElement("meiHead");
        XMLElement xmlFileDesc = new XMLElement("fileDesc");
        xmlMeiHead.addChild(xmlFileDesc);

        XMLElement xmlTitleStmt = new XMLElement("titleStmt");
        xmlFileDesc.addChild(xmlTitleStmt);

        XMLElement xmlTitle = new XMLElement("title",  "Prueba"); // david metadata.getTitle().getTitle());
        xmlTitleStmt.addChild(xmlTitle);
    }

}
