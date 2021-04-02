package es.ua.dlsi.grfia.im3ws.muret.model.actionlogs;

import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.ActionLogModel;
import es.ua.dlsi.im3.core.IM3Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ActionLogsAgnostic extends AbstractActionLogs {
    private final ActionType CHANGE_SYMBOL_TYPE;
    private final ActionType CHANGE_SYMBOL_BOUNDING_BOX;
    private final ActionType DELETE_SYMBOL;
    private final ActionType CREATE_SYMBOL_FROM_BOUNDING_BOX;
    private final ActionType CREATE_SYMBOL_FROM_STROKES;
    private final ActionType CHANGE_SYMBOL_VERTICAL_POSITION;
    private final ActionType CHANGE_SYMBOL_HORIZONTAL_POSITION;
    private final ActionType END_TO_END;
    private final ActionType REGION_CLEAR;

    @Autowired
    public ActionLogsAgnostic(ActionLogModel actionLogModel) throws IM3Exception {
        super(actionLogModel);
        CHANGE_SYMBOL_TYPE = getActionType(1);
        CHANGE_SYMBOL_BOUNDING_BOX = getActionType(2);
        DELETE_SYMBOL = getActionType(3);
        CREATE_SYMBOL_FROM_BOUNDING_BOX = getActionType(4);
        CREATE_SYMBOL_FROM_STROKES = getActionType(5);
        END_TO_END = getActionType(6);
        REGION_CLEAR = getActionType(7);
        CHANGE_SYMBOL_VERTICAL_POSITION = getActionType(8);
        CHANGE_SYMBOL_HORIZONTAL_POSITION = getActionType(9);
    }


    public void logChangeSymbolType(Symbol symbol) {
        log(CHANGE_SYMBOL_TYPE, symbol);
    }

    public void logChangeSymbolBoundingBox(Symbol symbol) {
        log(CHANGE_SYMBOL_BOUNDING_BOX, symbol);
    }

    public void logChangeHorizontalPosition(Symbol symbol) {
        log(CHANGE_SYMBOL_HORIZONTAL_POSITION, symbol);
    }

    public void logChangeVerticalPosition(Symbol symbol) {
        log(CHANGE_SYMBOL_VERTICAL_POSITION, symbol);
    }

    public void logSymbolDelete(Symbol symbol) {
        log(DELETE_SYMBOL, symbol);
    }

    public void logCreateSymbolFromBoundingBox(Symbol symbol, String classifierID) {
        log(CREATE_SYMBOL_FROM_BOUNDING_BOX, symbol, classifierID);
    }

    public void logCreateSymbolFromStrokes(Symbol symbol, String classifierID) {
        log(CREATE_SYMBOL_FROM_STROKES, symbol, classifierID);
    }

    public void logEndToEnd(Region region, String classifierID) {
        log(END_TO_END, region, classifierID);
    }

    public void logRegionClear(Region region) {
        log(REGION_CLEAR, region);
    }
}
