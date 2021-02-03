package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.grfia.im3ws.muret.entity.LastDocument;

import java.util.Date;

/**
 * This class is used to avoid transferring too many unnecessary data
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 3/2/21
 */
public class LastDocumentExtract {
    private Integer collectionID;
    private String collectionName;
    private Integer documentID;
    private String documentName;
    private Date timestamp;

    public LastDocumentExtract() {
    }

    public LastDocumentExtract(LastDocument lastDocument) {
        this.collectionID = lastDocument.getDocument().getCollection().getId();
        this.collectionName = lastDocument.getDocument().getCollection().getName();
        this.documentID = lastDocument.getDocument().getId();
        this.documentName = lastDocument.getDocument().getName();
        this.timestamp = lastDocument.getTimestamp();
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

    public Integer getCollectionID() {
        return collectionID;
    }

    public void setCollectionID(Integer collectionID) {
        this.collectionID = collectionID;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}
