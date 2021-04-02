package es.ua.dlsi.grfia.im3ws.muret.controller.payload.actionlogs;

import es.ua.dlsi.grfia.im3ws.muret.entity.Action;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.model.actionlogs.ActionLogsDocument;
import es.ua.dlsi.im3.core.IM3Exception;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 1/4/21
 */
public class ActionLogSummary {
    Document document;
    List<ActionLogSession> sessions;

    public ActionLogSummary(Document document, List<Action> actions) throws IM3Exception {
        this.document = document;
        this.sessions = new LinkedList<>();
        this.buildSessions(actions);
    }

    private void buildSessions(List<Action> actions) throws IM3Exception {
        ActionLogSession lastSession = null;
        TreeSet<Action> sorted = new TreeSet<>(actions);
        for (Iterator<Action> actionIterator = sorted.iterator(); actionIterator.hasNext();) {
            Action action = actionIterator.next();
            if (action.getActionType().getId() == ActionLogsDocument.OPEN_DOCUMENT_ID) {
                // start a new session
                ActionLogSession actionLogSession = new ActionLogSession();
                sessions.add(actionLogSession);
                lastSession = actionLogSession;
            } else if (lastSession == null) {
                throw new IM3Exception("There is not an opened session");
            }

            lastSession.addAction(action);
        }
    }

    public List<ActionLogSession> getSessions() {
        return sessions;
    }
}
