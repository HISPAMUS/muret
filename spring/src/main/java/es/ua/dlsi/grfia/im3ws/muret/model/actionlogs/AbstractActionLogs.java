package es.ua.dlsi.grfia.im3ws.muret.model.actionlogs;

import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.ActionLogModel;
import es.ua.dlsi.im3.core.IM3Exception;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 1/4/21
 */
public abstract class AbstractActionLogs {

    protected ActionLogModel actionLogModel;

    public AbstractActionLogs(ActionLogModel actionLogModel) {
        this.actionLogModel = actionLogModel;
    }

    protected ActionType getActionType(int id) throws IM3Exception {
        Optional<ActionType> result = actionLogModel.getActionTypeRepository().findById(id);
        if (!result.isPresent()) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Cannot find action type with id " + id);
            throw new IM3Exception("Cannot find action type with id " + id);
        }
        return result.get();
    }


    public void log(ActionType actionType, Symbol symbol, String classifierID) {
        Region region = symbol.getRegion();
        Page page = region.getPage();
        Image image = page.getImage();
        Section section = image.getSection();
        Document document = image.computeDocument();
        actionLogModel.log(actionType, document.getId(), section!=null?section.getId():null, image.getId(), page.getId(), region.getId(), symbol.getId(), classifierID);
    }

    public void log(ActionType actionType, Symbol symbol) {
        log(actionType, symbol, null);
    }

    public void log(ActionType actionType, Region region, String classifierID) {
        Page page = region.getPage();
        Image image = page.getImage();
        Section section = image.getSection();
        Document document = image.computeDocument();
        actionLogModel.log(actionType, document.getId(), section!=null?section.getId():null, image.getId(), page.getId(), region.getId(), null, classifierID);
    }

    public void log(ActionType actionType, Region region) {
        log(actionType, region, null);
    }

    public void log(ActionType actionType, Page page) {
        Image image = page.getImage();
        Section section = image.getSection();
        Document document = image.computeDocument();
        actionLogModel.log(actionType, document.getId(), section!=null?section.getId():null, image.getId(), page.getId(), null, null, null);
    }

    public void log(ActionType actionType, Image image, String classifierID) {
        Section section = image.getSection();
        Document document = image.computeDocument();
        actionLogModel.log(actionType, document.getId(), section!=null?section.getId():null, image.getId(), null, null, null, classifierID);
    }

    public void log(ActionType actionType, Image image) {
        log(actionType, image, null);
    }

    public void log(ActionType actionType, Section section) {
        Document document = section.getDocument();
        actionLogModel.log(actionType, document.getId(), section.getId(), null, null, null, null, null);
    }

    public void log(ActionType actionType, Document document, String classifierID) {
        actionLogModel.log(actionType, document.getId(), null, null, null, null, null, classifierID);
    }

    public void log(ActionType actionType, Document document) {
        log(actionType, document, null);
    }

}
