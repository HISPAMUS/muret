package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class Notation {
    String semanticEncoding;
    String content;
    NotationResponseType notationResponseType;
    String errorMessage;

    public Notation(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Notation(NotationResponseType notationResponseType, String code, String semanticEncoding) {
        this.notationResponseType = notationResponseType;
        this.content = code;
        this.semanticEncoding = semanticEncoding;
    }


    public String getContent() {
        return content;
    }

    public NotationResponseType getNotationResponseType() {
        return notationResponseType;
    }

    public String getSemanticEncoding() {
        return semanticEncoding;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
