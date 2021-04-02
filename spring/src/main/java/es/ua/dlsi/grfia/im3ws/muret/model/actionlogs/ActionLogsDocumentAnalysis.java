package es.ua.dlsi.grfia.im3ws.muret.model.actionlogs;

import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.ActionLogModel;
import es.ua.dlsi.im3.core.IM3Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionLogsDocumentAnalysis extends AbstractActionLogs {
    private final ActionType AUTOMATIC;
    private final ActionType CLEAR;
    private final ActionType CREATE_REGION;
    private final ActionType DELETE_REGION;
    private final ActionType RESIZE_REGION;
    private final ActionType CHANGE_TYPE;
    private final ActionType CREATE_PAGE;
    private final ActionType DELETE_PAGE;
    private final ActionType RESIZE_PAGE;

    @Autowired
    public ActionLogsDocumentAnalysis(ActionLogModel actionLogModel) throws IM3Exception {
        super(actionLogModel);
        AUTOMATIC = getActionType(17);
        CLEAR = getActionType(33);
        CREATE_REGION = getActionType(18);
        DELETE_REGION = getActionType(19);
        RESIZE_REGION = getActionType(20);
        CHANGE_TYPE = getActionType(21);
        CREATE_PAGE = getActionType(22);
        DELETE_PAGE = getActionType(23);
        RESIZE_PAGE = getActionType(24);
    }

    public void logAutomatic(Image image, String classifierID) {
        log(AUTOMATIC, image, classifierID);
    }
    public void logCreateRegion(Image image) {
        log(CREATE_REGION, image);
    }
    public void logDeleteRegion(Region region) {
        log(DELETE_REGION, region);
    }
    public void logResizeRegion(Region region) {
        log(RESIZE_REGION, region);
    }
    public void logChangeRegionType(Region region) {
        log(CHANGE_TYPE, region);
    }
    public void logCreatePage(Image image) {
        log(CREATE_PAGE, image);
    }
    public void logDeletePage(Page page) {
        log(DELETE_PAGE, page);
    }
    public void logResizePage(Page page) {
        log(RESIZE_PAGE, page);
    }

    public void logClear(Image image) {
        log(CLEAR, image);
    }
}
