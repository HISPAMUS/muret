package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.io.ExportException;
import es.ua.dlsi.im3.core.io.ImportException;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.io.mei.MEISongExporter;
import es.ua.dlsi.im3.core.score.io.mei.MEISongImporter;
import es.ua.dlsi.im3.core.score.staves.Pentagram;

import java.io.File;
import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * This class is in charge of handling pages, systems, etc... We don't use ScoreLayout because it contains too much
 * information not required yet by our OMR
 */
public class ProjectScoreSong {
    ScoreSong scoreSong;
    NotationType notationType;
    File file;
    /**
     * key = part name
     */
    LinkedHashMap<String, ProjectScoreSongPart> parts;

    public ProjectScoreSong(File file, NotationType notationType) throws IM3WSException {
        this.notationType = notationType;
        this.file = file;
        if (file.exists()) {
            read();
        } else {
            createEmpty();
        }
    }

    private void createEmpty() throws IM3WSException {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        this.scoreSong = new ScoreSong(null); // create an empty song
        this.scoreSong.setFacsimile(new Facsimile());
        save();
    }

    public void save() throws IM3WSException {
        MEISongExporter exporter = new MEISongExporter();
        try {
            exporter.exportSongAsParts(file, scoreSong);
        } catch (ExportException e) {
            throw new IM3WSException(e);
        }
    }

    private void read() throws IM3WSException {
        MEISongImporter importer = new MEISongImporter();
        try {
            scoreSong = importer.importSong(file);
        } catch (ImportException e) {
            throw new IM3WSException(e);
        }
        readParts();
    }

    public ScoreSong getScoreSong() {
        return scoreSong;
    }

    public ProjectScoreSong(ScoreSong scoreSong) throws IM3WSException {
        this.scoreSong = scoreSong;
        if (scoreSong.getFacsimile() == null) {
            throw new IM3WSException("The project score song needs a score song with facsimile");
        }
        readParts();
    }

    private void readParts() throws IM3WSException {
        this.parts = new LinkedHashMap<>();
        for (ScorePart scorePart: scoreSong.getParts()) {
            if (scorePart.getName() == null) {
                throw new IM3WSException("Cannot work with unnamed parts");
            }
            parts.put(scorePart.getName(), new ProjectScoreSongPart(scorePart));
        }
    }


    public ProjectScoreSongPart getScorePart(String partName) {
        return this.parts.get(partName);
    }

    public ProjectScoreSongPart addPart(String partName) throws IM3WSException {
        if (this.parts == null) {
            this.parts = new LinkedHashMap<>();
        }
        ScorePart scorePart = scoreSong.addPart();
        try {
            Staff staff = new Pentagram(scoreSong, "1", 1); //TODO
            staff.setName(partName);
            staff.setNotationType(notationType);
            scoreSong.addStaff(staff);
            scorePart.setName(partName);
            scorePart.addStaff(staff);
            scorePart.addScoreLayer(staff);
        } catch (IM3Exception e) {
            throw new IM3WSException(e);
        }

        ProjectScoreSongPart projectScoreSongPart = new ProjectScoreSongPart(scorePart);
        this.parts.put(partName, projectScoreSongPart);
        this.save();
        return projectScoreSongPart;
    }

    public Collection<ProjectScoreSongPart> getScoreParts() {
        return this.parts.values();
    }

}

/*
        if (notationType == NotationType.eModern) {
            Measure measure = new Measure(song, 1);
            song.addMeasure(Time.TIME_ZERO, measure); // first measure
        }

        SemanticSymbolType propagated = null;
        for (SemanticSymbol semanticSymbol: semanticEncoding.getSymbols()) {
            propagated = semanticSymbol.getSymbol().semantic2IMCore(scoreLayer, propagated);
        }
        if (notationType == NotationType.eModern) {
            // if not closed by an ending line
            if (!song.getLastMeasure().hasEndTime()) {
                song.getLastMeasure().setEndTime(song.getSongDuration());
            }
        }
        return song;

 */
