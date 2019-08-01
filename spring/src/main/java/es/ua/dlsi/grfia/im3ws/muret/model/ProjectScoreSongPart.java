package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.entity.BoundingBox;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.Pair;
import es.ua.dlsi.im3.core.adt.TimedElementCollection;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.omr.encoding.semantic.Semantic2IMCore;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticEncoding;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbol;

import java.util.*;

public class ProjectScoreSongPart {
    ScorePart scorePart;
    LinkedHashMap<Long, ProjectScoreSongPage> pageList;
    LinkedHashMap<Long, ProjectScoreSongSystem> systemList;

    public ProjectScoreSongPart(ScorePart scorePart) throws IM3WSException {
        this.scorePart = scorePart;
        readPages();
        readSystems();
    }

    public ScorePart getScorePart() {
        return scorePart;
    }

    private void readPages() {
        pageList = new LinkedHashMap<>();

        // ---- pages ----
        ArrayList<PageBeginning> pageBeginningArrayList = new ArrayList<>(this.scorePart.getPageSystemBeginnings().getPageBeginnings().values());
        pageBeginningArrayList.sort(Comparator.comparing(PageBeginning::getTime));

        ProjectScoreSongPage lastPage = null;
        for (PageBeginning pageBeginning: pageBeginningArrayList) {
            ProjectScoreSongPage page = new ProjectScoreSongPage(pageBeginning);
            pageList.put(extractPageID(pageBeginning.__getID()), page);
            if (lastPage == null) {
                lastPage.setTo(pageBeginning.getTime());
            }
            lastPage = page;
        }
        if (lastPage != null) {
            lastPage.setTo(scorePart.computeScoreDuration());
        }

    }

    private void readSystems() throws IM3WSException {
        this.systemList = new LinkedHashMap<>();

        // ---- systems ----
        ArrayList<SystemBeginning> systemBeginningArrayList = new ArrayList<>(this.scorePart.getPageSystemBeginnings().getSystemBeginnings().values());
        systemBeginningArrayList.sort(Comparator.comparing(SystemBeginning::getTime));
        ProjectScoreSongSystem lastSystem = null;
        for (SystemBeginning systemBeginning: systemBeginningArrayList) {
            ProjectScoreSongSystem system = new ProjectScoreSongSystem(systemBeginning);
            if (systemBeginning.__getID() == null) {
                throw new IM3WSException("Cannot work with system beginnings without ID");
            }
            systemList.put(extractRegionID(systemBeginning.__getID()), system);
            if (lastSystem != null) {
                lastSystem.setTo(systemBeginning.getTime());
            }
            lastSystem = system;
        }
        if (lastSystem != null) {
            lastSystem.setTo(scorePart.computeScoreDuration());
        }
    }

    private Long extractPageID(String id) {
        // reference is inserted with format page_id_<muret database page id>, e.g. #page_id_102
        return Long.parseLong(id.substring(8));
    }

    private Long extractRegionID(String id) {
        // reference is inserted with format region_id_<muret database page id>, e.g. #region_id_102
        return Long.parseLong(id.substring(10));
    }

    private String generatePageID(long id) {
        return "page_id_" + id;
    }

    private String generateRegionID(long id) {
        return "region_id_" + id;
    }

    public ProjectScoreSongPage getScoreSongPage(Long id) {
        return this.pageList.get(id);
    }
    public ProjectScoreSongSystem getScoreSongSystem(Long id) {
        return this.systemList.get(id);
    }

    public ProjectScoreSongSystem addProjectScoreSystem(long regionID, BoundingBox boundingBox) throws IM3WSException {
        //TODO ¿y si no es el último?
        SystemBeginning systemBeginning = new SystemBeginning(scorePart.computeScoreDuration(), true);
        systemBeginning.__setID(generateRegionID(regionID));
        try {
            scorePart.getPageSystemBeginnings().addSystemBeginning(systemBeginning);
        } catch (IM3Exception e) {
            throw new IM3WSException(e);
        }

        ProjectScoreSongSystem projectScoreSongSystem = new ProjectScoreSongSystem(systemBeginning);
        this.systemList.put(regionID, projectScoreSongSystem);
        return projectScoreSongSystem;
    }

    public void addSemanticEncoding(ProjectScoreSongSystem projectScoreSystem, SemanticEncoding semanticEncoding) throws IM3WSException {

        Semantic2IMCore semantic2IMCore = new Semantic2IMCore();
        //TODO sólo va para un pentagrama
        ScoreLayer layer = null;
        try {
            layer = scorePart.getUniqueVoice();

            // first find the point at the score where the system is and remove from it to the next system or the end
            SystemBeginning systemBeginning = projectScoreSystem.getSystemBeginning();
            SystemBeginning nextSystemBeginning = scorePart.getPageSystemBeginnings().getSystemBeginningAfter(systemBeginning.getTime());
            if (nextSystemBeginning != null) {
                layer.remove(systemBeginning.getTime(), nextSystemBeginning.getTime());
                layer.getStaff().remove(systemBeginning.getTime(), nextSystemBeginning.getTime());
            } else {
                layer.remove(systemBeginning.getTime(), Time.TIME_MAX);
                layer.getStaff().remove(systemBeginning.getTime(), Time.TIME_MAX);
            }

            // now insert the new content
            TimeSignature lastTimeSignature = layer.getStaff().getRunningTimeSignatureOrNullAt(systemBeginning.getTime());
            KeySignature lastKeySignature = layer.getStaff().getRunningKeySignatureOrNullAt(layer.getDuration());
            List<Pair<SemanticSymbol, ITimedElementInStaff>> newElementsPairs = semantic2IMCore.convert(layer.getStaff().getNotationType(), lastTimeSignature, lastKeySignature, semanticEncoding);

            LinkedList<ITimedElementInStaff> newElements = new LinkedList<>();
            newElementsPairs.forEach(pair -> {
                newElements.add(pair.getY());
            });
            Time to = layer.insertAt(systemBeginning.getTime(), newElements);

            projectScoreSystem.setTo(to);
        } catch (IM3Exception e) {
            throw new IM3WSException(e);
        }
    }

    public Collection<ProjectScoreSongSystem> getSystems() {
        return systemList.values();
    }
}
