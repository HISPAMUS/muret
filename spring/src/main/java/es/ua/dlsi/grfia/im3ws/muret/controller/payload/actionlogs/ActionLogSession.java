package es.ua.dlsi.grfia.im3ws.muret.controller.payload.actionlogs;

import es.ua.dlsi.grfia.im3ws.muret.entity.Action;

import java.time.Duration;
import java.util.*;

/**
 * Since the document opens until the next document open action with that document
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 1/4/21
 */
public class ActionLogSession {
    List<ActionWithDuration> actions;
    ActionWithDuration lastAddedAction;

    public ActionLogSession() {
        this.actions = new LinkedList<>();
        this.lastAddedAction = null;
    }

    public void addAction(Action action) {
        ActionWithDuration actionWithDuration = new ActionWithDuration(action);
        if (lastAddedAction != null) {
            long seconds = Duration.between(lastAddedAction.getTimestamp().toInstant(), action.getTimestamp().toInstant()).getSeconds();
            actionWithDuration.setDurationInSeconds(seconds);
        }
        this.actions.add(actionWithDuration);
        this.lastAddedAction = actionWithDuration;
    }

    public List<ActionWithDuration> getActions() {
        return actions;
    }
}
