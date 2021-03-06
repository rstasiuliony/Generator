package handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RequirementsHandler {

    private Scanner inputReader;
    private List<Long> startingPointValues;
    private List<Long> usersCoefficientValues;
    private long tempValue;

    public RequirementsHandler() {
        build();
    }

    private void build() {

        inputReader = new Scanner(System.in);
        startingPointValues = new ArrayList<>();
        usersCoefficientValues = new ArrayList<>();

        setUserValues();
        if (hasUserOwnCoefficients()) {
            setUserCoefficients();
        }
        startSolutionCreator();
        inputReader.close();
    }

    private void setUserValues() {

        setStartingPointValue("first");
        setStartingPointValue("second");
    }

    private void setStartingPointValue(String whichValue) {

        System.out.println("Enter the " + whichValue + " value which will be a starting point to generate and compare numbers. " +
                "Only integer number is accepted.");

        if (!isInsertedValueNumber()) {
            setStartingPointValue(whichValue);
        } else {
            startingPointValues.add(tempValue);
        }
    }

    private boolean hasUserOwnCoefficients() {

        System.out.println("Values will be generated using the following coefficients: 16807 for the first value " +
                "and 48271 for the second value.\nIf you prefer to use these coefficients enter 0, " +
                "otherwise enter 1");

        if (!isInsertedValueNumber()) {
            hasUserOwnCoefficients();
        }
        if (tempValue != 0 && tempValue != 1) {
            System.out.println("Incorrect value. Try again.");
            hasUserOwnCoefficients();
        } else if (tempValue == 1) {
            return true;
        }
        return false;
    }

    private void setUserCoefficients() {

        setCoefficient("first");
        setCoefficient("second");
    }

    private void setCoefficient(String whichValue) {

        System.out.println("Insert the " + whichValue + " coefficient. Only integer can be inserted:");

        if (!isInsertedValueNumber()) { 
            setStartingPointValue(whichValue);
        } else {
            usersCoefficientValues.add(tempValue);
        }
    }

    private boolean isInsertedValueNumber() {

        try {
            tempValue = Integer.parseInt(inputReader.nextLine());
            return true;
        } catch (NumberFormatException exception) {
            System.out.println("Incorrect value, try again.");
            return false;
        }
    }

    private void startSolutionCreator() {

        SolutionHandler solutionHandler = new SolutionHandler(startingPointValues, usersCoefficientValues);
    }
}
