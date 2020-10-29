package es.ua.dlsi.grfia.moosicae.core.properties;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public interface IId {
    String getValue();

    /**
     * @return True If it is generated automatically, false if set from a file import or similar
     */
    boolean isGenerated();
}
