package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Notation;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.NotationResponseType;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Renderer;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.repository.ProjectRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.UserRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.Pair;
import es.ua.dlsi.im3.core.adt.graphics.BoundingBoxXY;
import es.ua.dlsi.im3.core.io.ExportException;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.clefs.ClefG2;
import es.ua.dlsi.im3.core.score.facsimile.Graphic;
import es.ua.dlsi.im3.core.score.facsimile.Surface;
import es.ua.dlsi.im3.core.score.facsimile.Zone;
import es.ua.dlsi.im3.core.score.io.mei.MEISongExporter;
import es.ua.dlsi.im3.core.score.staves.Pentagram;
import es.ua.dlsi.im3.core.utils.FileUtils;
import es.ua.dlsi.im3.omr.encoding.Encoder;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import es.ua.dlsi.im3.omr.encoding.semantic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Used to be able to work also with command line
 */
@Component
public class ProjectModel {
    private static final String SYMBOL_STR = "symbol";
    private final UserRepository userRepository;

    private final ProjectRepository projectRepository;

    private final MURETConfiguration muretConfiguration;

    /**
     * <key = project.id>
     */
    HashMap<Integer, ProjectScoreSong> projectScoreSongHashMap;

    @Autowired
    public ProjectModel(UserRepository userRepository, ProjectRepository projectRepository, MURETConfiguration muretConfiguration) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.muretConfiguration = muretConfiguration;
        this.projectScoreSongHashMap = new HashMap<>();
    }

    private File createProjectFileStructure(File parentFolder, String projectBaseName) throws IM3WSException {

        File path = new File(parentFolder, projectBaseName);
        if (path.exists()) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Path '{0}' alredy exists", path.getAbsolutePath());
            throw new IM3WSException("Path '" + projectBaseName + "' already exists in repository");
        }

        if (!path.mkdirs()) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot create path '{0}'", path.getAbsolutePath());
            throw new IM3WSException("Cannot create path '" + projectBaseName);
        }

        return path;
    }

    public Project newProject(Project project) throws IM3WSException {
        Date now = new Date();

        String projectBaseName = FileUtils.leaveValidCaracters(project.getName()).toLowerCase();

        Stack<File> createdFolders = new Stack<>();
        try {

            File muretFolder = new File(muretConfiguration.getFolder());
            if (!muretFolder.exists()) {
                muretFolder = createProjectFileStructure(null, muretConfiguration.getFolder());
            }
            File projectFolder = createProjectFileStructure(muretFolder, projectBaseName);
            createdFolders.push(projectFolder);
            createdFolders.push(createProjectFileStructure(projectFolder, MURETConfiguration.MASTER_IMAGES));
            createdFolders.push(createProjectFileStructure(projectFolder, MURETConfiguration.THUMBNAIL_IMAGES));
            createdFolders.push(createProjectFileStructure(projectFolder, MURETConfiguration.PREVIEW_IMAGES));

            Project newProject = new Project(project.getName(),
                    projectBaseName,
                    project.getComposer(),
                    now,
                    now,
                    project.getCreatedBy(),
                    null,
                    project.getThumbnailBase64Encoding(),
                    project.getComments(),
                    null,
                    project.getNotationType(),
                    project.getManuscriptType(),
                    null,
                    null,
                    null,
                    project.getCollection()
            );

            return projectRepository.save(newProject);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot create project", e);
            while (!createdFolders.empty()) {
                File folder = createdFolders.pop();
                folder.delete();
            }
            throw e;
        }
    }

    public Path getProjectFolder(Project project) {
        return Paths.get(muretConfiguration.getFolder(), project.getPath());
    }
    /**
     * It generates a zip file containing the whole project file, mrt plus the image set
     * @param project
     * @return
     */
    public File exportFullProject(Project project) {
        throw new UnsupportedOperationException("TO-DO");
    }

    private File getProjectFile(Project project) {
        Path path = getProjectFolder(project);
        File file = Paths.get(path.toFile().getAbsolutePath(), project.getPath() + ".mei").toFile();
        return file;
    }
    public synchronized ProjectScoreSong getProjectScoreSong(Project project) throws IM3WSException {
        ProjectScoreSong projectScoreSong = projectScoreSongHashMap.get(project.getId());
        if (projectScoreSong == null) {
            File file = getProjectFile(project);
            projectScoreSong = new ProjectScoreSong(file, project.getNotationType());
            projectScoreSongHashMap.put(project.getId(), projectScoreSong);
        }
        return projectScoreSong;
    }

    /*public Notation render(ScoreSong scoreSong, NotationType notationType, ManuscriptType manuscriptType, boolean mensustriche, Renderer renderer) throws IM3WSException {
        try {
            if (renderer == Renderer.im3) {
                if (mensustriche) {
                    Clef[] modernClefs = new Clef[]{
                            new ClefG2(), new ClefG2(), new ClefG2(), new ClefF4(),
                            new ClefG2(), new ClefG2(), new ClefF4(), new ClefF4(),
                            new ClefF4()
                    };

                    MensuralToModern mensuralToModern = new MensuralToModern(modernClefs);
                    //TODO Parámetro
                    //ScoreSong modern = mensuralToModern.convertIntoNewSong(mensural, Intervals.FOURTH_PERFECT_DESC); // ésta genera más sostenidos
                    ScoreSong modern = mensuralToModern.convertIntoNewSong(scoreSong, Intervals.FIFTH_PERFECT_DESC);
                    mensuralToModern.merge(scoreSong, modern);
                }

                ScoreLayout layout = new HorizontalLayout(scoreSong,
                        new CoordinateComponent(1000),
                        new CoordinateComponent(400)); //TODO
                layout.layout(true);
                SVGExporter svgExporter = new SVGExporter();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                svgExporter.exportLayout(outputStream, layout);
                return new Notation(NotationResponseType.svg, outputStream.toString());
            } else if (renderer == Renderer.verovio) {
                MEISongExporter exporter = new MEISongExporter();
                return new Notation(NotationResponseType.mei, exporter.exportSong(scoreSong));
            } else {
                throw new IM3WSException("Unknown renderer: " + renderer);
            }
        } catch (IM3Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot render", e);
            return new Notation(e.getMessage());
        }
    }*/

    /*public Notation render(ScorePart scorePart, NotationType notationType, ManuscriptType manuscriptType, boolean mensustriche, Renderer renderer) throws IM3WSException {
        if (renderer == Renderer.im3) {
            throw new IM3WSException("Unimplemented");
        } else if (renderer == Renderer.verovio) {
            MEISongExporter exporter = new MEISongExporter();
            ArrayList<ScorePart> scorePartArrayList = new ArrayList<>();
            scorePartArrayList.add(scorePart);
            return new Notation(NotationResponseType.mei, exporter.exportPart(scorePart, null));
        } else {
            throw new IM3WSException("Unknown renderer: " + renderer);
        }
    }*/

    //TODO Ahora sólo lo guardo en la región
    /*public Notation render(ScorePart scorePart, Segment segment, NotationType notationType, ManuscriptType manuscriptType, boolean mensustriche, Renderer renderer) throws IM3WSException{
        if (renderer == Renderer.im3) {
            throw new IM3WSException("Unimplemented");
        } else if (renderer == Renderer.verovio) {
            if (scorePart.getStaves().size() != 1) {
                return new Notation("Currently we can handle just 1 staff parts, and there are " + scorePart.getStaves().size());
            }

            MEISongExporter exporter = new MEISongExporter();
            ArrayList<ScorePart> scorePartArrayList = new ArrayList<>();
            scorePartArrayList.add(scorePart);
            String mei = null;
            try {
                mei = exporter.exportPart(scorePart, segment);
            } catch (ExportException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot export part to MEI", e);
                return new Notation("Cannot export to MEI: " + e.getMessage());
            }

            String semanticEncoding = null;
            try {
                Encoder encoder = new Encoder(AgnosticVersion.v2, false);
                encoder.encode(scorePart.getStaves().get(0), segment);
                //SemanticExporter semanticExporter = new SemanticExporter();
                //semanticEncoding = semanticExporter.export(encoder.getSemanticEncoding());
                KernSemanticExporter kernSemanticExporter = new KernSemanticExporter();
                semanticEncoding = kernSemanticExporter.export(encoder.getSemanticEncoding());
            } catch (IM3Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot export part to semantic encoding", e);
                return new Notation("Cannot export to MEI: " + e.getMessage());
            }

            return new Notation(NotationResponseType.mei, mei, semanticEncoding);


        } else {
            throw new IM3WSException("Unknown renderer: " + renderer);
        }
    }


    public Notation render(Project project, String partName, Long regionID, NotationType notationType, ManuscriptType manuscriptType, boolean mensustriche, Renderer renderer) throws IM3WSException {
        ProjectScoreSong projectScoreSong = getProjectScoreSong(project);
        ProjectScoreSongPart projectScorePart = projectScoreSong.getScorePart(partName);
        ProjectScoreSongSystem projectScoreSystem = projectScorePart.getScoreSongSystem(regionID);
        if (projectScoreSystem == null) {
            throw new IM3WSException("Cannot find score system for region ID " + regionID + " in part '" + partName + "'");
        }

        Segment segment = new Segment(projectScoreSystem.getFrom(), projectScoreSystem.getTo());
        return render(projectScorePart.getScorePart(), segment, notationType, manuscriptType, mensustriche, renderer);
    }*/

    public void addPart(Project project, String partName) throws IM3WSException {
        ProjectScoreSong projectScoreSong = getProjectScoreSong(project);
        projectScoreSong.addPart(partName);
    }

    /**
     * It removes the project and associated files (.mei)
     * @param project
     */
    public void delete(Project project) {
        File file = getProjectFile(project);
        file.delete();
        projectScoreSongHashMap.remove(project);
    }

    //TODO Ahora sólo lo guardo en la región
    /*public void addSemanticEncoding(Project project, String partName, long regionID, BoundingBox boundingBox, String semanticEncodingString) throws IM3WSException {
        try {
            if (project.getNotationType() != NotationType.eMensural) {
                throw new IM3WSException("Currently only mensural notation is supported");
            }
            MensSemanticImporter importer = new MensSemanticImporter();
            SemanticEncoding semanticEncoding = importer.importString(NotationType.eMensural, semanticEncodingString);
            addSemanticEncoding(project, partName, regionID, boundingBox, semanticEncoding);
        } catch (Exception e) {
            throw new IM3WSException(e);
        }

    }
    public void addSemanticEncoding(Project project, String partName, long regionID, BoundingBox boundingBox, SemanticEncoding semanticEncoding) throws IM3WSException {
        ProjectScoreSong projectScoreSong = getProjectScoreSong(project);
        ProjectScoreSongPart projectScorePart = projectScoreSong.getScorePart(partName);
        ProjectScoreSongSystem projectScoreSystem = projectScorePart.getScoreSongSystem(regionID);
        if (projectScoreSystem == null) {
            projectScoreSystem = projectScorePart.addProjectScoreSystem(regionID, boundingBox);
            //TODO añadir a page
        }

        projectScorePart.addSemanticEncoding(projectScoreSystem, semanticEncoding);
        projectScoreSong.save();
    }
*/
    /**
     * It removes all elements in the part
     */
    /*public void clearSystem(Project project, String partName, long regionID) {
        //TODO
    }*/

    //TODO esto sólo funciona con 1 pentagrama y 1 layer
    /*public void addToPart(ProjectScoreSongPart part, ITimedElementInStaff timedElementInStaff) throws IM3Exception {
        ScorePart scorePart = part.getScorePart();
        if (scorePart.getStaves().size() != 1) {
            throw new IM3Exception("Cannot work yet with other than 1 staff in the scorePart");
        }
        Staff staff = scorePart.getStaves().get(0);
        if (staff.getLayers().size() != 1) {
            throw new IM3Exception("Cannot work yet with other than 1 layer in the staff");
        }
        ScoreLayer layer = scorePart.getUniqueVoice();
        staff.addCoreSymbol(timedElementInStaff);
        if (timedElementInStaff instanceof Atom) {
            layer.add((Atom) timedElementInStaff);
        }
    }*/


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

    /**
     *
     * @param project
     * @param specificPart If null, the full score is rendered
     * @return
     * @throws IM3Exception
     */
    public String exportMEI(Project project, Part specificPart, boolean partsAndFacsimile) throws IM3Exception {
        ScoreSong song = new ScoreSong();
        song.addTitle(project.getName());

        Facsimile facsimile = new Facsimile();
        if (partsAndFacsimile) {
            song.setFacsimile(facsimile);
        }

        HashMap<Part, ScorePart> scorePartHashMap = new HashMap<>();
        HashMap<Part, Staff> staves = new HashMap<>();
        HashMap<Part, Clef> lastClefs = new HashMap<>();

        int cont = 1;
        ScorePart scoreSpecificPart = null;
        for (Part part: project.getParts()) {
            if (specificPart == null || part.getId() == specificPart.getId()) {
                ScorePart scorePart = new ScorePart(song, cont); //TODO Ordenación de partes
                song.addPart(scorePart);
                scorePart.setName(part.getName());
                scorePartHashMap.put(part, scorePart);

                if (specificPart != null) {
                    scoreSpecificPart = scorePart;
                }

                Pentagram pentagram = new Pentagram(song, new Integer(cont).toString(), cont);
                pentagram.setNotationType(project.getNotationType());
                ScoreLayer layer = scorePart.addScoreLayer();
                pentagram.addLayer(layer);
                pentagram.setName(part.getName());
                staves.put(part, pentagram);
                scorePart.addStaff(pentagram);
                song.addStaff(pentagram);
                cont++;
            }
        }

        for (Image image: project.getImages()) {
            Part imagePart = image.getPart();
            for (Page page: image.getPages()) {
                String lastPageID = "page_" + page.getId();
                Surface imageSurface = null;
                if (partsAndFacsimile) {
                    imageSurface = new Surface();
                    imageSurface.setID(lastPageID);
                    imageSurface.setBoundingBox(new BoundingBoxXY(0, 0, image.getWidth(), image.getHeight()));

                    Graphic graphic = new Graphic();
                    graphic.setTarget(project.getPath() + "/" + image.getFilename());
                    imageSurface.addGraphic(graphic);

                    facsimile.addSurface(imageSurface);
                }


                boolean newPage = true;
                Part pagePart = page.getPart() == null ? imagePart : page.getPart();
                for (Region region: page.getRegions()) {
                    String lastRegionID = "region_" + region.getId();
                    if (imageSurface != null) {
                        Zone zone = new Zone();
                        zone.setID(lastRegionID);
                        zone.setBoundingBox(getBoundingBox(region.getBoundingBox()));
                        zone.setType("region");
                        imageSurface.addZone(zone);

                        for (Symbol symbol: region.getSymbols()) {
                            Zone symbolZone = new Zone();
                            symbolZone.setID(generateID(symbol));
                            symbolZone.setBoundingBox(getBoundingBox(symbol.getBoundingBox()));
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

                            //TODO Código duplicado en SemanticRepresentationModel - getNotation
                            MensSemanticImporter mensSemanticImporter = new MensSemanticImporter(); //TODO Sólo va para mensural
                            SemanticEncoding semantic = mensSemanticImporter.importString(project.getNotationType(), region.getSemanticEncoding());
                            Semantic2IMCore semantic2IMCore = new Semantic2IMCore();
                            //TODO compases y tonalidad anteriores
                            List<Pair<SemanticSymbol, ITimedElementInStaff>> items = semantic2IMCore.convert(project.getNotationType(), null, null, semantic);

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
                                if (timedElementInStaff instanceof Atom) {
                                    Atom atom = (Atom) timedElementInStaff;
                                    layer.add(atom);
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
}
