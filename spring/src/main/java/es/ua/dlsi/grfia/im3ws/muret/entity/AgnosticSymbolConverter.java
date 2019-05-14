package es.ua.dlsi.grfia.im3ws.muret.entity;

import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.logging.Level;
import java.util.logging.Logger;

@Converter
public class AgnosticSymbolConverter implements AttributeConverter<AgnosticSymbol, String> {
    private static String COMMA = ",";

    @Override
    public String convertToDatabaseColumn(AgnosticSymbol agnosticSymbol) {
        return agnosticSymbol.getAgnosticString();
    }

    @Override
    public AgnosticSymbol convertToEntityAttribute(String s) {
        try {
            return AgnosticSymbol.parseAgnosticString(AgnosticVersion.v2, s.trim());
        } catch (IM3Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot convert agnostic string' " + s.trim() + "'");
            throw new RuntimeException(e);
        }
    }
}
