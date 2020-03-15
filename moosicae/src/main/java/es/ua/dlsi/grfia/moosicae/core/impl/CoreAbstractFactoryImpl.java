package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.IMetronomeMark;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.enums.mensural.EMensurations;
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
    public IAlteration createAlteration(IAccidentalSymbol accidentalSymbol, Optional<IAlterationDisplayType> alterationDisplayType) {
        return new Alteration(accidentalSymbol, alterationDisplayType);
    }

    @Override
    public IBarline createBarline(Optional<Integer> barNumber, Optional<IBarlineType> barlineType) {
        return new Barline(barNumber, barlineType);
    }

    @Override
    public IChord createChord(IFigure figure, Optional<IDots> dots, IPitch[] pitches) {
        return new Chord(figure, dots, pitches);
    }

    @Override
    public IClef createClef(int line, IClefSign clefSign) {
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
    public IMetronomeMark createMetronomeMark(IFigure figure, Optional<IDots> dots, int value) {
        return new MetronomeMark(figure, dots, value);
    }

    @Override
    public IMultimeasureRest createMultimeasureRest(int measureCount) {
        return new MultimeasureRest(measureCount);
    }

    @Override
    public INote createNote(IFigure figure, Optional<IDots> dots, IPitch pitches) {
        return new Note(figure, dots, pitches);
    }


    @Override
    public IPitch createPitch(IOctave octave, Optional<IAlteration> alteration, IDiatonicPitch diatonicPitch) {
        return new Pitch(octave, alteration,  diatonicPitch);
    }

    @Override
    public IPitchClass createPitchClass(IDiatonicPitch diatonicPitch, Optional<IAccidentalSymbol> accidentalSymbol) {
        return new PitchClass(diatonicPitch, accidentalSymbol);
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
    public IRest createRest(IFigure figure, Optional<IDots> dots) {
        return new Rest(figure, dots);
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
        part.add(voice);
        return voice;
    }

    @Override
    public IBarlineType createBarlineType(EBarlineTypes barlineType) {
        return new BarlineType(barlineType);
    }

    @Override
    public IFigure createFigure(EFigures figure) {
        return new Figure(figure);
    }

    @Override
    public IAccidentalSymbol createAccidentalSymbol(EAccidentalSymbols accidentalSymbol) {
        return new AccidentalSymbol(accidentalSymbol);
    }

    @Override
    public IAlterationDisplayType createAlterationDisplayType(EAlterationDisplayTypes alterationDisplayType) {
        return new AlterationDisplayType(alterationDisplayType);
    }

    @Override
    public IClefSign createClefSign(EClefSigns clefSign) {
        return new ClefSign(clefSign);
    }

    @Override
    public IDiatonicPitch createDiatonicPitch(EDiatonicPitches diatonicPitch) {
        return new DiatonicPitch(diatonicPitch);
    }

    @Override
    public INotationType createNotationType(ENotationTypes notationType) {
        return new NotationType(notationType);
    }

    @Override
    public IMeterSymbol createMeterSymbol(EMeterSymbols meterSymbols) {
        switch (meterSymbols) {
            case commonTime:
                return new CommonTime();
            case cutTime:
                return new CutTime();
            default:
                throw new IMRuntimeException("Unknown meter symbol: " + meterSymbols);
        }
    }

    @Override
    public IMensuration createMensuration(EMensurations mensuration) {
        switch (mensuration) {
            case proportioTripla:
                return new ProportioTripla();
            case proportioChangeDupla:
                return new ProportioChangeDupla();
            case proportioChangeTripla:
                return new ProportioChangeTripla();
            case proportioSesquialtera:
                return new ProportioSesquialtera();
            case tempusImperfectumCumProlationeImperfecta:
                return new TempusImperfectumCumProlationeImperfecta();
            case tempusImperfectumCumProlationeImperfectaDiminutum:
                return new TempusImperfectumCumProlationeImperfectaDiminutum();
            case tempusImperfectumCumProlationePerfecta:
                return new TempusImperfectumCumProlationePerfecta();
            case tempusPerfectumCumProlationeImperfecta:
                return new TempusPerfectumCumProlationeImperfecta();
            case tempusPerfectumCumProlationePerfecta:
                return new TempusPerfectumCumProlationePerfecta();
            default:
                throw new IMRuntimeException("Unknown mensuration: " + mensuration);
        }
    }

}
