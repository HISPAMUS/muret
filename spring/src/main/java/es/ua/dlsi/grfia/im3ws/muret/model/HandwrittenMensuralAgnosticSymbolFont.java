package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.layout.fonts.PatriarcaFont;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.*;
import es.ua.dlsi.im3.omr.encoding.enums.ClefNote;
import es.ua.dlsi.im3.omr.encoding.enums.MeterSigns;

/**
 * https://paper.dropbox.com/doc/Simbolos-en-representacion-agnostica-lpRHU8fKTfRTuiklJdRW7
 * @autor drizo
 */
public class HandwrittenMensuralAgnosticSymbolFont extends AgnosticSymbolFont {
    public HandwrittenMensuralAgnosticSymbolFont() throws IM3Exception {
        super(new PatriarcaFont());
        add(new Accidental(Accidentals.flat), "accidentalFlat"); //TODO Ver TODO en es.ua.dlsi.im3.core.score.layout.coresymbols.components
        add(new Accidental(Accidentals.sharp), "accidentalSharp"); //TODO Ver TODO en es.ua.dlsi.im3.core.score.layout.coresymbols.components
        add(new Accidental(Accidentals.natural), "accidentalNatural"); //TODO Ver TODO en es.ua.dlsi.im3.core.score.layout.coresymbols.components

        add(new Clef(ClefNote.C), "cClef");
        add(new Clef(ClefNote.F), "fClef");
        add(new Clef(ClefNote.G), "gClef");
        add(new Clef(ClefNote.Fpetrucci), "mensuralFclefPetrucci");

        add(new MeterSign(MeterSigns.C), "timeSigCommon");
        add(new MeterSign(MeterSigns.Ccut), "timeSigCutTime");
        add(new MeterSign(MeterSigns.CcutZ), "timeSigProporcionMayor");
        add(new MeterSign(MeterSigns.CZ), "timeSigProporcionMenor");

        add(new Note(NoteFigures.quadrupleWholeStem, Directions.up), "quadrupleWholeStemUp");
        add(new Note(NoteFigures.quadrupleWholeStem, Directions.down), "quadrupleWholeStem");
        add(new Note(NoteFigures.tripleWholeStem, Directions.up), "tripleWholeStemUp");
        add(new Note(NoteFigures.tripleWholeStem, Directions.down), "tripleWholeStem");
        add(new Note(NoteFigures.doubleWholeStem, Directions.down), "mensuralWhiteMaxima");
        add(new Note(NoteFigures.doubleWholeStem, Directions.up), "mensuralWhiteMaximaUp");
        add(new Note(NoteFigures.doubleWhole), "doubleWhole");
        add(new Note(NoteFigures.longa, Directions.up), "mensuralWhiteLongaUp");
        add(new Note(NoteFigures.longa, Directions.down), "mensuralWhiteLonga");
        add(new Note(NoteFigures.longaBlack, Directions.up), "mensuralBlackLongaUp");
        add(new Note(NoteFigures.longaBlack, Directions.down), "mensuralBlackLonga");
        add(new Note(NoteFigures.breve), "mensuralWhiteBrevis");
        add(new Note(NoteFigures.breveBlack), "mensuralBlackBrevis");
        add(new Note(NoteFigures.whole), "mensuralBlackSemibrevisVoid");
        add(new Note(NoteFigures.wholeBlack), "mensuralBlackSemibrevis");
        add(new Note(NoteFigures.half, Directions.up), "mensuralWhiteMinima");
        add(new Note(NoteFigures.half, Directions.down), "mensuralWhiteMinimaDown");
        add(new Note(NoteFigures.quarter, Directions.up), "mensuralWhiteSemiminima");
        add(new Note(NoteFigures.quarter, Directions.down), "mensuralWhiteSemiminimaDown");
        add(new Note(NoteFigures.eighth, Directions.up), "mensuralWhiteFusa");
        add(new Note(NoteFigures.eighth, Directions.down), "mensuralWhiteFusaDown");
        add(new Note(NoteFigures.eighthVoid, Directions.up), "eighthVoid");
        add(new Note(NoteFigures.eighthVoid, Directions.down), "eighthVoidDown");
        add(new Note(NoteFigures.eighthCut, Directions.up), "mensuralWhiteSemifusa");
        add(new Note(NoteFigures.eighthCut, Directions.down), "mensuralWhiteSemifusaDown");
        add(new Note(NoteFigures.sixteenthVoid, Directions.up), "sixteenthVoid");
        add(new Note(NoteFigures.sixteenthVoid, Directions.down), "sixteenthVoidDown");

        //quadrupleWhole is represented agnostically as two longa rests
        add(new Rest(RestFigures.longa3), "mensuralRestLongaPerfecta");
        add(new Rest(RestFigures.longa2), "mensuralRestLongaImperfecta");
        add(new Rest(RestFigures.breve), "mensuralRestBrevis");
        add(new Rest(RestFigures.whole), "mensuralRestSemibrevis");
        add(new Rest(RestFigures.half), "mensuralRestMinima");
        add(new Rest(RestFigures.seminima), "mensuralRestSemiminima");
        add(new Rest(RestFigures.fusa), "mensuralRestFusa");
        add(new Rest(RestFigures.semifusa), "mensuralRestSemifusa");

        add(new VerticalLine(AgnosticVersion.v2), "barlineSingle");
        //add(new VerticalLine(AgnosticVersion.v1), "barlineSingle");

        add(new Ligature(), "ligature");

        add(new Custos(), "mensuralCustosUp");
        add(new Dot(), "augmentationDot");
        add(new Fermata(Positions.above), "fermataAbove");
        add(new Fermata(Positions.below), "fermataBelow");
        add(new RepetitionDots(), "repeatDots");
        add(new SignumCongruentiae(), "mensuralSignumUp");

        add(new Slur(StartEnd.start), "agnosticSlurStart");
        add(new Slur(StartEnd.end), "agnosticSlurEnd");

        add(new Note(new Beam(BeamType.right, 1), Directions.up), "beamedRight1");
        add(new Note(new Beam(BeamType.right, 1), Directions.down), "beamedRight1Down");
        add(new Note(new Beam(BeamType.both, 1), Directions.up), "beamedBoth1");
        add(new Note(new Beam(BeamType.both, 1), Directions.down), "beamedBoth1Down");
        add(new Note(new Beam(BeamType.left, 1), Directions.up), "beamedLeft1");
        add(new Note(new Beam(BeamType.left, 1), Directions.down), "beamedLeft1Down");


        add(new Note(new Beam(BeamType.right, 2), Directions.up), "beamedRight2");
        add(new Note(new Beam(BeamType.right, 2), Directions.down), "beamedRight2Down");
        add(new Note(new Beam(BeamType.both, 2), Directions.up), "beamedBoth2");
        add(new Note(new Beam(BeamType.both, 2), Directions.down), "beamedBoth2Down");
        add(new Note(new Beam(BeamType.left, 2), Directions.up), "beamedLeft2");
        add(new Note(new Beam(BeamType.left, 2), Directions.down), "beamedLeft2Down");

        add(new Smudge(), "smudge");
        add(new InkBlot(), "inkBlot");
        add(new PaperHole(), "paperHole");
    }
}
