package es.ua.dlsi.grfia.moosicae.io.mon;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import org.json.simple.JSONArray;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 12/04/2020
 */
public class MONExporterVisitor implements IExporterVisitor<MONExportParam> {

    @Override
    public void exportClef(IClef clef, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonClef = inputOutput.addChild("clef");

        exportCoreObject(clef, inputOutput);
        exportClefSign(clef.getSignType(), jsonClef);
        if (clef.getLine().isPresent()) {
            jsonClef.add("line", clef.getLine().get().getValue());
        }
        if (clef.getOctaveTransposition().isPresent()) {
            exportClefOctaveTransposition(clef.getOctaveTransposition().get(), jsonClef);
        }
    }

    @Override
    public void exportClefSign(IClefSign clefSign, MONExportParam inputOutput) throws IMException {
        inputOutput.add("sign", clefSign.getValue().name());
    }

    @Override
    public void exportClefOctaveTransposition(IOctaveTransposition octaveTransposition, MONExportParam inputOutput) throws IMException {
        inputOutput.add("octave", octaveTransposition.getValue());
    }


    @Override
    public void exportNote(INote note, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonNote = inputOutput.addChild("note");

        exportCoreObject(note, jsonNote);
        exportDurationalSingle(note, jsonNote);
        exportNoteHead(note.getNoteHead(), jsonNote);

    }

    private void exportDurationalSingle(IDurationalSingle durationalSingle, MONExportParam inputOutput) throws IMException {
        exportFigure(durationalSingle.getFigure(), inputOutput);
        if (durationalSingle.getDots().isPresent()) {
            exportDots(durationalSingle.getDots().get(), inputOutput);
        }
    }

    @Override
    public void exportRest(IRest rest, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonRest = inputOutput.addChild("rest");

        exportCoreObject(rest, jsonRest);
        exportDurationalSingle(rest, jsonRest);
    }

    @Override
    public void exportMultimeasureRest(IMultimeasureRest mrest, MONExportParam inputOutput) throws IMException {

    }

    @Override
    public void exportStandardTimeSignature(IStandardTimeSignature meter, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonMeter = inputOutput.addChild("standardTimeSignature");
        exportCoreObject(meter, jsonMeter);

        jsonMeter.add("numerator", meter.getNumerator().getValue());
        jsonMeter.add("denominator", meter.getDenominator().getValue());

    }

    @Override
    public void exportCutTime(ICutTime meter, MONExportParam inputOutput) throws IMException {
        inputOutput.addChild("cutTime");
    }

    @Override
    public void exportCommonTime(ICommonTime meter, MONExportParam inputOutput) throws IMException {
        inputOutput.addChild("commonTime");
    }

    @Override
    public void exportChord(IChord chord, MONExportParam inputOutput) throws IMException {

    }

    @Override
    public void exportCustos(ICustos custos, MONExportParam inputOutput) throws IMException {

    }

    @Override
    public void exportKey(IKey key, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonKey = inputOutput.addChild("key");
        exportPitchClass(key.getPitchClass(), jsonKey);
        exportMode(key.getMode(), jsonKey);
    }

    @Override
    public void exportConventionalKeySignature(IConventionalKeySignature commonAlterationKey, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonKeySignature = inputOutput.addChild("conventionalKeySignature");
        jsonKeySignature.add("accidentalCount", commonAlterationKey.getAccidentalCount().getValue());
        if (commonAlterationKey.getAccidentalSymbol().isPresent()) {
            exportAccidentalSymbol(commonAlterationKey.getAccidentalSymbol().get(), jsonKeySignature);
        }
        if (commonAlterationKey.getCautionaryAccidentals().isPresent()) {
            jsonKeySignature.add("cautionaryAccidentals", "true");
        }
    }

    @Override
    public void exportMode(IMode mode, MONExportParam inputOutput) {
        inputOutput.add("mode", mode.getValue().name());
    }

    private void exportVoiced(IVoiced item, MONExportParam jsonItem) throws IMException {
        item.export(this, jsonItem);
    }

    @Override
    public void exportVoice(IVoice voice, MONExportParam inputOutput) throws IMException {
        exportCoreObject(voice, inputOutput);

        if (voice.getName().isPresent()) {
            inputOutput.add("name", voice.getName().get().getValue());
        }

        JSONArray jsonItems = new JSONArray();
        for (IVoiced item: voice.getItems()) {
            MONExportParam jsonItem = new MONExportParam();
            exportVoiced(item, jsonItem);
            jsonItems.add(jsonItem.getJsonObject());
        }
        inputOutput.add("items", jsonItems);
    }

