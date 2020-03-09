package es.ua.dlsi.grfia.im4.io.skm;

import es.ua.dlsi.grfia.im4.core.IScore;
import es.ua.dlsi.grfia.im4.io.IExporter;


import java.io.File;

public class SkmExporter implements IExporter {
    @Override
    public String exportScore(IScore score) {
        StringBuilder stringBuilder = new StringBuilder();




        return stringBuilder.toString();
    }

    @Override
    public void exportScore(IScore score, File file) {

    }
}
