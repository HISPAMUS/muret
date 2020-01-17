package es.ua.dlsi.grfia.im3ws.muret.model.semantic.grammar;

import es.ua.dlsi.im3.core.TestFileUtils;
import es.ua.dlsi.im3.core.io.ImportException;
import es.ua.dlsi.im3.core.score.io.kern.HumdrumMatrix;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class SKernMensImporterTest {
    @Test
    public void importSKernMens() throws ImportException {
        String [] testFileNames = {"smens1.skm", "skern1.skm"};

        for (String testFileName: testFileNames) {
            SKernMensImporter sKernMensImporter = new SKernMensImporter();
            File file = TestFileUtils.getFile("/testdata/semantic/" + testFileName);
            HumdrumMatrix imported = sKernMensImporter.importSKernMens(file);
            assertTrue(imported.getRowCount() > 1);
        }
    }
}
