package es.ua.dlsi.grfia.moosicae.io.skm.grammar;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.utils.TestFileUtils;
import org.junit.Test;

import java.io.File;

/**
 * This test just checks the parse process does not fail
 */
public class SkmSyntaxDirectedTranslationTest {
    //TODO
    @Test
    public void importSKernMens() throws IMException {
        String [] testFileNames = {"base.skm"};

        /*for (String testFileName: testFileNames) {
            KernSyntaxDirectedTranslation skmSyntaxDirectedTranslation = new KernSyntaxDirectedTranslation(new CoreFactory().create());
            File file = TestFileUtils.getFile("/testdata/io/skm/" + testFileName);
            KernDocument imported = skmSyntaxDirectedTranslation.importSkm(file);
            // imported.printGraphDot(new File("/tmp/composition.dot"));
        }*/
    }
}
