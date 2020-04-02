package es.ua.dlsi.grfia.moosicae.io.allcore;

import es.ua.dlsi.grfia.moosicae.core.*;

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
}
