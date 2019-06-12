package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.im3.core.score.SystemBeginning;
import es.ua.dlsi.im3.core.score.Time;

public class ProjectScoreSongSystem {
    private final SystemBeginning systemBeginning;
    Time from;
    Time to;

    public ProjectScoreSongSystem(SystemBeginning systemBeginning) {
        this.systemBeginning = systemBeginning;
        this.from = systemBeginning.getTime();
    }

    public SystemBeginning getSystemBeginning() {
        return systemBeginning;
    }

    public Time getFrom() {
        return from;
    }

    public void setFrom(Time from) {
        this.from = from;
    }

    public Time getTo() {
        return to;
    }

    public void setTo(Time to) {
        this.to = to;
    }
}
