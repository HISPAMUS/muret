package es.ua.dlsi.grfia.im3ws.muret.entity;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/3/21
 */
public enum DocumentType {
    compilation, // a collection of songs, e.g. FMT or JazzMus - each section will be interpreted as a song
    incipits, // a book of incipits, e.g. Catedrales Málaga
    piece // a single composition, work
}
