package es.ua.dlsi.grfia.im3ws.controller;

/**
 * Used to return single strings as JSon
 */
public class StringResponse {
    String response;

    public StringResponse() {
    }

    public StringResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
