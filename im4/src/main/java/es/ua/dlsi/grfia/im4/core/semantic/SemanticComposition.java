package es.ua.dlsi.grfia.im4.core.semantic;

import java.util.LinkedList;
import java.util.List;

/**
 * The main entry point: a musical piece, a musical composition
 * @author drizo
 */
public class SemanticComposition {
    List<SemanticPart> semanticParts;

    public SemanticComposition() {
        semanticParts = new LinkedList<>();
    }
}
