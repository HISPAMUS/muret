package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Notation;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.NotationResponseType;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.PreflightCkeckResult;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Renderer;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.semantic.grammar.SKernMensSemanticImporter;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.Pair;
import es.ua.dlsi.im3.core.adt.graphics.BoundingBoxXY;
import es.ua.dlsi.im3.core.conversions.MensuralToModern;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.facsimile.Graphic;
import es.ua.dlsi.im3.core.score.facsimile.Surface;
import es.ua.dlsi.im3.core.score.facsimile.Zone;
import es.ua.dlsi.im3.core.score.io.mei.MEISongExporter;
import es.ua.dlsi.im3.core.score.io.musicxml.MusicXMLExporter;
import es.ua.dlsi.im3.core.score.layout.CoordinateComponent;
import es.ua.dlsi.im3.core.score.layout.HorizontalLayout;
import es.ua.dlsi.im3.core.score.layout.fonts.LayoutFonts;
import es.ua.dlsi.im3.core.score.layout.svg.SVGExporter;
import es.ua.dlsi.im3.core.score.staves.Pentagram;
import es.ua.dlsi.im3.omr.encoding.semantic.*;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotationModel {
    private static final String SYMBOL_STR = "symbol";

    public String getMEINotation(SemanticEncoding semanticEncoding, NotationType notationType) throws IM3WSException, IM3Exception {
        Semantic2IMCore semantic2IMCore = new Semantic2IMCore();
        //TODO compases y tonalidad anteriores
        //TODO URGENT - esta separación no está bien - puesto para prueba de concepto de ReadSCO
        ScoreSong song = null;
        if (notationType == NotationType.eMensural) {
            List<Pair<SemanticSymbol, ITimedElementInStaff>> items = semantic2IMCore.convert(notationType, null, null, semanticEncoding);
            song = new ScoreSong();
            ScorePart part = song.addPart();
            ScoreLayer layer = part.addScoreLayer();
            Staff staff = new Pentagram(song, "1", 1);
            staff.setNotationType(notationType);
            song.addStaff(staff);
            part.addStaff(staff);
            staff.addLayer(layer);
            for (Pair<SemanticSymbol, ITimedElementInStaff> item : items) {
                ITimedElementInStaff timedElementInStaff = item.getY();
                if (timedElementInStaff instanceof Atom) {
                    layer.add((Atom) timedElementInStaff);
                } else {
                    staff.addElementWithoutLayer((IStaffElementWithoutLayer) timedElementInStaff);
                }
            }
        } else {
            song = semantic2IMCore.convertToSingleVoicedSong(notationType, semanticEncoding);
        }

        if (notationType == NotationType.eModern && song.getMeasures().isEmpty()) {
            throw new IM3WSException("Cannot create modern translation in a modern song without bars");
        }

        MEISongExporter exporter = new MEISongExporter();
        String mei = exporter.exportSong(song);
        return mei;
    }

    SemanticEncoding importSemanticEncoding(Document document, Region region) throws IM3Exception {
        if (region.getSemanticEncoding() == null) {
            throw new IM3Exception("Region has not a semantic encoding yet");
        }

        ISemanticImporter semanticImporter = new SKernMensSemanticImporter();
        /*switch (document.getNotationType()) {
            case eMensural:
                semanticImporter = new MensSemanticImporter();
                break;
            case eModern:
                semanticImporter = new KernSemanticImporter();
                break;
            default:
                throw new IM3Exception("Unsupported notation type: " + document.getNotationType());
        }*/


        return semanticImporter.importString(document.getNotationType(), region.getSemanticEncoding());
    }

    public Notation getNotation(Document document, String partName, Region region, boolean mensustriche, Renderer renderer) {

        //TODO Código algo duplicado en DocumentModel - exportMEI
        //TODO Ahora sólo lo guardo en la región
        try {
            SemanticEncoding semanticEncoding = importSemanticEncoding(document, region);
            String mei = getMEINotation(semanticEncoding, document.getNotationType());
            return new Notation(NotationResponseType.mei, mei, region.getSemanticEncoding());
        } catch (Exception e) {
            return new Notation("Cannot import semantic encoding: " + e.getMessage());
        }
    }

    private String generateID(Symbol symbol) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SYMBOL_STR);
        stringBuilder.append('_');
        stringBuilder.append(symbol.getId());
        return stringBuilder.toString();
    }

    private String generateID(Long id) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SYMBOL_STR);
        stringBuilder.append('_');
        stringBuilder.append(id);
        return stringBuilder.toString();
    }

    public Pair<ScoreSong, ScorePart> exportScoreSong(Document document, Part specificPart, boolean partsAndFacsimile, Set<Long> idsOfSelectedImages) throws IM3Exception {
        ScoreSong song = new ScoreSong();
        song.addTitle(document.getName());

        Facsimile facsimile = new Facsimile();
        if (partsAndFacsimile) {
            song.setFacsimile(facsimile);
        }

        HashMap<Part, ScorePart> scorePartHashMap = new HashMap<>();
        HashMap<Part, Staff> staves = new HashMap<>();
        HashMap<Part, Clef> lastClefs = new HashMap<>();

        int cont = 1;
        ScorePart scoreSpecificPart = null;
        for (Part part: document.getParts()) {
            if (specificPart == null || part.getId() == specificPart.getId()) {
                ScorePart scorePart = new ScorePart(song, cont); //TODO Ordenación de partes
                song.addPart(scorePart);
                scorePart.setName(part.getName());
                scorePartHashMap.put(part, scorePart);

                if (specificPart != null) {
                    scoreSpecificPart = scorePart;
                }

                Pentagram pentagram = new Pentagram(song, new Integer(cont).toString(), cont);
                pentagram.setNotationType(document.getNotationType());
                ScoreLayer layer = scorePart.addScoreLayer();
                pentagram.addLayer(layer);
                pentagram.setName(part.getName());
                staves.put(part, pentagram);
                scorePart.addStaff(pentagram);
                song.addStaff(pentagram);
                cont++;
            }
        }

        for (Image image: document.getImages()) {
            if (idsOfSelectedImages.contains(image.getId())) {
                Part imagePart = image.getPart();
                int npage = 0;
                for (Page page: image.getPages()) {
                    npage++;
                    String lastPageID = "page_" + page.getId();
                    Surface imageSurface = null;
                    if (partsAndFacsimile) {
                        imageSurface = new Surface();
                        imageSurface.setID(lastPageID);
                        imageSurface.setBoundingBox(new BoundingBoxXY(0, 0, image.getWidth(), image.getHeight()));

                        Graphic graphic = new Graphic();
                        graphic.setTarget(document.getPath() + "/" + image.getFilename());
                        imageSurface.addGraphic(graphic);

                        facsimile.addSurface(imageSurface);
                    }


                    boolean newPage = true;
                    Part pagePart = page.getPart() == null ? imagePart : page.getPart();
                    int nregion = 0;
                    for (Region region : page.getRegions()) {
                        if (region.getRegionType().getName().toLowerCase().indexOf("staff") >= 0) {
                            nregion++;
                        }
                        String lastRegionID = "region_" + region.getId();
                        if (imageSurface != null) {
                            Zone zone = new Zone();
                            zone.setID(lastRegionID);
                            zone.setBoundingBox(getBoundingBox(region.getBoundingBox()));
                            zone.setType("region");
                            imageSurface.addZone(zone);

                            for (Symbol symbol : region.getSymbols()) {
                                Zone symbolZone = new Zone();
                                symbolZone.setID(generateID(symbol));

                                if (symbol.getBoundingBox() != null) {
                                    symbolZone.setBoundingBox(getBoundingBox(symbol.getBoundingBox()));
                                } else if (symbol.getApproximateX() != null) {
                                    //TODO 25
                                    symbolZone.setBoundingBox(new BoundingBoxXY(symbol.getApproximateX(),
                                            region.getBoundingBox().getFromY(),
                                            symbol.getApproximateX() + 25,
                                            region.getBoundingBox().getToY()));
                                }


                                symbolZone.setType(SYMBOL_STR);
                                imageSurface.addZone(symbolZone);
                            }
                        }


                        Part regionPart = region.getPart() == null ? pagePart : region.getPart();
                        if (regionPart == null) {
                            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Region {0} has not a part assigned", region.getId());
                        } else {
                            if (specificPart == null || regionPart.getId() == specificPart.getId()) {
                                Clef lastClef = lastClefs.get(regionPart);

                                //TODO Código algo duplicado en SemanticRepresentationModel - getNotation
                                String semanticEncoding = region.getSemanticEncoding();
                                if (semanticEncoding != null && !semanticEncoding.trim().isEmpty()) {
                                    //SemanticEncoding semantic = mensSemanticImporter.importString(document.getNotationType(), region.getSemanticEncoding());
                                    SemanticEncoding semantic = importSemanticEncoding(document, region);
                                    Semantic2IMCore semantic2IMCore = new Semantic2IMCore();
                                    //TODO compases y tonalidad anteriores
                                    List<Pair<SemanticSymbol, ITimedElementInStaff>> items = semantic2IMCore.convert(document.getNotationType(), null, null, semantic);

                                    Staff staff = staves.get(regionPart);
                                    if (staff == null) {
                                        throw new IM3Exception("Cannot find the staff for the region " + region.getId());
                                    }

                                    ScoreLayer layer = staff.getLayers().get(0);
                                    ScorePart scorePart = scorePartHashMap.get(regionPart);
                                    if (scorePart == null) {
                                        throw new IM3Exception("Cannot find the score part for the region " + region.getId());
                                    }
                                    Time time = staff.getDuration();
                                    if (partsAndFacsimile || specificPart != null) {
                                        if (newPage) {
                                            newPage = false;
                                            PageBeginning pageBeginning = new PageBeginning(time, true);
                                            if (partsAndFacsimile) {
                                                pageBeginning.setFacsimileElementID(lastPageID);
                                            }
                                            scorePart.addPageBeginning(pageBeginning);
                                        }
                                        SystemBeginning systemBeginning = new SystemBeginning(time, true);
                                        if (partsAndFacsimile) {
                                            systemBeginning.setFacsimileElementID(lastRegionID);
                                        }
                                        scorePart.addSystemBeginning(systemBeginning);
                                    }

                                    boolean firstNote = true;
                                    for (Pair<SemanticSymbol, ITimedElementInStaff> pair : items) {
                                        SemanticSymbol semanticSymbol = pair.getX();
                                        ITimedElementInStaff timedElementInStaff = pair.getY();

                                        if (semanticSymbol.getSymbol().getAgnosticIDs() != null && semanticSymbol.getSymbol().getAgnosticIDs().length > 0) {
                                            //TODO We can only reference to one symbol - maybe, when the semantic symbol corresponds to several agnostic,
                                            // we could export the merged bounding box of all agnostic symbols
                                            // Now we just reference to the first one

                                            Long agnosticID = semanticSymbol.getSymbol().getAgnosticIDs()[0];
                                            String referencedSymbolID = generateID(agnosticID);
                                            timedElementInStaff.setFacsimileElementID(referencedSymbolID);
                                        }
                                        if (timedElementInStaff instanceof Atom) { //TODO Mejor con una anotación (marcador)
                                            Atom atom = (Atom) timedElementInStaff;
                                            layer.add(atom);

                                            if (atom instanceof SimpleNote) {
                                                if (firstNote) {
                                                    firstNote = false;
                                                    SimpleNote simpleNote = (SimpleNote) atom;
                                                    String label = image.getFilename() + ", p" + npage + ", s" + nregion;
                                                    simpleNote.getAtomPitch().addLyric(new ScoreLyric(1, simpleNote.getAtomPitch(), label, Syllabic.single));
                                                }
                                            }
                                        } else {
                                            boolean insert = true;
                                            if (timedElementInStaff instanceof Clef) {
                                                if (lastClef == null || !lastClef.equals(timedElementInStaff)) {
                                                    lastClef = (Clef) timedElementInStaff;
                                                    lastClefs.put(regionPart, lastClef);
                                                } else {
                                                    insert = false;
                                                }
                                            } else if (timedElementInStaff instanceof Custos) {
                                                insert = partsAndFacsimile || specificPart != null;
                                            }

                                            if (insert) {
                                                staff.addElementWithoutLayer((IStaffElementWithoutLayer) timedElementInStaff);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return new Pair<>(song, scoreSpecificPart);
    }

    /**
     *
     * @param document
     * @param specificPart If null, the full score is rendered
     * @param idsOfSelectedImages
     * @return
     * @throws IM3Exception
     */
    public String exportMEI(Document document, Part specificPart, boolean partsAndFacsimile, Set<Long> idsOfSelectedImages) throws IM3Exception {

        Pair<ScoreSong, ScorePart> pair = exportScoreSong(document, specificPart, partsAndFacsimile, idsOfSelectedImages);
        ScoreSong song = pair.getX();
        ScorePart scoreSpecificPart = pair.getY();

        MEISongExporter exporter = new MEISongExporter();
        String mei = null;
        if (partsAndFacsimile) {
            mei = exporter.exportSongAsParts(song);
        } else {
            if (specificPart == null) {
                mei = exporter.exportSong(song);
            } else {
                mei = exporter.exportPart(scoreSpecificPart, null);
            }
        }

        return mei;
    }

    private BoundingBoxXY getBoundingBox(BoundingBox boundingBox) throws IM3Exception {
        return new BoundingBoxXY(
                boundingBox.getFromX(), boundingBox.getFromY(),
                boundingBox.getToX(), boundingBox.getToY()
        );
    }

    public void generateMensurstrich(Path tgz, Document document, Set<Long> idsOfSelectedImages) throws IM3Exception {
        Pair<ScoreSong, ScorePart> pair = exportScoreSong(document, null, false, idsOfSelectedImages);
        ScoreSong mensural = pair.getX();

        HorizontalLayout horizontalLayout = new HorizontalLayout(mensural, new CoordinateComponent(50000), new CoordinateComponent(3000), LayoutFonts.bravura);
        horizontalLayout.layout(true);

        SVGExporter svgExporter = new SVGExporter();
        File svgOutput = new File(tgz.toFile(), document.getPath() + "_mensural.svg"); //TODO ¿cuando no es mensural?
        svgExporter.exportLayout(svgOutput, horizontalLayout);

        MensuralToModern mensuralToModern = new MensuralToModern(null);
        ScoreSong modern = mensuralToModern.convertIntoNewSong(mensural, Intervals.UNISON_PERFECT);

        mensuralToModern.merge(mensural, modern);

        HorizontalLayout horizontalLayoutMerged = new HorizontalLayout(mensural, new CoordinateComponent(25000), new CoordinateComponent(2000), LayoutFonts.bravura);
        horizontalLayoutMerged.layout(true);

        SVGExporter svgExporterMerged = new SVGExporter();
        File svgOutputMerged = new File(tgz.toFile(), document.getPath() + "_mensural_modern_mensurstrich.svg"); //TODO ¿cuando no es mensural?
        svgExporterMerged.exportLayout(svgOutputMerged, horizontalLayoutMerged);
    }

    public void generateMusicXML(Path tgz, Document document, Set<Long> idsOfSelectedImages) throws IM3Exception {
        //TODO ¿Si no es mensural?
        Pair<ScoreSong, ScorePart> pair = exportScoreSong(document, null, false, idsOfSelectedImages);
        ScoreSong mensural = pair.getX();

        MensuralToModern mensuralToModern = new MensuralToModern(null);
        ScoreSong modern = mensuralToModern.convertIntoNewSong(mensural, Intervals.UNISON_PERFECT);

        MusicXMLExporter musicXMLExporter = new MusicXMLExporter();
        File musicXMLFile = new File(tgz.toFile(), document.getPath() + ".xml");
        musicXMLExporter.exportSong(musicXMLFile, modern);
    }

    public List<PreflightCkeckResult> preflightCheck(Document document, Set<Long> idsOfSelectedImages) {
        ArrayList<PreflightCkeckResult> resultArrayList = new ArrayList<>();

        resultArrayList.add(new PreflightCkeckResult(2728, 25074, "Prueba 1"));
        resultArrayList.add(new PreflightCkeckResult(2728, 2964, "Prueba 2"));
        return resultArrayList;
    }
}
