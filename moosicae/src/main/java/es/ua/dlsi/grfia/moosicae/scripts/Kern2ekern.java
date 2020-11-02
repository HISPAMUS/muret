package es.ua.dlsi.grfia.moosicae.scripts;

import java.io.File;
import java.util.Collection;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernSyntaxDirectedTranslation2EKern;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * It migrates from kern to ekern a given folder recursively. It leaves the files in the same folder of the *krn files.
 * When traversing the folder, if the *ekern file exists, it skips the translation
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 01/11/2020
 */
public class Kern2ekern {
    public static final void main(String [] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: es.ua.dlsi.grfia.moosicae.scripts.Kern2ekern <input folder>");
        } else {
            new Kern2ekern().run(args[0]);
        }
    }

    public void run(String folderName) throws Exception {
        File folder = new File(folderName);
        if (!folder.exists()) {
            throw new Exception("Cannot find a folder name " + folderName);
        }
        Collection<File> files = FileUtils.listFiles(folder, new String[]{"krn"}, true);
        for (File krnFile: files) {
            convert(krnFile);
        }
    }

    private void convert(File kernFile) throws IMException {
        File ekernFile = new File(kernFile.getParent(), FilenameUtils.removeExtension(kernFile.getName()) + ".ekrn");
        if (ekernFile.exists()) {
            System.out.println("File " + ekernFile + " already exists");
            return;
        }
        System.out.println("------- Translating " + kernFile.getAbsolutePath() + " into " +  ekernFile.getAbsolutePath() + "-------");
        KernSyntaxDirectedTranslation2EKern kernSyntaxDirectedTranslation2EKern = new  KernSyntaxDirectedTranslation2EKern();
        kernSyntaxDirectedTranslation2EKern.translateKern(kernFile, ekernFile);
    }
}
