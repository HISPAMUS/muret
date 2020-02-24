package es.ua.dlsi.grfia.im4.core.semantic.barlines;

import es.ua.dlsi.grfia.im4.core.Factory;
import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.semantic.BarLine;


public class BarlineFactory extends Factory<BarLine> {
    private static BarlineFactory instance = null;

    public static BarlineFactory getInstance() {
        if (instance == null) {
            instance = new BarlineFactory();
        }
        return instance;
    }

    private BarlineFactory() {
        super("barline");

        map.put(BarlineDoubleThin.CHILD_SKM, BarlineDoubleThin::new);
        map.put(BarlineFinal.CHILD_SKM, BarlineDoubleThin::new);
        map.put(BarlineHidden.CHILD_SKM, BarlineDoubleThin::new);
        map.put(BarlineLeftRepeat.CHILD_SKM, BarlineDoubleThin::new);
        map.put(BarlineLeftRightRepeat.CHILD_SKM, BarlineDoubleThin::new);
        map.put(BarlineRightRepeat.CHILD_SKM, BarlineDoubleThin::new);
        map.put(BarlineSingle.CHILD_SKM, BarlineDoubleThin::new);
    }


    /**
     *
     * @param barline may be null
     * @return
     */
    public BarLine create(String barlineTypeCode, Integer barline) throws IM4Exception {
        if (barline == null) {
            return super.create(barlineTypeCode);
        } else {
            BarLine barLine = super.create(barlineTypeCode);
            barLine.setBarNumberOnlyByFactory(barline);
            return barLine;
        }
    }
}
