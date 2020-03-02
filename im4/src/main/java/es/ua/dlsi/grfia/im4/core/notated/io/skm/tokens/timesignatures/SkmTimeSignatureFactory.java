package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.timesignatures;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmTimeSignature;
import es.ua.dlsi.grfia.im4.utils.Factory;


public class SkmTimeSignatureFactory extends Factory<SkmTimeSignature> {
    private static SkmTimeSignatureFactory instance = null;

    public static SkmTimeSignatureFactory getInstance() {
        if (instance == null) {
            instance = new SkmTimeSignatureFactory();
        }
        return instance;
    }

    private SkmTimeSignatureFactory() {
        super("time signature");

        defaultConstructor.put(SkmTimeSignature2by2.SKM, SkmTimeSignature2by2::new);
        defaultConstructor.put(SkmTimeSignature2by4.SKM, SkmTimeSignature2by4::new);
        defaultConstructor.put(SkmTimeSignature3by4.SKM, SkmTimeSignature3by4::new);
        defaultConstructor.put(SkmTimeSignature4by4.SKM, SkmTimeSignature4by4::new);
        defaultConstructor.put(SkmTimeSignature5by4.SKM, SkmTimeSignature5by4::new);
        defaultConstructor.put(SkmTimeSignature6by4.SKM, SkmTimeSignature6by4::new);
        defaultConstructor.put(SkmTimeSignature7by4.SKM, SkmTimeSignature7by4::new);
        defaultConstructor.put(SkmTimeSignature9by4.SKM, SkmTimeSignature9by4::new);
        defaultConstructor.put(SkmTimeSignature3by8.SKM, SkmTimeSignature3by8::new);
        defaultConstructor.put(SkmTimeSignature6by8.SKM, SkmTimeSignature6by8::new);
        defaultConstructor.put(SkmTimeSignature9by8.SKM, SkmTimeSignature9by8::new);
        defaultConstructor.put(SkmTimeSignature12by8.SKM, SkmTimeSignature12by8::new);

    }
}
