package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.adt.dag.DAG;
import es.ua.dlsi.grfia.im4.core.adt.dag.DAGItem;

public class SemanticPart {
    DAG<SemanticItem> dag;

    public SemanticPart() {
        dag = new DAG<>();
    }

    public void add(SemanticItem semanticItem) {
        dag.add(new DAGItem<SemanticItem>(semanticItem));
    }
}
