package es.ua.dlsi.grfia.moosicae.io.kern;

//TODO Spines
/**
 * Used to move contextual information between tokens (e.g. ties)
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 21/5/21
 */
public class KernExporterContext {
    private boolean tieOpened;

    public KernExporterContext() {
        tieOpened = false;
    }

    public boolean isTieOpened() {
        return tieOpened;
    }

    public void setTieOpened(boolean tieOpened) {
        this.tieOpened = tieOpened;
    }
}
