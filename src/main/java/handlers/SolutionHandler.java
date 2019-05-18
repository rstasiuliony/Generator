package handlers;

import converter.BinaryConverter;
import generator.Generator;
import handlers.enums.Coefficient;

import java.util.ArrayList;
import java.util.List;

public class SolutionHandler {

    private List<Long> startingNumbers;
    private List<Long> usersCoefficients;
    private List<Long> firstGeneratedValues;
    private List<Long> secondGeneratedValues;
    private Generator firstGenerator;
    private Generator secondGenerator;
    private int numberOfSameBinaryValues;
    private static final int TIMESTOGENERATE = 1000000;

    public SolutionHandler(List<Long> startingNumbers, List<Long> userCofficients) {

        this.startingNumbers = startingNumbers;
        this.usersCoefficients = userCofficients;
        numberOfSameBinaryValues = 0;
        build();
    }

    private void build() {

        generateValues();
        List<String> firstConvertedValues = getConvertedValuesToBinary(firstGeneratedValues);
        List<String> secondConvertedValues = getConvertedValuesToBinary(secondGeneratedValues);
        countSameBinaryValues(firstConvertedValues, secondConvertedValues);
        provideResultToUser();
    }

    private void generateValues() {

        firstGeneratedValues = new ArrayList<>();
        secondGeneratedValues = new ArrayList<>();

        if (usersCoefficients.size() == 0) {
            firstGenerator = new Generator(startingNumbers.get(0), Coefficient.SMALL.getCoefficient(), TIMESTOGENERATE);
            secondGenerator = new Generator(startingNumbers.get(1), Coefficient.BIG.getCoefficient(), TIMESTOGENERATE);
            firstGeneratedValues = firstGenerator.getListOfGeneratedValues();
            secondGeneratedValues = secondGenerator.getListOfGeneratedValues();
        } else {
            firstGenerator = new Generator(startingNumbers.get(0), usersCoefficients.get(0), TIMESTOGENERATE);
            secondGenerator = new Generator(startingNumbers.get(1), usersCoefficients.get(1), TIMESTOGENERATE);
            firstGeneratedValues = firstGenerator.getListOfGeneratedValues();
            secondGeneratedValues = secondGenerator.getListOfGeneratedValues();
        }
    }

    private List<String> getConvertedValuesToBinary(List<Long> valuesToConvert) {

        BinaryConverter binaryConverter = new BinaryConverter();
        List<String> convertedValues = new ArrayList<>();

        for (Long value : valuesToConvert) {
            convertedValues.add(binaryConverter.getConvertedValue(value));
        }
        return convertedValues;
    }

    private void countSameBinaryValues(List<String> comparableListA, List<String> comparableListB) {

        int count = 0;
        while (count != comparableListA.size()) {
            String eightSymbolsA = comparableListA.get(count);
            String eightSymbolsB = comparableListB.get(count);

            eightSymbolsA = "00000000000000000000000000000000".substring(eightSymbolsA.length()) + eightSymbolsA;
            eightSymbolsB = "00000000000000000000000000000000".substring(eightSymbolsB.length()) + eightSymbolsB;

            eightSymbolsA = eightSymbolsA.substring(eightSymbolsA.length() - 8);
            eightSymbolsB = eightSymbolsB.substring(eightSymbolsB.length() - 8);
            if (eightSymbolsA.equalsIgnoreCase(eightSymbolsB)) {
                numberOfSameBinaryValues++;
            }
            count++;
        }
    }

    private void provideResultToUser() {

        System.out.println("Last 8 bits are the same in " + numberOfSameBinaryValues + " values.");
    }
}
