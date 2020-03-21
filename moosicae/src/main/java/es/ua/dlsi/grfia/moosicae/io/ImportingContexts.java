package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.CoreFactory;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IChordBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IDiatonicPitchBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IPitchBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;

import java.util.HashMap;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 21/03/2020
 */
public class ImportingContexts {
    private final ImportedObjectPool objectPool;
    private final HashMap<String, CoreObjectBuilder<?>> objectBuilder;

    public ImportingContexts() {
        objectBuilder = new HashMap<>();
        objectPool = new ImportedObjectPool();
    }

    public void begin(String contextName, CoreObjectBuilder<?> coreObjectBuilder) {
        objectBuilder.put(contextName, coreObjectBuilder);
    }

    public ICoreObject end(String contextName) throws IMException {
        CoreObjectBuilder<?> coreObjectBuilder = objectBuilder.get(contextName);
        if (coreObjectBuilder == null) {
            throw new IMException("Cannot find a core object builder for the context with name '" + contextName + "'");
        }
        objectPool.populate(coreObjectBuilder);
        ICoreObject coreObject = coreObjectBuilder.build();
        objectPool.add(coreObject);
        return coreObject;
    }

    private void addObjectToPool(Object object) {
        this.objectPool.add(object);
    }

    // this example simulates a parsing session
    public static void main(String[] args) throws IMException {
        ImportingContexts importingContexts = new ImportingContexts();

        ICoreAbstractFactory coreFactory = new CoreFactory().create();

        importingContexts.begin("chord", new IChordBuilder(coreFactory));
        importingContexts.begin("pitch", new IPitchBuilder(coreFactory));
        importingContexts.addObjectToPool(coreFactory.createOctave(4));
        importingContexts.begin("diatonicPitch", new IDiatonicPitchBuilder(coreFactory));
        importingContexts.addObjectToPool(EDiatonicPitches.B);
        importingContexts.end("diatonicPitch");
        importingContexts.end("pitch");


        importingContexts.begin("pitch", new IPitchBuilder(coreFactory));
        importingContexts.addObjectToPool(coreFactory.createOctave(5));
        importingContexts.begin("diatonicPitch", new IDiatonicPitchBuilder(coreFactory));
        importingContexts.addObjectToPool(EDiatonicPitches.D);
        importingContexts.end("diatonicPitch");
        importingContexts.end("pitch");

        importingContexts.begin("figure", new IPitchBuilder(coreFactory));
        importingContexts.addObjectToPool(coreFactory.createFigure(EFigures.WHOLE));
        importingContexts.end("figure");
        ICoreObject chord = importingContexts.end("chord");
        System.out.println(chord);
    }


}
