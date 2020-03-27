package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.ICommonAlterationKey;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.builders.IClefBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IKeyFromAccidentalCountBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IModeBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefLine;
import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * It contains several parsers used in builders
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIAttributesParsers {
    private static MEIAttributesParsers instance;

    private MEIAttributesParsers() {
    }

    public static MEIAttributesParsers getInstance() {
        if (instance == null) {
            instance = new MEIAttributesParsers();
        }
        return instance;
    }

    public Optional<EFigures> parseFigure(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> dur = xmlImporterParam.getAttribute("dur");
        if (dur.isPresent()) {
            EFigures eFigure;
            switch (dur.get()) {
                case "maxima":
                    eFigure = EFigures.MAXIMA;
                    break;
                case "longa":
                    eFigure = EFigures.LONGA;
                    break;
                case "brevis":
                    eFigure = EFigures.BREVE;
                    break;
                case "semibrevis":
                    eFigure = EFigures.SEMIBREVE;
                    break;
                case "minima":
                    eFigure = EFigures.MINIM;
                    break;
                case "semiminima":
                    eFigure = EFigures.SEMIMINIM;
                    break;
                case "fusa":
                    eFigure = EFigures.FUSA;
                    break;
                case "semifusa":
                    eFigure = EFigures.SEMIFUSA;
                    break;
                case "long":
                    eFigure = EFigures.QUADRUPLE_WHOLE;
                    break;
                case "breve":
                    eFigure = EFigures.DOUBLE_WHOLE;
                    break;
                default:
                    eFigure = EFigures.findMeterUnit(Integer.parseInt(dur.get()), ENotationTypes.eModern);
            }
            return Optional.of(eFigure);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Integer> parseDots(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> dots = xmlImporterParam.getAttribute("dots");
        if (dots.isPresent()) {
            return Optional.of(Integer.parseInt(dots.get()));
        } else {
            return Optional.empty();
        }
    }

    Optional<Integer> parseOctave(XMLImporterParam xmlImporterParam) {
        Optional<String> value = xmlImporterParam.getAttribute("oct");
        if (value.isPresent()) {
            return Optional.of(Integer.parseInt(value.get()));
        } else {
            return Optional.empty();
        }
    }

    Optional<EAccidentalSymbols> parseAccidentalSymbol(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> value = xmlImporterParam.getAttribute("accid.ges");
        if (value.isPresent()) {
            EAccidentalSymbols eAccidentalSymbol;
            switch (value.get()) {
                case "fff":
                    eAccidentalSymbol = EAccidentalSymbols.TRIPLE_FLAT;
                    break;
                case "ff":
                    eAccidentalSymbol = EAccidentalSymbols.DOUBLE_FLAT;
                    break;
                case "f":
                    eAccidentalSymbol = EAccidentalSymbols.FLAT;
                    break;
                case "n":
                    eAccidentalSymbol = EAccidentalSymbols.NATURAL;
                    break;
                case "s":
                    eAccidentalSymbol = EAccidentalSymbols.SHARP;
                    break;
                case "ss":
                    eAccidentalSymbol = EAccidentalSymbols.DOUBLE_SHARP;
                    break;
                default:
                    throw new IMException("Unkown accidental symbol '" + value.get() + "'");
            }
            return Optional.of(eAccidentalSymbol);
        } else {
            return Optional.empty();
        }
        //TODO hidden, editorial...
    }

    Optional<EDiatonicPitches> parseDiatonicPitch(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> value = xmlImporterParam.getAttribute("pname");
        if (value.isPresent()) {
            EDiatonicPitches diatonicPitch = EDiatonicPitches.noteFromName(value.get().toUpperCase());
            return Optional.of(diatonicPitch);
        } else {
            return Optional.empty();
        }
        //TODO hidden, editorial...
    }

    Optional<IMeter> parseMeter(ICoreAbstractFactory abstractFactory, XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> meterSym = xmlImporterParam.getAttribute("meter.sym");
        if (meterSym.isPresent()) {
            switch (meterSym.get()) {
                case "common":
                    return Optional.of(abstractFactory.createCommonTime(null));
                case "cut":
                    return Optional.of(abstractFactory.createCutTime(null));
                default:
                    throw new IMException("Unkown meter symbol: " + meterSym.get());
            }
        } else {
            //TODO fracionales y mensurales
            return Optional.empty();
        }
    }

    Optional<IClef> parseClef(ICoreAbstractFactory abstractFactory, XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> shape = xmlImporterParam.getAttribute("clef.shape");
        if (shape.isPresent()) {
            IClefBuilder clefBuilder = new IClefBuilder(abstractFactory);
            EClefSigns clefSign;
            switch (shape.get()) {
                case "perc":
                    clefSign = EClefSigns.Percussion;
                    break;
                case "TAB":
                    clefSign = EClefSigns.TAB;
                    break;
                default:
                    clefSign = EClefSigns.valueOf(shape.get());
            }
            clefBuilder.from(clefSign);

            Optional<String> line = xmlImporterParam.getAttribute("clef.line");
            if (line.isPresent()) {
                IClefLine clefLine = abstractFactory.createClefLine(null, Integer.parseInt(line.get()));
                clefBuilder.from(clefLine);
            }
            return Optional.of(clefBuilder.build());
        } else {
            return Optional.empty();
        }
    }

    Optional<ICommonAlterationKey> parseCommonAlterationKey(ICoreAbstractFactory coreAbstractFactory, XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> keySig = xmlImporterParam.getAttribute("key.sig");
        if (keySig.isPresent()) {
            if (keySig.get().length() != 2) {
                throw new IMException("Expected 2 characters for keySig value: '" + keySig.get() + "'");
            }

            IKeyFromAccidentalCountBuilder keyFromAccidentalCountBuilder = new IKeyFromAccidentalCountBuilder(coreAbstractFactory);

            int nAccidentals = Integer.parseInt(keySig.get().substring(0, 1));
            keyFromAccidentalCountBuilder.from(coreAbstractFactory.createKeyAccidentalCount(coreAbstractFactory.createId(), nAccidentals));

            char accidental = keySig.get().charAt(1);
            IAccidentalSymbol accidentalSymbol;
            if (accidental == 'f') {
                accidentalSymbol = coreAbstractFactory.createAccidentalSymbol(coreAbstractFactory.createId(), EAccidentalSymbols.FLAT);
            } else if (accidental == 's') {
                accidentalSymbol = coreAbstractFactory.createAccidentalSymbol(coreAbstractFactory.createId(), EAccidentalSymbols.SHARP);
            } else {
                throw new IMException("Unkown accidental: '" + accidental + "'");
            }
            keyFromAccidentalCountBuilder.from(accidentalSymbol);

            Optional<String> modeString = xmlImporterParam.getAttribute("key.mode");
            if (modeString.isPresent()) {
                IModeBuilder modeBuilder = new IModeBuilder(coreAbstractFactory);
                modeBuilder.from(EModes.valueOf(modeString.get().toLowerCase()));
                IMode mode = modeBuilder.build();
                keyFromAccidentalCountBuilder.from(mode);
            }
            return Optional.of(keyFromAccidentalCountBuilder.build());
        } else {
            return Optional.empty();
        }
    }

}
