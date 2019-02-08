package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.io.Serializable;

public class StringBody implements Serializable {
    String value;

    public StringBody() {
    }

    public StringBody(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
