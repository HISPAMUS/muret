package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;

//TODO --> crear objeto??
public enum AccidentalQualifier {
    hidden ("y"),
    cautionary ("yy"),
    ficta ("Y"),
    editorial ("YY");

    AccidentalQualifier(String skmEncoding) {
        this.skmEncoding = skmEncoding;
    }

    private String skmEncoding;

    public static AccidentalQualifier findQualifier(String skmEncoding) throws IM4Exception {
        for (AccidentalQualifier accidentalQualifier: values()) {
            if (accidentalQualifier.skmEncoding.equals(skmEncoding)) {
                return accidentalQualifier;
            }
        }
        throw new IM4Exception("Cannot find an accidental qualifier with skm encoding '" + skmEncoding + "'");
    }

}
