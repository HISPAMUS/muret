package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.io.IExporter;
import es.ua.dlsi.grfia.moosicae.utils.xml.XMLElement;
import es.ua.dlsi.grfia.moosicae.utils.xml.XMLPreambleElement;
import es.ua.dlsi.grfia.moosicae.utils.xml.XMLTree;

import java.util.Optional;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class MEIExporter implements IExporter {
    public MEIExporter() {

    }



    @Override
    public String exportScore(IScore score) {
        XMLTree xmlTree = new XMLTree("mei");
        xmlTree.getRoot().addAttribute("xmlns", "http://www.music-encoding.org/ns/mei");
        xmlTree.getRoot().addAttribute("meiversion", "4.0.0");
        XMLPreambleElement xmlVersion = new XMLPreambleElement("xml");
        xmlVersion.addAttribute("version", "1.0");
        xmlTree.addPreamble(xmlVersion);

        XMLPreambleElement namespace = new XMLPreambleElement("xml-model");
        namespace.addAttribute("href", "http://music-encoding.org/schema/4.0.0/mei-all.rng");
        namespace.addAttribute("type", "application/xml");
        namespace.addAttribute("schematypens", "http://relaxng.org/ns/structure/1.0");
        xmlTree.addPreamble(namespace);

        XMLPreambleElement schematron = new XMLPreambleElement("xml-model");
        schematron.addAttribute("href", "http://music-encoding.org/schema/4.0.0/mei-all.rng");
        schematron.addAttribute("type", "application/xml");
        schematron.addAttribute("schematypens", "http://purl.oclc.org/dsdl/schematron");
        xmlTree.addPreamble(schematron);

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
        for (IStaffElement staffSymbol: staff.getStaffSymbols()) {
            /*if (staffSymbol instanceof ISymbolInStaff &&
                    type.isInstance(((ISymbolInStaff) staffSymbol).getSymbol())) {
                return (Optional<T>) Optional.of((T) ((ISymbolInStaff) staffSymbol).getSymbol());
            }*/

            if (staffSymbol instanceof IStaffElementOfSymbol) {
                ISymbol symbol = ((IStaffElementOfSymbol) staffSymbol).getSymbol();
                if (type.isAssignableFrom(symbol.getClass())) {
                    return (Optional<T>) Optional.of(symbol);
                }
            }
        }
        return Optional.empty();
    }

    private <T> Optional<T> getCommonBeginning(IScore score, Class<T> type) {
        T last = null;
        //TODO anidado
        for (IStaff staff: score.getAllStaves()) {
            Optional<T> staffFirst = findFirst(staff, type);
            if (!staffFirst.isPresent()) {
                return Optional.empty();
            }

            if (last == null) {
                last = staffFirst.get();
            } else if (!last.equals(staffFirst.get())) {
                return Optional.empty();
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
        export(xmlScoreDef, score.getSystemElements());
    }

    private void export(XMLElement xmlScoreDef, ISystemElement[] systemElements) {
        XMLElement xmlStaffGrp = xmlScoreDef.addChild("staffGrp"); // TODO anidado
        for (ISystemElement staffOurGroup : systemElements) {
            IStaff [] staves = staffOurGroup.getStaves();
            for (IStaff staff : staves) {
                exportDef(xmlStaffGrp, staff);
            }
        }
    }

    private void exportDef(XMLElement xmlStaffGrp, IStaff staff) {
        //TODO - cosas como compases especiales, transposiciones.... - habrá que indicar qué compases se han exportado ya (common...)
        //TODO Debemos guardar la equivalencia de nº de staff
        XMLElement xmlStaffDef = xmlStaffGrp.addChild("staffDef");
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
