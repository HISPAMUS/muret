package es.ua.dlsi.grfia.moosicae.io.skm.grammar;

import es.ua.dlsi.grfia.moosicae.core.CoreFactory;
import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.io.builders.BuilderFactory;
import es.ua.dlsi.grfia.moosicae.utils.TestFileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * This test just checks the parse process does not fail
 */
public class SkmSyntaxDirectedTranslationTest {
    @Test
    public void importSKernMens() throws IMException {
        String [] testFileNames = {"base.skm"};

        BuilderFactory builderFactory = new BuilderFactory(new CoreFactory().create());

        for (String testFileName: testFileNames) {
            SkmSyntaxDirectedTranslation skmSyntaxDirectedTranslation = new SkmSyntaxDirectedTranslation(builderFactory);
            File file = TestFileUtils.getFile("/testdata/io/skm/" + testFileName);
            SkmDocument imported = skmSyntaxDirectedTranslation.importSkm(file);
            // imported.printGraphDot(new File("/tmp/composition.dot"));
        }
    }
}
