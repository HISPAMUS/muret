package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.entity.ManuscriptType;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.NotationType;
import org.junit.Test;

import java.io.IOException;

public class DocumentModelTest {

    private Document createProject() {
        Document document = new Document();
        document.setName("Semantic test");
        document.setNotationType(NotationType.eMensural);
        document.setId(1973);
        document.setPath("semantic_test");
        document.setManuscriptType(ManuscriptType.ePrinted);

        return document;
    }
    @Test
    public void transductionTest() throws IM3Exception, IOException, IM3WSException {
        //TODO
        /*MURETConfiguration muretConfiguration =
                new MURETConfiguration(null, null, TestFileUtils.createTempFolder("muretprojectmodel").getAbsolutePath(),  null, 0, 0, true);

        DocumentModel projectModel = new DocumentModel(null, null, muretConfiguration);

        Document document = createProject();
        projectModel.delete(document);

        String partName = "Tiple";
        projectModel.addPart(document, partName);

        // --- create agnostic sequences
        ArrayList<AgnosticEncoding> agnosticEncodings = new ArrayList<>();

        String [][] agnosticSequences = new String[][] {
                // TODO the ligature is intended not to be drawn currently
                {"clef.G:L2", "metersign.Ct:L3", "ligature:S4", "rest.half:L4", "note.whole:S4", "note.half_down:L5", "note.whole:S4", "dot:S4"},
                {"clef.G:L2", "note.whole:L5", "note.half_down:S4", "note.whole:L4", "accidental.sharp:S1", "note.whole:S3"}, //TODO ¿Qué pasa cuando el sostenido está desplazado?
                {"clef.G:L2", "rest.longa2:L2", "rest.longa2:L2", "rest.longa2:L3", "rest.whole:L5", "note.half_down:S3", "dot:S3"},
                {"clef.G:L2", "note.quarter_down:L4", "note.quarter_down:S4", "note.quarter_down:S3", "note.half_down:L5", "dot:S5"},
                {"clef.G:L2", "note.quarter_down:L4", "custos:S5"}
        };

        Long [] regionIDS = new Long[] {1L, 2L, 3L, 4L, 5L};

        BoundingBox [] boundingBoxes = new BoundingBox[] {
                new BoundingBox(0, 0, 150, 230),
                new BoundingBox(10, 10, 1150, 1230),
                new BoundingBox(20, 20, 2150, 2230),
                new BoundingBox(30, 30, 3150, 3230),
                new BoundingBox(40, 40, 4150, 4230)
        };

        for (String [] agnosticSequence: agnosticSequences) {
            AgnosticEncoding agnosticEncoding = new AgnosticEncoding(AgnosticVersion.v2, agnosticSequence);
            agnosticEncodings.add(agnosticEncoding);
        }

        // convert
        int i=0;
        MensuralAgnostic2SemanticTransducer transducer = new MensuralAgnostic2SemanticTransducer();
        for (AgnosticEncoding agnosticEncoding: agnosticEncodings) {
            SemanticTransduction transduction = transducer.transduce(agnosticEncoding);
            assertTrue("Not empty", !transduction.getSemanticEncoding().getSymbols().isEmpty());

            // transduction.getSemanticEncoding().getSymbols().forEach(semanticSymbol -> System.out.println(semanticSymbol.toSemanticString()));

            projectModel.addSemanticEncoding(document, partName, regionIDS[i], boundingBoxes[i], transduction.getSemanticEncoding());

            Notation notationPrinted = projectModel.render(document, partName, regionIDS[i], NotationType.eMensural, ManuscriptType.ePrinted, false, Renderer.verovio);
            Files.write(Paths.get("/tmp", "staff_" + i + ".mei"), Collections.singleton(notationPrinted.getContent()));
            i++;
        }


        // try to load it again - replace one region
        Document projectAgain = createProject();
        for (int j = 0; j<regionIDS.length; j++) {
            if (j == 1) {
                String [] newAgnosticSequence = {"clef.F:L4", "note.whole:L1", "note.whole:L2", "note.whole:L3", "note.whole:L4", "note.whole:L5"};
                SemanticTransduction transduction = transducer.transduce(new AgnosticEncoding(AgnosticVersion.v2, newAgnosticSequence));
                projectModel.addSemanticEncoding(document, partName, regionIDS[j], boundingBoxes[j], transduction.getSemanticEncoding());
            }

            Notation notationPrinted = projectModel.render(document, partName, regionIDS[j], NotationType.eMensural, ManuscriptType.ePrinted, false, Renderer.verovio);
            Files.write(Paths.get("/tmp", "staff_again_" + j + ".mei"), Collections.singleton(notationPrinted.getContent()));
        }*/


        /*Notation notationPrinted = projectModel.render(song, NotationType.eMensural, ManuscriptType.ePrinted, false, Renderer.verovio);
        Files.write(Paths.get("/tmp", "transduced-printed.mei"), Collections.singleton(notationPrinted.getContent()));

        Notation notationHandwritten = projectModel.render(song, NotationType.eMensural, ManuscriptType.eHandwritten, false, Renderer.im3);
        Files.write(Paths.get("/tmp", "transduced-handwritten.svg"), Collections.singleton(notationHandwritten.getContent()));

        KernExporter kernExporter = new KernExporter();
        kernExporter.exportSong(new File("/tmp/transduced.krn"), song);

        Notation notationHandwrittenMensustriche = projectModel.render(song, NotationType.eMensural, ManuscriptType.eHandwritten, true, Renderer.im3);
        Files.write(Paths.get("/tmp", "transduced-handwritten-mensustriche.svg"), Collections.singleton(notationHandwrittenMensustriche.getContent()));

        //TODO
        System.err.println("PROBAR A insertar desordenado!!!!!!!!!!!!!!!!!!!!");*/
    }
}