    @Override
    public void exportDiatonicPitch(IDiatonicPitch diatonicPitch, MONExportParam inputOutput) throws IMException {
        inputOutput.add("diatonicPitch",diatonicPitch.getValue().name());
    }

    @Override
    public void exportAccidentalSymbol(IAccidentalSymbol accidental, MONExportParam inputOutput) throws IMException {
        inputOutput.add("accidental", accidental.getValue().name());
    }

    @Override
    public void exportAlterationDisplayType(IAlterationDisplayType alterationDisplayType, MONExportParam inputOutput) throws IMException {
        inputOutput.add("display", alterationDisplayType.getValue().name());
    }

    @Override
    public void exportAlteration(IAlteration alteration, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonAlteration = inputOutput.addChild("alteration");
        exportCoreObject(alteration, jsonAlteration);
        exportAccidentalSymbol(alteration.getAccidentalSymbol(), jsonAlteration);
        if (alteration.getAlterationDisplayType().isPresent()) {
            exportAlterationDisplayType(alteration.getAlterationDisplayType().get(), jsonAlteration);
        }
    }

    @Override
    public void exportPitchClass(IPitchClass pitchClass, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonPitchClass = inputOutput.addChild("pitchClass");
        exportCoreObject(pitchClass, jsonPitchClass);
        exportDiatonicPitch(pitchClass.getDiatonicPitch(), jsonPitchClass);
        if (pitchClass.getAccidental().isPresent()) {
            exportAccidentalSymbol(pitchClass.getAccidental().get(), jsonPitchClass);
        }

    }

    @Override
    public void exportPitch(IPitch pitch, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonPitch = inputOutput.addChild("pitch");
        exportCoreObject(pitch, jsonPitch);
        exportOctave(pitch.getOctave(), jsonPitch);
        if (pitch.getAlteration().isPresent()) {
            exportAlteration(pitch.getAlteration().get(), jsonPitch);
        }
        exportDiatonicPitch(pitch.getDiatonicPitch(), jsonPitch);
    }

    @Override
    public void exportNoteHead(INoteHead noteHead, MONExportParam inputOutput) throws IMException {
        exportPitch(noteHead.getPitch(), inputOutput);
        //TODO tie
    }

    @Override
    public void exportDots(IDots dots, MONExportParam inputOutput) throws IMException {
        inputOutput.add("dots", dots.getValue());
    }

    @Override
    public void exportOctave(IOctave octave, MONExportParam inputOutput) throws IMException {
        inputOutput.add("octave", octave.getValue());
    }

    @Override
    public void exportFigure(IFigure figure, MONExportParam inputOutput) throws IMException {
        inputOutput.add("figure", figure.getValue().name());
    }

    @Override
    public void exportMetronomeMark(IMetronomeMark metronomeMark, MONExportParam inputOutput) throws IMException {
        //TODO
    }

    @Override
    public void exportBarline(IBarline barline, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonBarLine = inputOutput.addChild("barLine");
        exportCoreObject(barline, jsonBarLine);
        if (barline.getBarNumber().isPresent()) {
            jsonBarLine.add("number", barline.getBarNumber().get().getValue());
        }
        if (barline.getBarlineType().isPresent()) {
            exportBarlineType(barline.getBarlineType().get(), jsonBarLine);
        }

    }

    @Override
    public void exportBarlineType(IBarlineType barlineType, MONExportParam inputOutput) throws IMException {
        inputOutput.add("type", barlineType.getValue().name());
    }

    @Override
    public void exportPageBeginning(IPageBeginning pageBeginning, MONExportParam inputOutput) {

    }

    @Override
    public void exportSystemBeginning(ISystemBeginning systemBeginning, MONExportParam inputOutput) {

    }

    @Override
    public void exportUnconventionalKeySignature(IUnconventionalKeySignature unconventionalKeySignature, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonKS = inputOutput.addChild("unconventionalKeySignature");
        exportCoreObject(unconventionalKeySignature, jsonKS);
        JSONArray jsonArray = new JSONArray();
        for (IPitchClass pitchClass: unconventionalKeySignature.getPitchClasses()) {
            MONExportParam alteration = new MONExportParam();
            exportPitchClass(pitchClass, alteration);
            jsonArray.add(alteration);
        }
        jsonKS.add("pitchClasses", jsonArray);
    }

