package es.ua.dlsi.grfia.im3ws.muret.model.actionlogs;

import es.ua.dlsi.grfia.im3ws.muret.entity.ActionType;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.model.ActionLogModel;
import es.ua.dlsi.im3.core.IM3Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionLogsSemantic extends AbstractActionLogs {
    private final ActionType TRANSDUCE;
    private final ActionType LINK_SYMBOLS;
    private final ActionType UNLINK_SYMBOLS;
    private final ActionType CHANGE;
    private final ActionType CLEAR;

    @Autowired
    public ActionLogsSemantic(ActionLogModel actionLogModel) throws IM3Exception {
        super(actionLogModel);
        TRANSDUCE = getActionType(28);
        LINK_SYMBOLS = getActionType(29);
        UNLINK_SYMBOLS = getActionType(30);
        CHANGE = getActionType(31);
        CLEAR = getActionType(32);
    }

    public void logTransduce(Region region, String classifierID) {
        log(TRANSDUCE, region, classifierID);
    }
    public void logClear(Region region) {
        log(CLEAR, region);
    }
    public void logChange(Region region) {
        log(CHANGE, region);
    }
    public void logLinkSymbols(Region region) {
        log(LINK_SYMBOLS, region);
    }
    public void logUnlinkSymbols(Region region) {
        log(UNLINK_SYMBOLS, region);
    }
}
