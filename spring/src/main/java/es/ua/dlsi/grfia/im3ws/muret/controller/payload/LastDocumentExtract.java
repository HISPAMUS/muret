package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.util.Date;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 3/2/21
 */
public class LastDocumentExtract {
    private Integer documentID;
    private String documentName;
    private Date timestamp;

    public LastDocumentExtract() {
    }

    public LastDocumentExtract(Integer documentID, String documentName, Date timestamp) {
        this.documentID = documentID;
        this.documentName = documentName;
        this.timestamp = timestamp;
    }

    public Integer getDocumentID() {
        return documentID;
    }

    public void setDocumentID(Integer documentID) {
        this.documentID = documentID;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
