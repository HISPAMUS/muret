package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.IClefBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IConventionalKeySignatureBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IModeBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
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

    Optional<IMeter> parseMeter(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> meterSym = xmlImporterParam.getAttribute("meter.sym");
        if (meterSym.isPresent()) {
            switch (meterSym.get()) {
                case "common":
                    return Optional.of(ICoreAbstractFactory.getInstance().createCommonTime(null));
                case "cut":
                    return Optional.of(ICoreAbstractFactory.getInstance().createCutTime(null));
                default:
                    throw new IMException("Unknown meter symbol: " + meterSym.get());
            }
            //TODO mensurales
        } else {
            Optional<String> meterCount = xmlImporterParam.getAttribute("meter.count");
            Optional<String> meterUnit = xmlImporterParam.getAttribute("meter.unit");
            if (meterCount.isPresent() || meterUnit.isPresent()) {
                if (!meterCount.isPresent() || !meterUnit.isPresent()) {
                    throw new IMException("Either count or unit is missing in meter definition");
                }

                IStandardTimeSignature standardTimeSignature = ICoreAbstractFactory.getInstance().createStandardTimeSignature(null,
                        ICoreAbstractFactory.getInstance().createTimeSignatureNumerator(null, Integer.parseInt(meterCount.get())),
                        ICoreAbstractFactory.getInstance().createTimeSignatureDenominator(null, Integer.parseInt(meterUnit.get()))
                        );
                return Optional.of(standardTimeSignature);
            }
            return Optional.empty();
        }
    }

    Optional<IClef> parseClef(XMLImporterParam xmlImporterParam, boolean asAttribute) throws IMException {
        String prefix = asAttribute?"clef.":"";
        Optional<String> shape = xmlImporterParam.getAttribute(prefix + "shape");
        if (shape.isPresent()) {
            IClefBuilder clefBuilder = new IClefBuilder();
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

            Optional<String> line = xmlImporterParam.getAttribute(prefix + "line");
            if (line.isPresent()) {
                IClefLine clefLine = ICoreAbstractFactory.getInstance().createClefLine(null, Integer.parseInt(line.get()));
                clefBuilder.from(clefLine);
            }

            Optional<String> clefDis = xmlImporterParam.getAttribute(prefix + "dis");
            Optional<String> clefDisPlace = xmlImporterParam.getAttribute(prefix + "dis.place");
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
                IOctaveTransposition octaveTransposition = ICoreAbstractFactory.getInstance().createOctaveTransposition(null, octaves);
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

    public Optional<IConventionalKeySignature> parseConventionalKeySignature(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<Pair<Integer, Optional<EAccidentalSymbols>>> pair = parseConventionalKeySignatureAttribute(xmlImporterParam, "key.sig");
        if (pair.isPresent()) {
            IConventionalKeySignatureBuilder keyFromAccidentalCountBuilder = new IConventionalKeySignatureBuilder();

            int nAccidentals = pair.get().getLeft();
            keyFromAccidentalCountBuilder.from(ICoreAbstractFactory.getInstance().createKeyAccidentalCount(null, nAccidentals));

            if (nAccidentals != 0) {
                EAccidentalSymbols eaccidentalSymbol = pair.get().getRight().get();
                IAccidentalSymbol accidentalSymbol = ICoreAbstractFactory.getInstance().createAccidentalSymbol(null, eaccidentalSymbol);
                keyFromAccidentalCountBuilder.from(accidentalSymbol);
            }

            return Optional.of(keyFromAccidentalCountBuilder.build());
        } else {
            return Optional.empty();
        }
    }

    public Optional<IMode> parseMode(XMLImporterParam xmlImporterParam, String attrName) throws IMException {
        Optional<String> modeString = xmlImporterParam.getAttribute(attrName);
        if (modeString.isPresent()) {
            IModeBuilder modeBuilder = new IModeBuilder();
            modeBuilder.from(EModes.valueOf(modeString.get().toLowerCase()));
            IMode mode = modeBuilder.build();
            return Optional.of(mode);
        } else {
            return Optional.empty();
        }
    }
    Optional<IKey> parseKey(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<IMode> optMode = parseMode(xmlImporterParam, "key.mode");
        if (optMode.isPresent()) {
            IMode mode = optMode.get();

            Optional<IConventionalKeySignature> conventionalKeySignature = parseConventionalKeySignature(xmlImporterParam);
            if (!conventionalKeySignature.isPresent()) {
                throw new IMException("If key.mode is specified, key.sig should also be present");
            }
            EAccidentalSymbols accidentalSymbol = null;
            if (conventionalKeySignature.get().getAccidentalSymbol().isPresent()) {
                accidentalSymbol = conventionalKeySignature.get().getAccidentalSymbol().get().getValue(); 
            }
            EConventionalKeys eConventionalKey = EConventionalKeys.findKeyWithAccidentalCount(mode.getValue(), conventionalKeySignature.get().getAccidentalCount().getValue(), accidentalSymbol);

            Optional<String> showChange = xmlImporterParam.getAttribute("keysig.showchange");
            ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals = null;
            if (showChange.isPresent() && showChange.get().equals("true")) {
                cautionaryKeySignatureAccidentals = ICoreAbstractFactory.getInstance().createCautionaryKeySignatureAccidentals(null, true);
            }

            return Optional.of(ICoreAbstractFactory.getInstance().createConventionalKey(null, eConventionalKey, cautionaryKeySignatureAccidentals));
        } else {
            return Optional.empty();
        }
    }

    public Optional<EStemDirection> parseStem(XMLImporterParam xmlImporterParam, String attrName) throws IMException {
        Optional<String> directionString = xmlImporterParam.getAttribute(attrName);
        if (directionString.isPresent()) {
            switch (directionString.get()) {
                case "up": return Optional.of(EStemDirection.up);
                case "down": return Optional.of(EStemDirection.down);
                default: throw new IMException("Unknown stem direction: '" + directionString.get() + "'");
            }
        } else {
            return Optional.empty();
        }
    }

    public Optional<EGraceNoteType> parseGraceNoteType(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> grace = xmlImporterParam.getAttribute("grace");
        if (grace.isPresent()) {
            Optional<String> stemMod = xmlImporterParam.getAttribute("stem.mod");
            if (stemMod.isPresent()) {
                if (stemMod.equals("1slash")) {
                    return Optional.of(EGraceNoteType.acciaccatura);
                } else {
                    throw new IMException("Unsupported slash type in grace note: '" + stemMod.get() + "'");
                }
            } else {
                return Optional.of(EGraceNoteType.appoggiatura);
            }
        } else {
            return Optional.empty();
        }
    }

    public Optional<INotationType> parseNotationType(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> notationType = xmlImporterParam.getAttribute("notationtype");
        if (notationType.isPresent()) {
            switch (notationType.get()) {
                case "mensural":
                    return Optional.of(ICoreAbstractFactory.getInstance().createNotationType(null, ENotationTypes.eMensural));
                default:
                    throw new IMException("Unsupported notation type: '" + notationType.get() + "'");
            }
        }

        return Optional.empty();
    }
}
