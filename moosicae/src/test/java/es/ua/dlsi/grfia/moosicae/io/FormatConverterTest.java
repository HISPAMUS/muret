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
        String path = "/testdata/io/mei/exportedFromVerovio/";
        String [] extensions = new String[] {".ekrn", ".krn"};
        File input = TestFileUtils.getFile(path + filename + ".mei");
        for (String extension: extensions) {
            File output = TestFileUtils.createTempFile(filename + extension);
            //File output  = new File("/tmp/" + filename + ".ekrn");
            FormatConverter formatConverter = new FormatConverter();
            formatConverter.convert(input, output);

            List<String> expected = Files.readAllLines(TestFileUtils.getFile(path + filename + extension).toPath());
            List<String> found = Files.readAllLines(output.toPath());
            assertEquals(filename + extension, expected, found);
        }
    }

    @Test
    public void convert() throws IMException, IOException {
        String [] filenames = new String[] {
                "201005180-1_11_2", // several nested beams, natural accidental
                "201009317-1_18_2", // unrequired meter change, multirest in the middle
                "000103729-1_1_1", // this one is imported from mensural into modern and it has weird bar lines
                "220017450-1_11_1", // this one contains longa durations in modern notation
                "000102289-4_1_1", // this one includes two adjacent clef changes at the beginning
                "000107035-1_20_1", "210097473-1_11_1", "200043752-1_43_2", "000124645-10_1_1", "000122362-1_1_1", "230006508-1_9_1", "000103737-1_1_1"};
        for (String filename: filenames) {
            test(filename);
        }

    }
}
