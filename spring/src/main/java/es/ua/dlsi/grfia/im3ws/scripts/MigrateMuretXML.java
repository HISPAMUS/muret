package es.ua.dlsi.grfia.im3ws.scripts;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.utils.FileUtils;
import es.ua.dlsi.im3.core.utils.ImageUtils;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import es.ua.dlsi.im3.omr.model.entities.Image;
import es.ua.dlsi.im3.omr.model.io.XMLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// IMPORTANT: IN order to execute it, remove spring-boot-starter-tomcat
// In order to remove from database:
/*
delete from symbol;
delete from region;
delete from page;
delete from image;
delete from permissions;
delete from document;
*/
/**
 * It migrates MuRET XML files to the online version
 */
@ComponentScan("es.ua.dlsi.grfia.im3ws")
@EnableJpaRepositories("es.ua.dlsi.grfia.im3ws.muret.repository")
@EntityScan("es.ua.dlsi.grfia.im3ws.muret.entity")
public class MigrateMuretXML implements CommandLineRunner {
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    PageRepository pageRepository;
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    SymbolRepository symbolRepository;
    @Autowired
    RegionTypeRepository regionTypeRepository;
    @Autowired
    DocumentModel documentModel;

    HashMap<String, es.ua.dlsi.grfia.im3ws.muret.entity.RegionType> regionTypeHashMap;


    MURETConfiguration muretConfiguration;

    public static void main(String[] args)  {
        SpringApplication.run(MigrateMuretXML.class, args);
    }

    @Override
    public void run(String... args) throws IOException, IM3Exception {
        muretConfiguration = new MURETConfiguration(null, null, "/Applications/MAMP/htdocs/muret", null, 200, 720, true, null, null, false, null, null, null, null);

        regionTypeHashMap = new HashMap<>();
        regionTypeRepository.findAll().forEach(regionType -> regionTypeHashMap.put(regionType.getName(), regionType));
        ArrayList<File> mrts = new ArrayList<>();
        FileUtils.readFiles(new File("/Users/drizo/GCLOUDUA/HISPAMUS/muret/pruebas"), mrts, "mrt2", true); // documents with regions tagged with es.ua.dlsi.im3.omr.conversions.VicenteGilabertBoundingBoxes2MURET
        FileUtils.readFiles(new File("/Users/drizo/GCLOUDUA/HISPAMUS/muret/catedral_barcelona"), mrts, "mrt2", true); // documents with regions tagged with es.ua.dlsi.im3.omr.conversions.VicenteGilabertBoundingBoxes2MURET
        FileUtils.readFiles(new File("/Users/drizo/GCLOUDUA/HISPAMUS/muret/catedral_zaragoza"), mrts, "mrt2", true); // documents with regions tagged with es.ua.dlsi.im3.omr.conversions.VicenteGilabertBoundingBoxes2MURET

        for (File file: mrts) {
            importMuRETXML(file.getAbsolutePath()); //TODO Importar tipo de region
        }

        System.out.println("Finished");
        ConfigurableApplicationContext ctx = SpringApplication.run(MigrateMuretXML.class, args);
        SpringApplication.exit(ctx);
    }

