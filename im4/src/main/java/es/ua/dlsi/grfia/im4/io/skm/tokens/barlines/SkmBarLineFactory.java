package es.ua.dlsi.grfia.im4.io.skm.tokens.barlines;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmBarLine;
import es.ua.dlsi.grfia.im4.utils.Factory;
import es.ua.dlsi.grfia.im4.core.IM4Exception;

public class SkmBarLineFactory extends Factory<SkmBarLine> {
    private static SkmBarLineFactory instance = null;

    public static SkmBarLineFactory getInstance() {
        if (instance == null) {
            instance = new SkmBarLineFactory();
        }
        return instance;
    }

    private SkmBarLineFactory() {
        super("barline");

        defaultConstructor.put(SkmBarLineDoubleThin.CHILD_SKM, SkmBarLineDoubleThin::new);
        integerConstructor.put(SkmBarLineDoubleThin.CHILD_SKM, SkmBarLineDoubleThin::new);

        defaultConstructor.put(SkmBarLineFinal.CHILD_SKM, SkmBarLineFinal::new);
        integerConstructor.put(SkmBarLineFinal.CHILD_SKM, SkmBarLineFinal::new);

        defaultConstructor.put(SkmBarLineHidden.CHILD_SKM, SkmBarLineHidden::new);
        integerConstructor.put(SkmBarLineHidden.CHILD_SKM, SkmBarLineHidden::new);

        defaultConstructor.put(SkmBarLineLeftRepeat.CHILD_SKM, SkmBarLineLeftRepeat::new);
        integerConstructor.put(SkmBarLineLeftRepeat.CHILD_SKM, SkmBarLineLeftRepeat::new);

        defaultConstructor.put(SkmBarLineLeftRightRepeat.CHILD_SKM, SkmBarLineLeftRightRepeat::new);
        integerConstructor.put(SkmBarLineLeftRightRepeat.CHILD_SKM, SkmBarLineLeftRightRepeat::new);

        defaultConstructor.put(SkmBarLineRightRepeat.CHILD_SKM, SkmBarLineRightRepeat::new);
        integerConstructor.put(SkmBarLineRightRepeat.CHILD_SKM, SkmBarLineRightRepeat::new);

        defaultConstructor.put(SkmBarLineSingle.CHILD_SKM, SkmBarLineSingle::new);
        integerConstructor.put(SkmBarLineSingle.CHILD_SKM, SkmBarLineSingle::new);
    }

    public SkmBarLine create(String barlineTypeCode, Integer barNumber) throws IM4Exception {
        if (barNumber == null) {
            return super.create(barlineTypeCode);
        } else {
            return super.create(barlineTypeCode, barNumber);
        }
    }
}
