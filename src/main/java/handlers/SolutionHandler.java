package handlers;

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

    public SolutionHandler(List<Long> startingNumbers, List<Long> userCofficients) {

        this.startingNumbers = startingNumbers;
        this.usersCoefficients = userCofficients;
        build();
    }

    private void build() {

        generateValue();
    }

    private void generateValue() {

        firstGeneratedValues = new ArrayList<>();
        secondGeneratedValues = new ArrayList<>();

        if (usersCoefficients.size() == 0) {
            firstGenerator = new Generator(startingNumbers.get(0), Coefficient.SMALL.getCoefficient(), 1000000);
            secondGenerator = new Generator(startingNumbers.get(1), Coefficient.BIG.getCoefficient(), 1000000);
            firstGeneratedValues = firstGenerator.getListOfGeneratedValues();
            secondGeneratedValues = secondGenerator.getListOfGeneratedValues();
            System.out.println(firstGeneratedValues.size());
            System.out.println(secondGeneratedValues.size());
        } else {
            firstGenerator = new Generator(startingNumbers.get(0), usersCoefficients.get(0), 1000000);
            secondGenerator = new Generator(startingNumbers.get(1), usersCoefficients.get(1), 1000000);
            firstGeneratedValues = firstGenerator.getListOfGeneratedValues();
            secondGeneratedValues = secondGenerator.getListOfGeneratedValues();
        }
    }

}
