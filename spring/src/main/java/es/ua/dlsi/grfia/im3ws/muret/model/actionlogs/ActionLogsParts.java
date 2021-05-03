package es.ua.dlsi.grfia.im3ws.muret.model.actionlogs;

import es.ua.dlsi.grfia.im3ws.muret.entity.ActionType;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.model.ActionLogModel;
import es.ua.dlsi.im3.core.IM3Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionLogsParts extends AbstractActionLogs {
    private final ActionType CREATE_PART;
    private final ActionType LINK_PART;
    private final ActionType UNLINK_PART;

    @Autowired
    public ActionLogsParts(ActionLogModel actionLogModel) throws IM3Exception {
        super(actionLogModel);
        CREATE_PART = getActionType(25);
        LINK_PART = getActionType(26);
        UNLINK_PART = getActionType(27);
    }

    public void logCreatePart(Document document) {
        log(CREATE_PART, document);
    }
    public void logLinkPart(Image image) {
        log(LINK_PART, image);
    }
    public void logUnlinkPart(Image image) {
        log(UNLINK_PART, image);
    }
}
