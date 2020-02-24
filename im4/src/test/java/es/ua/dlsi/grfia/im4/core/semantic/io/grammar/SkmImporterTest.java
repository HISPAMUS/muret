package es.ua.dlsi.grfia.im4.core.semantic.io.grammar;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.TestFileUtils;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class SkmImporterTest {
    @Test
    public void importSKernMens() throws IM4Exception {
        String [] testFileNames = {"smens1.skm", "skern1.skm"};

        for (String testFileName: testFileNames) {
            SkmImporter sKernMensImporter = new SkmImporter();
            File file = TestFileUtils.getFile("/testdata/semantic/" + testFileName);
            SkmMatrix imported = sKernMensImporter.importFile(file);
            assertTrue(imported.getRowCount() > 1);
        }
    }
}
