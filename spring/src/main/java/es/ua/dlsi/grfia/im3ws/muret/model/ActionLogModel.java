package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.muret.auditing.AuditorAwareImpl;
import es.ua.dlsi.grfia.im3ws.muret.entity.Action;
import es.ua.dlsi.grfia.im3ws.muret.entity.ActionType;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import es.ua.dlsi.grfia.im3ws.muret.repository.ActionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.ActionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Used to register user actions
 */
@Component
public class ActionLogModel {
    private final ActionRepository actionRepository;
    private final ActionTypeRepository actionTypeRepository;

    @Autowired
    public ActionLogModel(ActionRepository actionRepository, ActionTypeRepository actionTypeRepository) {
        this.actionRepository = actionRepository;
        this.actionTypeRepository = actionTypeRepository;
    }

    private User getUser() {
        return AuditorAwareImpl.getCurrentUser();
    }

    public ActionRepository getActionRepository() {
        return actionRepository;
    }

    public ActionTypeRepository getActionTypeRepository() {
        return actionTypeRepository;
    }

    public void log(ActionType actionType, Integer projectID, Long imageID, Long regionID, Long symbolID) {
        try {
            Action action = new Action();
            action.setActionType(actionType);
            action.setTimestamp(new Date());
            action.setUser(getUser());

            action.setProjectID(projectID);
            action.setImageID(imageID);
            action.setRegionID(regionID);
            action.setSymbolID(symbolID);

            actionRepository.save(action);
        } catch (Throwable t) {
            // we cannot block operation because the log has not been saved
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Cannot log action", t);
        }
    }

}
