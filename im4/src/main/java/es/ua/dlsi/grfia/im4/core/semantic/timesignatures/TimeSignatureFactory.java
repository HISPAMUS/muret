package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

import es.ua.dlsi.grfia.im4.core.Factory;
import es.ua.dlsi.grfia.im4.core.semantic.TimeSignature;


public class TimeSignatureFactory extends Factory<TimeSignature> {
    private static TimeSignatureFactory instance = null;

    public static TimeSignatureFactory getInstance() {
        if (instance == null) {
            instance = new TimeSignatureFactory();
        }
        return instance;
    }

    private TimeSignatureFactory() {
        super("time signature");

        map.put(TimeSignature2by2.SKM, TimeSignature2by2::new);
        map.put(TimeSignature2by4.SKM, TimeSignature2by4::new);
        map.put(TimeSignature3by4.SKM, TimeSignature3by4::new);
        map.put(TimeSignature4by4.SKM, TimeSignature4by4::new);
        map.put(TimeSignature5by4.SKM, TimeSignature5by4::new);
        map.put(TimeSignature6by4.SKM, TimeSignature6by4::new);
        map.put(TimeSignature7by4.SKM, TimeSignature7by4::new);
        map.put(TimeSignature9by4.SKM, TimeSignature9by4::new);
        map.put(TimeSignature3by8.SKM, TimeSignature3by8::new);
        map.put(TimeSignature6by8.SKM, TimeSignature6by8::new);
        map.put(TimeSignature9by8.SKM, TimeSignature9by8::new);
        map.put(TimeSignature12by8.SKM, TimeSignature12by8::new);

    }
}
