package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.im3.core.IM3Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ActionLogAgnosticModel {
    private final ActionLogModel actionLogModel;
    private final ActionType CHANGE_SYMBOL_TYPE;
    private final ActionType CHANGE_SYMBOL_BOUNDING_BOX;
    private final ActionType DELETE_SYMBOL;
    private final ActionType CREATE_SYMBOL_FROM_BOUNDING_BOX;
    private final ActionType CREATE_SYMBOL_FROM_STROKES;
    private final ActionType END_TO_END;
    private final ActionType REGION_CLEAR;

    @Autowired
    public ActionLogAgnosticModel(ActionLogModel actionLogModel) throws IM3Exception {
        this.actionLogModel = actionLogModel;
        CHANGE_SYMBOL_TYPE = getActionType(1);
        CHANGE_SYMBOL_BOUNDING_BOX = getActionType(2);
        DELETE_SYMBOL = getActionType(3);
        CREATE_SYMBOL_FROM_BOUNDING_BOX = getActionType(4);
        CREATE_SYMBOL_FROM_STROKES = getActionType(5);
        END_TO_END = getActionType(6);
        REGION_CLEAR = getActionType(7);
    }

    public void log(ActionType actionType, Symbol symbol) {
        Region region = symbol.getRegion();
        Image image = region.getPage().getImage();
        Project project = image.getProject();
        actionLogModel.log(actionType, project.getId(), image.getId(), region.getId(), symbol.getId());
    }

    public void log(ActionType actionType, Region region) {
        Image image = region.getPage().getImage();
        Project project = image.getProject();
        actionLogModel.log(actionType, project.getId(), image.getId(), region.getId(), null);
    }

    private ActionType getActionType(int id) throws IM3Exception {
        Optional<ActionType> result = actionLogModel.getActionTypeRepository().findById(id);
        if (!result.isPresent()) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Cannot find action type with id " + id);
            throw new IM3Exception("Cannot find action type with id " + id);
        }
        return result.get();
    }


    public void logChangeSymbolType(Symbol symbol) {
        log(CHANGE_SYMBOL_TYPE, symbol);
    }


    public void logChangeSymbolBoundingBox(Symbol symbol) {
        log(CHANGE_SYMBOL_BOUNDING_BOX, symbol);
    }

    public void logSymbolDelete(Symbol symbol) {
        log(DELETE_SYMBOL, symbol);
    }

    public void logCreateSymbolFromBoundingBox(Symbol symbol) {
        log(CREATE_SYMBOL_FROM_BOUNDING_BOX, symbol);
    }

    public void logCreateSymbolFromStrokes(Symbol symbol) {
        log(CREATE_SYMBOL_FROM_STROKES, symbol);
    }

    public void logEndToEnd(Region region) {
        log(END_TO_END, region);
    }

    public void logRegionClear(Region region) {
        log(REGION_CLEAR, region);
    }
}
