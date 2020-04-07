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

    public MonodicTest(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
    }

    protected void prepareScore() {
        score = coreAbstractFactory.createScore(coreAbstractFactory.createId());
        part = coreAbstractFactory.createPart(score, coreAbstractFactory.createId(), coreAbstractFactory.createName(coreAbstractFactory.createId(), "Violin"));
        voice = coreAbstractFactory.createVoice(part, coreAbstractFactory.createId(), null);
        staff = coreAbstractFactory.createStaff(score, coreAbstractFactory.createId(), coreAbstractFactory.createStaffLineCount(5));
    }

    protected void addSmallRest()  {
        IRest rest = null;
        try {
            rest = new IRestBuilder(coreAbstractFactory).from(EFigures.SIXTEENTH).build();
        } catch (IMException e) {
            throw new IMRuntimeException(e);
        }
        score.add(voice,  staff, rest);
    }

    protected void addG2Clef() {
        IClef clef = coreAbstractFactory.createClef(coreAbstractFactory.createId(), coreAbstractFactory.createClefSign(coreAbstractFactory.createId(), EClefSigns.G), coreAbstractFactory.createClefLine(coreAbstractFactory.createId(), 2), null);
        score.add(voice, staff, clef);
    }
}
