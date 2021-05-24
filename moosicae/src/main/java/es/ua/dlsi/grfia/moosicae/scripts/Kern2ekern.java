package es.ua.dlsi.grfia.moosicae.scripts;

import java.io.File;
import java.util.Collection;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernDocument;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernSyntaxDirectedTranslation;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernSyntaxDirectedTranslation2EKern;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * @deprecated Use ConvertFormat
 * It migrates from kern to ekern a given folder recursively. The ekern has the order of the tokens normalized (always in the same position).
 * It leaves the files in the same folder of the *krn files.
 * When traversing the folder, if the *ekern file exists, it skips the translation.
 *
 * The -basic option forces the exporter to keep just the minimal information required: notes, rests, etc...
 * In that case, it reads only .bkrn files (.krn files exported with humdrum command extract -i '*krn') exports adds a .bekrn suffix to the generated file name
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 01/11/2020
 */
public class Kern2ekern { // actually Bkern2ekern
    public static final void main(String [] args) throws Exception {
        if (args.length != 1 && args.length != 2) {
            System.err.println("Usage: es.ua.dlsi.grfia.moosicae.scripts.Kern2ekern <input folder> [-basic]");
        } else {
            new Kern2ekern().run(args);
        }
    }

    public void run(String [] args) throws Exception {
        String folderName = args[0];
        File folder = new File(folderName);
        if (!folder.exists()) {
            throw new Exception("Cannot find a folder name " + folderName);
        }
        boolean basic = args.length == 2 && args[1].equals("-basic");
        String extension;
        if (basic) {
            extension = "bkrn";
        } else {
            extension = "krn";
        }
        Collection<File> files = FileUtils.listFiles(folder, new String[]{extension}, true);
        for (File krnFile: files) {
            try {
                convert(krnFile, basic);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    //TODO https://dzone.com/articles/java-concurrency-multi-threading-with-executorserv
    private void convert(File kernFile, boolean basic) throws IMException {
        String suffix;
        if (basic) {
            suffix = ".bekrn";
        } else {
            suffix = ".ekrn";
        }
        File ekernFile = new File(kernFile.getParent(), FilenameUtils.removeExtension(kernFile.getName()) + suffix);
        if (ekernFile.exists()) {
            System.out.println("File " + ekernFile + " already exists");
            return;
        }
        System.out.println("------- Translating " + kernFile.getAbsolutePath() + " into " +  ekernFile.getAbsolutePath() + "-------");
        KernSyntaxDirectedTranslation2EKern kernSyntaxDirectedTranslation2EKern = new KernSyntaxDirectedTranslation2EKern();
        kernSyntaxDirectedTranslation2EKern.translateKern(kernFile, ekernFile, basic);
        //KernSyntaxDirectedTranslation directedTranslation = new KernSyntaxDirectedTranslation();
        //KernDocument kernDocument = directedTranslation.importKern(kernFile);
        //TODO Traducir a ekern usando KernSyntaxDirectedTranslation
    }
}
