package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.util.List;

public class MoveDocuments {
    Integer currentCollectionID;
    List<Integer> documentIDs;
    Integer subcollectionID;
    String newCollectionName;

    public MoveDocuments() {
    }

    public MoveDocuments(Integer currentCollectionID, List<Integer> documentIDs, Integer collectionID, String newCollectionName) {
        this.currentCollectionID = currentCollectionID;
        this.documentIDs = documentIDs;
        this.subcollectionID = collectionID;
        this.newCollectionName = newCollectionName;
    }

    public Integer getCurrentCollectionID() {
        return currentCollectionID;
    }

    public void setCurrentCollectionID(Integer currentCollectionID) {
        this.currentCollectionID = currentCollectionID;
    }

    public List<Integer> getDocumentIDs() {
        return documentIDs;
    }

    public void setDocumentIDs(List<Integer> documentIDs) {
        this.documentIDs = documentIDs;
    }

    public Integer getSubcollectionID() {
        return subcollectionID;
    }

    public void setSubcollectionID(Integer subcollectionID) {
        this.subcollectionID = subcollectionID;
    }

    public String getNewCollectionName() {
        return newCollectionName;
    }

    public void setNewCollectionName(String newCollectionName) {
        this.newCollectionName = newCollectionName;
    }
}
