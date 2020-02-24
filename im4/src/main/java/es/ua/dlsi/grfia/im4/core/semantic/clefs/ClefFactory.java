package es.ua.dlsi.grfia.im4.core.semantic.clefs;


import es.ua.dlsi.grfia.im4.core.Factory;
import es.ua.dlsi.grfia.im4.core.semantic.Clef;

public class ClefFactory extends Factory<Clef> {
    private static ClefFactory instance = null;

    public static ClefFactory getInstance() {
        if (instance == null) {
            instance = new ClefFactory();
        }
        return instance;
    }

    private ClefFactory() {
        super("clef");

        map.put(ClefC1.SKM, ClefC1::new);
        map.put(ClefC2.SKM, ClefC2::new);
        map.put(ClefC3.SKM, ClefC3::new);
        map.put(ClefC4.SKM, ClefC4::new);
        map.put(ClefC5.SKM, ClefC5::new);
        map.put(ClefF2.SKM, ClefF2::new);
        map.put(ClefF3.SKM, ClefF3::new);
        map.put(ClefF4.SKM, ClefF4::new);
        map.put(ClefF4OttavaAlta.SKM, ClefF4OttavaAlta::new);
        map.put(ClefF4OttavaBassa.SKM, ClefF4OttavaBassa::new);
        map.put(ClefF4QuindicesimaAlta.SKM, ClefF4QuindicesimaAlta::new);
        map.put(ClefF4QuindicesimaBassa.SKM, ClefF4QuindicesimaBassa::new);
        map.put(ClefF5.SKM, ClefF5::new);
        map.put(ClefG1.SKM, ClefG1::new);
        map.put(ClefG2.SKM, ClefG2::new);
        map.put(ClefG2OttavaAlta.SKM, ClefG2OttavaAlta::new);
        map.put(ClefG2OttavaBassa.SKM, ClefG2OttavaBassa::new);
        map.put(ClefG2QuindicesimaAlta.SKM, ClefG2QuindicesimaAlta::new);
        map.put(ClefG2QuindicesimaBassa.SKM, ClefG2QuindicesimaBassa::new);
        map.put(ClefG3.SKM, ClefG3::new);
        map.put(ClefPercussion.SKM, ClefPercussion::new);
        map.put(ClefTab.SKM, ClefTab::new);
    }
}
