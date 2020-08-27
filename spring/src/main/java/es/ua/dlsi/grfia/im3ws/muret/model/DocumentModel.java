package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.repository.DocumentRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.UserRepository;
import es.ua.dlsi.im3.core.utils.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Used to be able to work also with command line
 */
@Component
public class DocumentModel {
    private final UserRepository userRepository;

    private final DocumentRepository documentRepository;

    private final MURETConfiguration muretConfiguration;

    /**
     * <key = document.id>
     */
    HashMap<Integer, DocumentScoreSong> documentScoreSongHashMap;

    @Autowired
    public DocumentModel(UserRepository userRepository, DocumentRepository documentRepository, MURETConfiguration muretConfiguration) {
        this.userRepository = userRepository;
        this.documentRepository = documentRepository;
        this.muretConfiguration = muretConfiguration;
        this.documentScoreSongHashMap = new HashMap<>();
    }

    private File createDocumentFileStructure(File parentFolder, String documentBaseName) throws IM3WSException {

        File path = new File(parentFolder, documentBaseName);
        if (path.exists()) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Path '{0}' alredy exists", path.getAbsolutePath());
            throw new IM3WSException("Path '" + documentBaseName + "' already exists in repository");
        }

        if (!path.mkdirs()) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot create path '{0}'", path.getAbsolutePath());
            throw new IM3WSException("Cannot create path '" + documentBaseName);
        }

        return path;
    }

    public Document newDocument(Document document) throws IM3WSException {
        Date now = new Date();

        String documentBaseName = FileUtils.leaveValidCaracters(document.getName()).toLowerCase();

        Stack<File> createdFolders = new Stack<>();
        try {

            File muretFolder = new File(muretConfiguration.getFolder());
            if (!muretFolder.exists()) {
                muretFolder = createDocumentFileStructure(null, muretConfiguration.getFolder());
            }
            File documentFolder = createDocumentFileStructure(muretFolder, documentBaseName);
            createdFolders.push(documentFolder);
            createdFolders.push(createDocumentFileStructure(documentFolder, MURETConfiguration.MASTER_IMAGES));
            createdFolders.push(createDocumentFileStructure(documentFolder, MURETConfiguration.THUMBNAIL_IMAGES));
            createdFolders.push(createDocumentFileStructure(documentFolder, MURETConfiguration.PREVIEW_IMAGES));

            Document newDocument = new Document(document.getName(),
                    documentBaseName,
                    document.getComposer(),
                    now,
                    now,
                    document.getCreatedBy(),
                    null,
                    document.getThumbnailBase64Encoding(),
                    document.getComments(),
                    null,
                    document.getNotationType(),
                    document.getManuscriptType(),
                    null,
                    null,
                    null,
                    document.getCollection()
            );

            return documentRepository.save(newDocument);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot create document", e);
            while (!createdFolders.empty()) {
                File folder = createdFolders.pop();
                folder.delete();
            }
            throw e;
        }
    }

    public Path getDocumentFolder(Document document) {
        return Paths.get(muretConfiguration.getFolder(), document.getPath());
    }
    /**
     * It generates a zip file containing the whole document file, mrt plus the image set
     * @param document
     * @return
     */
    public File exportFullDocument(Document document) {
        throw new UnsupportedOperationException("TO-DO"); // TODO tiene que ver con el MEI con facsimile y los bounding boxes (export images)
    }

    private File getDocumentFile(Document document) {
        Path path = getDocumentFolder(document);
        File file = Paths.get(path.toFile().getAbsolutePath(), document.getPath() + ".mei").toFile();
        return file;
    }
    public synchronized DocumentScoreSong getDocumentScoreSong(Document document) throws IM3WSException {
        DocumentScoreSong documentScoreSong = documentScoreSongHashMap.get(document.getId());
        if (documentScoreSong == null) {
            File file = getDocumentFile(document);
            documentScoreSong = new DocumentScoreSong(file, document.getNotationType());
            documentScoreSongHashMap.put(document.getId(), documentScoreSong);
        }
        return documentScoreSong;
    }

    /**
     * It generates the IIIF manifest file and saves it. If it existed, it would replace it keeping always the last copy
     * @return
     */
    public IIIFModel generateIIIFManifestFile(Document document) throws IM3WSException {
        IIIFModel model = new IIIFModel();
        JSONObject manifestJSON = new JSONObject();
        //TODO ¿ponemos también la colección?
        String baseID = muretConfiguration.getBaseIIIFManifestURI() + "/" + document.getPath();
        String manifestURL = baseID + "/manifest.json";
        manifestJSON.put("@id", manifestURL);
        manifestJSON.put("label", document.getName() + document.getComposer()!=null? " " + document.getComposer() : "");
        manifestJSON.put("logo", "https://muret.dlsi.ua.es/muret/assets/images/logos/uacolor.jpg");
        manifestJSON.put("description", "Transcription from " + document.getName() + " using MuRET");
        JSONArray sequencesJSON = new JSONArray();
        JSONObject sequenceJSON = new JSONObject();
        JSONArray canvasesJSON = new JSONArray();

        int canvasN = 1;
        for (Image image: document.getSortedImages()) {
            JSONObject canvasJSON = new JSONObject();
            String canvasID = baseID + "/canvas/f" + canvasN;
            model.addCanvas(image, canvasID);
            canvasJSON.put("@id", canvasID);
            canvasJSON.put("@type", "sc:Canvas");
            canvasJSON.put("label", image.getFilename());
            canvasJSON.put("width", image.getWidth());
            canvasJSON.put("height", image.getHeight());

            JSONArray imagesJSON = new JSONArray();
            JSONObject jsonImageJSON = new JSONObject();
            jsonImageJSON.put("motivation", "sc:painting");
            jsonImageJSON.put("on", canvasID);

            JSONObject resourceJSON = new JSONObject();
            resourceJSON.put("format", "image/jpeg"); //TODO - ¿tenemos también tiff?
            JSONObject serviceJSON = new JSONObject();
            serviceJSON.put("@context", "http://iiif.io/api/image/2/context.json");
            serviceJSON.put("profile", "http://iiif.io/api/image/2/level2.json");
            String imageID = muretConfiguration.getBaseIIIFImagesURI() + "/" + document.getPath()
                    + muretConfiguration.getPathSeparatorIIIF()
                    + MURETConfiguration.MASTER_IMAGES
                    + muretConfiguration.getPathSeparatorIIIF()
                    + image.getFilename();
            serviceJSON.put("@id", imageID);
            resourceJSON.put("service", serviceJSON);
            resourceJSON.put("width", image.getWidth());
            resourceJSON.put("height", image.getHeight());
            resourceJSON.put("@id", imageID);
            resourceJSON.put("@type", "dctypes:Image");
            jsonImageJSON.put("resource", resourceJSON);
            jsonImageJSON.put("@type", "oa:Annotation");
            imagesJSON.add(jsonImageJSON);
            canvasJSON.put("images", imagesJSON);
            canvasesJSON.add(canvasJSON);
            canvasN++;
        }
        sequenceJSON.put("canvases", canvasesJSON);
        sequenceJSON.put("label", "Current Page Order");
        sequenceJSON.put("@type", "sc:Sequence");
        sequenceJSON.put("@id", baseID + "/sequence/default");
        sequencesJSON.add(sequenceJSON);
        manifestJSON.put("sequences", sequencesJSON);
        manifestJSON.put("@type", "sc:Manifest");
        manifestJSON.put("@context", "http://iiif.io/api/presentation/2/context.json");


        //Write JSON file
        String pathIIIF = muretConfiguration.getFolderIIIF();
        File outputFolder = new File(pathIIIF, document.getPath());
        outputFolder.mkdir();
        File outputFile = new File(outputFolder, "manifest.json");
        try (FileWriter file = new FileWriter(outputFile)) {
            file.write(manifestJSON.toJSONString().replace("\\/", "/")); // avoid escape characters
            file.flush();

        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot write manifest JSON", e);
            throw new IM3WSException("Cannot write manifest JSON");
        }
        model.setManifestFile(baseID + "/manifest.json");
        return model;
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


    public Notation render(Document document, String partName, Long regionID, NotationType notationType, ManuscriptType manuscriptType, boolean mensustriche, Renderer renderer) throws IM3WSException {
        DocumentScoreSong documentScoreSong = getDocumentScoreSong(document);
        DocumentScoreSongPart documentScorePart = documentScoreSong.getScorePart(partName);
        DocumentScoreSongSystem documentScoreSystem = documentScorePart.getScoreSongSystem(regionID);
        if (documentScoreSystem == null) {
            throw new IM3WSException("Cannot find score system for region ID " + regionID + " in part '" + partName + "'");
        }

        Segment segment = new Segment(documentScoreSystem.getFrom(), documentScoreSystem.getTo());
        return render(documentScorePart.getScorePart(), segment, notationType, manuscriptType, mensustriche, renderer);
    }*/

    public void addPart(Document document, String partName) throws IM3WSException {
        DocumentScoreSong documentScoreSong = getDocumentScoreSong(document);
        documentScoreSong.addPart(partName);
    }

    /**
     * It removes the document and associated files (.mei)
     * @param document
     */
    public void delete(Document document) {
        File file = getDocumentFile(document);
        file.delete();
        documentScoreSongHashMap.remove(document);
    }


    //TODO Ahora sólo lo guardo en la región
    /*public void addSemanticEncoding(Document document, String partName, long regionID, BoundingBox boundingBox, String semanticEncodingString) throws IM3WSException {
        try {
            if (document.getNotationType() != NotationType.eMensural) {
                throw new IM3WSException("Currently only mensural notation is supported");
            }
            MensSemanticImporter importer = new MensSemanticImporter();
            SemanticEncoding semanticEncoding = importer.importString(NotationType.eMensural, semanticEncodingString);
            addSemanticEncoding(document, partName, regionID, boundingBox, semanticEncoding);
        } catch (Exception e) {
            throw new IM3WSException(e);
        }

    }
    public void addSemanticEncoding(Document document, String partName, long regionID, BoundingBox boundingBox, SemanticEncoding semanticEncoding) throws IM3WSException {
        DocumentScoreSong documentScoreSong = getDocumentScoreSong(document);
        DocumentScoreSongPart documentScorePart = documentScoreSong.getScorePart(partName);
        DocumentScoreSongSystem documentScoreSystem = documentScorePart.getScoreSongSystem(regionID);
        if (documentScoreSystem == null) {
            documentScoreSystem = documentScorePart.addDocumentScoreSystem(regionID, boundingBox);
            //TODO añadir a page
        }

        documentScorePart.addSemanticEncoding(documentScoreSystem, semanticEncoding);
        documentScoreSong.save();
    }
*/
    /**
     * It removes all elements in the part
     */
    /*public void clearSystem(Document document, String partName, long regionID) {
        //TODO
    }*/

    //TODO esto sólo funciona con 1 pentagrama y 1 layer
    /*public void addToPart(DocumentScoreSongPart part, ITimedElementInStaff timedElementInStaff) throws IM3Exception {
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
}
