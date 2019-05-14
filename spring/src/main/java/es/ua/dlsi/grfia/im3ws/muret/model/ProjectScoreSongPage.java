package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.im3.core.score.PageBeginning;
import es.ua.dlsi.im3.core.score.Time;

public class ProjectScoreSongPage {
    private final PageBeginning pageBeginning;
    Time from;
    Time to;


    public ProjectScoreSongPage(PageBeginning pageBeginning) {
        this.pageBeginning = pageBeginning;
        this.to = pageBeginning.getTime();
    }

    public PageBeginning getPageBeginning() {
        return pageBeginning;
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
