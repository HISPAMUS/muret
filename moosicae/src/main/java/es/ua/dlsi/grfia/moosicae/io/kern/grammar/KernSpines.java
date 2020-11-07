package es.ua.dlsi.grfia.moosicae.io.kern.grammar;

import es.ua.dlsi.grfia.moosicae.IMException;

import java.util.ArrayList;

/**
 * Used both in parsers and in kernLexer to keep track of spine types
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 05/11/2020
 */
public class KernSpines {
    private static final String SPINE_JOIN = "*v";
    private static final String SPINE_TERMINATE = "*-";
    private static final String SPINE_SPLIT = "*^";
    private static final String SPINE_ADD = "*+";
    private static final String SPINE_PLACEHOLDER = "*";
    private final boolean usedInParser;

    ArrayList<EKernHeaders> spineTypes;
    ArrayList<String> currentRecordOperators;

    public KernSpines(boolean usedInParser) {
        spineTypes = new ArrayList<>();
        this.usedInParser = usedInParser;
    }

    public boolean isUsedInParser() {
        return usedInParser;
    }

    /**
     * A new line is started
     */
    public void recordStart() {
        currentRecordOperators = null;
    }

    public void addOperator(String spineOperator) {
        if (currentRecordOperators == null) {
            currentRecordOperators = new ArrayList<>();
        }
        currentRecordOperators.add(spineOperator);
    }

    private String generateExceptionMessageFrom() {
        if (usedInParser) {
            return "[Called from parser] ";
        } else {
            return "[Called from lexer] ";
        }
    }
    /**
     * Line is ended, try to apply spine operators
     */
    public void recordEnd() throws IMException {
        if (currentRecordOperators != null) {
            boolean onlyPlaceHolder = true;
            for (String operator : currentRecordOperators) {
                if (!operator.equals(SPINE_PLACEHOLDER)) {
                    onlyPlaceHolder = false;
                    break;
                }
            }

            if (!onlyPlaceHolder) {
                if (currentRecordOperators.size() != spineTypes.size()) {
                    throw new IMException(generateExceptionMessageFrom() + "The number of operators " + currentRecordOperators.toString()
                            + " is different from the number of spines " + spineTypes.toString());
                }
                int spine = 0;
                String lastOperator = null;
                // the first spineJoin of a group is not skipped because its spine is not removed, but those that go to its right
                for (String operator : currentRecordOperators) {
                    switch (operator) {
                        case SPINE_JOIN:
                            if (lastOperator != null && lastOperator.equals(SPINE_JOIN)) {
                                spineTypes.remove(spine);
                            }
                            break;
                        case SPINE_ADD:
                        case SPINE_SPLIT:
                            spineTypes.add(spine + 1, spineTypes.get(spine));
                            spine++;
                            break;
                        case SPINE_TERMINATE:
                            spineTypes.remove(spine);
                            break;
                        case SPINE_PLACEHOLDER:
                            spine++;
                            break;
                        default:
                            throw new IMException(generateExceptionMessageFrom() + "Invalid spine operation '" + operator + "'");
                    }
                    lastOperator = operator;
                }
            } // else this was not a spine operators line
        }
        currentRecordOperators = null;
    }

    public EKernHeaders getSpineType(int index) throws IMException {
        if (index < 0 || index >= spineTypes.size()) {
            throw new IMException(generateExceptionMessageFrom() + "Invalid spine index: " + index + " for types " + spineTypes.toString());
        }
        return spineTypes.get(index);
    }


    public EKernHeaders addSpine(String text) {
        EKernHeaders type = EKernHeaders.valueOf(text.substring(2)); // remove the **
        if (type == null) {
            throw new RuntimeException(generateExceptionMessageFrom()+ "Cannot find a valid header type for '" + text + "'");
        }
        this.spineTypes.add(type);
        return type;
    }

    public int getSpineCount() {
        return this.spineTypes.size();
    }

    @Override
    public String toString() {
        return "KernSpines{" +
                "spineTypes=" + spineTypes +
                ", currentRecordOperators=" + currentRecordOperators +
                '}';
    }
}
