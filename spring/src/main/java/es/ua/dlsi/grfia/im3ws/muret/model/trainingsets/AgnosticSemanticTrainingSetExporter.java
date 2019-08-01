package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.*;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.io.ExportException;
import es.ua.dlsi.im3.core.score.Segment;
import es.ua.dlsi.im3.core.score.Staff;
import es.ua.dlsi.im3.core.utils.FileCompressors;
import es.ua.dlsi.im3.omr.encoding.Encoder;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticExporter;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import es.ua.dlsi.im3.omr.encoding.semantic.KernSemanticExporter;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticExporter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It exports a set of json files, one for each project
 */
public class AgnosticSemanticTrainingSetExporter extends AbstractTrainingSetExporter {
    private final ProjectModel projectModel;

    public AgnosticSemanticTrainingSetExporter(int id, ProjectModel projectModel) {
        super(id, "Agnostic-semantic", "Exports pairs agnostic-semantic in JSON files (one for each project)", false);
        this.projectModel = projectModel;
    }

    @Override
    public Path generate(Path muretFolder, Collection<Project> projectCollection) throws ExportException {
        try {
            Path directory = Files.createTempDirectory("json_agnostic_semantic_pairs");

            for (Project project : projectCollection) {
                File jsonFile = new File(directory.toFile(), project.getPath() + ".json");
                //ProjectScoreSong projectScoreSong = projectModel.getProjectScoreSong(project);
                //export(projectScoreSong, jsonFile);
                export(project, jsonFile);
            }

            File resultTGZ = File.createTempFile("json_agnostic_semantic_pairs", ".tar.gz");
            FileCompressors fileCompressors = new FileCompressors();
            fileCompressors.tgzFolder(resultTGZ.toPath(), directory);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Generated tgz {0}", resultTGZ);
            return resultTGZ.toPath();

        } catch (Exception e) {
            throw new ExportException(e);
        }
    }

    /**
     * @deprecated
     * @param projectScoreSong
     * @param outputJSonFile
     * @throws IOException
     * @throws IM3Exception
     */
    private void export(ProjectScoreSong projectScoreSong, File outputJSonFile) throws IOException, IM3Exception {
        JSONObject projectJSON = new JSONObject();
        JSONArray jsonSystems = new JSONArray();

        for (ProjectScoreSongPart projectScoreSongPart: projectScoreSong.getScoreParts()) {
            //TODO esto va sólo para un pentagrama
            if (projectScoreSongPart.getScorePart().getStaves().size() > 1) {
                throw new IM3Exception("Cannot work yet with multiple staff parts");
            }
            if (!projectScoreSongPart.getScorePart().getStaves().isEmpty()) {
                JSONObject systemJSON = new JSONObject();
                Staff scoreStaff = projectScoreSongPart.getScorePart().getStaves().get(0);
                for (ProjectScoreSongSystem projectScoreSongSystem : projectScoreSongPart.getSystems()) {
                    Encoder encoder = new Encoder(AgnosticVersion.v2, false);
                    encoder.encode(scoreStaff, new Segment(projectScoreSongSystem.getFrom(), projectScoreSongSystem.getTo()));
                    AgnosticExporter agnosticExporter = new AgnosticExporter(AgnosticVersion.v2);
                    SemanticExporter semanticExporter = new SemanticExporter();

                    systemJSON.put("region_id", projectScoreSongSystem.getSystemBeginning().getFacsimileElementID());
                    systemJSON.put("agnostic", agnosticExporter.export(encoder.getAgnosticEncoding()));
                    systemJSON.put("semantic", agnosticExporter.export(encoder.getAgnosticEncoding()));
                    jsonSystems.add(systemJSON);
                }
            }
        }
        projectJSON.put("systems", jsonSystems);


        FileWriter file = new FileWriter(outputJSonFile);
        String jsonString = projectJSON.toJSONString();
        file.write(jsonString);
        file.close();
    }

    private void export(Project project, File outputJSonFile) throws IOException, IM3Exception {
        JSONObject projectJSON = new JSONObject();
        JSONArray jsonSystems = new JSONArray();

        for (Image image: project.getImages()) {
            for (Page page: image.getPages()) {
                for (Region region: page.getRegions()) {
                    if (region.getSymbols() != null && !region.getSymbols().isEmpty() && region.getSemanticEncoding() != null) {
                        JSONObject systemJSON = new JSONObject();

                        ArrayList<Symbol> symbolArrayList = new ArrayList<>(region.getSymbols());
                        symbolArrayList.sort(Symbol.getHorizontalPositionComparator());

                        AgnosticEncoding agnostic = SemanticRepresentationModel.region2Agnostic(region, true);
                        AgnosticExporter agnosticExporter = new AgnosticExporter(AgnosticVersion.v2);
                        String agnosticSequence = agnosticExporter.export(agnostic);

                        systemJSON.put("region_id", region.getId());
                        systemJSON.put("agnostic", agnosticSequence);
                        systemJSON.put("semantic", removeIDS(region.getSemanticEncoding()));
                        jsonSystems.add(systemJSON);

                    }
                }
            }
        }

        projectJSON.put("regions", jsonSystems);


        FileWriter file = new FileWriter(outputJSonFile);
        String jsonString = projectJSON.toJSONString();
        file.write(jsonString);
        file.close();
    }

    private String removeIDS(String semanticWithIDS) {
        StringBuilder stringBuilder = new StringBuilder();
        String [] tokens = semanticWithIDS.split(Character.toString(KernSemanticExporter.TOKEN_SEPARATOR));
        for (String tokenWithID: tokens) {
            String [] elements = tokenWithID.split(KernSemanticExporter.IDS_SEPARATOR);
            stringBuilder.append(elements[0]);
            stringBuilder.append(KernSemanticExporter.TOKEN_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
