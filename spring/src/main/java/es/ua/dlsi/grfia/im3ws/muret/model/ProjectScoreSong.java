package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.io.ExportException;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.io.mei.MEISongExporter;
import es.ua.dlsi.im3.core.score.io.mei.MEISongImporter;
import es.ua.dlsi.im3.core.score.staves.Pentagram;

import java.io.File;
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

    public ProjectScoreSong(File file, NotationType notationType) throws IM3Exception {
        this.notationType = notationType;
        this.file = file;
        if (file.exists()) {
            read();
        } else {
            createEmpty();
        }
    }

    private void createEmpty() throws ExportException {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        this.scoreSong = new ScoreSong(null); // create an empty song
        this.scoreSong.setFacsimile(new Facsimile());
        save();
    }

    public void save() throws ExportException {
        MEISongExporter exporter = new MEISongExporter();
        exporter.exportSongAsParts(file, scoreSong);
    }

    private void read() throws IM3Exception {
        MEISongImporter importer = new MEISongImporter();
        scoreSong = importer.importSong(file);
        readParts();
    }

    public ScoreSong getScoreSong() {
        return scoreSong;
    }

    public ProjectScoreSong(ScoreSong scoreSong) throws IM3Exception {
        this.scoreSong = scoreSong;
        if (scoreSong.getFacsimile() == null) {
            throw new IM3Exception("The project score song needs a score song with facsimile");
        }
        readParts();
    }

    private void readParts() throws IM3Exception {
        this.parts = new LinkedHashMap<>();
        for (ScorePart scorePart: scoreSong.getParts()) {
            if (scorePart.getName() == null) {
                throw new IM3Exception("Cannot work with unnamed parts");
            }
            parts.put(scorePart.getName(), new ProjectScoreSongPart(scorePart));
        }
    }


    public ProjectScoreSongPart getScorePart(String partName) {
        return this.parts.get(partName);
    }

    public void addPart(String partName) throws IM3Exception {
        if (this.parts == null) {
            this.parts = new LinkedHashMap<>();
        }
        Staff staff = new Pentagram(scoreSong, "1", 1); //TODO
        staff.setName(partName);
        staff.setNotationType(notationType);
        scoreSong.addStaff(staff);
        ScorePart scorePart = scoreSong.addPart();
        scorePart.setName(partName);
        scorePart.addStaff(staff);
        scorePart.addScoreLayer(staff);

        ProjectScoreSongPart projectScoreSongPart = new ProjectScoreSongPart(scorePart);
        this.parts.put(partName, projectScoreSongPart);
        this.save();
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
