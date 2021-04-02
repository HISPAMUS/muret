package es.ua.dlsi.grfia.im3ws.muret.controller.payload.actionlogs;

import es.ua.dlsi.grfia.im3ws.muret.entity.Action;
import es.ua.dlsi.grfia.im3ws.muret.entity.ActionType;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 1/4/21
 */
public class ActionWithDuration {
    int actionTypeID;
    long actionID;
    int userID;
    Date timestamp;
    Integer documentID;
    Long sectionID;
    Long imageID;
    Long pageID;
    Long regionID;
    Long symbolID;
    Long durationInSeconds;
    String classifierID;

    public ActionWithDuration(Action action) {
        this.actionTypeID = action.getActionType().getId();
        this.actionID = action.getId();
        this.userID = action.getUser().getId();
        this.timestamp = action.getTimestamp();
        this.documentID = action.getDocumentID();
        this.imageID = action.getImageID();
        this.regionID = action.getRegionID();
        this.symbolID = action.getSymbolID();
        this.pageID = action.getPageID();
        this.sectionID = action.getSectionID();
        this.classifierID = action.getClassifierID();
    }

    public int getActionTypeID() {
        return actionTypeID;
    }

    public void setActionTypeID(int actionTypeID) {
        this.actionTypeID = actionTypeID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getDocumentID() {
        return documentID;
    }

    public void setDocumentID(Integer documentID) {
        this.documentID = documentID;
    }

    public Long getImageID() {
        return imageID;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }

    public Long getRegionID() {
        return regionID;
    }

    public void setRegionID(Long regionID) {
        this.regionID = regionID;
    }

    public Long getSymbolID() {
        return symbolID;
    }

    public void setSymbolID(Long symbolID) {
        this.symbolID = symbolID;
    }

    public Long getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(Long durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public long getActionID() {
        return actionID;
    }

    public void setActionID(long actionID) {
        this.actionID = actionID;
    }

    public Long getSectionID() {
        return sectionID;
    }

    public void setSectionID(Long sectionID) {
        this.sectionID = sectionID;
    }

    public Long getPageID() {
        return pageID;
    }

    public void setPageID(Long pageID) {
        this.pageID = pageID;
    }

    public String getClassifierID() {
        return classifierID;
    }

    public void setClassifierID(String classifierID) {
        this.classifierID = classifierID;
    }
}