    private void exportCompositeMeter(ICompositeMeter meter, MONExportParam inputOutput) throws IMException {
        exportCoreObject(meter, inputOutput);
        for (IMeter submeters: meter.getSubMeters()) {
            submeters.export(this, inputOutput);
        }
    }

    @Override
    public void exportMixedMeter(IMixedMeter mixedMeter, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonMeter = inputOutput.addChild("mixedMeter");
        exportCompositeMeter(mixedMeter, jsonMeter);
    }

    @Override
    public void exportAlternatingMeter(IAlternatingMeter alternatingMeter, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonMeter = inputOutput.addChild("alternatingMeter");
        exportCompositeMeter(alternatingMeter, jsonMeter);

    }

    @Override
    public void exportAdditiveMeter(IAdditiveMeter additiveMeter, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonMeter = inputOutput.addChild("additiveMeter");
        JSONArray array = new JSONArray();
        for (ITimeSignatureNumerator numerator: additiveMeter.getNumerators()) {
                array.add(numerator.getValue());
        }
        jsonMeter.add("numerators", array);
        jsonMeter.add("denominator", additiveMeter.getDenominator().getValue());

    }

    @Override
    public void exportInterchangingMeter(IInterchangingMeter interchangingMeter, MONExportParam inputOutput) throws IMException {
        MONExportParam jsonMeter = inputOutput.addChild("interchangingMeter");
        MONExportParam jsonLeft = jsonMeter.addChild("left");
        interchangingMeter.getLeft().export(this, jsonLeft);
        MONExportParam jsonRight = jsonMeter.addChild("left");
        interchangingMeter.getRight().export(this, jsonRight);
    }

    private void exportMetadata(IMetadata metadata, MONExportParam metadata1) {
        //TODO
    }

    private void exportCoreObject(ICoreObject coreObject, MONExportParam inputOutput) {
        if (coreObject.getId().isPresent()) {
            inputOutput.add("id", coreObject.getId().get().getValue());
        }
    }

    private void exportPart(IPart part, MONExportParam inputOutput) throws IMException {
        exportCoreObject(part, inputOutput);

        if (part.getName().isPresent()) {
            inputOutput.add("name", part.getName().get().getValue());
        }

        JSONArray jsonVoices = new JSONArray();
        for (IVoice voice: part.getVoices()) {
            MONExportParam jsonVoice = new MONExportParam();
            exportVoice(voice, jsonVoice);
            jsonVoices.add(jsonVoice.getJsonObject());
        }
        inputOutput.add("voices", jsonVoices);
    }

    private void exportSystem(ISystem system, MONExportParam inputOutput) {
        if (system instanceof IStaff) {
            exportStaff((IStaff)system, inputOutput);
        } else if (system instanceof IStaffGroup) {
            exportStaffGroup((IStaffGroup)system, inputOutput);
        }
    }

    private void exportStaffGroup(IStaffGroup system, MONExportParam inputOutput) {
        MONExportParam jsonStaff = inputOutput.addChild("staffGroup");
        JSONArray jsonChildren = new JSONArray();
        for (ISystem child: system.getChildren()) {
            MONExportParam jsonChild = new MONExportParam();
            exportSystem(child, inputOutput);
            jsonChildren.add(jsonChild.getJsonObject());
        }
        jsonStaff.add("children", jsonChildren);
    }

    private void exportStaff(IStaff staff, MONExportParam inputOutput) {
        MONExportParam jsonStaff = inputOutput.addChild("staff");
        //TODO sólo definición, luego cada item debe decir dónde está - ¿cómo?
        jsonStaff.add("lines", staff.getStaffLineCount().getValue());
    }


    public void exportScore(IScore score, MONExportParam scoreParam) throws IMException {
        MONExportParam jsonMetadata = new MONExportParam();
        exportMetadata(score.getMetadata(), jsonMetadata);
        scoreParam.add("metadata", jsonMetadata.getJsonObject());

        JSONArray jsonParts = new JSONArray();
        for (IPart part: score.getParts()) {
            MONExportParam jsonPart = new MONExportParam();
            exportPart(part, jsonPart);
            jsonParts.add(jsonPart.getJsonObject());
        }
        scoreParam.add("parts", jsonParts);

        JSONArray jsonSystemElements = new JSONArray();
        for (ISystem system: score.getSystemElements()) {
            MONExportParam jsonSystem = new MONExportParam();
            exportSystem(system, jsonSystem);
            jsonSystemElements.add(jsonSystem.getJsonObject());
        }
        scoreParam.add("systems", jsonSystemElements);
    }
}
