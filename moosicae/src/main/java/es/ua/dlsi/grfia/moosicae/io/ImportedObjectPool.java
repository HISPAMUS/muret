package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.builders.IObjectBuilder;

import java.lang.reflect.Method;
import java.util.*;

/**
 * This class maintains a collection of available objects. When a core object builder asks for being populated
 * it looks for objects in the list of available objects for those that can be assigned through setter methods
 * or methods whose name starts with "add" (used to add elements to collections).
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 21/03/2020
 */
public class ImportedObjectPool {
    public static final String FROM = "from";
    public static final String ADD = "add";
    private final List<Object> availableObjects;

    /**
     * Other properties attached to the object not inserted to the object as properties.
     * Key = identity hash code
     */
    private final HashMap<Object, Properties> notHandledProperties;

    public ImportedObjectPool() {
        availableObjects = new LinkedList<>();
        notHandledProperties = new HashMap<>();
    }

    public void add(Object object) {
        availableObjects.add(object);
    }

    /**
     * It tries to assign (either with "add" or with "set") the source object to the target builder
     * @param sourceProperty
     * @param target
     * @return True if assigned
     * @throws IMException
     */
    public boolean assign(Object sourceProperty, IObjectBuilder<?> target) {
        try {
            for (Method method : target.getClass().getMethods()) {
                if (method.getName().equals(FROM) || method.getName().equals(ADD)) {
                    if (method.getParameters().length == 1) {
                        if (method.getParameters()[0].getType().isAssignableFrom(sourceProperty.getClass())) {
                            method.invoke(target, sourceProperty);
                            return true;
                            /*if (method.getName().equals(FROM)) {
                                return true;
                            }*/
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new IMRuntimeException(e);
        }
        return false;
    }

    /**
     * This method contains the "magic". It tries to find setters and methods starting with "add" in order to add elements to lists
     * @param target
     * @throws IMException
     */
    public void populate(IObjectBuilder<?> target) throws IMException {
            for (Iterator iterator = availableObjects.iterator(); iterator.hasNext(); ) {
                Object property = iterator.next();
                boolean assigned = assign(property, target);
                if (assigned) {
                    iterator.remove();
                }
            }
        /*try {
            for (Method method : target.getClass().getMethods()) {
                if (method.getName().equals(FROM) || method.getName().equals(ADD)) {
                    if (method.getParameters().length == 1) {
                        for (Iterator iterator = availableObjects.iterator(); iterator.hasNext(); ) {
                            Object property = iterator.next();

                            if (method.getParameters()[0].getType().isAssignableFrom(property.getClass())) {
                                method.invoke(target, property);
                                iterator.remove();
                                if (method.getName().equals(FROM)) {
                                    break; // there will not be any other method with the same signature
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new IMException(e);
        }*/
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
