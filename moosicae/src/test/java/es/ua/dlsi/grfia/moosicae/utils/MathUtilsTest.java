package es.ua.dlsi.grfia.moosicae.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 28/10/2020
 */
public class MathUtilsTest {

    @Test
    public void isPowerOfTwo() {
        assertFalse(MathUtils.isPowerOfTwo(0));
        assertTrue(MathUtils.isPowerOfTwo(1));
        assertTrue(MathUtils.isPowerOfTwo(2));
        assertFalse(MathUtils.isPowerOfTwo(3));
        assertTrue(MathUtils.isPowerOfTwo(4));
        assertFalse(MathUtils.isPowerOfTwo(5));
        assertFalse(MathUtils.isPowerOfTwo(6));
        assertFalse(MathUtils.isPowerOfTwo(7));
        assertTrue(MathUtils.isPowerOfTwo(8));
        assertFalse(MathUtils.isPowerOfTwo(9));
        assertFalse(MathUtils.isPowerOfTwo(10));
        assertFalse(MathUtils.isPowerOfTwo(15));
        assertTrue(MathUtils.isPowerOfTwo(16));
        assertFalse(MathUtils.isPowerOfTwo(17));
    }
}