    private void importMuRETXML(String xmlFileName) throws IM3Exception {
        try {
            System.out.println("Loading " + xmlFileName);
            XMLReader muretXMLReader = new XMLReader(AgnosticVersion.v2);

            File xmlFile = new File(xmlFileName);
            File xmlDocumentPath = xmlFile.getParentFile();
            // now Document is named Document
            es.ua.dlsi.im3.omr.model.entities.Project xmlDocument = muretXMLReader.load(xmlFile);

            Document document = new Document();
            document.setName(FileUtils.getFileWithoutPathOrExtension(xmlFile));
            document.setComposer(xmlDocument.getComposer());
            document.setComments(xmlDocument.getComments());
            document.setNotationType(xmlDocument.getNotationType());
            document.setManuscriptType(ManuscriptType.eHandwritten); // not all of them are handwritten
            // use new obtained document object
            document = documentModel.newDocument(document);

            System.out.println("\tDocument created and inserted, working with images");
            File xmlImagesPath = new File(xmlDocumentPath, "images");

            File documentPath = new File(muretConfiguration.getFolder(), document.getPath());

            for (es.ua.dlsi.im3.omr.model.entities.Image xmlImage : xmlDocument.getImages()) {
                es.ua.dlsi.grfia.im3ws.muret.entity.Image image = importImage(xmlImage, xmlImagesPath, document, documentPath);

                if (xmlImage.getPages() != null) {
                    for (es.ua.dlsi.im3.omr.model.entities.Page xmlPage : xmlImage.getPages()) {
                        es.ua.dlsi.grfia.im3ws.muret.entity.Page page = importPage(xmlPage, image);

                        for (es.ua.dlsi.im3.omr.model.entities.Region xmlRegion : xmlPage.getRegions()) {
                            es.ua.dlsi.grfia.im3ws.muret.entity.Region region = importRegion(xmlRegion, page);

                            for (es.ua.dlsi.im3.omr.model.entities.Symbol xmlSymbol : xmlRegion.getSymbols()) {
                                es.ua.dlsi.grfia.im3ws.muret.entity.Symbol symbol = importSymbol(xmlSymbol, region);
                            }
                        }
                    }
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
            throw new IM3Exception("Cannot import "+ xmlFileName);
        }
    }

    private Symbol importSymbol(es.ua.dlsi.im3.omr.model.entities.Symbol xmlSymbol, Region region) {
        /// System.out.println("\t\t\t\tImporting symbol");
        es.ua.dlsi.grfia.im3ws.muret.entity.Symbol symbol = new Symbol();
        symbol.setAgnosticSymbol(xmlSymbol.getAgnosticSymbol());
        symbol.setBoundingBox(convert(xmlSymbol.getBoundingBox()));
        symbol.setRegion(region);
        symbol.setComments(xmlSymbol.getComments());
        if (xmlSymbol.getStrokes() != null) {
            symbol.setStrokes(convert(xmlSymbol.getStrokes()));
        }
        return symbolRepository.save(symbol);
    }

    private Strokes convert(es.ua.dlsi.im3.omr.model.entities.Strokes xmlStrokes) {
        Strokes strokes = new CalcoStrokes();
        if (xmlStrokes.getStrokeList() != null) {
            for (es.ua.dlsi.im3.omr.model.entities.Stroke xmlStroke : xmlStrokes.getStrokeList()) {
                CalcoStroke stroke = new CalcoStroke();
                // remove strokes with a resolution lower than the pixel
                int prevX = 0;
                int prevY = 0;
                for (es.ua.dlsi.im3.omr.model.entities.Point xmlPoint : xmlStroke.pointsProperty()) {
                    int x = (int) Math.round(xmlPoint.getX());
                    int y = (int) Math.round(xmlPoint.getY());

                    if (prevX != x || prevY != y) {
                        stroke.addPoint(new Point(xmlPoint.getRelativeTime(), x, y));
                    }

                    prevX = x;
                    prevY = y;
                }
                ((CalcoStrokes) strokes).addStroke(stroke);
            }
        }

        return strokes;
    }

    private Region importRegion(es.ua.dlsi.im3.omr.model.entities.Region xmlRegion, Page page) throws IM3Exception {
        /// System.out.println("\t\t\tImporting region");
        es.ua.dlsi.grfia.im3ws.muret.entity.Region region = new Region();
        region.setBoundingBox(convert(xmlRegion.getBoundingBox()));
        region.setPage(page);
        region.setComments(xmlRegion.getComments());
        es.ua.dlsi.grfia.im3ws.muret.entity.RegionType regionType = regionTypeHashMap.get(xmlRegion.getRegionType().name());
        if (regionType == null) {
            throw new IM3Exception("Cannot find region type: '" + xmlRegion.getRegionType().name() + "'");
        }
        region.setRegionType(regionType);
        return regionRepository.save(region);
    }

    private Page importPage(es.ua.dlsi.im3.omr.model.entities.Page xmlPage, es.ua.dlsi.grfia.im3ws.muret.entity.Image image) {
        System.out.println("\t\tImporting page");

        es.ua.dlsi.grfia.im3ws.muret.entity.Page page = new Page();
        page.setComments(xmlPage.getComments());
        page.setBoundingBox(convert(xmlPage.getBoundingBox()));
        page.setImage(image);
        return pageRepository.save(page);
    }

    BoundingBox convert(es.ua.dlsi.im3.core.adt.graphics.BoundingBox bb) {
        return new BoundingBox((int)bb.getFromX(), (int)bb.getFromY(), (int)bb.getToX(), (int)bb.getToY());
    }

    private es.ua.dlsi.grfia.im3ws.muret.entity.Image importImage(Image xmlImage, File xmlImagesPath, Document document, File documentPath) throws IOException, IM3Exception {
        System.out.println("\tImporting image "  + xmlImage.getImageRelativeFileName());
        es.ua.dlsi.grfia.im3ws.muret.entity.Image image = new es.ua.dlsi.grfia.im3ws.muret.entity.Image();
        image.setDocument(document);
        image.setFilename(xmlImage.getImageRelativeFileName());
        image.setComments(xmlImage.getComments());


        // copy original file
        File inputImage = new File(xmlImagesPath, xmlImage.getImageRelativeFileName());
        if (!inputImage.exists()) {
            throw new IOException("Cannot find " + inputImage.getAbsolutePath());
        }
        FileUtils.copy(inputImage, new File(new File(documentPath, MURETConfiguration.MASTER_IMAGES), xmlImage.getImageRelativeFileName()));

        BufferedImage fullImage = ImageIO.read(inputImage);
        image.setHeight(fullImage.getHeight());
        image.setWidth(fullImage.getWidth());

        // copy thumbnail file
        File thumbnail = new File(new File(documentPath, MURETConfiguration.THUMBNAIL_IMAGES), xmlImage.getImageRelativeFileName());
        ImageUtils.getInstance().scaleToFitHeight(inputImage, thumbnail, muretConfiguration.getThumbnailHeight());

        // copy preview file
        File preview = new File(new File(documentPath, MURETConfiguration.PREVIEW_IMAGES), xmlImage.getImageRelativeFileName());
        ImageUtils.getInstance().scaleToFitHeight(inputImage, preview, muretConfiguration.getPreviewHeight());

        return imageRepository.save(image);
    }


}
