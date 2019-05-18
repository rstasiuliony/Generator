package generator;

import java.util.ArrayList;
import java.util.List;

public class Generator implements  GeneratorInterface {

    private long startingNumber;
    private long coefficient;
    private int timesToGenerate;
    private List<Long> listOfGeneratedValues;

    public Generator(long startingNumber, long coefficient, int timesToGenerate) {

        this.listOfGeneratedValues = new ArrayList<>();
        this.startingNumber = startingNumber;
        this.coefficient = coefficient;
        this.timesToGenerate = timesToGenerate;
        System.out.println(this.startingNumber + " " + this.coefficient + " " + this.timesToGenerate);
    }

    public List<Long> getListOfGeneratedValues() {

        int timesGenerated = 0;
        long generatedValue = 0;
        while (timesGenerated != timesToGenerate) {
            generatedValue = getGeneratedValue();
            System.out.println("Sugeneruotas skaicius:" + generatedValue);
            listOfGeneratedValues.add(generatedValue);
            timesGenerated++;
        }
        return listOfGeneratedValues;
    }

    private long getGeneratedValue() {

        long result = 0;
        result = startingNumber * coefficient % 2147483647;
        startingNumber = result;
        return result;
    }
}
