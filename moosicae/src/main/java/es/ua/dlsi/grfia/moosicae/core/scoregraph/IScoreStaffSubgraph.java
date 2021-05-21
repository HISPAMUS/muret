package es.ua.dlsi.grfia.moosicae.core.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.IStaff;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public interface IScoreStaffSubgraph extends IScoreSubgraph {
    IStaff getStaff();
}
