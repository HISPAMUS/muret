package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.clefs;


import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmClef;
import es.ua.dlsi.grfia.im4.utils.Factory;

public class SkmClefFactory extends Factory<SkmClef> {
    private static SkmClefFactory instance = null;

    public static SkmClefFactory getInstance() {
        if (instance == null) {
            instance = new SkmClefFactory();
        }
        return instance;
    }

    private SkmClefFactory() {
        super("clef");

        defaultConstructor.put(SkmClefC1.SKM, SkmClefC1::new);
        defaultConstructor.put(SkmClefC2.SKM, SkmClefC2::new);
        defaultConstructor.put(SkmClefC3.SKM, SkmClefC3::new);
        defaultConstructor.put(SkmClefC4.SKM, SkmClefC4::new);
        defaultConstructor.put(SkmClefC5.SKM, SkmClefC5::new);
        defaultConstructor.put(SkmClefF2.SKM, SkmClefF2::new);
        defaultConstructor.put(SkmClefF3.SKM, SkmClefF3::new);
        defaultConstructor.put(SkmClefF4.SKM, SkmClefF4::new);
        defaultConstructor.put(SkmClefF4OttavaAlta.SKM, SkmClefF4OttavaAlta::new);
        defaultConstructor.put(SkmClefF4OttavaBassa.SKM, SkmClefF4OttavaBassa::new);
        defaultConstructor.put(SkmClefF4QuindicesimaAlta.SKM, SkmClefF4QuindicesimaAlta::new);
        defaultConstructor.put(SkmClefF4QuindicesimaBassa.SKM, SkmClefF4QuindicesimaBassa::new);
        defaultConstructor.put(SkmClefF5.SKM, SkmClefF5::new);
        defaultConstructor.put(SkmClefG1.SKM, SkmClefG1::new);
        defaultConstructor.put(SkmClefG2.SKM, SkmClefG2::new);
        defaultConstructor.put(SkmClefG2OttavaAlta.SKM, SkmClefG2OttavaAlta::new);
        defaultConstructor.put(SkmClefG2OttavaBassa.SKM, SkmClefG2OttavaBassa::new);
        defaultConstructor.put(SkmClefG2QuindicesimaAlta.SKM, SkmClefG2QuindicesimaAlta::new);
        defaultConstructor.put(SkmClefG2QuindicesimaBassa.SKM, SkmClefG2QuindicesimaBassa::new);
        defaultConstructor.put(SkmClefG3.SKM, SkmClefG3::new);
        defaultConstructor.put(SkmClefPercussion.SKM, SkmClefPercussion::new);
        defaultConstructor.put(SkmClefTab.SKM, SkmClefTab::new);
    }
}
