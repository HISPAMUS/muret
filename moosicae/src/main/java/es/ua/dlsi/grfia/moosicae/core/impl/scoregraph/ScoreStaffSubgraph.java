package es.ua.dlsi.grfia.moosicae.core.impl.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.IStaff;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreStaffSubgraph;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public class ScoreStaffSubgraph extends ScoreSubgraph implements IScoreStaffSubgraph {
    private final IStaff staff;

    public ScoreStaffSubgraph(IStaff staff) {
        this.staff = staff;
    }

    @Override
    public IStaff getStaff() {
        return staff;
    }

    @Override
    public String toDotLabelString() {
        return "staff " + staff.toString();
    }
}
