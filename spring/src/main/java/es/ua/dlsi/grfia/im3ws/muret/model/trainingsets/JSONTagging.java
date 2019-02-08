package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.muret.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.ProjectModel;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.TestFileUtils;
import es.ua.dlsi.im3.core.io.ExportException;
import es.ua.dlsi.im3.core.utils.FileCompressors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
public class JSONTagging extends AbstractTrainingSetExporter {
    private static final String FIELD_SEPARATOR = ";";
    private final boolean includeStrokes;

    @Autowired
    MURETConfiguration muretConfiguration;

    ProjectModel projectModel;

    public JSONTagging(int id, boolean includeStrokes) {
        super(id,
                includeStrokes?
                        "JSON files with images, pages, regions, symbols and strokes"
                        :"JSON files with images, pages, regions, symbols",
                "It generates a compressed file containing a folder for each project and a JSON file for each image with its relative file name. " +
                        "This JSON file encodes the bounding boxes of pages, regions, and symbols. For each region its region type is also exported. " +
                        "For each symbol both its agnostic encoding is appended and, if present, the strokes information"
                );
        projectModel = new ProjectModel();
        this.includeStrokes = includeStrokes;
    }

    @Override
    public Path generate(Path muretFolder, Collection<Project> projectCollection) throws ExportException {
        try {
            Path directory = Files.createTempDirectory("json_agnostic_symbol_images");
            for (Project project: projectCollection) {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Exporting project " + project.getName());

                for (Image image: project.getImages()) {
                    Logger.getLogger(this.getClass().getName()).log(Level.FINE, "Exporting JSON for image " + image.getFilename());
                    File outputJSonFile = new File(directory.toFile(), project.getName() + ".json");
                    generate(image, outputJSonFile);
                }
            }

            File resultTGZ = File.createTempFile("boundingboxes_pages_regions_symbols", ".tar.gz");
            FileCompressors fileCompressors = new FileCompressors();
            fileCompressors.tgzFolder(resultTGZ.toPath(), directory);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Generated tgz {0}", resultTGZ);
            return resultTGZ.toPath();
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot generate agnostic_symbol_images", e);
            throw new ExportException(e);
        }
    }

    private void putBoundingBox(JSONObject jsonObject, BoundingBox boundingBox) {
        JSONObject jsonBB = new JSONObject();
        jsonBB.put("fromX", boundingBox.getFromX());
        jsonBB.put("fromY", boundingBox.getFromY());
        jsonBB.put("toX", boundingBox.getToX());
        jsonBB.put("toY", boundingBox.getToY());
        jsonObject.put("bounding_box", jsonBB);
    }

    private void generate(Image image, File outputJSonFile) throws IOException {
        JSONObject jsonImage = new JSONObject();

        jsonImage.put("id", image.getId());
        jsonImage.put("filename", image.getFilename());

        if (image.getPages() != null && !image.getPages().isEmpty()) {
            JSONArray jsonPages = new JSONArray();
            jsonImage.put("pages", jsonPages);

            for (Page page : image.getPages()) {
                JSONObject jsonPage = new JSONObject();
                jsonPages.add(jsonPage);
                jsonPage.put("id", page.getId());
                putBoundingBox(jsonPage, page.getBoundingBox());

                if (page.getRegions()!=null && !page.getRegions().isEmpty()) {
                    JSONArray jsonRegions = new JSONArray();
                    jsonPage.put("regions", jsonRegions);
                    for (Region region : page.getRegions()) {
                        JSONObject jsonRegion = new JSONObject();
                        jsonRegions.add(jsonRegion);
                        jsonRegion.put("id", region.getId());
                        if (region.getRegionType() != null) {
                            jsonRegion.put("type", region.getRegionType().getName());
                        }
                        putBoundingBox(jsonRegion, region.getBoundingBox());

                        if (region.getSymbols() != null && !region.getSymbols().isEmpty()) {
                            JSONArray jsonSymbols = new JSONArray();
                            jsonRegion.put("symbols", jsonSymbols);

                            for (Symbol symbol : region.getSymbols()) {
                                JSONObject jsonSymbol = new JSONObject();
                                jsonSymbols.add(jsonSymbol);
                                jsonSymbol.put("id", symbol.getId());
                                jsonSymbol.put("agnostic_symbol_type", symbol.getAgnosticSymbolType());
                                jsonSymbol.put("position_in_straff", symbol.getPositionInStaff());
                                putBoundingBox(jsonSymbol, symbol.getBoundingBox());
                                
                                if (includeStrokes && symbol.getStrokes() != null && !symbol.getStrokes().getStrokeList().isEmpty()) {
                                    JSONArray jsonStrokes = new JSONArray();
                                    jsonSymbol.put("strokes", jsonStrokes);

                                    for (Stroke stroke: symbol.getStrokes().getStrokeList()) {
                                        jsonStrokes.add(stroke.toString());
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

        Logger.getLogger(this.getClass().getName()).log(Level.FINE, "Writing JSon file {0}", outputJSonFile);
        FileWriter file = new FileWriter(outputJSonFile);
        String jsonString = jsonImage.toJSONString();
        file.write(jsonString);
        file.close();
        Logger.getLogger(this.getClass().getName()).log(Level.FINE, "JSon file created {0}", outputJSonFile);
    }
}
