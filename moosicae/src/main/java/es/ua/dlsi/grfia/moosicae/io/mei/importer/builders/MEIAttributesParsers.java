package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.IClefBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IConventionalKeySignatureBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IModeBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefLine;
import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;
import org.apache.commons.lang3.tuple.Pair;

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

    Optional<EAccidentalSymbols> parseAccidentalSymbol(XMLImporterParam xmlImporterParam, String attrName) throws IMException {
        Optional<String> value = xmlImporterParam.getAttribute(attrName);
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
                case "x":
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

            Optional<String> clefDis = xmlImporterParam.getAttribute("clef.dis");
            Optional<String> clefDisPlace = xmlImporterParam.getAttribute("clef.dis.place");
            if (clefDis.isPresent() || clefDisPlace.isPresent()) {
                if (!clefDis.isPresent() || !clefDisPlace.isPresent()) {
                    throw new IMException("For clef octave transposition, both clef.dis and clef.dis must be present");
                }
                int octaves;
                int clefDisValue = Integer.parseInt(clefDis.get());
                switch (clefDisValue) {
                    case 8:
                        octaves = 1;
                        break;
                    case 15:
                        octaves = 2;
                        break;
                    default:
                        throw new IMException("Unsupported clef octave transposition: " + clefDisValue);
                }
                if (clefDisPlace.get().equals("below")) {
                    octaves = -octaves;
                }
                IOctaveTransposition octaveTransposition = abstractFactory.createOctaveTransposition(null, octaves);
                clefBuilder.from(octaveTransposition);
            }

            return Optional.of(clefBuilder.build());
        } else {
            return Optional.empty();
        }
    }

    public Optional<Pair<Integer, Optional<EAccidentalSymbols>>> parseConventionalKeySignatureAttribute(XMLImporterParam xmlImporterParam, String attrName) throws IMException {
        Optional<String> keySig = xmlImporterParam.getAttribute(attrName);
        if (!keySig.isPresent()) {
            return Optional.empty();
        } else {
            Integer nAccidentals;
            EAccidentalSymbols accidentalSymbol = null;
            if (keySig.get().equals("0")) {
                nAccidentals = 0;
            } else {
                if (keySig.get().length() != 2) {
                    throw new IMException("Expected 2 characters for keySig value: '" + keySig.get() + "'");
                }

                nAccidentals = Integer.parseInt(keySig.get().substring(0, 1));

                char accidental = keySig.get().charAt(1);
                if (accidental == 'f') {
                    accidentalSymbol = EAccidentalSymbols.FLAT;
                } else if (accidental == 's') {
                    accidentalSymbol =EAccidentalSymbols.SHARP;
                } else {
                    throw new IMException("Unknown accidental: '" + accidental + "'");
                }
            }
            return Optional.of(Pair.of(nAccidentals, Optional.ofNullable(accidentalSymbol)));
        }
    }

    public Optional<IConventionalKeySignature> parseConventionalKeySignature(ICoreAbstractFactory coreAbstractFactory, XMLImporterParam xmlImporterParam) throws IMException {
        Optional<Pair<Integer, Optional<EAccidentalSymbols>>> pair = parseConventionalKeySignatureAttribute(xmlImporterParam, "key.sig");
        if (pair.isPresent()) {
            IConventionalKeySignatureBuilder keyFromAccidentalCountBuilder = new IConventionalKeySignatureBuilder(coreAbstractFactory);

            int nAccidentals = pair.get().getLeft();
            keyFromAccidentalCountBuilder.from(coreAbstractFactory.createKeyAccidentalCount(null, nAccidentals));

            if (nAccidentals != 0) {
                EAccidentalSymbols eaccidentalSymbol = pair.get().getRight().get();
                IAccidentalSymbol accidentalSymbol = coreAbstractFactory.createAccidentalSymbol(null, eaccidentalSymbol);
                keyFromAccidentalCountBuilder.from(accidentalSymbol);
            }

            return Optional.of(keyFromAccidentalCountBuilder.build());
        } else {
            return Optional.empty();
        }
    }

    public Optional<IMode> parseMode(ICoreAbstractFactory coreAbstractFactory, XMLImporterParam xmlImporterParam, String attrName) throws IMException {
        Optional<String> modeString = xmlImporterParam.getAttribute(attrName);
        if (modeString.isPresent()) {
            IModeBuilder modeBuilder = new IModeBuilder(coreAbstractFactory);
            modeBuilder.from(EModes.valueOf(modeString.get().toLowerCase()));
            IMode mode = modeBuilder.build();
            return Optional.of(mode);
        } else {
            return Optional.empty();
        }
    }
    Optional<IKey> parseKey(ICoreAbstractFactory coreAbstractFactory, XMLImporterParam xmlImporterParam) throws IMException {
        Optional<IMode> optMode = parseMode(coreAbstractFactory, xmlImporterParam, "key.mode");
        if (optMode.isPresent()) {
            IMode mode = optMode.get();

            Optional<IConventionalKeySignature> conventionalKeySignature = parseConventionalKeySignature(coreAbstractFactory, xmlImporterParam);
            if (!conventionalKeySignature.isPresent()) {
                throw new IMException("If key.mode is specified, key.sig should also be present");
            }
            EAccidentalSymbols accidentalSymbol = null;
            if (conventionalKeySignature.get().getAccidentalSymbol().isPresent()) {
                accidentalSymbol = conventionalKeySignature.get().getAccidentalSymbol().get().getValue(); 
            }
            EConventionalKeys eConventionalKey = EConventionalKeys.findKeyWithAccidentalCount(mode.getValue(), conventionalKeySignature.get().getAccidentalCount().getValue(), accidentalSymbol);
            return Optional.of(coreAbstractFactory.createConventionalKey(null, eConventionalKey));
        } else {
            return Optional.empty();
        }
    }

}
