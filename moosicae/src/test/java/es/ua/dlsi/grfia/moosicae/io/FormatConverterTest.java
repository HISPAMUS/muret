package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.utils.TestFileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 12/5/21
 */
public class FormatConverterTest {
    private void test(String filename) throws IMException, IOException {
        File input = TestFileUtils.getFile("/testdata/io/mei/exportedFromVerovio/" + filename + ".mei");
        //File output  = TestFileUtils.createTempFile(filename + ".krn"); // TODO ekern
        File output  = new File("/tmp/" + filename + ".ekrn"); // TODO ekern
        FormatConverter formatConverter = new FormatConverter();
        formatConverter.convert(input, output);

        List<String> expected = Files.readAllLines(TestFileUtils.getFile("/testdata/io/mei/exportedFromVerovio/" + filename + ".ekrn").toPath());
        List<String> found = Files.readAllLines(output.toPath());
        assertEquals(filename, expected, found);
    }

    @Test
    public void convert() throws IMException, IOException {
        String [] filenames = new String[] {"200043752-1_43_2", "000124645-10_1_1", "000122362-1_1_1", "230006508-1_9_1", "000103737-1_1_1"};
        for (String filename: filenames) {
            test(filename);
        }

    }
}
