package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.im3.core.TestFileUtils;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 4/5/21
 */
public class ImageModelTest {

    @Test
    public void computeScoreRotation() throws IOException {
        File imageFile = TestFileUtils.getFile("/testdata/imagemodel/bach-invention-01-a4.png");
        BufferedImage bufferedImage = ImageIO.read(imageFile);
        assertEquals("Rotation", 2.0, new ImageModel().computeScoreRotation(bufferedImage), 0.2);
    }
}
