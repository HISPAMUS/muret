package es.ua.dlsi.grfia.im3ws.service;

import es.ua.dlsi.im3.core.TestFileUtils;
import es.ua.dlsi.im3.core.utils.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 09/07/2020
 */
public class FileUtilsTest {

    @Test
    public void isImageFile() {
        Utils utils = new Utils();
        assertTrue(utils.isImageFile(TestFileUtils.getFile("/testdata/utils/image.jpg")));
        assertTrue(utils.isImageFile(TestFileUtils.getFile("/testdata/utils/image.tiff")));
        assertTrue(utils.isImageFile(TestFileUtils.getFile("/testdata/utils/image.png")));
        assertTrue(utils.isPDF(TestFileUtils.getFile("/testdata/utils/image.pdf")));
    }

    @Test
    public void extractImagesFromPDF() throws IOException {
        File pdfFile = TestFileUtils.getFile("/testdata/utils/images.pdf");
        Utils utils = new Utils();
        File output = TestFileUtils.createTempFolder("_images_");
        List<File> result = utils.extractImagesFromPDF(pdfFile, output);

        ArrayList<File> generatedFiles = new ArrayList<>();
        FileUtils.readFiles(output, generatedFiles, "jpg");
        assertEquals("Generated JPG from PDF", 40, generatedFiles.size());
        assertEquals("Generated JPG from PDF", 40, result.size());
    }
}
