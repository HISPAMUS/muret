package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.im3.core.io.ExportException;

import java.nio.file.Path;
import java.util.Collection;

/**
 * It exports a training set
 * @author drizo
 */
public interface ITrainingSetExporter {
    int getId();
    String getName();
    String getDescription();

    /**
     * @param muretFolder Provided by MuRETConfiguration from controller
     * @param documentCollection
     * @return A tgz file
     * @throws ExportException
     */
    Path generate(Path muretFolder, Collection<Document> documentCollection) throws ExportException;

    boolean isAdminPermissionRequired();
}
