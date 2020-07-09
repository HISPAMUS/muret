package es.ua.dlsi.grfia.im3ws.service;

import es.ua.dlsi.im3.core.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 09/07/2020
 */
public class Utils {
    private static final String TIFF = "tiff";
    private static final String TIF = "tif";
    private static final String JPG = "jpg";
    private static final String JPEG = "jpeg";
    private static final String PNG = "png";
    private static final String PDF = "pdf";

    public boolean isImageFile(File file) {
        String extension = FileUtils.getExtension(file);
        return extension.equals(TIFF)
                || extension.equals(TIF)
                ||extension.equals(JPG)
                || extension.equals(JPEG)
                || extension.equals(PNG);
        //MimetypesFileTypeMap m = new MimetypesFileTypeMap();
        //m.addMimeTypes("image png jpeg jpg tiff tif");
    }

    public boolean isPDF(File file) {
        String extension = FileUtils.getExtension(file);
        return extension.equals(PDF);
    }

    public List<File> extractImagesFromPDF(File pdfFile, File outputFolder) throws IOException {
        LinkedList<File> result = new LinkedList<>();
        String fileName = FileUtils.getFileWithoutPathOrExtension(pdfFile.getName());
        PDDocument document = PDDocument.load(pdfFile);
        PDPageTree pages = document.getDocumentCatalog().getPages();
        int pageNumber=1;
        for (int i=0; i<pages.getCount(); i++) {
            PDPage page = pages.get(i);
            PDResources pdResources = page.getResources();
            for (COSName c : pdResources.getXObjectNames()) {
                PDXObject o = pdResources.getXObject(c);
                if (o instanceof org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) {
                    File file = new File(outputFolder, fileName + "_" + pageNumber + ".jpg");
                    ImageIO.write(((org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject)o).getImage(), "jpg", file);
                    pageNumber++;
                    result.add(file);
                }
            }
        }
        return result;
    }

}
