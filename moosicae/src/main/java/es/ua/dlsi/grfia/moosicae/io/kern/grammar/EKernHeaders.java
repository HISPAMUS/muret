package es.ua.dlsi.grfia.moosicae.io.kern.grammar;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public enum EKernHeaders {
    kern ("**kern"),
    mens ("**mens"),
    skern ("**skern"),
    smens ("**smens"),
    ekern ("**ekern"),
    edynam ("**edynam"),
    dyn ("**dyn"), // old dynamics type, not supperted by VHV
    dynam ("**dynam"), // new dynamics type, supported by VHV
    harm ("**harm"),
    mxhm("**mxhm"),
    root ("**root"),
    text ("**text"),
    id ("**id");

    private final String encoding;

    EKernHeaders(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }
}
