package es.ua.dlsi.grfia.im3ws.controller;

/**
 * Used to communicate the status of a PUT HTTP operation
 */
public class ChangeResponse<T> {
    boolean ok;
    String message;
    T content;

    public ChangeResponse() {
        this.ok = true;
    }

    public ChangeResponse(T content) {
        this.ok = true;
        this.content = content;
    }

    public ChangeResponse(boolean ok, T content, String message) {
        this.ok = ok;
        this.content = content;
        this.message = message;
    }

    public boolean isOk() {
        return ok;
    }

    public String getMessage() {
        return message;
    }

    public T getContent() {
        return content;
    }
}
