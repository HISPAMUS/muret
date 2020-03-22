package es.ua.dlsi.grfia.moosicae.io.lilypond;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.core.IStaff;
import es.ua.dlsi.grfia.moosicae.core.ICoreItem;
import es.ua.dlsi.grfia.moosicae.io.IExporter;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 18/03/2020
 */
public class LilypondExporter implements IExporter {
    @Override
    public String exportScore(IScore score) throws IMException {
        List<ILilypondElement> output = new LinkedList<>();
        output.add(new LilypondLine("\\version \"2.20\"\n"));
        LilypondContext scoreContext = new LilypondContext("score", false);
        output.add(scoreContext);
        export(scoreContext, score);

        StringBuilder stringBuilder = new StringBuilder();
        for (ILilypondElement lilypondElement: output) {
            stringBuilder.append(lilypondElement.export(0));
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    private void export(LilypondContext scoreContext, IScore score) throws IMException {
        LilypondExporterVisitor lilypondExporterVisitor = new LilypondExporterVisitor();
        for (IStaff staff: score.getAllStaves()) {
            LilypondContext staffContext = new LilypondContext("Staff", true);
            scoreContext.addChild(staffContext);
            for (ICoreItem staffElement: staff.getStaffSymbols()) {
                LilypondExporterVisitorParam lilypondExporterVisitorParam = new LilypondExporterVisitorParam(staffContext);
                staffElement.export(lilypondExporterVisitor, lilypondExporterVisitorParam);
            }
        }
    }
}
