package es.ua.dlsi.grfia.moosicae.io;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/08/2020
 */
public enum Encodings {
    MEI("mei"),
    MUSICXML("musicxml"),
    KERN("krn"),
    EKERN("ekrn"),
    MON("mon"),
    LILYPOND("ly");

    private String extension;

    Encodings(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
