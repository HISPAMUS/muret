package es.ua.dlsi.grfia.moosicae.core.enums;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.utils.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/5/21
 */
public class EFiguresTest {

    @Test
    public void findDurationWithDots() throws IMException {
        ITime duration = ICoreAbstractFactory.getInstance().createTime(3, 1);
        Pair<EFigures, Integer> expected = new Pair<>(EFigures.HALF, 1);
        Pair<EFigures, Integer> actual = EFigures.findDurationWithDots(duration, ENotationTypes.eModern, 2);
        assertEquals(expected, actual);
    }
}
