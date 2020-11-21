package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticSymbolFont;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticSymbolFontSingleton;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentModel;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.io.ExportException;
import es.ua.dlsi.im3.core.score.PositionInStaff;
import es.ua.dlsi.im3.core.score.PositionsInStaff;
import es.ua.dlsi.im3.core.utils.FileCompressors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
public class JSONTagging extends AbstractTrainingSetExporter {
    private static final String FIELD_SEPARATOR = ";";
    private final boolean includeStrokes;

    //TODO Como constructor
    @Autowired
    MURETConfiguration muretConfiguration;

    //TODO Como constructor
    @Autowired
    DocumentModel documentModel;



    public JSONTagging(int id, boolean includeStrokes) {
        super(id,
                includeStrokes?
                        "JSON files with images, pages, regions, symbols, symbol dictionary and strokes"
                        :"JSON files with images, pages, regions, symbols and symbol dictionary",
                "It generates a compressed file containing a folder for each document and a JSON for the symbol dictionary, and a JSON file for each image with its relative file name. " +
                        "This JSON file encodes the bounding boxes of pages, regions, and symbols. For each region its region type is also exported. " +
                        "For each symbol both its agnostic encoding is appended and, if present, the strokes information",
                false
                );
        this.includeStrokes = includeStrokes;
    }


    @Override
    public Path generate(Path muretFolder, Collection<Document> documentCollection) throws ExportException {
        try {
            Path directory = Files.createTempDirectory("json_agnostic_symbol_images");
            File outputJSonDiccFile = new File(directory.toFile(), "dictionary.json");
            for (Document document : documentCollection) {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Exporting document " + document.getName());

                generateDictionary(document);

                File documentFolder = new File(directory.toFile(), document.getPath());
                documentFolder.mkdirs();

                for (Image image: document.getSortedImages()) {
                    Logger.getLogger(this.getClass().getName()).log(Level.FINE, "Exporting JSON for image " + image.getFilename());
                    File outputJSonFile = new File(documentFolder, image.getFilename() + ".json");
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

    // see AgnosticRepresentationController.getAgnosticSymbolSVGSet
    private void generateDictionary(Document document) throws IM3WSException, IM3Exception {
        AgnosticSymbolFont agnosticSymbolFont = AgnosticSymbolFontSingleton.getInstance().getLayoutFont(document.getNotationType(), document.getManuscriptType());

        try {
            SVGSet result = new SVGSet(agnosticSymbolFont.getLayoutFont().getSVGFont().getAscent(),
                    agnosticSymbolFont.getLayoutFont().getSVGFont().getDescent(),
                    agnosticSymbolFont.getLayoutFont().getSVGFont().getUnitsPerEM(),
                    agnosticSymbolFont.getFullSVGSetPathd());
            List<AgnosticTypeSVGPath> paths = result.getPaths();
            List<PositionInStaff> positions = new ArrayList<>();
            for (int i=PositionsInStaff.FOURTH_BOTTOM_LEDGER_LINE.getLineSpace(); i<=PositionsInStaff.FOURTH_TOP_LEDGER_LINE.getLineSpace(); i++) {
                positions.add(new PositionInStaff(i));
            }
            JSONObject jsonDictionary = new JSONObject();

            JSONArray jsonArray = new JSONArray();
            for (AgnosticTypeSVGPath agnosticTypeSVGPath: paths) {
                for (PositionInStaff position : positions) {
                    String item = agnosticTypeSVGPath.getAgnosticTypeString() + ":" + position.toString();
                    jsonArray.add(item);
                }
            }
            jsonDictionary.put("agnostic_dictionary", jsonArray);
        } catch (IM3Exception e) {
            throw new IM3WSException(e);
        }
    }

    public static void putBoundingBox(JSONObject jsonObject, BoundingBox boundingBox) {
        JSONObject jsonBB = new JSONObject();
        jsonBB.put("fromX", boundingBox.getFromX());
        jsonBB.put("fromY", boundingBox.getFromY());
        jsonBB.put("toX", boundingBox.getToX());
        jsonBB.put("toY", boundingBox.getToY());
        jsonObject.put("bounding_box", jsonBB);
    }

    private String constructCollectionPath(Image image) {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.toString();
    }

    private void generate(Image image, File outputJSonFile) throws IOException, ExportException {
        JSONObject jsonImage = new JSONObject();

        jsonImage.put("id", image.getId());
        jsonImage.put("filename", image.getFilename());
        jsonImage.put("collection", constructCollectionPath(image));

        List<Page> pages = image.getSortedPages();
        if (pages != null && !pages.isEmpty()) {
            JSONArray jsonPages = new JSONArray();
            jsonImage.put("pages", jsonPages);

            for (Page page : pages) {
                JSONObject jsonPage = new JSONObject();
                jsonPages.add(jsonPage);
                jsonPage.put("id", page.getId());
                putBoundingBox(jsonPage, page.getBoundingBox());

                List<Region> regions = page.getSortedRegions();
                if (regions!=null && !regions.isEmpty()) {
                    JSONArray jsonRegions = new JSONArray();
                    jsonPage.put("regions", jsonRegions);
                    for (Region region : regions) {
                        JSONObject jsonRegion = new JSONObject();
                        jsonRegions.add(jsonRegion);
                        jsonRegion.put("id", region.getId());
                        if (region.getRegionType() != null) {
                            jsonRegion.put("type", region.getRegionType().getName());
                        }
                        putBoundingBox(jsonRegion, region.getBoundingBox());

                        List<Symbol> symbols = region.getSortedSymbols();
                        if (symbols != null && !symbols.isEmpty()) {
                            JSONArray jsonSymbols = new JSONArray();
                            jsonRegion.put("symbols", jsonSymbols);


                            /*ArrayList<Symbol> symbols = new ArrayList<>();
                            symbols.addAll(region.getSymbols());

                            // sort first by x, then by y
                            symbols.sort(Symbol.getHorizontalPositionComparator());*/

                            for (Symbol symbol : symbols) {
                                JSONObject jsonSymbol = new JSONObject();
                                jsonSymbols.add(jsonSymbol);
                                jsonSymbol.put("id", symbol.getId());
                                jsonSymbol.put("agnostic_symbol_type", symbol.getAgnosticSymbolType());
                                jsonSymbol.put("position_in_staff", symbol.getPositionInStaff());
                                if (symbol.getBoundingBox() != null) {
                                    putBoundingBox(jsonSymbol, symbol.getBoundingBox());
                                } else if (symbol.getApproximateX() != null) {
                                    jsonSymbol.put("approximateX", symbol.getApproximateX());
                                } else {
                                    throw new ExportException("Cannot export a symbol without bounding box or approximate X possition");
                                }
                                
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
