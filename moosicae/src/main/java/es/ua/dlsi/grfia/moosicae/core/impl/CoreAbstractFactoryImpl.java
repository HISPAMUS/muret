package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations.*;
import es.ua.dlsi.grfia.moosicae.core.mensural.*;
import es.ua.dlsi.grfia.moosicae.core.metadata.ITitle;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class CoreAbstractFactoryImpl implements ICoreAbstractFactory {
    @Override
    public IAlteration createAlteration(EAccidentals accidentals, Optional<EAlterationDisplayType> alterationDisplayType) {
        return new Alteration(accidentals, alterationDisplayType);
    }

    @Override
    public IChord createChord(EFigures figures, Optional<IDots> dots, IPitch[] pitches) {
        return new Chord(figures, dots, pitches);
    }

    @Override
    public IClef createClef(int line, EClefSigns clefSign) {
        return new Clef(line, clefSign);
    }

    @Override
    public ICommonTime createCommonTime() {
        return new CommonTime();
    }

    @Override
    public ICustos createCustos(IPitch pitch) {
        return new Custos(pitch);
    }

    @Override
    public ICutTime createCutTime() {
        return new CutTime();
    }


    @Override
    public IKeySignature createKeySignature(IPitchClass[] pitchClasses) {
        return new KeySignature(pitchClasses);
    }

    @Override
    public IFractionalTimeSignature createFractionalTimeSignature(int numerator, int denominator) {
        return new FractionalTimeSignature(numerator, denominator);
    }

    @Override
    public IMensuration createMensuration(EMensuralPerfections modusMaior, EMensuralPerfections modusMinor, EMensuralPerfections tempus, EMensuralPerfections prolatio) {
        Mensuration result;

        switch (tempus) {
            case imperfectum:
                if (prolatio == EMensuralPerfections.imperfectum) {
                    result = new TempusImperfectumCumProlationeImperfecta();
                } else if (prolatio == EMensuralPerfections.perfectum) {
                    result = new TempusImperfectumCumProlationePerfecta();
                } else {
                    throw new IMRuntimeException("Invalid prolatio: " + prolatio);
                }
                break;
            case perfectum:
                if (prolatio == EMensuralPerfections.imperfectum) {
                    result = new TempusPerfectumCumProlationeImperfecta();
                } else if (prolatio == EMensuralPerfections.perfectum) {
                    result = new TempusPerfectumCumProlationePerfecta();
                } else {
                    throw new IMRuntimeException("Invalid prolatio: " + prolatio);
                }
                break;
            default:
                throw new IMRuntimeException("Invalid tempus: " + tempus);
        }

        if (modusMaior != null) {
            result.setModusMaior(modusMaior);
        }
        if (modusMinor != null) {
            result.setModusMinor(modusMinor);
        }
        return result;
    }

    @Override
    public IMultimeasureRest createMultimeasureRest(EFigures figure, int measureCount) {
        return new MultimeasureRest(figure, measureCount);
    }

    @Override
    public INote createNote(EFigures figures, Optional<IDots> dots, IPitch pitches) {
        return new Note(figures, dots, pitches);
    }


    @Override
    public IPitch createPitch(IOctave octave, IAlteration alteration, EDiatonicPitches diatonicPitch) {
        return new Pitch(octave, alteration,  diatonicPitch);
    }

    @Override
    public IProportioChangeDupla createProportioChangeDupla() {
        return new ProportioChangeDupla();
    }

    @Override
    public IProportioChangeTripla createProportioChangeTripla() {
        return new ProportioChangeTripla();
    }

    @Override
    public IProportioSesquialtera createProportioSesquialtera() {
        return createProportioSesquialtera();
    }

    @Override
    public IProportioTripla createProportioTripla() {
        return createProportioTripla();
    }

    @Override
    public IOctave createOctave(int number) {
        return new Octave(number);
    }


    @Override
    public ITitle createTitle(String title) {
        return new Title(title);
    }


    @Override
    public IPart createPart(IScore score, String name) {
        IPart part = new Part(name);
        score.add(part);
        return part;
    }


    @Override
    public IScore createScore() {
        return new Score();
    }

    @Override
    public ITempusImperfectumCumProlationeImperfecta createTempusImperfectumCumProlationeImperfecta() {
        return new TempusImperfectumCumProlationeImperfecta();
    }

    @Override
    public ITempusImperfectumCumProlationeImperfectaDiminutum createTempusImperfectumCumProlationeImperfectaDominitum() {
        return new TempusImperfectumCumProlationeImperfectaDiminutum();
    }

    @Override
    public ITempusImperfectumCumProlationePerfecta createTempusImperfectumCumProlationePerfecta() {
        return new TempusImperfectumCumProlationePerfecta();
    }

    @Override
    public ITempusPerfectumCumProlationeImperfecta createTempusPerfectumCumProlationeImperfecta() {
        return new TempusPerfectumCumProlationeImperfecta();
    }

    @Override
    public ITempusPerfectumCumProlationePerfecta createTempusPerfectumCumProlationePerfecta() {
        return new TempusPerfectumCumProlationePerfecta();
    }

    @Override
    public IStaff createStaff(IStaffGroup staves) {
        Staff staff = new Staff();
        staves.add(staff);
        return null;
    }

    @Override
    public IStaff createStaff(IScore score) {
        Staff staff = new Staff();
        score.add(staff);
        return staff;
    }

    @Override
    public IStaffGroup createStaffGroup(IScore score) {
        StaffGroup staffGroup = new StaffGroup();
        score.add(staffGroup);
        return staffGroup;
    }

    @Override
    public IStaffGroup createStaffGroup(IStaffGroup staffGroup) {
        StaffGroup childStaffGroup = new StaffGroup();
        staffGroup.add(childStaffGroup);
        return childStaffGroup;
    }

    @Override
    public IVoice createVoice(IPart part) {
        Voice voice = new Voice();
        part.addVoice(voice);
        return voice;
    }

}
