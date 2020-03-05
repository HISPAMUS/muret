package es.ua.dlsi.grfia.im4.io.skm.tokens.spineoperators;

import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmSpineOperator;
import es.ua.dlsi.grfia.im4.utils.Factory;


public class SkmSpineOperatorsFactory extends Factory<SkmSpineOperator> {
    private static SkmSpineOperatorsFactory instance = null;

    public static SkmSpineOperatorsFactory getInstance() {
        if (instance == null) {
            instance = new SkmSpineOperatorsFactory();
        }
        return instance;
    }

    private SkmSpineOperatorsFactory() {
        super("spine operation");

        defaultConstructor.put(SkmSpineOperatorAdd.SKM, SkmSpineOperatorAdd::new);
        defaultConstructor.put(SkmSpineOperatorJoin.SKM, SkmSpineOperatorJoin::new);
        defaultConstructor.put(SkmSpineOperatorSplit.SKM, SkmSpineOperatorSplit::new);
        defaultConstructor.put(SkmSpineOperatorTerminate.SKM, SkmSpineOperatorTerminate::new);
    }
}
