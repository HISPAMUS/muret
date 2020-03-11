package es.ua.dlsi.grfia.im4.io.skm;

import es.ua.dlsi.grfia.im4.core.*;
import es.ua.dlsi.grfia.im4.io.AbstractExporter;
import es.ua.dlsi.grfia.im4.io.skm.builders.SkmExporterVisitor;

import java.util.LinkedList;
import java.util.List;

public class SkmExporter extends AbstractExporter<SkmExporterVisitor> {
    public SkmExporter() {
        super(new SkmExporterVisitor());
    }

    private String exportMatrix(LinkedList<LinkedList<String>> matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LinkedList<String> record: matrix) {
            boolean first = true;
            for (String field: record) {
                if (first) {
                    first = false;
                } else {
                    stringBuilder.append('\t');
                }
                stringBuilder.append(field);
            }
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }


    @Override
    public String exportScore(IScore score) {
        LinkedList<LinkedList<String>> matrix = new LinkedList<>();
        List<IVoice> voices = generateVoices(score);

        exportHeaders(matrix, voices);
        exportParts(matrix, score);
        //TODO staves, text, dynamics....
        exportSymbols(matrix, voices);

        return exportMatrix(matrix);
    }

    private List<IVoice> generateVoices(IScore score) {
        LinkedList<IVoice> result = new LinkedList<>();
        for (int ipart = score.getParts().length-1; ipart>=0; ipart--) {
            IPart part = score.getParts()[ipart];
            for (int ivoice = part.getVoices().length - 1; ivoice >= 0; ivoice--) {
                IVoice voice = part.getVoices()[ivoice];
                result.add(voice);
            }
        }
        return result;
    }

    private void exportSymbols(LinkedList<LinkedList<String>> matrix, List<IVoice> voices) {
        //TODO varios spines...
        LinkedList<String> record = addRecord(matrix);
        for (IVoice voice: voices) {
            for (IVoiced voiced: voice.getItems()) {
                StringBuilder stringBuilder = new StringBuilder();
                voiced.export(this.exporterVisitor, stringBuilder);
                record.add(stringBuilder.toString());
            }
        }
    }

    private void exportParts(LinkedList<LinkedList<String>> matrix, IScore score) {
        for (int ipart = score.getParts().length-1; ipart>=0; ipart--) {
            IPart part = score.getParts()[ipart];
            LinkedList<String> record = addRecord(matrix);
            for (int ivoice = part.getVoices().length -1; ivoice >= 0; ivoice--) {
                IVoice voice = part.getVoices()[ivoice];
                //TODO tipo
                addField(record, exportPartNumber(ipart+1));
            }
        }
    }

    private String exportPartNumber(int n) {
        return "*part" + n;
    }

    private void exportHeaders(LinkedList<LinkedList<String>> matrix, List<IVoice> voices) {
        //TODO tipo
        LinkedList<String> record = addRecord(matrix);
        for (IVoice voice: voices) {
            addField(record, "**skern");
        }
    }

    private LinkedList<String> addRecord(LinkedList<LinkedList<String>> matrix) {
        LinkedList<String> record = new LinkedList<>();
        matrix.add(record);
        return record;
    }

    private void addField(LinkedList<String> record, String field) {
        record.add(field);
    }

}
