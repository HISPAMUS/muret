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
import es.ua.dlsi.im3.core.io.ExportException;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.clefs.ClefG2;
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
     * @param project
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

    //TODO BORRAR
    public String nada() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<?xml-model href=\"http://music-encoding.org/schema/4.0.0/mei-all.rng\" type=\"application/xml\" schematypens=\"http://relaxng.org/ns/structure/1.0\"?>\n" +
                "<?xml-model href=\"http://music-encoding.org/schema/4.0.0/mei-all.rng\" type=\"application/xml\" schematypens=\"http://purl.oclc.org/dsdl/schematron\"?>\n" +
                "<mei xmlns=\"http://www.music-encoding.org/ns/mei\" meiversion=\"4.0.0\">\n" +
                "    <meiHead>\n" +
                "        <fileDesc>\n" +
                "            <titleStmt>\n" +
                "                <title />\n" +
                "            </titleStmt>\n" +
                "            <pubStmt />\n" +
                "        </fileDesc>\n" +
                "        <encodingDesc>\n" +
                "            <appInfo>\n" +
                "                <application isodate=\"2019-07-30T20:52:23\" version=\"2.2.0-dev-724637b\">\n" +
                "                    <name>Verovio</name>\n" +
                "                    <p>Transcoded from Humdrum</p>\n" +
                "                </application>\n" +
                "            </appInfo>\n" +
                "        </encodingDesc>\n" +
                "        <workList>\n" +
                "            <work>\n" +
                "                <title />\n" +
                "            </work>\n" +
                "        </workList>\n" +
                "    </meiHead>\n" +
                "    <music>\n" +
                "        <body>\n" +
                "            <mdiv xml:id=\"mdiv-0000001875122450\">\n" +
                "                <score xml:id=\"score-0000000808117618\">\n" +
                "                    <scoreDef xml:id=\"scoredef-0000000605239052\" midi.bpm=\"400\">\n" +
                "                        <staffGrp xml:id=\"staffgrp-0000001443844955\">\n" +
                "                            <staffDef xml:id=\"staffdef-0000000545218833\" clef.shape=\"F\" clef.line=\"4\" key.sig=\"0\" mensur.sign=\"C\" mensur.slash=\"1\" n=\"1\" notationtype=\"mensural.white\" lines=\"5\">\n" +
                "                                <label xml:id=\"label-0000000630793959\" />\n" +
                "                            </staffDef>\n" +
                "                        </staffGrp>\n" +
                "                    </scoreDef>\n" +
                "                    <section xml:id=\"section-L1F1\">\n" +
                "                        <measure xml:id=\"measure-L1\" right=\"invis\" n=\"0\">\n" +
                "                            <staff xml:id=\"staff-0000001177131203\" n=\"1\">\n" +
                "                                <layer xml:id=\"layer-L1F1N1\" n=\"1\">\n" +
                "                                    <note xml:id=\"note-L7F1\" dur=\"brevis\" oct=\"2\" pname=\"f\" />\n" +
                "                                </layer>\n" +
                "                            </staff>\n" +
                "                        </measure>\n" +
                "                    </section>\n" +
                "                </score>\n" +
                "            </mdiv>\n" +
                "        </body>\n" +
                "    </music>\n" +
                "</mei>\n";
    }

    public String exportMEI(Project project) throws IM3Exception {
        ScoreSong song = new ScoreSong();
        HashMap<Part, ScorePart> scorePartHashMap = new HashMap<>();
        HashMap<Part, Staff> staves = new HashMap<>();
        int cont = 1;
        for (Part part: project.getParts()) {
            ScorePart scorePart = new ScorePart(song, cont); //TODO Ordenación de partes
            scorePart.setName(part.getName());
            scorePartHashMap.put(part, scorePart);
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

        for (Image image: project.getImages()) {
            Part imagePart = image.getPart();
            for (Page page: image.getPages()) {
                Part pagePart = page.getPart() == null ? imagePart : page.getPart();
                for (Region region: page.getRegions()) {
                    Part regionPart = region.getPart() == null ? pagePart : region.getPart();
                    if (regionPart == null) {
                        Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Region {0} has not a part assigned", region.getId());
                    } else {
                        //TODO Código duplicado en SemanticRepresentationModel - getNotation
                        MensSemanticImporter mensSemanticImporter = new MensSemanticImporter(); //TODO Sólo va para mensural
                        SemanticEncoding semantic = mensSemanticImporter.importString(project.getNotationType(), region.getSemanticEncoding());
                        Semantic2IMCore semantic2IMCore = new Semantic2IMCore();
                        //TODO compases y tonalidad anteriores
                        List<ITimedElementInStaff> items = semantic2IMCore.convert(project.getNotationType(), null, null, semantic);

                        Staff staff = staves.get(regionPart);
                        if (staff == null) {
                            throw new IM3Exception("Cannot find the staff for the region " + region.getId());
                        }

                        ScoreLayer layer = staff.getLayers().get(0);

                        for (ITimedElementInStaff timedElementInStaff : items) {
                            if (timedElementInStaff instanceof Atom) {
                                layer.add((Atom) timedElementInStaff);
                            } else {
                                staff.addElementWithoutLayer((IStaffElementWithoutLayer) timedElementInStaff);
                            }
                        }
                    }
                }
            }
        }

        MEISongExporter exporter = new MEISongExporter();
        String mei = exporter.exportSong(song);
        System.out.println(mei);
        return mei;
    }
}
