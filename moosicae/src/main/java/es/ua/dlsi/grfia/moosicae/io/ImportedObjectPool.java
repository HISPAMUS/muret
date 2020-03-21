package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;

import java.lang.reflect.Method;
import java.util.*;

/**
 * This class maintains a collection of available objects. When a core object builder asks for being populated
 * it looks for objects in the list of available objects for those that can be assigned through setter methods
 * or methods whose name starts with "add" (used to add elements to collections)
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 21/03/2020
 */
public class ImportedObjectPool {
    public static final String SET = "set";
    public static final String ADD = "add";
    /**
     * Always insert and retrieve from the beginning of the list
     */
    private final List<Object> availableObjects;

    public ImportedObjectPool() {
        availableObjects = new LinkedList<>();
    }

    public void add(Object object) {
        availableObjects.add(0, object);
    }

    /**
     * It tries to find setters and methods starting with "add" in order to add elements to lists
     * @param target
     * @throws IMException
     */
    public void populate(CoreObjectBuilder<?> target) throws IMException {
        try {
            for (Method method : target.getClass().getMethods()) {
                if (method.getName().startsWith(SET) || method.getName().startsWith(ADD)) {
                    if (method.getParameters().length == 1) {
                        for (Object property: availableObjects) {
                            if (method.getParameters()[0].getType().isAssignableFrom(property.getClass())) {
                                method.invoke(target, property);
                                availableObjects.remove(target);
                                if (method.getName().startsWith(SET)) {
                                    break; // don't need to add other object
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new IMException(e);
        }
    }

    /*public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, IMException {
        ICoreAbstractFactory coreFactory = new CoreFactory().create();
        ImportedObjectPool importedObjectPool = new ImportedObjectPool(coreFactory);
        IPitchBuilder builder = new IPitchBuilder(coreFactory);
        IOctave octave = coreFactory.createOctave(4);
        importedObjectPool.add(octave);
        IDiatonicPitch diatonicPitch = coreFactory.createDiatonicPitch(EDiatonicPitches.B);
        importedObjectPool.add(diatonicPitch);
        String otraCosa = "Prueba";
        importedObjectPool.add(otraCosa);
        importedObjectPool.populate(builder);
        IPitch pitch = builder.build();
        importedObjectPool.add(pitch);

        IPitchBuilder builder2 = new IPitchBuilder(coreFactory);
        IOctave octave2 = coreFactory.createOctave(4);
        importedObjectPool.add(octave2);
        IDiatonicPitch diatonicPitch2 = coreFactory.createDiatonicPitch(EDiatonicPitches.G);
        importedObjectPool.add(diatonicPitch2);
        importedObjectPool.populate(builder2);
        IPitch pitch2 = builder2.build();
        importedObjectPool.add(pitch2);

        IFigure figure = coreFactory.createFigure(EFigures.WHOLE);
        importedObjectPool.add(figure);
        IChordBuilder chordBuilder = new IChordBuilder(coreFactory);
        importedObjectPool.populate(chordBuilder);
        IChord chord = chordBuilder.build();
        System.out.println(chord);
    }*/
}
