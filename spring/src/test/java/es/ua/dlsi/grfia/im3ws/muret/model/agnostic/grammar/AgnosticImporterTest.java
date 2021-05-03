package es.ua.dlsi.grfia.im3ws.muret.model.agnostic.grammar;

import es.ua.dlsi.im3.core.TestFileUtils;
import es.ua.dlsi.im3.core.io.ImportException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

// Agnostic files are generated using the script generate.sh in the folder testdata/agnostic
/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/4/21
 */
public class AgnosticImporterTest {

    /**
     * This test just evaluates the files are correct.
     * Files to test are generated with script generate.sh in the folder testdata/agnostic
     */
    @Test
    public void importAgnostic() throws IOException, ImportException {
        File lstFile = TestFileUtils.getFile("/testdata/agnostic/files.lst");
        List<String> files = Files.readAllLines(lstFile.toPath());
        AgnosticImporter agnosticImporter = new AgnosticImporter();
        for (String filename: files) {
            File file = new File(lstFile.getParent(), filename);
            try {
                agnosticImporter.importAgnostic(file);
            } catch (ImportException e) {
                System.err.println("Error in file " + filename);
                e.printStackTrace();
                throw e;
            }
        }
    }
}
