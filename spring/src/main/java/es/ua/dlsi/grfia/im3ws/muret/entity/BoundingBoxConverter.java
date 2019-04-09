package es.ua.dlsi.grfia.im3ws.muret.entity;

import es.ua.dlsi.im3.core.IM3RuntimeException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BoundingBoxConverter implements AttributeConverter<BoundingBox, String> {
    private static String COMMA = ",";

    @Override
    public String convertToDatabaseColumn(BoundingBox boundingBox) {
        if (boundingBox != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(boundingBox.getFromX());
            stringBuilder.append(',');
            stringBuilder.append(boundingBox.getFromY());
            stringBuilder.append(',');
            stringBuilder.append(boundingBox.getToX());
            stringBuilder.append(',');
            stringBuilder.append(boundingBox.getToY());
            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    @Override
    public BoundingBox convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        } else {
            String[] fields = s.split(COMMA);
            try {
                int fromX = Integer.parseInt(fields[0]);
                int fromY = Integer.parseInt(fields[1]);
                int toX = Integer.parseInt(fields[2]);
                int toY = Integer.parseInt(fields[3]);
                return new BoundingBox(fromX, fromY, toX, toY);
            } catch (IM3RuntimeException t) {
                throw t;
            } catch (Throwable t) {
                throw new RuntimeException("Invalid bounding box string, expected 4 integer fields comma separated in: '" + s + "'");
            }
        }
    }
}
