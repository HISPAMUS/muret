package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class Notation {
    String content;
    NotationResponseType notationResponseType;

    public Notation(NotationResponseType notationResponseType, String code) {
        this.notationResponseType = notationResponseType;
        this.content = code;
    }

    public String getContent() {
        return content;
    }

    public NotationResponseType getNotationResponseType() {
        return notationResponseType;
    }
}
