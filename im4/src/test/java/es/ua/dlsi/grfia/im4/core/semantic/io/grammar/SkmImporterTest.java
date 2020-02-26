package es.ua.dlsi.grfia.im4.core.semantic.io.grammar;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.TestFileUtils;
import es.ua.dlsi.grfia.im4.core.semantic.SemanticComposition;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

public class SkmImporterTest {
    @Test
    public void importSKernMens() throws IM4Exception, FileNotFoundException {
        String [] testFileNames = {"base.skm"};

        for (String testFileName: testFileNames) {
            SkmSyntaxDirectedTranslation skmSyntaxDirectedTranslation = new SkmSyntaxDirectedTranslation();
            File file = TestFileUtils.getFile("/testdata/io/skm/" + testFileName);
            SemanticComposition imported = skmSyntaxDirectedTranslation.importSkm(file);
            //TODO comprobar contenido - ahora sólo comprueba que no falla

            imported.printGraphDot(new File("/tmp/composition.dot"));
        }
    }
}
