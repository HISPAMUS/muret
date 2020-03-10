package es.ua.dlsi.grfia.im4.io.skm.grammar;

import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.impl.CoreFactoryImpl;
import es.ua.dlsi.grfia.im4.io.skm.SkmBuilderFactory;
import es.ua.dlsi.grfia.im4.utils.TestFileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

public class SkmImporterTest {
    @Test
    public void importSKernMens() throws IM4Exception, FileNotFoundException {
        String [] testFileNames = {"base.skm"};

        ICoreAbstractFactory coreAbstractFactory = new CoreFactoryImpl();

        for (String testFileName: testFileNames) {
            SkmSyntaxDirectedTranslation skmSyntaxDirectedTranslation = new SkmSyntaxDirectedTranslation(coreAbstractFactory);
            File file = TestFileUtils.getFile("/testdata/io/skm/" + testFileName);
            SkmDocument imported = skmSyntaxDirectedTranslation.importSkm(file);
            //TODO comprobar contenido - ahora sólo comprueba que no falla

            imported.printGraphDot(new File("/tmp/composition.dot"));
        }
    }
}
