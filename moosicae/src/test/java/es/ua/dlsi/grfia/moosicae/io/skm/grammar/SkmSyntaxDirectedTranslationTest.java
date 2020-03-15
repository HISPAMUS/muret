package es.ua.dlsi.grfia.moosicae.io.skm.grammar;

import es.ua.dlsi.grfia.moosicae.core.CoreFactory;
import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.utils.TestFileUtils;
import org.junit.Test;

import java.io.File;

/**
 * This test just checks the parse process does not fail
 */
public class SkmSyntaxDirectedTranslationTest {
    @Test
    public void importSKernMens() throws IMException {
        String [] testFileNames = {"base.skm"};

        for (String testFileName: testFileNames) {
            SkmSyntaxDirectedTranslation skmSyntaxDirectedTranslation = new SkmSyntaxDirectedTranslation(new CoreFactory().create());
            File file = TestFileUtils.getFile("/testdata/io/skm/" + testFileName);
            SkmDocument imported = skmSyntaxDirectedTranslation.importSkm(file);
            // imported.printGraphDot(new File("/tmp/composition.dot"));
        }
    }
}
