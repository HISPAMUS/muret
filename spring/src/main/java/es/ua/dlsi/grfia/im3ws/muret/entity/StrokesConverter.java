package es.ua.dlsi.grfia.im3ws.muret.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Converter
public class StrokesConverter implements AttributeConverter<Strokes, String> {
    private static String COMMA = ",";

    @Override
    public String convertToDatabaseColumn(Strokes strokes) {
        if (strokes != null) {
            String result = strokes.toDatabaseString();
            if (result.length() > 8192) {
                throw new RuntimeException("Strokes too long, max is 8K: " + result.length());
            }
            return result;
        } else {
            return null;
        }
    }

    @Override
    public Strokes convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        if (s.startsWith(CalcoStrokes.PREFIX)) {
            try {
                return CalcoStrokes.parse(s);
            } catch (IOException e) {
                String message = "Cannot parse strokeList string: '" + s + "'";
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, message, e);
                throw new RuntimeException(message);
            }
        } else if (s.startsWith(IPadStrokes.PREFIX)) {
            throw new UnsupportedOperationException("TO-DO");
        } else {
            String message = "String must start with a valid prefix, invalid string='" + s + "'";
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, message);
            throw new RuntimeException(message);
        }
    }
}
