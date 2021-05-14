package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.io.kern.EKernExporter;
import es.ua.dlsi.grfia.moosicae.io.kern.KernExporter;
import es.ua.dlsi.grfia.moosicae.io.lilypond.LilypondExporter;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIExporter;
import es.ua.dlsi.grfia.moosicae.io.mon.MONExporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLExporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Exporter {
    private IExporter create(Encodings encoding) throws IMException {
        switch (encoding) {
            case MEI:
                return new MEIExporter();
            case MUSICXML:
                return new MusicXMLExporter();
            case MON:
                return new MONExporter();
            case LILYPOND:
                return new LilypondExporter();
            case KERN:
                return new KernExporter();
            case EKERN:
                return new EKernExporter();
            default:
                throw new IMException("Cannot export to unsupported encoding: " + encoding);
        }
    }

    public String export(IScore score, Encodings encoding) throws IMException {
        IExporter exporter = create(encoding);
        return exporter.exportScore(score);
    }

    public void export(IScore score, File file) throws IOException, IMException {
        String filename = file.getName();
        IExporter exporter = null;
        for (Encodings encoding: Encodings.values()) {
            if (filename.endsWith("." + encoding.getExtension())) {
                exporter = create(encoding);
                break;
            }
        }

        String str = exporter.exportScore(score);
        byte[] strToBytes = str.getBytes();
        Files.write(file.toPath(), strToBytes);
    }

}
