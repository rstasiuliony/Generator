package generator;

import java.util.ArrayList;
import java.util.List;

public class Generator implements  GeneratorInterface {

    private long startingNumber;
    private long coefficient;
    private int timesToGenerate;
    private List<Long> listOfGeneratedValues;
    private int modula;

    public Generator(long startingNumber, long coefficient, int timesToGenerate) {

        listOfGeneratedValues = new ArrayList<>();
        modula = 2147483647;
        this.startingNumber = startingNumber;
        this.coefficient = coefficient;
        this.timesToGenerate = timesToGenerate;
    }

    public List<Long> getListOfGeneratedValues() {

        int timesGenerated = 0;
        long generatedValue = 0;
        while (timesGenerated != timesToGenerate) {
            generatedValue = getGeneratedValue();
            listOfGeneratedValues.add(generatedValue);
            timesGenerated++;
        }
        return listOfGeneratedValues;
    }

    private long getGeneratedValue() {

        long result = 0;
        result = startingNumber * coefficient % modula;
        startingNumber = result;
        return result;
    }
}
