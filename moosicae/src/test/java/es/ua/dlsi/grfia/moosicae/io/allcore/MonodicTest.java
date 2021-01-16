package es.ua.dlsi.grfia.moosicae.io.allcore;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.IRestBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;

/**
 * Tests that only use a staff, a part and a voice
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public abstract class MonodicTest extends AbstractCoreTest {
    protected IScore score;
    protected IVoice voice;
    protected IStaff staff;
    protected IPart part;




    protected void prepareScore() {
        score = ICoreAbstractFactory.getInstance().createScore(ICoreAbstractFactory.getInstance().createId());
        part = ICoreAbstractFactory.getInstance().createPart(score, ICoreAbstractFactory.getInstance().createId(), ICoreAbstractFactory.getInstance().createName(ICoreAbstractFactory.getInstance().createId(), "Violin"));
        voice = ICoreAbstractFactory.getInstance().createVoice(part, ICoreAbstractFactory.getInstance().createId(), null);
        staff = ICoreAbstractFactory.getInstance().createStaff(score, ICoreAbstractFactory.getInstance().createId(), ICoreAbstractFactory.getInstance().createStaffLineCount(5));
    }

    protected void addSmallRest()  {
        IRest rest = null;
        try {
            rest = new IRestBuilder().from(EFigures.SIXTEENTH).build();
        } catch (IMException e) {
            throw new IMRuntimeException(e);
        }
        score.add(voice,  staff, rest);
    }

    protected void addG2Clef() {
        IClef clef = ICoreAbstractFactory.getInstance().createClef(ICoreAbstractFactory.getInstance().createId(), ICoreAbstractFactory.getInstance().createClefSign(ICoreAbstractFactory.getInstance().createId(), EClefSigns.G), ICoreAbstractFactory.getInstance().createClefLine(ICoreAbstractFactory.getInstance().createId(), 2), null);
        score.add(voice, staff, clef);
    }
}
