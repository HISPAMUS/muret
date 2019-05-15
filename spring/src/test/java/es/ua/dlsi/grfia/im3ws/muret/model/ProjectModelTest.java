package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Notation;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Renderer;
import es.ua.dlsi.grfia.im3ws.muret.entity.BoundingBox;
import es.ua.dlsi.grfia.im3ws.muret.entity.ManuscriptType;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.MensuralAgnostic2SemanticTransducer;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.TestFileUtils;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.ScoreSong;
import es.ua.dlsi.im3.core.score.io.kern.KernExporter;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import es.ua.dlsi.im3.omr.encoding.semantic.Semantic2IMCore;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class ProjectModelTest {

    @Test
    public void transductionTest() throws IM3Exception, IOException {
        MURETConfiguration muretConfiguration =
                new MURETConfiguration(null, null, TestFileUtils.createTempFolder("muretprojectmodel").getAbsolutePath(),  null, 0, 0, true);

        ProjectModel projectModel = new ProjectModel(null, null, muretConfiguration);

        Project project = new Project();
        project.setName("Semantic test");
        project.setNotationType(NotationType.eMensural);
        project.setId(1973);
        project.setPath("semantic_test");
        project.setManuscriptType(ManuscriptType.ePrinted);

        projectModel.delete(project);

        String partName = "Tiple";
        projectModel.addPart(project, partName);

        // --- create agnostic sequences
        ArrayList<AgnosticEncoding> agnosticEncodings = new ArrayList<>();

        String [][] agnosticSequences = new String[][] {
                {"clef.G:L2", "metersign.Ct:L3", "rest.half:L4", "note.whole:S4", "note.half_down:L5", "note.whole:S4", "dot:S4"},
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
            AgnosticEncoding agnosticEncoding = new AgnosticEncoding();
            for (String s: agnosticSequence) {
                agnosticEncoding.add(AgnosticSymbol.parseAgnosticString(AgnosticVersion.v2, s));
            }
            agnosticEncodings.add(agnosticEncoding);
        }

        // convert
        int i=0;
        MensuralAgnostic2SemanticTransducer transducer = new MensuralAgnostic2SemanticTransducer();
        for (AgnosticEncoding agnosticEncoding: agnosticEncodings) {
            SemanticTransduction transduction = transducer.transduce(agnosticEncoding);
            assertTrue("Not empty", !transduction.getSemanticEncoding().getSymbols().isEmpty());

            transduction.getSemanticEncoding().getSymbols().forEach(semanticSymbol -> System.out.println(semanticSymbol.toSemanticString()));

            projectModel.addSemanticTransduction(project, partName, regionIDS[i], boundingBoxes[i], transduction.getSemanticEncoding());

            Notation notationPrinted = projectModel.render(project, partName, regionIDS[i], NotationType.eMensural, ManuscriptType.ePrinted, false, Renderer.verovio);
            Files.write(Paths.get("/tmp", "staff_" + i + ".mei"), Collections.singleton(notationPrinted.getContent()));
            i++;
        }

        //TODO renderizar ahora sólo un pentagrama

        /*

        ProjectScoreSong projectScoreSong = projectModel.getProjectScoreSong(project);
        ProjectScoreSongPart projectScorePart = projectScoreSong.getScorePart("Tiple");


        projectModel.getProjectScoreSong()

        ArrayList<AgnosticEncoding> agnosticEncodings = new ArrayList<>();

        String [][] agnosticSequences = new String[][] {
                {"clef.G:L2", "metersign.Ct:L3", "rest.half:L4", "note.whole:S4", "note.half_down:L5", "note.whole:S4", "dot:S4",}
                {"note.whole:L5", "note.half_down:S4", "note.whole:L4", "accidental.sharp:S1", "note.whole:S3",} //TODO ¿Qué pasa cuando el sostenido está desplazado?
                {"rest.longa2:L2", "rest.longa2:L2", "rest.longa2:L3", "rest.whole:L5", "note.half_down:S3", "dot:S3",}
                {"note.quarter_down:L4", "note.quarter_down:S4", "note.quarter_down:S3", "note.half_down:L5", "dot:S5",}
                {"note.quarter_down:L4", "custos:S5"}
        };

        for (String [] agnosticSequence: agnosticSequences) {
            AgnosticEncoding agnosticEncoding = new AgnosticEncoding();
            for (String s: agnosticSequence) {
                agnosticEncoding.add(AgnosticSymbol.parseAgnosticString(AgnosticVersion.v2, s));
            }
            agnosticEncodings.add(agnosticEncoding);
        }



        SemanticTransduction transduction = transducer.transduce(agnosticEncoding);
        System.out.println("P=" + transduction.getProbability());
        transduction.getSemanticEncoding().getSymbols().forEach(semanticSymbol -> System.out.println(semanticSymbol.toSemanticString()));

        ScoreSong song = transducer.semantic2IMCore(null, null, transduction.getSemanticEncoding());

        SemanticRepresentationModel semanticRepresentationModel = new SemanticRepresentationModel(null);
        ProjectModel projectModel = new ProjectModel(null, null, null);
        Notation notationPrinted = projectModel.render(song, NotationType.eMensural, ManuscriptType.ePrinted, false, Renderer.verovio);
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
