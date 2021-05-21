package es.ua.dlsi.grfia.moosicae.core.scoregraph;

import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.IMooObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;

/**
 * The nodes are implementing a double linked list. The same contents are shared among nodes in different graphs
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/5/21
 */
public interface IScoreGraph {
    IScorePartSubgraph[] getPartsSubgraphs();
    void addPartSubgraph(IScorePartSubgraph subgraph);

    IScoreStaffSubgraph[] getStavesSubgraphs();
    void addStaffSubgraph(IScoreStaffSubgraph subgraph);

    /**
     * Add a new node and link it to all subgraphs
     * @param mooObject
     */
    void addCommonContentNode(IMooObject mooObject);

    /**
     * Add a new node and link it to the specified subgraph
     * @param mooObject
     */
    void addContentNode(IScoreStaffSubgraph subgraph, IMooObject mooObject);

    IScoreGraphStartNode getStartNode();

    /**
     * Dot format for graphviz
     * @param file
     */
    void printDot(File file) throws FileNotFoundException;
}
