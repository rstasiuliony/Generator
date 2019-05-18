package handlers;

import testGenerator.Generator;
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
    private static final int TIMESTOGENERATE = 1000000;

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

}
