package es.ua.dlsi.grfia.im4.io.skm;

import es.ua.dlsi.grfia.im4.io.IExporterContext;

public class SkmExporterContext implements IExporterContext {
    StringBuilder stringBuilder;

    public SkmExporterContext() {
        this.stringBuilder = new StringBuilder();
    }

    public void append(String string) {
        this.stringBuilder.append(string);
    }
    public void append(char character) {
        this.stringBuilder.append(character);
    }
    public void append(int integer) {
        this.stringBuilder.append(integer);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
