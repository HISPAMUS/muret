package es.ua.dlsi.grfia.moosicae.core;


/**
 * The fact of having the octave allows encodings such as those used in Lilypond, or F Major key mensural key signatures
 * with two B flats in different octaves.
 * Note that on adding the octave position, the key signature depends on the clef for positioning the pitches
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 01/04/2020
 */
public interface IUnconventionalKeySignature extends IKeySignature {
}
