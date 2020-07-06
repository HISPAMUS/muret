package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.enums.EModes;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import org.junit.Test;

import javax.validation.constraints.NotNull;

import static org.junit.Assert.fail;

class Example {
    @NotNull
    private final String name;

    // this can be null
    private final Integer value;

    public Example(@NotNull String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}
/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class TestNotNullAnnotations {
    @Test
    public void testNotNullOK() {
        Example exampleOK = new Example("Test 1", 10);
        Example exampleOK2 = new Example("Test 1", null);
    }

    //TODO
    /*@Test (expected = java.lang.IllegalArgumentException.class)
    public void testNotNullKO() {
        Example exampleOK = new Example(null, 10);
    }*/

    /**TODO @Test (expected = java.lang.IllegalArgumentException.class)
    public void testNotNullAtICoreAbstractFactory1() {
        ICoreAbstractFactory coreAbstractFactory = new CoreFactory().create();
        // name element is required
        IName name = coreAbstractFactory.createName(coreAbstractFactory.createId(), null);
        fail("It should not arrive here: recompile with Maven and reimport project in IDE");
    }

    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testNotNullAtICoreAbstractFactory2() {
        ICoreAbstractFactory coreAbstractFactory = new CoreFactory().create();
        // name element is required
        IClef clef =  coreAbstractFactory.createClef(null, null, null, null);
        fail("It should not arrive here: recompile with Maven and reimport project in IDE");
    }*/
}
